/*
    Software Engineer
    ---------------------------------------
    Md. Arab Hossain
    Email: arabhossain317@diu.edu.bd
           green.arab1995@gmail.com
    Mobile: +8801827-464330
            +8801737-331037
    Daffodil International University(Student)
 */
package Networking.MakeServer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Loser
 */
public class chartServer {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws  IOException {
        ServerSocket server = new ServerSocket(10007,100);
        Message("Server Socket is Ready. Listining for client....");
        Socket sock = server.accept();
        Message("Connect with Client Successfuly! Waiting for response...");
        BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintStream output = new PrintStream(sock.getOutputStream());
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true) {
            line = input.readLine();
            if (line.equals("bye")) {
                 break;
            }
            System.out.println(sock.getInetAddress().getHostName()+": " + line);
            System.out.print("Server: ");
            line = serverInput.readLine();
            output.println(line);
        }
        server.close();
        sock.close();
        input.close();
        output.close();
        serverInput.close();
    }

    /**
     *
     * @param msg
     */
    public static void Message(String msg){
        System.out.println(msg);
    }
}

