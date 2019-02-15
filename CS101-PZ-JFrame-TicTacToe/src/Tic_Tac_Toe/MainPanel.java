/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tic_Tac_Toe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jack
 */
class MainPanel extends JPanel implements MouseListener {

    private Player firstPlayer;
    private Player secondPlayer;
    private GameSetup gameSetup;
    private int chosenScore;
    private char whoseTurnIsIt = 'X';
    private boolean gameEnabled = true;
    
    Field upperLeft = new Field(15, 172, 15, 204);
    Field upperCenter = new Field(188, 353, 15, 204);
    Field upperRight = new Field(370, 527, 15, 204);
    
    Field middleLeft = new Field(15, 172, 223, 414);
    Field middleCenter = new Field(188, 353, 223, 414);
    Field middleRight = new Field(370, 527, 223, 414);
    
    Field lowerLeft = new Field(15, 172, 430, 620);
    Field lowerCenter = new Field(188, 353, 430, 620);
    Field lowerRight = new Field(370, 527, 430, 620);    
            
    public MainPanel() 
    {
        gameSetup = new GameSetup();
        setBackground(Color.RED);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 15));
        super.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int x = getWidth() / 3;
        int y = getHeight() / 3;

        g2.setStroke(new BasicStroke(15));

        g2.drawLine(0, y, getWidth(), y);
        g2.drawLine(0, y * 2, getWidth(), y * 2);
        g2.drawLine(x, 0, x, getHeight());
        g2.drawLine(x * 2, 0, x * 2, getHeight());

        g2.setFont(new Font("Times New Roman", Font.PLAIN, 190));
        
        drawValueAtCoordinates(g2, upperLeft.getFieldValue(), 20, 180);
        drawValueAtCoordinates(g2, upperCenter.getFieldValue(), 200, 180);
        drawValueAtCoordinates(g2, upperRight.getFieldValue(), 380, 180);
        
        drawValueAtCoordinates(g2, middleLeft.getFieldValue(), 20, 380);
        drawValueAtCoordinates(g2, middleCenter.getFieldValue(), 200, 380);
        drawValueAtCoordinates(g2, middleRight.getFieldValue(), 380, 380);
        
        drawValueAtCoordinates(g2, lowerLeft.getFieldValue(), 20, 590);
        drawValueAtCoordinates(g2, lowerCenter.getFieldValue(), 200, 590);
        drawValueAtCoordinates(g2, lowerRight.getFieldValue(), 380, 590);
        
        g2.setStroke(new BasicStroke(20));
        g2.setColor(Color.LIGHT_GRAY);

        drawVictoryLineAtCoordinates(g2, upperLeft.getFieldValue(), upperCenter.getFieldValue(), upperRight.getFieldValue(), 0, getHeight() / 5 - 10, getWidth(), getHeight() / 5 - 10);
        drawVictoryLineAtCoordinates(g2, middleLeft.getFieldValue(), middleCenter.getFieldValue(), middleRight.getFieldValue(), 0, getHeight() / 2, getWidth(), getHeight() / 2);
        drawVictoryLineAtCoordinates(g2, lowerLeft.getFieldValue(), lowerCenter.getFieldValue(), lowerRight.getFieldValue(), 0, getHeight() - 110, getWidth(), getHeight() - 110);
        
        drawVictoryLineAtCoordinates(g2, upperLeft.getFieldValue(), middleLeft.getFieldValue(), lowerLeft.getFieldValue(), getWidth() / 6, getHeight(), getWidth() / 6, 0);
        drawVictoryLineAtCoordinates(g2, upperCenter.getFieldValue(), middleCenter.getFieldValue(), lowerCenter.getFieldValue(), getWidth() / 2, getHeight(), getWidth() / 2, 0);
        drawVictoryLineAtCoordinates(g2, upperRight.getFieldValue(), middleRight.getFieldValue(), lowerRight.getFieldValue(), getWidth() - 95, getHeight(), getWidth() - 95, 0);
        
        drawVictoryLineAtCoordinates(g2, upperLeft.getFieldValue(), middleCenter.getFieldValue(), lowerRight.getFieldValue(), 20, 20, getWidth() - 20, getHeight() - 20);
        drawVictoryLineAtCoordinates(g2, upperRight.getFieldValue(), middleCenter.getFieldValue(), lowerLeft.getFieldValue(), getWidth() - 20, 20, 20, getHeight() - 20);

    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if (!gameEnabled)
            return;

        int x = e.getX();
        int y = e.getY();
        
        turnControl(upperLeft, x, y);
        turnControl(upperCenter, x, y);
        turnControl(upperRight, x, y);
        
        turnControl(middleLeft, x, y);
        turnControl(middleCenter, x, y);
        turnControl(middleRight, x, y);

        turnControl(lowerLeft, x, y);
        turnControl(lowerCenter, x, y);
        turnControl(lowerRight, x, y);
        
        
        checkWinAndVictory(upperLeft.getFieldValue(), upperCenter.getFieldValue(), upperRight.getFieldValue());
        checkWinAndVictory(middleLeft.getFieldValue(), middleCenter.getFieldValue(), middleRight.getFieldValue());
        checkWinAndVictory(lowerLeft.getFieldValue(), lowerCenter.getFieldValue(), lowerRight.getFieldValue());
        
        checkWinAndVictory(upperLeft.getFieldValue(), middleLeft.getFieldValue(), lowerLeft.getFieldValue());
        checkWinAndVictory(upperCenter.getFieldValue(), middleCenter.getFieldValue(), lowerCenter.getFieldValue());
        checkWinAndVictory(upperRight.getFieldValue(), middleRight.getFieldValue(), lowerRight.getFieldValue());
        
        checkWinAndVictory(upperLeft.getFieldValue(), middleCenter.getFieldValue(), lowerRight.getFieldValue());
        checkWinAndVictory(lowerLeft.getFieldValue(), middleCenter.getFieldValue(), upperRight.getFieldValue());
       
        checkIfDraw();
        
        repaintScore();
        
        changeTurns();
    }

    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void nextRound() 
    {
        upperLeft.setFieldValue(' ');
        upperCenter.setFieldValue(' ');
        upperRight.setFieldValue(' ');
        middleLeft.setFieldValue(' ');
        middleCenter.setFieldValue(' ');
        middleRight.setFieldValue(' ');
        lowerLeft.setFieldValue(' ');
        lowerCenter.setFieldValue(' ');
        lowerRight.setFieldValue(' ');
        whoseTurnIsIt = 'X';
        
        if (firstPlayer.getValue() == 'X')
            firstPlayer.setValue('O');
        else if (firstPlayer.getValue() == 'O')
            firstPlayer.setValue('X');
        
        if (secondPlayer.getValue() == 'X')
            secondPlayer.setValue('O');
        else if (secondPlayer.getValue() == 'O')
            secondPlayer.setValue('X');
        
        GameView.firstUsernameLabel.setText(firstPlayer.getUsername() + " [ " + firstPlayer.getValue() + " ]");
        GameView.secondUsernameLabel.setText(secondPlayer.getUsername() + " [ " + secondPlayer.getValue() + " ]");
        
        gameEnabled = true;
        GameView.btnNextRound.setEnabled(false);
        repaint();
    }
    
    public void resetGame() 
    {
        upperLeft.setFieldValue(' ');
        upperCenter.setFieldValue(' ');
        upperRight.setFieldValue(' ');
        middleLeft.setFieldValue(' ');
        middleCenter.setFieldValue(' ');
        middleRight.setFieldValue(' ');
        lowerLeft.setFieldValue(' ');
        lowerCenter.setFieldValue(' ');
        lowerRight.setFieldValue(' ');
        whoseTurnIsIt = 'X';
        firstPlayer.setScore(0);
        secondPlayer.setScore(0);
        gameEnabled = true;
        GameView.btnNextRound.setEnabled(false);
        GameView.btnResetGame.setEnabled(false);
        repaintScore();
        gameSetup.setupScore(this);
        repaint();
    }
    
    private void repaintScore()
    {
        GameView.jlLeftScore.setText(String.valueOf(firstPlayer.getScore()));
        GameView.jlRightScore.setText(String.valueOf(secondPlayer.getScore()));
    }

    private void checkIfDraw()
    {
        if(upperLeft.getFieldValue() != ' ' 
            && upperCenter.getFieldValue() != ' '
            && upperRight.getFieldValue() != ' '
            && middleLeft.getFieldValue() != ' '
            && middleCenter.getFieldValue() != ' '
            && middleRight.getFieldValue() != ' '
            && lowerLeft.getFieldValue() != ' '
            && lowerCenter.getFieldValue() != ' '
            && lowerRight.getFieldValue() != ' '
            && gameEnabled 
         )
        {
            JOptionPane.showMessageDialog(this, "It's a Draw!");
            GameView.btnNextRound.setEnabled(true);
        }
    }
    
    private void drawValueAtCoordinates(Graphics2D graphics2D ,char value, int coordinateX, int coordinateY)
    {
        if (!(value == ' '))
        {
            graphics2D.drawString(String.valueOf(value), coordinateX, coordinateY);
        }
    }

    private void drawVictoryLineAtCoordinates(Graphics2D graphics2D, char leftValue, char centerValue, char rightValue, int x1, int y1, int x2, int y2 )
    {
        if (centerValue != ' ' && leftValue == centerValue && rightValue == centerValue)
        {
            graphics2D.drawLine(x1, y1, x2, y2);
            gameEnabled = false;
        }
    }
    
    private void turnControl(Field field, int coordinateX, int coordinateY)
    {
        if (field.getFieldValue() == ' ')
        {
            if (field.belongsToField(coordinateX, coordinateY))
            {
                field.setFieldValue(whoseTurnIsIt);
                
                repaint();
            }
        }
    }
    
    private void checkWinAndVictory(char leftValue, char centerValue, char rightValue)
    {
        if (centerValue != ' ' && leftValue == centerValue && rightValue == centerValue)
        {
            if (firstPlayer.getValue() == whoseTurnIsIt)
                setWinningPlayer(firstPlayer);
            else if (secondPlayer.getValue() == whoseTurnIsIt)
                setWinningPlayer(secondPlayer);
        }            
    }

    private void setWinningPlayer(Player winningPlayer)
    {
        JOptionPane.showMessageDialog(null, winningPlayer.getUsername() + " wins!");
        winningPlayer.incScore();

        if(chosenScore == winningPlayer.getScore())
        {
            JOptionPane.showMessageDialog(null, winningPlayer.getUsername() + " is Champion!");
            GameView.btnResetGame.setEnabled(true);
        }    
        else
            GameView.btnNextRound.setEnabled(true);
            
    }
   
    private void changeTurns()
    {
       if (whoseTurnIsIt == 'X')
           whoseTurnIsIt = 'O';
       else if (whoseTurnIsIt == 'O')
           whoseTurnIsIt = 'X';
    }

    
    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
    
    public boolean isGameEnabled() {
        return gameEnabled;
    }

    public void setGameEnabled(boolean GameEnabled) {
        this.gameEnabled = GameEnabled;
    }
    
    public void setChosenScore(int chosenScore) {
        this.chosenScore = chosenScore;
    }
}