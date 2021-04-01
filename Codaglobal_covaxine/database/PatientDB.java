package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PatientDB {

	private final static String viewSlot="SELECT * FROM `doctor_details`";
	private final static String acceptPatient="INSERT INTO `patient_details`(`patient_name`, `problems`, `from_slot`, `to_slot`, `status`) VALUES (?,?,?,?)";
	private final static String bookedSlot="SELECT from_slot , to_slot FROM `doctor_details` where patient_name = ?";
	private final static String deleteSlot="DELETE FROM `patient_details` WHERE patient_name = ?";
	private final static String updateSlot="UPDATE `patient_details` SET `from_slot`=?,`to_slot`=? WHERE patient_name = ?";
	
	public ArrayList<ArrayList<String>> viewSlot()
	{
		ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(viewSlot);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ArrayList<String> temp=new ArrayList<String>();
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				temp.add(rs.getString(5));
				res.add(temp);
			}
		}
		catch(Exception e)
		{
			
		}
		return res;
	}
	
	public void bookSLot(String from,String to,String name)
	{
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(acceptPatient);
			pstmt.setString(1,from);
			pstmt.setString(2, to);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public ArrayList<ArrayList<String>> bookedSlot(String name)
	{
		ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(bookedSlot);
			pstmt.setString(1, name);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ArrayList<String> temp=new ArrayList<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				res.add(temp);
			}
		}
		catch(Exception e)
		{
			
		}
		return res;
	}
	
	public void deleteSlot(String name)
	{
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(deleteSlot);
			
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void UpdateSlot(String from,String to,String name)
	{
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(updateSlot);
			pstmt.setString(1, from);
			pstmt.setNString(2, to);
			pstmt.setString(3,name);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
	}
}
