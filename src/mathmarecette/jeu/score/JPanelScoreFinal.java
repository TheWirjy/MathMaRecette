
package mathmarecette.jeu.score;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import mathmarecette.Tools;
import mathmarecette.jeu.JPanelArcade;
import mathmarecette.jeu.Recette.Recette;

public class JPanelScoreFinal extends JPanel implements ActionListener
	{

	/**
	 *
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

		g2.drawImage(TABLEAU.getImage(), 0, 0, null);
		g2.setColor(Color.WHITE);
		g2.drawLine(120, 110, 480, 110);
		g2.setFont(FONT_TITRE);
		g2.drawString("TABLEAU DES SCORES", 130, 100);

		Recette[] recettes = panelRecette.getRecettes();
		int scoreTot = 0;
		g2.setFont(FONT_QUESTION);

		int yPos = 130;
		String txt = "";
		for(int i = 0; i < recettes.length; i++)
			{
			yPos += 30;
			txt = recettes[i].getNom();

			g2.setColor(Color.WHITE);

			g2.drawString(txt, 70, yPos);

			scoreTot += recettes[i].getScore();
			color(g2, recettes[i].getScore());

			g2.drawString(recettes[i].getScore() + "", 480, yPos);
			}

		g2.setColor(Color.WHITE);

		yPos += 20;

		g2.drawLine(70, yPos, 530, yPos);

		yPos += 30;

		color(g2, scoreTot);
		g2.drawString(scoreTot + "", 480, yPos);

		g2.setColor(Color.WHITE);
		g2.drawString(time, 70, yPos);

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
					System.out.println("menu");
					}
			});
		}

	private void appearance()
		{
		Dimension dim = new Dimension(600, 660);
		setPreferredSize(dim);
		setSize(dim);
		setLocation(0, 50);

		buttonImprimer.setIcon(IMPRIMER);
		buttonImprimer.setPressedIcon(IMPRIMER_CLICK);
		buttonImprimer.setContentAreaFilled(false);
		buttonImprimer.setBorderPainted(false);
		buttonImprimer.setSize(146, 91);
		buttonImprimer.setLocation(getWidth() / 2 - buttonImprimer.getWidth(), 520);
		buttonContinuer.setIcon(CONTINUER);
		buttonContinuer.setPressedIcon(CONTINUER_CLICK);
		buttonContinuer.setContentAreaFilled(false);
		buttonContinuer.setBorderPainted(false);
		buttonContinuer.setSize(154, 61);
		buttonContinuer.setLocation(getWidth() / 2, 550);

		labelMedaille.setSize(80, 80);
		labelMedaille.setLocation(450, 50);
		labelMedaille.setIcon(MEDAILLE);

		setBackground(Tools.COLOR_BAR);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private static final ImageIcon TABLEAU = new ImageIcon(".\\image\\tableau.png");
	private static final ImageIcon IMPRIMER = new ImageIcon(".\\image\\btnScoreImprimer.png");
	private static final ImageIcon IMPRIMER_CLICK = new ImageIcon(".\\image\\btnScoreImprimer_click.png");

	private static final ImageIcon MEDAILLE = new ImageIcon(".\\image\\medaille.png");

	private static final ImageIcon CONTINUER = new ImageIcon(".\\image\\btnScoreContinuer.png");
	private static final ImageIcon CONTINUER_CLICK = new ImageIcon(".\\image\\btnScoreContinuer_click.png");
	private final Font FONT_TITRE = new Font("Segoe Print", Font.BOLD, 28);
	private final Font FONT_QUESTION = new Font("Segoe Print", Font.PLAIN, 20);
	private JPanelArcade panelRecette;
	private JButton buttonImprimer;
	private JButton buttonContinuer;
	private JLabel labelMedaille;

	private float alpha = 0.0f;
	private Timer timer;
	private String time;
	}
