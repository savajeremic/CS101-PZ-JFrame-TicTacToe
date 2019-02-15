/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tic_Tac_Toe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jack
 */
class GameView extends JFrame {
    
    private MainPanel mainPanel;
    private GameSetup gameSetup;
    private JPanel bottomPanel;
    
    public static JLabel firstUsernameLabel = new JLabel();
    public static JLabel secondUsernameLabel = new JLabel();
    public static JLabel jlLeftScore = new JLabel();
    public static JLabel jlRightScore = new JLabel();
    
    private JButton btnExit = new JButton("Exit");
    public static JButton btnNextRound = new JButton("Next Round");
    public static JButton btnResetGame = new JButton("Reset Game");

    public GameView() 
    {
        mainPanel = new MainPanel();
        gameSetup = new GameSetup();
        bottomPanel = new JPanel();
        
        btnNextRound.setEnabled(false);
        btnResetGame.setEnabled(false);
        
        setFrame();
    }

    private void setFrame() 
    {
        setTitle("Royal Tic Tac Toe");
        setSize(550, 700);
        add(mainPanel);
        addBottomPanel();
        setupButtons();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        gameSetup.setupPlayers(mainPanel);
        gameSetup.setupScore(mainPanel);
        repaint();
    }

    private void addBottomPanel() 
    {     
        bottomPanel.add(firstUsernameLabel);
        bottomPanel.add(jlLeftScore);
        bottomPanel.add(btnNextRound);
        bottomPanel.add(btnResetGame);
        bottomPanel.add(btnExit);
        bottomPanel.add(jlRightScore);
        bottomPanel.add(secondUsernameLabel);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private void setupButtons()
    {    
        btnExit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        btnNextRound.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainPanel.nextRound();
            }

        });
        
        btnResetGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.resetGame();
            }
        });
    }
}   