import java.util.*;
class Example{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		
		System.out.print("Input your age  : ");
		int age=input.nextInt();
		input.nextLine();
		System.out.print("Input your name : ");
		String name=input.nextLine();

		System.out.println("Name : "+name);
		System.out.println("Age  : "+age);
	}
}
