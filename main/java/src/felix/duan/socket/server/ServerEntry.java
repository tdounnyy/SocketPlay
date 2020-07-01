package felix.duan.socket.server;

import felix.duan.socket.IEntryPoint;
import felix.duan.socket.util.Consts;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class ServerEntry implements IEntryPoint {

    @Override
    public void start() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        int port = Consts.PORT;

        Server server = new Server();
        if (!server.init(port, 20, address)) {
            System.out.println("init fail");
            Runtime.getRuntime().exit(-1);
        }
        server.printServerSocket();
        while (true) {
            server.listen();
        }
//        server.read();
    }
}
