package server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

public class ListenerYes implements ActionListener {
    byte[] fileData;
    String fileName;
    JFrame jFrame;

    public ListenerYes(byte[] fileData, String fileName, JFrame jFrame) {
        this.fileData = fileData;
        this.fileName = fileName;
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File fileToDownload = new File(fileName);
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileToDownload);
            fileOutputStream.write(fileData);
            fileOutputStream.close();
            jFrame.dispose();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
