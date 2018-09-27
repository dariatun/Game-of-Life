/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author dariatunina
 */
public class MyField {

    //private final ArrayList<Cell> field;
    private final Cell[][] field;
    private final int width = 100;
    private final int height = 100;
    private final int size = 10;

    public MyField() {
        field = new Cell[width][height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                field[i][j] = new Cell();
            }
        }

        //field = new ArrayList<>();
    }

    public void setCell(int x, int y) {
        x = (int) Math.floor(x / size);
        y = (int) Math.floor(y / size);
        //Cell cell = new Cell(x, y);
        field[x][y].setAlive(true);
        //field.add(cell);
    }

    public Cell[] getAlive() {
        ArrayList<Cell> aliveCells = new ArrayList<>();
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (field[i][j] != null && field[i][j].isAlive()) {
                    aliveCells.add(field[i][j]);
                }
            }
        }
        return (Cell[]) aliveCells.toArray();
    }

    private Color chooseColor(int generation) {
        Color currentColor;
        switch (generation) {
            case 1:
                currentColor = Color.DARKMAGENTA;
                break;
            case 2:
                currentColor = Color.DARKCYAN;
                break;
            case 3:
                currentColor = Color.FORESTGREEN;
                break;
            case 4:
                currentColor = Color.DARKORANGE;
                break;
            default:
                currentColor = Color.CRIMSON;
                break;
        }
        return currentColor;
    }

    public void draw(GraphicsContext gc) {
        //for (Cell cell : field) {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (field[i][j].isAlive()) {
                    gc.setFill(chooseColor(field[i][j].getGeneration()));
                    gc.fillRect(i * size, j * size, size, size);
                }
            }
        }
    }

    public void printCells() {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                Cell cell = field[i][j];
                if (cell != null && cell.isAlive()) {

                }
            }
        }
//        for (Cell cell : field) {
//        }
        System.out.println("-------------");
    }

    public int getNumberOfNeighbours(int x, int y) {
        int count = 0;
        for (int i = (x - 1 > 0 ? x - 1 : 0); i <= (x + 1 < width ? x + 1 : width - 1); ++i) {
            for (int j = (y - 1 > 0 ? y - 1 : 0); j <= (y + 1 < height ? y + 1 : height - 1); ++j) {
                Cell neighbour = field[i][j];
                if (neighbour != null && neighbour.isAlive()
                        && !(x == i && y == j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public Cell[] getArray() {
        Cell[] cells = new Cell[width * height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                cells[i * height + j] = field[i][j];
            }
        }
        return cells;
    }

    public void oneCycle() {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                Cell cell = field[i][j];
                int numOfNeigbours = getNumberOfNeighbours(i, j);
                if (cell.isAlive()) {
                    if (numOfNeigbours != 2 && numOfNeigbours != 3) {
                        cell.setChanged(true);
                        cell.decreaseGeneration();
                    } else {
                        cell.increaseGeneration();
                    }
                } else {
                    if (getNumberOfNeighbours(i, j) == 3) {
                        cell.setChanged(true);
                        cell.increaseGeneration();
                    }
                }
                //System.out.print(numOfNeigbours);
            }
            //System.out.println("");
        }
        //System.out.println("--------------");
        applyChanges();
    }

    private void applyChanges() {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                Cell cell = field[i][j];
                if (cell.isChanged()) {
                    cell.setAlive(!cell.isAlive());
                    cell.setChanged(false);
                }
            }

        }
    }
}
