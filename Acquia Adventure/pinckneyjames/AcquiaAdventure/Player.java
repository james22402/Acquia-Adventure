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
	
	public void addItem(String name)
	{
		inv.setItemSlot(name);
	}
	
	public String getRandWeapon()
	{
		int randWeaponDigit = (int)(Math.random()*10);
		if( randWeaponDigit == 1 || randWeaponDigit == 2)
		{
			return "charging cable";
		}
		if( randWeaponDigit == 3 || randWeaponDigit == 4)
		{
			return "dry erase markers";
		}
		if( randWeaponDigit == 5 || randWeaponDigit == 6)
		{
			return "box of paper clips";
		}
		if( randWeaponDigit == 7 || randWeaponDigit == 8)
		{
			return "white board eraser";
		}
		if( randWeaponDigit == 9 || randWeaponDigit == 10)
		{
			return "slightly sharpened #2 pencil";
		}
		else {
			return "";
		}
	}
	
	public String getRandFood()
	{
		int randFoodDigit = (int)(Math.random()*10);
		if( randFoodDigit == 1 || randFoodDigit == 2)
		{
			return "a single gummy bear";
		}
		if( randFoodDigit == 3 || randFoodDigit == 4)
		{
			return "mostly eaten granola bar";
		}
		if( randFoodDigit == 5 || randFoodDigit == 6)
		{
			return "moldy pizza crust";
		}
		if( randFoodDigit == 7 || randFoodDigit == 8)
		{
			return "assorted bread crumbs";
		}
		if( randFoodDigit == 9 || randFoodDigit == 10)
		{
			return "slightly sharpened #2 pencil";
		}
		else {
			return "";
		}
	}
	
}
