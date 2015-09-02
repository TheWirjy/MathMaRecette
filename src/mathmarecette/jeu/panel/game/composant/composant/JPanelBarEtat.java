
package mathmarecette.jeu.panel.game.composant.composant;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import mathmarecette.Tools;

public class JPanelBarEtat extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * panel suivi des question qcm, affiche a quelle question on est (en fonction du nombre de question total)
	 */
	private static final long serialVersionUID = -4325557141358902924L;

	public JPanelBarEtat()
		{
		reponse = new ArrayList<Integer>();
		width = 250;
		height = 15;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//initialisation : recupere le nombre de question = nombre de rond a afficher
	public void initialisation(int _nbQuestion)
		{
		nbQuestion = _nbQuestion;
		reponse.clear();
		for(int i = 0; i < nbQuestion; i++)
			{
			reponse.add(2);
			}
		}

	@Override
	public void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//si la case du tableau = 1 : signifie que la question a ete repondu donc on affiche un cercle vert
		for(int i = 0; i < nbQuestion; i++)
			{
			if (reponse.get(i) == 1)
				{
				g2.setColor(COLOR_JUSTE);
				g2.fillOval(i * 10 + i * 5 + 5, 3, 10, 10);
				}
			}

		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(2));

		for(int i = 0; i < nbQuestion; i++)//affiche un cercle vide de contour noir pour chaque question
			{
			g.drawOval(i * 10 + i * 5 + 5, 3, 10, 10);
			}
		}

	public void next(int indice)
		{
		reponse.add(indice, 1);
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
		setSize(width, height);
		setPreferredSize(new Dimension(width, height));
		setLocation(335, 175);
		setOpaque(false);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private int width;
	private int height;
	private int nbQuestion = 0;
	private List<Integer> reponse;
	private final Color COLOR_JUSTE = Tools.COLOR_VERT;
	}
