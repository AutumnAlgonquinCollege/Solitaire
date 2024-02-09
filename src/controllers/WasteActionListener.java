package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.CardButton;

public class WasteActionListener implements ActionListener{

	Controller controller;
	
	
	public WasteActionListener(Controller controller) {
		this.controller = controller;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		LastCardSelectedUtility.setCardSelected(controller.getGameBoard().getWastePile(), LastCardSelectedUtility.indexNull);
		System.out.println(LastCardSelectedUtility.getLastCardSelected().toString());
		System.out.println(LastCardSelectedUtility.getLastIndexSelected().toString());
		controller.redrawAll();
		System.out.println("Successfully redrew.");
	}

	
	
}
