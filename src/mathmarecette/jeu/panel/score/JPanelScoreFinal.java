
package mathmarecette.jeu.panel.score;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import mathmarecette.Tools;
import mathmarecette.jeu.Recette.Recette;
import mathmarecette.jeu.medaille.JPanelMedaille;
import mathmarecette.jeu.panel.game.JPanelArcade;

public class JPanelScoreFinal extends JPanel implements ActionListener
	{

	/**
	 * panel de score final apres le mode arcade fini au complet
	 */
	private static final long serialVersionUID = 1L;

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelScoreFinal(JPanelArcade panelRecette)
		{
		this.panelRecette = panelRecette;
		timer = new Timer(30, this);
		time = "";
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setTime(String time)
		{
		this.time = time;
		}

	public void startFade()
		{
		timer.start();
		}

	@Override
	public void actionPerformed(ActionEvent arg0)
		{
		alpha += 0.1f;
		if (alpha > 1)
			{
			alpha = 1;
			timer.stop();
			}
		repaint();
		}

	public void color(Graphics2D g, int score)
		{
		if (score > 0)
			{
			g.setColor(Color.GREEN);
			}
		else
			{
			g.setColor(Color.RED);
			}
		}

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// ANTI ALIASING
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

		//dessine le tableau
		g2.drawImage(Tools.TABLEAU.getImage(), 0, 0, null);
		g2.setColor(Color.WHITE);
		g2.drawLine(200, 110, 400, 110);
		g2.setFont(FONT_TITRE);
		g2.drawString("RÉSUMÉ", 240, 100);

		//recupere les recette
		Recette[] recettes = panelRecette.getRecettes();
		int scoreTot = 0;
		int scoreTotMax = 0;
		g2.setFont(FONT_QUESTION);

		int yPos = 130;
		String txt = "";

		//pour chaque recette, on affiche son nom et son score ainsi que le nombre de point max possible pour la recette
		for(int i = 0; i < recettes.length; i++)
			{
			yPos += 30;
			txt = recettes[i].getNom();

			g2.setColor(Color.WHITE);

			g2.drawString(txt, 70, yPos);

			scoreTot += recettes[i].getScore();
			scoreTotMax += recettes[i].getScoreMax();
			color(g2, recettes[i].getScore());

			g2.drawString(recettes[i].getScore() + "", 390, yPos);
			g2.setColor(Color.WHITE);
			g2.drawString(" / " + recettes[i].getScoreMax(), 450, yPos);
			g2.drawImage(recettes[i].getMedaille().getImage(), 85 + i * 85, 400, null);
			}

		g2.setColor(Color.WHITE);

		yPos += 20;

		g2.drawLine(70, yPos, 530, yPos);

		yPos += 30;

		//affiche le temps
		g2.drawString(scoreTot + "", 390, yPos);
		g2.drawString(" / " + scoreTotMax, 450, yPos);
		g2.setColor(Color.WHITE);
		g2.drawString(time, 70, yPos);

		yPos += 30;

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
		// JComponent : Instanciation
		boutonToc = new JButton();
		boutonQuitter = new JButton();
		panelMedaille = new JPanelMedaille();

		setLayout(null);

		// JComponent : add
		add(panelMedaille);
		add(boutonToc);
		add(boutonQuitter);
		}

	private void control()
		{
		//affiche la toque avec les badge que l on pourra imprimer en 3d
		boutonToc.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					panelMedaille.setVisible(!panelMedaille.isVisible());
					panelMedaille.setRecette(panelRecette.getRecettes(), time);

					if (panelMedaille.isVisible())
						{
						boutonToc.setIcon(Tools.BOUTON_TOC_VISIBLE);
						}
					else
						{
						boutonToc.setIcon(Tools.BOUTON_TOC);
						}
					}
			});

		//bouton quitter = retour menu
		boutonQuitter.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					panelMedaille.save();
					panelRecette.quitArcade();
					}
			});
		}

	private void appearance()
		{
		Dimension dim = new Dimension(600, 650);
		setPreferredSize(dim);
		setSize(dim);
		setLocation(0, 50);

		panelMedaille.setVisible(false);
		panelMedaille.setLocation(100, 150);

		boutonToc.setIcon(Tools.BOUTON_TOC);
		boutonToc.setPressedIcon(Tools.BOUTON_TOC_VISIBLE);
		boutonToc.setContentAreaFilled(false);
		boutonToc.setBorderPainted(false);
		boutonToc.setSize(60, 67);
		boutonToc.setLocation(getWidth() / 2 - boutonToc.getWidth() - 40, 540);
		boutonQuitter.setIcon(Tools.BOUTON_QUITTER_ARCADE);
		boutonQuitter.setPressedIcon(Tools.BOUTON_QUITTER_ARCADE_CLICK);
		boutonQuitter.setContentAreaFilled(false);
		boutonQuitter.setBorderPainted(false);
		boutonQuitter.setSize(154, 61);
		boutonQuitter.setLocation(getWidth() / 2 - 40, 550);

		setBackground(Tools.COLOR_BAR);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private final Font FONT_TITRE = new Font("Segoe Print", Font.BOLD, 28);
	private final Font FONT_QUESTION = new Font("Segoe Print", Font.PLAIN, 20);
	private JPanelArcade panelRecette;
	private JButton boutonToc;
	private JButton boutonQuitter;
	private JPanelMedaille panelMedaille;

	private float alpha = 0.0f;
	private Timer timer;
	private String time;
	}
