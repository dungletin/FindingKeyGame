import java.awt.Dimension;

import javax.swing.JButton;

public class Key extends JButton
{
	private int code;

	public Key()
	{
		setPreferredSize(new Dimension(80, 80));
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.code);
	}
}
