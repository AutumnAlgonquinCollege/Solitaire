package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.GameBoard;
import models.Tableau;

public class TableauActionListener implements ActionListener {

	private GameBoard gameBoard;
	private Controller controller;
	private Tableau tableau;
	
	public TableauActionListener(GameBoard gameBoard, Controller controller, Tableau tableau) {
		this.gameBoard = gameBoard;
		this.controller = controller;
		this.tableau = tableau;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		LastCardSelectedUtility.setCardSelected(tableau, tableau.getTotalCards());
		
		
	}

}
