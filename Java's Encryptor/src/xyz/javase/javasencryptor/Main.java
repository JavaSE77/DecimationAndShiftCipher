package xyz.javase.javasencryptor;

public class Main {
	public static void main(String[] args) {
		Rotter rot7 = new Rotter(7);
		Decimation decimation = new Decimation(11);
		Encoder shift0 = new Encoder(generateAlphabet());
		Encoder shift7 = new Encoder(rot7.rotate(generateAlphabet()));
		Encoder encryptDecemation = new Encoder(decimation.alphabetize());
	
		
		System.out.println(generateAlphabet().toLowerCase());
		System.out.println(decimation.alphabetize());
		System.out.println(generateAlphabet().toLowerCase());
		System.out.println(rot7.rotate(decimation.alphabetize()));
		System.out.println(shift0.encodedMessage("HELLO"));
		System.out.println(shift7.encodedMessage("HELLO"));
		System.out.println(encryptDecemation.encodedMessage("HELLO"));
		
		System.out.println(shift7.encodedMessage(encryptDecemation.encodedMessage(generateAlphabet())));
		System.out.println(encryptDecemation.encodedMessage(shift7.encodedMessage("PRICE")));
		
		DecoderForSimpleSub decoder = new DecoderForSimpleSub(shift7.encodedMessage(encryptDecemation.encodedMessage(generateAlphabet())));
		System.out.println(decoder.decodedMessage(shift7.encodedMessage("DYJOB")));
		
		
		Encoder simpleSub = new Encoder("RVLZWDENTMUPQFXJAYBSKIOGHC");
		System.out.println(simpleSub.encodedMessage("SMILE"));
		
		
		Decimation decimation17 = new Decimation(17);
		Decimation decimation25 = new Decimation(23);
		Encoder ec17 = new Encoder(decimation17.alphabetize());
		Encoder ec25 = new Encoder(decimation25.alphabetize());
		String code = ec17.encodedMessage("HELLO");
		DecoderForSimpleSub dc = new DecoderForSimpleSub(decimation25.alphabetize());
		System.out.println(dc.decodedMessage(code));
		Rotter rot8 = new Rotter(8);
		DecoderForSimpleSub dc8 = new DecoderForSimpleSub(rot8.rotate(generateAlphabet()));
		System.out.println(ec25.encodedMessage(dc8.decodedMessage("DYJOB")));
		
//		for (int i = 0; i < 26; i++) {
//			Decimation decimationLoop = new Decimation(i);
//			Encoder ecLoop = new Encoder(decimationLoop.alphabetize());
//			System.out.println("Output using " + i +": " + ecLoop.encodedMessage(code));
//		}
		
		VigenereCipher vingenere = new VigenereCipher("HEART");
		String vin = vingenere.encryptString("TOMORROW HEAD NORTH TO HEADQUARTERS");
		System.out.println("TOMORROW HEAD NORTH TO HEADQUARTERS");
		System.out.println(vin);
		
		
		VigenereCipher evingenere = new VigenereCipher("GUESS");
		String evin = evingenere.decryptString("ZIQG JXIA ZWGX WGMZ BXGT GMIU SSJ");
		System.out.println("ZIQG JXIA ZWGX WGMZ BXGT GMIU SSJ");
		System.out.println(evin);
		
		AutoKeyCipher autokeyCipher = new AutoKeyCipher("AVOID");
		String autokey = autokeyCipher.encodeMessgae("AT SIX HEAD EAST TO ENEMY CAMP");
		System.out.println("AT SIX HEAD EAST TO ENEMY CAMP");
		System.out.println(autokey);	
		
		AutoKeyCipher autokeyCipher2 = new AutoKeyCipher("MUSIC");
		String autokey2 = autokeyCipher2.decodeMessgae("UHLE QLNR OGSY MFLP PURM");
		System.out.println("UHLE QLNR OGSY MFLP PURM");
		System.out.println(autokey2);
		
		
		String input;
		String output;
		System.out.println("Old Ciphers reprogrammed");
		
		
		AdditiveCipher ad = new AdditiveCipher(15);
		input = "Strawberry";
		output = ad.encode(input);
		System.out.println(input);
		System.out.println(output);
		
		MultiplicativeCipher md = new MultiplicativeCipher(25);
		input = "sound";
		output = md.encode(input);
		System.out.println(input);
		System.out.println(output);
		
		VigenereCipher cd = new VigenereCipher("TEACH");
		input = "AT ONE ATTACK FRONT LINES";
		output = cd.encryptString(input);
		System.out.println(input);
		System.out.println(output);
		
		AffineCipher ac = new AffineCipher(17, -25);
		input = "EHZQM ";
		output = ac.encode(input);
		System.out.println(input);
		System.out.println(output);
		
		cd = new VigenereCipher("PLANT");
		input = "PEFV OTDU EOTT LYTC NEBG ICEA VWPS";
		output = cd.decryptString(input);
		System.out.println(input);
		System.out.println(output);
		
		
	}
	
	public static String generateAlphabet() {
		StringBuilder output = new StringBuilder();
		
		for(int i = 1; i <= 26; i++) {
			/**
			 * We are taking all strings in as ASCII charters. Ascii 'A' is 65. Z is '90'
			 * **/

			output.append((char) (64+i));
			
		}
		
		return output.toString();
	}
}
