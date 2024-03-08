package views;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
		models.MenuBar menuBarModel = new models.MenuBar();
		menuBar = new JMenuBar();
		
		//instantiating the menu and 
		//adding it to the menubar
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		//Instantiating JMenuItems and adding them to
		//the File Menu
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuBarModel.newGame();
				
			}
		});
		fileMenu.add(newGame);
		credits = new JMenuItem("Credits");
		credits.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, menuBarModel.credits());
				
				
			}
		});
		fileMenu.add(credits);
		exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exit);
		
		//Creating the Help menu and adding it
		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		//Help items for the Help Menu
		rules = new JMenuItem("Rules");
		rules.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBarModel.help();
				
			}
		});
		helpMenu.add(rules);
		

		
		
		return menuBar;
	}

}
