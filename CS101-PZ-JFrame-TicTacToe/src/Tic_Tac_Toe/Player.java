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
public class Player {
    private int score;
    private String username;
    private char value;

    public Player(String username, char value) 
    {
        this.username = username;
        this.value = value;
        score = 0;
    }

    public void incScore(){
        score++;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}