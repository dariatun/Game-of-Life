/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author dariatunina
 */
public class Cell {
    private boolean alive;
    private boolean changed;
    private int generation;

    public Cell() {
        generation = 0;
        alive = false;
        changed = false;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
    
    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }
    
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public void decreaseGeneration() {
        generation = 0;
    }
    
    public void increaseGeneration() {
        generation++;
    }

    

        
}
