import java.io.*;
import java.net.*;
import java.util.*;
public class spot2cli2
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket cs=new DatagramSocket();
		/*String blank=new String();
		byte[] sbm=new byte[1024];
		sbm=blank.getBytes();
		InetAddress ip1=InetAddress.getByName("localhost");
		DatagramPacket sp1=new DatagramPacket(sbm,sbm.length,ip1,9876);
		cs.send(sp1);*/
		while(true)
		{
		byte[] sd=new byte[1024];
		byte[] rd=new byte[1024];
		String send;
		send=in.readLine();
		
		sd=send.getBytes();
		InetAddress ip=InetAddress.getByName("localhost");
		DatagramPacket sp=new DatagramPacket(sd,sd.length,ip,9876);
		cs.send(sp);
		if(send.equals("bye"))
			break;
		DatagramPacket rp=new DatagramPacket(rd,rd.length);
		cs.receive(rp);
		String rec=new String(rp.getData());
		rec=rec.trim();
		System.out.println("From server:"+rec);
		
		}
	}
}
		