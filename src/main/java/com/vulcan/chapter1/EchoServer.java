package com.vulcan.chapter1;

/**
 * @author Vulcan Pong [vulcanpong@yeah.net]
 */

import java.io.*;
import java.net.*;
public class EchoServer {
    private static final int port=8000;
    private ServerSocket serverSocket;

    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("serverSocket");
    }

    public String echo(String msg) {
        return "echo:" + msg;
    }

    private PrintWriter getWriter(Socket socket)throws IOException{
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut,true);
    }
    private BufferedReader getReader(Socket socket)throws IOException{
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public void service() {
        while (true) {
            Socket socket=null;
            try {
                socket = serverSocket.accept();  //µÈ´ý¿Í»§Á¬½Ó
                System.out.println("New connection accepted "
                        +socket.getInetAddress() + ":" +socket.getPort());
                BufferedReader br =getReader(socket);
                PrintWriter pw = getWriter(socket);

                String msg = null;
                while ((msg = br.readLine()) != null) {
                    System.out.println(msg);
                    pw.println(echo(msg));
                    if (msg.equals("bye")) //
                        break;
                }
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                try{
                    if(socket!=null)socket.close();  //
                }catch (IOException e) {e.printStackTrace();}
            }
        }
    }

    public static void main(String args[])throws IOException {
        new EchoServer().service();
    }
}
