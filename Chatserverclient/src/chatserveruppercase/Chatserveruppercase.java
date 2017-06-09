//to run this in command line, point to the project location. 
//From there run the command java -cp bin packagename.classname
//

package chatserveruppercase;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.*;

public class Chatserveruppercase {

    private static final int PORT = 3000;

    public static void main(String args[]) throws Exception {
        System.out.println("server running...");
        ServerSocket serverSocket = new ServerSocket(Chatserveruppercase.PORT);
        while (true) {
//            byte[] receiveData = new byte[1024];
            Socket socket= serverSocket.accept(); //wait for incoming request 
            
            BufferedReader inFromClient =
                    new BufferedReader(
                    new InputStreamReader(
                                 socket.getInputStream()));  //read request from connectionSocket
            
            DataOutputStream outToClient =
                    new DataOutputStream(
                    socket.getOutputStream());   
            
            String clientSentence = inFromClient.readLine();

            String capitalizedSentence = clientSentence.toUpperCase() + '\n';

            outToClient.writeBytes(capitalizedSentence); //write request to client
            socket.close();
//           

        }
    }
}
