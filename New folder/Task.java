import java.util.*;
class Task{
	public static void main(String args[]){
		System.out.println("#+------------------------------------------------------------+");
		System.out.println("#|	Boiled Chicken Packet Factory System                  |");
		System.out.println("#+------------------------------------------------------------+");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nEnter today's Manufacturing Price (Rs. per kg) : ");
		double manufacturingPrice = input.nextDouble();
		
		System.out.print("Enter today's Selling Price (Rs. per kg) : ");
		double sellingPrice = input.nextDouble();
		
		System.out.println("\nStarting Box 1...");
		
		
		System.out.println("\n#+------------------------------------------------------------+");
		System.out.println("#|				Box 1                         |");
		System.out.println("#+------------------------------------------------------------+");
		
		System.out.print("\nEnter packet weight (kg) [0 = box full, -1 = end day]: ");
		double packetWeight = input.nextDouble();
		if ( packetWeight < 0) {
            System.out.println("\tInvalid input...");
        }
		//for (double i = 0; i < packetWeight;){
			//packetWeight = 0;
			while(packetWeight>0){
				System.out.print("\nEnter packet weight (kg) [0 = box full, -1 = end day]: ");
				double packetWeight2 = input.nextDouble();
				packetWeight = packetWeight2;
				
                if (packetWeight2 == 0 ) break;
				else if ( packetWeight < 0) {
                    System.out.println("\tInvalid input...");
        }
				}
                

			//packetWeight++;
		
		System.out.println("#---------------Box 1 Report-----------------#");
		System.out.println("Total Packets   : ");
		System.out.println("Total Weights   : ");
		System.out.println("Maximum Weight  : ");
		System.out.println("Minimum Weight  : ");
		System.out.println("Average Weight  : ");
		System.out.println("#--------------------------------------------#");
				
		
		
		//System.out.println("");
		
	}
}
