package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Courses {
	// Nested json field course - for which we have created a dedicated pojo class
	// watch out the return types 
	@JsonProperty
	private List<WebAutomation> webAutomation;
	@JsonProperty
	private List<Api> api; 
	@JsonProperty
	private List<Mobile> mobile;
	
	
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	

}
