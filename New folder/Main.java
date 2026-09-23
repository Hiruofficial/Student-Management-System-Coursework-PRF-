import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        String result = ""; // store all outputs

        for (int i = 1; i <= T; i++) {

            int acceptedCount = 0;
            int totalWeight = 0;
            int largestWeight = 0;
            int rejectedCount = 0;

            while (true) {
                int weight = sc.nextInt();

                if (weight == 0) break;

                if (weight >= 1 && weight <= 20) {
                    acceptedCount++;
                    totalWeight += weight;

                    if (weight > largestWeight) {
                        largestWeight = weight;
                    }
                } else if (weight > 20) {
                    rejectedCount++;
                }
            }

            // store instead of print
            result += "Case #" + i + ": "
                    + acceptedCount + " "
                    + totalWeight + " "
                    + largestWeight + " "
                    + rejectedCount + "\n";
        }

        // print once at the end
        System.out.println(result);

        //sc.close();
    }
}
