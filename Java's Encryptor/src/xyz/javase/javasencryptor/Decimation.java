package xyz.javase.javasencryptor;

public class Decimation {

	private int key;
	
	public Decimation(int key) {
		this.key = key;
	}
	
	public String alphabetize() {
		StringBuilder output = new StringBuilder();
		
		for(int i = 1; i <= 26; i++) {
			/**
			 * We are taking all strings in as ASCII charters. Ascii 'A' is 65. Z is '90'
			 * **/
			int shift = (i * key) % 26;
			//handle edge case where z equals 0
			if(shift == 0) shift = 26;
			output.append((char) (64+shift));
			
		}
		
		return output.toString();
	}
	

	
	
}
