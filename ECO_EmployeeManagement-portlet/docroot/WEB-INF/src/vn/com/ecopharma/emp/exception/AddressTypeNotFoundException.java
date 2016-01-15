package vn.com.ecopharma.emp.exception;

public class AddressTypeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddressTypeNotFoundException(String message) {
		super(message);
	}

	public AddressTypeNotFoundException() {
		super("Exception caused by address type not found");
	}
}
