
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
		this.id_pos = _id;
		this.x = x;
		setLocation(x, 0);
		setSize(80, 80);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public int getID()
		{
		return id;
		}

	public int getID_pos()
		{
		return id_pos;
		}

	public void setID_pos(int id)
		{
		this.id_pos = id;
		}


	public void setPositionX(int x)
		{
		this.x = x;
		}

	public int getPositionX()
		{
		return x;
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

	private int id_pos;
	private int id;
	private int x;
	}
