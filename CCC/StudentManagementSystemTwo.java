import java.util.*;

public class StudentManagementSystemTwo {

    public static final int ENROLLMENTOPEN = 1;
    public static final int ENROLLMENTCLOSED = 0;

    // Updated batch initializers
    public static int[] batchNameArray = {100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
    public static int[] batchStatusArray = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};

    // Initialized student data arrays
    public static String[] regNoArray = {
            "PR24105001", "PR24105002", "PR24105003", "PR24105004", "PR24105005",
            "PR24105006", "PR24105007", "PR24105008", "PR24105009", "PR24105010",
            "OR24105011", "OR24105012", "OR24105013", "OR24105014", "OR24105015",
            "PR24105016", "PR24105017", "PR24105018", "OR24105019", "OR24105020",
            "PR24105021", "PR24105022", "OR24105023", "OR24105024", "PR24105025",
            "PR24106001", "PR24106002", "PR24106003", "PR24106004", "PR24106005",
            "PR24106006", "PR24106007", "PR24106008", "PR24106009", "PR24106010",
            "OR24106011", "OR24106012", "OR24106013", "OR24106014", "OR24106015",
            "PR24106016", "PR24106017", "PR24106018", "OR24106019", "OR24106020",
            "PR24106021", "PR24106022", "OR24106023", "OR24106024", "PR24106025",
            "PR24107001", "PR24107002", "PR24107003", "PR24107004", "PR24107005",
            "PR24107006", "PR24107007", "PR24107008", "PR24107009", "PR24107010",
            "OR24107011", "OR24107012", "OR24107013", "OR24107014", "OR24107015",
            "PR24107016", "PR24107017", "PR24107018", "OR24107019", "OR24107020",
            "PR24107021", "PR24107022", "OR24107023", "OR24107024", "PR24107025",
            "PR24108001", "PR24108002", "PR24108003", "PR24108004", "PR24108005",
            "PR24108006", "PR24108007", "PR24108008", "PR24108009", "PR24108010",
            "OR24108011", "OR24108012", "OR24108013", "OR24108014", "OR24108015",
            "PR24108016", "PR24108017", "PR24108018", "OR24108019", "OR24108020",
            "PR24108021", "PR24108022", "OR24108023", "OR24108024", "PR24108025",
            "PR24109001", "PR24109002", "PR24109003", "PR24109004", "PR24109005",
            "PR24109006", "PR24109007", "PR24109008", "PR24109009", "PR24109010",
            "OR24109011", "OR24109012", "OR24109013", "OR24109014", "OR24109015",
            "PR24109016", "PR24109017", "PR24109018", "OR24109019", "OR24109020",
            "PR24109021", "PR24109022", "OR24109023", "OR24109024", "PR24109025",
            "PR24110001", "PR24110002", "PR24110003", "PR24110004", "PR24110005",
            "PR24110006", "PR24110007", "PR24110008", "PR24110009", "PR24110010",
            "OR24110011", "OR24110012", "OR24110013", "OR24110014", "OR24110015",
            "PR24110016", "PR24110017", "PR24110018", "OR24110019", "OR24110020",
            "PR24110021", "PR24110022", "OR24110023", "OR24110024", "PR24110025"
    };

