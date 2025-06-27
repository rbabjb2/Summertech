import javax.swing.JFrame;

public class Frame {
    JFrame frame = new JFrame("Screen");

    public void makeFrame(){
        frame.setSize(400, 300); // 400 pixels wide, 300 pixels high
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
