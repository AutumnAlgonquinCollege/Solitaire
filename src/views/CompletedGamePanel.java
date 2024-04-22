package views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Main;

public class CompletedGamePanel{
	
	private JFrame completedFrame;
	private JPanel completedPanel;
	private JButton newGameButton;
	private JLabel finishTime;
	private JLabel finishScore;
	private JLabel timeBonus;
	private JLabel totalScore;
	private JLabel congratulationsMessage;
	
	public CompletedGamePanel(String time, int score, int bonus) {
		completedFrame = new JFrame();
		completedFrame.setAlwaysOnTop(true);
		completedFrame.setBounds(450, 400, 180, 200);
		
		completedPanel = new JPanel();
		
		
		congratulationsMessage = new JLabel("Congratulations!");
		finishTime = new JLabel("Time: " + time);
		
		finishScore = new JLabel("Score: " + (score - bonus));
		timeBonus = new JLabel("Time Bonus: " + bonus);
		totalScore = new JLabel("Total Score: "+ score);
		
		newGameButton = new JButton();
		newGameButton.setText("New Game");
		newGameButton.setFocusPainted(false);
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.restartGame();
				completedFrame.dispose();
			}
		});
		
		
		

		
		completedPanel.add(congratulationsMessage);
		
		finishTime.setPreferredSize(new Dimension(150, 20));
		finishScore.setPreferredSize(new Dimension(150, 20));
		timeBonus.setPreferredSize(new Dimension(150, 20));
		totalScore.setPreferredSize(new Dimension(150, 20));
		
		finishTime.setHorizontalAlignment(JLabel.CENTER);
        finishScore.setHorizontalAlignment(JLabel.CENTER);
        timeBonus.setHorizontalAlignment(JLabel.CENTER);
        totalScore.setHorizontalAlignment(JLabel.CENTER);
		
		completedPanel.add(finishTime);
		completedPanel.add(finishScore);
		if (bonus != 0) {
			completedPanel.add(timeBonus);
		}
		completedPanel.add(totalScore);
		completedPanel.add(newGameButton);
		
		completedFrame.add(completedPanel);
		
		completedPanel.setVisible(true);
		completedFrame.setVisible(true);
		
		
		
	}

}
