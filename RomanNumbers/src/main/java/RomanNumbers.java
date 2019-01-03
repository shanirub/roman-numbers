public class RomanNumbers {

    public static final String ROMAN_VALUES = "IVXLCDM";
    public static final int[] DEC_VALUES = {1,5,10,50,100,500,1000};

    public static void main (String[] args) {

    }

    private static int translateOneDigit(char digit) {
        int digitIndex = ROMAN_VALUES.indexOf(digit);
        return DEC_VALUES[digitIndex];
    }

    public static int romanToDec(String roman) {

        if (roman.length() == 0) // empty string
            return 0;

        if (roman.length() == 1) // one roman digit
             return translateOneDigit(roman.charAt(0));

        int firstDigit = romanToDec(roman.charAt(0) + "");
        int secondDigit = romanToDec(roman.charAt(1) + "");

        // 2 digits
        if (roman.length() == 2)
        {
            if (firstDigit < secondDigit)
                return (secondDigit - firstDigit + romanToDec(roman.substring(2)));

            // if (firstDigit > secondDigit)
            return (firstDigit + secondDigit + romanToDec(roman.substring(2)));
        }

        // 3 digits
        int thirdDigit = romanToDec(roman.charAt(2) + "");

        if (secondDigit < thirdDigit)
            return (firstDigit + romanToDec(roman.substring(1)));
        else
            return (romanToDec(roman.substring(0, 2)) + romanToDec(roman.substring(2)));

    }
}
