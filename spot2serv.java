import java.io.*;
import java.net.*;
import java.util.*;
public class spot2serv
{
	public static void main(String[] args) throws IOException
	{
		ArrayList<Integer> portarray=new ArrayList<Integer>();
		DatagramSocket ss=new DatagramSocket(9876);
		while(true)
		{
		byte[] recdata=new byte[1024];
		DatagramPacket recpack=new DatagramPacket(recdata,recdata.length);
		ss.receive(recpack);
		InetAddress ip=recpack.getAddress();
		int port=recpack.getPort();
		portarray.add(port);
		String rec=new String(recpack.getData());
		rec=rec.trim();
		System.out.println(rec+"from"+port);
		String msg=new String(rec+"from"+port);
		if(rec.equals("bye"))
			break;
		for(int dport:portarray)
		{
			if(dport!=port)
			{
				byte[] sd=new byte[1024];
				sd=msg.getBytes();
				DatagramPacket sp=new DatagramPacket(sd,sd.length,ip,dport);
		        ss.send(sp);
			}
		}
		//DatagramPacket sp=new DatagramPacket(sd,sd.length,ip,port);
		//ss.send(sp);
		}
	}
}