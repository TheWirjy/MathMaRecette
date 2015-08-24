
package mathmarecette.jeu.ordre;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class JLabelOrdre extends JLabel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JLabelOrdre(int _id, int x)
		{
		super("" + _id);
		this.id = _id;
		this.x = x;
		setLocation(x, 0);
		setSize(80, 80);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		mx = x + 40;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public int getID()
		{
		return id;
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

	private int id;
	private int x;
	private int mx;
	}
