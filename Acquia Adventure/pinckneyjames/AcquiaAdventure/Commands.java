package pinckneyjames.AcquiaAdventure;

public class Commands {
	
	public Commands()
	{
		
	}
	
	public boolean isCommand(String cmd)
	{
		if(cmd.equalsIgnoreCase("look") || cmd.equals("look at"))
		{
			return true;
		}
		else if(cmd.equalsIgnoreCase("take") || cmd.equalsIgnoreCase("pick up"))
		{
			return true;
		}
		else if(cmd.equalsIgnoreCase("open"))
		{
			return true;
		}
		else if(cmd.equalsIgnoreCase("enter") || cmd.equalsIgnoreCase("go to"))
		{
			return true;
		}
		else if(cmd.equalsIgnoreCase("leave"))
		{
			return true;
		}
		else if(cmd.equalsIgnoreCase("eat"))
		{
			return true;
		}
		else if(cmd.equalsIgnoreCase("attack"))
		{
			return true;
		}
		else if(cmd.equalsIgnoreCase("talk to") || cmd.equalsIgnoreCase("talk"))
		{
			return true;
		}
		else {
			return false;
		}
	}

}
