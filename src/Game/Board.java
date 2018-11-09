package Game;

import Rooms.Room;

public class Board
{
    Room[][] board;

    public Board(Room[][] board)
    {
        this.board = board;
    }

    public Board(int height, int width)
    {
        this.board = new Room[height][width];
    }

    public void addRoom(Room room, int row, int col)
    {
        board[row][col] = room;
    }

    public String print()
    {
        String str = "";
        for (Room[] i : board)
        {
            for (Room j : i)
            {
                str += j;
            }
            str += "\n";
        }
        return str;
    }
}