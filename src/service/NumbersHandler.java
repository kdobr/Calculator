package service;

import exeption.CalcWrongDataExeption;

public class NumbersHandler {
	
	private static char oper;
	
	public static int[] handleNumbers (String[] arr) {
		
		int num1Rom, num2Rom;
		num1Rom = num2Rom = 0;

		if (arr[0].length() > 1) {
			num1Rom = Convertor.convertToArab((arr[0]).toUpperCase());
		} else {
			char num1 = arr[0].charAt(0);
			if (num1 < 48 || num1 > 57) {
				num1Rom = Convertor.convertToArab(("" + num1).toUpperCase());
			}
		}
		oper = arr[1].charAt(0);
		if (oper != 42 && oper != 43 && oper != 45 && oper != 47) {
			
			throw new CalcWrongDataExeption("not correct operator. Only '+', '-', '*', '/' possible");
		}
		if (arr[2].length() > 1) {
			num2Rom = Convertor.convertToArab(arr[2].toUpperCase());
		} else {
			char num2 = arr[2].charAt(0);
			if (num2 < 48 || num2 > 57) {
				num2Rom = Convertor.convertToArab(("" + num2).toUpperCase());
			}
		}
		if ((num1Rom == 0) ^ (num2Rom == 0)) {

			throw new CalcWrongDataExeption("you inserted Arab and Roman number together");
		}
		if ((num1Rom > 9) || (num2Rom > 9)) {
			
			throw new CalcWrongDataExeption("you inserted Roman number more then 9");
		}
		num1Rom = num1Rom != 0 ? num1Rom : Integer.parseInt(arr[0]);
		num2Rom = num2Rom != 0 ? num2Rom : Integer.parseInt(arr[2]);
		
		return new int[] {num1Rom, num2Rom};
		
	}
	
	public static char getOper() {
		return oper;
		
	}

}
