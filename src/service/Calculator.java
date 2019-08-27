package service;

import model.Add;
import model.Divide;
import model.ICalc;
import model.Multy;
import model.Subtract;

public class Calculator {

	public static int calculate(int num1, char oper, int num2) throws Exception {

		Class<?> calcClass = null;

		if (oper == '+') {
			calcClass = Class.forName(Add.class.getName());
		}
		if (oper == '-') {
			calcClass = Class.forName(Subtract.class.getName());
		}

		if (oper == '*') {
			calcClass = Class.forName(Multy.class.getName());
		}
		if (oper == '/') {
			calcClass = Class.forName(Divide.class.getName());
		}

		ICalc iCalc = (ICalc) calcClass.newInstance();

		int result = iCalc.calc(num1, num2);

		System.out.println(Convertor.romNum ? Convertor.toRoman(result) : result);
		return result;
	}

}
