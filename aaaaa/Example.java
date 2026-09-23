import java.util.*;
class Example{
	
	public static String[] customerIDArray=new String [0];
	public static int[] billValueArray=new int [0];
	
	
	
	
	public static void main(String args[]){
	//public static void printId (String  args[]){
		while (true){
		
			Scanner input = new Scanner(System.in);
			System.out.print("Enter Customer ID (Enter -1 to stop) : ");        
			String id = input.nextLine();
		
			if(id.equals("-1")){
				break;
			}//else   
		
			System.out.print("Enter Bill Value : ");
			int bill = input.nextInt();
			
			
			//}
		}
		System.out.println("");
		System.out.println("\n Customer ID\t | Total Bill Value ");
		System.out.println("------------------------------------");
		//System.out.println(customerIDArray[i]);
		//System.out.println(billValueArray[i]);
	
	}
     
}


