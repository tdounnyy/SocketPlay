package felix.duan.socket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

class Client {

    private Socket socket = null;
    private OutputStream os;

    public Client() {

    }

    public boolean init(InetAddress address, int port) {
        try {
            socket = new Socket(address, port);
            os = socket.getOutputStream();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void isConnected() {
        System.out.println("Client.isConnected " + socket.isConnected());
    }

    public void isClosed() {
        System.out.println("Client.isClosed " + socket.isClosed());
    }

    public boolean isAlive() {
        boolean alive;
        try {
            socket.sendUrgentData(0);
            alive = true;
        } catch (IOException e) {
            e.printStackTrace();
            alive = false;
        }
        System.out.println("Client.testConnection alive = " + alive);
        return alive;
    }

    public void close() {
        try {
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void greeting() {
        String hello = "client: hello server";
        try {
            os.write(hello.getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
