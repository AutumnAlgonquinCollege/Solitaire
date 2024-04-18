package models;

import javax.swing.ImageIcon;

public class Constants {
	
	//==================================
	//        List of Constants
	//==================================
	public static final String[] suitArray = {"SPADES", "CLUBS", "DIAMONDS", "HEARTS"};
	public static final int[] rankArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	public static final String spades = "SPADES";
	public static final String clubs = "CLUBS";
	public static final String diamonds = "DIAMONDS";
	public static final String hearts = "HEARTS";
	
	public static final long timeDelay = 1000;
	public static final long timePeriod = 1000;
	
	
	public static final ImageIcon emptyCardImg = new ImageIcon("ImageAssets/NewModels/Backs/empty-frame.png");
	public static final ImageIcon backSideImg = new ImageIcon("ImageAssets/NewModels/Backs/card-backnew.png"); 
	
	//Old image paths
	/*	
	public static final ImageIcon backSideImg = new ImageIcon("ImageAssets/Backs/back_0.png"); 
	*/
	public static final ImageIcon spadesFoundationImg = new ImageIcon("ImageAssets/NewModels/Backs/spades-foundation.png");
	public static final ImageIcon clubsFoundationImg = new ImageIcon("ImageAssets/NewModels/Backs/clubs-foundation.png");
	public static final ImageIcon diamondsFoundationImg = new ImageIcon("ImageAssets/NewModels/Backs/diamonds-foundation.png");
	public static final ImageIcon heartsFoundationImg = new ImageIcon("ImageAssets/NewModels/Backs/hearts-foundation.png");
	
	
	//New card images
	public static final String[] spadesImgPath = 
		{"ImageAssets/NewModels/Spades/card-spades-1.png",
		"ImageAssets/NewModels/Spades/card-spades-2.png",
		"ImageAssets/NewModels/Spades/card-spades-3.png",
		"ImageAssets/NewModels/Spades/card-spades-4.png",
		"ImageAssets/NewModels/Spades/card-spades-5.png",
		"ImageAssets/NewModels/Spades/card-spades-6.png",
		"ImageAssets/NewModels/Spades/card-spades-7.png",
		"ImageAssets/NewModels/Spades/card-spades-8.png",
		"ImageAssets/NewModels/Spades/card-spades-9.png",
		"ImageAssets/NewModels/Spades/card-spades-10.png",
		"ImageAssets/NewModels/Spades/card-spades-11.png",
		"ImageAssets/NewModels/Spades/card-spades-12.png",
		"ImageAssets/NewModels/Spades/card-spades-13.png" };
	public static final String[] clubsImgPath = 
		{"ImageAssets/NewModels/Clubs/card-clubs-1new.png",
		"ImageAssets/NewModels/Clubs/card-clubs-2.png",
		"ImageAssets/NewModels/Clubs/card-clubs-3.png",
		"ImageAssets/NewModels/Clubs/card-clubs-4.png",
		"ImageAssets/NewModels/Clubs/card-clubs-5.png",
		"ImageAssets/NewModels/Clubs/card-clubs-6.png",
		"ImageAssets/NewModels/Clubs/card-clubs-7.png",
		"ImageAssets/NewModels/Clubs/card-clubs-8.png",
		"ImageAssets/NewModels/Clubs/card-clubs-9.png",
		"ImageAssets/NewModels/Clubs/card-clubs-10.png",
		"ImageAssets/NewModels/Clubs/card-clubs-11.png",
		"ImageAssets/NewModels/Clubs/card-clubs-12.png",
		"ImageAssets/NewModels/Clubs/card-clubs-13.png" };
	public static final String[] diamondsImgPath = 
		{"ImageAssets/NewModels/Diamonds/card-diamonds-1.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-2.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-3.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-4.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-5.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-6.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-7.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-8.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-9.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-10.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-11.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-12.png",
		"ImageAssets/NewModels/Diamonds/card-diamonds-13.png" };
	public static final String[] heartsImgPath = 
		{"ImageAssets/NewModels/Hearts/card-hearts-1.png",
		"ImageAssets/NewModels/Hearts/card-hearts-2.png",
		"ImageAssets/NewModels/Hearts/card-hearts-3.png",
		"ImageAssets/NewModels/Hearts/card-hearts-4.png",
		"ImageAssets/NewModels/Hearts/card-hearts-5.png",
		"ImageAssets/NewModels/Hearts/card-hearts-6.png",
		"ImageAssets/NewModels/Hearts/card-hearts-7.png",
		"ImageAssets/NewModels/Hearts/card-hearts-8.png",
		"ImageAssets/NewModels/Hearts/card-hearts-9.png",
		"ImageAssets/NewModels/Hearts/card-hearts-10.png",
		"ImageAssets/NewModels/Hearts/card-hearts-11.png",
		"ImageAssets/NewModels/Hearts/card-hearts-12.png",
		"ImageAssets/NewModels/Hearts/card-hearts-13.png" };
	
