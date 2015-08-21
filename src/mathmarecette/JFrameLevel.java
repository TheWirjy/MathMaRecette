package mathmarecette;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameLevel extends JFrame
{

/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

public JFrameLevel()
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

	level = new JPanelLevel ();
	pictures= new JLabel("");
	
	// JComponent : Adaptation
	ImageIcon iconPictures = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\font-niveau.png");
	pictures.setIcon(iconPictures);

	// JComponent : Layout

	setLayout(null);
	add(level);
	add(pictures);
	level.setSize(500, 470);
	level.setLocation(50,30);
	pictures.setSize(500, 150);
	pictures.setLocation(50, 500);
	}

private void control()
	{

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
private JPanelLevel level;
private JLabel pictures;



}

