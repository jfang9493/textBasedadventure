package Rooms;

import People.Person;

public class TreasureRoom extends Room{

	public TreasureRoom(int x, int y) {
		super(x, y);
	}

	@Override
	public void enterRoom(Person x)
	{
		occupant = x;
		System.out.println("You have found the treasure! Try to get out of the catle without dying");
		x.showHealth();
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}
	
}