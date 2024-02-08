package views;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class CardButton extends JToggleButton{
		
	public static Color backgroundGreen = new Color(0, 128, 1);
	
	//Creates a button without an icon. NOT RECOMMENDED.
	public CardButton() {
		super();
		this.setMargin(new Insets(0,0,0,0));
		this.setBorder(null);
		this.setBackground(backgroundGreen);
	}
	
	//Creates a button with an icon
	public CardButton(ImageIcon i) {
		super(i);
		this.setMargin(new Insets(0,0,0,0));
		this.setBorder(null);
		this.setBackground(backgroundGreen);
	}
	
	//draws the cardButton based on the x and y and sets
	//the dimensions of the button to the image that is assigned to it. 
	public void draw(int x, int y) {
		this.setBounds(x, y, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		this.repaint();
	}
	

}
