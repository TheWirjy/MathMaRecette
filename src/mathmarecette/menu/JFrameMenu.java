
package mathmarecette.menu;

import java.awt.BorderLayout;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mathmarecette.jeu.JPanelArcade;
import mathmarecette.jeu.JPanelRecette;
import mathmarecette.jeu.Recette.Recette;

public class JFrameMenu extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 *
	 */
	private static final long serialVersionUID = 2051497550641079298L;

	public JFrameMenu()
		{
		arcade = false;
		geometry();
		control();
		appearance();

		MP3 mp3 = new MP3("./Son/recette.mp3");
		//mp3.play();
		playSon();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void playSon()
		{
		try
			{
			File file = new File("./Son/menu.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		catch (Exception e)
			{
			System.out.println("erreur son");
			}
		}

	public void questionBonus()
		{
		if (arcade)
			{
			panelArcade.startQuestionBonus();
			}
		else
			{
			panelRecette.startQuestionBonus();
			}
		}

	public void recette(Recette _recette)
		{
		clip.close();
		arcade = false;
		panelRecette.init(_recette);
		remove(panelLevel);
		add(panelRecette);
		revalidate();
		repaint();
		}

	public void quitRecette()
		{
		if (arcade)
			{
			remove(panelArcade);
			}
		else
			{
			remove(panelRecette);
			}
		add(panelMenu);
		revalidate();
		repaint();
		playSon();
		}

	public void arcade()
		{
		clip.stop();
		arcade = true;
		panelArcade.init();
		remove(panelMenu);
		add(panelArcade);
		revalidate();
		repaint();
		}

	public void level()
		{
		remove(panelMenu);
		add(panelLevel);
		repaint();
		}

	public void tuto()
		{
		remove(panelMenu);
		add(panelTuto);
		repaint();
		}

	public void credit()
		{
		remove(panelMenu);
		add(panelCredit);
		repaint();
		}

	public void menu(JPanel panel)
		{
		remove(panel);
		add(panelMenu);
		repaint();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public JPanelRecette getPanelRecette()
		{
		return panelRecette;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		panelMenu = new JPanelMenu(this);
		panelCredit = new JPanelCredits(this);
		panelLevel = new JPanelLevel(this);
		panelRecette = new JPanelRecette(this);
		panelTuto = new JPanelTuto(this);
		panelArcade = new JPanelArcade(this);

		// JComponent : Layout
		setLayout(new BorderLayout());

		add(panelMenu, BorderLayout.CENTER);

		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		/*Dimension dim = new Dimension(600, 700);
		setPreferredSize(dim);
		setSize(dim);
		setMaximumSize(dim);*/
		pack();
		setResizable(false);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelMenu panelMenu;
	private JPanelLevel panelLevel;
	private JPanelCredits panelCredit;
	private JPanelRecette panelRecette;
	private JPanelTuto panelTuto;
	private JPanelArcade panelArcade;
	private boolean arcade;
	private Clip clip;
	}
