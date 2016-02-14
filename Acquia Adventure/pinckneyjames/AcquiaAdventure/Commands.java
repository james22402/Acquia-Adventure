package pinckneyjames.AcquiaAdventure;

public class Commands {
	
	String command;
	
	public Commands()
	{
		command = "";
	}
	
	public boolean isCommand(String cmd)
	{
		if(cmd.equalsIgnoreCase("look"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("take"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("open"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("approach"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("enter"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("leave"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("eat"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("attack"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("talk"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("equip"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("drop"))
		{
			setCommand(cmd);
			return true;
		}
		else if(cmd.equalsIgnoreCase("inventory"))
		{
			setCommand(cmd);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setCommand(String cmmd)
	{
		command = cmmd;
	}
	
	public String getCommand()
	{
		return command;
	}

}
