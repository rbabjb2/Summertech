import javax.swing.*;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener{
    int screenSizeX;
    int screenSizeY;
    JFrame frame = new JFrame("Screen");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();

    public static void main(String[] args) {
        new Frame(8, 10);
    }

    public void makeLabels(String[][] array, int screenSizeX, int screenSizeY) {
        panel.removeAll();
        String arrayToString = "<html><pre>";
        for (int i = 0; i < screenSizeY; i++) {
            for (int x = 0; x < screenSizeX; x++) {
                arrayToString = arrayToString + array[x][i];
            }
            arrayToString = arrayToString + "<br>";
        }
        arrayToString = arrayToString + "</pre></html>";
        label.setBounds(50, 50, 1000, 50);
        label.setText(arrayToString);
        panel.add(label);
    }

    public Frame(int screenSizeX2, int screenSizeY2) {
        label.setFont(new Font("Monospaced", Font.BOLD, 16));
        screenSizeX = screenSizeX2;
        screenSizeY = screenSizeY2;
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        frame.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A:
            Tetris.currentBlock.move("left");
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }



}
