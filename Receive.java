import java.net.*;
import java.io.*;

public class Receive // server
{
	public static void main(String[] args) throws Exception
	{
	ServerSocket     ss = new ServerSocket(1234);	// "listens" for connections to port 1234
	String serverAddress = InetAddress.getLocalHost().getHostAddress();
  	int    serverPort    = ss.getLocalPort();
  	System.out.println("Receive server is up at " + serverAddress
		           + " on port " + serverPort
		           + " waiting to accept connects and receive messages!");
  	while(true)// loop forever
    {
		try 
		{  
        Socket s = ss.accept();//wait for next connect
        DataInputStream dis = new DataInputStream(s.getInputStream());
        String message = dis.readUTF();//wait for send
        System.out.println("Received: " + message + " from " + s.getInetAddress().getHostAddress());
        s.close();// hang up on this client after one message
        }
		catch(IOException ioe)
	    {
		System.out.println(ioe);
	    }
    }
  }
}