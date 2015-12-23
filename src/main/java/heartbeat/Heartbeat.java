package heartbeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mkhanwalkar on 12/21/15.
 */
public class Heartbeat {

    String targetHost ;
    int port ;
    int interval ;
    int numMisses;



    public Heartbeat(int port, String targetHost, int interval , int numMisses)
    {
        this.targetHost = targetHost;
        this.port = port ;
        this.interval = interval ;
        this.numMisses = numMisses;
    }


    // try to connect to target host , if successful set up task to connect to host .
    // else set up server to listen to incoming connections .

    public void init()
    {
        if (connect())
        {
            System.out.println("Connected as Client ");
            Thread t = new Thread(()->{

                while(true)
                {
                    out.println("Hello from client");
                    out.flush();
                    try {
                    System.out.println(input.readLine());
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });

            t.start();


        }
        else
        {
            server();
        }

    }


    public void destroy()
    {

    }

    Socket s ;
    BufferedReader input ;
    PrintWriter out ;

    public boolean connect()
    {

        try {
            s = new Socket(targetHost, port);
            input =
                    new BufferedReader(new InputStreamReader(s.getInputStream()));

            out =
                    new PrintWriter(s.getOutputStream(), true);
            return true;

        } catch (IOException e) {
           // e.printStackTrace();
            return false ;
        }

    }

    public void server ()
    {

        {
            Thread t = new Thread(()->{


                try {
                    ServerSocket listener = new ServerSocket(port);
                    try {
                        while(true) {
                             Socket socket = listener.accept();
                            System.out.println("Listening as server");
                           // Handler handler = (Handler) Class.forName(handlerType).newInstance();
                            //handler.setSocket(socket);
                         Thread t1 = new Thread(()->{

                             while(true) {
                                 try {
                                     BufferedReader input =
                                             new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                     PrintWriter out =
                                             new PrintWriter(socket.getOutputStream(), true);
                                     System.out.println(input.readLine());
                                     out.println("Hello from server");
                                     out.flush();

                                 } catch (IOException e) {
                                     e.printStackTrace();
                                 }
                             }


                           });
                            //Thread t1 = new Thread(handler);
                            t1.start();
                        }
                    }
                    finally {
                        listener.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            });

            t.start();



        }

    }

}