    public static String[] nicArray = {
            "199501012345", "199503153872", "199506202198", "199509102983", "199511258739",
            "199512303498", "199502183764", "199504223198", "199508153210", "199510293417",
            "199601102375", "199604182938", "199606243879", "199608142178", "199610312475",
            "199611173452", "199603293481", "199605083217", "199607232198", "199609192375",
            "199701212483", "199703132487", "199706253478", "199708083298", "199710243651",
            "199712152983", "199702182734", "199704293187", "199705142375", "199709083751",
            "199801032874", "199803232871", "199806193428", "199808013764", "199810242374",
            "199812302984", "199802152348", "199805213471", "199807172398", "199811283472",
            "199901122471", "199903052984", "199906213874", "199908093412", "199910273894",
            "199912153482", "199902202394", "199904163874", "199907293481", "199911083479",
            "200001112374", "200003143478", "200006293874", "200008103471", "200010252984",
            "200012043894", "200002193874", "200004212374", "200005183492", "200007153871",
            "200101232984", "200103083471", "200106273894", "200108123984", "200110043728",
            "200112213874", "200102253471", "200104103874", "200105293784", "200107202983",
            "200201013874", "200203253471", "200206143874", "200208083471", "200210293874",
            "200212183471", "200202103874", "200204123894", "200205283471", "200207153874",
            "200301093874", "200303283471", "200306153874", "200308123471", "200310083874",
            "200312243471", "200302273874", "200304203471", "200305123874", "200307213471",
            "200401153874", "200403123471", "200406293874", "200408083471", "200410213874",
            "200412153471", "200402203874", "200404273471", "200405143874", "200407183471",
            "200501023874", "200503193471", "200506153874", "200508213471", "200510083874",
            "200512293471", "200502123874", "200504153471", "200505283874", "200507173471",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200512345678", "199909876543", "199812346789", "200010203040", "200608789012",
            "200012345678", "199812345679", "199902345678", "199712345670", "200102345671",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200512345678", "199909876543", "199812346789", "200010203040", "200608789012",
            "200012345678", "199812345679", "199902345678", "199712345670", "200102345671",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678"
    };

    public static String[] nameArray = {
            "Gunawardena Weerasinghe", "Senanayake Silva", "Silva Kumara", "Kumara Herath", "Rathnayake Herath",
            "Wijesinghe Bandara", "Rajapaksha Herath", "Senanayake Karunaratne", "Karunaratne Jayasinghe",
            "Gunawardena Silva",
            "Weerasinghe Rajapaksha", "Silva Rathnayake", "Fernando Perera", "Kumara Abeysekera",
            "Ekanayake Rathnayake",
            "Herath Gunawardena", "Abeysekera Silva", "Weerasinghe Silva", "Jayasinghe Dias", "Bandara Rathnayake",
            "Silva Perera", "De Silva Dias", "Abeysekera Jayasinghe", "Rajapaksha Senanayake", "Kumara Karunaratne",
            "Silva Abeysekera", "Jayasinghe Bandara", "Rathnayake Kumara", "Weerasinghe Rajapaksha",
            "Senanayake Herath",
            "Perera Ekanayake", "Herath Jayasinghe", "Kumara Gunawardena", "Abeysekera Silva", "Dias Fernando",
            "Karunaratne Weerasinghe", "Ekanayake Bandara", "Rajapaksha Kumara", "Silva De Silva",
            "Gunawardena Rathnayake",
            "Bandara Karunaratne", "Fernando Perera", "De Silva Silva", "Rajapaksha Gunawardena", "Herath Weerasinghe",
            "Karunaratne Dias", "Jayasinghe Silva", "Senanayake Abeysekera", "Silva Jayasinghe", "Rathnayake Kumara",
            "Gunawardena Kumara", "Rajapaksha Silva", "Perera Jayasinghe", "Silva Ekanayake", "Dias Senanayake",
            "Herath Abeysekera", "Rathnayake Fernando", "Kumara Herath", "Weerasinghe Silva", "Senanayake Karunaratne",
            "Abeysekera Silva", "Bandara Gunawardena", "Karunaratne Weerasinghe", "Perera Herath", "Fernando Dias",
            "Weerasinghe Gunawardena", "Rathnayake Kumara", "Senanayake Fernando", "Silva Bandara", "Herath Rajapaksha",
            "Kumara Jayasinghe", "Abeysekera Perera", "Rathnayake Jayasinghe", "Kumara Weerasinghe",
            "Rajapaksha Ekanayake",
            "Fernando Rajapaksha", "Silva Gunawardena", "Perera Wijesinghe", "Herath Abeysekera",
            "Rajapaksha Ekanayake",
            "Karunaratne Silva", "Weerasinghe Fernando", "Silva Bandara", "Abeysekera Weerasinghe",
            "Kumara Karunaratne",
            "Dias Rajapaksha", "Herath Perera", "Rathnayake Gunawardena", "Ekanayake Jayasinghe", "Gunawardena Silva",
            "Rajapaksha Perera", "Karunaratne Jayasinghe", "Weerasinghe Abeysekera", "Rathnayake Fernando",
            "Kumara Herath",
            "Silva Weerasinghe", "Herath Karunaratne", "Abeysekera Silva", "Gunawardena Ekanayake",
            "Weerasinghe Kumara",
            "Weerasinghe Kumara", "Rajapaksha Abeysekera", "Gunawardena Perera", "Karunaratne Silva",
            "Herath Wijesinghe",
            "Rathnayake Ekanayake", "Silva Fernando", "Abeysekera Rajapaksha", "Fernando Bandara", "Perera Herath",
            "Weerasinghe Jayasinghe", "Silva Karunaratne", "Rathnayake Gunawardena", "Herath Kumara",
            "Abeysekera Silva",
            "Ekanayake Bandara", "Rajapaksha Fernando", "Gunawardena Weerasinghe", "Kumara Karunaratne", "Silva Dias",
            "Perera Weerasinghe", "Karunaratne Rajapaksha", "Jayasinghe Silva", "Rathnayake Perera", "Silva Ekanayake",
            "Silva Karunaratne", "Herath Fernando", "Kumara Jayasinghe", "Weerasinghe Perera", "Abeysekera Rajapaksha",
            "Rathnayake Karunaratne", "Ekanayake Bandara", "Gunawardena Perera", "Silva Wijesinghe",
            "Rajapaksha Jayasinghe",
            "Rathnayake Fernando", "Karunaratne Kumara", "Perera Silva", "Gunawardena Ekanayake", "Bandara Rajapaksha",
            "Silva Herath", "Rathnayake Weerasinghe", "Perera Gunawardena", "Herath Karunaratne", "Silva Rajapaksha",
            "Ekanayake Kumara", "Bandara Herath", "Weerasinghe Rajapaksha", "Karunaratne Abeysekera", "Perera Dias"
    };

