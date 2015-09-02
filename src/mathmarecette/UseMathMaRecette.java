
package mathmarecette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mathmarecette.menu.JFrameMenu;

public class UseMathMaRecette
	{

	private JDialog dialog;

	//private JProgressBar progress;

	protected void initUI() throws MalformedURLException
		{
		showSplashScreen();
		SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>()
			{

				@Override
				protected Void doInBackground() throws Exception
					{
					for(int i = 0; i < 10; i++)
						{
						Thread.sleep(100);
						publish(i * 10);
						}
					return null;
					}

				@Override
				protected void process(List<Integer> chunks)
					{
					//progress.setValue(chunks.get(chunks.size() - 1));
					}

				@Override
				protected void done()
					{
					showFrame();
					hideSplashScreen();
					}

			};
		worker.execute();
		}

	protected void hideSplashScreen()
		{
		dialog.setVisible(false);
		dialog.dispose();
		}

	protected void showSplashScreen() throws MalformedURLException
		{
		dialog = new JDialog((Frame)null);
		dialog.setModal(false);
		dialog.setUndecorated(true);
		dialog.getRootPane().setOpaque(true);
		dialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
		dialog.setBackground(new Color(0, 0, 0, 0));
		JLabel background = new JLabel(new ImageIcon(".//Image//splachScreen.png"));
		background.setLayout(new BorderLayout());
		dialog.add(background);

		//progress = new JProgressBar();
		//background.add(progress, BorderLayout.SOUTH);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		}

	protected void showFrame()
		{
		new JFrameMenu();
		}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
		{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(new Runnable()
			{

				@Override
				public void run()
					{
					try
						{
						new UseMathMaRecette().initUI();
						}
					catch (MalformedURLException e)
						{
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					}
			});
		}
	}
