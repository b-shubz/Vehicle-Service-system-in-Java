package test;

import java.io.Serializable;

public class Bill  implements Serializable{
	
	private double amount, paidAmount;
	ServiceRequest sr=null;
	
	public Bill(ServiceRequest serviceRequest) {
		sr=serviceRequest;
	}
	
	
	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public double getPaidAmount() {
		return paidAmount;
	}


	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}


	void computeAmount()
	{
		if (sr.serviceList!=null) {
		for (Service s:sr.serviceList)
		{
			if (s instanceof Maintainance)
			{
				Maintainance m =(Maintainance) s;
				m.display();
				System.out.println("\nLabour Charges : "+m.getLabourCharges());
				amount+=m.price();
			}
			if (s instanceof Oil)
			{
				Oil o = (Oil) s;
				o.display();
				amount+=o.price();
			}
		}
		
 	}
	}
	void computeTax() {
		double tax=(amount*12.6)/100;
		System.out.println("-------------------------------");
		System.out.println("\nTotal Amount   : "+String.format("%.2f", this.amount));
		System.out.println("Tax on Total   : "+String.format("%.2f", tax));
		  
				
		this.amount+=tax;
		System.out.println("Total (tax inc): "+String.format("%.2f", this.amount));
		
	}
	
	

	
}

            
 