package People;

import Game.Runner;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
	int xLoc, yLoc, armor, health, treasure;


	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public void changeHealth(int num) {
		this.health += num;
	}

	public void showHealth() {
		if (this.health <= 0) {
			System.out.println("You have died");
			Runner.gameOff();
		}
		else {
			System.out.println("You have " + this.health + " health.");
		}
	}
	public Boolean hasArmor() {
		if (this.armor >0) {
			return true;
		}
		else return false;
	}
	public void changeArmor(int num) {
		this.armor += num;
	}

	public void showArmor() {
		System.out.println("You have " + this.armor + " armor.");
	}

	public void addTreasure(){
		this.treasure = 1;
	}

	public Boolean checkTreasure(){
		if (this.treasure == 1) return true;
		else return false;
	}
	public Person (int health,int armor, int xLoc, int yLoc,int treasure)
	{
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.armor = armor;
		this.health = health;
		this.treasure = treasure;
	}

}
