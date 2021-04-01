package admin;

import java.util.ArrayList;
import java.util.Scanner;

import database.AdminDB;

public class AdminDashboard {

	
	public DoctorDetails bookSlot()
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the Doctor ID : ");
		int doctor_id=in.nextInt();
		in.nextLine();
		System.out.print("Enter the Doctor Name : ");
		String doctor_name=in.nextLine();
		System.out.println("Enter the Doctor's Specialization : ");
		String specialization = in.nextLine();
		System.out.println("Enter the Starting time of slot : ");
		String from_slot=in.nextLine();
		System.out.println("Enter the Ending time of slot : ");
		String to_slot=in.nextLine();
		
		DoctorDetails obj=new DoctorDetails(doctor_id, doctor_name, specialization, from_slot, to_slot);
		return obj;
	}
	
	
	public void viewPatients()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the Starting time of slot : ");
		String from_slot=in.nextLine();
		System.out.println("Enter the Ending time of slot : ");
		String to_slot=in.nextLine();
		AdminDB obj=new AdminDB();
		ArrayList<ArrayList<String>> res=obj.viewPatient(from_slot, to_slot);
		ArrayList<Integer> id=new ArrayList<>();
		for(ArrayList<String> i:res)
		{
			System.out.println("Patient Name : "+i.get(1));
			System.out.println("Patient Problems : "+i.get(2));
			System.out.println("Press 1 to accept and 0 to reject");
			int ch=in.nextInt();
			id.add(ch);
		}
		obj.acceptPatient(id, from_slot, to_slot);
	}
	
	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);
		AdminDashboard obj=new AdminDashboard();
		System.out.println("------Welcome to Admin Dashboard------");
		System.out.println("\n\n");
		
		System.out.println("Press 1 to create booking panels");
		System.out.println("Press 2 to see patients list");
		
		int choice=in.nextInt();
		if(choice==1)
		{
			DoctorDetails obj1=obj.bookSlot();
			AdminDB obj2=new AdminDB();
			obj2.storeSlot(obj1);
		}
		else if(choice==2)
		{
			obj.viewPatients();
		}
	}

}
