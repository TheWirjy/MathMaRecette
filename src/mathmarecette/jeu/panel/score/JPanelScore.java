
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import mathmarecette.Tools;
import mathmarecette.jeu.panel.game.composant.JPanelRecette;

public class JPanelScore extends JPanel implements ActionListener
	{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelScore(JPanelRecette panelRecette)
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

		g2.drawImage(Tools.TABLEAU.getImage(), 0, 0, null);
		g2.setColor(Color.WHITE);
		g2.drawLine(120, 110, 480, 110);
		g2.setFont(FONT_TITRE);
		g2.drawString("TABLEAU DES SCORES", 130, 100);

		int[] score = panelRecette.getRecette().getTabScore();
		int nbQuestion = panelRecette.getRecette().getNbQuestion();

		g2.setFont(FONT_QUESTION);

		int yPos = 130;
		String txt = "";
		for(int i = 0; i < nbQuestion; i++)
			{
			yPos += 30;
			if (panelRecette.getRecette().getTabQuestion()[i].length() > 30)
				{
				txt = panelRecette.getRecette().getTabQuestion()[i].substring(0, 30) + "...";
				}
			else
				{
				txt = panelRecette.getRecette().getTabQuestion()[i];
				}

			g2.setColor(Color.WHITE);

			g2.drawString(txt, 70, yPos);

			color(g2, score[i]);

			g2.drawString(score[i] + "", 480, yPos);
			}

		g2.setColor(Color.WHITE);

		if (panelRecette.getRecette().aUnMiniJeu())
			{
			yPos += 50;
			g2.drawString("Mini jeu ", 70, yPos);

			color(g2, score[nbQuestion]);

			g2.drawString(score[nbQuestion] + "", 480, yPos);
			yPos += 50;

			g2.setColor(Color.WHITE);

			g2.drawString("Horloge", 70, yPos);

			color(g2, score[nbQuestion + 1]);
			g2.drawString(score[nbQuestion + 1] + "", 480, yPos);
			}
		else
			{
			yPos += 50;
			g2.drawString("Horloge", 70, yPos);

			color(g2, score[nbQuestion]);
			g2.drawString(score[nbQuestion] + "", 480, yPos);
			}

		g2.setColor(Color.WHITE);

		yPos += 20;

		g2.drawLine(70, yPos, 530, yPos);

		yPos += 30;

		int scoreTot = panelRecette.getRecette().getScore();

		color(g2, scoreTot);
		g2.drawString(scoreTot + "", 480, yPos);

		g2.setColor(Color.WHITE);
		g2.drawString(time, 70, yPos);

		g2.drawImage(panelRecette.getRecette().getMedaille().getImage(), 460, 50, null);
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
		buttonImprimer = new JButton();
		buttonContinuer = new JButton();
		labelMedaille = new JLabel();

		setLayout(null);

		// JComponent : add
		add(buttonImprimer);
		add(buttonContinuer);
		add(labelMedaille);
		}

	private void control()
		{
		buttonContinuer.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					panelRecette.retourScore();
					}
			});
		}

	private void appearance()
		{
		Dimension dim = new Dimension(600, 660);
		setPreferredSize(dim);
		setSize(dim);
		setLocation(0, 50);

		buttonImprimer.setIcon(Tools.IMPRIMER);
		buttonImprimer.setPressedIcon(Tools.IMPRIMER_CLICK);
		buttonImprimer.setContentAreaFilled(false);
		buttonImprimer.setBorderPainted(false);
		buttonImprimer.setSize(146, 91);
		buttonImprimer.setLocation(getWidth() / 2 - buttonImprimer.getWidth(), 520);
		buttonContinuer.setIcon(Tools.CONTINUER);
		buttonContinuer.setPressedIcon(Tools.CONTINUER_CLICK);
		buttonContinuer.setContentAreaFilled(false);
		buttonContinuer.setBorderPainted(false);
		buttonContinuer.setSize(154, 61);
		buttonContinuer.setLocation(getWidth() / 2, 550);

		labelMedaille.setSize(80, 80);
		labelMedaille.setLocation(450, 50);

		setBackground(Tools.COLOR_BAR);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private final Font FONT_TITRE = new Font("Segoe Print", Font.BOLD, 28);
	private final Font FONT_QUESTION = new Font("Segoe Print", Font.PLAIN, 20);
	private JPanelRecette panelRecette;
	private JButton buttonImprimer;
	private JButton buttonContinuer;
	private JLabel labelMedaille;

	private float alpha = 0.0f;
	private Timer timer;
	private String time;
	}