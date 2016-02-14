package pinckneyjames.AcquiaAdventure;

public class Tesla extends ConferenceRoom {

	
	/**
	 * Items: N/A
	 * Interactables: N/A
	 * Enemies: N/A
	 * Exits: North + South
	 */
	
	
	
	public Tesla() {
		// TODO Auto-generated constructor stub
	}

	public Tesla(String[] objects, String[] Interactables, String[] Enemies, String[] Exits) {
		super(objects, Interactables, Enemies, Exits);
	}
	
	public static String[] getItems()
	{
		String[] s = null;
		return s;
	}
	
	public static String[] getInteractables()
	{
		String[] s = null;
		return s;
	}
	
	public static String[] getEnemies()
	{
		String[] s = null;
		return s;
	}
	
	public static String[] getExits()
	{
		String[] s = {"north", "south"};
		return s;
	}

}
