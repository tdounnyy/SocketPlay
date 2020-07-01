package felix.duan.socket.server;

import felix.duan.socket.IEntryPoint;
import felix.duan.socket.util.Consts;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
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
            Socket socket = server.listen();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] buffer = new byte[1024];
                        InputStream inputStream = socket.getInputStream();
                        while (true) {
                            int length = inputStream.read(buffer);
                            String msg = new String(buffer, 0, length, "utf-8");
                            System.out.println("" + System.currentTimeMillis());
                            System.out.println(msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
//        server.read();
    }
}
