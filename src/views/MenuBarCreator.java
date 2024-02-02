package views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarCreator {
	
	MenuBarCreator() {
		super();
	}
	
	//this menu creates a menu bar, then will pass it back to the gameFrame
	public JMenuBar createMenuBar() {
		//Creating all objects
		JMenuBar menuBar;
		JMenu fileMenu, helpMenu;
		JMenuItem newGame, credits, exit, rules;
		
		//instantiating the first menu
		menuBar = new JMenuBar();
		
		//instantiating the menu and 
		//adding it to the menubar
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		//Instantiating JMenuItems and adding them to
		//the File Menu
		newGame = new JMenuItem("New Game");
		fileMenu.add(newGame);
		credits = new JMenuItem("Credits");
		fileMenu.add(credits);
		exit = new JMenuItem("Exit");
		fileMenu.add(exit);
		
		//Creating the Help menu and adding it
		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		//Help items for the Help Menu
		rules = new JMenuItem("Rules");
		helpMenu.add(rules);
		

		
		
		return menuBar;
	}

}
