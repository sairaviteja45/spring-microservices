package armstrongNumbers;

public class ArmstrongNumbers {

    /**
     * armstrongNumbersFrom 1 To 99
     **/
    public static void armstrongNumbersFrom1To99() {
        System.err.println("Armstrong Numbers From 1 To 99:");

        boolean isFirst = true; // To handle comma separation
        for (int number = 1; number <= 99; number++) {
            int originalNumber = number;
            int sum = 0;
            if (number < 10) {
                sum = number; // single-digit numbers are Armstrong numbers
            } else {
                int numbers = number;
                while (numbers > 0) {
                    int lastNumber = numbers % 10;
                    sum += lastNumber * lastNumber * lastNumber;
                    numbers /= 10;
                }
            }

            if (sum == originalNumber) {
                if (!isFirst) {
                    System.err.print(", "); // Print comma before next number
                }
                System.err.print(number);
                isFirst = false; // Comma handling set after the first number
            }
        }
        System.err.println(); // For proper newline after the output
    }

    /**
     * armstrongNumbersFrom 100 To 1000
     **/
    public static void armstrongNumbersFrom100To1000() {
        System.err.println("Armstrong Numbers From 100 To 1000:");

        boolean isFirst = true; // To handle comma separation
        for (int number = 100; number < 1000; number++) {
            int originalNumber = number;
            int sum = 0;
            int numbers = number;

            // Calculate the sum of the cubes of the digits
            while (numbers > 0) {
                int lastNumber = numbers % 10;
                sum += lastNumber * lastNumber * lastNumber;
                numbers /= 10;
            }

            // Check if the sum equals the original number
            if (sum == originalNumber) {
                if (!isFirst) {
                    System.err.print(", "); // Print comma before next number
                }
                System.err.print(number);
                isFirst = false; // Comma handling set after the first number
            }
        }
        System.err.println(); // For proper newline after the output
    }


}
