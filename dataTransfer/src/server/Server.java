package server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    static Vector<MyFile> myFiles = new Vector<>();

    public static void main(String[] args) throws Exception {
        int fileId = 0;

        JFrame jFrame = new JFrame("fenetre");
        jFrame.setSize(400,400);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(),BoxLayout.Y_AXIS));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        JScrollPane jScrollPane = new JScrollPane(jPanel);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel jlTitle = new JLabel("Kanty Soc Server");
        jlTitle.setBorder(new EmptyBorder(20,0,10,0));
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        jFrame.add(jlTitle);
        jFrame.add(jScrollPane);
        jFrame.setVisible(true);

        ServerSocket serverSocket = new ServerSocket(1234);
        while (true){
            try{
                Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                int fileNameLength = dataInputStream.readInt();
                if (fileNameLength > 0){
                    byte[] fileNameBytes = new byte[fileNameLength];
                    dataInputStream.readFully(fileNameBytes,0,fileNameBytes.length);
                    String filename = new String(fileNameBytes);
                    int fileContentLength = dataInputStream.readInt();
                    if (fileContentLength > 0){
                        byte[] fileContentBytes = new byte[fileContentLength];
                        dataInputStream.readFully(fileContentBytes,0,fileContentLength);
                        JPanel jpFileRow = new JPanel();
                        jpFileRow.setLayout(new BoxLayout(jpFileRow,BoxLayout.Y_AXIS));
                        JLabel jlFileName = new JLabel(filename);
                        jlFileName.setBorder(new EmptyBorder(10,0,10,0));

                        if(getFileExtension(filename).equalsIgnoreCase("txt")){
                            jpFileRow.setName(String.valueOf(fileId));
                            ListenerMouse lm = new ListenerMouse(myFiles);
                            jpFileRow.addMouseListener(lm);
                            jpFileRow.add(jlFileName);
                            jPanel.add(jpFileRow);
                            jFrame.validate();
                        }else {
                            jpFileRow.setName(String.valueOf(fileId));
                            ListenerMouse lm = new ListenerMouse(myFiles);
                            jpFileRow.addMouseListener(lm);
                            jpFileRow.add(jlFileName);
                            jPanel.add(jpFileRow);

                            jFrame.validate();
                        }
                        myFiles.add(new MyFile(fileId,filename,fileContentBytes,getFileExtension(filename)));
                    }
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    public static String getFileExtension(String fileName){
        int i = fileName.lastIndexOf('.');
        if (i > 0){
            return fileName.substring(i+1);
        }else {
            return "extension invalide.";
        }
    }
}
