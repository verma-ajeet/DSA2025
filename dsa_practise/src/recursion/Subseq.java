package recursion;

public class Subseq {
	public static void main(String[] args) {
		String mainString = "Hello, world!";
		String subString = "lool";
		isSequence(mainString,subString);
		isSeq(mainString,subString);
	}

	private static void isSeq(String mainString, String subString) {
		int mainInd=0;
		int subInd=0;
		while(mainInd<mainString.length() && subInd<subString.length()){
			if(mainString.charAt(mainInd)==subString.charAt(subInd)) {
				subInd++;
			}
			mainInd++;
		}
		System.out.println(subInd==subString.length());
	}

	private static void isSequence(String mainString, String subString) {
		int mainInd=0;
		int subInd=0;
		while(mainInd<mainString.length() && subInd<subString.length()) {
			if(subString.charAt(subInd)==mainString.charAt(mainInd)) {
				subInd++;
			}
			mainInd++;
		}
		System.out.println(subInd==subString.length());
	}
	
}
