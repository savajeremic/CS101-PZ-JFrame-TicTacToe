/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tic_Tac_Toe;

/**
 *
 * @author Jack
 */
public class Field {
    
    private char fieldValue;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    
    public Field(int x1, int x2, int y1, int y2) 
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        fieldValue = ' ';
    }
    
    public boolean belongsToField(int x, int y)
    {
        if (x >= this.getX1() && x <= this.getX2() && y >= this.getY1() && y <= this.getY2())
            return true;
        else
            return false;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
    

    public char getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(char fieldValue) {
        this.fieldValue = fieldValue;
    }
}