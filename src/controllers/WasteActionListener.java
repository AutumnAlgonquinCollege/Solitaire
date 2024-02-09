package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.CardButton;

public class WasteActionListener implements ActionListener{

	private void checkIfCardRemoved() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		LastCardSelectedUtility.setCardSelected((CardButton)e.getSource());
		System.out.println(LastCardSelectedUtility.getLastCardSelected());
	}

	
	
}
