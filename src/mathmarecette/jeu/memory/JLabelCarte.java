
package mathmarecette.jeu.memory;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCarte extends JLabel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JLabelCarte(int id, JPanelMemory memory)
		{
		super(CARTE_A);
		carte_b = new ImageIcon(".\\image\\memory\\"+id+".png");
		this.memory = memory;
		this.id = id;

		setLayout(null);
		setSize(80, 80);

		addMouseListener(new MouseListener()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseExited(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseEntered(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseClicked(MouseEvent e)
					{
					// TODO Auto-generated method stub
					if (trouve == false && isReturn == false)
						{
						retourner();
						}
					}
			});
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void retourner()
		{
		cpt++;

		if (cpt == 3)
			{
			memory.cacherCarte();
			cpt = 1;
			}

		isReturn = true;

		setIcon(carte_b);

		System.out.println(id + "");

		if (cpt == 2)
			{
			memory.verification(id);
			}

		if (cpt == 1)
			{
			idA = id;
			}

		}

	public void cacher()
		{
		setIcon(CARTE_A);
		isReturn = false;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public void isFound()
		{
		trouve = true;
		setIcon(CARTE_C);
		}

	public boolean getFound()
		{
		return trouve;
		}

	public boolean getReturn()
		{
		return isReturn;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private final static ImageIcon CARTE_A = new ImageIcon(".\\image\\memory\\carte.png");
	private final static ImageIcon CARTE_C = new ImageIcon(".\\image\\memory\\famille.png");
	private ImageIcon carte_b;
	private JPanelMemory memory;
	private int id;
	public static int cpt = 0;
	public static int idA = -1;
	private boolean trouve = false;
	private boolean isReturn = false;
	}
