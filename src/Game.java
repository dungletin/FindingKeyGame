import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame
{
	private int numOfKeys = 3;
	private int numOfDoors = 5;
	private int numOfPlayers = 4;
	private Door[] doors;
	private Key[] keys;
	private Random random;

	public Game()
	{

		doors = new Door[numOfDoors];

		setLayout(new GridLayout());
		add(createKeyPanel());
		add(createDoorPanel());
		// set the program to end when the window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// display the window
		setVisible(true);
		pack();
	}

	public void createDoors(Key[] keys)
	{
		// create 3 locked doors with the same 3 unique keys
		for (int i = 0; i < numOfKeys; i++)
		{
			int location = getRandomLocation();

			doors[location] = new LockedDoor(keys[i].getCode());
		}

		// create no lock door
		for (int i = 0; i < numOfDoors; i++)
		{
			if (doors[i] == null)
			{
				doors[i] = new Door();
			}
		}

		// test game
		// for (int i = 0; i < numOfDoors; i++)
		// {
		// System.out.println(doors[i]);
		// }

	}

	public void createKeys()
	{
		random = new Random();
		// create unique set code for keys
		HashSet<Integer> uniqueSet = new HashSet<>();

		while (uniqueSet.size() < 3)
		{
			uniqueSet.add(random.nextInt(100));

		}

		keys = new Key[numOfKeys];
		// put the unique set numbers into the keys
		int i = 0;
		for (int num : uniqueSet)
		{
			keys[i] = new Key();
			keys[i].setCode(num);
			i++;
		}

	}

	// create random location for locked door
	public int getRandomLocation()
	{
		int location;
		location = random.nextInt(5);
		while (doors[location] != null)
		{
			location = random.nextInt(5);
		}
		return location;
	}

	/*
	 * Methods create game panel
	 */
	public JPanel createDoorPanel()
	{
		createDoors(keys);
		JPanel doorPanel = new JPanel();
		// add buttons into frame
		for (int i = 0; i < numOfDoors; i++)
		{
			// Temp set the text to check if the code work
			doorPanel.add(doors[i]);
			if (doors[i].isLocked())
			{
				doors[i].setText(doors[i].toString());
			}
			else
			{
				doors[i].setText("no lock");
			}
		}

		doorPanel.setPreferredSize(new Dimension(400, 400));
		return doorPanel;

	}

	/*
	 * Create key panel
	 */
	public JPanel createKeyPanel()
	{
		JPanel keyPanel = new JPanel();
		createKeys();
		for (int i = 0; i < numOfKeys; i++)
		{
			keyPanel.add(keys[i]);
			keys[i].setText(keys[i].toString());
		}

		keyPanel.setPreferredSize(new Dimension(400, 400));
		return keyPanel;
	}
	
	
	

}
