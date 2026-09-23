import java.util.*;
class Coursework5{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n				 __                     __           ");
		System.out.println("				|  \\                   |  \\          ");
		System.out.println("				 \\$$  _______  ______  | $$  _______ ");
		System.out.println("				|  \\ /       \\|      \\ | $$ /       \\");
		System.out.println("				| $$|  $$$$$$$ \\$$$$$$\\| $$|  $$$$$$$");
		System.out.println("				| $$| $$      /      $$| $$| $$      ");
		System.out.println("				| $$| $$_____|  $$$$$$$| $$| $$_____ ");
		System.out.println("				| $$ \\$$     \\\\$$    $$| $$ \\$$     \\");
		System.out.println("				 \\$$  \\$$$$$$$ \\$$$$$$$ \\$$  \\$$$$$$$\n");
		
		System.out.println("   _   _                 _                  _____                          _            ");
		System.out.println("  | \\ | |               | |                / ____|                        | |           ");
		System.out.println("  |  \\| |_   _ _ __ ___ | |__   ___ _ __  | |     ___  _ ____   _____ _ __| |_ ___ _ __ ");
		System.out.println("  | . ` | | | | '_ ` _ \\| '_ \\ / _ \\ '__| | |    / _ \\| '_ \\ \\ / / _ \\ '__| __/ _ \\ '__|");
		System.out.println("  | |\\  | |_| | | | | | | |_) |  __/ |    | |___| (_) | | | \\ V /  __/ |  | ||  __/ |   ");
		System.out.println("  |_| \\_|\\__,_|_| |_| |_|_.__/ \\___|_|     \\_____\\___/|_| |_|\\_/ \\___|_|   \\__\\___|_| ");
		System.out.println("\n==========================================================================================\n");
		
		System.out.println("[01] Decimal Converter");
		System.out.println("[02] Binary Converter");
		System.out.println("[03] Octal Converter");
		System.out.println("[04] Hexadecimal Converter");
		System.out.println("[05] Roman Number Converter\n");
		
		System.out.print("Enter Option ->");
		int option = input.nextInt();
		
		switch(option){
			

			case 1:
				System.out.println ("-----------------------------------------------------------------------------");
				System.out.println("|                     \t\t[01] Decimal Converter                       |");
				System.out.println ("-----------------------------------------------------------------------------");
				System.out.println ();
				System.out.print("Enter Decimal Number : ");
				int decimalNum=input.nextInt();
				if(decimalNum<0){
					System.out.println ("\tInvalid output...");
				}else{

				String binary="";
				String octal="";
				String hexa="";

				// Decimal -> Binary
				int temp=decimalNum;

				if(temp==0){
					binary="0";
				}else{
					while(temp>0){
						int r=temp%2;
						binary=r+binary;
						temp=temp/2;
        }
    }

    System.out.println("Binary No      : "+binary);

			// Decimal -> Octal
			int temp2=decimalNum;

			if(temp2==0){
				octal="0";
			}else{
				while(temp2>0){
					int r=temp2%8;
					octal=r+octal;
					temp2=temp2/8;
        }
    }

    System.out.println("Octal No       : "+octal);

			// Decimal -> Hexadecimal
			int temp3=decimalNum;

			if(temp3==0){
				hexa="0";
			}else{
				while(temp3>0){
					int r=temp3%16;

					if(r<10){
						hexa=r+hexa;
					}else{
						char ch=(char)(55+r);
						hexa=ch+hexa;
            }

            temp3=temp3/16;
        }
    }
	System.out.println("Hexadecimal No : "+hexa);
}
	
	
	

	System.out.print("\nDo you want to go Homepage (Y/N) -> ");
	char ans = input.next().charAt(0);

	if(ans=='Y' || ans=='y'){
		main(args);   // call main method (Home Page) 
		return; //don't execude old method(main) anymore
		
	/*if(ans.equalsIgnoreCase("Y")){ // 'y'='Y' 
    main(args);
    return;*/
	}

	// N -> case 2
	
    		System.out.println ();

			case 2: System.out.println ("---------------------------------------------------------------------------");
					System.out.println ("|                   \t	[02] Binary Converter                      |");
					System.out.println ("---------------------------------------------------------------------------");
					System.out.println ();
				    System.out.print("Enter a Binary Number : ");
					int binaryNum=input.nextInt();
					if(binaryNum>2     || binaryNum<0){
						System.out.println ("\tInvalid output...");
					}else{
						System.out.println ();  
						System.out.println ();
					
					
        
			
			
			
				break;
		    case 3: System.out.println ("\t	[03] Octal Converter");
				break;
		    case 4: System.out.println ("\t	[04] Hexadecimal Converter");
				break;
			case 5: System.out.println ("\t	[05] Roman Number Converter");
				break;
		}


		        
	}
}
