package views;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class MenuBarCreator {
	
	private String gameMode;
	private String drawMode;
	
	MenuBarCreator() {
		super();
		gameMode = "STANDARD";
		drawMode = "DRAW 1";
	}
	
	//this menu creates a menu bar, then will pass it back to the gameFrame
	public JMenuBar createMenuBar() {
		//Creating all objects
		JMenuBar menuBar;
		JMenu fileMenu, gameModeMenu, drawMenu, helpMenu;
		JMenuItem newGame, credits, exit, rules;
		JRadioButtonMenuItem standardMenuItem,  vegasMenuItem, d1MenuItem, d3MenuItem;

		//instantiating the first menu
		models.MenuBar menuBarModel = new models.MenuBar(gameMode, drawMode);
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
		
		//Create Game mode
		gameModeMenu = new JMenu("Game Mode");
		menuBar.add(gameModeMenu);		
		
		ButtonGroup modeGroup = new ButtonGroup();	
		
		standardMenuItem = new JRadioButtonMenuItem("Standard");		
		vegasMenuItem = new JRadioButtonMenuItem("Vegas");
					
		//Set the default mode
		standardMenuItem.setSelected(true);		
		
		modeGroup.add(standardMenuItem);
		modeGroup.add(vegasMenuItem);
		
		gameModeMenu.add(standardMenuItem);
		gameModeMenu.add(vegasMenuItem);
		
		standardMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentMode = getGameMode();
				setGameMode(standardMenuItem.getText().toUpperCase());
				menuBarModel.setGameMode(currentMode, standardMenuItem.getText().toUpperCase());				
			}
		});
		
		vegasMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentMode = getGameMode();
				setGameMode(vegasMenuItem.getText().toUpperCase());
				menuBarModel.setGameMode(currentMode, vegasMenuItem.getText().toUpperCase());				
			}
		});
		
		//Create Draw menu
		
		drawMenu = new JMenu("Draw options");
		menuBar.add(drawMenu);
		
		ButtonGroup drawGroup = new ButtonGroup();
		d1MenuItem = new JRadioButtonMenuItem("Draw 1");		
		d3MenuItem = new JRadioButtonMenuItem("Draw 3");
		
		d1MenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentMode = getDrawMode();
				setDrawMode(d1MenuItem.getText().toUpperCase());
				menuBarModel.setDrawMode(currentMode, d1MenuItem.getText().toUpperCase());				
			}
		});
		
		d3MenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentMode = getDrawMode();
				setDrawMode(d3MenuItem.getText().toUpperCase());
				menuBarModel.setDrawMode(currentMode, d3MenuItem.getText().toUpperCase());				
			}
		});
		
		//Add radio buttons to button groups
		drawGroup.add(d1MenuItem);
		drawGroup.add(d3MenuItem);
		
		//Set the default modes
		d1MenuItem.setSelected(true);
		
		drawMenu.add(d1MenuItem);
		drawMenu.add(d3MenuItem);		

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
	
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	
	public String getGameMode() {
		return gameMode;
	}
	
	public void setDrawMode(String drawMode) {
		this.drawMode = drawMode;
	}
	
	public String getDrawMode() {
		return drawMode;
	}

}
