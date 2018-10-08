import java.io.*;
import java.net.*;
//Christopher Coscarella - Solo
public class EchoServer
{
	public static void main(String[] args) throws IOException {

		int port = 8008;
		
		
		try{
			ServerSocket serverSocket = new ServerSocket(port);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
			String inputLine;
			while((inputLine = in.readLine()) != null){
				System.out.println("Recieved message: " + inputLine);
				out.println("Server: " + inputLine);
			}
		}catch (IOException e) {
			System.out.println("Exception caught");
		}
	}
	
}


