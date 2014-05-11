import java.io.*;
import java.net.*;

public class PiServer{
	
	public static void main(String[] args) throws IOException{
		final int size = 2; //change 2 to a bigger number to test a more accurate pi.
		double sum = 0;
		double result = 0;
		
		try{
			ServerSocket sock = new ServerSocket(4321);
			Thread[] a = new Thread[size];
			
			for(int i = 0; i < size; i++){
				Socket server = sock.accept();
				a[i] = new Thread(new MyThread(server));
			}
			
			for(int i = 0; i < size; i++){
				a[i].start();
			}
					
			try{
				for(int i = 0; i < size; i++){
					a[i].join();
					result = MyThread.result;
					sum = sum + result;
				}
			}
			catch(Exception e){
				System.err.println("Error: " + e);
				System.exit(0);
			}
			 
			System.out.println(sum/size);
			
			sock.close();
		
		} 
		catch (IOException ioe){
			System.err.println("Error: " + ioe);
			System.exit(0);
		}
	}
}

	

