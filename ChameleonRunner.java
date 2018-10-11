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
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 * @author Ilana Shapiro -- rewrote this entire runner class to suit the Jumping Animal game
 */

import java.awt.Color;

import java.util.ArrayList;
import javax.swing.*;
//import java.util.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;


/**
 * This class runs a world that contains chameleon critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class ChameleonRunner extends World<Actor>
{
	private static Zebra zebra = new Zebra(); //"zebra" is the jumping square
   	private static SideScroller[][] sqArray = new SideScroller[3][3];
   	private static Location[][] locArray = new Location[3][3];

   	private static SideScroller[][] sqArrayTall = new SideScroller[4][1];
   	private static Location[][] locArrayTall = new Location[4][1];

   	private static SideScroller[][] sqArrayLong = new SideScroller[1][5];
   	private static Location[][] locArrayLong = new Location[1][5];

   	private static int fireCount = 1;
	public static Timer t;
	private static ActorWorld world = new ActorWorld(zebra);
	private Grid<Actor> gr = (Grid<Actor>)getGrid();
    private ArrayList<Actor> actors = new ArrayList<Actor>();

    public static void main(String[] args)
    {
    	SideScrollerArray scroller = new SideScrollerArray(3, 3);

    	for(int r = 0; r < sqArray.length; r++)
        {
        	for(int c = 0; c < sqArray[0].length; c++)
        	{
        		sqArray[r][c] = new SideScroller();
        		locArray[r][c] = new Location(18 + r, 50 + c);
			}
        }

        world.add(new Location(20, 8), zebra);


        world.add(locArray, sqArray);


        world.show();
    }

     public int stop()
     {
     	t.stop();
     	return fireCount;
  	 }

    public void scrollerAdd()
    {

        int delay = 500; //milliseconds
  		ActionListener taskPerformer = new ActionListener(){
  			public void actionPerformed(ActionEvent evt) {
  				int i = (int)(Math.random() * 3 + 1);
  				if(i == 1 && fireCount % 4 == 0)
  				{
  					for(int r = 0; r < sqArray.length; r++)
				    {
				        for(int c = 0; c < sqArray[0].length; c++)
				        {
				        	sqArray[r][c] = new SideScroller();
				        	locArray[r][c] = new Location(18 + r, 50 + c);
						}
				    }
  					world.add(locArray, sqArray);

  				}

  				else if(i == 2 && fireCount % 4 == 0)
  				{
  					for(int r = 0; r < sqArrayTall.length; r++)
				    {
				        for(int c = 0; c < sqArrayTall[0].length; c++)
				        {
				        	sqArrayTall[r][c] = new SideScroller();
				        	locArrayTall[r][c] = new Location(17 + r, 50 + c);
						}
				    }
  					world.add(locArrayTall, sqArrayTall);

  				}

  				else if(i == 3 && fireCount % 4 == 0)
  				{
  					for(int r = 0; r < sqArrayLong.length; r++)
				    {
				        for(int c = 0; c < sqArrayLong[0].length; c++)
				        {
				        	sqArrayLong[r][c] = new SideScroller();
				        	locArrayLong[r][c] = new Location(20 + r, 50 + c);
						}
				    }
  					world.add(locArrayLong, sqArrayLong);

  				}

		       fireCount++;
		       //System.out.println(fireCount);
   			 }

  		};

  		t = new Timer(delay, taskPerformer);
  		t.start();
    }
}













//code to add more shapes in the timer:
/*int i = (int)(Math.random() * 3 + 1);
  				if(i == 1 && fireCount % 4 == 0)
  				{
  					for(int r = 0; r < sqArray.length; r++)
				    {
				        for(int c = 0; c < sqArray[0].length; c++)
				        {
				        	sqArray[r][c] = new SideScroller();
				        	locArray[r][c] = new Location(18 + r, 50 + c);
						}
				    }
  					world.add(locArray, sqArray);

  				}

  				else if(i == 2 && fireCount % 4 == 0)
  				{
  					for(int r = 0; r < sqArrayTall.length; r++)
				    {
				        for(int c = 0; c < sqArrayTall[0].length; c++)
				        {
				        	sqArrayTall[r][c] = new SideScroller();
				        	locArrayTall[r][c] = new Location(18 + r, 50 + c);
						}
				    }
  					world.add(locArrayTall, sqArrayTall);

  				}

  				else if(i == 3 && fireCount % 4 == 0)
  				{
  					for(int r = 0; r < sqArrayLong.length; r++)
				    {
				        for(int c = 0; c < sqArrayLong[0].length; c++)
				        {
				        	sqArrayLong[r][c] = new SideScroller();
				        	locArrayLong[r][c] = new Location(20 + r, 50 + c);
						}
				    }
  					world.add(locArrayLong, sqArrayLong);

  				}
  				*/
