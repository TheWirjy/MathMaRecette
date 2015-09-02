package mathmarecette.jeu;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import mathmarecette.Tools;

public class JPanelVolume  extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelVolume ()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
			// JComponent : Instanciation
			volume= new JSlider();
			sonPropriete= new JLabel("Paramètre Audio");
			volumeActuel= new JLabel("10");
			imageVolume= new JLabel();


		// JComponent : add
			add(sonPropriete);
			add(volume);
			add(volumeActuel);
			add(imageVolume);

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		Dimension panelD = new Dimension(300, 120);
		this.setSize(panelD);
		this.setPreferredSize(panelD);
		this.setMaximumSize(panelD);
		setBackground(Tools.COLOR_MUR);

		sonPropriete.setSize(300,50);
		sonPropriete.setLocation(0, 0);

		imageVolume.setSize(50, 50);
		imageVolume.setLocation(0,60);

		volume.setSize(180, 50);
		volume.setLocation(55, 60);

		volumeActuel.setSize(50, 50);
		volumeActuel.setLocation(245, 60);

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JSlider volume;
	private JLabel sonPropriete;
	private JLabel volumeActuel;
	private JLabel imageVolume;
	}




