package BlackJack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

public class GUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnPlay;
	JButton btnExit;
	JButton btnHold;
	JButton btnHit;
	JTextArea textArea;
	JTextArea textArea_1;
	JTextArea textArea_2;
	Game game;
	GUI me;
	int hit;
	
	public GUI() {
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		setSize(680,420);
		btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(this);
		springLayout.putConstraint(SpringLayout.NORTH, btnPlay, 106, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnPlay, 0, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnPlay);
		
		btnExit = new JButton("EXIT");
		btnExit.addActionListener(this);
		springLayout.putConstraint(SpringLayout.NORTH, btnExit, 61, SpringLayout.SOUTH, btnPlay);
		springLayout.putConstraint(SpringLayout.WEST, btnExit, 0, SpringLayout.WEST, btnPlay);
		getContentPane().add(btnExit);
		
		btnHold = new JButton("HOLD");
		btnHold.addActionListener(this);
		springLayout.putConstraint(SpringLayout.NORTH, btnHold, 0, SpringLayout.NORTH, btnPlay);
		springLayout.putConstraint(SpringLayout.EAST, btnHold, 0, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnHold);
		
		btnHit = new JButton("HIT");
		btnHit.addActionListener(this);
		springLayout.putConstraint(SpringLayout.NORTH, btnHit, 0, SpringLayout.NORTH, btnExit);
		springLayout.putConstraint(SpringLayout.EAST, btnHit, 0, SpringLayout.EAST, btnHold);
		getContentPane().add(btnHit);
		
		textArea = new JTextArea(5,15);
		getContentPane().add(textArea);
		
		textArea_1 = new JTextArea(2,15);
		springLayout.putConstraint(SpringLayout.NORTH, textArea_1, 41, SpringLayout.SOUTH, textArea);
		springLayout.putConstraint(SpringLayout.EAST, textArea_1, 0, SpringLayout.EAST, textArea);
		getContentPane().add(textArea_1);
		
		textArea_2 = new JTextArea(5,15);
		springLayout.putConstraint(SpringLayout.WEST, textArea_2, 0, SpringLayout.WEST, textArea);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea_2, -37, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(textArea_2);
		
		JLabel lblDealer = new JLabel("Dealer");
		springLayout.putConstraint(SpringLayout.WEST, textArea, 209, SpringLayout.EAST, lblDealer);
		springLayout.putConstraint(SpringLayout.NORTH, lblDealer, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 0, SpringLayout.NORTH, lblDealer);
		springLayout.putConstraint(SpringLayout.WEST, lblDealer, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblDealer);
		
		JLabel lblPlayer = new JLabel("Player");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlayer, 73, SpringLayout.SOUTH, btnPlay);
		springLayout.putConstraint(SpringLayout.WEST, lblPlayer, 0, SpringLayout.WEST, lblDealer);
		getContentPane().add(lblPlayer);
		
	}
public void setResult(String x){
	textArea_1.setText(x);
}
public void setDealer(String x){
	textArea.setText(x);
}
public void setPlayer(String x){
	textArea_2.setText(x);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnPlay)
		{
			this.textArea.setText("");
			this.textArea_1.setText("");
			this.textArea_2.setText("");
			game = new Game(this);
			
		}
		else if (e.getSource()==btnExit)
		{
			System.exit(0);
		}
		else if (e.getSource()==btnHold)
		{
			game.holdPressed();
		}
		else if (e.getSource()==btnHit)
		{
			game.hitPressed();	}
		
	}
}

