package LiaYang.LiaYangAssignment;

public class LaiYangException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public LaiYangException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}
