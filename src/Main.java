import java.util.Scanner;

public class Main {

//	Create a function that takes a number as an argument and returns true if the number is a valid credit card number, false otherwise.
//
//	Credit card numbers must be between 14-19 digits in length, and pass the Luhn test, described below:
//
//	Remove the last digit (this is the "check digit").
//	Reverse the number.
//	Double the value of each digit in odd-numbered positions. If the doubled value has more than 1 digit, add the digits together (e.g. 8 x 2 = 16 --> 1 + 6 = 7).
//	Add all digits.
//	Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.
//
//	Examples
//	validateCard(1234567890123456) ➞ false
//
//	// Step 1: check digit = 6, num = 123456789012345
//	// Step 2: num reversed = 543210987654321
//	// Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
//	// Step 4: sum = 58
//	// Step 5: 10 - 8 = 2 (not equal to 6) --> false
//
//	validateCard(1234567890123452) --> true

//	public boolean isValid(String s) {
//		if (s.length() > 13 && s.length() < 20) {
//			return true;
//		} else {return false;}
//	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter valid Credit Card Number:");

		// input goes into s
		StringBuilder s = new StringBuilder(sc.next());

		// checks for valid length of 14-19 digits
		if (s.length() > 13 && s.length() < 20) {
			int checkDigit = Character.getNumericValue(s.charAt(s.length()-1));
			int sum = 0;
			
			// removes last digit
			s.setLength(s.length() - 1);
			// reverses digits
			s.reverse();

			// inputs digits into char array
			char[] sAsArray = new char[s.length()];
			s.getChars(0, s.length(), sAsArray, 0);
			int length = sAsArray.length;

			//making empty int array
			int[] intArray = new int[sAsArray.length];
			
			//storing char array as int array
			for (int n = 0; n < length; n++) {

				//only double odd numbered positions in array
				if ((n+1)%2 == 1) {
					
					//doubling value
					intArray[n] = Character.getNumericValue(sAsArray[n]) * 2;
					}

				
				//if value is greater than 9, add number into 1 digit
				if (intArray[n] > 9) {
					int value = intArray[n];
					int added = 0;
					while (value != 0) {
						added = added + value % 10;
						value = value/10;
						intArray[n] = added;
					}
				}
				
				//stores array
				if ((n+1)%2 == 0 ) {
					intArray[n] = Character.getNumericValue(sAsArray[n]);
				}
				
				sum = sum + intArray[n];
				
			}
			
			String sumString = Integer.toString(sum);
			
			char[] sumArray = new char[String.valueOf(sum).length()];
			
			//inputing value into new array
			sumString.getChars(0, sumArray.length, sumArray, 0);
			
			int lastDigit = Character.getNumericValue(sumArray[1]);
			
			int result = 10 - lastDigit;
			
			if (result == checkDigit) {
				System.out.println("Valid Number");
			} else {
				System.out.println("Invalid Number");
			}
			
		} else {
			System.out.println("Invalid");
			System.exit(1);
		}

		sc.close();

	}
}

// false
// 1234567890123456
// true
// 1234567890123452
