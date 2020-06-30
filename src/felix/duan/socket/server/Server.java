package felix.duan.socket.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

    private ServerSocket serverSocket = null;
    private Socket socket = null;

    public boolean init(int port, int backlog, InetAddress address) {
        try {
            serverSocket = new ServerSocket(port, backlog, address);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void printServerSocket() {
        int localPort = serverSocket.getLocalPort();
        InetAddress inetAddress = serverSocket.getInetAddress();
        System.out.println("printServerSocket " + localPort + " " + inetAddress);
    }

    public void listen() {
        System.out.println("Server.start");
        try {
            socket = serverSocket.accept();
            System.out.println("Server.start after accept");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
