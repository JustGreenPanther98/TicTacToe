public class InvalidInputOXException extends Exception{
	@Override
	public String getMessage() {
		return "Number is not in range";
	}
	@Override
	public String toString() {
		return "Invalid Input!";
	}
}