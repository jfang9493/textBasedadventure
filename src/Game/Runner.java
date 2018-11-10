package Game;

import People.Person;
import Rooms.*;
import Game.Board;

import java.util.Scanner;

public class Runner {

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		Board building = new Board(5,5);

		//Fill the building with normal rooms
		for (int x = 0; x<building.board.length; x++)
		{
			for (int y = 0; y < building.board[x].length; y++)
			{
				building.board[x][y] = new Room(x,y);
			}
		}

		int x,y;
		//Create 11-12 random monster rooms
		int randomMonster = (int) Math.random()+11;
		for (int i = 0; i < randomMonster; i++) {
			x = (int) (Math.random() * building.board.length);
			y = (int) (Math.random() * building.board.length);
			if (x == 0 && y == 0) {
				x = (int) Math.random()*3+1;
				y = (int) Math.random()*3+1;
			}
			building.board[x][y] = new MonsterRoom(x, y);
		}

		//Create 5 random item rooms
		for (int i = 0; i < 5;i++)
		{
			if (Math.random() > 0.50) {
				x = (int) (Math.random() * building.board.length);
				y = (int) (Math.random() * building.board.length);
				building.board[x][y] = new PotionRoom(x, y);
			}
			else {
				x = (int) (Math.random() * building.board.length);
				y = (int) (Math.random() * building.board.length);
				building.board[x][y] = new ShieldRoom(x, y);
			}
		}
		//Create a random treasure room.
		x = (int)(Math.random()*building.board.length);
		y = (int)(Math.random()*building.board.length);
		if (x == 0 && y == 0) {
			x = (int) Math.random()*3+1;
			y = (int) Math.random()*3+1;
		}
		building.board[x][y] = new TreasureRoom(x, y);

		System.out.println("treasure roon: " + x + "," + y);
		//Setup player 1 and the input scanner
		Person player1 = new Person(10,1,0, 0,0);
		building.board[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		System.out.println("Use the WASD keys to move");
		while(gameOn)
		{
			for(int i = 0; i < building.board.length; i++)
			{
				for (int j = 0; j < building.board[x].length; j++)
				{
					if(player1.getxLoc() == i && player1.getyLoc() == j)
						System.out.print("[O]");
					else
						System.out.print("[ ]");
				}
				System.out.println();
			}
			String move = in.nextLine();
			if(validMove(move, player1, building.board))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				
			}
			else {
				System.out.println("Please choose a valid move.");
			}
			if (player1.getxLoc() == 0 && player1.getyLoc() == 0 && player1.checkTreasure()) {
				System.out.println("You successfully escaped the castle with the treasure. Unfortunately you tripped on a rock outside and died.");
				gameOn = false;
			}
		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "w":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "d":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "a":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;
					
		}
		return true;
	}

	public static void gameOff()
	{
		gameOn = false;
	}
	


}
