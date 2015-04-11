import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.util.*;
/*
<applet code="my" width=700 height=500>
</applet>
*/
class newframe4 extends Frame implements ActionListener,ItemListener
{
	String ba,val,t1,akt,val2,str,rip,bk,shoppe,val9,trmx;
	double bill,vle,d,rep;
	int count=0,count1=0,linenos=0;
	newframe4(String title,String billamt,String acct,String bank,String shp)
	{
			super(title);
			MyWindowAdapter4 r= new MyWindowAdapter4(this);
			addWindowListener(r);
			ba=billamt;
			akt=acct;
			bk=bank;
			shoppe=shp;
			bill=Double.parseDouble(billamt);
			try
			{
			BufferedReader obr=new BufferedReader(new FileReader("mallaccnts.txt"));
						
			while((trmx=obr.readLine())!=null)
			{
				linenos++;
				StringTokenizer stx3= new StringTokenizer(trmx," ");
				val9=stx3.nextToken();
				if(val9.equals(shoppe))
				{
					System.out.println("found at line" + linenos);
					break;
				}
			}
			}
			catch(Exception e){ };
						
		try
		{
			//PROGRAM REQUIRES RECORDS TO BE EXISTING IN THE FILE 
		
			FileInputStream fos=new FileInputStream("mallaccnts.txt");
			int linee_no=linenos;//nos start from 1
			long bytes=fos.available();
			for(int i=0;i<(linee_no-1);)
			{
				int o;							
				o=fos.read();
				if(o!=-1)
				{
					char t=(char)o;
					if(t=='\n')
						i++;
				}
				else
					break;
			}
			long finalw=fos.available();
			finalw=bytes-finalw;
			int o=0;
			String line_to_be_changed="";
			do
			{
				o=fos.read();
				if(o!=-1)
				{
					char t=(char)o;
					
				 if(t!='\n')
						line_to_be_changed+=t;
					else
						break;
				}
				else
					break;
			}while(o!=-1);
			//length of existing line
			int init_size=line_to_be_changed.length();
			RandomAccessFile op=new RandomAccessFile("mallaccnts.txt","rw");
			
			//number that you want to write must be converted to a char array with each char
			//of the array being the each digit of the number and then each of these
			//characters are written one at a time
	
			StringTokenizer str=new StringTokenizer(line_to_be_changed," \n",false);
			String firstname=str.nextToken(); 
			
			String bal=str.nextToken();
			Double l=Double.parseDouble(bal);
			Double ball=Double.parseDouble(ba);
			Double ty=l+ball;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			//this is the number to be stored in the file which will replace existing one
			
			String changed_line=firstname+" "+ty;
			
			//length of the line to be written
			int final_size=changed_line.length();
		
			if(final_size>init_size)
			{
				int incr=final_size-init_size;				
				long j=op.length()-1;
				op.setLength(incr+bytes);
				long j2=op.length()-1;
				while(j>=(finalw+init_size))
				{
					op.seek(j);
					int u=op.read();
					op.seek(j2);
					op.write(u);
					j--;
					j2--;
				}
				op.seek(finalw);
				op.writeBytes(changed_line);
			}
			else if(final_size<init_size)
			{				
				while(changed_line.length()<init_size)
					changed_line+=" ";					
				op.seek(finalw);
				for(int kl=0;kl<changed_line.length();kl++)
				{
					if(Character.isISOControl(changed_line.charAt(kl)))
					{
					}		
					else
						op.write((int)changed_line.charAt(kl));
				}
				
				long j=finalw+init_size-1;
				long diff=init_size-final_size;
				while(j<=(op.length()-1))
				{
					op.seek(j);
					int jjui=op.read();
					op.seek(j-diff);
					op.write(jjui);
					j++;
				}
			}	
			else
			{
				System.out.println("equal");
				op.seek(finalw);
				op.writeBytes(changed_line);
			}					
		}
		catch(Exception e){System.out.println(e);}
			try
			{
				PrintWriter pkc=new PrintWriter(new FileOutputStream("count.txt",true),true);

				pkc.println("1");
				System.out.println("SSSSSSSS");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}			
			if(bk.equals("StateBank"))
			{
				try
				{
					PrintWriter p=new PrintWriter(new FileOutputStream("account.txt",true),true);
					BufferedReader ob=new BufferedReader(new FileReader("account.txt"));
					while((t1=ob.readLine())!=null)
					{
						int j=0;
						count=count+1;
						StringTokenizer st3=new StringTokenizer(t1," ");
						 val2=st3.nextToken();
						while(j<4)
						{
							 val2=st3.nextToken();
							//System.out.println("hello");	
							j++;
						}
						if(akt.equals(val2))
						{
							count1=count;
							 val2=st3.nextToken();
							//System.out.println("hello");
							vle=Double.parseDouble(val2);
								rep=vle-bill;
						}
				}		
			try
			{
				//PROGRAM REQUIRES RECORDS TO BE EXISTING IN THE FILE 
		
				FileInputStream fos=new FileInputStream("account.txt");
				int linee_no=count1;//nos start from 1
				long bytes=fos.available();
				for(int i=0;i<(linee_no-1);)
				{
					int o;							
					o=fos.read();
					if(o!=-1)
					{
						char t=(char)o;
						if(t=='\n')
							i++;
					}
					else
						break;
				}
				long finalw=fos.available();
				finalw=bytes-finalw;
				int o=0;
				String line_to_be_changed="";
				do
				{
					o=fos.read();
					if(o!=-1)
					{
						char t=(char)o;
					
				 		if(t!='\n')
							line_to_be_changed+=t;
						else
							break;
					}
					else
						break;
				}while(o!=-1);
			
				int init_size=line_to_be_changed.length();
				RandomAccessFile op=new RandomAccessFile("account.txt","rw");
				StringTokenizer str=new StringTokenizer(line_to_be_changed," \n",false);
				String firstname=str.nextToken(); 
				String dob=str.nextToken();
				String mob=str.nextToken();
				String sex=str.nextToken();
				String numbr=str.nextToken();
				String bal=str.nextToken();
				String passwrd=str.nextToken();
				String bnkakt=str.nextToken();
				Double l=rep;
				String changed_line=firstname+" "+dob+" "+mob+" "+sex+" "+numbr+" "+l.toString()+" "+passwrd+" "+bnkakt;
				int final_size=changed_line.length();
				if(final_size>init_size)
				{
					int incr=final_size-init_size;				
					long j=op.length()-1;
					op.setLength(incr+bytes);
					long j2=op.length()-1;
					while(j>=(finalw+init_size))
					{
						op.seek(j);
						int u=op.read();
						op.seek(j2);
						op.write(u);
						j--;
						j2--;
					}
					op.seek(finalw);
					op.writeBytes(changed_line);
				}
				else if(final_size<init_size)
				{				
					while(changed_line.length()<init_size)
						changed_line+=" ";					
					op.seek(finalw);
					for(int kl=0;kl<changed_line.length();kl++)
					{
						if(Character.isISOControl(changed_line.charAt(kl)))
						{
						}		
						else
							op.write((int)changed_line.charAt(kl));
					}
				
					long j=finalw+init_size-1;
					long diff=init_size-final_size;
					while(j<=(op.length()-1))
					{
						op.seek(j);
						int jjui=op.read();
						op.seek(j-diff);
						op.write(jjui);
						j++;
					}
				}	
				else
				{
					System.out.println("equal");
					op.seek(finalw);
					op.writeBytes(changed_line);
				}					
			}
			catch(Exception e){System.out.println(e);}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
			else if(bk.equals("IdbiBank"))
			{
				try
				{
					PrintWriter p=new PrintWriter(new FileOutputStream("account1.txt",true),true);
					BufferedReader ob=new BufferedReader(new FileReader("account1.txt"));
					while((t1=ob.readLine())!=null)
					{
						int j=0;
						count=count+1;
						StringTokenizer st3=new StringTokenizer(t1," ");
						 val2=st3.nextToken();
						while(j<4)
						{
							 val2=st3.nextToken();
							//System.out.println("hello");	
							j++;
						}
						if(akt.equals(val2))
						{
							count1=count;
							 val2=st3.nextToken();
							//System.out.println("hello");
							vle=Double.parseDouble(val2);
								rep=vle-bill;
						}
				}		
			try
			{
				//PROGRAM REQUIRES RECORDS TO BE EXISTING IN THE FILE 
		
				FileInputStream fos=new FileInputStream("account1.txt");
				int linee_no=count1;//nos start from 1
				long bytes=fos.available();
				for(int i=0;i<(linee_no-1);)
				{
					int o;							
					o=fos.read();
					if(o!=-1)
					{
						char t=(char)o;
						if(t=='\n')
							i++;
					}
					else
						break;
				}
				long finalw=fos.available();
				finalw=bytes-finalw;
				int o=0;
				String line_to_be_changed="";
				do
				{
					o=fos.read();
					if(o!=-1)
					{
						char t=(char)o;
					
				 		if(t!='\n')
							line_to_be_changed+=t;
						else
							break;
					}
					else
						break;
				}while(o!=-1);
			
				int init_size=line_to_be_changed.length();
				RandomAccessFile op=new RandomAccessFile("account1.txt","rw");
				StringTokenizer str=new StringTokenizer(line_to_be_changed," \n",false);
				String firstname=str.nextToken(); 
				String dob=str.nextToken();
				String mob=str.nextToken();
				String sex=str.nextToken();
				String numbr=str.nextToken();
				String bal=str.nextToken();
				String passwrd=str.nextToken();
				String bnkakt=str.nextToken();
				Double l=rep;
				String changed_line=firstname+" "+dob+" "+mob+" "+sex+" "+numbr+" "+l.toString()+" "+passwrd+" "+bnkakt;
				int final_size=changed_line.length();
				if(final_size>init_size)
				{
					int incr=final_size-init_size;				
					long j=op.length()-1;
					op.setLength(incr+bytes);
					long j2=op.length()-1;
					while(j>=(finalw+init_size))
					{
						op.seek(j);
						int u=op.read();
						op.seek(j2);
						op.write(u);
						j--;
						j2--;
					}
					op.seek(finalw);
					op.writeBytes(changed_line);
				}
				else if(final_size<init_size)
				{				
					while(changed_line.length()<init_size)
						changed_line+=" ";					
					op.seek(finalw);
					for(int kl=0;kl<changed_line.length();kl++)
					{
						if(Character.isISOControl(changed_line.charAt(kl)))
						{
						}		
						else
							op.write((int)changed_line.charAt(kl));
					}
				
					long j=finalw+init_size-1;
					long diff=init_size-final_size;
					while(j<=(op.length()-1))
					{
						op.seek(j);
						int jjui=op.read();
						op.seek(j-diff);
						op.write(jjui);
						j++;
					}
				}	
				else
				{
					System.out.println("equal");
					op.seek(finalw);
					op.writeBytes(changed_line);
				}					
			}
			catch(Exception e){System.out.println(e);}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	
				
				
	}
	else if(bk.equals("CorporationBank"))
	{
		try
		{
			PrintWriter p=new PrintWriter(new FileOutputStream("account2.txt",true),true);
			BufferedReader ob=new BufferedReader(new FileReader("account2.txt"));
			while((t1=ob.readLine())!=null)
			{
					int j=0;
						count=count+1;
						StringTokenizer st3=new StringTokenizer(t1," ");
						 val2=st3.nextToken();
						while(j<4)
						{
							 val2=st3.nextToken();
							//System.out.println("hello");	
							j++;
						}
						if(akt.equals(val2))
						{
							count1=count;
							 val2=st3.nextToken();
							//System.out.println("hello");
							vle=Double.parseDouble(val2);
								rep=vle-bill;
						}
			}		
			try
			{
				//PROGRAM REQUIRES RECORDS TO BE EXISTING IN THE FILE 
		
				FileInputStream fos=new FileInputStream("account2.txt");
				int linee_no=count1;//nos start from 1
				long bytes=fos.available();
				for(int i=0;i<(linee_no-1);)
				{
					int o;							
					o=fos.read();
					if(o!=-1)
					{
						char t=(char)o;
						if(t=='\n')
							i++;
					}
					else
						break;
				}
				long finalw=fos.available();
				finalw=bytes-finalw;
				int o=0;
				String line_to_be_changed="";
				do
				{
					o=fos.read();
					if(o!=-1)
					{
						char t=(char)o;
					
				 		if(t!='\n')
							line_to_be_changed+=t;
						else
							break;
					}
					else
						break;
				}while(o!=-1);
			
				int init_size=line_to_be_changed.length();
				RandomAccessFile op=new RandomAccessFile("account2.txt","rw");
				StringTokenizer str=new StringTokenizer(line_to_be_changed," \n",false);
				String firstname=str.nextToken(); 
				String dob=str.nextToken();
				String mob=str.nextToken();
				String sex=str.nextToken();
				String numbr=str.nextToken();
				String bal=str.nextToken();
				String passwrd=str.nextToken();
				String bnkakt=str.nextToken();
				Double l=rep;
				String changed_line=firstname+" "+dob+" "+mob+" "+sex+" "+numbr+" "+l.toString()+" "+passwrd+" "+bnkakt;
				int final_size=changed_line.length();
				if(final_size>init_size)
				{
					int incr=final_size-init_size;				
					long j=op.length()-1;
					op.setLength(incr+bytes);
					long j2=op.length()-1;
					while(j>=(finalw+init_size))
					{
						op.seek(j);
						int u=op.read();
						op.seek(j2);
						op.write(u);
						j--;
						j2--;
					}
					op.seek(finalw);
					op.writeBytes(changed_line);
				}
				else if(final_size<init_size)
				{				
					while(changed_line.length()<init_size)
						changed_line+=" ";					
					op.seek(finalw);
					for(int kl=0;kl<changed_line.length();kl++)
					{
						if(Character.isISOControl(changed_line.charAt(kl)))
						{
						}		
						else
							op.write((int)changed_line.charAt(kl));
					}
				
					long j=finalw+init_size-1;
					long diff=init_size-final_size;
					while(j<=(op.length()-1))
					{
						op.seek(j);
						int jjui=op.read();
						op.seek(j-diff);
						op.write(jjui);
						j++;
					}
				}	
				else
				{
					System.out.println("equal");
					op.seek(finalw);
					op.writeBytes(changed_line);
				}					
			}
			catch(Exception e){System.out.println(e);}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	
				
				
	}
}
				
				
	
			
	public void itemStateChanged(ItemEvent me)
	{
			//repaint();
	}
	public void  actionPerformed(ActionEvent me)
	{
	}
	public void paint(Graphics g)
	{
		Dimension d=this.getSize();
		int c=50;
		g.setColor(Color.white);
		g.fillRect(0,0,d.width,d.height);
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman",Font.BOLD,40));
		drawCenteredString("YOUR TRANSACTION HAS BEEN COMPLETED"+" ",d.width,d.height,g);
		drawCenteredString("THANK YOU FOR USING VMT SOFTWARE",d.width,d.height,g,c);
		g.drawRect(0,0,d.width-1,d.height-1);
	}
	public void drawCenteredString(String s,int w,int h,Graphics g)
	{
		FontMetrics fm=g.getFontMetrics();
		int x=(w-fm.stringWidth(s))/2;
		int y=(fm.getAscent()+(h-(fm.getAscent()+fm.getDescent()))/2);
		g.drawString(s,x,y);
	}
	public void drawCenteredString(String s,int w,int h,Graphics g,int p)
	{
		FontMetrics fm=g.getFontMetrics();
		int x=(w-fm.stringWidth(s))/2;
		int y=(fm.getAscent()+(h-(fm.getAscent()+fm.getDescent()))/2)+p;
		g.drawString(s,x,y);
	}
}
class MyWindowAdapter4 extends WindowAdapter
{
	newframe4 nf1;
	public MyWindowAdapter4(newframe4 nf1)
	{
		this.nf1=nf1;
	}
	public void windowClosing(WindowEvent we)
	{
		nf1.setVisible(false);
	}
}
		
	
class newframe3 extends Frame implements ActionListener,ItemListener
{
		String bank,acct,billno,billamt,t1,t2,val,val1,mallcode,t3,t4,val3,val4,val2,a,t,vl,mesg,val8,val9,trmx,msgchck,trmy,msgchck1,shop;
		String l;
		Frame fr4;
		TextArea txt;
		TextField txts;
		Label l1;
		//Calendar cal=Calendar.getInstance();
		Date theDate;
		String v=" ";
		String w="\n";
		String u="name : ";
		String x="mob no. : ";
		int f=1,f1=1,cnt=0,cnt1=0,linenos=0,countline=0,checkit=0,linenos1=0,yck,checkit1=0;
		Button bt;
		double bill,vle;
		
		newframe3(String title,String s,String bnk,String account,String a1,String b1)
		{
			super(title);
			bank=bnk;
			acct=account;
			billno=a1;
			billamt=b1;
			mallcode=s;
			txts=new TextField(10);
			txts.setEchoChar('*');
			l1=new Label("SESSION PASSWORD",Label.RIGHT);
			theDate = new Date();
			setFont(new Font("Times New Roman",Font.BOLD,15));
			//setLayout(new FlowLayout());
			GridBagLayout gbag=new GridBagLayout();
			GridBagConstraints gbc=new GridBagConstraints();
			setLayout(gbag);
			l=theDate.toString();
			txt=new TextArea(v,10,40);
			bt=new Button("Yes,i agree these are my details and i accept for the transaction");
			txt.append(v);
			txt.append(v);
			txt.append(v);
			txt.append(v);
			txt.append(v);
			txt.append(v);
			txt.append(v);
			txt.append(v);
			txt.append(v);
			txt.append(v);
			txt.append(v);
			txt.append(v);
			txt.append(l);
			gbc.gridx=2;
			gbc.gridy=0;
			gbc.insets=new Insets(10,10,5,5);
			gbag.setConstraints(txt,gbc);
			add(txt);
			gbc.gridx=2;
			gbc.gridy=6;
			gbc.insets=new Insets(20,20,5,5);
			gbag.setConstraints(bt,gbc);
			add(bt);
			gbc.gridx=1;
			gbc.gridy=4;
			gbc.insets=new Insets(20,20,5,5);
			gbag.setConstraints(l1,gbc);
			add(l1);
			gbc.gridx=2;
			gbc.gridy=4;
			gbc.insets=new Insets(20,20,5,5);
			gbag.setConstraints(txts,gbc);
			add(txts);
			
			MyWindowAdapter3 r= new MyWindowAdapter3(this);
			addWindowListener(r);
			
			try
			{
				if(bank.equals("StateBank"))
				{
					BufferedReader ob1=new BufferedReader(new FileReader("account.txt"));
				
					int count=1,p=100;
					while((t1=ob1.readLine())!=null)
					{
						System.out.println("hiii");	
						int j=0;int k1=0;
						StringTokenizer st1=new StringTokenizer(t1," ");
						val=st1.nextToken();
						while(j<4)
						{
							val=st1.nextToken();
								
							j++;
						}
						if(acct.equals(val))
						{	
							p=1;
							
						}
						else
						{
							if(p==1)
							{
						
							}
							else
								count=count+1;
						}
					}
					
					BufferedReader ob2=new BufferedReader(new FileReader("account.txt"));
					while(f<=count)
					{
						t2=ob2.readLine();
						f=f+1;
					}
				}
				else if(bank.equals("IdbiBank"))
				{
					BufferedReader ob1=new BufferedReader(new FileReader("account1.txt"));
					int count=1,p=100;
					while((t1=ob1.readLine())!=null)
					{
						System.out.println("hiii");	
						int j=0;int k1=0;
						StringTokenizer st1=new StringTokenizer(t1," ");
						val=st1.nextToken();
						while(j<4)
						{
							val=st1.nextToken();
							j++;
						}
						if(acct.equals(val))
						{	
							p=1;
						}
						else
						{
							if(p==1)
							{
							}
							else
								count=count+1;
						}
					}
					BufferedReader ob2=new BufferedReader(new FileReader("account1.txt"));
					while(f<=count)
					{
						t2=ob2.readLine();
						f=f+1;
					}
				}
				
				else if(bank.equals("CorporationBank"))
				{
					BufferedReader ob1=new BufferedReader(new FileReader("account2.txt"));
					int count=1,p=100;
					while((t1=ob1.readLine())!=null)
					{
						System.out.println("hiii");	
						int j=0;int k1=0;
						StringTokenizer st1=new StringTokenizer(t1," ");
						 val=st1.nextToken();
						while(j<4)
						{
							val=st1.nextToken();
							j++;
						}
						if(acct.equals(val))
						{	
							p=1;
						}
						else
						{
							if(p==1)
							{
							}
							else
								count=count+1;
						}
					}
					BufferedReader ob2=new BufferedReader(new FileReader("account2.txt"));
					while(f<=count)
					{
						t2=ob2.readLine();
						f=f+1;
					}
				}
				//System.out.println(f);
				txt.append(w);
				txt.append(w);
				txt.append(u);
				StringTokenizer st2=new StringTokenizer(t2," ");
				val1=st2.nextToken();
				txt.append(val1);
				txt.append(w);
				val1=st2.nextToken();
				txt.append("date of birth : ");
				txt.append(val1);
				//txt.append(w);
				val1=st2.nextToken();
				txt.append(w);
				txt.append(x);
				txt.append(val1);
				txt.append(w);
				val1=st2.nextToken();
				txt.append("sex : ");
				txt.append(val1);
				txt.append(w);
				txt.append("bill no. :");
				txt.append(a1);
				txt.append(w);
				txt.append("bill amt. :");
				txt.append(b1);
				txt.append(w);
				try
				{	
					System.out.println("hiii  nd how r u");	
					BufferedReader ob3=new BufferedReader(new FileReader("shoppingmalls.txt"));
					int co=1,p1=100;
					while((t3=ob3.readLine())!=null)
					{
						System.out.println("hiii and hello nd how r u");	
						int j=0;int k1=0;
						StringTokenizer st3=new StringTokenizer(t3," ");
						 val2=st3.nextToken();
						while(j<3)
						{
							 val2=st3.nextToken();
								
							j++;
						}
						if(mallcode.equals(val2))
						{	
							
							p1=1;
							System.out.println("hiii and hello");	
						}
						else
						{
							if(p1==1)
							{
						
							}
							else
								co=co+1;
						}
					}
					BufferedReader ob4=new BufferedReader(new FileReader("shoppingmalls.txt"));
					while(f1<=co)
					{
						t4=ob4.readLine();
						f1=f1+1;
					}
					StringTokenizer st4=new StringTokenizer(t4," ");
					txt.append("mall address :");
					txt.append(v);
					txt.append(v);
					val3=st4.nextToken();
					shop=val3;
					txt.append(val3);
					txt.append(",");
					val3=st4.nextToken();
					txt.append(val3);
					txt.append(",");
					val3=st4.nextToken();
					txt.append(val3);
					txt.append(w);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				txt.append("vmt code of mall :");
				txt.append(mallcode);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			bt.addActionListener(this);
		}
		public void itemStateChanged(ItemEvent me)
		{
			//repaint();
		}
		public void  actionPerformed(ActionEvent me)
		{
			a=me.getActionCommand();
			try
			{
				if(bank.equals("StateBank"))
				{
					BufferedReader ob1=new BufferedReader(new FileReader("account.txt"));
					bill=Double.parseDouble(billamt);
					if(a.equals("Yes,i agree these are my details and i accept for the transaction"))
					{
						System.out.println("der");
					try
					{
						String str =txts.getText();
						System.out.println(str);
						System.out.println("der");
						BufferedReader obr=new BufferedReader(new FileReader("verify.txt"));
						BufferedReader obr1=new BufferedReader(new FileReader("verify.txt"));
						while((trmx=obr.readLine())!=null)
						{
							linenos++;
							StringTokenizer stx3= new StringTokenizer(trmx," ");
							val9=stx3.nextToken();
							if(val9.equals(acct))
							{
								System.out.println("found at line" + linenos);
								break;
							}
						}
						yck=linenos;
						while((trmy=obr1.readLine())!=null)
						{ 
							linenos1++;
							if(linenos1==yck)
							{
								System.out.println("susheel");
								StringTokenizer stx2= new StringTokenizer(trmy," ");
								while(stx2.hasMoreTokens())
								{
									val8=stx2.nextToken();
									System.out.println(val8);
								}
								if(str.equals(val8))
								{
									System.out.println("line");
									System.out.println("found at line" + linenos);
									countline++;
								}
							}
							else
							{
								/* msgchck1="INVALID SESSIONAL PASSWORD";
								checkit1=1;
								System.out.println("enter correct pasword");
								repaint();*/
							}		
							System.out.println("out");
								if(countline!=0)
								break;
					}
					System.out.println("here");
				}
				catch(Exception e)
				{
				}
							
				if(countline!=0)
				{	
						System.out.println("ders");
		
					
					
						while((t=ob1.readLine())!=null)
						{
							
							int j=0;
							StringTokenizer stk=new StringTokenizer(t," ");
						 	vl=stk.nextToken();
							while(j<=4)
							{
								 vl=stk.nextToken();
								
								j++;
							}
							vle=Double.parseDouble(vl);
							if(vle<bill)
							{
								cnt=cnt+1;
								mesg="Sorry, you dont have enough balance";
								repaint();
							}
							else
							{
							
									if(cnt==0&&cnt1==0)
									{
										fr4=new newframe4("new one",billamt,acct,bank,shop);
										fr4.setSize(500,500);
										fr4.setVisible(true);
										cnt1=cnt1+1;
									}
									else
									{
									}
							}
						}
					}
					else
					{
						 msgchck="INVALID SESSIONAL PASSWORD";
							checkit=1;
						System.out.println("enter correct pasword");
						repaint();
					}
					}
				}
				if(bank.equals("IdbiBank"))
				{
					BufferedReader ob1=new BufferedReader(new FileReader("account1.txt"));
					bill=Double.parseDouble(billamt);
					if(a.equals("Yes,i agree these are my details and i accept for the transaction"))
					{
						System.out.println("der");
				try
				{
					String str =txts.getText();
					System.out.println(str);
					System.out.println("der");
				BufferedReader obr=new BufferedReader(new FileReader("verify.txt"));
				BufferedReader obr1=new BufferedReader(new FileReader("verify.txt"));
				
					while((trmx=obr.readLine())!=null)
					{
						linenos++;
						StringTokenizer stx3= new StringTokenizer(trmx," ");
						val9=stx3.nextToken();
						if(val9.equals(acct))
						{
							System.out.println("found at line" + linenos);
							break;
						}
					}
					yck=linenos;
						while((trmy=obr1.readLine())!=null)
						{ linenos1++;
				
					
						if(linenos1==yck)
						{
							System.out.println("susheel");
					
						StringTokenizer stx2= new StringTokenizer(trmy," ");
								while(stx2.hasMoreTokens())
								{
								val8=stx2.nextToken();
								System.out.println(val8);
								}
								if(str.equals(val8))
								{
									System.out.println("line");
									System.out.println("found at line" + linenos);
									countline++;
								}
						
						}
						else
						{
							/* msgchck1="INVALID SESSIONAL PASSWORD";
							checkit1=1;
						System.out.println("enter correct pasword");
						repaint();*/
						}		
								System.out.println("out");
								if(countline!=0)
								break;
					}
					System.out.println("here");
				}
				catch(Exception e)
				{
				}
							
				if(countline!=0)
				{	
						System.out.println("ders");
		
					
						while((t=ob1.readLine())!=null)
						{
							
							int j=0;
							StringTokenizer stk=new StringTokenizer(t," ");
						 	vl=stk.nextToken();
							while(j<=4)
							{
								 vl=stk.nextToken();
								
								j++;
							}
							vle=Double.parseDouble(vl);
							if(vle<bill)
							{
								cnt=cnt+1;
								mesg="Sorry, you dont have enough balance";
								repaint();
							}
							else
							{
							
									if(cnt==0&&cnt1==0)
									{
										fr4=new newframe4("new one",billamt,acct,bank,shop);
										fr4.setSize(500,500);
										fr4.setVisible(true);
										cnt1=cnt1+1;
									}
									else
									{
									}
							}
						}
					}
					else
					{
						 msgchck="INVALID SESSIONAL PASSWORD";
							checkit=1;
						System.out.println("enter correct pasword");
						repaint();
					}
					}
				}
				if(bank.equals("CorporationBank"))
				{
					BufferedReader ob1=new BufferedReader(new FileReader("account2.txt"));
					bill=Double.parseDouble(billamt);
					if(a.equals("Yes,i agree these are my details and i accept for the transaction"))
					{
						System.out.println("der");
				try
				{
					String str =txts.getText();
					System.out.println(str);
					System.out.println("der");
				BufferedReader obr=new BufferedReader(new FileReader("verify.txt"));
				BufferedReader obr1=new BufferedReader(new FileReader("verify.txt"));
				
					while((trmx=obr.readLine())!=null)
					{
						linenos++;
						StringTokenizer stx3= new StringTokenizer(trmx," ");
						val9=stx3.nextToken();
						if(val9.equals(acct))
						{
							System.out.println("found at line" + linenos);
							break;
						}
					}
					yck=linenos;
						while((trmy=obr1.readLine())!=null)
						{ linenos1++;
				
					
						if(linenos1==yck)
						{
							System.out.println("susheel");
					
						StringTokenizer stx2= new StringTokenizer(trmy," ");
								while(stx2.hasMoreTokens())
								{
								val8=stx2.nextToken();
								System.out.println(val8);
								}
								if(str.equals(val8))
								{
									System.out.println("line");
									System.out.println("found at line" + linenos);
									countline++;
								}
						
						}
						else
						{
							/* msgchck1="INVALID SESSIONAL PASSWORD";
							checkit1=1;
						System.out.println("enter correct pasword");
						repaint();*/
						}		
								System.out.println("out");
								if(countline!=0)
								break;
					}
					System.out.println("here");
				}
				catch(Exception e)
				{
				}
							
				if(countline!=0)
				{	
						System.out.println("ders");
		
					
						while((t=ob1.readLine())!=null)
						{
							
							int j=0;
							StringTokenizer stk=new StringTokenizer(t," ");
						 	vl=stk.nextToken();
							while(j<=4)
							{
								 vl=stk.nextToken();
								
								j++;
							}
							vle=Double.parseDouble(vl);
							if(vle<bill)
							{
								cnt=cnt+1;
								mesg="Sorry, you dont have enough balance";
								repaint();
							}
							else
							{
							
									if(cnt==0&&cnt1==0)
									{
										fr4=new newframe4("new one",billamt,acct,bank,shop);
										fr4.setSize(500,500);
										fr4.setVisible(true);
										cnt1=cnt1+1;
									}
									else
									{
									}
							}
						}
					}
					else
					{
						 msgchck="INVALID SESSIONAL PASSWORD";
							checkit=1;
						System.out.println("enter correct pasword");
						repaint();
					}
					
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
							
		}
		public void paint(Graphics g) 
		{
			if(cnt==0)
			{
				
			}
			else
			{
				
					 g. setFont(new Font("Times New Roman",Font.BOLD,40));
				g.drawString(mesg,400,630);	
			}
			if(checkit==1)
			{
				g. setFont(new Font("Times New Roman",Font.BOLD,40));
				g.drawString(msgchck,400,690);
			}
			if(checkit1==1)
			{
				g. setFont(new Font("Times New Roman",Font.BOLD,40));
				g.drawString(msgchck1,400,650);
			}		
				
		}
}
class MyWindowAdapter3 extends WindowAdapter
{
	newframe3 nf1;
	public MyWindowAdapter3(newframe3 nf1)
	{
		this.nf1=nf1;
	}
	public void windowClosing(WindowEvent we)
	{
		nf1.setVisible(false);
	}
}
		
class newframe2 extends Frame implements ActionListener,ItemListener
{
		String k,t1,t2,val,val1,bk,act,a1,b1,a,d,y,sdt,sdt1,sdt2,m;
		String msg1="\n";
		Button b;
		
		Calendar cal=Calendar.getInstance();
		TextField tf1,tf2;
		Label l1,l2,l3,l4,l5;
		Choice date,month,year; 
		Frame fr3;
		int dt,mn,yr,d1,y1;
		int i,l,ly,m1;
		newframe2(String title,String s,String bank,String ack) 
		{
			super(title);
			k=s;
			bk=bank;
			act=ack;
			int f=1;
			MyWindowAdapter2 r= new MyWindowAdapter2(this);
			addWindowListener(r);
			
			date=new Choice();
			month=new Choice();
			year=new Choice();
			b=new Button("OK");
			l1=new Label("BILL NO.",Label.RIGHT);
			l3=new Label("DATE",Label.RIGHT);
			l4=new Label("MONTH",Label.RIGHT);
			l5=new Label("YEAR",Label.RIGHT);
			tf1=new TextField(10);
			l2=new Label("BILL AMT.",Label.RIGHT);
			tf2=new TextField(10);
			for(i=1;i<=31;i++)
			{
				sdt=""+i;
				date.add(sdt);
			}
			for(l=1;l<=12;l++)
			{
				sdt1=""+l;
				month.add(sdt1);
			}
			for(ly=2000;ly<=2015;ly++)
			{
				sdt2=""+ly;
				year.add(sdt2);
			}
			
			GridBagLayout gbag=new GridBagLayout();
			GridBagConstraints gbc=new GridBagConstraints();
			setLayout(gbag);
			TextArea t=new TextArea(k,5,15);
			gbc.gridx=2;
			gbc.gridy=1;
			gbag.setConstraints(t,gbc);
			add(t);
			
			t.append(msg1);
			setFont(new Font("Times New Roman",Font.BOLD,20));
			gbc.gridx = 1;
			gbc.gridy=3;
			gbc.insets=new Insets(10,10,5,0);
			gbag.setConstraints(l1,gbc);
			add(l1);
			gbc.gridx = 2;
			gbc.gridy=3;
			gbc.insets=new Insets(10,10,5,0);
			gbag.setConstraints(tf1,gbc);
			add(tf1);
			gbc.gridx = 1;
			gbc.gridy=4;
			gbc.insets=new Insets(10,10,5,0);
			gbag.setConstraints(l2,gbc);
			add(l2);
			gbc.gridx = 2;
			gbc.gridy=4;
			gbc.insets=new Insets(10,10,5,0);
			gbag.setConstraints(tf2,gbc);
			add(tf2);
			gbc.gridx = 0;
			gbc.gridy=6;
			gbag.setConstraints(l3,gbc);
			add(l3);
			gbc.gridx = 1;
			gbc.gridy=6;
			gbag.setConstraints(date,gbc);
			add(date);
			gbc.gridx = 2;
			gbc.gridy=6;
			gbag.setConstraints(l4,gbc);
			add(l4);
			gbc.gridx = 3;
			gbc.gridy=6;
			gbag.setConstraints(month,gbc);
			add(month);
			gbc.gridx = 4;
			gbc.gridy=6;
			gbag.setConstraints(l5,gbc);
			add(l5);
			gbc.gridx = 5;
			gbc.gridy=6;
			gbag.setConstraints(year,gbc);
			add(year);
			gbc.gridx =2;
			gbc.gridy=8;
			gbag.setConstraints(b,gbc);
			add(b);
			try
			{
				BufferedReader ob1=new BufferedReader(new FileReader("shoppingmalls.txt"));
				int count=1,p=100;
					while((t1=ob1.readLine())!=null)
					{
							
						int j=0;int k1=0;
						StringTokenizer st1=new StringTokenizer(t1," ");
						 val=st1.nextToken();
						while(j<3)
						{
							 val=st1.nextToken();
								
							j++;
						}
						if(k.equals(val))
						{	
							
							p=1;
							
						}
						else
						{
							if(p==1)
							{
						
							}
							else
								count=count+1;
						}
					}
					
			
				
				BufferedReader ob2=new BufferedReader(new FileReader("shoppingmalls.txt"));
				while(f<=count)
				{
					t2=ob2.readLine();
					
					
					f=f+1;
				}
				StringTokenizer st2=new StringTokenizer(t2," ");
				
				val1=st2.nextToken();
				t.append(val1);
				t.append(msg1);
				val1=st2.nextToken();
				t.append(val1);
				t.append(msg1);
				val1=st2.nextToken();
				t.append(val1);
			}
			catch(Exception e)
			{
			}
			b.addActionListener(this);
			
           		
		}
		public void itemStateChanged(ItemEvent me)
		{
			//repaint();
		}
		public void  actionPerformed(ActionEvent me)
		{
			a=me.getActionCommand();
			a1=tf1.getText();
			b1=tf2.getText();
			//System.out.println("hello");
			d=date.getSelectedItem();
			m=month.getSelectedItem();
			y=year.getSelectedItem();
			d1=Integer.parseInt(d);
			y1=Integer.parseInt(y);
			m1=Integer.parseInt(m);
			dt=cal.get(Calendar.DATE);
			
			mn=cal.get(Calendar.MONTH);
			//System.out.println(mn);
			yr=cal.get(Calendar.YEAR);
			if(a.equals("OK"))
			{
				
				if(d1==dt)
				{
					if(m1==(mn+1))
					{
						if(y1==yr)
						{
								fr3=new newframe3("new one",k,bk,act,a1,b1);
								fr3.setSize(500,500);
								fr3.setVisible(true);
						}
					}
				}
			}
				
		}
		public void paint(Graphics g) 
		{
			// g.setFont(new Font("Times New Roman",Font.BOLD,32));
       			
		}
}
class MyWindowAdapter2 extends WindowAdapter
{
	newframe2 nf1;
	public MyWindowAdapter2(newframe2 nf1)
	{
		this.nf1=nf1;
	}
	public void windowClosing(WindowEvent we)
	{
		nf1.setVisible(false);
	}
}


		
class newframe1 extends Frame implements ActionListener,ItemListener
{
		String msg,msg1,msg2,s,a1,t1,val,bnk,accnt;
		TextField t;
		Label l1;
		Choice mall;
		Button b;
		Frame fr2;
		
		newframe1(String title,String bank,String acno) 
		{
			super(title);
			bnk=bank;
			accnt=acno;
			MyWindowAdapter1 k= new MyWindowAdapter1(this);
			addWindowListener(k);
			setLayout(new FlowLayout());
			   setFont(new Font("Times New Roman",Font.BOLD,32));
			 msg="YOUR ACCOUNT HAS BEEN VERIFIED";
			msg1="Select the Shopping Mall";
			mall=new Choice();
			l1=new Label("VMT CODE OF MALL",Label.RIGHT);
			t=new TextField(10);
			b=new Button("OK");

			mall.add("spencer's");
			mall.add("more");
			mall.add("BigBazar");
			mall.add("fresh");
			mall.add("Kalamandir");
			mall.add("brandfactory");
			GridBagLayout gbag=new GridBagLayout();
			GridBagConstraints gbc=new GridBagConstraints();
			setLayout(gbag);
			gbc.gridx = 3;
			gbc.gridy=1;
			gbc.insets=new Insets(10,10,5,0);
			gbag.setConstraints(mall,gbc);
			add(mall);
			gbc.gridx = 2;
			gbc.gridy=2;
		
			gbc.insets=new Insets(10,10,5,0);
		
			gbag.setConstraints(l1,gbc);
			add(l1);
			gbc.gridx = 3;
			gbc.gridy=2;
			gbc.insets=new Insets(10,10,5,0);
			gbag.setConstraints(t,gbc);
		
			add(t);
			GridBagConstraints gbc4 = new GridBagConstraints();
			gbc4.gridx=3;
			gbc4.gridy=10;
		
			gbag.setConstraints(b,gbc4);
			add(b);
//-----------------------------------------------
			b.addActionListener(this);	
			mall.addItemListener(this);
			
		}			
			
		

			

		public void itemStateChanged(ItemEvent me)
		{
			//repaint();
		}
		public void actionPerformed(ActionEvent w)
		{
			try	
			{	
				String s1=w.getActionCommand();
				BufferedReader ob=new BufferedReader(new FileReader("shoppingmalls.txt"));
				s=mall.getSelectedItem();
				a1=t.getText();
				if(s1.equals("OK"))
				{
					
					
					while((t1=ob.readLine())!=null)
					{
							
						int j=0;
						StringTokenizer st=new StringTokenizer(t1," ");
						 val=st.nextToken();
						if(s.equals(val))
						{
							
							while(j<3)
							{
								 val=st.nextToken();
								
								j++;
							}
							if(a1.equals(val))
							{
								fr2=new newframe2("new one",a1,bnk,accnt);
								fr2.setSize(500,500);
								fr2.setVisible(true);
								this.setVisible(false);
						
							}
							else
							{
								msg2="Please enter correct vmtcode";
								repaint();
							}
						}
						
						
							
					}
				}
								
			}
			catch(Exception e)
			{
				System.out.println(e);
			}		
				
		}
		public void paint(Graphics g)
		{
			
			g.drawString(msg,400,100);
			 g. setFont(new Font("Times New Roman",Font.BOLD,35));
			g.drawString(msg1,650,270);
			g.drawString(msg2,580,560);
		}
}


class MyWindowAdapter1 extends WindowAdapter
{
	newframe1 nf1;
	public MyWindowAdapter1(newframe1 nf1)
	{
		this.nf1=nf1;
	}
	public void windowClosing(WindowEvent we)
	{
		nf1.setVisible(false);
	}
}

class newframe extends Frame implements ActionListener
{
	 TextField t1,t2,t3;
	Label l1,l2,l3;
	Button bt;
	 Frame fr1;
	 String msg,msg1,msg2;
	 String	b1,a1,t,val,c1;
	int count=0;
	String msg4=" ";
	newframe(String title,String b) 
	{
		msg1=b;
		MyWindowAdapter a=new MyWindowAdapter(this);
		addWindowListener(a);
		setFont(new Font("Monospaced",Font.BOLD,30));
		msg="Welcome To ";
		msg2="Enter the Account no.,DOB and Password";
			l1=new Label("AC.NO.",Label.RIGHT);
			l2=new Label("DATE OF BIRTH",Label.RIGHT);
			l3=new Label("PASSWORD",Label.RIGHT);
			t1=new TextField(10);
			t1.setEchoChar('*');
			t2=new TextField(10);
			t2.setEchoChar('.');
			t3=new TextField(10);
			t3.setEchoChar('*');
			bt=new Button("OK");
			GridBagLayout gbag=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		setLayout(gbag);
			gbc.gridx = 1;
		gbc.gridy=1;
		
		gbc.insets=new Insets(10,10,5,0);
		
		gbag.setConstraints(l1,gbc);
			add(l1);
				gbc.gridx = 2;
		gbc.gridy=1;
		
		gbc.insets=new Insets(10,10,5,0);
		
		gbag.setConstraints(t1,gbc);
			add(t1);
				gbc.gridx = 1;
		gbc.gridy=2;
		
		gbc.insets=new Insets(10,10,5,0);
		
		gbag.setConstraints(l2,gbc);
			add(l2);
				gbc.gridx = 2;
		gbc.gridy=2;
		
		gbc.insets=new Insets(10,10,5,0);
		
		gbag.setConstraints(t2,gbc);
			add(t2);
		gbc.gridx = 1;
		gbc.gridy=3;
		
		gbc.insets=new Insets(10,10,5,0);
		
		gbag.setConstraints(l3,gbc);
		add(l3);
		gbc.gridx = 2;
		gbc.gridy=3;
		
		gbc.insets=new Insets(10,10,5,0);
		
		gbag.setConstraints(t3,gbc);
		add(t3);
		gbc.gridx = 2;
		gbc.gridy=6;
		
		gbc.insets=new Insets(10,10,5,0);
		
		gbag.setConstraints(bt,gbc);
		add(bt);
			t1.addActionListener(this);
			bt.addActionListener(this);
			
	}	
	
		public void actionPerformed(ActionEvent a) 
		{
			try
			{
				//BufferedReader ob=new BufferedReader(new FileReader("account.txt"));
				String s1=a.getActionCommand();
				a1=t1.getText();	
				b1=t2.getText();
				c1=t3.getText();
				if(s1.equals("OK"))
				{ 
								System.out.println("hello");
						if(msg1.equals("CorporationBank"))
						{	
								System.out.println("hiii");
							BufferedReader ob=new BufferedReader(new FileReader("account2.txt"));
							while((t=ob.readLine())!=null)
							{
								System.out.println("hii 3");
								int i=0,j=0;
								StringTokenizer st=new StringTokenizer(t," ");
								while(i<=1)
								{
									 val=st.nextToken();
									System.out.println("hii 4");
									i++;
								}
								if(val.equals(b1))
								{
									count=count+1;
									while(j<3)
									{
								 		val=st.nextToken();
										System.out.println("hii 5");
										j++;
									}
									if(val.equals(a1))
									{
										val=st.nextToken();
										val=st.nextToken();
										if(val.equals(c1))
										{
											count=count+1;
											System.out.println("hii 6");
											fr1=new newframe1("new one",msg1,a1);
											fr1.setSize(1000,1000);
											fr1.setVisible(true);	
											this.setVisible(false);
										}
									}
									else
									{
										msg4="Entered details are wrong please check ur details";
										repaint();
									}
								}
								else
								{
									msg4="Entered details are wrong please check ur details";
									repaint();
								}
							}
						}
						else if(msg1.equals("IdbiBank"))
						{
							BufferedReader ob=new BufferedReader(new FileReader("account1.txt"));
							while((t=ob.readLine())!=null)
							{
								System.out.println("hello");
								int i=0,j=0;
								StringTokenizer st=new StringTokenizer(t," ");
								while(i<=1)
								{
									 val=st.nextToken();
								
									i++;
								}
								if(val.equals(b1))
								{
									count=count+1;
									while(j<3)
									{
								 		val=st.nextToken();
								
										j++;
									}
									if(val.equals(a1))
									{
										val=st.nextToken();
										val=st.nextToken();
										if(val.equals(c1))
										{
											count=count+1;
											fr1=new newframe1("new one",msg1,a1);
											fr1.setSize(1000,1000);
											fr1.setVisible(true);	
											this.setVisible(false);
										}
									}
									else
									{
										msg4="Entered details are wrong please check ur details";
										repaint();
									}
								}
								else
								{
									msg4="Entered details are wrong please check ur details";
									repaint();
								}
							}
						}
						else if(msg1.equals("StateBank"))
						{	
							BufferedReader ob=new BufferedReader(new FileReader("account.txt"));
							while((t=ob.readLine())!=null)
							{
								System.out.println("hello");
								int i=0,j=0;
								StringTokenizer st=new StringTokenizer(t," ");
								while(i<=1)
								{
									 val=st.nextToken();
								
									i++;
								}
								if(val.equals(b1))
								{
									count=count+1;
									while(j<3)
									{
								 		val=st.nextToken();
								
										j++;
									}
									if(val.equals(a1))
									{
										val=st.nextToken();
										val=st.nextToken();
										if(val.equals(c1))
										{
											count=count+1;
											fr1=new newframe1("new one",msg1,a1);
											fr1.setSize(1000,1000);
											fr1.setVisible(true);	
											this.setVisible(false);
										}
									}
									else
									{
										msg4="Entered details are wrong please check ur details";
										repaint();
									}
								}
								else
								{
									msg4="Entered details are wrong please check ur details";
									repaint();
								}
							}
						}
	
					}
				}
			catch(Exception e)
			{
				System.out.println(e);	
			}
		}
	
		public void paint(Graphics g)
		{
			 g. setFont(new Font("Times New Roman",Font.BOLD,40));
			g.drawString(msg,500,130);
			g.drawString(msg1,730,130);
			g.drawString(msg2,300,230);
			if(count==2)
			{
			}
			else
			{
				g.drawString(msg4,300,600);
			}
		}
	
	
}
class MyWindowAdapter extends WindowAdapter
{
	newframe nf;
	public MyWindowAdapter(newframe nf)
	{
		this.nf=nf;
	}
	public void windowClosing(WindowEvent we)
	{
		nf.setVisible(false);
	}
}

public class my extends Applet implements ItemListener,ActionListener
{
	String msg1=" ";
	String msg2=" ";
	String msg3=" ";
	String bank=" ";
	Checkbox b1,b2,b3;
	Font f,f1,f3;
	Button b;
	Frame fr;
	public void init()
	{	
		b1=new Checkbox("StateBank");
		b2=new Checkbox("IdbiBank");
		b3=new Checkbox("CorporationBank");
		b=new Button("OK");
		GridBagLayout gbag=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		setLayout(gbag);
		gbc.gridx = 1;
		gbc.gridy=1;
		
		gbc.insets=new Insets(10,10,5,0);
		
		gbag.setConstraints(b1,gbc);
		add(b1);
	//	----------------------------------------------------
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx=1;
		gbc2.gridy=2;
		
		gbc2.insets=new Insets(10,10,5,0);
		gbag.setConstraints(b2,gbc2);
		add(b2);
//--------------------------------------------------------------------------
		
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx=1;
		gbc3.gridy=3;
		gbc3.insets=new Insets(10,10,5,0);
		
		gbag.setConstraints(b3,gbc3);
		add(b3);
//---------------------------------------------------------------
		
		
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx=1;
		gbc4.gridy=4;
		
		gbag.setConstraints(b,gbc4);
		add(b);
//-----------------------------------------------
		b.addActionListener(this);	
		b1.addItemListener(this);

		b2.addItemListener(this);
		b3.addItemListener(this);
		
		
		msg1="Welcome to Virtual-Money Transfer Scheme";
		
		f1=new Font("Monospaced",Font.BOLD,30);
		msg2="Select the Bank";
		setFont(f1);
	}
	public void itemStateChanged(ItemEvent me)
	{
		repaint();
	}
	public void actionPerformed(ActionEvent a) 
	{
		String s=a.getActionCommand();
		if(s.equals("OK")) 
		{
			
				fr=new newframe("new one",bank);

				fr.setSize(500,500);
				fr.setVisible(true);
				this.setVisible(false);
		}
	}
	public void paint(Graphics g)
	{
		 g. setFont(new Font("Times New Roman",Font.BOLD,40));
		g.drawString(msg1,390,100);
		g.setFont(new Font("Monospaced",Font.BOLD,30));
		g.drawString(msg2,570,200);
		if(b1.getState())
		{
			
			msg3=" statebank is selected";
			bank=b1.getLabel();
			g.drawString(msg3,500,500);
		}
		else if(b2.getState())
		{
			
			
			msg3=" idbibank is selected";
			bank=b2.getLabel();
			g.drawString(msg3,500,500);
		}
		else if(b3.getState())
		{
			
			msg3=" corporationbank is selected";
			bank=b3.getLabel();
			g.drawString(msg3,500,500);
		}
	}
}
			