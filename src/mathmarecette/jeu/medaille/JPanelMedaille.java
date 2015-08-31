
package mathmarecette.jeu.medaille;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import mathmarecette.Tools;

public class JPanelMedaille extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelMedaille()
		{
		geometry();
		control();
		appearance();

		try
			{
			font = Font.createFont(Font.TRUETYPE_FONT, new File(".\\font\\DIGITALISM.TTF"));
			font = font.deriveFont(Font.BOLD, 45);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			}
		catch (Exception e)
			{
			// TODO Auto-generated catch block
			font = new Font("Segoe Print", Font.BOLD, 45);
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// ANTI ALIASING
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.drawImage(IMAGE_TOC.getImage(), 0, 0, null);

		g2.drawImage(M_SPAG.getImage(), 70, 70, null);
		g2.drawImage(M_SALADE.getImage(), 235, 30, null);
		g2.drawImage(M_CREPE.getImage(), 400, 70, null);
		g2.drawImage(M_CAKE.getImage(), 170, 120, null);
		g2.drawImage(M_PIZZA.getImage(), 300, 120, null);
		g2.drawImage(M_TIME.getImage(), 220, 420, null);
		g2.setFont(font);
		g2.drawString("15:58", 253, 472);
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
		Dimension dim = new Dimension(600, 530);
		setSize(dim);
		setPreferredSize(dim);
		setMaximumSize(dim);

		setBackground(Tools.COLOR_MUR);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private ImageIcon IMAGE_TOC = new ImageIcon(".\\image\\medailles\\toc.png");
	private ImageIcon M_SPAG = new ImageIcon(".\\image\\medailles\\mSpagh3.png");
	private ImageIcon M_CAKE = new ImageIcon(".\\image\\medailles\\mCake3.png");
	private ImageIcon M_PIZZA = new ImageIcon(".\\image\\medailles\\mPizza3.png");
	private ImageIcon M_CREPE = new ImageIcon(".\\image\\medailles\\mCrepe3.png");
	private ImageIcon M_SALADE = new ImageIcon(".\\image\\medailles\\mSalade3.png");
	private ImageIcon M_TIME = new ImageIcon(".\\image\\medailles\\time.png");
	private Font font;
	}
