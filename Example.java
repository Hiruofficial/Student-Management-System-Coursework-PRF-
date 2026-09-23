import java.util.*;
class Example{
	public static void main(String args[]){
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("|                        SALARY INFORMATION SYSTEM                             |");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("        [1] Calculate Income Tax");
		System.out.println("        [2] Calculate Annual Bonus");
		System.out.println("        [3] Calculate Loan amount\n");
		
		System.out.print("Enter an option to continue >");
		int option=input.nextInt();
		
		switch(option){
			case 1: System.out.println("--------------------------------------------------------------------------------");
					System.out.println("|                          Calculate Income Tax                                |");
					System.out.println("--------------------------------------------------------------------------------");
					break;
			case 2: System.out.println("--------------------------------------------------------------------------------");
					System.out.println("|                          Calculate Annual Tax                                |");
					System.out.println("--------------------------------------------------------------------------------");

		            System.out.print("Input Employee name   - ");
		            String name=input.next();
					System.out.print("Input Employee salary - ");
					double salary=input.nextDouble();
					double bonus;
					if(salary<100000){
						bonus=5000;
					}else if(salary<200000){
						bonus=salary*0.1;
					}else if(salary<300000){
						bonus=salary*0.15;
					}else if(salary<400000){
						bonus=salary*0.2;
					}else
						bonus=salary*0.35;
					}
						System.out.println("Annual bonus - "+bonus);
					break;
					
			case 3: System.out.println("--------------------------------------------------------------------------------");
					System.out.println("|                          Calculate Loan Tax                                  |");
					System.out.println("--------------------------------------------------------------------------------");
					break;
		}
	
	}
}
