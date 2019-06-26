package bigramParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	File file;
	ArrayList<String> words;

	public Input() {
		
	}
	
	public Input(String address) throws FileNotFoundException {
		words = new ArrayList<String>();
		file = new File(address);
		System.out.println("File exists:" + file.exists());
		if (file.exists()) {
			System.out.println("File location:" + file.getAbsolutePath());
		}
		try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] cluster = line.split(" ");
                for (int i=0;i<cluster.length;i++) {
                	words.add(cluster[i]);
                	}
            	}
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public ArrayList<String> getWords() {
		return words;
	}
	
	public ArrayList<String> filteredList (ArrayList<String> parseList) {
		ArrayList<String> words = new ArrayList<String>();
		String currentString;
		
		while (!parseList.isEmpty()) {
			currentString = parseList.get(0);
			currentString = currentString.toLowerCase();
			currentString = currentString.replaceAll("[^a-zA-Z1-9 ]", "");
			if (!currentString.equals("")) words.add(currentString);
			parseList.remove(0);
		}
		return words;
	}
	
	public ArrayList<Bigram> gramifiedList(ArrayList<String> filteredList) {
		ArrayList<Bigram> grams = new ArrayList<Bigram>();
		String str1;
		String str2;
		while (filteredList.size()>1) {
			str1 = filteredList.get(0);
			str2 = filteredList.get(1);
			grams.add(new Bigram(str1,str2));
			filteredList.remove(0);
		}
		return grams;
	}	
	
}
