package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.GameBoard;

public class TableauActionListener implements ActionListener {

	private GameBoard gameBoard;
	private Controller controller;
	
	public TableauActionListener(GameBoard gameBoard, Controller controller) {
		this.gameBoard = gameBoard;
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
