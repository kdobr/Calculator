package exeption;

public class CalcWrongDataExeption extends RuntimeException {

	public CalcWrongDataExeption(String message) {
		super(message+". Try again.");
	}	
}
