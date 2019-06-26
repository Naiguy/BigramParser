package bigramParser;

import java.util.ArrayList;

public class Histogram {
	ArrayList<Bigram> uniqueBigrams = new ArrayList<Bigram>();
	ArrayList<Integer> occurences = new ArrayList<Integer>();
	
	public Histogram (ArrayList<Bigram> grams) {
		for (int i=0;i<grams.size();i++) {
			this.add(grams.get(i));
		}
	}
	
	public Histogram (Input input) {
		ArrayList<String> filteredList = input.filteredList(input.getWords());
		ArrayList<Bigram> grams = input.gramifiedList(filteredList);
		for (int i=0;i<grams.size();i++) {
			this.add(grams.get(i));
		}
		
	}
	
	public Histogram () {  }
	
	public void add(Bigram gram) {
		if (!this.hasBigram(gram)) {
			uniqueBigrams.add(gram);
			occurences.add(1);
		}
		else {
			int index = this.getBigramIndex(gram);
			int value = occurences.get(index);
			value++;
			occurences.set(index, value);
		}
		
	}
	
	public boolean hasBigram(Bigram gram) {
		boolean has = false;
		for (int i=0;i<uniqueBigrams.size();i++) {
			if (Bigram.compareBigrams(gram,uniqueBigrams.get(i)) ) {
				
				has = true;
				i = uniqueBigrams.size()+1;
			}
		}
		return has;
	}
	
	public int getBigramIndex(Bigram gram) {
		int result = -1;
		for (int i=0;i<uniqueBigrams.size();i++) {
			if (Bigram.compareBigrams(gram,uniqueBigrams.get(i)) ) {
				result = i;
			}
		}
		return result;
	}
	
	public void printout() {
		for (int i=0;i<uniqueBigrams.size();i++) {
			String stars="";
			for (int j=0;j<occurences.get(i);j++) {
				stars = stars + "*";
			}
			
			System.out.printf("%-30.30s  %-3.3s  %-100.100s%n", 
					uniqueBigrams.get(i), occurences.get(i), stars);
		}
		
		
	}
	
}
