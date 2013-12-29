package com.pad.production;

import java.net.*;
import java.util.*;
import java.io.*;

public class network {
	
	private ServerSocket sock;
	private BufferedReader in;
	private PrintWriter out;
	private Socket client;
	private String line;
	
	public void listenSocketServer(int port)
	{
		try
		{
			sock = new ServerSocket(port);
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
		
		
		try
		{
			client = sock.accept();
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
		
		try
		{
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
	}
	
	public void listenSocketClient(String name, int port)
	{
		try
		{
			client = new Socket(name,port);
			out = new PrintWriter(client.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
	}
	
	public String listen()
	{
		try
		{
			line = in.readLine();
			return line;
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
		
		return line;
	}
	
	public void broadcast(String msg)
	{
		try
		{
			out.println(msg);
		}
		catch(Exception i)
		{
			System.out.println(i);
		}	
	}
	
	
}
