package server;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class ListenerMouse implements MouseListener {
    Vector<MyFile> myFiles;
    public ListenerMouse(Vector<MyFile> myFiles) {
        this.myFiles = myFiles;
    }
    public JFrame createFrame(String fileName,byte[] fileData,String fileExtension){
        JFrame jFrame = new JFrame("fenetre");
        jFrame.setSize(400,400);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        JLabel jlTitle = new JLabel("Kanty Soc File Downloader");
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlTitle.setBorder(new EmptyBorder(20,0,10,0));

        JLabel jlPrompt = new JLabel("Telecharger "+fileName+" ?");
        jlPrompt.setBorder(new EmptyBorder(20,0,10,0));
        jlPrompt.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton jbYes = new JButton("Yes");
        jbYes.setPreferredSize(new Dimension(150,75));

        JButton jbNo = new JButton("No");
        jbNo.setPreferredSize(new Dimension(150,75));

        JLabel jlFileContent = new JLabel();
        jlFileContent.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel jpButtons = new JPanel();
        jpButtons.setBorder(new EmptyBorder(20,0,10,0));
        jpButtons.add(jbYes);
        jpButtons.add(jbNo);

        if (fileExtension.equalsIgnoreCase("txt")){
            jlFileContent.setText("<html>" +new String(fileData) +"</html>");
        }else {
            jlFileContent.setIcon(new ImageIcon(fileData));
        }
        ListenerYes ly = new ListenerYes(fileData,fileName,jFrame);
        jbYes.addActionListener(ly);
        ListenerNo ln = new ListenerNo(jFrame);
        jbNo.addActionListener(ln);

        jPanel.add(jlTitle);
        jPanel.add(jlPrompt);
        jPanel.add(jlFileContent);
        jPanel.add(jpButtons);

        jFrame.add(jPanel);

        return jFrame;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel jPanel = (JPanel) e.getSource();
        int fileId = Integer.parseInt(jPanel.getName());
        for (MyFile myFile: myFiles){
            if (myFile.getId() == fileId){
                JFrame jfPreview = createFrame(myFile.getName(),myFile.getData(),myFile.getFileExtension());
                jfPreview.setVisible(true);
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
