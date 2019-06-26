package bigramParser;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		String address="";
		//to test code from IDE, you can edit address of text file here.
		//address="./src/TestFiles/TestA.txt";
		//address="";
		if (args.length==0 && address.equals("")) {
			System.out.println(
				"Please indicate which test file you would like to use from the local folder.");
			System.out.println(
					"\nFor example: You may use TestA.txt TestB.txt or TestC.txt");	
			System.out.println(
					"\nYou may also use the argument of this application to assert a file location be it local or otherwise.");	
			Scanner scanner = new Scanner(System.in);
			String[] bits = scanner.next().split(" ");
			address = bits[0];
			scanner.close();	
		}
		else if (args.length>0){
			address = args[0];
		}

		Histogram histo = new Histogram(new Input(address));
		histo.printout();
	}

}