    public static int[] prfMarksArray = {
            85, 39, -1, 72, 44,
            91, 60, 38, 95, 49,
            -1, 67, 23, 58, 88,
            81, 73, 29, 62, -1,
            79, 53, 94, 47, 35,
            93, 15, -1, 82, 45,
            88, 23, 79, 37, -1,
            68, 100, 59, 29, 92,
            12, 77, 38, 66, 9,
            84, 51, 32, -1, 97,
            95, -1, 63, 88, 32,
            76, 97, 54, -1, 23,
            90, 35, 81, 61, 44,
            67, 100, 17, 85, 29,
            70, 42, -1, 60, 86,
            86, 57, 91, 35, -1,
            76, 48, 94, 23, 69,
            -1, 80, 55, 88, 32,
            100, 67, 43, -1, 90,
            60, 77, 25, 71, 84,
            92, 68, 59, 85, 63,
            76, 91, 70, 84, 63,
            72, 89, 45, 81, 77,
            68, 63, 88, 75, 90,
            57, 79, 92, 62, 100,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2
    };

    public static int[] dbmsMarksArray = {
            66, 45, 93, 58, -1,
            37, 88, 21, 79, 40,
            76, 54, -1, 69, 92,
            25, 84, 33, 60, 71,
            59, -1, 98, 27, 48,
            35, 91, 60, -1, 72,
            49, 26, 80, 14, 89,
            67, -1, 31, 94, 53,
            78, 5, 90, 24, 86,
            39, -1, 61, 73, 100,
            38, 91, -1, 74, 55,
            82, 66, 49, 99, 13,
            80, 70, 93, 36, 59,
            85, 47, 90, -1, 22,
            77, 34, 63, 100, 29,
            79, 62, 87, -1, 54,
            46, 99, 39, 70, -1,
            75, 83, 58, 92, 30,
            91, 40, 63, 95, 68,
            -1, 66, 21, 88, 37,
            67, 91, 85, 73, 70,
            63, 76, 88, 55, 64,
            79, 80, 59, 92, 68,
            100, 77, 83, 45, 62,
            66, 59, 78, 85, 56,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2
    };
	//clear console
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

