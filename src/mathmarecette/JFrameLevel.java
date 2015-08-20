package mathmarecette;

import java.awt.FlowLayout;

import javax.swing.JFrame;

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

	// JComponent : Layout

	setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
	add (level);
	}

private void control()
	{

	}

private void appearance()
	{
	setSize(300, 250);
	setLocationRelativeTo(null); // frame centrer
	setVisible(true); // last!
	setResizable(false);
	}

/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

// Tools
private JPanelLevel level;



}

