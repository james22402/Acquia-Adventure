package pinckneyjames.AcquiaAdventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
	static JTextField input;
	static JTextArea output;
	static JButton enter;
	boolean result;
	static JLabel picture, mapPicture;
	BufferedImage wPic, mapPic;
	Player p;
	SceneNumber scene;
	String s;
	Commands cmd;
	JScrollPane scroll;
	public int numTimes = 0;
	boolean hasSearched = false;
	boolean hasTakenTwig = false;

	enum SceneNumber
	{
		INTRO, ONE, CAM_ONE, CAM_TWO, CAM_THREE, CAM_FOUR, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELEVE, THIRTEEN
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
		textPanel.setBackground(Color.decode("#0f0d63")); // Red

		output = new JTextArea("Welcome to Acquila!");
		// textPanel.setLayout(new BorderLayout());
		scroll = new JScrollPane(output);
		scroll.setPreferredSize(new Dimension(600, 100));
		output.setText(
				"You have nearly finished your code on Eclipse when a wild Apache team member appears and throws an ACME anvil through your Lenovo laptop, before disappearing into the darkness of the hallway. Slightly disappointed you remember that James recently backed up your code to a Sandisk flash drive.  Encouraged, you plug the drive into an Asus chromebook, only to discover that the files are corrupted. Not giving up hope, Kat suggests bringing the only remaining existence of the day's hard work to a mentor to be recovered.  You open the door to leave, and hesitate, wondering which direction you should leave, left or right. You sense movement to your left(North), and see a menacing Austin Powers cardboard cutout to your right(South). Which way do you choose?");
		// textPanel.add(output, BorderLayout.CENTER);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textPanel.add(scroll, BorderLayout.CENTER);

		input = new JTextField("Enter Command");
		input.setPreferredSize(new Dimension(600, 20));
		// input.
		// textPanel.setLayout(new BorderLayout());
		textPanel.add(input, BorderLayout.PAGE_START);
		output.setEditable(false);

		enter = new JButton("Submit");
		enter.setActionCommand("Submit");
		enter.addActionListener(this);
		enter.setFocusable(false);
		enter.setPreferredSize(new Dimension(75, 50));
		textPanel.add(enter, BorderLayout.LINE_END);

		foodLevels = new JPanel();
		foodLevels.setVisible(true);
		foodLevels.setBackground(Color.decode("#141098")); // Blue

		map = new JPanel();
		map.setVisible(true);
		map.setBackground(Color.decode("#1C12FF")); // Green

		p = new Player();
		p.setLocation("Tesla");

		scene = SceneNumber.ONE;

		cmd = new Commands();

		try
		{
			wPic = ImageIO.read(this.getClass().getResource("_0 Intro.jpg"));
			picture = new JLabel(new ImageIcon(wPic));
			picture.setPreferredSize(new Dimension(800, 600));
			imagePanel.add(picture);
		}
		catch (IOException e)
		{

		}

		try
		{
			mapPic = ImageIO.read(this.getClass().getResource("Codeday map Good.png"));

		}
		catch (IOException e1)
		{
			System.out.print("Catch");
		}
		mapPicture = new JLabel(new ImageIcon(mapPic));
		mapPicture.setPreferredSize(new Dimension(200, 200));
		map.setLayout(new BorderLayout());
		map.add(mapPicture, BorderLayout.CENTER);
		// Codeday map Good.png
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
				if (result && scene == SceneNumber.ONE && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("north"))
				{
					sceneOne();
				}
				else if (result && scene == SceneNumber.ONE && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("south"))
				{
					output.setText(getRandDivert2());
					camHall();
				}
				else if (result && scene == SceneNumber.TWO)
				{
					sceneTwo();
				}
				else if (result && scene == SceneNumber.CAM_ONE)
				{
					camHall2();
				}
				else if (result && scene == SceneNumber.CAM_TWO)
				{
					output.setText(getRandDivert3());
					camHall3();
				}
				else if (result && scene == SceneNumber.CAM_THREE)
				{
					camHall3();
				}
				else if (result && scene == SceneNumber.FOUR)
				{
					p.setLocation("ApacheHall2");
					triggerApacheEvent(false);
				}
				else if (result && scene == SceneNumber.THREE)
				{
					p.setLocation("ApacheHall2");
					triggerApacheEvent(true);
				}
				else if (result && scene == SceneNumber.FIVE)
				{
					p.setLocation("Bitcoin");
					sceneFive();
				}
				else if (result && scene == SceneNumber.SIX)
				{
					output.setText("You duck back out to the firing squard. You manage to fend them off with your weapon. You can now proceed(north)");
					p.setLocation("ApacheHallway3");
					try
					{
						wPic = ImageIO.read(this.getClass().getResource("_01Hallway One.jpg"));

					}
					catch (IOException e1)
					{
						System.out.print("Catch");
					}
					picture.setIcon(new ImageIcon(wPic));
					picture.setPreferredSize(new Dimension(800, 600));
					sceneSix();
				}
			}
		}

	}

	public void sceneOne()
	{
		try
		{
			wPic = ImageIO.read(this.getClass().getResource("_01Hallway One.jpg"));

		}
		catch (IOException e1)
		{
			System.out.print("Catch");
		}
		picture.setIcon(new ImageIcon(wPic));
		picture.setPreferredSize(new Dimension(800, 600));

		if (cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("Tesla"))
		{
			if (s.indexOf(" ") != -1)
			{
				if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("north"))
				{
					output.setText("You are in the Apache Hall. You can either go towards the Bitcoin room(North), or back to the Tesla Room(South). There is also a Mentor standing near a desk, that looks like he has nothing to do.");
					scene = SceneNumber.TWO;
					p.setLocation("apacheHall");
					// apacheHallCount++;
				}
				else if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("south"))
				{
					scene = SceneNumber.CAM_ONE;
					p.setLocation("South Hall");
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

				if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("south"))
				{
					output.setText("You are in the Tesla Meeting Room. You can either go towards the Apache Room(North) or towards the abandoned part of the office.");
					scene = SceneNumber.ONE;
					try
					{
						wPic = ImageIO.read(this.getClass().getResource("_01Hallway One.jpg"));

					}
					catch (IOException e1)
					{
						System.out.print("Catch");
					}
				}
				else if (cmd.getCommand().equalsIgnoreCase("talk"))
				{
					if (s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("mentor"))
					{
						output.setText("Finding a mentor willing to help, he takes the flash drive and, using his mad tech skills, fixes all the things. Before even getting a chance to break out into cheers, a second wild Apache team member appears, grabs the drive, and flees. Chase them! (North)");
						try
						{
							wPic = ImageIO.read(this.getClass().getResource("MentorPhoto.jpg"));

						}
						catch (IOException e1)
						{
							System.out.print("Catch");
						}
						picture.setIcon(new ImageIcon(wPic));
						picture.setPreferredSize(new Dimension(800, 600));
					}

				}
				else if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("north"))
				{
					output.setText("Incredibly vexed, you run after the thief. But suddenly, a battalion of intimidating Apache Nerf warriors appears, covering the thief’s escape. Do you charge blindly into the midst of the small army (North), or dive into the nearby room (Bitcoin) for cover?");
					p.setLocation("ApacheHall2");
					scene = SceneNumber.THREE;
					triggerApacheEvent(true);
				}
				else
				{
					output.setText(s.substring(s.indexOf(" "), s.length()) + " is not a valid action!");
				}
			}
		}
	}

	public void triggerApacheEvent(boolean b)
	{
		try
		{
			wPic = ImageIO.read(this.getClass().getResource("_02Nerf Fight.jpg"));

		}
		catch (IOException e1)
		{
			System.out.print("Catch");
		}
		picture.setIcon(new ImageIcon(wPic));
		picture.setPreferredSize(new Dimension(800, 600));

		if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("north") && p.getLocation().equals("ApacheHall2") && b == false)
		{
			output.setText("You are driven back by a barrage of nerf bullets. Maybe try a different route? (bitcoin)");
		}
		else if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("bitcoin") && b == false)
		{
			output.setText("Frantic for anything to defend yourself with, you scan the small room. You notice a chair, a table, and a recycling bin, and hope that one of them conceals an acceptable weapon.");
			p.setLocation("Bitcoin");
			scene = SceneNumber.FIVE;
			try
			{
				wPic = ImageIO.read(this.getClass().getResource("_03 Bitcoin.jpg"));

			}
			catch (IOException e1)
			{
				System.out.print("Catch");
			}
			picture.setIcon(new ImageIcon(wPic));
			picture.setPreferredSize(new Dimension(800, 600));
		}
		else
		{
			if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("north"))
			{
				scene = SceneNumber.FOUR;
			}
		}
		// Apache Event Will be all text
	}

	public void camHall()
	{
		try
		{
			wPic = ImageIO.read(this.getClass().getResource("2Hallway 1.jpg"));

		}
		catch (IOException e1)
		{
			System.out.print("Catch");
		}
		picture.setIcon(new ImageIcon(wPic));
		picture.setPreferredSize(new Dimension(800, 600));
		// output.setText(p.getLocation());
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("South Hall"))
		{
			if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("south"))
			{
				try
				{
					wPic = ImageIO.read(this.getClass().getResource("2Hallway 2.jpg"));

				}
				catch (IOException e1)
				{
					System.out.print("Catch");
				}
				picture.setIcon(new ImageIcon(wPic));
				picture.setPreferredSize(new Dimension(800, 600));
				p.setLocation("South Hall2");
				scene = SceneNumber.CAM_TWO;
				output.setText(getRandDivert1());
			}
			else if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("north"))
			{
				scene = SceneNumber.ONE;
				p.setLocation("apacheHall");
			}
		}
		else if (p.getLocation().equals("Tesla"))
		{
			p.setLocation("South Hall");
		}
	}

	public void camHall2()
	{
		try
		{
			wPic = ImageIO.read(this.getClass().getResource("2Hallway 2.jpg"));

		}
		catch (IOException e1)
		{
			System.out.print("Catch");
		}
		picture.setIcon(new ImageIcon(wPic));
		picture.setPreferredSize(new Dimension(800, 600));
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("South Hall"))
		{
			if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("south"))
			{
				p.setLocation("South Hall2");
				scene = SceneNumber.CAM_THREE;

				camHall3();
			}
			else if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("north"))
			{
				scene = SceneNumber.ONE;
				p.setLocation("apacheHall");
			}
		}
		else if (p.getLocation().equals("South Hall2"))
		{
			p.setLocation("South Hall3");
		}
	}

	public void camHall3()
	{
		try
		{
			wPic = ImageIO.read(this.getClass().getResource("2Hallway 3.jpg"));

		}
		catch (IOException e1)
		{
			System.out.print("Catch");
		}
		picture.setIcon(new ImageIcon(wPic));
		picture.setPreferredSize(new Dimension(800, 600));
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("South Hall3"))
		{
			if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("south"))
			{
				p.setLocation("South Hall2");
				scene = SceneNumber.CAM_THREE;
				// camHall2();
			}
			else if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("north"))
			{
				try
				{
					wPic = ImageIO.read(this.getClass().getResource("_01Hallway One.jpg"));

				}
				catch (IOException e1)
				{
					System.out.print("Catch");
				}
				picture.setIcon(new ImageIcon(wPic));
				picture.setPreferredSize(new Dimension(800, 600));
				scene = SceneNumber.ONE;
				output.setText("You are in the Apache Hall. You can either go towards the Bitcoin room(North), or back to the Tesla Room(South). There is also a Mentor standing near a desk, that looks like he has nothing to do.");
				p.setLocation("Tesla");
			}
		}
		else if (p.getLocation().equals("South Hall2"))
		{
			p.setLocation("South Hall3");
		}
	}

	public void sceneFive()
	{
		picture.setIcon(new ImageIcon(wPic));
		picture.setPreferredSize(new Dimension(800, 600));
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))))
		{
			if ((cmd.getCommand().equalsIgnoreCase("look")))
			{
				if (s.substring(s.indexOf(" ") + 1, s.length()).equals("recycling bin") && hasSearched == false)
				{
					String weap = p.getRandWeapon();
					p.addItem(weap);
					hasSearched = true;
					output.setText("You found a " + weap);
				}
				else if (s.substring(s.indexOf(" ") + 1, s.length()).equals("table") && hasSearched == false)
				{
					String weap = "Great Rifle";
					p.addItem(weap);
					hasSearched = true;
					output.setText("You found a " + weap);
				}
				else if (s.substring(s.indexOf(" ") + 1, s.length()).equals("chair") && hasSearched == false)
				{
					String weap = "Good Pistol";
					p.addItem(weap);
					hasSearched = true;
					output.setText("You found a " + weap);
				}
				else if (hasSearched)
				{
					output.setText("You already searched this room!");
				}
			}
			else if (s.substring(s.indexOf(" ") + 1, s.length()).equals("bitcoin"))
			{
				p.setLocation("ApacheHall3");
				scene = SceneNumber.SIX;
				output.setText("You duck back out to the battle. You manage to fend them off with your weapon. They still have the flash drive though! You can now proceed(north)");
				try
				{
					wPic = ImageIO.read(this.getClass().getResource("_02Nerf Fight.jpg"));

				}
				catch (IOException e1)
				{
					System.out.print("Catch");
				}
				picture.setIcon(new ImageIcon(wPic));
				picture.setPreferredSize(new Dimension(800, 600));
			}
		}
	}

	public void sceneSix()
	{
		output.setText("You are in the Apache Hall. You can either go towards the Bitcoin room(North), or back to the Tesla Room(South). There is also a Mentor standing near a desk, that looks like he has nothing to do.");
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))))
		{
			if (s.indexOf(" ") != -1)
			{
				if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("south"))
				{
					output.setText("You are in the Tesla Meeting Room. You can either go towards the Apache Room(North) or towards the abandoned part of the office.");
					scene = SceneNumber.ONE;
					try
					{
						wPic = ImageIO.read(this.getClass().getResource("_01Hallway One.jpg"));

					}
					catch (IOException e1)
					{
						System.out.print("Catch");
					}
					picture.setIcon(new ImageIcon(wPic));
					picture.setPreferredSize(new Dimension(800, 600));
				}
				else if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("north"))
				{
					output.setText("You are in the Twig Hall. You may go south, north or approach Twig.");
					try
					{
						wPic = ImageIO.read(this.getClass().getResource("TwigHall.jpg"));

					}
					catch (IOException e1)
					{
						System.out.print("Catch");
					}
					picture.setIcon(new ImageIcon(wPic));
					picture.setPreferredSize(new Dimension(800, 600));
					if (cmd.isCommand(s.substring(0, s.indexOf(" "))))
					{
						if ((cmd.getCommand().equalsIgnoreCase("approach")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("twig"))
							scene = SceneNumber.SEVEN;
							sceneSeven();
					}
				}
				else
				{
					output.setText(s.substring(s.indexOf(" "), s.length()) + " is not a valid action!");
				}
			}
		}
	}

	public void sceneSeven()
	{
		output.setText("You look around confused as to where to go next. If only you had an internet-connected device that could access the online map of the Acquia Center. The room next to you has an iPad mounted to the external wall, but perhaps the room itself contains something running a superior operating system.");
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))))
		{
			if (s.indexOf(" ") != -1)
			{
				if ((cmd.getCommand().equalsIgnoreCase("take")) && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("ipad"))
				{
					hasTakenTwig = true;
					p.addItem("ipad");
					output.setText("An ipad is added to your inventory. You proceed to north (to pidgin hall)");
					scene = SceneNumber.EIGHT;
					try
					{
						wPic = ImageIO.read(this.getClass().getResource("_06Hallway2.jpg"));

					}
					catch (IOException e1)
					{
						System.out.print("Catch");
					}
					picture.setIcon(new ImageIcon(wPic));
					picture.setPreferredSize(new Dimension(800, 600));
				}
				else if (cmd.getCommand().equalsIgnoreCase("enter") && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("twig"))
				{
					output.setText("Look around for a device. Perhaps the drawer or bag");
					if ((cmd.getCommand().equalsIgnoreCase("look")))
					{
						if (s.substring(s.indexOf(" ") + 1, s.length()).equals("drawer"))
						{
							output.setText("You have found a Project Tango Tablet with a great map. Now you can leave the room.");
							p.addItem("Tango Tablet");
						}
						else if (s.substring(s.indexOf(" ") + 1, s.length()).equals("bag"))
						{
							output.setText("You have found a Nokia Brick with a 240p map. Now you can leave the room in despair.");
							p.addItem("Nokia Brick");
						}
					}
					if ((cmd.getCommand().equalsIgnoreCase("leave") && s.substring(s.indexOf(" ") + 1, s.length()).equalsIgnoreCase("twig")))
					{
						scene = SceneNumber.EIGHT;
						try
						{
							wPic = ImageIO.read(this.getClass().getResource("_06Hallway2.jpg"));

						}
						catch (IOException e1)
						{
							System.out.print("Catch");
						}
						picture.setIcon(new ImageIcon(wPic));
						picture.setPreferredSize(new Dimension(800, 600));
					}
				}
			}
		}
	}

	public String getRandDivert1()
	{
		int randDivertDigit1 = (int) (Math.random() * 10);
		if (randDivertDigit1 == 1 || randDivertDigit1 == 2)
		{
			return "The rooms you are passing seem familiar.";
		}
		else if (randDivertDigit1 == 3 || randDivertDigit1 == 4)
		{
			return "It seems to be getting cold.";
		}
		else if (randDivertDigit1 == 5 || randDivertDigit1 == 6)
		{
			return "There is a nerf gun suspiciously poking over a couch ahead.";
		}
		else if (randDivertDigit1 == 7 || randDivertDigit1 == 8)
		{
			return "You smell a nice cheese pizza.";
		}
		else
		{
			return "Your WiFi reception is getting worse/";
		}
	}

	public String getRandDivert2()
	{
		int randDivertDigit2 = (int) (Math.random() * 10);
		if (randDivertDigit2 == 1 || randDivertDigit2 == 2)
		{
			return "You spot a hungry jaguar.";
		}
		else if (randDivertDigit2 == 3 || randDivertDigit2 == 4)
		{
			return "There is a nice laptop the other way";
		}
		else if (randDivertDigit2 == 5 || randDivertDigit2 == 6)
		{
			return "You spot a comfy beanbag behind you.";
		}
		else if (randDivertDigit2 == 7 || randDivertDigit2 == 8)
		{
			return "You can hear yelling in the distance.";
		}
		else
		{
			return "A nerf gun just clicked somewhere in front of you.";
		}
	}

	public String getRandDivert3()
	{
		int randDivertDigit3 = (int) (Math.random() * 10);
		if (randDivertDigit3 == 1 || randDivertDigit3 == 2)
		{
			return "You see what you think is a dead body. It smells like rotten flesh. You don't want to end up like them, do you?";
		}
		else if (randDivertDigit3 == 3 || randDivertDigit3 == 4)
		{
			return "A shark has escaped it's ACQUIA-arium and it's heading your way. You should head north.";
		}
		else if (randDivertDigit3 == 5 || randDivertDigit3 == 6)
		{
			return "An angry SQirreL blocks your way. You should head north.";
		}
		else if (randDivertDigit3 == 7 || randDivertDigit3 == 8)
		{
			return "The portal in the bathroom next to you has begun screeching. You should head north.";
		}
		else
		{
			return "There is a bloody hand print on the wall next to you. You should head north.";
		}
	}
}