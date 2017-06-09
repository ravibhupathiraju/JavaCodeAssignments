//This chat server programs reads unsorted integers from client and sends sorted integers back to client
//to run this in command line, point to the project location. 
//From there run the command java -cp bin packagename.classname
//

package chatServerArray;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class ChatServerArray {

	private static final int PORT = 3000;

	public static void main(String args[]) throws Exception {
		System.out.println("server running...");
		ServerSocket serverSocket = new ServerSocket(ChatServerArray.PORT);
		while (true) {
			// byte[] receiveData = new byte[1024];
			Socket socket = serverSocket.accept(); // wait for incoming request
			
			//read request from connection socket
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(socket.getInputStream())); 

			//Creating data stream for output
			DataOutputStream outToClient = new DataOutputStream(
					socket.getOutputStream());

			//reading data from client
			String clientSentence = inFromClient.readLine();

			//pass the space delimited input to String array 
			String[] ss = clientSentence.split(" ");

			//Move the String array to Integer Arraylist  
			ArrayList intList = new ArrayList(ss.length);
			for (int j = 0; j < ss.length; j++) {
				intList.add(Integer.parseInt(ss[j]));
			}
			//sort the arraylist
			Collections.sort(intList);

			//move sorted integers to string
			String outList = String.valueOf(intList.get(0));
			for (int i = 1; i < ss.length; i++) {
				outList = outList + " " + String.valueOf(intList.get(i));
			}
			//write to client
			outToClient.writeBytes(" sorted output is " + outList);
			
			//socket close
			socket.close();
		}
	}
}
