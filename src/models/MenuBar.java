package models;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import application.Main;
import controllers.Controller;
import views.GameView;

public class MenuBar {

	private URI rules;
	private String credits;
	private String gameMode;
	private String drawMode;
	
	public MenuBar() {
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
	
	public void newGame(String gameMode, String drawMode) {
		Main.restartGame(gameMode, drawMode);
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
		if (currentGameMode != newGameMode) {
			this.gameMode = newGameMode;
			newGame(gameMode, drawMode);
		}		
	}

	public void setDrawMode(String currentDrawMode, String newDrawMode) {
		if (currentDrawMode != newDrawMode) {
			this.drawMode = newDrawMode;
			newGame(gameMode, drawMode);
		}		
	}
	
}
