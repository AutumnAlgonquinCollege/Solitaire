package views;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CardButton extends JButton{
		
	//Creates a button without an icon. NOT RECOMMENDED.
	CardButton() {
		super();
		this.setMargin(new Insets(0,0,0,0));
		this.setBorder(null);
		this.setBackground(GameFrame.backgroundGreen);
	}
	
	//Creates a button with an icon
	CardButton(ImageIcon i) {
		super(i);
		this.setMargin(new Insets(0,0,0,0));
		this.setBorder(null);
		this.setBackground(GameFrame.backgroundGreen);
	}
	
	//draws the cardButton based on the x and y
	public void draw(int x, int y) {
		this.setBounds(x, y, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		this.repaint();
	}
	

}
