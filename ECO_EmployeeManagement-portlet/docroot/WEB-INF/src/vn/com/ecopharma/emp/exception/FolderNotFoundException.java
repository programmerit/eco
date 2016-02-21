package vn.com.ecopharma.emp.exception;

public class FolderNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FolderNotFoundException() {
		super("Exception caused by given directory not found.");
	}

	public FolderNotFoundException(String message) {
		super(message);
	}

}
