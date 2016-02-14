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
	static JLabel picture, picture1;
	BufferedImage wPic;
	Player p;
	SceneNumber scene;
	String s;
	Commands cmd;
	JScrollPane scroll;
	public int apacheHallCount = 0;

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
		textPanel.setBackground(Color.decode("#e71316")); // Red

		output = new JTextArea("Welcome to Acquila!");
		// textPanel.setLayout(new BorderLayout());
		scroll = new JScrollPane(output);
		scroll.setPreferredSize(new Dimension(600, 100));
		output.setText("You have nearly finished your code on Eclipse when a wild Apache team member appears and throws an ACME anvil through your Lenovo laptop, before disappearing into the darkness of the hallway. Slightly disappointed you remember that James recently backed up your code to a Sandisk flash drive.  Encouraged, you plug the drive into an Asus chromebook, only to discover that the files are corrupted. Not giving up hope, Kat suggests bringing the only remaining existence of the day's hard work to a mentor to be recovered.  You open the door to leave, and hesitate, wondering which direction you should leave, left or right. You sense movement to your left(North), and see a menacing Austin Powers cardboard cutout to your right(South). Which way do you choose?");
		//textPanel.add(output, BorderLayout.CENTER);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textPanel.add(scroll, BorderLayout.CENTER);

		input = new JTextField("Enter Command");
		input.setPreferredSize(new Dimension(600, 20));
		//input.
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
		foodLevels.setBackground(Color.decode("#1fc3ff")); // Blue

		map = new JPanel();
		map.setVisible(true);
		map.setBackground(Color.decode("#87ff1f")); // Green

		

		p = new Player();
		p.setLocation("Tesla");

		scene = SceneNumber.ONE;

		cmd = new Commands();
		
		try
		{
			wPic = ImageIO.read(this.getClass().getResource("_0 Intro.jpg"));
			picture = new JLabel(new ImageIcon(wPic));
			picture.setPreferredSize(new Dimension(800,600));
			imagePanel.add(picture);
		}
		catch (IOException e)
		{

		}
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
				if (result && scene == SceneNumber.ONE && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("north"))
				{
					sceneOne();
				}
				else if (result && scene == SceneNumber.ONE && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("south"))
				{
					output.setText("You smell a nice cheese pizza back the way you came. Of course you could always continue going straight(South).");
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
				else if(result && scene == SceneNumber.CAM_TWO)
				{
					output.setText("An angry SQuirreL blocks your way. Too bad, looks like you'll have to go back the way you came (North).");
					camHall3();
				}
				else if(result && scene == SceneNumber.CAM_THREE)
				{
					camHall3();
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
		try
		{
			wPic = ImageIO.read(this.getClass().getResource("_01Hallway One.jpg"));
			
		}
		catch (IOException e1)
		{
			System.out.print("Catch");
		}
		picture.setIcon(new ImageIcon(wPic));
		picture.setPreferredSize(new Dimension(800,600));
		
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("Tesla"))
		{
			if (s.indexOf(" ") != -1)
			{
				if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("north"))
				{
					output.setText("You are in the Apache Hall. You can either go towards the Bitcoin room(North), or back to the Tesla Room(South). There is also a Mentor standing near a desk, that looks like he has nothing to do.");
					scene = SceneNumber.TWO;
					p.setLocation("apacheHall");
					//apacheHallCount++;
				}
				else if ((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("south"))
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
				
				if((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("south"))
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
				else if(cmd.getCommand().equalsIgnoreCase("talk"))
				{
					if(s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("mentor"))
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
						picture.setPreferredSize(new Dimension(800,600));
					}
					
				}
				else if((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("north"))
				{
					output.setText("Incredibly vexed, you run after the thief. But suddenly, a battalion of intimidating Apache Nerf warriors appears, covering the thief’s escape. Do you charge blindly into the midst of the small army (North), or dive into the nearby room (Bitcoin) for cover?");
					triggerApacheEvent();
					apacheHallCount++;
				}
				else
				{
					output.setText(s.substring(s.indexOf(" "), s.length()) + " is not a valid action!");
				}
			}
			else if(cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("apacheHall") && apacheHallCount >= 2)
			{
				output.setText("You are in the Apache Hall. You can either go towards the Bitcoin room(North), or back to the Tesla Room(South). There is also a Mentor standing near a desk, that looks like he has nothing to do.");
			}
		}
	}
	
	public void triggerApacheEvent()
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
		picture.setPreferredSize(new Dimension(800,600));
		//Apache Event Will be all text
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
		picture.setPreferredSize(new Dimension(800,600));
		//output.setText(p.getLocation());
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("South Hall"))
		{
			if((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("south"))
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
				picture.setPreferredSize(new Dimension(800,600));
				p.setLocation("South Hall2");
				scene = SceneNumber.CAM_TWO;
				output.setText("You think you catch sight of a hungry Jaguar in front of you. Best advice, turn tale and run. Or, you could be stupid and go straight(South)." + p.getLocation());
			}
			else if((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("north"))
			{
				scene = SceneNumber.ONE;
				p.setLocation("apacheHall");
			}
		}
		else if(p.getLocation().equals("Tesla"))
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
		picture.setPreferredSize(new Dimension(800,600));
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("South Hall"))
		{
			if((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("south"))
			{
				p.setLocation("South Hall2");
				scene = SceneNumber.CAM_THREE;
				
				camHall3();
			}
			else if((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("north"))
			{
				scene = SceneNumber.ONE;
				p.setLocation("apacheHall");
			}
		}
		else if(p.getLocation().equals("South Hall2"))
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
		picture.setPreferredSize(new Dimension(800,600));
		if (cmd.isCommand(s.substring(0, s.indexOf(" "))) && p.getLocation().equals("South Hall3"))
		{
			if((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("south"))
			{
				p.setLocation("South Hall2");
				scene = SceneNumber.CAM_THREE;
				//camHall2();
			}
			else if((cmd.getCommand().equalsIgnoreCase("enter")) && s.substring(s.indexOf(" ")+1, s.length()).equalsIgnoreCase("north"))
			{
				scene = SceneNumber.ONE;
				output.setText("You are in the Apache Hall. You can either go towards the Bitcoin room(North), or back to the Tesla Room(South). There is also a Mentor standing near a desk, that looks like he has nothing to do." + p.getLocation());
				p.setLocation("Tesla");
			}
		}
		else if(p.getLocation().equals("South Hall2"))
		{
			p.setLocation("South Hall3");
		}
	}
}