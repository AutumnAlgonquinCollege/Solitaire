package views;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class GameFrame extends JFrame{

	
	GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setSize(1000, 1050);
		this.setJMenuBar(new MenuBarCreator().createMenuBar());
		
	}
	
	
	
	
}
