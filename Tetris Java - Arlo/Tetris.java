


public class Tetris {
    
    public static void main(String[] args) {
        block currentBlock = new block();
        int screenSizeY = 10;
        int screenSizeX = 8;
        char borderChar = 'X';
        char[][] screen = new char[screenSizeX][screenSizeY];
        currentBlock.screenSizeSet(screenSizeX, screenSizeY);
        new Frame();
        

        for (int y = 0; y < screenSizeY; y++) {
            for (int x = 0; x < screenSizeX; x++) {
                if (x == screenSizeX - 1 || x == 0) {
                    screen[x][y] = borderChar;
                } else if (y == screenSizeY - 1) {
                    screen[x][y] = borderChar;
                } else {
                    screen[x][y] = ' ';
                }
            }
        }
        printScreen(screen, screenSizeX, screenSizeY);
        screen[4][8] = '#';
        screen[currentBlock.posX][currentBlock.posY] = '#';
        printScreen(screen, screenSizeX, screenSizeY);

        while (screen[currentBlock.posX][currentBlock.posY + 1] == ' ') {
            screen[currentBlock.posX][currentBlock.posY] = ' ';
            currentBlock.move("down");
            screen[currentBlock.posX][currentBlock.posY] = '#';
            printScreen(screen, screenSizeX, screenSizeY);
        }
        currentBlock.reset("square");
    }
    public static void printScreen(char[][] screen, int screenSizeX, int screenSizeY) {
        System.out.println();
        for (int y = 0; y < screenSizeY; y++) {
            for (int x = 0; x < screenSizeX; x++) { 
                System.out.print(screen[x][y]);
            }
            System.out.println();
        }
    }

}
