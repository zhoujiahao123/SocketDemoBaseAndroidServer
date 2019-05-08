import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {
    private BufferedReader br;
    public ReceiveThread(Socket socket) throws IOException {
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        //循环接收来自客户端的消息
        while(true){
            String content="";
            try {
                while ((content = br.readLine())!=null){
                    System.out.println("来自客户端：");
                    System.out.println(content);
                    System.out.println();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
