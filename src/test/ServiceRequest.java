package test;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class ServiceRequest{
	private Scanner sc =new  Scanner(System.in);
	private String customerName,vehicleNumber;
	LinkedList<Service> serviceList = new  LinkedList<>();
	
	public ServiceRequest(String customerName, String vehicleNumber) {
		this.customerName = customerName;
		this.vehicleNumber = vehicleNumber;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	public Bill processRequest()
	{
		int ch=0;
		System.out.println("\n1. Oil Change \n2. Maintainane \n0. Exit ");
		ch=sc.nextInt();
		while(ch==1 || ch==2)
		{	
			if (ch==1) {
			Oil s = new Oil();
				System.out.print("Enter oil name : ");
				String name=sc.next();
				System.out.print("Enter Cost     : ");
				s.setCost(sc.nextDouble());
				serviceList.add(s);
			}
			else if (ch==2) {
				Maintainance s=new Maintainance();
				System.out.println("\n\n1. Add Parts \n2.Normal Service ");
				int ch2=0;
				ch2=sc.nextInt();
				while(ch2==1) {
					
					System.out.print("Part Name  : ");
					String desc=sc.next();
					System.out.print("Rate       : ");
					double rate=sc.nextDouble();
					s.addPart(desc,rate);
					System.out.println("\n\n1. Add more Parts \n0. Exit");
					ch2=sc.nextInt();
				}
				
				System.out.print("Enter Labour Charges : ");
				s.setLabourCharges(sc.nextDouble());
			
				serviceList.add(s);
			}
			
			System.out.println("\n\n1. Oil Change \n2. Maintainane \n0. Exit \n\n");
			ch=sc.nextInt();
			
			if(ch!=1 && ch!=2) {
			Bill b = new Bill(this);
			System.out.println("------------------------------");
			b.computeAmount();
			b.computeTax();                     
			
			System.out.print("\nEnter Payment  : ");								
			double pay=sc.nextDouble();
			System.out.println("---------------------------------");
			b.setPaidAmount(pay);
			return b;
			}
		}
		return null;
	}
	
	
}

            
 