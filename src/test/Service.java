package test;

import java.io.Serializable;

public class Service{
	
	protected String desc;
	
	public Service() {
		this.desc = "";
	}
	public Service(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	double price() {
		return 0;
	}
	
}

            
 