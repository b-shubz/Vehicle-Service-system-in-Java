package test;

import java.io.Serializable;

public class Part {
	
	private String desc;
	private double rate;

	public Part() {
		this.desc = "";
		this.rate = 0;
	}

	public Part(String desc, double rate) {
		this.desc = desc;
		this.rate = rate;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}

            
 