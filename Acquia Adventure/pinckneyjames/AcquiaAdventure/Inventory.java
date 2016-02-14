package pinckneyjames.AcquiaAdventure;

public class Inventory 
{
	private String[] inventory = new String[5];
	
	public String[] getInventory()
	{
		return inventory;
	}
	
	public String getItem(int inventorySpot)
	{
		return inventory[inventorySpot];
	}
}
