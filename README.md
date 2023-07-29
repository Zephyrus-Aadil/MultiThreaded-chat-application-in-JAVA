# MultiThreaded-chat-application-in-JAVA
A simple Multi-threaded chat application built using Java. It can handle Upto 1K request at a time.  
Packages used:-

`java.io.*` - for all input and Output stream 

`java.net.*` - for creating socket in java

`java.util.concurrent.ExecutorService` -  The ExecutorService interface extends Executor by adding methods that help manage and control the execution of threads. 

`Client.java` : It try to connect with the local host Server running at 127.0.0.1 with port 9001

`Server.java`: This server Runs at 127.0.0.1 and Listen in port 9001. This server can handle multiple request at a time . It has been achived by using Java virtual Thread. 

**STEPS TO RUN THE APPLICATION IN YOUR SYSTEM**

1) Need to have JDK 18 installed in your system 
2) Run `javac server.java` in your favourite terminal
3) Run `java client.java`
4) Start the server first by `java server`
5) Open another terminal and connect clients by `java client`

![Screenshot from 2023-07-29 12-34-48](https://github.com/Zephyrus-Aadil/MultiThreaded-chat-application-in-JAVA/assets/72851384/501e0336-4b3b-4cc8-ab11-4c201c1870e4)



![Screenshot from 2023-07-29 12-35-38](https://github.com/Zephyrus-Aadil/MultiThreaded-chat-application-in-JAVA/assets/72851384/0d42c57d-a524-4c4f-b51f-203b584bbd12)
