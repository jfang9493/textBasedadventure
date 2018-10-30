package Rooms;
import java.util.Scanner;

import Game.Runner;
import People.Person;

public class ShopRoom extends Room{
    public ShopRoom(int a, int b)
    {
        super(a,b);
    }
    @Override
    public void enterRoom(Person a) {

        occupant = a;
        a.setxLoc(this.xLoc);
        a.setyLoc(this.yLoc);
        System.out.println("YOU HAVE FOUND SEAN'S SECRET SHOP!!! I HAVE A PAPER SWORD AND A POTATO, PLEASE TAKE ONE!!!");
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();
        while (!statement.equals("Leave"))
        {
            statement = in.nextLine();
            if (statement.equals("sword") || statement.equals("Sword"))
            {
                System.out.println("WONDERFUL CHOICE!!!");
                break;
            }
            else if (statement.equals("potato") || statement.equals("Potato"))
            {
                System.out.println("ENJOY IT!!!");
                break;
            }
            else
            {
                System.out.println("I DON'T UNDERSTAND YOU. DO YOU WANT THE SWORD OR THE POTATO.");
            }
    }


}
}
