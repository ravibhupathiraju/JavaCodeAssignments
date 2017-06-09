//to run this in command line, point to the project location. 
//From there run the command java -cp bin packagename.classname
//

package chatclientarray;

import java.io.*;
import java.net.Socket;
import java.net.*;

public class Chatclientarray {

	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;
		System.out.println("Enter your input");
		while (true) {
			BufferedReader inFromUser = new BufferedReader(
					new InputStreamReader(System.in));
			try {
				   // Step 1. create a socket
				Socket clientSocket = new Socket("localhost", 3000);
			      // Step 2.  Get input from the Keyboard
				BufferedReader inFromServer = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				// Step 3.  Creating the stream to send to the server
				DataOutputStream outToServer = new DataOutputStream(
						clientSocket.getOutputStream());
				sentence = inFromUser.readLine();

				if (sentence.equals("quit")) {
					break;
				}

				outToServer.writeBytes(sentence + '\n');

				modifiedSentence = inFromServer.readLine();

				System.out.println("FROM SERVER: " + modifiedSentence);
			} catch (ConnectException e) {
				System.out.println("Please check if the server is running");
				break;
			} catch (Exception e){
				System.out.println("Please report the incident to IT team");
				break;
			} finally {
				System.out.println("Enter your next input or close the window:");
			}

		}
	}
	// clientSocket.close();
}
