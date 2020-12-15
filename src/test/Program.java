package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Program {
	private static Scanner sc=new Scanner(System.in);
	private static int mainMenu() {
		System.out.println("\n\n0. Exit");
		System.out.println("1. Regsiter New Customer");
		System.out.println("2. Service Request");
		System.out.print("3. Todays Business\n\n");
		System.out.print("4. Save data to file\n");
		System.out.print("5. Load data from file\n\n");
		return sc.nextInt();
	}
	
	private static String[] getCustomerDetails() {
		String[] d= {"","",""};
		System.out.print("Enter Name     : ");
		d[0]=sc.next();
		System.out.print("Enter Address  : ");
		d[1]=sc.next();
		System.out.print("Enter Mobile   :");
		d[2]=sc.next();
		return d;
	}
	
	private static void PrintCustomerList(HashSet<Customer> c) {
		HashSet<Customer> cl=c;
		System.out.println(cl+"sshsakj");
		for (Customer cust: cl) {
			cust.toString();
		}
		
	}

	
	public static void main(String[] args) {
		
		ServiceStation s = new ServiceStation("Shubz");
		
		int ch=0;
		
		while((ch=Program.mainMenu())!=0)
		{
			try {
				
			switch (ch) {			
			case 1:
				String[] cdetail=Program.getCustomerDetails();
				s.newCustomer(cdetail[0],cdetail[1],cdetail[2]);
				break;
			case 2:
				HashSet<Customer> clist=s.getCustomerList();
				System.out.println("---------list of Customers---------");
				for(Customer c: clist)
					System.out.println(c);
				System.out.print("\n\nEnter Name : ");
				String cname=sc.next();
				Customer ncustomer= new Customer(cname);
				if (clist.contains(ncustomer))
				{	
					Iterator<Customer> itr =clist.iterator();
					while(itr.hasNext()) {
						Customer ccc=itr.next();
						if (ccc.equals(ncustomer))
						{
							ncustomer=ccc;
						}
					}
					HashMap<String ,Vehicle> hlist=ncustomer.getVehicleList();
					System.out.println("\n----- vehicles list-----");
					Program.printVehicles(hlist);
					Program.addVehicle(ncustomer);
					hlist=ncustomer.getVehicleList();
					System.out.println("\n----- vehicles list-----");
					Program.printVehicles(hlist);
					System.out.print("\n\nEnter Vehicle number : ");
					String vnum=String.valueOf(sc.next());
					System.out.println(vnum);
					if (hlist.containsKey(vnum))
					{
						s.handleServiceRequest(ncustomer.getName(),vnum);
					}
					else
						System.out.println("Vehicle nt found ");
				}
				else
				System.out.println("Customer Not Found");
				
				
				break;
			case 3:
				s.business();
				break;
			case 4:
				s.writeRecordCustomers();
			case 5:
				s.readRecordCustomers();
			case 0:
				break;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	}

	private static void printVehicles(HashMap<String, Vehicle> hlist) {
		if (hlist!=null)
		{
			Iterator itr=hlist.entrySet().iterator();
			while(itr.hasNext()) {
				Map.Entry<String, Vehicle> set =(Map.Entry<String, Vehicle>)itr.next();
				System.out.println(set.getValue());
			}
		}
		
	}

	private static int vehicleAddMenu() {
		System.out.println("\n0. Exit, use old vehicle");
		System.out.println("1. Add new Vehicle");
		return sc.nextInt();
	}
		
	private static void addVehicle(Customer ncustomer) {
		int ch;
		while((ch=Program.vehicleAddMenu())!=0)
		{
			switch(ch) {
			case 1:
				System.out.print("Model   :");
				String model=sc.next();
				System.out.print("Company :");
				String company=sc.next();
				System.out.print("Number  :");
				String number=String.valueOf(sc.next());
				ncustomer.newVehicle(company, model, number);
				break;
								
			}
		}
	}
		

	

	
}

            
 