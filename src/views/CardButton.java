package views;

import java.awt.Color;
import java.awt.Insets;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;

import models.Card;

public class CardButton extends JToggleButton{
		
	public static Color backgroundGreen = new Color(0, 128, 1);
	private Card card;
	private List<Card> cards;
	
	//Creates a button without an icon. NOT RECOMMENDED.
	public CardButton() {
		super();
		this.setMargin(new Insets(0,0,0,0));
		this.setBorder(null);
		this.setBackground(backgroundGreen);
	}
	
	//Creates a button with an icon
	public CardButton(ImageIcon i, Card card, List<Card> cards) {
		super(i);
		this.card = card;
		this.cards = cards;
		this.setMargin(new Insets(0,0,0,0));
		this.setBorder(null);
		this.setBackground(backgroundGreen);
	}
	
	public Card getCardModel() {
		return card;
	}
	
	public void setCardModel(Card card) {
		this.card = card;
	}
	
	//draws the cardButton based on the x and y and sets
	//the dimensions of the button to the image that is assigned to it. 
	public void draw(int x, int y) {
		this.setBounds(x, y, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		this.repaint();
	}
	

}
