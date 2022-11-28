package client;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class Client {
    public static void main(String[] args) {
        File[] fileToSend = new File[1];

        JFrame jFrame = new JFrame("fenetre");
        jFrame.setSize(450,450);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(),BoxLayout.Y_AXIS));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jlTitle = new JLabel("Kanty Soc Client");
        jlTitle.setBorder(new EmptyBorder(20,0,10,0));
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel jlFilename = new JLabel("Choisir le fichier a envoyé");
        jlFilename.setBorder(new EmptyBorder(50,0,0,0));
        jlFilename.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel jpButton = new JPanel();
        jpButton.setBorder(new EmptyBorder(75,0,10,0));

        JButton jbSendFile = new JButton("Send");
        jbSendFile.setPreferredSize(new Dimension(150,75));

        JButton jbChooseFile = new JButton("Parcourir");
        jbChooseFile.setPreferredSize(new Dimension(150,75));

        jpButton.add(jbSendFile);
        jpButton.add(jbChooseFile);

        ListenerChoose lc = new ListenerChoose(fileToSend,jlFilename);
        jbChooseFile.addActionListener(lc);

        ListenerSend ls = new ListenerSend(fileToSend,jlFilename);
        jbSendFile.addActionListener(ls);

        jFrame.add(jlTitle);
        jFrame.add(jlFilename);
        jFrame.add(jpButton);
        jFrame.setVisible(true);
    }
}
