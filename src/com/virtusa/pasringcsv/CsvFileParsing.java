package com.virtusa.pasringcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author PrasadGanta
 * Class which ask for the file name and Designation to search in file to display the record
 *
 */
public class CsvFileParsing {

	public static void main(String[] args) {

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter File Name (Example:employeeData.csv )");
			String filename = sc.next();
			System.out.println("Please enter the Desgination (TL/PM/AR/SE) to display the employee details");
			String desgination = sc.next();
			br = new BufferedReader(new FileReader("./src/cvsfile/" + filename));
			while ((line = br.readLine()) != null) {

				String[] lineArray = line.split(cvsSplitBy);
				if (lineArray[2].contains(desgination) || line.startsWith("EmpId")) {

					System.out.println(line);
				}

			}

		} catch (Exception e) {
			System.out.println("Please check the file path and name properly and try once again !!");

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}