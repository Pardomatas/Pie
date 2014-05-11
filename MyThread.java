import java.io.*;
import java.net.*;


public class MyThread implements Runnable{
	Socket server;
	public static double result;
	
	public MyThread(Socket server){
		this.server = server;
	}
	
	public void run(){
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			result = (Double.parseDouble(in.readLine()));
		} 
		catch (IOException ioe){
			System.err.println("Error: " + ioe);
			System.exit(0);
		}
	}
}