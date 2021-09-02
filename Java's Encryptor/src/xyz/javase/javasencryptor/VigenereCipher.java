package xyz.javase.javasencryptor;

public class VigenereCipher {

	private char[] charKey;
	private int[] key;
	
	public VigenereCipher(String key) {
		this.charKey = key.toUpperCase().toCharArray();
		
		generateOffSetKey();
		
	}
	/**
	 * We are taking all strings in as ASCII charters. Ascii 'A' is 65. Z is '90'
	 * **/
	private void generateOffSetKey() {
		
		this.key = new int[charKey.length];
		
		for(int i = 0; i < charKey.length; i++) {
			for (int j = 65; j < 91; j++) {
			if(charKey[i] == j) {
				key[i] = j;
				continue;
			}
			}
		}
		
	}
	
	public String encryptString(String msg) {
		StringBuilder output = new StringBuilder();
		
		int spaceCounter = 0;
		
		for(int i = 0; i < msg.toCharArray().length; i++) {
			if(msg.toCharArray()[i] == 32) {
				//then it is a space
				spaceCounter++;
			}
			Rotter rot = new Rotter(key[((i - spaceCounter) % key.length)] - 65);
			output.append(rot.rotate(msg.toCharArray()[i]));
//			
//			System.out.println("DEBUG " + " starting char " + (char) msg.toCharArray()[i] +
//					" offset " + (key[((i - spaceCounter) % key.length)] - 65) + " || " + (char) (key[((i - spaceCounter) % key.length)])
//					+ " output of:" + rot.rotate(msg.toCharArray()[i]));
		}
		
		return output.toString();
	}
	
	public String decryptString(String msg) {
		StringBuilder output = new StringBuilder();
		
		int spaceCounter = 0;
		
		for(int i = 0; i < msg.toCharArray().length; i++) {
			if(msg.toCharArray()[i] == 32) {
				//then it is a space
				spaceCounter++;
			}
			Rotter rot = new Rotter(Math.abs((key[((i - spaceCounter) % key.length)] - 65)- 26));
			output.append(rot.rotate(msg.toCharArray()[i]));
			
//			System.out.println("DEBUG " + " starting char " + (char) msg.toCharArray()[i] +
//					" offset " + Math.abs((key[((i - spaceCounter) % key.length)] - 65)- 26) + " || " + (char) (key[((i - spaceCounter) % key.length)])
//					+ " output of:" + rot.rotate(msg.toCharArray()[i]));
		}
		
		
		return output.toString().toLowerCase();
	}
	
}
