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
package Networking.Client;

import Networking.MakeServer.chartServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


/**
 *
 * @author Loser
 */
public class ClientServer {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException{
        Socket client = new Socket("127.0.7.3", 10007);
        chartServer.Message("Connection has built! Start chating....");
        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintStream output = new PrintStream(client.getOutputStream());
        BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true) {
            System.out.print("Client: ");
            line = clientInput.readLine();
            output.println(line);
            line = input.readLine();
            System.out.println("Server: " + line + "");
            if (line.equals("bye")) {
             break;
            }
        }
        client.close();
        input.close();
        clientInput.close();
        output.close();
    }
}
