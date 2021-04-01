package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.DoctorDetails;

public class AdminDB {

	private final static String insertSlot="INSERT INTO `doctor_details`(`doctor_id`, `doctor_name`, `specializtion`, `from_slot`, `to_slot`) VALUES (?,?,?,?,?)";
	private final static String viewPatient="SELECT patient_id,patient_name , problems FROM `patient_details` WHERE from_slot=? and to_slot=?";
	private final static String acceptPatient="Update patient_details set status='accepted' WHERE from_slot=? and to_slot=? and patient_id=?";
	
	public void storeSlot(DoctorDetails obj)
	{
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(insertSlot);
			pstmt.setInt(1, obj.getDoctor_id());
			pstmt.setString(2,obj.getDoctor_name());
			pstmt.setString(3, obj.getSpecialization());
			pstmt.setString(4, obj.getFrom_slot());
			pstmt.setString(5, obj.getTo_slot());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("storeSlot : "+e);
		}
	}
	
	public ArrayList<ArrayList<String>> viewPatient(String fromSlot,String toSlot)
	{
		ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(viewPatient);
			pstmt.setString(1,fromSlot);
			pstmt.setString(2, toSlot);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ArrayList<String> temp=new ArrayList<String>();
				temp.add(String.valueOf(rs.getInt(1)));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				res.add(temp);
			}
		}
		catch(Exception e)
		{
			System.out.println("viewPatient : "+e);
		}
		return res;
	}
	
	public void acceptPatient(ArrayList<Integer> id,String fromSlot,String toSlot)
	{
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(acceptPatient);
			for(Integer i:id)
			{
				pstmt.setString(1,fromSlot);
				pstmt.setString(2, toSlot);
				pstmt.setInt(3, i);
				pstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("acceptPatient : "+e);
		}
	}
	
}
