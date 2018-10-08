import java.io.*;
import java.net.*;
//Christopher Coscarella - Solo
public class EchoClient	
{
	public static void main(String[] args){
	
		String hostname = args[0];
		int port = 8008;
		
		try{
			Socket clientSocket = new Socket(hostname, port);
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			String userInput;

			while ((userInput = stdIn.readLine()) != null){
				String s = stdIn.readLine();
				System.out.println(s);
				out.println(in.readLine());
			}

			System.err.println("Closing Connection to " + hostname);
			out.close();
			in.close();
			clientSocket.close();

		}catch (UnknownHostException e){
			System.err.println("Unknwon hostname");
			System.exit(1);
		}catch (IOException e){
			System.err.println("Couldn't get I/O for connection");
			System.exit(1);
		}
			
	}
}

