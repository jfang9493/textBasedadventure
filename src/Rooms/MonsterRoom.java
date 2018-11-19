package Rooms;

import Game.Runner;
import People.Person;

public class MonsterRoom extends Room
{

	public MonsterRoom(int x, int y) {
		super(x, y);
	}

	/**
	 * Player battles a monster when entering this room
	 * If player has armor, an armor point is removed
	 * Otherwise player takes between 1 to 4 points of damage inclusively
	 * @param x the Person entering
	 */
	@Override
	public void enterRoom(Person x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("You encounter a monster!");
		int damage = (int) Math.random()*3+1;
		if(x.hasArmor()) {
			x.changeArmor(-1);
			System.out.println("You kill the monster, but it destroys part of your armor.");
			x.showArmor();
			x.showHealth();
		}
		else {
			x.changeHealth(damage);
		}
	}
	

}
