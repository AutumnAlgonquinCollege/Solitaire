package views;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	
	GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setSize(1000, 1050);
		this.setJMenuBar(new MenuBarCreator().createMenuBar());
		
	}
	
	
	
}
