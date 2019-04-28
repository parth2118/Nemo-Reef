import java.util.Scanner;
public class NemoReefTours {
	public static void main(String[] args) {
		System.out.println("Welcome to the Nemo Reef Tours Management System\n");
		Scanner scr=new Scanner(System.in);
		Scanner num=new Scanner(System.in);
		double[] charge=new double[4];
		int[] tickets=new int[4];
		String[] name=new String[4];
		double min=0,max=0,sum=0,avg=0,total=0;
		String minName,maxName;
		for(int i=0;i<4;i++)
		{
			do
			{
				System.out.print("\nPlease enter Booking Name "+(i+1)+" ==> ");
				name[i]=scr.nextLine();
				if(name[i].equals(""))
				{
					System.out.println("ERROR booking name cannot be blank");
				}
			}while(name[i].equals(""));
			do
			{
				System.out.print("Enter the number of passengers for "+name[i]+" ==> ");
				tickets[i]=num.nextInt();
				if(tickets[i]<=0)
				{
					System.out.println("ERROR number of passenegers must be greater than zero");
				}
			}while(tickets[i]<=0);
			if(tickets[i]<=2 && tickets[i]>=1)
			{
				charge[i]=85.5*tickets[i];
				System.out.println("The tour charges for "+name[i]+" for "+tickets[i]+" passenger<s> is $"+charge[i]);
			}
			else if(tickets[i]<=5 && tickets[i]>=3)
			{
				charge[i]=(85.50*tickets[i])-((85.50*tickets[i])/10);
				System.out.println("The tour charges for "+name[i]+" for "+tickets[i]+" passenger<s> is $"+charge[i]);
			}
			else if(tickets[i]<=10 && tickets[i]>=6)
			{
				charge[i]=(85.50*tickets[i])-((85.50*tickets[i]*15)/100);
				System.out.println("The tour charges for "+name[i]+" for "+tickets[i]+" passenger<s> is $"+charge[i]);
			}
			else
			{
				charge[i]=(85.50*tickets[i])-((85.50*tickets[i])/5);
				System.out.println("The tour charges for "+name[i]+" for "+tickets[i]+" passenger<s> is $"+charge[i]);
			}
		}
		min=tickets[0];
		minName=name[0];
		max=tickets[0];
		maxName=name[0];
		for(int i=1;i<4;i++)
		{
			if(tickets[i]<min)
			{
				min=tickets[i];
				minName=name[i];
			}
			else if(tickets[i]>max)
			{
				max=tickets[i];
				maxName=name[i];
			}
		}
		for(int i=0;i<4;i++)
		{
			sum=sum+tickets[i];
			total=total+charge[i];
		}
		avg=sum/4;
		System.out.println("\n\nStatistical information for Nemo Reef Tours\n");
		System.out.println("Booking: "+minName+" has the minimum number of "+min+" passenger<s>");
		System.out.println("Booking: "+maxName+" has the maximum number of "+max+" passenger<s>");
		System.out.println("The average number of passengers per booking is: "+avg+" passengers");
		System.out.println("The total charges collected is $"+total);
		System.out.println("\n\nThank you for using the Nemo Reef Tours Management System");
		System.out.println("Program written by Parth Shah");
	}
}
