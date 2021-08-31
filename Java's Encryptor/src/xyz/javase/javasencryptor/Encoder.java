package xyz.javase.javasencryptor;

public class Encoder {

	private char[] key;
	
	public Encoder(String key) {
		this.key = generateArrayFromKey(key);
	}
	
	private char[] generateArrayFromKey(String key) {
		
		return key.toCharArray();
	}
	
	public String encodedMessage(String message) {
		
		char[] input = message.toUpperCase().toCharArray();
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < input.length; i++) {
			
			int placeInAlphabet = input[i] - 65;
			
			output.append(key[placeInAlphabet]);
		}
		 
		return output.toString();
	}
	
	
}
