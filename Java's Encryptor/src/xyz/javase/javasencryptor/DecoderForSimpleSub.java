package xyz.javase.javasencryptor;

public class DecoderForSimpleSub {

	private char[] key;
	private char[] alphabet;
	
	public DecoderForSimpleSub(String key) {
		this.key = generateArrayFromKey(key);
		this.alphabet = generateArrayFromKey(Main.generateAlphabet());
	}
	
	private char[] generateArrayFromKey(String key) {
		
		return key.toCharArray();
	}
	
	public String decodedMessage(String message) {
		
		char[] input = message.toUpperCase().toCharArray();
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < input.length; i++) {

			for(int j = 0; j < key.length; j++) {
				if(key[j] == input[i]) {
					output.append(alphabet[j]);
					continue;
				}
				
			}
			
		}
		 
		return output.toString();
	}
}
