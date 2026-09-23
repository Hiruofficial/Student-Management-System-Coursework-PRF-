import java.util.*;

class Coursework6 {

    public final static void clearConsole() { 
        try {
            final String os = System.getProperty("os.name"); 
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); 
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        L1: do {
            clearConsole();
            System.out.println("\n\n\n\t\t\t\t\t __  ______             __");         
            System.out.println("\t\t\t\t\t|  \\ /      \\            |  \\");         
            System.out.println("\t\t\t\t\t \\$$|  $$$$$$\\  ______  | $$  _______");       
            System.out.println("\t\t\t\t\t|  \\| $$   \\$$ |      \\ | $$ /       \\");       
            System.out.println("\t\t\t\t\t| $$| $$        \\$$$$$$\\| $$|  $$$$$$$");       
            System.out.println("\t\t\t\t\t| $$| $$   __  /      $$| $$| $$");             
            System.out.println("\t\t\t\t\t| $$| $$__/  \\|  $$$$$$$| $$| $$_____");        
            System.out.println("\t\t\t\t\t| $$ \\$$    $$ \\$$    $$| $$ \\$$     \\");       
            System.out.println("\t\t\t\t\t \\$$  \\$$$$$$   \\$$$$$$$ \\$$  \\$$$$$$$");       
                                                                
            System.out.println("\n   _   _                        _                         _____                                         _");                  
            System.out.println("  | \\ | |                      | |                       / ____|                                       | |");                 
            System.out.println("  |  \\| |  _   _   _ __ ___    | |__     ___    _ __    | |        ___    _ __   __   __   ___    _ __  | |_    ___    _ __"); 
            System.out.println("  | . ` | | | | | | '_ ` _ \\   | '_ \\   / _ \\ | '__|   | |       / _ \\  | '_ \\  \\ \\ / /  / _ \\ | '__| | __|  / _ \\ | '__|");
            System.out.println("  | |\\  | | |_| | | | | | | |  | |_) | |  __/ | |      | |____  | (_) | | | | |  \\ V /  |  __/ | |    | |_  |  __/ | |");   
            System.out.println("  |_| \\_|  \\__,_| |_| |_| |_|  |_.__/   \\___| |_|       \\_____|  \\___/  |_| |_|   \\_/    \\___| |_|     \\__|  \\___| |_|");   
            System.out.println("\n===========================================================================================================================");                                                                                                                                           
            
            System.out.println("\n\n\n\t[01] Decimal Converter");
            System.out.println("\n\t[02] Binary Converter");
            System.out.println("\n\t[03] Octal Converter");
            System.out.println("\n\t[04] Hexadecimal Converter");
            System.out.println("\n\t[05] Roman Number Converter");
            System.out.println("\n\t[06] Exit");

            System.out.print("\n\nEnter Option -> ");
            int option = input.nextInt();

            switch (option) {
                case 1: // Decimal Converter
                    L2: do {
                        clearConsole();
                        System.out.println("+-------------------------------------------+");
                        System.out.println("|             Decimal Converter             |");
                        System.out.println("+-------------------------------------------+");
                        System.out.print("\n\nEnter a Decimal number: ");
                        int decimal = input.nextInt();

                        if (decimal < 0) {
                            System.out.println("\tInvalid input (must be non-negative)...");
                            System.out.print("\nDo you want to input number again (Y/N) -> ");
                            char c = input.next().charAt(0);
                            if (c == 'Y' || c == 'y') continue L2;
                            else continue L1;
                        }

                        // Decimal to Binary
                        int binary = 0, base = 1, temp2 = decimal;
                        while (temp2 > 0) {
                            binary += (temp2 % 2) * base;
                            temp2 /= 2;
                            base *= 10;
                        }
                        System.out.println("\n\tBinary number: " + binary);

                        // Decimal to Octal
                        int octal = 0, base1 = 1, temp3 = decimal;
                        while (temp3 > 0) {
                            octal += (temp3 % 8) * base1;
                            temp3 /= 8;
                            base1 *= 10;
                        }
                        System.out.println("\tOctal number: " + octal);

                        // Decimal to Hexadecimal
                        int temp4 = decimal;
                        String hex = "";
                        while (temp4 > 0) {
                            int rem = temp4 % 16;
                            hex = (rem < 10 ? rem : (char) (rem + 55)) + hex;
                            temp4 /= 16;
                        }
                        System.out.println("\tHexadecimal number: " + (hex.isEmpty() ? "0" : hex));

                        System.out.print("\n\nDo you want to go to homepage (Y/N)-> ");
                        char c = input.next().charAt(0);
                        if (c == 'Y' || c == 'y') continue L1;
                        else break L1;
                    } while (true);

                case 2: // Binary Converter
                    L3: do {
                        clearConsole();
                        System.out.println("+-------------------------------------------+");
                        System.out.println("|              Binary Converter             |");
                        System.out.println("+-------------------------------------------+");
                        System.out.print("\n\nEnter a Binary number: ");
                        int binaryNumber = input.nextInt();

                        // Validation
                        int temp = binaryNumber;
                        boolean isValid = binaryNumber >= 0;
                        while (temp > 0 && isValid) {
                            if (temp % 10 > 1) isValid = false;
                            temp /= 10;
                        }

                        if (!isValid) {
                            System.out.println("\tInvalid input (only 0 and 1 allowed)...");
                            System.out.print("\nDo you want to input number again (Y/N) -> ");
                            char c = input.next().charAt(0);
                            if (c == 'Y' || c == 'y') continue L3;
                            else continue L1;
                        }

                        // Binary to Decimal
                        int decimal = 0, base1 = 1, tempBin = binaryNumber;
                        while (tempBin > 0) {
                            int rem = tempBin % 10;
                            decimal += rem * base1;
                            base1 *= 2;
                            tempBin /= 10;
                        }
                        System.out.println("\n\tDecimal Number: " + decimal);

                        // Binary to Octal
                        int octal = 0, base2 = 1, temp3 = decimal;
                        while (temp3 > 0) {
                            octal += (temp3 % 8) * base2;
                            temp3 /= 8;
                            base2 *= 10;
                        }
                        System.out.println("\tOctal number: " + octal);

                        // Binary to Hexadecimal
                        int temp4 = decimal;
                        String hex = "";
                        while (temp4 > 0) {
                            int rem = temp4 % 16;
                            hex = (rem < 10 ? rem : (char) (rem + 55)) + hex;
                            temp4 /= 16;
                        }
                        System.out.println("\tHexadecimal number: " + (hex.isEmpty() ? "0" : hex));

                        System.out.print("\n\nDo you want to go to homepage (Y/N)-> ");
                        char c = input.next().charAt(0);
                        if (c == 'Y' || c == 'y') continue L1;
                        else break L1;
                    } while (true);

                case 3: // Octal Converter
                    L4: do {
                        clearConsole();
                        System.out.println("+-------------------------------------------+");
                        System.out.println("|               Octal Converter             |");
                        System.out.println("+-------------------------------------------+");
                        System.out.print("\n\nEnter an Octal number: ");
                        int octal = input.nextInt();

                        int temp = octal;
                        boolean isValid = octal >= 0;
                        while (temp > 0 && isValid) {
                            if (temp % 10 > 7) isValid = false;
                            temp /= 10;
                        }

                        if (!isValid) {
                            System.out.println("\tInvalid input (digits 0-7 allowed)...");
                            System.out.print("\nDo you want to input number again (Y/N) -> ");
                            char c = input.next().charAt(0);
                            if (c == 'Y' || c == 'y') continue L4;
                            else continue L1;
                        }

                        // Octal to Decimal
                        int decimal = 0, base = 1, tempOct = octal;
                        while (tempOct > 0) {
                            int rem = tempOct % 10;
                            decimal += rem * base;
                            base *= 8;
                            tempOct /= 10;
                        }
                        System.out.println("\n\tDecimal Number: " + decimal);

                        // Octal to Binary
                        int temp2 = decimal;
                        String binary = "";
                        while (temp2 > 0) {
                            binary = (temp2 % 2) + binary;
                            temp2 /= 2;
                        }
                        System.out.println("\tBinary Number: " + (binary.isEmpty() ? "0" : binary));

                        // Octal to Hexadecimal
                        String hex = "";
                        int tempDec = decimal;
                        while (tempDec > 0) {
                            int rem = tempDec % 16;
                            hex = (rem < 10 ? rem : (char) (rem + 55)) + hex;
                            tempDec /= 16;
                        }
                        System.out.println("\tHexadecimal Number: " + (hex.isEmpty() ? "0" : hex));

                        System.out.print("\n\nDo you want to go to homepage (Y/N)-> ");
                        char c = input.next().charAt(0);
                        if (c == 'Y' || c == 'y') continue L1;
                        else break L1;
                    } while (true);

                case 4: // Hexadecimal Converter
                    L5: do {
                        clearConsole();
                        System.out.println("+-------------------------------------------+");
                        System.out.println("|           Hexadecimal Converter           |");
                        System.out.println("+-------------------------------------------+");
                        System.out.print("\n\nEnter a Hexadecimal number : ");
                        String hex = input.next();

                        int decimal = 0;
                        boolean isValid = true;
                        for (int i = hex.length() - 1, j = 0; i >= 0; i--, j++) {
                            char c = hex.charAt(i);
                            int digit = 0;
                            if (c >= '0' && c <= '9') digit = c - '0';
                            else if (c >= 'A' && c <= 'F') digit = c - 'A' + 10;
                            else if (c >= 'a' && c <= 'f') digit = c - 'a' + 10;
                            else {
                                isValid = false;
                                break;
                            }
                            decimal += digit * Math.pow(16, j);
                        }

                        if (!isValid) {
                            System.out.println("\tInvalid Hexadecimal input...");
                            System.out.print("\nDo you want to input number again (Y/N) -> ");
                            char c = input.next().charAt(0);
                            if (c == 'Y' || c == 'y') continue L5;
                            else continue L1;
                        }

                        System.out.println("\n\tDecimal Number: " + decimal);

                        // Hexadecimal to Binary
                        int temp2 = decimal;
                        String binary = "";
                        while (temp2 > 0) {
                            binary = (temp2 % 2) + binary;
                            temp2 /= 2;
                        }
                        System.out.println("\tBinary Number: " + (binary.isEmpty() ? "0" : binary));

                        // Hexadecimal to Octal
                        int temp3 = decimal;
                        String octalStr = "";
                        while (temp3 > 0) {
                            octalStr = (temp3 % 8) + octalStr;
                            temp3 /= 8;
                        }
                        System.out.println("\tOctal Number: " + (octalStr.isEmpty() ? "0" : octalStr));

                        System.out.print("\n\nDo you want to go to homepage (Y/N)-> ");
                        char c = input.next().charAt(0);
                        if (c == 'Y' || c == 'y') continue L1;
                        else break L1;
                    } while (true);

                case 5: // Roman Converter
                    clearConsole();
                    System.out.println("+--------------------------------------------------------------+");
                    System.out.println("|                     Roman Number Converter                   |");
                    System.out.println("+--------------------------------------------------------------+");
                    System.out.println("\n\n\t[01] Decimal Number to Roman Number Converter");
                    System.out.println("\n\t[02] Roman Number to Decimal Number Converter");
                    System.out.print("\n\nEnter an option -> ");
                    int option2 = input.nextInt();

                    if (option2 == 1) {
                        L6: do {
                            clearConsole();
                            System.out.println("+------------------------------------------------------------------+");
                            System.out.println("|            Decimal Number to Roman Number Converter              |");
                            System.out.println("+------------------------------------------------------------------+");
                            System.out.print("\n\nEnter a Decimal number: ");
                            int num = input.nextInt();

                            if (num <= 0 || num > 3999) {
                                System.out.println("\tPlease enter a number between 1 and 3999.");
                                System.out.print("\nDo you want to input number again (Y/N) -> ");
                                char c = input.next().charAt(0);
                                if (c == 'Y' || c == 'y') continue L6;
                                else continue L1;
                            }

                            int temp = num;
                            String roman = "";
                            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
                            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

                            for (int i = 0; i < values.length; i++) {
                                while (temp >= values[i]) {
                                    roman += symbols[i];
                                    temp -= values[i];
                                }
                            }

                            System.out.println("\n\tRoman Number: " + roman);
                            System.out.print("\n\nDo you want to go to homepage (Y/N)-> ");
                            char c = input.next().charAt(0);
                            if (c == 'Y' || c == 'y') continue L1;
                            else break L1;
                        } while (true);
                    }
                    break;

                case 6:
                    System.out.println("\nExiting program. Goodbye!");
                    break L1;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        } while (true);

        input.close();
    }
}
