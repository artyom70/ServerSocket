import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket(8606, 50, InetAddress.getByName("localhost"));
			Socket client = socket.accept();
			
			OutputStream out = client.getOutputStream();
			InputStream in = client.getInputStream();
			
			DataOutputStream dout = new DataOutputStream(out);
			DataInputStream din = new DataInputStream(in);
			
			String line = null;
			
			while(true) {
				line = din.readUTF();
				System.out.println(line);
				dout.writeUTF(line);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
