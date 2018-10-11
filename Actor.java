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
 * @author Ilana Shapiro: greatly modified canMove to create new rules for if the jumping green square can still move (i.e. to ascertain if it has hit an incoming obstacle). if any side of the jumping green square has hit a black scrolling obstacle, the green square cannot move
 */


import java.awt.Color;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;

/**
 * An <code>Actor</code> is an entity with a color and direction that can act.
 * <br />
 * The API of this class is testable on the AP CS A and AB exams.
 */
public class Actor
{
    private Grid<Actor> grid;
    private Location location;
    private int direction;
    private Color color;
    private Actor act;

    /**
     * Constructs a blue actor that is facing north.
     */
    public Actor()
    {
        color = Color.BLUE;
        direction = Location.EAST;
        grid = null;
        location = null;


    }

    /**
     * Gets the color of this actor.
     * @return the color of this actor
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Sets the color of this actor.
     * @param newColor the new color
     */
    public void setColor(Color newColor)
    {
        color = newColor;
    }

    /**
     * Gets the current direction of this actor.
     * @return the direction of this actor, an angle between 0 and 359 degrees
     */
    public int getDirection()
    {
        return direction;
    }

    /**
     * Sets the current direction of this actor.
     * @param newDirection the new direction. The direction of this actor is set
     * to the angle between 0 and 359 degrees that is equivalent to
     * <code>newDirection</code>.
     */
    public void setDirection(int newDirection)
    {
        direction = newDirection % Location.FULL_CIRCLE;
        if (direction < 0)
            direction += Location.FULL_CIRCLE;
    }

    /**
     * Gets the grid in which this actor is located.
     * @return the grid of this actor, or <code>null</code> if this actor is
     * not contained in a grid
     */
    public Grid<Actor> getGrid()
    {
        return grid;
    }

    /**
     * Gets the location of this actor.
     * @return the location of this actor, or <code>null</code> if this actor is
     * not contained in a grid
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Puts this actor into a grid. If there is another actor at the given
     * location, it is removed. <br />
     * Precondition: (1) This actor is not contained in a grid (2)
     * <code>loc</code> is valid in <code>gr</code>
     * @param gr the grid into which this actor should be placed
     * @param loc the location into which the actor should be placed
     */
    public void putSelfInGrid(Grid<Actor> gr, Location loc)
    {
        if (grid != null)
            throw new IllegalStateException(
                    "This actor is already contained in a grid.");

        Actor actor = gr.get(loc);
        if (actor != null)
        {
        	actor.removeSelfFromGrid();
        //	System.out.println("2");
        }

        gr.put(loc, this);
        grid = gr;
        location = loc;
    }

    public void putSelfInGrid(Grid<Actor> gr, Location loc, SideScroller sc)
    {
        if (grid != null)
            throw new IllegalStateException(
                    "This actor is already contained in a grid.");

        Actor actor = gr.get(loc);
        if (actor != null){
        	//System.out.println("2");
        	actor.removeSelfFromGrid();
        }

        gr.put(loc, sc);
        grid = gr;
        location = loc;
    }

    public void putSelfInGrid(Grid<Actor> gr, Location loc[][])
    {
    	for(int r = 0; r < loc.length; r++)
        {
        	for(int c = 0; c < loc[0].length; c++)
        	{
		        if (grid != null)
		            throw new IllegalStateException(
		                    "This actor is already contained in a grid.");

		        Actor actor = gr.get(loc[r][c]);
		        if (actor != null)
		        {//System.out.println("here");
		        	actor.removeSelfFromGrid();

		        }


		        gr.put(loc[r][c], this);
		        grid = gr;
				location = loc[r][c];
        	}
        }
    }





    /**
     * Removes this actor from its grid. <br />
     * Precondition: This actor is contained in a grid
     */
    public void removeSelfFromGrid()
    {
        if (grid == null)
            throw new IllegalStateException(
                    "This actor is not contained in a grid.");
        if (grid.get(location) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + location + ".");

        grid.remove(location);
        grid = null;
        location = null;
        //System.out.println("REMOVEDSELF");
    }

    /**
     * Moves this actor to a new location. If there is another actor at the
     * given location, it is removed. <br />
     * Precondition: (1) This actor is contained in a grid (2)
     * <code>newLocation</code> is valid in the grid of this actor
     * @param newLocation the new location
     */
    public void moveTo(Location newLocation)
    {
        if (grid == null)
            throw new IllegalStateException("This actor is not in a grid.");
        if (grid.get(location) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + location + ".");

        if (!grid.isValid(newLocation))
			throw new IllegalArgumentException("Location " + newLocation
                    + " is not valid.");
        if (newLocation.equals(location))
            return;
        grid.remove(location);
        Actor other = grid.get(newLocation);
        if (other != null)
        {
        	System.out.println("here");
        	other.removeSelfFromGrid();
        }


        location = newLocation;
        //System.out.println(location);
        grid.put(location, this);
    }

    /**
     * Reverses the direction of this actor. Override this method in subclasses
     * of <code>Actor</code> to define types of actors with different behavior
     *
     */
    public void act()
    {
        if (canMove())
        {
        	 move();
        	 //System.out.println(this);
        }

    }

    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection() + 180);
        //System.out.println(next);
        if (!grid.isValid(next) && grid.get(location) instanceof SideScroller)
        {
        	//System.out.println("REMOVED");
        	this.removeSelfFromGrid();
        }

        else if (gr.isValid(next))
            moveTo(next);
    }


    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection() + 180);
        Location left = loc.getAdjacentLocation(270);
        Location down = loc.getAdjacentLocation(180);
        Location right = loc.getAdjacentLocation(90);

        if(!gr.isValid(next) && this instanceof SideScroller)
        	return true;
        else if (!gr.isValid(next))
            return false;
        Actor actor = gr.get(loc);
        Actor neighbor = gr.get(next);
        Actor neighborDown = gr.get(down);
        Actor neighborRight = gr.get(right);
        Actor neighborLeft = gr.get(left);

        if(actor instanceof SideScroller && neighbor instanceof Zebra)
        {
        	return false;
        }

        else if(actor instanceof SideScroller && neighborLeft instanceof Zebra)
        {
        	return false;

        }

        else if(actor instanceof Zebra && neighborDown instanceof SideScroller)
        {
        	return false;
        }
        else if(actor instanceof Zebra && neighborRight instanceof SideScroller)
        {
        	return false;
        }

        //System.out.println(neighbor);
        return true;
    }



    /**
     * Creates a string that describes this actor.
     * @return a string with the location, direction, and color of this actor
     */
    public String toString()
    {
        return getClass().getName() + "[location=" + location + ",direction="
                + direction + ",color=" + color + "]";
    }

    public boolean toStop(ArrayList<Actor> actors)
    {

		for (Actor a : actors)
		{
			System.out.println(a);
			if (a.canMove() == false)
			{
				System.out.println("CANNOT MOVE");
				return true;
			}
		}
		return false;
    }


}
