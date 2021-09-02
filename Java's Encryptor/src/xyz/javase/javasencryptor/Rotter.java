package xyz.javase.javasencryptor;

public class Rotter {

	private int shift = 0;
	
	/**
	 * We are taking all strings in as ASCII charters. Ascii 'A' is 65. Z is '90'
	 * **/
	
	public Rotter(int shift) {
		this.shift = shift;
	}
	
	public String rotate(String input) {
		input = input.toUpperCase();
		StringBuilder output = new StringBuilder();
		
		//Check if letter is valid ascii code
		for(char c : input.toCharArray()) {
			int asciiForC = c;
			
			//this is a space. We are keeping space for now
			if(asciiForC == 32) {
				output.append(" ");
				continue;
			}
			
//			if(asciiForC > 90 || asciiForC < 65) {
//				throw new LetterOutOfACSIIRange("Input out of range at: " + c + " " + asciiForC);
//			}
			
			//rotate letter by the shift amount
			asciiForC += shift;
			
			//check if letter loops back from z
			if(asciiForC > 90) {
				asciiForC -= 26;
			}
			
			c = (char) asciiForC;
			output.append(c);
		}
		
		
		return output.toString();
	}

	public char rotate(char input) {
		// TODO Auto-generated method stub
		char output;
		
			int asciiForC = input;
			
			//this is a space. We are keeping space for now
			if(asciiForC == 32) {
				return ' ';
			}	
			
			
			//rotate letter by the shift amount
			asciiForC += shift;
			
			//check if letter loops back from z
			if(asciiForC > 90) {
				asciiForC -= 26;
			}
			
			
			output = (char) asciiForC;
		
			return output;
	}
	
}
