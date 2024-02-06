package views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class GameView {
	
	
	
	GameFrame frame;
	JPanel panel;
	JLayeredPane pane;
	
	public static Color backgroundGreen = new Color(0, 128, 1);
	
	public GameView() {
		frame = new GameFrame();
		
		panel = new JPanel();
		panel.setBackground(backgroundGreen);
		
		pane = new JLayeredPane();
		pane.setLayout(null);
		pane.setPreferredSize(new Dimension(frame.getWidth()-20, frame.getHeight()-70));
		pane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		panel.add(pane);
		frame.add(panel);
	}
	
	
	public void addComponent(JComponent component) {
		pane.add(component);
	}
	
	public void addCardButton(CardButton card, int x, int y) {
		pane.add(card);
		card.draw(x, y);
		
	}
	
	public void removeComponent(JComponent component) {
		pane.remove(component);
	}
	
	public void setViewVisible() {
		frame.setVisible(true);
		panel.setVisible(true);
	}

}
