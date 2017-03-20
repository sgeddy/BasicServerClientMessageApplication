import java.net.*;
import java.io.*;

public class Send   	// client
{
public static void main(String[] args) throws Exception
	{
	if (args.length != 2)
	{
	 System.out.println("Provide target address and message to be sent (enclosed in quotes) as the command line parameters.");
	 return;
    }
    System.out.println("Sending: " + args[1] + " to " + args[0]);
    
	Socket s = new Socket(args[0], 1234); // establish CONNECTION to server
	DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	dos.writeUTF(args[1]);
	System.out.println("message sent");		// don't hang up, server will
	}
}
