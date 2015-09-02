
package mathmarecette.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mathmarecette.Tools;

public class JPanelCredits extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	/**
	 * panel a propos, logo école + nom prenom
	 */
	private static final long serialVersionUID = 8560785449800765489L;
	public JPanelCredits(JFrameMenu _parent)
		{
		this.parent = _parent;
		geometry();
		control();
		appearance();
		}

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// ANTI ALIASING
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//dessine une feuille blanche
		g2.setColor(Color.GRAY);
		g2.fillRect(55, 55, 500, 600);

		g2.setColor(Color.WHITE);
		g2.fillRect(50, 50, 500, 600);
		g2.setColor(Color.BLACK);
		g2.drawRect(50, 50, 500, 600);

		//dessine les logo
		g2.drawImage(Tools.HES_SO.getImage(), 150, 100, null);
		g2.drawImage(Tools.ARC.getImage(), 150, 253, null);
		g2.drawLine(130, 350, 470, 350);

		//dessine les nom prenom + titre
		g2.setFont(FONT_T);
		g2.setColor(COLOR_ARC_ROUGE);
		g2.drawString("Projet d'HES d'été", 210, 380);
		g2.setFont(FONT_N);
		g2.setColor(COLOR_HES_BLEU);
		g2.drawString("Schaffo Raphaël", 235, 420);
		g2.drawString("Ajjali Wassim", 245, 450);
		g2.drawString("Wirth Jeremy", 243, 480);
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		labelRetour = new JLabel();

		setLayout(null);

		add(labelRetour);

		}

	private void control()
		{
		//ajout du bouton retour pour revenir au menu
		labelRetour.addMouseListener(new MouseAdapter()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					labelRetour.setIcon(Tools.BOUTON_RETOUR);
					if (click && dessus)
						{
						parent.menu(JPanelCredits.this);
						}
					click = false;
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					click = true;
					dessus = true;
					labelRetour.setIcon(Tools.BOUTON_RETOUR_CLICK);
					}

				@Override
				public void mouseExited(MouseEvent e)
					{
					// TODO Auto-generated method stub
					dessus = false;
					}

				@Override
				public void mouseEntered(MouseEvent e)
					{
					// TODO Auto-generated method stub
					dessus = true;
					}
			});
		}

	private void appearance()
		{
		Dimension panelD = new Dimension(600, 700);
		this.setSize(panelD);
		this.setPreferredSize(panelD);
		this.setMaximumSize(panelD);
		setBackground(Tools.COLOR_MUR);

		labelRetour.setIcon(Tools.BOUTON_RETOUR);
		labelRetour.setSize(35, 35);
		labelRetour.setLocation(10, 10);

		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools

	private JLabel labelRetour;
	private JFrameMenu parent;

	private boolean click = false;
	private boolean dessus = false;

	private final Font FONT_T = new Font("Segoe Print", Font.PLAIN, 20);
	private final Font FONT_N = new Font("Segoe Print", Font.PLAIN, 16);
	private final Color COLOR_HES_BLEU = new Color(1, 152, 241);
	private final Color COLOR_ARC_ROUGE = new Color(200, 0, 79);
	}
