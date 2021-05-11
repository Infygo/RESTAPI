package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	@JsonProperty
	private double lat;
	@JsonProperty
	private double lng;
	
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	

}
