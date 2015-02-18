package justfast;
 
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewClass {

    
    public void con(){
        try {
            ServerSocket ss = new ServerSocket(90,1);
            Socket socket = ss.accept();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //dos.writeUTF("Content Type: text/html");
            //dos.writeUTF("Content Length: 2");
            dos.writeUTF("<html></html>");
        } catch (IOException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}
