package felix.duan.socket;

import felix.duan.socket.client.ClientEntry;
import felix.duan.socket.server.ServerEntry;

import java.net.UnknownHostException;

class Entry {
    public static void main(String[] args) {
        IEntryPoint entryPoint = null;
        if (isServerMode(args[1])) {
            entryPoint = new ServerEntry();
        } else {
            entryPoint = new ClientEntry();
        }

        try {
            entryPoint.start();
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException");
            e.printStackTrace();
        }
    }

    private static boolean isServerMode(String arg) {
        if ("server".equals(arg)) {
            System.out.println("server mode");
            return true;
        } else {
            System.out.println("client mode");
            return false;
        }
    }
}