	//Old card images
	/*
		public static final String[] spadesImgPath = 
			{"ImageAssets/Spades/Spades_card_01.png",
			"ImageAssets/Spades/Spades_card_02.png",
			"ImageAssets/Spades/Spades_card_03.png",
			"ImageAssets/Spades/Spades_card_04.png",
			"ImageAssets/Spades/Spades_card_05.png",
			"ImageAssets/Spades/Spades_card_06.png",
			"ImageAssets/Spades/Spades_card_07.png",
			"ImageAssets/Spades/Spades_card_08.png",
			"ImageAssets/Spades/Spades_card_09.png",
			"ImageAssets/Spades/Spades_card_10.png",
			"ImageAssets/Spades/Spades_card_11.png",
			"ImageAssets/Spades/Spades_card_12.png",
			"ImageAssets/Spades/Spades_card_13.png" };
		public static final String[] clubsImgPath = 
			{"ImageAssets/Clubs/Clubs_card_01.png",
			"ImageAssets/Clubs/Clubs_card_02.png",
			"ImageAssets/Clubs/Clubs_card_03.png",
			"ImageAssets/Clubs/Clubs_card_04.png",
			"ImageAssets/Clubs/Clubs_card_05.png",
			"ImageAssets/Clubs/Clubs_card_06.png",
			"ImageAssets/Clubs/Clubs_card_07.png",
			"ImageAssets/Clubs/Clubs_card_08.png",
			"ImageAssets/Clubs/Clubs_card_09.png",
			"ImageAssets/Clubs/Clubs_card_10.png",
			"ImageAssets/Clubs/Clubs_card_11.png",
			"ImageAssets/Clubs/Clubs_card_12.png",
			"ImageAssets/Clubs/Clubs_card_13.png" };
		public static final String[] diamondsImgPath = 
			{"ImageAssets/Diamonds/Diamonds_card_01.png",
			"ImageAssets/Diamonds/Diamonds_card_02.png",
			"ImageAssets/Diamonds/Diamonds_card_03.png",
			"ImageAssets/Diamonds/Diamonds_card_04.png",
			"ImageAssets/Diamonds/Diamonds_card_05.png",
			"ImageAssets/Diamonds/Diamonds_card_06.png",
			"ImageAssets/Diamonds/Diamonds_card_07.png",
			"ImageAssets/Diamonds/Diamonds_card_08.png",
			"ImageAssets/Diamonds/Diamonds_card_09.png",
			"ImageAssets/Diamonds/Diamonds_card_10.png",
			"ImageAssets/Diamonds/Diamonds_card_11.png",
			"ImageAssets/Diamonds/Diamonds_card_12.png",
			"ImageAssets/Diamonds/Diamonds_card_13.png" };
		public static final String[] heartsImgPath = 
			{"ImageAssets/Hearts/Hearts_card_01.png",
			"ImageAssets/Hearts/Hearts_card_02.png",
			"ImageAssets/Hearts/Hearts_card_03.png",
			"ImageAssets/Hearts/Hearts_card_04.png",
			"ImageAssets/Hearts/Hearts_card_05.png",
			"ImageAssets/Hearts/Hearts_card_06.png",
			"ImageAssets/Hearts/Hearts_card_07.png",
			"ImageAssets/Hearts/Hearts_card_08.png",
			"ImageAssets/Hearts/Hearts_card_09.png",
			"ImageAssets/Hearts/Hearts_card_10.png",
			"ImageAssets/Hearts/Hearts_card_11.png",
			"ImageAssets/Hearts/Hearts_card_12.png",
			"ImageAssets/Hearts/Hearts_card_13.png" };
			*/	
}
