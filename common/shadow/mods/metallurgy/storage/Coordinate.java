package shadow.mods.metallurgy.storage;

public class Coordinate 
{
	int x;
	int y;
	int z;
	
	Coordinate(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Coordinate() 
	{
		x = 0;
		y = 0;
		z = 0;
	}

	public boolean equals(Object obj)
	{
		if(obj instanceof Coordinate)
		{
			Coordinate coords = (Coordinate)obj;
			return x == coords.x && y == coords.y && z == coords.z;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		return "" + x + " " + " " + y + " " + z;
	}

	public Coordinate copy() 
	{
		return new Coordinate(x, y, z);
	}
}
