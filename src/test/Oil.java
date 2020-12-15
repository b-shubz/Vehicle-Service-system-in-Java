package test;

import java.io.Serializable;

public class Oil extends Service {
	private  double cost;
	
	public Oil() {
		this.cost=0;
		
	}
	
	public Oil(double cost) {
		this.cost=cost;
		
	}


	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	double price()
	{
		return cost;
	}
	
	void display()
	{
		System.out.println("Oil Cost       : "+this.cost+"\n");
		            
	}


}

            
 