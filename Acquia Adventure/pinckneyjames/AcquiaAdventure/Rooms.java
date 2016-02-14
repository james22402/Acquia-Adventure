package pinckneyjames.AcquiaAdventure;

public interface Rooms {
	
	public boolean getItem(String[] obj, String name);
	
	public boolean getInteractable(String[] obj, String name);
	
	public boolean getEnemy(String[] obj, String name);
	
	public boolean getExit(String[] obj, String name);
	
}
