package com.virtusa.numbertoword;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author PrasadGanta
 * The class which takes the integer number and converts that into words
 *
 */
public class NumberToWord  

{
    private static final String[] specialNames = {
        "",
        " thousand",
        " million",
        " billion",
        " trillion",
        " quadrillion",
        " quintillion"
    };
    
    private static final String[] tensNames = {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };
    
    private static final String[] numNames = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };
    
    /**
     * @param number
     * @return  String based on the number position will return a block statement 
     */
    private String convertLessThanOneThousand(int number) {
        String current;
        
        if (number % 100 < 20){
            current = numNames[number % 100];
            number /= 100;
        }
        else {
            current = numNames[number % 10];
            number /= 10;
            
            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames[number] + " hundred and" + current;
    }
    

    /**
     * @param number
     * @return String
     * 
     *  Takes the number check's the number positive or not accrodingly sets prefix
     *  Module the number by 1000 to take the last 3 digits of your number calculate the place and current position
     *  it will keep loops till the number is less than or equal to 0
     */
    public String convert(int number) {

        if (number == 0) { return "zero"; }
        
        String prefix = "";
        
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }
        
        String current = "";
        int place = 0;
        
        do {
            int n = number % 1000;
            if (n != 0){
                String s = convertLessThanOneThousand(n);
                current = s + specialNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);
        
        return (prefix + current).trim();
    }
    
	public static void main(String[] args) {
    	
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Please Enter Integer number");
    	try {
    		int number=sc.nextInt();
    	   NumberToWord obj = new NumberToWord();
           System.out.println(obj.convert(number));
    	}catch(InputMismatchException ex) {
    		System.out.println("Please make sure about your entry should be Number and it should not be more than 999999999");
    	}
     
       
    }
}
