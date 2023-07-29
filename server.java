import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;



/*class loginCredential{
    private String userName;
    private String clientIp;
    private String passWord="1234";
    private String[] logs = new String[1024];

    loginCredential(String userName,String clientIp) {
        this.userName = userName;
        this.clientIp = clientIp;
    } 
    void verify(loginCredential client) {
        if (find(client.userName) && client.passWord.equals(passWord)){

        }
    }
}
*/

class handleReq extends Thread{
    Socket sock;
    Scanner sc = new Scanner(System.in);
    handleReq(Socket sock){
        this.sock = sock;
    }
    void clientInfo () {
        System.out.println("Client Accepted : "+sock.getInetAddress().toString()+":"+sock.getPort());
        System.out.flush();
    }
    public void run() {
        if ( pingBack() == false) {
            close();
        } else {
            clientInfo();
            FromClient();
            toClient();
        }
    }
    void FromClient () {
        try {
        DataInputStream dIn = new DataInputStream(sock.getInputStream());
        byte[] buff = new byte[1024];
        dIn.read(buff);
        if (buff[0] == (byte)0) {
            return ;
        } else {
        String temp = new String(buff);
        System.out.println("Client :"+temp+temp.length());
        System.out.flush();
        
        }
        
    } catch (Exception e) {
            System.out.println(e);
        }
    }
    void toClient () {
        try {
            DataOutputStream dOut = new DataOutputStream(sock.getOutputStream());
            String msg = "Ok";
            dOut.write(msg.getBytes());
            dOut.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void close () {
        try{
        sock.close();
        sc.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    boolean pingBack() {
        try {
            DataInputStream dIn = new DataInputStream(sock.getInputStream());
            byte[] buff = new byte[1024];
            dIn.read(buff);
            DataOutputStream dOut = new DataOutputStream(sock.getOutputStream());
            dOut.write(buff);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }   
}


class server {
        public static void main(String[] args) {
            int cnt = 1;
            try {
                InetAddress ip = InetAddress.getByName("127.0.0.1");
                ServerSocket servSock =  new ServerSocket(9001,50,ip);

                System.out.println("Server Hosted at IP:"+servSock.getInetAddress()+ "Port :"+servSock.getLocalPort());
                System.out.println("Listening...");
                System.out.flush();
                ExecutorService pool = Executors.newFixedThreadPool(2);
                while(cnt <=10) {
                    
                   
                try{
               
                    
                Socket sock  = servSock.accept();
                handleReq req = new handleReq(sock);

                pool.execute(req);


                
                cnt++ ;
                
                }        
             catch (Exception e) {
                System.out.println("Exception occured in"+ e);
            }
        } 
        if (cnt >10)  {
            pool.shutdown();
            servSock.close();
        } 

        } catch (Exception e) {
            System.out.println(e);
        }
         
    }
}
