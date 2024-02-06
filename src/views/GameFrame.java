package views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	
	public static Color backgroundGreen = new Color(0, 128, 1);
	
	GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1000, 700);
	}
	
	public static void main(String args[]) {

		//Creating the frame itself
		GameFrame frame = new GameFrame();

		//The menubar has it's own class to keep things seperate from the game
		frame.setJMenuBar(new MenuBarCreator().createMenuBar());
		
		
		
		//A panel is needed to function and set the layered pane
		JPanel game = new JPanel();
		game.setBackground(backgroundGreen);
		
		//The JLayeredPane gamePane functions like that JPanel in this particular instance,
		//which allows the use of different depths to layer the tableau. it's set to be slightly smaller than 
		//the frame, taking up the majority of the space. 
		JLayeredPane gamePane = new JLayeredPane();
		gamePane.setLayout(null);
		gamePane.setPreferredSize(new Dimension(frame.getWidth()-20, frame.getHeight()-70));
		gamePane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//ImageIcons for testing purposes
		//this should all be handled by the controller / model later on
		ImageIcon deckIcon = new ImageIcon("ImageAssets/Backs/back_2.png");
		ImageIcon emptyCardFrameIcon = new ImageIcon("ImageAssets/Misc/empty_frame.png");
		ImageIcon clubsFoundationIcon = new ImageIcon("ImageAssets/Misc/clubs_foundation.png");
		ImageIcon heartsFoundationIcon = new ImageIcon("ImageAssets/Misc/hearts_foundation.png");
		ImageIcon diamondsFoundationIcon = new ImageIcon("ImageAssets/Misc/diamonds_foundation.png");
		ImageIcon spadesFoundationIcon = new ImageIcon("ImageAssets/Misc/spades_foundation.png");
		ImageIcon fourOfClubs = new ImageIcon("ImageAssets/Clubs/Clubs_card_04.png");
		
		
		//Creating the first set of cards and placing them for testing purposes
		//DO NOT DELETE UNTIL SURE; this currently has all the actually
		//placement data. Since all positioning is absolute, this has been calculated. 
		CardButton deck = new CardButton(deckIcon);
		deck.draw(10, 10);
		
		CardButton waste = new CardButton(emptyCardFrameIcon);
		waste.draw(125, 10);
		
		CardButton clubsFoundation = new CardButton(clubsFoundationIcon);
		clubsFoundation.draw(860, 10);
		
		CardButton heartsFoundation = new CardButton(heartsFoundationIcon);
		heartsFoundation.draw(745, 10);
		
		CardButton diamondsFoundation = new CardButton(diamondsFoundationIcon);
		diamondsFoundation.draw(630, 10);
		
		CardButton spadesFoundation = new CardButton(spadesFoundationIcon);
		spadesFoundation.draw(515, 10);
		
		CardButton tableau1 = new CardButton(deckIcon);
		tableau1.draw(10, 165);
		
		CardButton tableau2 = new CardButton(deckIcon);
		tableau2.draw(125, 165);
		
		CardButton tableau3 = new CardButton(deckIcon);
		tableau3.draw(240, 165);

		CardButton tableau4 = new CardButton(deckIcon);
		tableau4.draw(355, 165);
		
		CardButton tableau5 = new CardButton(deckIcon);
		tableau5.draw(470, 165);
		
		CardButton tableau6 = new CardButton(deckIcon);
		tableau6.draw(585, 165);
		
		CardButton tableau7 = new CardButton(deckIcon);
		tableau7.draw(700, 165);
		
		CardButton cardTest = new CardButton(fourOfClubs);
		System.out.println(tableau7.getX());
		cardTest.draw(tableau7.getX(), tableau7.getY()+25);
		
		
		//Adding all the different parts together;
		//The controller should have a method to do all of this based on what actually exists
		//otherwise we'll run into some major problems	
		game.add(gamePane);
		gamePane.add(deck);
		gamePane.add(waste);
		gamePane.add(clubsFoundation);
		gamePane.add(heartsFoundation);
		gamePane.add(diamondsFoundation);
		gamePane.add(spadesFoundation);
		gamePane.add(tableau1);
		gamePane.add(tableau2);
		gamePane.add(tableau3);
		gamePane.add(tableau4);
		gamePane.add(tableau5);
		gamePane.add(tableau6);
		gamePane.add(tableau7);
		gamePane.add(cardTest, 2, 0);
		
		
		
		//Finally, add the Panel to the frame
		frame.add(game);
		

	
		
		
		frame.setVisible(true);
		game.setVisible(true);
	}
}
