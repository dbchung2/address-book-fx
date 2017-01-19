package ch.makery.address.model;

import java.util.*;
public class Person {
	private String firstName;
    private String lastName;
    private String street;
    private int postalCode;
    private String city;
    private Calendar birthday;
    


	public  Person(){
    	;
    }
    
    public  Person(String firstName , String lastName ){
    	
    	this.firstName = firstName;
    	this.lastName = lastName;
    	//default
    	this.street = "none";
    	this.postalCode = 0;
    	this.city = "Choose a City";
    	this.birthday = Calendar.getInstance();
    }
    // getter and setter for all field 
    
    public String getFirstName(){
    	return this.firstName;
    }
    public void setFirstName(String firstName){
    	this.firstName = firstName;
    }
    
    public String getLastName(){
    	return this.lastName;
    }
    
    public void setLastName(String lastName){
    	this.lastName = lastName;
    }
    
    public String getStreet(){
    	return this.street;
    }
    
    public void setStreet(String street){
    	this.street = street ;
    }
    
    public int getPostalCode(){
    	return this.postalCode;
    }
    
    public void setPostalCode(int postalcode){
    	this.postalCode = postalcode;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public Calendar getBirthday(){
    	return this.birthday;
    }
    
    public void setBirthday(Calendar birthday){
    	this.birthday = birthday;
    }
}
