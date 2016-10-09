package us.brianolsen.spring.model;

public class Address {
	private String street;
	private int postcode;
	
	public Address(){
		
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public Address(String street, int postcode) {
		super();
		this.street = street;
		this.postcode = postcode;
	}
	
	public void init(){
		//System.out.println("BeanCreated: " + this);
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode + "]";
	}

}
