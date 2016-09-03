package cipher;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
public class CipherController extends Cipher {
 
	public static void main(String[] args) {
	boolean continueE = false;
	boolean continueD = false;
	boolean invalid = true;
	SecureRandom random = new SecureRandom();
	String input = "";
	
	Scanner s = new Scanner(System.in);	
	System.out.println("Would you like to (E)ncrypt or (D)ecrypt, or (Q)uit:  "); //first prompt

    do {

        input = s.next();
    	
    if (input.equals("E")|| input.equals("Encrypt")|| input.equals("e")|| input.equals("encrypt") ) { //encrypt path
    	continueE = true;
    	invalid = false;
    }
	
    else if (input.equals("D") || input.equals("Decrypt") || input.equals("d") || input.equals("decrypt") ) { //decrypt path
    	continueD = true;
    	invalid = false;
    }
    
    else if (input.equals("Q") || input.equals("q") || input.equals("quit") || input.equals("Quit") ) { //invalid path
    	invalid = false;
    	break;
    }
    
    else {
    	System.out.println("Invalid option.  Press Q to quit, E to encrypt, or D to decrypt: "); //Invalid option
	}
	
	} while(invalid); //repeat if invalid
    
    if(continueE) { /****** This is the ENCRYPTION PATH ********/
        invalid = true;
    	System.out.println("Please enter plaintext: ");
    	//Scanner key = new Scanner(System.in);
    	input = s.next();
    	//String plaintext = key.next();
    	String[] strArray = input.split(""); //Converts String into an array
    	strArray[0] = " "; //replace the beginning with a space instead of null
    	String[] strArray2 = Arrays.copyOfRange(strArray, 1, strArray.length);
    	try {
			encrypt(strArray2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
	
} //This bracket ends Public Static Void Main
	
}
