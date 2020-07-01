package felix.duan.socket.client;

import felix.duan.socket.IEntryPoint;
import felix.duan.socket.util.Consts;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientEntry implements IEntryPoint {

    public void start() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        int port = Consts.PORT;

        Client client = new Client();
        if (!client.init(address, port)) {
            System.out.println("client init fail");
            Runtime.getRuntime().exit(-1);
        }

        while (true) {
            client.isConnected();
            client.isClosed();
            if (!client.isAlive()) {
                client.close();
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
