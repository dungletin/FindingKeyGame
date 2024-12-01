
public class LockedDoor extends Door
{
	private int locker;

	public LockedDoor(int locker)
	{
		this.locker = locker;
	}

	public int getLocker()
	{
		return this.locker;
	}

	@Override
	public String toString()
	{
		return "Lock " + locker;
	}

	/*
	 * Door has locker
	 */
	@Override
	public boolean isLocked()
	{
		return true;
	}

}
