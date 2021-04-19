package sk.stuba.fei.uim.oop.Maze;

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
        new GenerateMaze(this);

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

    public void drawMaze(Graphics g) {

        for (ArrayList<Tile> line : grid) {
            for (Tile tile : line) {
                tile.drawTile(g);
            }
        }
    }

}