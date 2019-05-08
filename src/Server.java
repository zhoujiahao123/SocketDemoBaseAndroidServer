import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    public Server() throws IOException {
        //创建一个ip为本机ip(ipconfig查看即可),端口号为8888的服务端
        serverSocket = new ServerSocket(8888);
        System.out.println("服务已启动");
    }
    public void service() {
        Socket socket = null;
        //开启循环接受客户端的连接请求
        while (true){
            try {
                //该方法会阻塞，直到有新的连接请求
                socket = serverSocket.accept();
                System.out.println("有客户端连接进来");
                ReceiveThread receiveThread = new ReceiveThread(socket);
                receiveThread.start();
                SendMessageThread sendMessageThread = new SendMessageThread(socket);
                sendMessageThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String []args){
        try {
            Server server = new Server();
            server.service();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
