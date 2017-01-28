package testing;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class MyTest1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",2222);
        SocketChannel channel = socket.getChannel();
    }
}
