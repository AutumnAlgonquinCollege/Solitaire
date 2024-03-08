package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.WastePile;
import views.CardButton;

public class WasteActionListener implements ActionListener{

	Controller controller;
	WastePile wastePile;
	
	public WasteActionListener(Controller controller) {
		this.controller = controller;
		wastePile = controller.getGameBoard().getWastePile();
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		LastCardSelectedUtility.setCardSelected(wastePile, wastePile.getLastWasteIndex());
	}

	
	
}
