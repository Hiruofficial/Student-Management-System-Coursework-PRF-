import java.util.*;
class BillPrint{
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n ================================================================================ \n");
		System.out.println(" __          __  _                            _          _ __  __            _ ");
		System.out.println(" \\ \\        / / | |                          | |        (_)  \\/  |          | |");
		System.out.println("  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___    _| \\  / | __ _ _ __| |_");
		System.out.println("   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | | |\\/| |/ _` | '__| __|");
		System.out.println("    \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | | |  | | (_| | |  | |_");
		System.out.println("     \\/  \\/ \\___| |\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_|_|  |_|\\__,_|_|   \\__| \n");
		System.out.println("\n ================================================================================ \n");
		
		System.out.print("Enter Customer Phone Number : ");
		String phonenumber = input.next();
		
		System.out.println();
		
		System.out.print("Enter Customer Name : ");
		String name = input.next();
		
		System.out.println('\n');
		
		System.out.println("================================================================================= \n");
		
		System.out.print("BasmathiQty(Kg)   - ");
		int BasmathiQty = input.nextInt();
		
		System.out.print("DhalQty(Kg)       - ");
		int DhalQty = input.nextInt();
		
		System.out.print("SugarQty(Kg)      - ");
		int SugarQty = input.nextInt();
		
		System.out.print("HiglandQty        - ");
		int HiglandQty = input.nextInt();
		
		System.out.print("YoghurtQty        - ");
		int YoghurtQty = input.nextInt();
		
		System.out.print("FlourQty(Kg)      - ");
		int FlourQty = input.nextInt();
		
		System.out.print("SoapQty           - ");
		int SoapQty = input.nextInt();
		
		System.out.println('\n');
		
		double basmathiprice = 250.00;
		double dhalprice     = 180.00;
		double sugarprice    = 150.00;
		double higlandprice  = 1200.00;
		double yoghurtprice  = 50.00;
		double flourprice    = 120.00;
		double soapprice     = 160.00;
		
		double totBasmathiprice = basmathiprice * BasmathiQty;
		double totDhalprice = dhalprice * DhalQty;
		double totSugarprice = sugarprice * SugarQty;
		double totHiglandprice = higlandprice * HiglandQty;
		double totYoghurtprice = yoghurtprice * YoghurtQty;
		double totFlourprice = flourprice * FlourQty;
		double totSoapprice = soapprice * SoapQty;
		
		double total = totBasmathiprice + totDhalprice + totSugarprice + totHiglandprice + totYoghurtprice + totFlourprice + totSoapprice;
		
		double discount = total * 0.1;
		
		System.out.println();
		
		System.out.println("+----------------------------------------------------------------+");
		System.out.println("|               _   __  __          _____ _______                |");
		System.out.println("|              (_) |  \\/  |   /\\   |  __ \\__   __|               |");
		System.out.println("|               _  | \\  / |  /  \\  | |__) | | |                  |");
		System.out.println("|              | | | |\\/| | / /\\ \\ |  _  /  | |                  |");
		System.out.println("|              | | | |  | |/ ____ \\| | \\ \\  | |                  |");
		System.out.println("|              |_| |_|  |_/_/    \\_\\_|  \\_\\ |_|                  |");
		System.out.println("|                    222,Galle Road,Panadura.                    |");
		System.out.println("|                                                                |");
		System.out.println("+----------------------------------------------------------------+");
		System.out.printf ("|                        # Tel  : %-30s | \n",phonenumber);
		System.out.printf ("|                        # Name : %-30s | \n",name);
		System.out.println("+----------------+--------------+--------------+-----------------+");
		System.out.println("|                |     Qty      |  unit price  |      Price      |");
		System.out.println("+----------------+--------------+--------------+-----------------+");
		System.out.printf ("|   #Basmathi    |    %-4d      |    %-10.2f|     %-12.2f| \n" ,BasmathiQty, basmathiprice, totBasmathiprice);
		System.out.println("|                |              |              |                 |");
		System.out.printf ("|   #Dhal        |    %-4d      |    %-10.2f|     %-12.2f| \n" ,DhalQty, dhalprice, totDhalprice);
		System.out.println("|                |              |              |                 |");
		System.out.printf ("|   #Sugar       |    %-4d      |    %-10.2f|     %-12.2f| \n" ,SugarQty, sugarprice, totSugarprice);
		System.out.println("|                |              |              |                 |");
		System.out.printf ("|   #Higland     |    %-4d      |    %-10.2f|     %-12.2f| \n" ,HiglandQty, higlandprice, totHiglandprice);
		System.out.println("|                |              |              |                 |");
		System.out.printf ("|   #Yoghurt     |    %-4d      |    %-10.2f|     %-12.2f| \n" ,YoghurtQty, yoghurtprice, totYoghurtprice);
		System.out.println("|                |              |              |                 |");
		System.out.printf ("|   #Flour       |    %-4d      |    %-10.2f|     %-12.2f| \n" ,FlourQty, flourprice, totFlourprice);
		System.out.println("|                |              |              |                 |");
		System.out.printf ("|   #Soap        |    %-4d      |    %-10.2f|     %-12.2f| \n" ,SoapQty, soapprice, totSoapprice);
		System.out.println("|                |              |              |                 |");
		System.out.println("+-------------------------------+--------------+-----------------+");
		System.out.printf ("|                               | Total        |   %-14.2f| \n" ,total);
		System.out.println("|                               +--------------+-----------------+");
		System.out.printf ("|                               | discount(10%%)|    %-13.2f| \n" ,discount);
		System.out.println("|                               +--------------+-----------------+");
		System.out.printf ("|                               | Price        |    %-13.2f| \n",(total-discount) );
		System.out.println("+-------------------------------+--------------+-----------------+");
	}
}

