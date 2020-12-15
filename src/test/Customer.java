package test;

import java.io.Serializable;
import java.util.HashMap;

public class Customer implements Serializable{
	
	private  String address,mobile,name;
	HashMap<String,Vehicle> vehicleList = new HashMap<>();
	
	void displayVehicles(){
		
		if (vehicleList!=null)

		{
			//for (HashMap<Vehicle,Customer> v: vehicleList)
		}
		
	}
	
	
	void newVehicle(String string, String string2, String string3)
	{
		Vehicle v = new Vehicle(string,string2,string3);
		
		vehicleList.put(v.getNumber(), v);
	}

	public Customer(String name, String address, String mobile) {
		this.address = address;
		this.mobile = mobile;
		this.name = name;
	}
	public Customer(String cname) {
		this.address = "";
		this.mobile = "";
		this.name = cname;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Vehicle> getVehicleList() {
	
		return vehicleList;

	}

	public void payBill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return name+" "+address+" "+mobile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}

            
 