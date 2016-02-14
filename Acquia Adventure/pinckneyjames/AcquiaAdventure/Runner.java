package pinckneyjames.AcquiaAdventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Runner extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JFrame frame;
	static JPanel imagePanel;
	static JPanel textPanel;
	static JPanel foodLevels;
	static JPanel map;
	static Layout layout;
	static JTextArea input;
	static JTextArea output;
	static JButton enter;
	boolean result;
	static JLabel picture;
	BufferedImage wPic;
	Player p;
	SceneNumber scene;
	String s;
	Commands cmd;
	JScrollPane scroll;

	enum SceneNumber
	{
		INTRO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELEVE, THIRTEEN
	};

	public Runner()
	{
		layout = new Layout();

		frame = new JFrame();
		frame = new JFrame("Acquia Adventure v0.01");
		frame.setSize(1000, 800);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setLayout(new Layout());

		imagePanel = new JPanel();
		imagePanel.setVisible(true);
		imagePanel.setOpaque(false);
		// imagePanel.setBackground(Color.decode("#000000")); //Black

		textPanel = new JPanel();
		textPanel.setVisible(true);
		textPanel.setBackground(Color.decode("#e71316")); // Red

		output = new JTextArea("Welcome to Acquila!");
		// textPanel.setLayout(new BorderLayout());
		scroll = new JScrollPane(output);
		scroll.setPreferredSize(new Dimension(600, 50));
		output.setText("You have nearly finished your code on Eclipse when a wild Apache team member appears and throws an ACME anvil through your Lenovo laptop, before disappearing into the darkness of the hallway. Slightly disappointed you remember that James recently backed up your code to a Sandisk flash drive.  Encouraged, you plug the drive into an Asus chromebook, only to discover that the files are corrupted. Not giving up hope, Kat suggests bringing the only remaining existence of the day's hard work to a mentor to be recovered.  You open the door to leave, and hesitate, wondering which direction you should leave, left or right. You sense movement to your left, and see a menacing Austin Powers cardboard cutout to your right. Which way do you choose?");
		//textPanel.add(output, BorderLayout.CENTER);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textPanel.add(scroll, BorderLayout.CENTER);

		input = new JTextArea("Enter Command");
		input.setPreferredSize(new Dimension(600, 50));
		// textPanel.setLayout(new BorderLayout());
		textPanel.add(input, BorderLayout.PAGE_START);
		output.setEditable(false);

		enter = new JButton("Submit");
		enter.setActionCommand("Submit");
		enter.addActionListener(this);
		enter.setFocusable(false);
		enter.setPreferredSize(new Dimension(75, 100));
		textPanel.add(enter, BorderLayout.LINE_END);

		foodLevels = new JPanel();
		foodLevels.setVisible(true);
		foodLevels.setBackground(Color.decode("#1fc3ff")); // Blue

		map = new JPanel();
		map.setVisible(true);
		map.setBackground(Color.decode("#87ff1f")); // Green

		try
		{
			wPic = ImageIO.read(this.getClass().getResource("Hauser.jpg"));
		}
		catch (IOException e)
		{

		}

		picture = new JLabel(new ImageIcon(wPic));
		imagePanel.add(picture);

		p = new Player();
		p.setLocation("Tesla");

		scene = SceneNumber.ONE;

		cmd = new Commands();
	}

	public static void main(String[] args)
	{
		new Runner();
		layout.addTheComponent(imagePanel, BorderLayout.PAGE_START, 0, 0, 800, 600);
		layout.addTheComponent(textPanel, BorderLayout.LINE_START, 0, 800, 700, 50);
		layout.addTheComponent(foodLevels, BorderLayout.LINE_END, 0, 0, 100, 300);
		layout.addTheComponent(map, BorderLayout.CENTER, 800, 450, 200, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Submit"))
		{
			s = input.getText();
			if (s.indexOf(" ") != -1)
			{
				result = cmd.isCommand(s.substring(0, s.indexOf(" ")));
				// output.setText("" + result);
				if (result && scene == SceneNumber.ONE)
				{
					sceneOne();
				}
				else if (result && scene == SceneNumber.TWO)
				{
					sceneTwo();
				}
			}
			else
			{
				result = cmd.isCommand(s);
				output.setText("" + result);
			}
		}

	}

	public void sceneOne()
	{
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("Tesla"))
		{
			if (s.indexOf(" ") != -1)
			{
				if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("north"))
				{
					output.setText("Text to talk to Mentor Can go North/South");
					scene = SceneNumber.TWO;
					p.setLocation("apacheHall");
				}
				else if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("south"))
				{
					output.setText("Going to opposite way/Cameron's dead body idea");
				}
				else
				{
					output.setText(s.substring(s.indexOf(" "), s.length()) + " is Not a Valid Location");
				}
			}
			else
			{
				result = cmd.isCommand(s);
				output.setText("" + result);
			}
		}
	}

	public void sceneTwo()
	{
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("apacheHall"))
		{
			if (s.indexOf(" ") != -1)
			{
				
				if((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("south"))
				{
					output.setText("Text to go back to Tesla Room N/S");
					scene = SceneNumber.ONE;
				}
				else if(cmd.getCommand().equalsIgnoreCase("talk"))
				{
					if(s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("mentor"))
					{
						output.setText("Finding a mentor willing to help, he takes the flash drive and, using his mad tech skills, fixes all the things. Before even getting a chance to break out into cheers, a second wild Apache team member appears, grabs the drive, and flees.");
						
						triggerApacheEvent();
					}
				}
				else
				{
					output.setText(s.substring(s.indexOf(" "), s.length()) + " is not a valid action!");
				}
			}
			else
			{
				result = cmd.isCommand(s);
				output.setText("" + result);
			}
		}
	}
	
	public void triggerApacheEvent()
	{
		output.setText("HAHAHAHA! Take that!");
		//Apache Event Will be all text
	}
}