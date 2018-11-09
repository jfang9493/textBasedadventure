package Rooms;

import People.Person;

public class ShieldRoom extends Room{

	public ShieldRoom(int x, int y) {
		super(x, y);
	}

	/**
	 * Method controls the results when a person enters this room.
	 * @param x the Person entering
	 */
	public void enterRoom(Person x)
	{
		occupant = x;
		System.out.println("You found a shield!");
		x.changeArmor(1);
		x.showArmor();
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}
}
