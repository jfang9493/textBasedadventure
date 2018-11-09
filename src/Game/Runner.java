package Game;

import People.Person;
import Rooms.MonsterRoom;
import Game.Board;
import Rooms.Room;
import Rooms.WinningRoom;

import java.util.Scanner;

public class Runner {

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		Room[][] building = new Room[5][5];

		//Fill the building with normal rooms
		for (int x = 0; x<building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
			}
		}
		
		//Create a random winning room.
		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building.length);
		building[x][y] = new WinningRoom(x, y);

		//Create 5-7 random monster rooms
		int randomMonster = (int) (Math.random()*2)+5;
		for (int i = 0; i < randomMonster; i++) {
			x = (int) (Math.random() * building.length);
			y = (int) (Math.random() * building.length);
			building[x][y] = new MonsterRoom(x, y);
		}

		//Create 3 random item rooms
		/** for (int i = 0; i < 3;i++)
		{
			if (Math.random() > 0.50) {
				x = (int) (Math.random() * building.length);
				y = (int) (Math.random() * building.length);
				building[x][y] = new PotionRoom(x, y);
			}
			else {
				x = (int) (Math.random() * building.length);
				y = (int) (Math.random() * building.length);
				building[x][y] = new ShieldRoom(x, y);
			}
		}*/


		 //Setup player 1 and the input scanner
		Person player1 = new Person(0,5,0, 0,0);
		building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose N, S, E, W)");
			String move = in.nextLine();
			if(validMove(move, player1, building))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				
			}
			else {
				System.out.println("Please choose a valid move.");
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
			case "n":
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
			case "e":
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

			case "w":
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