    public static void exit() {
        clearConsole();
        System.out.println("\n\t\tYou left the program...\n");
        System.exit(0);
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
        if (m >= 80) return 4.00;
        if (m >= 75) return 3.70;
        if (m >= 70) return 3.30;
        if (m >= 65) return 3.00;
        if (m >= 60) return 2.70;
        if (m >= 55) return 2.30;
        if (m >= 50) return 2.00;
        if (m >= 45) return 1.70;
        if (m >= 40) return 1.30;
        if (m >= 30) return 1.00;
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


	public static void studentRegistrationReport() {
    Scanner input = new Scanner(System.in);

    do {
        clearConsole();
        System.out.println("------------------------------------------------------------");
        System.out.println(" \tStudent Registration Report");
        System.out.println("------------------------------------------------------------");

        // SORTING (by name)
        for (int i = 0; i < nameArray.length - 1; i++) {
            for (int j = i + 1; j < nameArray.length; j++) {

                if (nameArray[i].compareTo(nameArray[j]) > 0) {

                    // swap name
                    String tempName = nameArray[i];
                    nameArray[i] = nameArray[j];
                    nameArray[j] = tempName;

                    // swap regNo
                    String tempId = regNoArray[i];
                    regNoArray[i] = regNoArray[j];
                    regNoArray[j] = tempId;

                    // swap nic
                    String tempNic = nicArray[i];
                    nicArray[i] = nicArray[j];
                    nicArray[j] = tempNic;

                    // swap prf
                    int tempPrf = prfMarksArray[i];
                    prfMarksArray[i] = prfMarksArray[j];
                    prfMarksArray[j] = tempPrf;

                    // swap dbms
                    int tempDbms = dbmsMarksArray[i];
                    dbmsMarksArray[i] = dbmsMarksArray[j];
                    dbmsMarksArray[j] = tempDbms;
                }
            }
        }

        // PRINT
        System.out.printf("%-5s %-12s %-25s %-15s %-10s %-10s %-5s\n",
                "No", "Reg No", "Name", "NIC", "PRF", "DBMS", "GPA");

        for (int i = 0; i < nameArray.length; i++) {
            System.out.printf("%-5d %-12s %-25s %-15s %-10d %-10d %-5.2f\n",
                    (i + 1),
                    regNoArray[i],
                    nameArray[i],
                    nicArray[i],
                    prfMarksArray[i],
                    dbmsMarksArray[i],
                    calculateGPA(i));
        }

        System.out.print("\nDo you want to go back (Y/N): ");
        char ch = input.next().charAt(0);
        if (ch == 'Y' || ch == 'y') return;

    } while (true);
}


	public static void batchwiseStudentReport() {
    Scanner input = new Scanner(System.in);

    do {
        clearConsole();
        System.out.println("------------------------------------------------------------");
        System.out.println("\tBatch-wise Student Report");
        System.out.println("------------------------------------------------------------");

        // SHOW BATCHES
        for (int i = 0; i < batchNameArray.length; i++) {
            System.out.println((i + 1) + ") " + batchNameArray[i] + " Batch");
        }

        System.out.print("\nEnter batch option number: ");
        int choice = input.nextInt();

        // VALIDATION
        if (choice < 1 || choice > batchNameArray.length) {
            System.out.println("\nInvalid batch selection!");
            System.out.print("Press Enter to continue...");
            input.nextLine();
            input.nextLine();
            continue;
        }

        // batch number
        int selectedBatch = batchNameArray[choice - 1];

        System.out.printf("\n%-5s %-15s %-30s %-15s %-10s %-10s %-6s\n",
                "No", "Reg No", "Name", "NIC", "PRF", "DBMS", "GPA");

        int count = 1;

        for (int i = 0; i < regNoArray.length; i++) {

            int batch = Integer.parseInt(regNoArray[i].substring(4, 7));

            if (batch == selectedBatch) {

                // prf
                String prfText;
                if (prfMarksArray[i] == -1)
                    prfText = "Absent";
                else if (prfMarksArray[i] == -2)
                    prfText = "N/C";
                else
                    prfText = prfMarksArray[i] + "";

                // dbms
                String dbmsText;
                if (dbmsMarksArray[i] == -1)
                    dbmsText = "Absent";
                else if (dbmsMarksArray[i] == -2)
                    dbmsText = "N/C ";
                else
                    dbmsText = dbmsMarksArray[i] + "";

                System.out.printf("%-5d %-15s %-30s %-15s %-10s %-10s %-6.2f\n",
                        count++,
                        regNoArray[i],
                        nameArray[i],
                        nicArray[i],
                        prfText,
                        dbmsText,
                        calculateGPA(i));
            }
        }

        if (count == 1) {
            System.out.println("\nNo students found for this batch.");
        }

        System.out.print("\nDo you want another batch report (Y/N): ");
        char ch = input.next().charAt(0);
        if (ch != 'Y' && ch != 'y') return;

    } while (true);
}

    
    public static void industryTrainingEligibilityReport() {
    Scanner input = new Scanner(System.in);

    do {
        clearConsole();
        System.out.println("------------------------------------------------------------");
        System.out.println("\tIndustry Training Eligibility Report");
        System.out.println("------------------------------------------------------------");

        System.out.printf("%-5s %-12s %-25s %-15s %-10s %-10s %-5s\n",
                "No", "Reg No", "Name", "NIC", "PRF", "DBMS", "GPA");

        int count = 1;

        for (int i = 0; i < regNoArray.length; i++) {

            int prf = prfMarksArray[i];
            int dbms = dbmsMarksArray[i];
            double gpa = calculateGPA(i);

            if (prf >= 0 && dbms >= 0 &&
                prf > 50 && dbms > 50 &&
                gpa > 3.25) {

                System.out.printf("%-5d %-12s %-25s %-15s %-10d %-10d %-5.2f\n",
                        count++,
                        regNoArray[i],
                        nameArray[i],
                        nicArray[i],
                        prf,
                        dbms,
                        gpa);
            }
        }

        System.out.print("\nDo you want to go back (Y/N): ");
        char ch = input.next().charAt(0);
        if (ch == 'Y' || ch == 'y') return;

    } while (true);
    
}
    
    


    public static void reportManagement() {
		Scanner input = new Scanner(System.in);
        while (true) {
			clearConsole();
			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\tReport Generator\t\t\t|");
			System.out.println("-----------------------------------------------------------------\n");
    
			System.out.println("[1] Student Registration Report\n");
			System.out.println("[2] Batch-wise Student Report\n");
			System.out.println("[3] Industry Training Eligibility Report\n");
			System.out.println("[4] Exit\n");
			
			System.out.print("\nEnter an option to continue > ");
			 int option = input.nextInt();

            switch (option) {
                case 1:
                    studentRegistrationReport();
                    break;
                case 2:
                    batchwiseStudentReport();
                    break;
                case 3:
                    industryTrainingEligibilityReport();
                    break;
                case 4:
                    exit();
                    return;
                default:
                    System.out.println("Invalid Option!");
                    input.nextLine();
                    input.nextLine();
			}
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
                    exit();
                    return;
                default:
                    System.out.println("Invalid Option!");
                    input.nextLine();
                    input.nextLine();
            }
        }
    }
}

