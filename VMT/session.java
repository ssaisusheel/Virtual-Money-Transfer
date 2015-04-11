import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.util.*;
/*
<applet code="session" width=700 height=500>
</applet>
*/
public class session extends Applet implements ActionListener,WindowListener
{	
	String msg1,d,ts1,t,ts2,r,sespass,msgx,val,val1,tr,tr1,trk,val5,val7,trm,trm2,val8,tr7;
	TextField t1;
	Label l1;
	Button bt;
	Font f1;
	
	int count1=0,count=0,k,countp=0,i,counti=0,cnt=0,lineno=0,x,counts=0;
	String aval[]= new String[15];
	public void init()
	{	
		bt=new Button("OK");	
		l1=new Label("accnt no.",Label.RIGHT);
		t1=new TextField(10);	
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
		gbc.gridx=2;
		gbc.gridy=6;
		gbc.insets=new Insets(10,10,5,0);
		gbag.setConstraints(bt,gbc);
		add(bt);
		bt.addActionListener(this);
		msg1="Welcome to Sessional password generator";
		setFont(new Font("Times New Roman",Font.BOLD,40));

		//this.addWindowListener(this);
		
	}
	public void stop()
	{
		try
		{
			Runtime rk=Runtime.getRuntime();
			Process po=rk.exec("appletviewer -J-Djava.security.policy=polcy my.java");
		}
		catch(Exception we)
		{
			System.out.println(we);
		}
	}
	public void actionPerformed(ActionEvent a) 
	{
		String s=a.getActionCommand();
		try
		{
			if(s.equals("OK")) 
			{
				BufferedReader ob=new BufferedReader(new FileReader("count.txt"));
				while((t=ob.readLine())!=null)
				{
					count=count+1;
					//count1=count1+1;
				}
				//System.out.println(count);
				BufferedReader ob1=new BufferedReader(new FileReader("spl.txt"));
				while((ts1=ob1.readLine())!=null)
				{
					StringTokenizer st=new StringTokenizer(ts1,"\n ");
					if(count1==count)
					{
						 d=st.nextToken();
					}
					count1=count1+1;
				}
				//System.out.println(count1);
				if(count>count1)
				{
					BufferedReader ob2=new BufferedReader(new FileReader("spl.txt"));
					k=count-count1;
					while((ts2=ob2.readLine())!=null)
					{
						StringTokenizer st2=new StringTokenizer(ts2,"\n ");
						if(k==count1)
						{
							 r=st2.nextToken();
						}
						k++;
					}
					System.out.println(r);
				}
				String a1= t1.getText();
				int l = a1.length();
				String qb=a1.substring(0,2);
				String p= a1.substring(l-4,l);
				Calendar cal=Calendar.getInstance();
				int dt=cal.get(Calendar.DATE);
				String datee=dt+" ";
				if(count>count1)
				{
				 	sespass= qb + p + r + count + datee ;	
				}
				else
				{
				 	sespass= qb + p + d + count + datee ;
				}
				System.out.println(sespass);
				msgx="YOUR SESSIONAL PASSWORD IS :" + " " + sespass;
				repaint();
				PrintWriter pk=new PrintWriter(new FileOutputStream("verify.txt",true),true);
				BufferedReader ob3=new BufferedReader(new FileReader("verify.txt"));
				BufferedReader ob4=new BufferedReader(new FileReader("verify.txt"));
				BufferedReader ob5=new BufferedReader(new FileReader("verify.txt"));
				BufferedReader ob6=new BufferedReader(new FileReader("verify.txt"));
				BufferedReader ob7=new BufferedReader(new FileReader("verify.txt"));
				PrintWriter pk1=new PrintWriter(new FileOutputStream("verify.txt",true),true);
				PrintWriter pk2=new PrintWriter(new FileOutputStream("verify.txt",true),true);
				if((tr=ob3.readLine())==null)
				{
					System.out.println("namaste");
					pk.print(a1);
					pk.flush();
					pk.print(" "+sespass);
					pk.flush();
				}
				else 
				{		
					while((tr1=ob4.readLine())!=null)
					{
						//System.out.println("checking:");
						StringTokenizer st1=new StringTokenizer(tr1," ");
						i=0;
						try
						{
						do
						{
							val=st1.nextToken();
							System.out.println(val);
							aval[i]=val; 
							countp++;
							i++;
						}while(st1==null);
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
					
					for(i=0;i<countp;i++)
					{
						if(aval[i]!=a1)
						{
							counti++;	
						}
						
					}
					if(counti==countp)
					{
						try
						{
						while((trk=ob5.readLine())!=null)
						{
							
							StringTokenizer stp=new StringTokenizer(trk," ");
							val5=stp.nextToken();
							if(val5.equals(a1))
							{
								//System.out.println("append");
								cnt=1;
								break;
							}
						}
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
							System.out.println("hiiiiii");
						if(cnt!=1)
						{	
							System.out.println("hello mann!!!");
							//if(counts!=0&&cnt!=1)
							try{
							BufferedReader ob9=new BufferedReader(new FileReader("check.txt"));
							if((tr7=ob9.readLine())==null)
							{
								System.out.println("checking this");
								pk1.println();
							}
							}
							catch(Exception e)
							{
							}
							pk1.print(a1);
							pk1.flush();
							pk1.print(" "+sespass);
							pk1.flush();
							
						}
						else
						{
							try{
							PrintWriter pks=new PrintWriter(new FileOutputStream("check.txt",true),true);
							pks.print("sai");
							pks.flush();
							}
							catch(Exception e)
							{
							}
							//counts=counts+1;
							//System.out.println("append");
							while((trm2=ob7.readLine())!=null)
							{
								lineno++;
								StringTokenizer stx2= new StringTokenizer(trm2," ");
								val8=stx2.nextToken();
								if(a1.equals(val8))
								{
									//System.out.println("found at line" + lineno);
									break;
								}
							}
							x=lineno;
							System.out.println("found at line" + x);
							try
							{
								//PROGRAM REQUIRES RECORDS TO BE EXISTING IN THE FILE 
								FileInputStream fos=new FileInputStream("verify.txt");
								int linee_no=x;//nos start from 1
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
								RandomAccessFile op=new RandomAccessFile("verify.txt","rw");
								StringTokenizer str=new StringTokenizer(line_to_be_changed,"\n",false);
								line_to_be_changed=str.nextToken();
								StringBuffer lo=new StringBuffer();
								for(int testing=0;testing<line_to_be_changed.length();testing++)
								{
									if(line_to_be_changed.charAt(testing)=='\n')
										System.out.println("yes\n");
									else if(Character.isISOControl(line_to_be_changed.charAt(testing)))
										System.out.println("yes 2\n");
									else
										lo.append(line_to_be_changed.charAt(testing));
								}
								//String changed_line=line_to_be_changed+" "+sespass;
								String changed_line=new String(lo);
								changed_line+=" "+sespass;
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
							catch(Exception e)
							{
								System.out.println(e);
							}
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
	
	public void windowOpened(WindowEvent e)
	{
	}
	public void windowIconified(WindowEvent e)
	{
	}
	public void windowDeiconified(WindowEvent e)
	{
	}
	public void windowActivated(WindowEvent e)
	{
	}
	public void windowDeactivated(WindowEvent e)
	{
	}
	public void windowClosing(WindowEvent e)
	{
		/*try
		{
			Runtime rk=Runtime.getRuntime();
			Process po=rk.exec("appletviewer -J-Djava.security.policy=polcy my.java");
		}
		catch(Exception we)
		{
			System.out.println(we);
		}*/
	}
	public void windowClosed(WindowEvent e)
	{
	}
	public void paint(Graphics g)
	{
		 g. setFont(new Font("Times New Roman",Font.BOLD,40));
		g.drawString(msg1,390,100);
		g.drawString(msgx,230,500);
		
	}
}	