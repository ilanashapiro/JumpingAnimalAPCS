//creates the shapes ("obstacles") that move/scroll to the jumping square for the user to jump over
//@author Ilana Shapiro


import java.awt.Color;

public class SideScroller extends Actor
{


	public SideScroller()
	{
		setColor(Color.BLACK);
	}


	public void act()
    {
        if (canMove())
            move();
    }

}
