package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.util.ArrayList;

public class Maze {
    private ArrayList<ArrayList<Tile>> grid;
    private int rows;
    private int cols;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new ArrayList<>();
        makeGrid();
        GenerateMaze gr = new GenerateMaze(this);



    }

    public void drawMaze(Graphics g){
        DrawMaze dr = new DrawMaze(this, g);
        //g.setColor(Color.BLACK);
        //g.fillRect(0,0,(rows-1)*20, (cols-1)*20);
/*
        for (int i = 0; i< rows; i++){
            for (int j = 0; j < cols; j++){
                Tile t = grid.get(i).get(j);
                t.drawTile(g);
            }
        }*/

    }

    private void makeGrid(){
        for (int i = 0; i < rows; i++){
            ArrayList<Tile> row = new ArrayList<>();
            for(int j = 0; j < cols; j++){
                row.add(new Tile(i, j));
            }
            grid.add(row);
        }
    }

    public ArrayList<ArrayList<Tile>> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<ArrayList<Tile>> grid) {
        this.grid = grid;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
