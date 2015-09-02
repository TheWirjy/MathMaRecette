package mathmarecette.jeu;
import javax.swing.JFrame;

public class JFrameVolume extends JFrame
{

/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

public JFrameVolume()
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
	volume= new JPanelVolume();

		// JComponent : add
	add(volume);
	}

private void control()
	{
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

private void appearance()
	{
	setSize(300, 120);
	setLocationRelativeTo(null); // frame centrer
	setVisible(true); // last!

	volume.setSize(300, 120);
	volume.setLocation(0, 0);
	}

/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

// Tools
private JPanelVolume volume;
/*------------------------------------------------------------------*\
|*							Methodes Public							*|
\*------------------------------------------------------------------*/

public static void main(String[] args)
	{
	main();
	}

public static void main()
	{
	new JFrameVolume();
	}

/*------------------------------------------------------------------*\
|*							Methodes Private						*|
\*------------------------------------------------------------------*/

}




