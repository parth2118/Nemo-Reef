import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
class Booking
{
	private String bookingName;
	private int passengers;
	double charge;
	Booking(){};
	Booking(String bookingName,int passengers)
	{
		this.bookingName=bookingName;
		this.passengers=passengers;
	}
	void setName(String bookingName)
	{
		this.bookingName=bookingName;
	}
	void setPassengers(int passengers)
	{
		this.passengers=passengers;
	}
	String getName()
	{
		return bookingName;
	}
	int getPassengers()
	{
		return passengers;
	}
	double calculatecharges(int a)
	{
		if(a==1 || a==2)
		{
			charge=85.5*a;
		}
		else if(a>=3 && a<=5)
		{
			charge=(85.5*a)-((85.5*a)/10);
		}
		else if(a>=6 && a<=10)
		{
			charge=(85.5*a)-((15*85.5*a)/100);
		}
		else if(a>10)
		{
			charge=(85.5*a)-((85.5*a)/5);
		}
		return charge;
	}
}
public class NemoReefTourMenu {
	public static void main(String[] args){
		System.out.println("Welcome to the Nemo Reef Tours Management System\n");
		Booking[] cust=new Booking[10];
		for(int i=0;i<cust.length;i++)
		{
			cust[i]=new Booking();
		}
		Scanner scr=new Scanner(System.in);
		Scanner num=new Scanner(System.in);
		String x=null;
		order:
		while(true)
		{
			System.out.println("\nPlease select from the following");
			System.out.println("1)Enter booking name & number of passengers");
			System.out.println("2)Display all booking names, number of passengers & charges");
			System.out.println("3)Display Statistics");
			System.out.println("4)Search for booking");
			System.out.println("5)Sort the bookings");
			System.out.println("6)Exit the application");
			System.out.print("Enter choice ==> ");
			int a=num.nextInt();
			switch(a)
			{
				case 1:
					int count=0;
					for(int i=0;i<cust.length;i++)
					{
						if(cust[i].getName()==null)
						{
							count++;
						}
					}
					if(count!=0)
					{
						for(int i=0;i<cust.length;i++)
						{
							if(cust[i].getName()==null)
							{
								String n = null;
								String d = "";
								do
								{
									JTextField name=new JTextField();
									Object[] field1= {"Please enter the booking name : ",name};
									int result1=JOptionPane.showConfirmDialog(null,field1,"Input Booking Name",JOptionPane.OK_CANCEL_OPTION);
									if(result1 == -1 || result1 == JOptionPane.CANCEL_OPTION)
									{
										System.exit(-1);
									}
									//System.out.print("Please enter the booking name: ");
									//n=scr.nextLine();
									else if(result1 == JOptionPane.OK_OPTION)
									{
										n=name.getText();
										if(n.equals(""))
										{
											JOptionPane.showMessageDialog(null,"Error - Booking name cannot be blank");
											//System.out.println("Booking name cannot be blank");
										}
									}
								}while(n.equals(""));
								int dn=0;
								do
								{
									JTextField pass=new JTextField();
									Object[] field2={"Enter the number of passengers",pass};
									int result2=JOptionPane.showConfirmDialog(null,field2,"Input Number of Passengers",JOptionPane.OK_CANCEL_OPTION);
									if(result2 == -1 || result2 == JOptionPane.CANCEL_OPTION)
									{
										System.exit(-1);
									}
									else if(result2 == JOptionPane.OK_OPTION)
									{
										d=pass.getText();
										if(d.equals(""))
										{
											d="10";
										}
										if(d.equals("10"))
										{
											JOptionPane.showMessageDialog(null,"Error - Number of passengers cannot be blank.");
											continue;
											//System.out.println("Number of passengers cannot be blank");
										}
										dn=Integer.parseInt(d);
										if(dn<=0)
										{
											JOptionPane.showMessageDialog(null,"Error - Number of passengers must be at least 1");
											//System.out.println("Number of passengers must be at least 1");
										}
									}
								}while(dn<=0 || d.equals("10"));
								cust[i].setName(n);
								cust[i].setPassengers(Integer.parseInt(d));
								cust[i].calculatecharges(cust[i].getPassengers());
								System.out.println("\nDetails for booking "+(i+1)+" entered");
								System.out.println("Booking Name\tPassengers\tCharge");
								System.out.println(cust[i].getName()+"\t"+cust[i].getPassengers()+"\t\t$"+cust[i].charge);
								continue order;
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Maximum number of bookings has been reached");
						//System.out.println("Maximum number of bookings has been reached");
					}
				break;
				case 2:
					int count1=0;
					for(int i=0;i<cust.length;i++)
					{
						if(cust[i].getName()!=null)
						{
							count1++;
						}
					}
					if(count1>=1)
					{
						System.out.println("\nBooking Name\tPassengers\tCharge");
						for(int i=0;i<cust.length;i++)
						{
							if(cust[i].getName()!=null)
							{
								System.out.println(cust[i].getName()+"\t"+cust[i].getPassengers()+"\t\t$"+cust[i].charge);
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"You must enter at least one booking.");
						//System.out.println("You must enter at least one booking");
					}
				break;
				case 3:
					int count2=0;
					for(int i=0;i<cust.length;i++)
					{
						if(cust[i].getName()!=null)
						{
							count2++;
						}
					}
					if(count2>=1)
					{
						System.out.println("\nStatistics for Nemo Reef Tours");
						int sum=0,count3=0;
						double total=0;
						int max=cust[0].getPassengers();
						String maxName=cust[0].getName();
						int min=cust[0].getPassengers();
						String minName=cust[0].getName();
						for(int i=1;i<cust.length;i++)
						{
							if(cust[i].getName()!=null)
							{
								if(cust[i].getPassengers()>max)
								{
									max=cust[i].getPassengers();
									maxName=cust[i].getName();
								}
								else if(cust[i].getPassengers()<min)
								{
									min=cust[i].getPassengers();
									minName=cust[i].getName();
								}
							}
						}
						for(int i=0;i<cust.length;i++)
						{
							if(cust[i].getName()!=null)
							{
								sum+=cust[i].getPassengers();
								total+=cust[i].charge;
								count3++;
							}
						}
						float avg=(float)sum/count3;
						System.out.println(maxName+" has the maximum number of "+max+" passenger<s>");
						System.out.println(minName+" has the minimum number of "+min+" passenger<s>");
						System.out.println("Average number of passengers "+avg);
						System.out.println("The total charges are: $"+total);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"You must enter at least one booking");
						//System.out.println("You must enter at least one booking");
					}
				break;
				case 4:
					int count4=0;
					for(int i=0;i<cust.length;i++)
					{
						if(cust[i].getName()!=null)
						{
							count4++;
						}
					}
					if(count4>=1)
					{
						JTextField names=new JTextField();
						Object[] field3= {"Please enter the booking name : ",names};
						int result3=JOptionPane.showConfirmDialog(null,field3,"Input Booking Name",JOptionPane.OK_CANCEL_OPTION);
						if(result3 == -1 || result3 == JOptionPane.CANCEL_OPTION)
						{
							System.exit(-1);
						}
						//System.out.print("\nPlease enter the booking name: ");
						//String x=scr.nextLine();
						else if(result3 == JOptionPane.OK_OPTION)
						{
							x=names.getText();
							for(int i=0;i<cust.length;i++)
							{
								if(cust[i].getName()!=null)
								{
									if(cust[i].getName().equalsIgnoreCase(x))
									{
										System.out.println("\nBooking found");
										System.out.println("Booking Name\tPassengers\tCharge");
										System.out.println(cust[i].getName()+"\t"+cust[i].getPassengers()+"\t\t"+cust[i].charge);
										break;
									}
									else
									{
										JOptionPane.showMessageDialog(null,x+" not found");
										//System.out.println("\n"+x+" not found");
										break;
									}
								}
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"You must enter at least one booking");
						//System.out.println("You must enter at least one booking");
					}
				break;
				case 5:
					int count5=0;
					for(int i=0;i<cust.length;i++)
					{
						if(cust[i].getName()!=null)
						{
							count5++;
						}
					}
					if(count5>=2)
					{
					    Booking temp=new Booking();
						for(int i=0;i<cust.length;i++) 
				        {
				            for(int j=i+1;j<cust.length;j++) 
				            { 
				                if(cust[i].getName()!=null && cust[j].getName()!=null)
				                {
				                	if(cust[i].getName().compareTo(cust[j].getName())>0) 
				                	{
				                		temp=cust[i];
				                		cust[i]=cust[j];
				                		cust[j]=temp;
				                	}
				                }
				            }
				        }
					    System.out.println("\nBookings sorted\n");
					    System.out.println("Booking Name\tPassengers\tCharge");
						for(int i=0;i<cust.length-1;i++) 
				        {
					    	if(cust[i].getName()!=null)
							{
								System.out.println(cust[i].getName()+"\t"+cust[i].getPassengers()+"\t\t$"+cust[i].charge);
							}
				        }
					}
					else
					{
						JOptionPane.showMessageDialog(null,"You must enter at least two bookings to sort");
						//System.out.println("You must enter at least two bookings to sort");
					}
				break;
				case 6:
					System.out.println("\n\nThank you for using the Nemo Reef Tours Management System");
					System.out.println("Program written by Parth Shah");
					System.out.println("\nPress any key to continue . . .");
					System.exit(0);
				break;
				default:
					System.out.println("\nInvalid Choice");	
				break;
			}
		}
	}
}