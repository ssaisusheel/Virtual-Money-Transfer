import java.io.*;
class malls
{
	String name;
	String city;
	String area;
	String vmtcode;
	public static void main(String args[]) throws IOException
	{
		 InputStreamReader isr = new InputStreamReader(System.in);
       		 BufferedReader br = new BufferedReader(isr);
		malls[] m=new malls[1];
		int count=25;
		String t=" ";
		for (int i=0;i<m.length;i++)
		{
    			m[i] = new malls();
		}
		PrintWriter p=new PrintWriter(new FileOutputStream(args[0],true),true);
		BufferedReader ob=new BufferedReader(new FileReader(args[0]));
		while((t=ob.readLine())!=null)
		{
			count=count+1;
		}
		
		 for (int i=0;i<m.length;i++)
       		 {
			
			if(count==25)
			{
				p.print("");
			}
			else
			{
				p.println();
			}
			System.out.println("Enter Your Shopping Mall Name : ");
			m[i].name = br.readLine();
			p.print(m[i].name);
			p.flush();
			System.out.println("Enter the City :");
			 m[i].city = br.readLine();
			p.print(" "+m[i].city);
			p.flush();
			System.out.println("Enter the Area :");
			 m[i].area = br.readLine();
			p.print(" "+m[i].area);
			p.flush();
			m[i].vmtcode="vmt"+m[i].name+count;
			System.out.println("vmt vode generated : "+m[i].vmtcode);
			p.print(" "+m[i].vmtcode);
			p.flush();
			//p.println();
		
		}
		
		
	}
}	