package com.sb.EmployeeProject.bo;

public class GenericAPIResponse {
	
	private String status;
	
	private String reason;
	
	public GenericAPIResponse(){
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

}
