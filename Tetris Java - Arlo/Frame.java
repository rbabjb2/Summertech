import java.awt.Color;
import javax.swing.*;

public class Frame extends JFrame{
    JFrame frame = new JFrame("Screen");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();

    public static void main(String[] args) {
        new Frame();
    }

    public Frame(){
        frame.setSize(400, 300); // 400 pixels wide, 300 pixels high
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        label.setText("Hi!");
        panel.add(label);
        panel.setBackground(Color.BLUE);
        frame.add(panel);
    }

}
