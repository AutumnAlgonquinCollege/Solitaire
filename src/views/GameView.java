package views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class GameView {
	
	
	ButtonGroup gameButtons;
	GameFrame frame;
	JPanel panel;
	JLayeredPane pane;
	
	public static Color backgroundGreen = new Color(0, 128, 1);
	
	public GameView() {
		frame = new GameFrame();
		
		panel = new JPanel();
		panel.setBackground(backgroundGreen);
		
		gameButtons = new ButtonGroup();
		
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
		gameButtons.add(card);
		card.draw(x, y);
		
	}
	
	public void removeComponent(CardButton card) {
		pane.remove(card);
		gameButtons.remove(card);
	}
	
	public void addTableauCardButton(CardButton card, int x, int y, Integer z) {
		pane.add(card, z);
		gameButtons.add(card);
		card.draw(x, y);
	}
	
	public void setViewVisible() {
		frame.setVisible(true);
		panel.setVisible(true);
	}

}
