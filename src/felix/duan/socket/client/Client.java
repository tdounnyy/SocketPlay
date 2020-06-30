package felix.duan.socket.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

class Client {

    private Socket socket = null;

    public Client() {

    }

    public boolean init(InetAddress address, int port) {
        try {
            socket = new Socket(address, port);
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
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
