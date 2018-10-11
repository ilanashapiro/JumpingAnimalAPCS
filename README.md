# JumpingAnimalAPCS
Ilana Shapiro's final project for AP Computer Science course 2017

This is a "side scroller" game: various obstacles of different rectangular configurations scroll toward a green square at the left side of the screen. The user can make this green square jump in order to avoid the obstacles. The obstacles then disappear off the left side of the screen, and more keep coming. If the square hits an incoming obstacle, the game is over, and the user's score is the amount of seconds the user played the game. Before playing, the user can specify the speed at which the obstacles sroll. This came is modeled of the architecture of GridWorld, the case study for the 2008 - 2013 AP CS exams.

Note: this repository contains the entire GridWorld architecture. The only files that were modified/added to were Actor, ActorWorld, ChameleonRunner (essentially rewritten, also renamed), Critter, GuiController. I created the SideScroller, SideScrollerArray, and Zebra classes.
