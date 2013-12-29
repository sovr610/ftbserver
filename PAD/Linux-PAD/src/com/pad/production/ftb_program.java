package com.pad.production;

import java.util.*;
import java.io.*;
import java.net.*;

public class ftb_program {
	
	private File f1;
	private File f2;
	private File f3;
	private File f4;
	private File f5;
	private String check;
	private network net;
	private boolean server;
	
	
	public ftb_program()
	{
		f1 = new File("forward");
		f2 = new File("left");
		f3 = new File("right");
		f4 = new File("backward");
		f5 = new File("click");
		net = new network();
		
		String config = readConfig("server.conf");
		
		if(config == "server")
		{
			net.listenSocketServer(4444);
			server = true;
		}
		
		if(config == "client")
		{
			net.listenSocketClient("pad", 4444);
			server = false;
		}
	}
	
	public String readConfig(String name)
	{
		try
		{
			File f = new File(name);
			if(!(f.exists()))
			{
				f.createNewFile();
			}
			Scanner scan = new Scanner(new File(name));
			String config = scan.nextLine();
			scan.close();
			return config;
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
		
		return null;
	}
	
	public String checkup() throws Exception
	{
		if(f1.exists())
		{
			f1.delete();
			check = "forward";
		}
		
		if(f2.exists())
		{
			f2.delete();
			check = "left";
		}
		
		if(f3.exists())
		{
			f3.delete();
			check = "right";
		}
		
		if(f4.exists())
		{
			f4.delete();
			check = "backward";
		}
		
		if(f5.exists())
		{
			f5.delete();
			check = "click";
		}
		
		return check;
	}
	
	public void app_loop()
	{
		int c= 0;
		String got = null;
		while(c == 0)
		{
			try
			{
				if(server)
				{
					got = checkup();
					if(got != null)
					{
						System.out.println("we got this from ftb: " + got);
						net.broadcast(got);
					}
				}
				else
				{
					String results = net.listen();
					if(results != null)
					{
						Formatter form = new Formatter("results.dat");
						form.format("%s", results);
						form.close();
					}
				}
				

				
			}
			catch(Exception i)
			{
				System.out.println(i);
			}
		}
	}
	
	
	
	
}
