package Rooms;

import People.Person;

public class PotionRoom extends Room{

	public PotionRoom(int x, int y) {
		super(x, y);
	}

	/**
	 * Heals the player's health points for a random number between 1-3 inclusively
	 * @param x the Person entering
	 */
	@Override
	public void enterRoom(Person x)
	{
		occupant = x;
		int recover = (int)(Math.random()*2)+1;
		if (xLoc == 0 && yLoc == 0)
		{
			System.out.println("You found a potion!");
		}
		System.out.println("You recovered " + recover + " health!");
		x.changeHealth(recover);
		x.showHealth();
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}
	
}
