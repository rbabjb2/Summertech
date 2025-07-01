public class block {
    private String blockType;
    public int blockNumber;
    public int posX;
    public int posY;
    private int screenSizeX;
    private int screenSizeY;
    public boolean isBottom;
    public boolean isLeft;
    public boolean isRight;

    public void reset(String type) {
        this.blockType = type;
        isBottom = false;
        isLeft = false;
        isRight = false;
        if (this.blockType == "square") {
            this.posX = screenSizeX / 2;
            this.posY = 0;

        } else if (this.blockType == "line") {
            if (blockNumber == 1) {
                this.posX = (screenSizeX / 2) - 2;
                this.posY = 0;
                isBottom = true;
                isLeft = true;
            } else if (blockNumber == 2) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 0;
                isBottom = true;
            } else if (blockNumber == 3) {
                this.posX = screenSizeX / 2;
                this.posY = 0;
                isBottom = true;
            } else if (blockNumber == 4) {
                this.posX = (screenSizeX / 2) + 1;
                this.posY = 0;
                isBottom = true;
                isRight = true;
            } else {
                System.out.println("For some reason block number = " + blockNumber);
                System.exit(0);
            }

        } else if (this.blockType.equalsIgnoreCase("l")) {
            if (blockNumber == 1) {
                this.posX = (screenSizeX / 2) - 2;
                this.posY = 0;
                isLeft = true;
            } else if (blockNumber == 2) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 0;
                isBottom = true;
            } else if (blockNumber == 3) {
                this.posX = screenSizeX / 2;
                this.posY = 0;
                isBottom = true;
                isRight = true;
            } else if (blockNumber == 4) {
                this.posX = (screenSizeX / 2) - 2;
                this.posY = 1;
                isBottom = true;
                isLeft = true;
                isRight = true;
            } else {
                System.out.println("For some reason block number = " + blockNumber);
                System.exit(0);
            }

        } else if (this.blockType == "cube") {
            if (blockNumber == 1) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 0;
                isLeft = true;
            } else if (blockNumber == 2) {
                this.posX = (screenSizeX / 2);
                this.posY = 0;
                isRight = true;
            } else if (blockNumber == 3) {
                this.posX = screenSizeX / 2 - 1;
                this.posY = 1;
                isBottom = true;
                isLeft = true;
            } else if (blockNumber == 4) {
                this.posX = (screenSizeX / 2);
                this.posY = 1;
                isBottom = true;
                isRight = true;
            } else {
                System.out.println("For some reason block number = " + blockNumber);
                System.exit(0);
            }

        } else if (this.blockType.equalsIgnoreCase("j")) {

        } else if (this.blockType.equalsIgnoreCase("s")) {

        } else if (this.blockType.equalsIgnoreCase("z")) {

        } else {
            System.out.println("Please check your block type, its " + blockType);
            System.exit(0);
        }
    }

    // needs wall detection
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
    }

    public String getType() {
        return this.blockType;
    }

    public block() {
        isLeft = false;
        isRight = false;
        isBottom = false;
        
    }

    public void setBlockNumber(int number) {
        blockNumber = number;
    }

}
