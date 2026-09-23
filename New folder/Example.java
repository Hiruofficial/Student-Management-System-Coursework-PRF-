import java.util.*;
class Example{
	public static String[] id={"S001","S002","S003","S004","S005","S006","S007"};
	public static int[] marks={50,20,90,100,30,80,45};
	
	public static void main(String args[]){
		bestInMarks();
	}
	public static void bestInMarks(){
		int length=marks.length;
		int[] tempMark=new int[length];
		String[] tempId=new String[length];
		for (int i = 0; i < length; i++){
			tempMark[i]=marks[i];
			tempId[i]=id[i];
		}
		for(int i=tempMark.length-1; i>0; i--){
			for(int j=0; j<i; j++){
				if(tempMark[j]<tempMark[j+1]){
					int temp=tempMark[j];
					tempMark[j]=tempMark[j+1];
					tempMark[j+1]=temp;
					
					String tempStId=tempId[j];
					tempId[j]=tempId[j+1];
					tempId[j+1]=tempStId;
				}
			}
		}
		System.out.println("StID\tMarks");
		System.out.println("==============");
		for(int i=0; i<tempMark.length;i++){
			System.out.println(tempId[i]+"\t"+tempMark[i]);
		}
	}
}
