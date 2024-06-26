package models;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import application.Main;
import views.MenuBarCreator;

public class MenuBar {

	private URI rules;
	private String credits;
	private String gameMode;
	private String drawMode;
	private boolean gameModeChanged;
	
	public MenuBar(String gameMode, String drawMode) {
		this.gameMode = gameMode;
		this.drawMode = drawMode;
		gameModeChanged = false;
		try {
			rules = new URI("https://bicyclecards.com/how-to-play/solitaire/");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		credits = new String("Created by: Dominique Laberge, Autumn Morehouse, and Guosheng Wang.");
		
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void newGame() {
		Main.restartGame(gameMode, drawMode, gameModeChanged);
	}
	
	public String credits() {
		return credits;
	}
	
	public void help() {
			try {
				java.awt.Desktop.getDesktop().browse(rules);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void setGameMode(String currentGameMode, String newGameMode) {
		if (!currentGameMode.equals(newGameMode)) {
			this.gameMode = newGameMode;
			gameModeChanged = true;
			newGame();
			gameModeChanged = false;
		}		
	}

	public void setDrawMode(String currentDrawMode, String newDrawMode) {
		if (!currentDrawMode.equals(newDrawMode)) {
			this.drawMode = newDrawMode;
			newGame();
		}		
	}
	
}
