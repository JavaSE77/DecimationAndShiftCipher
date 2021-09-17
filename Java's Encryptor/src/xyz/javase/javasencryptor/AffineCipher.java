package xyz.javase.javasencryptor;

public class AffineCipher {

	private int multiply;
	private int add;
	private AdditiveCipher ac;
	private MultiplicativeCipher mc;

	public AffineCipher(int multiply, int add) {
		this.multiply = multiply;
		this.add = add;
		this.ac = new AdditiveCipher(add);
		this.mc = new MultiplicativeCipher(multiply);
	}

	
	public String encode(String input) {
		String output = mc.encode(input);
		output = ac.encode(output);
		
		return output;
	}

	public char encode(char input) {
		char output = mc.encode(input);
		output = ac.encode(output);
		
			return output;
	}
	

}
