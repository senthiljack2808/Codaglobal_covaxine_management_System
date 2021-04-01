package patient;

import java.util.ArrayList;
import java.util.Scanner;

import admin.AdminDashboard;
import database.PatientDB;

public class PatientDashboard {

	public void applySlot()
	{
		PatientDB obj=new PatientDB();
		Scanner in=new Scanner(System.in);
		ArrayList<ArrayList<String>> res=obj.viewSlot();
		for(ArrayList<String> i:res)
		{
			System.out.println("Doctor Name : "+i.get(0));
			System.out.println("Doctor Specialization : "+i.get(1));
			System.out.println("SLot : "+i.get(2)+"-"+i.get(3));
		}
		System.out.println("Enter the Starting time of slot : ");
		String from_slot=in.nextLine();
		System.out.println("Enter the Ending time of slot : ");
		String to_slot=in.nextLine();
		System.out.println("Enter the name");
		String name=in.next();
		obj.bookSLot(from_slot, to_slot,name);
	}
	
	public void viewSLot()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the patient Name : ");
		String s=in.nextLine();
		PatientDB obj=new PatientDB();
		ArrayList<ArrayList<String>> res=obj.bookedSlot(s);
		for(ArrayList<String> i:res)
		{
			System.out.println("SLot : "+i.get(0)+"-"+i.get(1));
		}
	}
	
	public void deleteSlot()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the patient Name : ");
		String s=in.nextLine();
		PatientDB obj=new PatientDB();
		obj.deleteSlot(s);
	}
	
	public void updateSlot()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the patient Name : ");
		String s=in.nextLine();
		System.out.println("Enter the New Starting time of slot : ");
		String from_slot=in.nextLine();
		System.out.println("Enter the New Ending time of slot : ");
		String to_slot=in.nextLine();
		PatientDB obj=new PatientDB();
		obj.UpdateSlot(from_slot, to_slot, s);
	}
	
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		PatientDashboard obj=new PatientDashboard();
		System.out.println("------Welcome to Patient Dashboard------");
		System.out.println("\n\n");
		
		System.out.println("Press 1 to view and apply booking Slot");
		System.out.println("Press 2 to applied slot");
		System.out.println("Press 3 to Change the slot");
		System.out.println("Press 4 to cancel the slot");
		
		int choice=in.nextInt();
		if(choice==1)
		{
		   obj.applySlot();	
		}
		else if(choice==2)
		{
			obj.viewSLot();
		}
		else if(choice==3)
		{
			obj.updateSlot();
		}
		else if(choice==4)
		{
			obj.deleteSlot();
		}
	}

}
