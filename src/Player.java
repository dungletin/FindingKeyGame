
public class Player
{
	private String name;
	private int hold;
	
	public Player(String name)
	{
		this.name = name;
	}
	
	/*
	 * Methods make player hold the key
	 */
	public void holdKey(int keyCode) {
		hold = keyCode;
	}
	

}
