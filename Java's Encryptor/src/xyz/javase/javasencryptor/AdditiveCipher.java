package xyz.javase.javasencryptor;

public class AdditiveCipher {
	
	private int shift;

	public AdditiveCipher(int shift) {
		this.shift = shift;
	}
	
	/**
	 * We are taking all strings in as ASCII charters. Ascii 'A' is 65. Z is '90'
	 * **/
	
	
	public String encode(String input) {
		input = input.toUpperCase();
		StringBuilder output = new StringBuilder();
		
		//Check if letter is valid ascii code
		for(char c : input.toCharArray()) {
			int asciiForC = c - 65;
			
			//this is a space. We are keeping space for now
			if(c == 32) {
				output.append(" ");
				continue;
			}
			

			
			//rotate letter by the shift amount
			asciiForC += shift;
			
			//check if letter loops back from z. Perform mod operation
			asciiForC = asciiForC % 26;
			
			c = (char) (Math.abs(asciiForC) + 65);
			output.append(c);
		}
		
		
		return output.toString();
	}

	public char encode(char input) {
		// TODO Auto-generated method stub
		char output;
		
			int asciiForC = input - 65;
			
			//this is a space. We are keeping space for now
			if(input == 32) {
				return ' ';
			}	
			
			
			//rotate letter by the shift amount
			asciiForC += shift;
			
			//check if letter loops back from z. Perform mod operation
			asciiForC = asciiForC % 26;
			

			output = (char) (Math.abs(asciiForC) + 65);
		
			return output;
	}
}
