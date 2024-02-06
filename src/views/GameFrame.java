package views;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	
	GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1000, 700);
		this.setJMenuBar(new MenuBarCreator().createMenuBar());
		
	}
	
	
	
}
