import javax.swing.*;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tetris extends JFrame implements KeyListener {
    static JPanel panel = new JPanel();
    static JLabel label = new JLabel();
    static JFrame frame = new JFrame("Screen");
    static int screenSizeY = 10;
    static int screenSizeX = 8;
    static block currentBlock = new block();
    static String[][] screen = new String[screenSizeX][screenSizeY];
    static boolean gameOver = false;
    
        public Tetris() {
                super();
                frame.addKeyListener(this);
                frame.setFocusable(true);
                frame.requestFocus();
        }
    public static void main(String[] args) {
        new Tetris();
        String borderChar = "X";
        currentBlock.screenSizeSet(screenSizeX, screenSizeY);

        for (int y = 0; y < screenSizeY; y++) {
            for (int x = 0; x < screenSizeX; x++) {
                if (x == screenSizeX - 1 || x == 0) {
                    screen[x][y] = borderChar;
                } else if (y == screenSizeY - 1) {
                    screen[x][y] = borderChar;
                } else {
                    screen[x][y] = " ";
                }
            }
        }
        label.setFont(new Font("Monospaced", Font.BOLD, 16));
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        printScreen();
        screen[4][8] = "#";
        screen[currentBlock.posX][currentBlock.posY] = "#";
        printScreen();
        while (gameOver == false) {
            while (screen[currentBlock.posX][currentBlock.posY + 1] == " ") {
                screen[currentBlock.posX][currentBlock.posY] = " ";
                currentBlock.move("down");
                screen[currentBlock.posX][currentBlock.posY] = "#";
                printScreen();
                makeLabels();
                try {
                    java.util.concurrent.TimeUnit.MILLISECONDS.sleep(750);
                } catch (InterruptedException temp) {
                    temp.printStackTrace();
                }
                
            }
            currentBlock.reset("square");
            screen[currentBlock.posX][currentBlock.posY] = "#";
        }
    }

    public static void makeLabels() {
        panel.removeAll();
        String arrayToString = "<html><pre>";
        for (int i = 0; i < screenSizeY; i++) {
            for (int x = 0; x < screenSizeX; x++) {
                arrayToString = arrayToString + screen[x][i];
            }
            arrayToString = arrayToString + "<br>";
        }
        arrayToString = arrayToString + "</pre></html>";
        label.setBounds(50, 50, 1000, 50);
        label.setText(arrayToString);
        panel.add(label);
    }

    public static void printScreen() {
        System.out.println();
        for (int y = 0; y < screenSizeY; y++) {
            for (int x = 0; x < screenSizeX; x++) {
                System.out.print(screen[x][y]);
            }
            System.out.println();
        }
    }

    public static void lineClearDetect() {
        for (i = 0;)
    }
        @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A:
            if (screen[currentBlock.posX - 1][currentBlock.posY] == " ") {
            screen[currentBlock.posX][currentBlock.posY] = " ";
            currentBlock.move("left");
            screen[currentBlock.posX][currentBlock.posY] = "#";
            makeLabels();
            printScreen();
            }
            break;
            case KeyEvent.VK_D:
            if (screen[currentBlock.posX + 1][currentBlock.posY] == " ") {
                screen[currentBlock.posX][currentBlock.posY] = " ";
                currentBlock.move("right");
                screen[currentBlock.posX][currentBlock.posY] = "#";
                makeLabels();
                printScreen();
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }

}
