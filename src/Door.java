import java.awt.Dimension;

import javax.swing.JButton;

public class Door extends JButton
{

	public Door()
	{
		setPreferredSize(new Dimension(80, 80));// set dimension for buttons
	}

	@Override
	public String toString()
	{
		return "No lock";
	}

	/*
	 * Door has no locker
	 */
	public boolean isLocked()
	{
		return false;
	}

}
