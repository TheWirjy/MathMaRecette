package mathmarecette.menu;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameMenu extends JFrame
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JFrameMenu()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		menu = new JPanelMenu();
		pictures= new JLabel("");
		title= new JLabel("");
		
		try {
			current = new java.io.File( "." ).getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ImageIcon iconPictures = new ImageIcon(current+"\\Image\\font.png");
		pictures.setIcon(iconPictures);

		ImageIcon iconTitle = new ImageIcon(current+"\\Image\\title.png");
		title.setIcon(iconTitle);

		// JComponent : Layout
		setLayout(null);
		add(menu);
		add(pictures);
		add(title);
		title.setSize(570, 115);
		title.setLocation(15, 40);
		menu.setSize(250, 300);
		menu.setLocation(160,200);
		pictures.setSize(500, 155);
		pictures.setLocation(50, 500);

		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(600, 700);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		setResizable(false);
		Color fontColor = new Color(255,246,213);
		getContentPane().setBackground(fontColor);
		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	private JPanelMenu menu;
	JLabel pictures;
	JLabel title;
	private String current;

	}
