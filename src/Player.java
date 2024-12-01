
public class Player
{
	private String name;
	private int hold;
	private boolean isHold = false;

	public Player(String name)
	{
		this.name = name;
	}

	/*
	 * Methods make player hold the key
	 */
	public void holdKey(int keyCode)
	{
		hold = keyCode;
		this.isHold = true;
	}

	/*
	 * The player will drop the key when hit the door button
	 */
	public void dropKey()
	{
		this.isHold = false;
	}

	/*
	 * Is the player holding the key
	 */
	public boolean isHold()
	{
		return isHold;
	}

}
