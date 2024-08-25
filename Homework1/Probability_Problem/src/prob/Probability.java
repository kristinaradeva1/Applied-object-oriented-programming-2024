package prob;

public class Probability {
    public static void main(String[] args) {
        double allFiveDigitNums = 0;

        double dividableBy12 = 0;
        for(int firstDigit = 1; firstDigit <= 6; firstDigit++) {
            for(int secondDigit = 4; secondDigit <= 8; secondDigit++) {
                for(int thirdDigit = 3; thirdDigit <= 7; thirdDigit++) {
                    for(int fourthDigit = 1; fourthDigit <= 9; fourthDigit++) {
                        for(int fifthDigit = 1; fifthDigit <= 8; fifthDigit++) {
                            int currentNumberToCheck = firstDigit * 10_000 + secondDigit * 1000 + thirdDigit * 100
                                    + fourthDigit * 10 + fifthDigit;
                            if(currentNumberToCheck % 12 == 0) {
                                dividableBy12++;
                            }
                            allFiveDigitNums++;
                        }
                    }
                }
            }
        }
        String formattedString = String.format("All numbers that have these properties are: %.0f", allFiveDigitNums);
        double probability = dividableBy12 / allFiveDigitNums;
        String formattedString2 = String.format("The probability a five digit num to be dividable by 12 if it has" +
                " some properties is: %.3f", probability);
        System.out.println(formattedString);
        System.out.println(formattedString2);


    }

}