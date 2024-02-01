package views;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeckPane extends JPanel{
	
	JLabel cardLabel;
	
	DeckPane(){
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setImage();
		this.add(cardLabel);
	}
	
	private void setImage() {
		BufferedImage deckImage = null;
		try {
			deckImage = ImageIO.read(new File("ImageAssets/Backs/back_1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Image Not Found");
		}
		cardLabel = new JLabel(new ImageIcon(deckImage));
	}
	
	
}
