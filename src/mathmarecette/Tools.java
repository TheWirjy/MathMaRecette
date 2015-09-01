
package mathmarecette;

import java.awt.Color;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class Tools
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void playBruitage(String bruitage)
		{

		try
			{
			if (clipBruitage != null && clipBruitage.isRunning())
				{
				clipBruitage.close();
				}
			File file = new File(bruitage);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
			clipBruitage = AudioSystem.getClip();
			clipBruitage.open(audioIn);
			clipBruitage.start();
			}
		catch (Exception e)
			{
			System.out.println("erreur son");
			}
		}

	public static void playSon(String son)
		{
		try
			{
			if (clipSon != null && clipSon.isRunning())
				{
				clipSon.close();
				}
			File file = new File(son);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
			clipSon = AudioSystem.getClip();
			clipSon.open(audioIn);
			clipSon.start();
			clipSon.loop(Clip.LOOP_CONTINUOUSLY);
			}
		catch (Exception e)
			{
			System.out.println("erreur son");
			}
		}

	public static void stopSon()
		{
		clipSon.close();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private static Clip clipSon;
	private static Clip clipBruitage;
	private static boolean bMute = false;

	public static final String CHEMIN = ".\\image\\ingredient\\";
	public static final Color COLOR_BAR = new Color(234, 226, 197);
	public static final Color COLOR_TITRE_RECETTE = new Color(0, 0, 128);
	public static final Color COLOR_PANEL_INGREDIENT = new Color(216, 209, 182);
	public static final Color COLOR_CASE_CLICK_INGREDIENT = new Color(173, 173, 173);
	public static final Color COLOR_CASE_INGREDIENT = new Color(205, 204, 205);
	public static final Color COLOR_MUR = new Color(252, 243, 212);
	public static final Color COLOR_VERT = new Color(0, 255, 0);
	public static final Color COLOR_BLEU = new Color(0, 0, 128);
	public static final Color COLOR_MENU = new Color(255, 246, 213);

	public static final ImageIcon HES_SO = new ImageIcon(".\\image\\hes-so.jpg");
	public static final ImageIcon ARC = new ImageIcon(".\\image\\arc.jpg");
	public static final ImageIcon BOUTON_RETOUR = new ImageIcon(".\\image\\retour.png");
	public static final ImageIcon BOUTON_RETOUR_CLICK = new ImageIcon(".\\image\\retour_click.png");

	public static final ImageIcon GIF_DRAG = new ImageIcon(".\\image\\dragGif.gif");
	public static final ImageIcon GIF_ORDRE = new ImageIcon(".\\image\\ordreGif.gif");
	public static final ImageIcon GIF_HORLOGE = new ImageIcon(".\\image\\horlogeGif.gif");
	}
