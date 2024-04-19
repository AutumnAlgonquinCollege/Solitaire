package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.Main;

public class CompletedGamePanel{
	
	private JFrame completedFrame;
	private JPanel completedPanel;
	private JButton newGameButton;
	private JLabel congratulationsMessage;
	
	public CompletedGamePanel() {
		completedFrame = new JFrame();
		completedFrame.setAlwaysOnTop(true);
		completedFrame.setBounds(450, 400, 100, 100);
		
		completedPanel = new JPanel();
		
		newGameButton = new JButton();
		newGameButton.setText("New Game");
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.restartGame();
				completedFrame.dispose();
			}
		});
		
		
		
		congratulationsMessage = new JLabel("Congratulations!");
		
		completedPanel.add(congratulationsMessage);
		completedPanel.add(newGameButton);
		
		completedFrame.add(completedPanel);
		
		completedPanel.setVisible(true);
		completedFrame.setVisible(true);
		
	}

}
