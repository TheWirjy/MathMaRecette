
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

	//joue un bruitage
	public static void playBruitage(String bruitage)
		{

		if (!bMute)
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
		}

	//Joue une musique
	public static void playSon(String son)
		{
		sonSave = son;
		if (!bMute)
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
		/*FloatControl volume = (FloatControl) clipSon.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(-20);*/
		}

	//stop le son
	public static void stopSon()
		{
		clipSon.close();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	//mute / démute
	public static void setMute()
		{
		bMute = !bMute;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	//recupere la valeur du mute
	public static boolean getMute()
		{
		return bMute;
		}

	//prend le dernier son jouer en cas "démute"
	public static String getSonSave()
		{
		return sonSave;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools classe
	private static Clip clipSon;
	private static Clip clipBruitage;
	private static boolean bMute = false;
	private static String sonSave = "";

	//CHEMIN
	public static final String CHEMIN = ".\\image\\ingredient\\";

	//COULEUR
	public static final Color COLOR_BAR = new Color(234, 226, 197);
	public static final Color COLOR_TITRE_RECETTE = new Color(0, 0, 128);
	public static final Color COLOR_PANEL_INGREDIENT = new Color(216, 209, 182);
	public static final Color COLOR_CASE_CLICK_INGREDIENT = new Color(173, 173, 173);
	public static final Color COLOR_CASE_INGREDIENT = new Color(205, 204, 205);
	public static final Color COLOR_MUR = new Color(252, 243, 212);
	public static final Color COLOR_VERT = new Color(0, 255, 0);
	public static final Color COLOR_BLEU = new Color(0, 0, 128);
	public static final Color COLOR_MENU = new Color(255, 246, 213);

	//IMAGE
	public static final ImageIcon HES_SO = new ImageIcon(".\\image\\logo_ecole\\hes-so.jpg");
	public static final ImageIcon ARC = new ImageIcon(".\\image\\logo_ecole\\arc.jpg");

	public static final ImageIcon TITRE_TUTO = new ImageIcon(".\\image\\titre\\titre_tuto.png");
	public static final ImageIcon BOUTON_QUITTER_ARCADE = new ImageIcon(".\\image\\quitter_fin_arcade.png");
	public static final ImageIcon BOUTON_QUITTER_ARCADE_CLICK = new ImageIcon(".\\image\\quitter_fin_arcade_click.png");

	public static final ImageIcon BOUTON_TOC = new ImageIcon(".\\image\\bouton_toc.png");
	public static final ImageIcon BOUTON_TOC_VISIBLE = new ImageIcon(".\\image\\bouton_toc_visible.png");

	public static final ImageIcon BOUTON_RETOUR = new ImageIcon(".\\image\\retour.png");
	public static final ImageIcon BOUTON_RETOUR_CLICK = new ImageIcon(".\\image\\retour_click.png");

	public static final ImageIcon MUTE_OFF = new ImageIcon(".\\image\\mute.png");
	public static final ImageIcon MUTE_ON = new ImageIcon(".\\image\\muteOn.png");

	public static final ImageIcon GIF_DRAG = new ImageIcon(".\\image\\tuto\\dragGif.gif");
	public static final ImageIcon GIF_ORDRE = new ImageIcon(".\\image\\tuto\\ordreGif.gif");
	public static final ImageIcon GIF_HORLOGE = new ImageIcon(".\\image\\tuto\\horlogeGif.gif");

	public static final ImageIcon MENU_MUTE_ON = new ImageIcon(".\\image\\muteOn_menu.png");
	public static final ImageIcon MENU_MUTE_ON_CLICK = new ImageIcon(".\\image\\muteOn_menu_click.png");
	public static final ImageIcon MENU_MUTE_OFF = new ImageIcon(".\\image\\muteOff_menu.png");
	public static final ImageIcon MENU_MUTE_OFF_CLICK = new ImageIcon(".\\image\\muteOff_menu_click.png");

	public static final ImageIcon TABLEAU = new ImageIcon(".\\image\\tableau.png");
	public static final ImageIcon IMPRIMER = new ImageIcon(".\\image\\btnScoreImprimer.png");
	public static final ImageIcon IMPRIMER_CLICK = new ImageIcon(".\\image\\btnScoreImprimer_click.png");

	public static final ImageIcon CONTINUER = new ImageIcon(".\\image\\btnScoreContinuer.png");
	public static final ImageIcon CONTINUER_CLICK = new ImageIcon(".\\image\\btnScoreContinuer_click.png");

	//MEDAILLES
	public static final ImageIcon TOC = new ImageIcon(".\\image\\medailles\\toc.png");
	public static final ImageIcon M_TIME = new ImageIcon(".\\image\\medailles\\time.png");
	public static final ImageIcon MEDAILLE_VIDE = new ImageIcon(".\\image\\medailles\\mVide.png");
	public static final ImageIcon M_SPAGH_1 = new ImageIcon(".\\image\\medailles\\mSpagh1.png");
	public static final ImageIcon M_SPAGH_2 = new ImageIcon(".\\image\\medailles\\mSpagh2.png");
	public static final ImageIcon M_SPAGH_3 = new ImageIcon(".\\image\\medailles\\mSpagh3.png");

	public static final ImageIcon M_SALADE_1 = new ImageIcon(".\\image\\medailles\\mSalade1.png");
	public static final ImageIcon M_SALADE_2 = new ImageIcon(".\\image\\medailles\\mSalade2.png");
	public static final ImageIcon M_SALADE_3 = new ImageIcon(".\\image\\medailles\\mSalade3.png");

	public static final ImageIcon M_CREPE_1 = new ImageIcon(".\\image\\medailles\\mCrepe1.png");
	public static final ImageIcon M_CREPE_2 = new ImageIcon(".\\image\\medailles\\mCrepe2.png");
	public static final ImageIcon M_CREPE_3 = new ImageIcon(".\\image\\medailles\\mCrepe3.png");

	public static final ImageIcon M_CAKE_1 = new ImageIcon(".\\image\\medailles\\mCake1.png");
	public static final ImageIcon M_CAKE_2 = new ImageIcon(".\\image\\medailles\\mCake2.png");
	public static final ImageIcon M_CAKE_3 = new ImageIcon(".\\image\\medailles\\mCake3.png");

	public static final ImageIcon M_PIZZA_1 = new ImageIcon(".\\image\\medailles\\mPizza1.png");
	public static final ImageIcon M_PIZZA_2 = new ImageIcon(".\\image\\medailles\\mPizza2.png");
	public static final ImageIcon M_PIZZA_3 = new ImageIcon(".\\image\\medailles\\mPizza3.png");
	}
