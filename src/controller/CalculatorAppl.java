package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import exeption.CalcWrongDataExeption;
import service.Calculator;
import service.Convertor;
import service.NumbersHandler;

public class CalculatorAppl {

	public static void main(String[] args) throws Exception {

		System.out.println("pls insert two Arab integer in range 0-9 or two Roman numbers in rage I-IX \n"
				+ "and one of operator sign ('+', '-', '*', '/') in follow format: \n5 + 3   or   V * III");

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			String[] stringArr = br.readLine().split("\\s");
			int[] numAarr  = NumbersHandler.handleNumbers(stringArr);

			Calculator.calculate(numAarr[0], NumbersHandler.getOper(), numAarr[1]);

		} catch (CalcWrongDataExeption e) {
			System.err.println(e.getMessage());
			return;
		}
	}
}
