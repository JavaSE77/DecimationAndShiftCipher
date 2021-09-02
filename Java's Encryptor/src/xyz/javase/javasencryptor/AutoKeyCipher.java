package xyz.javase.javasencryptor;

public class AutoKeyCipher {

	private String key;
	public AutoKeyCipher(String key) {

		this.key = key;
		
	}
	
	public String encodeMessgae(String msg) {
		String output;
		StringBuilder keyBuilder = new StringBuilder();
		
		keyBuilder.append(key);
		keyBuilder.append(stripChar32(msg));
		
		VigenereCipher vigenere = new VigenereCipher(keyBuilder.toString());
		
		output = vigenere.encryptString(msg);
		
		return output;
	}
	
	public String decodeMessgae(String msg) {
		
		StringBuilder output = new StringBuilder();
		msg = stripChar32(msg);
		
		char[] key = new char[msg.length()+this.key.length()];
		
		for(int i = 0; i < this.key.length(); i++) {
			key[i] = this.key.charAt(i);
		}
		
		for(int i = 0; i < msg.toCharArray().length; i++) {
			
			Rotter rot = new Rotter(Math.abs((key[i] - 65)- 26));
			char rottedChar = rot.rotate(msg.toCharArray()[i]);
			output.append(rottedChar);
			key[this.key.length() + i] = rottedChar;
			
//			System.out.println("DEBUG " + " starting char " + (char) msg.toCharArray()[i] +
//					" offset " + Math.abs((key[((i) % key.length)] - 65)- 26) + " || " + (char) (key[((i ) % key.length)])
//					+ " output of:" + rot.rotate(msg.toCharArray()[i]));
		}
		
		
	
		
		return output.toString().toLowerCase();
	}
	
	
	public String stripChar32(String input) {
		
		StringBuilder output = new StringBuilder();
		for(int i = 0; i < input.toCharArray().length; i++) {
			if(input.charAt(i) != 32) {
				output.append(input.charAt(i));
			}
		}
		
		return output.toString();
		
	}
	
}
