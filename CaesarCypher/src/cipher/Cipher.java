package cipher;
import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.security.SecureRandom;
public class Cipher{
	private static String[] ascii = new String[] {"!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", "0", "1", "2", "3", "4", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@", "A", "B", "C", "D", "E", "F", "G", "H", "I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","[","]","^","_","`","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	public static void encrypt(String[] s) throws FileNotFoundException, UnsupportedEncodingException {
		SecureRandom random = new SecureRandom();
		ArrayList<String> c = new ArrayList<String>();
		/* This method will take in Plaintext 'S'
		 * and encrypt it using SecureRandom by
		 * iterating through the string, spitting out
		 * ciphertext c.
		 */ //Took out escape characther "\\"
		Integer[] key = new Integer[s.length];
		//Integer[] asciiVal= new Integer[]{};
		//String[] ascii = new String[] {"!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", "0", "1", "2", "3", "4", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@", "A", "B", "C", "D", "E", "F", "G", "H", "I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","[","]","^","_","`","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," "};
		for(int i = 0; i < key.length; i++) {
			
			key[i] = random.nextInt(ascii.length)%ascii.length; //This is the key only
		}
		
		//for() //this is for the ciphertext
		char[] cipher = new char[s.length];
		for(int i=0; i<key.length;i++){
			//int acii = key[i] + (int) s[i].charAt(0);
			System.out.print(s[i] + " " + findIndex(s[i].charAt(0)) + "\n");
			int acii = key[i] + findIndex(s[i].charAt(0));
			acii = acii%ascii.length;
			//cipher[i] = (char) acii;
			cipher[i] = ascii[acii].charAt(0);
		}
		
		
		PrintWriter writer = new PrintWriter("saveFile.txt", "UTF-8");
		
		
		for(int i=0; i<key.length; i++)
		{

				writer.print(key[i] + " ");
		}
		writer.println(" ");
		
		for(int i=0; i<key.length; i++)
		{

				writer.print(cipher[i] + " ");
		}
		
		writer.close();
		decrypt(s);
		
		
		/* 
		FileOutputStream saveFile = new FileOutputStream("saveFile.sav");
		ObjectOutputStream save = ObjectOutputStream(saveFile);
		
		try {
			save.writeObject(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ObjectOutputStream ObjectOutputStream(
			FileOutputStream saveFile) {
		// TODO Auto-generated method stub
		return null;
	*/
	}
	
	private static void decrypt(String[] s) {
		String[] data = new String[2];
//		try {
//		   Scanner scanner = new Scanner(new File("saveFile.txt"));
//		   scanner.useDelimiter(System.getProperty("line.separator"));
//		   int i=0;
//		   		while (scanner.hasNext())
//		   			System.out.println(scanner.next()+ " " +i);
//		   			i++;
//		   			scanner.close();
//		} catch (FileNotFoundException e) {
//		   e.printStackTrace();
//		   System.out.print("File saveFile.txt not found");
//	  }
		InputStream    fis = null;
		BufferedReader br;
		String         line;

		try {
			fis = new FileInputStream("saveFile.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
		try {
			int i=0;
			while ((line = br.readLine()) != null) {
			    data[i] = line;
			    i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Done with the file
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = null;
		fis = null;
		
		data[1] = data[1].trim();
		StringTokenizer stdZ = new StringTokenizer(data[0]);
		for(int i=0;i<s.length;i++){

			String x = stdZ.nextToken();
			int a = (int) Integer.parseInt(x);
			// statements for debugging purposes
			//System.out.println(a);
			//System.out.println(data.length);
			//System.out.println(data[0].charAt(i));
			//System.out.println(data[1].charAt(i));
			//System.out.println(x);
			//System.out.println(Integer.parseInt(x));
			//System.out.println(findIndex(data[1].charAt(i)));
			int result = findIndex(data[1].charAt((i*2))) - a;
			System.out.println(result + " = " + findIndex(data[1].charAt(i)) + " - " + a);
			//System.out.println(result);
			if(result<0){
				result = result + ascii.length;
				System.out.println("After adding " + ascii.length + " "+ result);
			}
			else {
				result = result % ascii.length;
				System.out.println("After moding " + result);
			}
			//System.out.println(result);
			System.out.println(ascii[result]);
		}
		
	}
	
	
	private static int findIndex(char x){
		int result=0;
		inner: for(int i=0; i<ascii.length;i++){
			if(ascii[i].charAt(0)==x){
				result = i;
				break inner;
			}
		}
		return result;
	}
}
