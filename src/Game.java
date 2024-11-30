import java.util.HashSet;
import java.util.Random;

public class Game
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
		createKeys();
		createDoors(keys);
	}

	public void createDoors(Key[] keys)
	{
		// create 3 locked doors with the same 3 unique keys
		for (int i = 0; i < numOfKeys; i++)
		{
			int location = getRandomLocation();

			doors[location] = new LockedDoor(keys[i].getCode());
		}

		for (int i = 0; i < numOfDoors; i++)
		{
			if (doors[i] == null)
			{
				doors[i] = new Door();
			}
		}

		for (int i = 0; i < numOfDoors; i++)
		{
			System.out.println(doors[i]);
		}

	}

	public void createKeys()
	{
		random = new Random();
		// create unique set code for keys
		HashSet<Integer> uniqueSet = new HashSet<>();

		while (uniqueSet.size() < 3)
		{
			uniqueSet.add(random.nextInt(3));

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

}
