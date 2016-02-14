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
	
	public void setItemSlot(String name)
	{
		String[] s = getInventory();
		for(int i = 0; i < s.length; i++)
		{
			if(s[i] == null)
			{
				s[i] = name;
				break;
			}
		}
	}
}
