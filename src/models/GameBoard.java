package models;

public class GameBoard {
	
	//==================================
	//          Attributes
	//==================================
	private CardDeck cardDeck;
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
	
	
	//==================================
	//          Constructor
	//==================================
	public GameBoard() {
		cardDeck = new CardDeck();
		tableau1 = new Tableau(0);
		tableau2 = new Tableau(1);
		tableau3 = new Tableau(2);
		tableau4 = new Tableau(3);
		tableau5 = new Tableau(4);
		tableau6 = new Tableau(5);
		tableau7 = new Tableau(6);
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
		int i;
		for (i = 0; i < tableau.getUndiscoveredCards(); i++) {
			tableau.dealCard(cardDeck.drawCard(i));
			cardDeck.removeCardByIndex(i);
		}
		
		tableau.dealCard(cardDeck.drawCard(i));
		cardDeck.removeCardByIndex(i);
		tableau.setLastTableauCardVisible();	
	}	
	
}
