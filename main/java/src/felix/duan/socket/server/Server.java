package felix.duan.socket.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class Server {

    private ServerSocket serverSocket = null;
    private List<Socket> socketList = new ArrayList<>();

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

    public Socket listen() {
        Socket socket = null;
        System.out.println("Server.listen");
        try {
            socket = serverSocket.accept();
            System.out.println("Server.listen accept " + socket);
            socketList.add(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return socket;
    }

    public void read() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("while");
        }
    }

    public void disconnect() {
        for (Socket socket : socketList) {
            try {
                socket.close();
                System.out.println("Server.disconnect " + socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
