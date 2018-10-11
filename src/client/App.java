package client;

import javax.swing.SwingUtilities;
import view.AppFrame;

//Main class
public class App
{

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				AppFrame frame =new AppFrame();
				//populate frame
				frame.populate();
				// add GUI and console callbacks to game engine
				frame.addCallBacks();
				// add 1 player to game 
				frame.loadPlayer();
			}
		});
	
	}
}