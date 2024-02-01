package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GameFrame extends JFrame{
	
	GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700, 500);
	}
	
	public static void main(String args[]) {

		GameFrame frame = new GameFrame();


		
		JLabel label = new JLabel("This is a label");
//		DeckLabel deck = new DeckLabel();
		
		
		
		
		GamePanel game = new GamePanel();
		game.setLayout(new BoxLayout(game, BoxLayout.Y_AXIS));
		
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		JPanel bottomPanel = new JPanel(new FlowLayout());
		
		
		
		ImageIcon deckIcon = new ImageIcon("ImageAssets/Backs/back_2.png");
		JButton deck = new JButton(deckIcon);
		deck.setMargin(new Insets(0,0,0,0));
		deck.setBorder(null);
		
		JButton deck2 = new JButton(deckIcon);
		deck2.setMargin(new Insets(0,0,0,0));
		deck2.setBorder(null);
		
		JButton deck3 = new JButton(deckIcon);
		deck3.setMargin(new Insets(0,0,0,0));
		deck3.setBorder(null);
		
		topPanel.add(deck);
		topPanel.add(deck2);
		bottomPanel.add(deck3);
		
		game.add(topPanel);
		game.add(bottomPanel);
	
		frame.add(game);
		

	
		
		
		frame.setVisible(true);
		game.setVisible(true);
	}
}
