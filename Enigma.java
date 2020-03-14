//Dylan Usoro
//Enigma
//June 10 2016
//Ap CS p.2
import java.util.Scanner;

public class Enigma {
	public static String pb1; //plugboard 1
	public static String pb2; // connected to plugboard 1
	public static String pb3; // plugboard 2
	public static String pb4; // connected to plugboard 2
	public static String pb5; // plugboard 3
	public static String pb6; // connected to plugboard 3

	

	public static void main(String[] args) {
		FinalEncrypt();
	}

	public static void FinalEncrypt() {
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"; // multiple attached strings so it doesnt index out of bounds
		String ROTOR1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJEKMFLGDQVZNTOWYHXUSPAIBRCJEKMFLGDQVZNTOWYHXUSPAIBRCJ";
		String ROTOR2 = "AJDKSIRUXBLHWTMCQGZNPYFVOEAJDKSIRUXBLHWTMCQGZNPYFVOEAJDKSIRUXBLHWTMCQGZNPYFVOE";
		String ROTOR3 = "BDFHJLCPRTXVZNYEIWGAKMUSQOBDFHJLCPRTXVZNYEIWGAKMUSQOBDFHJLCPRTXVZNYEIWGAKMUSQO";
		String ROTOR4 = "ESOVPZJAYQUIRHXLNFTGKDCMWBESOVPZJAYQUIRHXLNFTGKDCMWBESOVPZJAYQUIRHXLNFTGKDCMWB";
		String ROTOR5 = "VZBRGITYUPSDNHLXAWMJQOFECKVZBRGITYUPSDNHLXAWMJQOFECKVZBRGITYUPSDNHLXAWMJQOFECK";
		String reflect = "YRUHQSLDPXNGOKMIEBFZCWVJATYRUHQSLDPXNGOKMIEBFZCWVJATYRUHQSLDPXNGOKMIEBFZCWVJAT";
		Scanner scan = new Scanner(System.in); //scanner
		System.out.println("Please input an Encryption:");
		String I = scan.next(); //  I first rotor 
		String II =scan.next(); // second rotor
		String III = scan.next(); // thrid rotor
		
		if(I.equals("III")){ //checks if rotor1 is 3
			ROTOR1 = ROTOR3; //will change if so
		}if(I.equals("II")){ // does the same thing for each one
			ROTOR1 = ROTOR2;
		}if(II == "IV"){
			ROTOR2 = ROTOR4;
		} if(II.equals("III")){ 
			ROTOR2 = ROTOR3;
		} if(III.equals("V")){
			ROTOR3 = ROTOR5;
		}  if(III.equals("IV")){
			ROTOR3 = ROTOR4;
		}
		
		String Rotor1Setting = scan.next(); //collects each rotor position
		
		String Rotor2Setting = scan.next();
	
		String Rotor3Setting = scan.next();
		
		
		//need to subtract last rotor position and add the rotor position.
		String plugboard1 = scan.next(); // gets plugboards and separates them
		pb1 = plugboard1.substring(0, 1);
		pb2 = plugboard1.substring(1, 2);
		String plugboard2 = scan.next();  
		pb3 = plugboard2.substring(0, 1);
		pb4 = plugboard2.substring(1, 2);
		String plugboard3 = scan.next();
		pb5 = plugboard3.substring(0, 1);
		pb6 = plugboard3.substring(1, 2);

		scan.next(); // skips over :
		
		while(scan.hasNext()){ //while there is more inputed encryption
		String whole = scan.next(); // collects each word
		int counter = 0; // first counter for changing rotor position
		int counter2 = 0; // second counter to print spaces every 4 letters
		for (int i = 0; i <= whole.length() - 1; i++) { //for loops through each letter in the word
			
			String toPlugBoard = whole.substring(i, i + 1);

			if (pb1.equals(toPlugBoard)) { //changes plugboards if letter is equal to it
				toPlugBoard = pb2;

			} else if (pb3.equals(toPlugBoard)) {
				toPlugBoard = pb4;

			} else if (pb5.equals(toPlugBoard)) {
				toPlugBoard = pb6;

			}else if (pb2.equals(toPlugBoard)) {
				toPlugBoard = pb1;

			}else if (pb4.equals(toPlugBoard)) {
				toPlugBoard = pb3;

			} else if (pb6.equals(toPlugBoard)) {
				toPlugBoard = pb5;

			}
			else {

			}
			int ChangedRotor3 = alpha.indexOf(Rotor3Setting); //index of rotors setting to add if change is needed
			int ChangedRotor2 = alpha.indexOf(Rotor2Setting);
			int ChangedRotor1 = alpha.indexOf(Rotor1Setting);
			
			
			
			
			int placement = alpha.indexOf(toPlugBoard); //finds the placement of the inputed letter and finds it on alpha
			String intoRotor3 = ROTOR3.substring(counter + ChangedRotor3 + placement , counter + ChangedRotor3 + placement + 1); // adds the counter and everything to change to correct location on that rotor
			
			
			int placement1 = alpha.indexOf(intoRotor3);
			String intoRotor2 = ROTOR2.substring(placement1 + ChangedRotor2 +(26- ChangedRotor3)-counter , placement1 + ChangedRotor2 + (26 - ChangedRotor3)-counter  + 1);
			
			
			int placement2 = alpha.indexOf(intoRotor2);
			String intoRotor1 = ROTOR1.substring(placement2 + ChangedRotor1 - ChangedRotor2 , placement2 + ChangedRotor1 - ChangedRotor2 + 1);
			
			
			int placement3 = alpha.indexOf(intoRotor1);
			String intoReflector = reflect.substring(placement3 + (26 -ChangedRotor1) , placement3 + (26 -ChangedRotor1) + 1);
			
			
			int placement4 = alpha.indexOf(intoReflector);
			String outOfReflector = alpha.substring( ChangedRotor1 + placement4  , placement4 + ChangedRotor1 +1);
			int blop = ROTOR1.indexOf(outOfReflector);
			String ofReflection = alpha.substring(blop, blop + 1);
			
			
			int placement5 = alpha.indexOf(ofReflection);
			String outOfRotor1 = alpha.substring(placement5 + ChangedRotor2 - ChangedRotor1 , placement5 +  ChangedRotor2 - ChangedRotor1 +1);
			int bruh = ROTOR2.indexOf(outOfRotor1);
			String OfRotor1 = alpha.substring(bruh, bruh + 1);
			
			
			int placement6 = alpha.indexOf(OfRotor1);
			String outOfRotor2 = alpha.substring(placement6 +  ChangedRotor3 + (26- ChangedRotor2)+counter , placement6 + ChangedRotor3 + (26- ChangedRotor2)+counter +1);
			int savage = ROTOR3.indexOf(outOfRotor2);
			String OfRotor2 = alpha.substring(savage + (26 - ChangedRotor3) -counter, savage + (26- ChangedRotor3)-counter +1);
			if (pb2.equals(OfRotor2)) { //returns to each plugboard and changes if needed
				OfRotor2 = pb1;

			} else if (pb4.equals(OfRotor2)) {
				OfRotor2 = pb3;

			} else if (pb6.equals(OfRotor2)) {
				OfRotor2 = pb5;

			}else if (pb1.equals(OfRotor2)) {
				OfRotor2 = pb2;

			}else if (pb3.equals(OfRotor2)) {
				OfRotor2 = pb4;

			}else if (pb5.equals(OfRotor2)) {
				OfRotor2 = pb6;

			}
			System.out.print(OfRotor2); //prints out new letter 
			counter++; //increments counter
			counter2++; //increments counter2
			if(counter2 == 4){ //when counter 2 is equal to 4 prints out a space and resets counter2 to 0
				System.out.print(" ");
				counter2 = 0;
			}
		}
		}
		scan.close();
	}
}







