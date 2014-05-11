import java.util.*;
import java.io.*;
import java.net.Socket;

public class PiClient{
  public static void main(String[] args){
    long toss, number_of_tosses, number_in_circle = 0;
    double x, y, distance_squared, pi_estimate;
    Random generator = new Random();
    number_of_tosses = generator.nextInt(5000) + 5000;
    for ( toss=0 ; toss< number_of_tosses ; toss++){
      x = 2*Math.random() - 1;
      y =  2*Math.random() - 1;
      distance_squared = x * x + y * y;
      if(distance_squared <= 1) number_in_circle++;
    }
    pi_estimate = 4 * number_in_circle/((double) number_of_tosses);
    try{
      Socket clientSocket = new Socket("localhost", 4321);
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      out.println(pi_estimate);
      clientSocket.close();
    }catch(Exception e){
    }
  }
}
