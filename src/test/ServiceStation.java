package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ServiceStation {
	
	private String name;
	LinkedList<Bill> billList=new LinkedList<>();
	HashSet<Customer> customerList=new HashSet<>();
	
	
	
	public ServiceStation(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LinkedList<Bill> getBillList() {
		return billList;
	}
	
	public HashSet<Customer> getCustomerList() {
		if (customerList!=null)
		return customerList;
		return null;
	}
	
	void newCustomer(String name,String address,String mobile)
	{	
		Customer c= new Customer(name,address,mobile);
		customerList.add(c);
		
	}
	
	void handleServiceRequest(String name,String vnumber)
	{		
		ServiceRequest sq= new ServiceRequest(name,vnumber);
		Bill b=sq.processRequest();
		billList.add(b);
		
	}
	
	void business()
	{
		if (billList!=null)
		{
			double today = 0;
			for (Bill b:billList) {
				today+=b.getAmount();}
			System.out.println("Total Business  : "+today);
		}
	}
	
	public static final String pathCustomer = "customers.db";
	public void writeRecordCustomers( ) throws Exception{
		try( ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(pathCustomer))))){
			outputStream.writeObject(this.customerList);
		}
	}
	public void readRecordCustomers( ) throws Exception{
		try( ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(pathCustomer))))){
			this.customerList = (HashSet<Customer>) inputStream.readObject();
		}
	}
	
	
}

            
 