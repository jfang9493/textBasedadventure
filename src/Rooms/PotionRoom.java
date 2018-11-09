package Rooms;

import People.Person;

public class PotionRoom extends {
	/**
	 * Method controls the results when a person enters this room.
	 * @param x the Person entering
	 */
	public void enterRoom(Person x)
	{
		occupant = x;
		int recover = (int)(Math.random()*2);
		if (xLoc == 0 && yLoc == 0)
		{
			System.out.println("You found a potion!");
		}
		System.out.println("You recovered " + recover + " health!");
		p.health += recover;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void leaveRoom(Person x)
	{
		occupant = null;
	}
	
}
