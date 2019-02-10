package com.nimgame.main;

/*
 * This is the Model class which demonstrate 
 * methods like getter and setter methods that will be used in the game as an access point
 * of instance variables and removeStone() method
 * Mohammed Atiq Mohammed Mashaq Shaikh 29/03/2017
 * */

public class NimPlayer {

	private String player1, player2;
	private int upperBound, stoneLeft;

	public String getPlayer1() {
		return player1;
	}
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	public String getPlayer2() {
		return player2;
	}
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	public int getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	public int getStoneLeft() {
		return stoneLeft;
	}
	public void setStoneLeft(int stoneLeft) {
		this.stoneLeft = stoneLeft;
	}

	//Method to remove stone from the stone which are left
    int removeStone(int removeStone,int stoneLeft)
	{
		stoneLeft = stoneLeft - removeStone;
		return stoneLeft;
	}
	
}
