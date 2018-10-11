//create the Zebra, which is the square that the user tells to jump with keyboard press in the side scroller game
//modeled after GridWorld's original Bug code
//@author Ilana Shapiro


import java.util.ArrayList;
import javax.swing.*;
//import java.util.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.Color;

public class Zebra extends Actor
{
	int fireCount = 1;
	Timer t;

	public Zebra()
	{
		setColor(null);
	}

	public Zebra(Color zebraColor)
    {
        setColor(zebraColor);
    }


	public void act()
	{
	}

	//code for the jumping square to jump in the side scroller game
	public void jump()
	{
		int delay = 50; //milliseconds

  		ActionListener taskPerformer = new ActionListener(){
  			public void actionPerformed(ActionEvent evt) {
  				if(fireCount % 16 == 0)
  				{
  						t.stop();
  						//t.restart();
  						//return;
  				}

		   		Location loc = getLocation();
		       	Location move;

		        Grid<Actor> gr = getGrid();
		        if (gr == null)
		            t.stop();

		        Location next = loc.getAdjacentLocation(getDirection() + 180);
		        Location down = loc.getAdjacentLocation(180);

		        Actor actor = gr.get(loc);
		        Actor neighbor = gr.get(next);
		        Actor neighborDown = gr.get(down);

		        if (!gr.isValid(next))
		        {
		        	move = new Location(loc.getRow(), loc.getCol());
		       		Zebra.this.moveTo(move);
		       		System.out.println("IS NOT VALID" + Zebra.this);
		        }

		        else if(actor instanceof Zebra && neighborDown instanceof SideScroller)
		        {
		        	if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		        	move = new Location(loc.getRow(), loc.getCol());
		       		Zebra.this.moveTo(move);
		        }

		       	else if(fireCount % 16 == 1)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() - 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(270);
		       	}
		       	else if(fireCount % 16 == 2)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() - 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(270);
		       	}
		       	else if(fireCount % 16 == 3)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() - 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(270);
		       	}
		       	else if(fireCount % 16 == 4)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() - 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(270);
		       	}
		       	else if(fireCount % 16 == 5)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() - 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(270);
		       	}
		       	else if(fireCount % 16 == 6)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() - 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(270);
		       	}
		       	else if(fireCount % 16 == 7)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() - 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(270);
		       	}
		       	else if(fireCount % 16 == 8)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() - 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(270);
		       	}
		       	else if(fireCount % 16 == 9)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() + 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(90);
		       	}
		       	else if(fireCount % 16 == 10)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() + 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(90);
		       	}
		        else if(fireCount % 16 == 11)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() + 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(90);
		       	}
		       	else if(fireCount % 16 == 12)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() + 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(90);
		       	}
		       	else if(fireCount % 16 == 13)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() + 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(90);
		       	}
		       	else if(fireCount % 16 == 14)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() + 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(90);
		       	}
		       	else if(fireCount % 16 == 15)
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() + 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(90);

		       	}
		       	else
		       	{
		       		if(!actor.canMove())
		        	{
		        		t.stop();
		        		return;
		        	}
		       		move = new Location(loc.getRow() + 1, loc.getCol());
		       		Zebra.this.moveTo(move);
		       		Zebra.this.setDirection(90);

		       	}

		       	//System.out.println(move);
		       	fireCount++;
   			 }

  		};

  		t = new Timer(delay, taskPerformer);
  		t.start();
	}


    /**THE FOLLOWING WAS TAKEN FROM THE ORIGINAL GRIDWORLD CODE -- I DID NOT WRITE THIS METHOD
     * Gets the actors for processing. Implemented to return the actors that
     * occupy neighboring grid locations. Override this method in subclasses to
     * look elsewhere for actors to process.<br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        return getGrid().getNeighbors(getLocation());
    }

    /**THE FOLLOWING WAS TAKEN FROM THE ORIGINAL GRIDWORLD CODE -- I DID NOT WRITE THIS METHOD
     * Processes the elements of <code>actors</code>. New actors may be added
     * to empty locations. Implemented to "eat" (i.e. remove) selected actors
     * that are not rocks or critters. Override this method in subclasses to
     * process actors in a different way. <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (!(a instanceof Rock) && !(a instanceof Critter))
                a.removeSelfFromGrid();
        }
    }

    /**THE FOLLOWING WAS TAKEN FROM THE ORIGINAL GRIDWORLD CODE -- I DID NOT WRITE THIS METHOD
     * Gets a list of possible locations for the next move. These locations must
     * be valid in the grid of this critter. Implemented to return the empty
     * neighboring locations. Override this method in subclasses to look
     * elsewhere for move locations.<br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of possible locations for the next move
     */
    public ArrayList<Location> getMoveLocations()
    {
        return getGrid().getEmptyAdjacentLocations(getLocation());
    }





    /**THE FOLLOWING WAS TAKEN FROM THE ORIGINAL GRIDWORLD CODE -- I DID NOT WRITE THIS METHOD
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn(int radians)
    {
    	double deg = radians * (180/Math.PI);
        setDirection(getDirection() + (int)deg);
    }

}
