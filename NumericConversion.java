import java.util.Locale;
import java.util.Scanner;
public class NumericConversion {
    public static void main(String[] args) {

        boolean NumericConversionTool = true;
        long returnme = 0; // I think the hex in the methods may need to be replaced with returnme
        String hexadecimal = null;
        String binary = null;
        Scanner scanner = new Scanner(System.in); //REMINDER: Always declare Scanner outside the loop!

        while (NumericConversionTool) {

        System.out.println("Decoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal"); //Decodes into decimal
        System.out.println("2. Decode binary"); //Decodes into decimal
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");
        System.out.println(" ");
        System.out.print("Please enter an option: ");
        int menuInput = scanner.nextInt();

        if (menuInput ==1) {
            System.out.print("Please enter the numeric string to convert: ");
            hexadecimal = scanner.next();
            //hexadecimal = hexadecimal.toUpperCase(); // This turns any lowercase letters uppercase
            returnme = hexStringDecode(hexadecimal);
            System.out.println("Result: " + returnme);
        }
        if (menuInput ==2) {
            System.out.print("Please enter the numeric string to convert: ");
            binary = scanner.next();
            returnme = binaryStringDecode(binary);
            System.out.println("Result: " + returnme);
        }
        if (menuInput ==3) {
            System.out.print("Please enter the numeric string to convert: ");
            binary = scanner.next();
           // returnme = binaryToHex(binary);
            System.out.println("Result: " + returnme);
        }
        if (menuInput ==4) {
            System.out.print("Goodbye!");
            break;
        }
        }

    }


    ///charAt(int index) seems like it could be useful. Take each character one index at a time and convert it

    public static Long hexStringDecode(String hex) { //Decodes an entire hexadecimal string and returns its value.
        hex = hex.toUpperCase(); // This turns any lowercase letters uppercase
        long returnme = 0;
        int lengthindexString = 0;
        lengthindexString = hex.length()-1; // The length of how many indexes are in the string
        //Might have to possibly add lengthindexString - 1; here?

        if ((hex.contains ("0X")||hex.contains("0x"))) {
            // (statement that deletes the first two index? substring() doesn't work.
            for (int i = 2; i <= lengthindexString; i++) { //This should start on the 2nd index, after 0x?
                returnme +=  (Math.pow(16, (lengthindexString - i)) * (hexCharDecode(hex.charAt(i))) );
            }
        }
        else {
            for (int i = 0; i <= lengthindexString; i++ ) { //This should start on the first index, 0, and work its way to the last index
                returnme += (Math.pow(16, (lengthindexString - i)) * (hexCharDecode(hex.charAt(i))) );
            }

        }
    return returnme;
    }



    public static short hexCharDecode(char digit) { //Decodes a single hex digit into decimal. This method is called and used in the hexStringDecode method.
        //digit = Character.toUpperCase();
        short decimal = 0;
        switch (digit) {
            case 'A':
            case 'a':
                decimal = 10;
                break;
            case 'B':
            case 'b':
                decimal = 11;
                break;
            case 'C':
            case 'c':
                decimal = 12;
                break;
            case 'D':
            case 'd':
                decimal = 13;
                break;
            case 'E':
            case 'e':
                decimal = 14;
                break;
            case 'F':
            case 'f':
                decimal = 15;
                break;
            default:
                decimal = (short)(digit - 48);
                //ascii values
        } //if digit = '2', which is 50 ASCII value, subtract 48 and you end up with actual 2.
    return decimal;
    }




    public static short binaryStringDecode(String binary) {  //Decodes a binary string and returns its value.
        long returnme = 0;
        int convertCharacter = 0;
        int lengthindexString = binary.length()-1; // The length of how many indexes are in the string

        if ((binary.contains ("0b")||binary.contains("0B"))) {
            for (int i=2; i<= lengthindexString; i++) { //Since 0b or 0B wants to be ignored, the i value starts at 2
                convertCharacter = (binary.charAt(i) - 48); //This converts the character '0' or '1' into its int value.
                returnme += (Math.pow(2, (lengthindexString - i))) * convertCharacter; //Then it takes that int value and multiplies it by 2 to the power of whatever index position its in.

            }

        }
        else {
            for (int i = 0; i <= lengthindexString; i++) {
                convertCharacter = (binary.charAt(i)-48); //This converts the character '0' or '1' into its int value.
                returnme += (Math.pow(2, (lengthindexString - i))) * convertCharacter; //Then it takes that int value and multiplies it by 2 to the power of whatever index position its in.
            }

        }


   return (short) returnme;
    }




        // BINARY TO HEX IS EXTRA CREDIT
  // public static String binaryToHex(String binary) { // Decodes a binary string, re-encodes it as a hexadecimal, and returns the hexadecimal string


   // return;
  //  }
}


