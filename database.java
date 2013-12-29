import java.io.*;
import java.net.*;

public class database
{
	private Socket sock = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private BufferedReader stdIn = null;
	


	public void createSocket(String host, int port)
	{
		try
		{
			sock = new Socket(host, port);
			out = new PrintWriter(sock.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
	}

	public void closeSockets()
	{
		try
		{
			out.close();
			in.close();
			stdIn.close();
			sock.close();
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
	}

	public void loopMessage(String msg)
	{
		try
		{
			String userInput = msg;
			while((userInput =  stdIn.readLine()) != null)
			{
				out.println(userInput);
				System.out.println(in.readLine());
			}
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
	}	

	public static void main(String[] args)
	{
		database db = new database();
		db.createSocket("192.168.1.113",4444);
		db.loopMessage("hello");
		db.closeSockets();
	}

	
}

	
