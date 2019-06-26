package bigramParser;

public class Bigram {

	private String first;
	private String second;
	
	public Bigram(String first, String second) {
		this.first = first;
		this.second = second;
	}
	public String toString() {
		return "[" + first + " " + second + "]";
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	
	public static boolean compareBigrams(Bigram one, Bigram two) {
		String oneFirst = one.getFirst();
		String oneSecond = one.getSecond();
		String twoFirst = two.getFirst();
		String twoSecond = two.getSecond();
		
		boolean firsts = oneFirst.equals(twoFirst);
		boolean seconds = oneSecond.equals(twoSecond);
		
		if (firsts && seconds) return true;
		else return false;	
	}
	
}
