//stores arrays of SideScroller objects
//@author Ilana Shapiro


public class SideScrollerArray extends SideScroller
{
	private Location[][] loc = new Location[3][3];
	private SideScroller[][] obj = new SideScroller[3][3];
	
	public SideScrollerArray(int row, int col)
	{
        for(int r = 0; r < obj.length; r++)
        {
        	for(int c = col; c < obj[0].length; c++)
        	{
        		loc[r][c] = new Location(row + r, col + r);
        		obj[r][c] = new SideScroller();
        	}
        }
	}
	
	public SideScroller[][] getObj()
	{
		return obj;
	}
	
	public Location[][] getLoc()
	{
		return loc;
	}
}