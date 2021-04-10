package sk.stuba.fei.uim.oop;

public class Tile {
    private int x;
    private int y;
    private boolean visited;
    private boolean topWall;
    private boolean rightWall;
    private boolean leftWall;
    private boolean bottomWall;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
        topWall = true;
        rightWall = true;
        leftWall = true;
        bottomWall = true;
    }
/*
    public void drawTile(Graphics g){
        int posX = x-1;
        if(posX > 0){
            posX = posX *20;
        }
        int posY = y-1;
        if(posY >0){
            posY = posY*20;
        }
        if(bottomWall){
            drawBottomWall(g, posX, posY);
        }
        if(topWall){
            drawTopWall(g, posX, posY);
        }
        if(leftWall){
            drawLeftWall(g, posX, posY);
        }
        if(rightWall){
            drawRightWall(g, posX, posY);
        }
    }

    public void drawRightWall(Graphics g,int  posX, int posY){
        g.setColor(Color.BLACK);

        g.drawLine(posX,posY+20,posX+20,posY+20);
    }

    public void drawTopWall(Graphics g,int posX, int posY){
        g.setColor(Color.BLACK);
        g.drawLine(posX,posY,posX,posY+20);
    }
    public void drawBottomWall(Graphics g, int posX, int posY){
        g.setColor(Color.BLACK);
        g.drawLine(x=posX+20,posX,posX+20,posY+20);

    }
    public void drawLeftWall(Graphics g, int posX, int posY){
        g.setColor(Color.BLACK);
        g.drawLine(posX,posY,posX+20,posY);
    }
*/
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isTopWall() {
        return topWall;
    }

    public void setTopWall(boolean topWall) {
        this.topWall = topWall;
    }

    public boolean isRightWall() {
        return rightWall;
    }

    public void setRightWall(boolean rightWall) {
        this.rightWall = rightWall;
    }

    public boolean isLeftWall() {
        return leftWall;
    }

    public void setLeftWall(boolean leftWall) {
        this.leftWall = leftWall;
    }

    public boolean isBottomWall() {
        return bottomWall;
    }

    public void setBottomWall(boolean bottomWall) {
        this.bottomWall = bottomWall;
    }
}
