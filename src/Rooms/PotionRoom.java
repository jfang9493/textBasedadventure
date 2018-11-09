package Rooms;

import People.Person;

public class PotionRoom extends Room{

	public PotionRoom(int x, int y) {
		super(x, y);
	}

	@Override
	public void enterRoom(Person x)
	{
		occupant = x;
		int recover = (int)(Math.random()*2);
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
