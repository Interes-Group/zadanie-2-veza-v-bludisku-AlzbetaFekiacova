package sk.stuba.fei.uim.oop.Maze;

import java.awt.*;
import java.util.ArrayList;

public class Maze {
    private ArrayList<ArrayList<Tile>> grid;
    private int rows;
    private int cols;
    private int size;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.size = 20;
        grid = new ArrayList<>();
        new GenerateMaze(this);

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void drawMaze(Graphics g) {
        DrawMaze dr = new DrawMaze(this, g);

    }

    public void makeGrid() {
        for (int i = 0; i < rows; i++) {
            ArrayList<Tile> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(new Tile(i, j));
            }
            grid.add(row);
        }
    }

    public ArrayList<ArrayList<Tile>> getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }


    public int getCols() {
        return cols;
    }


}