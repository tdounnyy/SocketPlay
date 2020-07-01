package felix.duan.socket;

import felix.duan.socket.client.ClientEntry;
import felix.duan.socket.server.ServerEntry;

import java.net.UnknownHostException;

public class Entry {
    public static void main(String[] args) {
        System.out.println("Entry.main " + args.length);
        for (String arg : args) {
            System.out.println("arg = " + arg);
        }
        IEntryPoint entryPoint = null;
        if (isServerMode(args)) {
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

    private static boolean isServerMode(String[] args) {
        if (args != null && args.length > 0 && "server".equals(args[0])) {
            System.out.println("server mode");
            return true;
        } else {
            System.out.println("client mode");
            return false;
        }
    }
}
