/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tic_Tac_Toe;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author Jack
 */
public class GameSetup {
    private Player firstPlayer;
    private Player secondPlayer;
    
    private String firstUsername;
    private String secondUsername;
    private final String[] buttonValues = { "3", "5", "10" };
    private int chosenScore;
    
    public void setupScore(MainPanel mainPanel)
    {
        int chosenButton = JOptionPane.showOptionDialog(null, "How many points for Victory?", "Points", JOptionPane.YES_NO_CANCEL_OPTION, 
                                    JOptionPane.QUESTION_MESSAGE, null, buttonValues, buttonValues[0]);
        
        switch(chosenButton){
            case -1:
                chosenScore = Integer.valueOf(buttonValues[0]);
                break;
            case 0:
                chosenScore = Integer.valueOf(buttonValues[0]);
                break;
            case 1:
                chosenScore = Integer.valueOf(buttonValues[1]);
                break;
            case 2:
                chosenScore = Integer.valueOf(buttonValues[2]);
                break;
        }
        
        mainPanel.setChosenScore(chosenScore);
    }

    public void setupPlayers(MainPanel mainPanel)
    {
        Font scoreFont = new Font("Times New Roman", Font.PLAIN, 28);
        
        firstUsername = JOptionPane.showInputDialog(null, "Enter first player username: ");
        secondUsername = JOptionPane.showInputDialog(null, "Enter second player username: ");
        
        if(firstUsername == null || firstUsername.equals(""))
            firstUsername = "Player 1";
        
        if(secondUsername == null || secondUsername.equals(""))
            secondUsername = "Player 2";
        
        firstPlayer = new Player(firstUsername, 'X');
        secondPlayer = new Player(secondUsername, 'O');
        
        mainPanel.setFirstPlayer(firstPlayer);
        mainPanel.setSecondPlayer(secondPlayer);
        
        GameView.firstUsernameLabel.setText(firstPlayer.getUsername() + " [ " + firstPlayer.getValue() + " ]");
        GameView.secondUsernameLabel.setText(secondPlayer.getUsername() + " [ " + secondPlayer.getValue() + " ]");
        
        GameView.jlLeftScore.setOpaque(true);
        GameView.jlLeftScore.setBackground(Color.BLACK);
        GameView.jlRightScore.setOpaque(true);
        GameView.jlRightScore.setBackground(Color.BLACK);
        
        GameView.jlLeftScore.setFont(scoreFont);
        GameView.jlRightScore.setFont(scoreFont);
        
        GameView.jlLeftScore.setText(String.valueOf(firstPlayer.getScore()));
        GameView.jlLeftScore.setForeground(Color.RED);
        GameView.jlRightScore.setText(String.valueOf(secondPlayer.getScore()));
        GameView.jlRightScore.setForeground(Color.RED);
    }
}