package pinckneyjames.AcquiaAdventure;

public class ConferenceRoom implements Rooms{
	
	String[] objectList, interactableList, enemiesList, exitList;
	
	
	public ConferenceRoom()
	{
		objectList = null;
		interactableList = null;
		enemiesList = null;
		exitList = null;
	}
	
	public ConferenceRoom(String[] objects)
	{
		objectList = objects;
	}
	
	public ConferenceRoom(String[] objects, String[] Interactables)
	{
		objectList = objects;
		interactableList = Interactables;
	}
	
	public ConferenceRoom(String[] objects, String[] Interactables, String[] Enemies)
	{
		objectList = objects;
		interactableList = Interactables;
		enemiesList = Enemies;
	}
	
	public ConferenceRoom(String[] objects, String[] Interactables, String[] Enemies, String[] Exits)
	{
		objectList = objects;
		interactableList = Interactables;
		enemiesList = Enemies;
		exitList = Exits;
	}

	@Override
	public boolean getItem(String[] obj, String name) {
		boolean output = false;
		for(String object : obj)
		{
			if(object.equalsIgnoreCase(name))
			{
				output = true;
			}
		}
		return output;
	}

	@Override
	public boolean getInteractable(String[] obj, String name) {
		boolean output = false;
		for(String object : obj)
		{
			if(object.equalsIgnoreCase(name))
			{
				output = true;
			}
		}
		return output;
	}

	@Override
	public boolean getEnemy(String[] obj, String name) {
		boolean output = false;
		for(String object : obj)
		{
			if(object.equalsIgnoreCase(name))
			{
				output = true;
			}
		}
		return output;
	}

	@Override
	public boolean getExit(String[] obj, String name) {
		boolean output = false;
		for(String object : obj)
		{
			if(object.equalsIgnoreCase(name))
			{
				output = true;
			}
		}
		return output;
	}

}
