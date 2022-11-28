package client;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class ListenerSend implements ActionListener {
    File[] fileTosend;
    JLabel jlFilename;
    public ListenerSend(File[] f, JLabel jl){
        this.fileTosend = f;
        this.jlFilename = jl;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(fileTosend[0] == null){
            jlFilename.setText("Veuillez d'abord choisir un fichier");
        }else {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileTosend[0].getAbsolutePath());
                Socket socket = new Socket("localhost",1234);

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String filename = fileTosend[0].getName();
                byte[] fileNameBytes = filename.getBytes();

                byte[] fileContentBytes = new byte[(int)fileTosend[0].length()];
                fileInputStream.read(fileContentBytes);

                dataOutputStream.writeInt(fileNameBytes.length);
                dataOutputStream.write(fileNameBytes);

                dataOutputStream.writeInt(fileContentBytes.length);
                dataOutputStream.write(fileContentBytes);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
