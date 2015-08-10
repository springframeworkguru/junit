package guru.springframework.unittest.mockito;

public class InsufficientProductsException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message = null;
	public InsufficientProductsException() { super(); }
	public InsufficientProductsException(String message) {
		super(message);
		this.message = message;
	}
	public InsufficientProductsException(Throwable cause)
	{
		super(cause);
	}
	@Override
	public String toString() {
		return message;
	}
}
