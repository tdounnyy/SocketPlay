package felix.duan.socketchat.socket

import java.io.InputStream
import java.io.OutputStream
import java.net.Socket

class SocketConnection(val config: ConnectConfig) : Connection {

    private var socket: Socket? = null

    private var inStream: InputStream? = null

    private var outStream: OutputStream? = null

    private val byteArray = ByteArray(1024)

    override fun connect() {
        socket = Socket(config.address, config.port).also {
            inStream = it.getInputStream()
            outStream = it.getOutputStream()
        }
    }

    override fun close() {
        inStream?.close()
        outStream?.close()
        socket?.close()
        inStream = null
        outStream = null
        socket = null
    }

    override fun read(byteArray: ByteArray): Int {
        TODO("Not yet implemented")
    }

    override fun write(byteArray: ByteArray) {
        TODO("Not yet implemented")
    }

    override fun isConnected(): Boolean {
        TODO("Not yet implemented")
    }
}