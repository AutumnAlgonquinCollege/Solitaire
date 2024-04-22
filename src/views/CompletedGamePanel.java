package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.Main;

public class CompletedGamePanel{
	
	private JFrame completedFrame;
	private JPanel completedPanel;
	private JButton newGameButton;
	private JLabel finishTime;
	private JLabel finishScore;
	private JLabel timeBonus;
	private JLabel congratulationsMessage;
	
	public CompletedGamePanel(String time, int score, int bonus) {
		completedFrame = new JFrame();
		completedFrame.setAlwaysOnTop(true);
		completedFrame.setBounds(450, 400, 75, 150);
		
		completedPanel = new JPanel();
		
		
		congratulationsMessage = new JLabel("Congratulations!");
		finishTime = new JLabel("Time: " + time);
		
		finishScore = new JLabel("Score: " + score);
		timeBonus = new JLabel("Time Bonus: " + bonus);
		
		newGameButton = new JButton();
		newGameButton.setText("New Game");
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.restartGame();
				completedFrame.dispose();
			}
		});
		
		
		

		
		completedPanel.add(congratulationsMessage);
		completedPanel.add(finishTime);
		completedPanel.add(finishScore);
		if (bonus != 0) {
			completedPanel.add(timeBonus);
		}
		completedPanel.add(newGameButton);
		
		completedFrame.add(completedPanel);
		
		completedPanel.setVisible(true);
		completedFrame.setVisible(true);
		
	}

}
