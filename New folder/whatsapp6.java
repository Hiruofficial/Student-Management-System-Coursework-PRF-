import java.util.Scanner;

public class whatsapp6 {

    static Scanner input = new Scanner(System.in);

    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // ignore
        }
    }

    public static void main(String[] args) {
        while (true) {
            clearConsole();
            System.out.println("======================================");
            System.out.println("        NUMBER CONVERTER MENU         ");
            System.out.println("======================================");
            System.out.println("1. Decimal Converter");
            System.out.println("2. Binary Converter");
            System.out.println("3. Octal Converter");
            System.out.println("4. Hexadecimal Converter");
            System.out.println("5. Roman Number Converter");
            System.out.println("0. Exit");
            System.out.print("Enter Option -> ");

            int option = readInt();

            switch (option) {
                case 1:
                    decimalConverter();
                    break;
                case 2:
                    binaryConverter();
                    break;
                case 3:
                    octalConverter();
                    break;
                case 4:
                    hexConverter();
                    break;
                case 5:
                    romanMenu();
                    break;
                case 0:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid option!");
                    pause();
            }
        }
    }

    static void decimalConverter() {
        clearConsole();
        System.out.println("Decimal Converter");
        System.out.print("Enter decimal number: ");
        int decimal = readInt();

        if (decimal < 0) {
            System.out.println("Invalid input!");
            pause();
            return;
        }

        System.out.println("Binary: " + Integer.toBinaryString(decimal));
        System.out.println("Octal: " + Integer.toOctalString(decimal));
        System.out.println("Hexadecimal: " + Integer.toHexString(decimal).toUpperCase());
        pause();
    }

    static void binaryConverter() {
        clearConsole();
        System.out.println("Binary Converter");
        System.out.print("Enter binary number: ");
        String binary = input.next();

        if (!binary.matches("[01]+")) {
            System.out.println("Invalid input!");
            pause();
            return;
        }

        int decimal = Integer.parseInt(binary, 2);
        System.out.println("Decimal: " + decimal);
        System.out.println("Octal: " + Integer.toOctalString(decimal));
        System.out.println("Hexadecimal: " + Integer.toHexString(decimal).toUpperCase());
        pause();
    }

    static void octalConverter() {
        clearConsole();
        System.out.println("Octal Converter");
        System.out.print("Enter octal number: ");
        String octal = input.next();

        if (!octal.matches("[0-7]+")) {
            System.out.println("Invalid input!");
            pause();
            return;
        }

        int decimal = Integer.parseInt(octal, 8);
        System.out.println("Decimal: " + decimal);
        System.out.println("Binary: " + Integer.toBinaryString(decimal));
        System.out.println("Hexadecimal: " + Integer.toHexString(decimal).toUpperCase());
        pause();
    }

    static void hexConverter() {
        clearConsole();
        System.out.println("Hexadecimal Converter");
        System.out.print("Enter hexadecimal number: ");
        String hex = input.next();

        if (!hex.matches("[0-9a-fA-F]+")) {
            System.out.println("Invalid input!");
            pause();
            return;
        }

        int decimal = Integer.parseInt(hex, 16);
        System.out.println("Decimal: " + decimal);
        System.out.println("Binary: " + Integer.toBinaryString(decimal));
        System.out.println("Octal: " + Integer.toOctalString(decimal));
        pause();
    }

    static void romanMenu() {
        clearConsole();
        System.out.println("Roman Number Converter");
        System.out.println("1. Decimal to Roman");
        System.out.println("2. Roman to Decimal");
        System.out.print("Enter option: ");
        int op = readInt();

        switch (op) {
            case 1:
                clearConsole();
                System.out.print("Enter decimal number: ");
                int num = readInt();
                if (num <= 0) {
                    System.out.println("Invalid input!");
                } else {
                    System.out.println("Roman: " + decimalToRoman(num));
                }
                pause();
                break;
            case 2:
                clearConsole();
                System.out.print("Enter roman number: ");
                String roman = input.next().toUpperCase();
                int dec = romanToDecimal(roman);
                if (dec == -1) {
                    System.out.println("Invalid Roman numeral!");
                } else {
                    System.out.println("Decimal: " + dec);
                }
                pause();
                break;
            default:
                System.out.println("Invalid option!");
                pause();
        }
    }

    static String decimalToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }
        return roman.toString();
    }

    static int romanToDecimal(String roman) {
        int total = 0;
        int prev = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char ch = roman.charAt(i);
            int value;

            switch (ch) {
                case 'I': value = 1; break;
                case 'V': value = 5; break;
                case 'X': value = 10; break;
                case 'L': value = 50; break;
                case 'C': value = 100; break;
                case 'D': value = 500; break;
                case 'M': value = 1000; break;
                default: return -1;
            }

            if (value < prev) {
                total -= value;
            } else {
                total += value;
            }
            prev = value;
        }
        return total;
    }

    static int readInt() {
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Enter a valid integer: ");
        }
        return input.nextInt();
    }

    static void pause() {
        System.out.print("Press Enter to continue...");
        input.nextLine();
        input.nextLine();
    }
}
