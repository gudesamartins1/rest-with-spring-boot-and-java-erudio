package br.gustavo.exceptions;

import java.io.Serializable;
import java.sql.Date;

public class ExceptionsResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date timestamp;
	private String message;
	private String details;
	public ExceptionsResponse(Date timestamp, String message, String details) {
		
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
	
	

}
