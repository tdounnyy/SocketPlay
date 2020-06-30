package felix.duan.socket.client;

import felix.duan.socket.util.Consts;

import java.net.InetAddress;
import java.net.UnknownHostException;

class ClientEntry {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        int port = Consts.PORT;

        Client client = new Client();
        if (!client.init(address, port)) {
            System.out.println("client init fail");
            Runtime.getRuntime().exit(-1);
        }

        client.isConnected();
    }
}
