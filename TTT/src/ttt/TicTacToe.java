package ttt;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener{
// Verschillende classes
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
        boolean End; // Boolean moest gebruikt worden om een reset en menu mogelijk te maken het is mislukt om dat te integreren
	TicTacToe(){
		// Generatie window en speelveld
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640,640);
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(255,0,0));
		textfield.setFont(new Font("Calisto MT",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,640,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(0,0,0));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Calisto MT",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Maakt de interactie mogelijk dat een speler zijn beurt kan doen,
		//zorgt er daarna voor dat de andere speler aan de beurt komt
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,255,0));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}			
		}
	}
	
	public void firstTurn() {
		// Delay tussen begintext en text die aangeeft welke beurt is
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		// bepaald en laat zien wie aan de beurt is
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}
	}
	
	public void check() {
		// Per winnende combinatie word gecontroleerd of X of O gewonnen heeft
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()== "O") &&
				(buttons[3].getText()== "O") &&
				(buttons[6].getText()== "O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
	}
	// Text die tevoorschijn komt als X of O gewonnen heeft
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
	}
	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
	}

}
