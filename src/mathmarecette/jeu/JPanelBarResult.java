
package mathmarecette.jeu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class JPanelBarResult extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBarResult()
		{
		reponse = new ArrayList<Integer>();
		width = 15;
		height = 250;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void initialisation(int _nbQuestion)
		{
		nbQuestion = _nbQuestion;
		reponse.clear();
		for(int i = 0; i < nbQuestion; i++)
			{
			reponse.add(2);
			}
		hLabel = height / _nbQuestion;
		}

	@Override
	public void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		for(int i = 0; i < nbQuestion; i++)
			{
			if (reponse.get(i) == 1)
				{
				g2.setColor(COLOR_JUSTE);
				g2.fillRect(3, (int)(height - (i + 1) * hLabel), width, (int)hLabel);
				}
			else if (reponse.get(i) == 0)
				{
				g2.setColor(COLOR_FAUX);
				g2.fillRect(3, (int)(height - (i + 1) * hLabel), width, (int)hLabel);
				}
			else
				{
				g2.setColor(COLOR_NEUTRE);
				g2.fillRect(3, (int)(height - (i + 1) * hLabel), width, (int)hLabel);
				}
			}

		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(2));
		for(int i = 0; i < nbQuestion; i++)
			{
			g.drawRect(3, (int)(i * hLabel) + 3, width, (int)hLabel);
			}
		}

	public void setResultat(int indice, boolean juste)
		{
		if (juste)
			{
			reponse.add(indice, 1);
			}
		else
			{
			reponse.add(indice, 0);
			}
		repaint();
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

	private void geometry()
		{
		setLayout(null);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		setSize(width + 5, height + 5);
		setLocation(570, 250);
		setOpaque(false);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private int width;
	private int height;
	private double hLabel;
	private int nbQuestion = 0;
	private List<Integer> reponse;
	private final Color COLOR_FAUX = new Color(174, 0, 38);
	private final Color COLOR_JUSTE = new Color(0, 173, 115);
	private final Color COLOR_NEUTRE = new Color(84, 84, 84);
	}
