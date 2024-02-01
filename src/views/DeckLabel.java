package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class DeckLabel extends JLabel{

	DeckLabel(){
		super();
		this.setSize(50, 50);
		this.setText("Deck");
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
