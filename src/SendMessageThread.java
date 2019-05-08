import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendMessageThread extends Thread{
    private OutputStream os;
    private Scanner input = new Scanner(System.in);
    public SendMessageThread(Socket socket) throws IOException{
        os = socket.getOutputStream();
    }
    @Override
    public void run() {
        while (true){
            String content = input.nextLine();
            try {
                os.write((content+"\r\n").getBytes("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
