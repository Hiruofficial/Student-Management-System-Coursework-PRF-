import java.util.*;

public class StudentManagementSystem {

    public static final int ENROLLMENTOPEN = 1;
    public static final int ENROLLMENTCLOSED = 0;

    // Updated batch initializers
    public static int[] batchNameArray = {100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
    public static int[] batchStatusArray = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};

    public static String[] regNoArray = {};
    public static String[] nicArray = {};
    public static String[] nameArray = {};
    public static int[] prfMarksArray = {};
    public static int[] dbmsMarksArray = {};

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

    public static void extendBatchArrays() {
        int[] temp1 = new int[batchNameArray.length + 1];
        int[] temp2 = new int[batchStatusArray.length + 1];

        for (int i = 0; i < batchNameArray.length; i++) {
            temp1[i] = batchNameArray[i];
            temp2[i] = batchStatusArray[i];
        }

        batchNameArray = temp1;
        batchStatusArray = temp2;
    }

    public static void extendStudentArrays() {
        String[] temp1 = new String[regNoArray.length + 1];
        String[] temp2 = new String[nicArray.length + 1];
        String[] temp3 = new String[nameArray.length + 1];
        int[] temp4 = new int[prfMarksArray.length + 1];
        int[] temp5 = new int[dbmsMarksArray.length + 1];

        for (int i = 0; i < regNoArray.length; i++) {
            temp1[i] = regNoArray[i];
            temp2[i] = nicArray[i];
            temp3[i] = nameArray[i];
            temp4[i] = prfMarksArray[i];
            temp5[i] = dbmsMarksArray[i];
        }

        regNoArray = temp1;
        nicArray = temp2;
        nameArray = temp3;
        prfMarksArray = temp4;
        dbmsMarksArray = temp5;
    }

