
package mathmarecette.jeu.panel.horloge;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
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
import javax.swing.SwingConstants;
import javax.swing.Timer;

import mathmarecette.Tools;
import mathmarecette.jeu.horloge.JPanelHorloge;
import mathmarecette.jeu.panel.game.JPanelRecette;

public class JPanelJeuHorloge extends JPanel implements ActionListener
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * panel jeu horloge
	 */
	private static final long serialVersionUID = -3863676014336915474L;

	public JPanelJeuHorloge(JPanelRecette _panelRecette)
		{
		panelRecette = _panelRecette;
		timer = new Timer(30, this);
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//initialisation du panel, efface la question, remet l horloge a 14h
	public void initialisation()
		{
		labelQuestion.setText("");
		panelHorloge.initialisation();
		}

	//set la question a afficher
	public void setQuestion(String question)
		{
		labelQuestion.setText("<html><body><p align=\"center\">" + question + "</p></body></html>");
		}

	//effet fade
	@Override
	public void actionPerformed(ActionEvent e)
		{
		alpha += 0.1f;
		if (alpha > 1)
			{
			alpha = 1;
			timer.stop();
			}
		repaint();
		}

	//demarre l effet
	public void startFade()
		{
		timer.start();
		}

	//dessine un cadre derriere la question pour continuer notre effet de zoom dans la cuisine
	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// ANTI ALIASING
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

		g2.drawImage(HORLOGE.getImage(), 0, 0, null);

		g2.setColor(Tools.COLOR_CASE_INGREDIENT);
		g2.fillRect(0, 0, getWidth(), 110);
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), 90);

		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(2));
		g2.drawLine(0, 90, getWidth(), 90);
		g2.drawLine(0, 110, getWidth(), 110);

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
		panelHorloge = new JPanelHorloge();
		labelQuestion = new JLabel();
		buttonValider = new JButton("Valider");

		setLayout(null);

		// JComponent : add
		add(panelHorloge);
		add(labelQuestion);
		add(buttonValider);
		}

	private void control()
		{
		//valide l heure, controle le resultat et affiche le score de la recette
		buttonValider.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					String reponse = panelHorloge.getHeure();
					panelRecette.getRecette().verificationBonus(reponse);
					panelRecette.afficheScore();
					}
			});
		}

	private void appearance()
		{
		Dimension dim = new Dimension(600, 660);
		setPreferredSize(dim);
		setSize(dim);
		setLocation(0, 50);
		setBackground(Tools.COLOR_PANEL_INGREDIENT);
		panelHorloge.setLocation(200, 180);

		labelQuestion.setFont(new Font("Arial", Font.BOLD, 20));
		labelQuestion.setSize(this.getWidth() - 20, 90);
		labelQuestion.setLocation(10, 0);
		labelQuestion.setVerticalAlignment(SwingConstants.CENTER);
		labelQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		buttonValider.setSize(80, 40);
		buttonValider.setLocation(160 + panelHorloge.getWidth() / 2, 570);
		buttonValider.setBackground(Tools.COLOR_CASE_INGREDIENT);

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelHorloge panelHorloge;
	private static final ImageIcon HORLOGE = new ImageIcon(".\\image\\horloge.png");
	private JLabel labelQuestion;
	private JPanelRecette panelRecette;
	private JButton buttonValider;
	private float alpha = 0.0f;
	private Timer timer;
	}
