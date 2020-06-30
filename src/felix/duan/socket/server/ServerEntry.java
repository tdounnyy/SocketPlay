package felix.duan.socket.server;

import felix.duan.socket.util.Consts;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

class ServerEntry {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        int port = Consts.PORT;

        Server server = new Server();
        if (!server.init(port, 20, address)) {
            System.out.println("init fail");
            Runtime.getRuntime().exit(-1);
        }
        server.printServerSocket();
        server.listen();
//        server.read();
        server.disconnect();
   }
}