    public static boolean checkBatchStatus(int b) {
        for (int i = 0; i < batchNameArray.length; i++) {
            if (b == batchNameArray[i]) {
                if (batchStatusArray[i] == ENROLLMENTOPEN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkNICIsExists(String nic) {
        for (int i = 0; i < nicArray.length; i++) {
            if (nic.equalsIgnoreCase(nicArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int isRegistrationNoExists(String id) {
        for (int i = 0; i < regNoArray.length; i++) {
            if (id.equalsIgnoreCase(regNoArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String generateStudentId(int b, int mode) {
        int count = 0;
        for (int i = 0; i < regNoArray.length; i++) {
            String id = regNoArray[i];
            String str = id.substring(4, 7);
            int bNo = Integer.parseInt(str);

            if (bNo == b) {
                count++;
            }
        }

        String pre = (mode == 1) ? "PR" : "OR";
        return pre + "26" + b + String.format("%03d", (count + 1));
    }

    public static void addStudentDetailsToArrays(String id, String n, String nic) {
        regNoArray[regNoArray.length - 1] = id;
        nameArray[nameArray.length - 1] = n;
        nicArray[nicArray.length - 1] = nic;
        prfMarksArray[prfMarksArray.length - 1] = -2;
        dbmsMarksArray[dbmsMarksArray.length - 1] = -2;
    }

    public static double getGPA(int m) {
        if (m >= 90) return 4.25;
        else if (m >= 80) return 4.00;
        else if (m >= 75) return 3.70;
        else if (m >= 70) return 3.30;
        else if (m >= 65) return 3.00;
        else if (m >= 60) return 2.70;
        else if (m >= 55) return 2.30;
        else if (m >= 50) return 2.00;
        else if (m >= 45) return 1.70;
        else if (m >= 40) return 1.30;
        else if (m >= 30) return 1.00;
        else return 0.70;
    }

    public static double calculateGPA(int i) {
        int prf = prfMarksArray[i];
        int dbms = dbmsMarksArray[i];

        double g1 = (prf >= 0) ? getGPA(prf) : 0.0;
        double g2 = (dbms >= 0) ? getGPA(dbms) : 0.0;

        return (g1 + g2) / 2;
    }

    public static void printStudentFullDetails(int i) {
        System.out.println("\tRegistration No     : " + regNoArray[i]);
        System.out.println("\tStudent Name        : " + nameArray[i]);
        System.out.println("\tStudent NIC         : " + nicArray[i]);

        if (prfMarksArray[i] == -2) {
            System.out.println("\tStudent PRF Marks   : Not Conducted");
        } else if (prfMarksArray[i] == -1) {
            System.out.println("\tStudent PRF Marks   : Absent");
        } else {
            System.out.println("\tStudent PRF Marks   : " + prfMarksArray[i]);
        }

        if (dbmsMarksArray[i] == -2) {
            System.out.println("\tStudent DBMS Marks  : Not Conducted");
        } else if (dbmsMarksArray[i] == -1) {
            System.out.println("\tStudent DBMS Marks  : Absent");
        } else {
            System.out.println("\tStudent DBMS Marks  : " + dbmsMarksArray[i]);
        }

        System.out.println("\tStudent GPA         : " + calculateGPA(i));
    }

    // =========================================================================
    // [1] STUDENT MANAGEMENT
    // =========================================================================

    public static void addStudent() {
        Scanner input = new Scanner(System.in);
        do {
            clearConsole();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\t\tAdd Student\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.print("Enter batch Number(Student should be added): ");
            int b = input.nextInt();

            if (checkBatchStatus(b)) {
                System.out.print("Enter Student NIC : ");
                String nic = input.next();

                if (checkNICIsExists(nic)) {
                    System.out.println("\tThis student is already added to the system...");
                } else {
                    System.out.print("Enter Student name : ");
                    String n = input.next();

                    System.out.print("Enter Lecturer Mode(1 - PHYSICAL / 0 - ONLINE) : ");
                    int mode = input.nextInt();

                    String id = generateStudentId(b, mode);
                    System.out.println("\tStudent Registration No - " + id);

                    extendStudentArrays();
                    addStudentDetailsToArrays(id, n, nic);
                }
            } else {
                System.out.println("\n\t Student cannot be added to this course because enrollment is closed....");
            }

            System.out.print("\nDo you want to add another student (Y/N): ");
            char ch = input.next().charAt(0);
            if (ch != 'Y' && ch != 'y') return;
        } while (true);
    }

    public static void updateStudent() {
        Scanner input = new Scanner(System.in);
        do {
            clearConsole();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tUpdate Student\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.print("Enter Student Registration No : ");
            String id = input.next();

            int idx = isRegistrationNoExists(id);

            if (idx == -1) {
                System.out.println("\n\tThis student does not exist in the system...");
            } else {
                System.out.println("\n\tStudent Name : " + nameArray[idx]);
                System.out.println("\tStudent NIC  : " + nicArray[idx] + "\n");

                System.out.println("What do you want to update?");
                System.out.println("\t(01) Student Name");
                System.out.println("\t(02) Student NIC");
                System.out.print("\nEnter option : ");
                int opt = input.nextInt();

                if (opt == 1) {
                    System.out.print("Enter new Student Name : ");
                    nameArray[idx] = input.next();
                    System.out.println("\n\tStudent Name updated successfully...");
                } else if (opt == 2) {
                    System.out.print("Enter new Student NIC : ");
                    String newNic = input.next();
                    if (checkNICIsExists(newNic)) {
                        System.out.println("\n\tThis NIC already exists!");
                    } else {
                        nicArray[idx] = newNic;
                        System.out.println("\n\tStudent NIC updated successfully...");
                    }
                }
            }

            System.out.print("\nDo you want to update another student details (Y/N): ");
            char ch = input.next().charAt(0);
            if (ch != 'Y' && ch != 'y') return;
        } while (true);
    }

    public static void viewStudentProfile() {
        Scanner input = new Scanner(System.in);
        do {
            clearConsole();
            System.out.println("------------------------------------------------");
            System.out.println("|\t\tView Student's Profile \t\t|");
            System.out.println("------------------------------------------------\n");

            System.out.print("Enter Student Registration No : ");
            String id = input.next();

            int idx = isRegistrationNoExists(id);

            if (idx >= 0) {
                printStudentFullDetails(idx);
            } else {
                System.out.println("\n\t This student does not exist in the system...");
            }

            System.out.print("\nDo you want to search another student details (Y/N): ");
            char ch = input.next().charAt(0);
            if (ch != 'Y' && ch != 'y') return;
        } while (true);
    }

    public static void deleteStudentProfile() {
        Scanner input = new Scanner(System.in);
        do {
            clearConsole();
            System.out.println("------------------------------------------------");
            System.out.println("|\t\tDelete Student Profile \t\t|");
            System.out.println("------------------------------------------------\n");

            System.out.print("Enter Student Registration No : ");
            String id = input.next();

            int idx = isRegistrationNoExists(id);

            if (idx == -1) {
                System.out.println("\n\tThis student does not exist in the system...");
            } else {
                printStudentFullDetails(idx);
                System.out.print("\nDo you want to delete this student (Y/N): ");
                char confirm = input.next().charAt(0);

                if (confirm == 'Y' || confirm == 'y') {
                    String[] t1 = new String[regNoArray.length - 1];
                    String[] t2 = new String[nameArray.length - 1];
                    String[] t3 = new String[nicArray.length - 1];
                    int[] t4 = new int[prfMarksArray.length - 1];
                    int[] t5 = new int[dbmsMarksArray.length - 1];

                    int k = 0;
                    for (int i = 0; i < regNoArray.length; i++) {
                        if (i == idx) continue;
                        t1[k] = regNoArray[i];
                        t2[k] = nameArray[i];
                        t3[k] = nicArray[i];
                        t4[k] = prfMarksArray[i];
                        t5[k] = dbmsMarksArray[i];
                        k++;
                    }

                    regNoArray = t1;
                    nameArray = t2;
                    nicArray = t3;
                    prfMarksArray = t4;
                    dbmsMarksArray = t5;

                    System.out.println("\n\tStudent deleted successfully...");
                }
            }

            System.out.print("\nDo you want to delete another student profile (Y/N): ");
            char ch = input.next().charAt(0);
            if (ch != 'Y' && ch != 'y') return;
        } while (true);
    }

    public static void studentManagement() {
        Scanner input = new Scanner(System.in);
        while (true) {
            clearConsole();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tStudent Management\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.println("[1] Add Student\n");
            System.out.println("[2] Update Student\n");
            System.out.println("[3] View Student Profile\n");
            System.out.println("[4] Delete Student Profile\n");
            System.out.println("[5] Exit\n");

            System.out.print("Enter an option to continue > ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    viewStudentProfile();
                    break;
                case 4:
                    deleteStudentProfile();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // =========================================================================
    // [2] BATCH MANAGEMENT
    // =========================================================================

    public static void addBatch() {
        Scanner input = new Scanner(System.in);
        do {
            clearConsole();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tAdd Batch\t\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.print("Enter Batch Number : ");
            int b = input.nextInt();

            boolean exists = false;
            for (int i = 0; i < batchNameArray.length; i++) {
                if (batchNameArray[i] == b) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                System.out.println("\n\tBatch already exists in the system...");
            } else {
                extendBatchArrays();
                batchNameArray[batchNameArray.length - 1] = b;
                batchStatusArray[batchStatusArray.length - 1] = ENROLLMENTOPEN;
                System.out.println("\n\tBatch added successfully...");
            }

            System.out.print("\nDo you want to add another batch (Y/N): ");
            char ch = input.next().charAt(0);
            if (ch != 'Y' && ch != 'y') return;
        } while (true);
    }

    public static void updateBatch() {
        Scanner input = new Scanner(System.in);
        do {
            clearConsole();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tUpdate Batch\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.print("Enter Batch Number : ");
            int b = input.nextInt();

            int idx = -1;
            for (int i = 0; i < batchNameArray.length; i++) {
                if (batchNameArray[i] == b) {
                    idx = i;
                    break;
                }
            }

            if (idx == -1) {
                System.out.println("\n\tThis batch does not exist in the system...");
            } else {
                String cur = (batchStatusArray[idx] == ENROLLMENTOPEN) ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
                String nxt = (batchStatusArray[idx] == ENROLLMENTOPEN) ? "ENROLLMENT CLOSED" : "ENROLLMENT OPEN";

                System.out.println("\nCurrent Status : " + cur);
                System.out.print("Do you want to change status to " + nxt + " (Y/N)? ");
                char confirm = input.next().charAt(0);

                if (confirm == 'Y' || confirm == 'y') {
                    batchStatusArray[idx] = (batchStatusArray[idx] == ENROLLMENTOPEN) ? ENROLLMENTCLOSED : ENROLLMENTOPEN;
                    System.out.println("\n\tBatch status updated successfully...");
                }
            }

            System.out.print("\nDo you want to update another batch (Y/N): ");
            char ch = input.next().charAt(0);
            if (ch != 'Y' && ch != 'y') return;
        } while (true);
    }

    public static void viewBatches() {
        Scanner input = new Scanner(System.in);
        clearConsole();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tView Batches\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------\n");

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-5s %-12s %-15s %-20s\n", "No", "Batch No", "Student Count", "Status");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < batchNameArray.length; i++) {
            int count = 0;
            String str = String.valueOf(batchNameArray[i]);
            for (int j = 0; j < regNoArray.length; j++) {
                if (regNoArray[j].substring(4, 7).equals(str)) {
                    count++;
                }
            }
            String st = (batchStatusArray[i] == ENROLLMENTOPEN) ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
            System.out.printf("%-5d %-12d %-15d %-20s\n", (i + 1), batchNameArray[i], count, st);
        }
        System.out.println("------------------------------------------------------------");

        System.out.print("\nPress Enter to return to main menu...");
        input.nextLine();
    }

    public static void batchManagement() {
        Scanner input = new Scanner(System.in);
        while (true) {
            clearConsole();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tBatch Management\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.println("[1] Add Batch\n");
            System.out.println("[2] Update Batch\n");
            System.out.println("[3] View Batches\n");
            System.out.println("[4] Exit\n");

            System.out.print("Enter an option to continue > ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    addBatch();
                    break;
                case 2:
                    updateBatch();
                    break;
                case 3:
                    viewBatches();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    // =========================================================================
    // [3] GRADE MANAGEMENT
    // =========================================================================

    public static void updateMarks(String sub) {
        Scanner input = new Scanner(System.in);
        do {
            clearConsole();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\t" + sub + " Marks Update\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.print("Enter Student Registration No : ");
            String id = input.next();

            int idx = isRegistrationNoExists(id);

            if (idx == -1) {
                System.out.println("\n\tThis student does not exist in the system...");
            } else {
                System.out.println("\n\tRegistration No : " + regNoArray[idx]);
                System.out.println("\tStudent Name    : " + nameArray[idx]);

                int cur = sub.equals("PRF") ? prfMarksArray[idx] : dbmsMarksArray[idx];

                if (cur >= 0) {
                    System.out.println("\tCurrent " + sub + " Marks : " + cur);
                } else if (cur == -1) {
                    System.out.println("\tCurrent " + sub + " Marks : Absent");
                } else {
                    System.out.println("\tCurrent " + sub + " Marks : Not Conducted");
                }

                System.out.print("\nEnter new " + sub + " Marks (-1 for Absent) : ");
                int mark = input.nextInt();

                if ((mark >= 0 && mark <= 100) || mark == -1) {
                    if (sub.equals("PRF")) {
                        prfMarksArray[idx] = mark;
                    } else {
                        dbmsMarksArray[idx] = mark;
                    }
                    System.out.println("\n\tMarks updated successfully...");
                } else {
                    System.out.println("\n\tInvalid Marks!");
                }
            }

            System.out.print("\nDo you want to update another student " + sub + " marks (Y/N): ");
            char ch = input.next().charAt(0);
            if (ch != 'Y' && ch != 'y') return;
        } while (true);
    }

    public static void gradeManagement() {
        Scanner input = new Scanner(System.in);
        while (true) {
            clearConsole();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tGrade Management\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.println("[1] PRF Marks Update\n");
            System.out.println("[2] DBMS Marks Update\n");
            System.out.println("[3] Exit\n");

            System.out.print("Enter an option to continue > ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    updateMarks("PRF");
                    break;
                case 2:
                    updateMarks("DBMS");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    // =========================================================================
    // [4] REPORT GENERATOR
    // =========================================================================

    public static void reportManagement() {
		Scanner input = new Scanner(System.in);
        while (true) {
        clearConsole();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tReport Generator\t\t\t|");
        System.out.println("-----------------------------------------------------------------\n");
		}
	}

    // =========================================================================
    // MAIN METHOD
    // =========================================================================

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            clearConsole();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tMain Menu\t\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");
            System.out.println("[1] Student Management\n");
            System.out.println("[2] Batch Management\n");
            System.out.println("[3] Grade Management\n");
            System.out.println("[4] Report Generator\n");
            System.out.println("[5] Exit\n");

            System.out.print("Enter an option to continue > ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    studentManagement();
                    break;
                case 2:
                    batchManagement();
                    break;
                case 3:
                    gradeManagement();
                    break;
                case 4:
                    reportManagement();
                    break;
                case 5:
                    System.out.println("\nExiting System.");
                    return;
                default:
                    System.out.println("Invalid Option!");
                    input.nextLine();
                    input.nextLine();
            }
        }
    }
}


