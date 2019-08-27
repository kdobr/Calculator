package service;

import java.util.TreeMap;

import exeption.CalcWrongDataExeption;

public class Convertor {
	
	private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
	static boolean romNum = false;

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }
    
    public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        
        if ( number == l ) { return map.get(number);}
            
        return map.get(l) + toRoman(number-l);
        }
	
		
	public static int convertToArab(String number) throws CalcWrongDataExeption {
		romNum = true;
		if (number.isEmpty()) return 0;
	        if (number.startsWith("M")) return 1000 + convertToArab(number.substring(1));
	        if (number.startsWith("D")) return 500 + convertToArab(number.substring(1));
	        if (number.startsWith("CD")) return 400 + convertToArab(number.substring(2));
	        if (number.startsWith("C")) return 100 + convertToArab(number.substring(1));
	        if (number.startsWith("XC")) return 90 + convertToArab(number.substring(2));
	        if (number.startsWith("CM")) return 900 + convertToArab(number.substring(2));
	        if (number.startsWith("L")) return 50 + convertToArab(number.substring(1));
	        if (number.startsWith("XL")) return 40 + convertToArab(number.substring(2));
	        if (number.startsWith("X")) return 10 + convertToArab(number.substring(1));
	        if (number.startsWith("IX")) return 9 + convertToArab(number.substring(2));
	        if (number.startsWith("V")) return 5 + convertToArab(number.substring(1));
	        if (number.startsWith("IV")) return 4 + convertToArab(number.substring(2));
	        if (number.startsWith("I")) return 1 + convertToArab(number.substring(1));
	        throw new CalcWrongDataExeption("you inserted not correct number");
	}
	
	

}
