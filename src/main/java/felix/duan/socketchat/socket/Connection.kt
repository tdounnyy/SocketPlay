package felix.duan.socketchat.socket

interface Connection {
    fun connect()
    fun close()
    fun read(byteArray: ByteArray): Int
    fun write(byteArray: ByteArray)
    fun isConnected(): Boolean
}