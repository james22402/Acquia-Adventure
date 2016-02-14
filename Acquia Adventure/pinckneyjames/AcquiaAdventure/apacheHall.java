package pinckneyjames.AcquiaAdventure;

public class apacheHall extends ConferenceRoom {
	
	/**
	 * Items: N/A
	 * Interactables: Mentor(Talk to) - Automatically Triggers Apache Event
	 * Enemies: N/A
	 * Exits: South
	 */

	public apacheHall() {
		// TODO Auto-generated constructor stub
	}

	public apacheHall(String[] objects, String[] Interactables, String[] Enemies, String[] Exits) {
		super(objects, Interactables, Enemies, Exits);
	}
	
	public String[] getItems()
	{
		return super.objectList;
	}
	
	public String[] getInteractables()
	{
		return super.interactableList;
	}
	
	public String[] getEnemies()
	{
		return super.enemiesList;
	}
	
	public String[] getExits()
	{
		return super.exitList;
	}

}
