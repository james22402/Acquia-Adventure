package pinckneyjames.AcquiaAdventure;

public class Player 
{
	private double hunger, fatigue;
	private String location;
	Inventory inv;
	
	public Player()
	{
		inv = new Inventory();
	}
	
	public String[] getInventory()
	{
		return inv.getInventory();
	}
	
	public double getHunger()
	{
		return hunger;
	}
	
	public double getFatigue()
	{
		return fatigue;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setLocation(String lcation)
	{
		location = lcation;
	}
	
	public void setHunger(double hnger)
	{
		hunger = hnger;
	}
	
	public void setFatigue(double ftigue)
	{
		fatigue = ftigue;
	}
	
}
