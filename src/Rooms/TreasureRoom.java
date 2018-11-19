package Rooms;

import People.Person;

public class TreasureRoom extends Room{

	public TreasureRoom(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates a treasure room that adds treasure to the player's inventory
	 * @param x the Person entering
	 */
	@Override
	public void enterRoom(Person x)
	{
		occupant = x;
		System.out.println("You have found the treasure! Try to get out of the castle without dying.");
		x.addTreasure();
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}
	
}
