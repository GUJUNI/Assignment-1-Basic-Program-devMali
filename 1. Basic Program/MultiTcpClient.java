import java.io.*;
import java.net.*;
import java.util.*;

public class MultiTcpClient{
	public static void main(String[] args) throws Exception
	{
		Socket s=new Socket("localhost",6666);
		DataOutputStream dout= new DataOutputStream(s.getOutputStream());
		DataInputStream din=new DataInputStream(s.getInputStream());
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			String strrecived=din.readUTF();
			System.out.println("Server Messaged:"+strrecived);
			System.out.println("Write Your Message");
			String strtosend=scan.nextLine();
			dout.writeUTF(strtosend);
			dout.flush();
			if(strtosend.equals("Exit"))
			{
				System.out.println("Client "+s+" is exiting");
				s.close();
				din.close();
				dout.close();
				break;
			}
		}
	}
}

/*
OUTPUT:

D:\MCA\SEM-2\Adv_Networking>java MultiTcpServer
A new client is connected via Socket[addr=/127.0.0.1,port=64192,localport=6666]
Assigning a new thread to the client
Client Messaged this is client-1
A new client is connected via Socket[addr=/127.0.0.1,port=64193,localport=6666]
Assigning a new thread to the client
Client Messaged this is client-2
Client Messaged exit
*/