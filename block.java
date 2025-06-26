public class block {
    private String blockType;
    public int posX;
    public int posY;
    private int screenSizeX;
    private int screenSizeY;

    public void reset(String type) {
        this.blockType = type;
        if (this.blockType == "square") {
            this.posX = screenSizeX / 2;
            this.posY = 0;
        } 
    }
    //needs wall detection
    public void move(String direction) {
        if (direction == "down") {
            this.posY++;
        } else if (direction == "left") {
            this.posX--;
        } else if (direction == "right") {
            this.posX++;
        } else {
            System.out.println("Error: Please check the move script and where you call it.");
        }
    }
    public int[] getPos() {
        int[] pos = new int[2];
        pos[0] = this.posX;
        pos[1] = this.posY;
        return pos;
    }

    public void screenSizeSet(int screenSizeX, int screenSizeY) {
        this.screenSizeX = screenSizeX;
        this.screenSizeY = screenSizeY;
        this.reset("square");
        }

    public String getType() {
        return this.blockType;
    }
}
