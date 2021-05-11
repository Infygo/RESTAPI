package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCourses {
	
	// variables for the json fields 
	@JsonProperty
	private String url;
	@JsonProperty
	private Courses courses; // return type is a class instead of String 
	@JsonProperty
	private String services;
	@JsonProperty
	private String expertise;
	@JsonProperty
	private String linkedIn;
	@JsonProperty
	private String instructor;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getLinkedin() {
		return linkedIn;
	}
	public void setLinkedin(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

}
