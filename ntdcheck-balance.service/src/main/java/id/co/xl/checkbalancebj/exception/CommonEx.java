package id.co.xl.checkbalancebj.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonEx extends Exception {
	
	private String status;
	private String message;
	private String exceptionCode;
	private String exceptionName;
	
	/*public CommonEx(String status, String message) {
		super(message);
		this.status = status;
		this.message = message;
		this.exceptionCode = message;
	}
	
	public CommonEx(String status, String message, String exceptionCode) {
		super(message);
		this.status = status;
		this.message = message;
		this.exceptionCode = exceptionCode;
	}
	
	public CommonEx(String status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
		this.message = message;
		this.exceptionCode = message;
	}*/
	
	public CommonEx(String status, String message, String exceptionCode, Throwable cause) {
		super(message, cause);
		this.status = status;
		this.message = message;
		this.exceptionCode = exceptionCode;
	}

	public CommonEx(String status, String message, String exceptionCode, String exceptionName, Throwable cause) {
		super(message, cause);
		this.status = status;
		this.message = message;
		this.exceptionCode = exceptionCode;
		this.exceptionName = exceptionName;
	}

	public CommonEx(String status, String message, String exceptionCode, String exceptionName) {
		super(message);
		this.status = status;
		this.message = message;
		this.exceptionCode = exceptionCode;
		this.exceptionName = exceptionName;
	}

}
