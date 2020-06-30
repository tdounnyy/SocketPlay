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
}
