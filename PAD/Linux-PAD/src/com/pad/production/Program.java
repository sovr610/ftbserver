package com.pad.production;

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.*;

public class Program {
	
	private Scanner scan;
	private String command;
	
	public Program()
	{
		command = null;
		scan = new Scanner(System.in);
	}
	
	public void consoleMain()
	{
		try
		{
			ftb_program ftb = new ftb_program();
			ftb.app_loop();
		}
		catch(Exception i)
		{
			System.out.println(i);
		}
	}
}
