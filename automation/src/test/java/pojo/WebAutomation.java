package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebAutomation {
	@JsonProperty
	private String courseTitle; 
	@JsonProperty
	private String price;
	
	
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
