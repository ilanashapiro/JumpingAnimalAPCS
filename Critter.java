/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Cay Horstmann
 * @author Ilana Shapiro: added jump method which will cause the green square to jump when the user calls it to avoid the black obstacles scrolling toward it. Also deleted extraneous methods from the original GridWorld
 */

import java.util.ArrayList;


/**
 * A <code>Critter</code> is an actor that moves through its world, processing
 * other actors in some way and then moving to a new location. Define your own
 * critters by extending this class and overriding any methods of this class
 * except for <code>act</code>. When you override these methods, be sure to
 * preserve the postconditions. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Critter extends Actor
{

    /**
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

    /**
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

    /**
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



    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn(int radians)
    {
    	double deg = radians * (180/Math.PI);
        setDirection(getDirection() + (int)deg);
    }



    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }


	//method to jump the green square in the side scroller
    public void jump()
    {
    	int radius = 10;
    	Grid<Actor> gr = getGrid();
    	//Location loc = getLocation();
        Location next = getLocation();

        if (gr == null)
            return;

    	for(int i = 0; i <= Math.PI; i += Math.PI/6)
    	{
    		double xCoord = radius * Math.cos(i);
    		double yCoord = radius * Math.sin(i);
    		next.setRow((int)(next.getRow() + xCoord));
    		next.setCol((int)(next.getCol() + yCoord));

    		if (gr.isValid(next))
    		{
    			turn(i);
            	moveTo(next);
    		}
    		else
	    		return;
    	}
    }

}
