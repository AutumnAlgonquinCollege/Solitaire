package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.*;
import views.*;

public class FoundationActionListener implements ActionListener{

	GameView gameView;
	Controller controller;
	Foundation foundation;
	WastePile wastePile;
	CardButton foundationView;
	
	
	public FoundationActionListener (Foundation foundation, GameView GV, WastePile wp, Controller controller, CardButton FV) {
		this.gameView = GV;
		this.foundation = foundation;
		this.wastePile = wp;
		this.controller = controller;
		CardButton foundationView = FV;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(LastCardSelectedUtility.getLastCardSelected() == controller.getWasteBtn()) {
			foundation.addCard(wastePile.getLastCard());
			foundationView.setIcon(wastePile.getLastCard().getImageIcon());
		}
		
	}

}
