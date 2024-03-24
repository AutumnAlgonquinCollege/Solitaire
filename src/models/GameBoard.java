package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import java.util.TimerTask;

import javax.swing.JLabel;

import controllers.ControllerConstants;

public class GameBoard {
	
	//==================================
	//          Attributes
	//==================================
	private CardDeck cardDeck;
	private WastePile wastePile;
	private Tableau tableau1;
	private Tableau tableau2;
	private Tableau tableau3;
	private Tableau tableau4;
	private Tableau tableau5;
	private Tableau tableau6;
	private Tableau tableau7;
	private Foundation foundationSpades;
	private Foundation foundationClubs;
	private Foundation foundationDiamonds;
	private Foundation foundationHearts;
	private ArrayList<Tableau> tableauList;
	private int score;
	private int time;
	private Timer gameTimer;
	boolean isTimerRunning;
	private int deckPasses;
	private String gameMode;
	private String drawMode;
	
	
	
	//==================================
	//          Constructor
	//==================================
	public GameBoard(String gameMode, String drawMode) {
		this.gameMode = gameMode;
		this.drawMode = drawMode;
		score = 0;
		time = 0;
		deckPasses = 0;
		gameTimer = new Timer();
		isTimerRunning = false;
		cardDeck = new CardDeck();
		wastePile = new WastePile();
		tableau1 = new Tableau(0);
		tableau2 = new Tableau(1);
		tableau3 = new Tableau(2);
		tableau4 = new Tableau(3);
		tableau5 = new Tableau(4);
		tableau6 = new Tableau(5);
		tableau7 = new Tableau(6);
		
		tableauList = new ArrayList<Tableau>();
		tableauList.add(tableau1);
		tableauList.add(tableau2);
		tableauList.add(tableau3);
		tableauList.add(tableau4);
		tableauList.add(tableau5);
		tableauList.add(tableau6);
		tableauList.add(tableau7);
		
		foundationSpades = new Foundation(Constants.spades);
		foundationClubs = new Foundation(Constants.clubs);
		foundationDiamonds = new Foundation(Constants.diamonds);
		foundationHearts = new Foundation(Constants.hearts);
		initializeGameBoard();
	}
	
	//==================================
	//       	   Getters
	//==================================
	
	public CardDeck getCardDeck() {
		return cardDeck;
	}
		
	public WastePile getWastePile() {
		return wastePile;
	}
	
	public Tableau getTableau1() {
		return tableau1;
	}
	
	public Tableau getTableau2() {
		return tableau2;
	}
	
	public Tableau getTableau3() {
		return tableau3;
	}
	
	public Tableau getTableau4() {
		return tableau4;
	}
	
	public Tableau getTableau5() {
		return tableau5;
	}
	
	public Tableau getTableau6() {
		return tableau6;
	}
	
	public Tableau getTableau7() {
		return tableau7;
	}
	
	public Foundation getFoundationSpades() {
		return foundationSpades;
	}
	
	public Foundation getFoundationClubs() {
		return foundationClubs;
	}
	
	public Foundation getFoundationDiamonds() {
		return foundationDiamonds;
	}
	
	public Foundation getFoundationHearts() {
		return foundationHearts;
	}
	
	public ArrayList<Tableau> getTableauList() {
		return tableauList;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	
	public String getFormattedTime() {
		int hours = time / 3600;
		int minutes = (time % 3600) / 60;
		int seconds = time % 60;
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getTime() {
		return time;
	}
	
	public Timer getGameTimer() {
		return gameTimer;
	}
	
	public boolean getIsTimerRunning() {
		return isTimerRunning;
	}
	
	public void setIsTimerRunning(boolean isTimerRunning) {
		this.isTimerRunning = isTimerRunning;		
	}
	
	public int getDeckPasses() {
		return deckPasses;
	}
	
	public void incrementDeckPass() {
		deckPasses += 1;
	}
	
	public String getGameMode() {
		return gameMode;
	}
	
	public String getDrawMode() {
		return drawMode;
	}
	
	//==================================
	//          Private Methods
	//==================================
	
	//Sets up the cards in all the tableaus
	private void initializeGameBoard() {
		dealCardsToTableau(tableau1);
		dealCardsToTableau(tableau2);
		dealCardsToTableau(tableau3);
		dealCardsToTableau(tableau4);
		dealCardsToTableau(tableau5);
		dealCardsToTableau(tableau6);
		dealCardsToTableau(tableau7);		
	}
	
	//Deals all the required undiscovered cards to the tableau object along with the last visible card.
	private void dealCardsToTableau(Tableau tableau) {
		
		int i = 0;
		for (i = 0; i < tableau.getUndiscoveredCards(); i++) {
			tableau.dealCard(cardDeck.getCardByIndex(i));
			cardDeck.removeCardByIndex(i);
		}
		
		tableau.dealCard(cardDeck.getCardByIndex(i));
		cardDeck.removeCardByIndex(i);
		tableau.setLastTableauCardVisible();	
	}
	
}
