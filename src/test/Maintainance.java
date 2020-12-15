package test;

import java.io.Serializable;
import java.util.LinkedList;

public class Maintainance extends Service{
	
	private double labourCharges;
	LinkedList<Part> partList = new LinkedList<>();
	
	
	public Maintainance() {
		this.labourCharges = 0;
	}

	public Maintainance(double labourCharges) {
		this.labourCharges = labourCharges;
	}
	
	public double getLabourCharges() {
		return labourCharges;
	}

	public void setLabourCharges(double labourCharges) {
		this.labourCharges = labourCharges;
	}

	void addPart(String desc,double rate)
	{
		Part p= new Part(desc,rate);
		partList.add(p);
	}
	
	double price()
	{	double partsPrice=labourCharges;
		if (partList!=null)
		{
			for (Part p: partList) {
				partsPrice+=p.getRate();
			}
		}
		return partsPrice;
	}
	
	void display()
	{
		if (partList!=null)
		{
			for (Part p: partList) {
				System.out.println("Part           : "+p.getRate()+"   -"+p.getDesc());
		
				                    
			}
		}
	}
}

            
 