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
import javax.swing.JTextArea;

public class Runner extends JFrame implements ActionListener{

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

	public Runner() {
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
		output.setPreferredSize(new Dimension(600, 50));
		//textPanel.setLayout(new BorderLayout());
		textPanel.add(output, BorderLayout.CENTER);
		
		input = new JTextArea("Enter Command");
		input.setPreferredSize(new Dimension(600, 50));
		//textPanel.setLayout(new BorderLayout());
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
		
		try {
			wPic = ImageIO.read(this.getClass().getResource("Hauser.jpg"));
		} catch (IOException e) {
			
		}
		
		picture = new JLabel(new ImageIcon(wPic));
		imagePanel.add(picture);
	}

	public static void main(String[] args) {
		new Runner();
		layout.addTheComponent(imagePanel, BorderLayout.PAGE_START, 0, 0, 800, 600);
		layout.addTheComponent(textPanel, BorderLayout.LINE_START, 0, 800, 700, 50);
		layout.addTheComponent(foodLevels, BorderLayout.LINE_END, 0, 0, 100, 300);
		layout.addTheComponent(map, BorderLayout.CENTER, 800, 450, 200, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Submit"))
		{
			String s = input.getText();
			Commands cmd = new Commands();
			if(s.indexOf(" ") != -1)
			{
				result = cmd.isCommand(s.substring(0, s.indexOf(" ")));
				output.setText("" + result);
			}
			else
			{
				result = cmd.isCommand(s);
				output.setText("" + result);
			}
		}
		
	}
}