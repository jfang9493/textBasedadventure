package People;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
	int xLoc, yLoc, shield, potion, money;


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

	public Person (int shield, int potion, int money, int xLoc, int yLoc)
	{
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.shield = shield;
		this.potion = potion;
		this.money = money;
	}


}
