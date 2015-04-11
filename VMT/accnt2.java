import java.io.*;
import java.util.*;
class accnt2
{
	long mobno;
	String name;
	String dob;
	String sex;
	String acno;
	double bal;
	String password;
	String bankacnt;
	
	
	public static void main(String args[]) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
       		BufferedReader br = new BufferedReader(isr);
		double h;String val2,val3,val4,val5,val6,val7,t1,t2,val8,val9,t,val10,val11,val12,d,m,s,u;
		int count=0,count1=25,count2=0,count3=0,x=0,y=0;
		accnt[] a=new accnt[1];
		for (int i=0;i<a.length;i++)
		{
    			a[i] = new accnt();
		}
		PrintWriter p=new PrintWriter(new FileOutputStream(args[0],true),true);
		BufferedReader ob=new BufferedReader(new FileReader("account2.txt"));
		while((t=ob.readLine())!=null)
		{
			count=count+1;
			count1=count1+1;
		}
		System.out.println(count);
		 for (int i=0;i<a.length;i++)
       		 {
          	  		if(count!=0)
				{
					p.println();
				}
			
		
			System.out.println("Enter Customer Name : ");
          	  	a[i].name = br.readLine();
			
				p.print(a[i].name);
				p.flush();
                         do
			{
				if(count3==0)
				{
					System.out.println("Enter date of birth:  DDMMYYYY");
         		 	 	m =a[i].dob= br.readLine();
				 	s= m.substring(0,2);
				 	x= Integer.parseInt(s);
				 	u= m.substring(2,4);
				 	y= Integer.parseInt(u);
					if(x<= 31 && y<=12)
					{
						p.print(" "+a[i].dob);  
						p.flush();
					}
				}
				else if(x>31  ||y>12)
				{
				 	System.out.println("enter valid date");
				 	m =a[i].dob= br.readLine();
				 	s= m.substring(0,2);
				 	x= Integer.parseInt(s);
				 	u= m.substring(2,4);
				 	y= Integer.parseInt(u);
					if(x<= 31 && y<=12)
					{
						p.print(" "+a[i].dob);  
						p.flush();
					}
				}
				count3=count3+1;
			}while(x>31 || y>12);
			
			do
			{
				if(count2==0)
				{
					System.out.println("Enter mobile number : ");
					d= br.readLine();
          	 	 		a[i].mobno = Long.parseLong(d);
					char[] ch = d.toCharArray();
				}
				else
				{
					System.out.println("enter valid no");
					d= br.readLine();
          	 	 		a[i].mobno = Long.parseLong(d);
					char[] ch = d.toCharArray();
				}
				count2= count2+1;
			
			}while((d.length())!=10);

			if((d.length())==10)
			{
			p.print(" "+a[i].mobno);
			p.flush();
			}
			
			System.out.println("Enter sex : M/F ");
			a[i].sex=br.readLine();
			p.print(" "+a[i].sex);
			p.flush();
			h=((a[i].mobno%1000)+(10*i));
			a[i].acno="b3"+h+count+count1;
			System.out.println("account number generated : "+a[i].acno);
			p.print(" "+a[i].acno);
			p.flush();	
			System.out.println("enter the balance :");
			a[i].bal = Double.parseDouble(br.readLine());
			p.print(" "+a[i].bal);
			p.flush();
			char[] ch1 = a[i].name.toCharArray();
			char[] ch2 = a[i].dob.toCharArray();
			char[] ch3 = a[i].sex.toCharArray();
			char[] ch4 = a[i].acno.toCharArray();
			
			t1=Character.toString(ch1[0]);
			t2=Character.toString(ch1[1]);
			val2=Character.toString(ch1[2]);
			
			val3=Character.toString(ch2[6]);
			val4=Character.toString(ch2[7]);
			val5=Character.toString(ch3[0]);
			val6=Character.toString(ch4[0]);
			val7=Character.toString(ch4[1]);
			val8=Character.toString(ch4[2]);
			val9=Character.toString(ch4[3]);
			a[i].password=t1+t2+val2+val3+val4+val5+val6+val7+val8+count;
			
			System.out.println("password generated : "+a[i].password);			
      		  	p.print(" "+a[i].password);
			p.flush();
			System.out.println("enter the bank account number :");
			a[i].bankacnt=br.readLine();
			p.print(" "+a[i].bankacnt);
			p.flush();
			//count=count+1;

		}
	}
}	

