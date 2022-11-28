package server;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerNo implements ActionListener {
    JFrame jf;
    public ListenerNo(JFrame jf) {
        this.jf = jf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jf.dispose();
    }
}
