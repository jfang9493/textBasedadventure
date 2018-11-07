package Rooms;

import People.Person;

public class ShieldRoom {
	Person occupant;
	int xLoc,yLoc;

	public ShieldRoom(int x, int y)
	{
		xLoc = x;
		yLoc = y;
	}

	/**
	 * Method controls the results when a person enters this room.
	 * @param x the Person entering
	 */
	public void enterRoom(Person x)
	{
		occupant = x;
		int coin = (int)(Math.random()*5);
		if (xLoc == 0 && yLoc == 0)
		{
			System.out.println("You are at the entrance of the castle.");
		}
		System.out.println("You found " + coin + " coins!");
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
