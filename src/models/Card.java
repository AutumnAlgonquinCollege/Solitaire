package models;

import javax.swing.ImageIcon;

public class Card {
	
	//==================================
	//          Attributes
	//==================================
	private String suit;
	private int rank;
	private boolean cardVisible;
	private String imagePath;
	private ImageIcon imageIcon;
	
	//==================================
	//          Constructors
	//==================================
	public Card () {}
	
	public Card (String suit, int rank, String imagePath) {
		this.suit = suit;
		this.rank = rank;
		this.imagePath = imagePath;
		cardVisible = false;
		this.imageIcon = new ImageIcon(imagePath);
	}
	
	//==================================
	//		 Getters and Setters
	//==================================
	public String getSuit() {
		return suit;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public boolean getCardVisible() {
		return cardVisible;
	}
	
	public ImageIcon getImageIcon() {
		return imageIcon;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void setCardVisible(boolean cardVisible) {
		this.cardVisible = cardVisible;
	}
	
	public ImageIcon getDisplayImage() {
		 return (cardVisible) ? imageIcon : Constants.backSideImg;
	}
	
	public String getCardColor() {
		return (suit == Constants.hearts || suit == Constants.diamonds) ? "RED" : "BLACK";
	}	

}
