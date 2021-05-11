package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddPlace {
	@JsonProperty
	private int accuracy;
	@JsonProperty
	private String name; 
	@JsonProperty
	private String phone_number;
	@JsonProperty
	private String address;
	@JsonProperty
	private String website;
	@JsonProperty
	private String language;
	@JsonProperty
	private Location location; // nested elements 
	@JsonProperty
	private List<String> types; // returns one list of string  elements 
	 
	
	
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	
	
	

}
