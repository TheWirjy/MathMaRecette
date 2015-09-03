
package mathmarecette.jeu.medaille;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import mathmarecette.Tools;
import mathmarecette.jeu.Recette.Recette;

public class JPanelMedaille extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelMedaille()
		{
		time = "00:00";
		geometry();
		control();
		appearance();

		//chargement des polices d'écriture (police externe)
		try
			{
			font = Font.createFont(Font.TRUETYPE_FONT, new File(".\\font\\DIGITALISM.TTF"));
			font = font.deriveFont(Font.BOLD, 30);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);

			font2 = Font.createFont(Font.TRUETYPE_FONT, new File(".\\font\\MELODBO.TTF"));
			font2 = font2.deriveFont(Font.PLAIN, 18);
			ge.registerFont(font2);
			}
		catch (Exception e)
			{
			// TODO Auto-generated catch block
			font = new Font("Segoe Print", Font.BOLD, 20);
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void save()
		{
		try
			{
			/*File file = new File("toque.png");
			if (file.exists())
				{
				file.delete();
				}*/
			ImageIO.write(off_Image, "png", new File("toque.png"));
			}
		catch (Exception ex)
			{
			System.out.println("err save");
			}
		}

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		//Graphics2D g2 = (Graphics2D)g;

		if (off_Image == null || bMaj)
			{
			off_Image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = off_Image.createGraphics();

			// ANTI ALIASING
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			//affiche la toque de cuisinier
			g2.drawImage(Tools.TOC.getImage(), 0, 0, null);

			g2.setColor(Color.BLACK);
			//si les recettes existe
			if (recettes != null)
				{
				//affiche la medaille de chaque recette
				g2.drawImage(recettes[0].getMedaille().getImage(), 35, 35, null);
				g2.drawImage(recettes[1].getMedaille().getImage(), 90, 85, null);
				g2.drawImage(recettes[2].getMedaille().getImage(), 155, 120, null);
				g2.drawImage(recettes[3].getMedaille().getImage(), 220, 85, null);
				g2.drawImage(recettes[4].getMedaille().getImage(), 280, 35, null);
				//affiche le temps du mode arcade
				g2.drawImage(Tools.M_TIME.getImage(), 150, 280, null);
				g2.setFont(font);
				g2.drawString(time, 165, 315);
				g2.setFont(font2);
				//affiche le titre du jeu sur la toque
				g2.drawString("MATH", 165, 50);
				g2.drawString("MA RECETTE", 135, 70);
				}
			bMaj = false;
			}
		g.drawImage(off_Image, 0, 0, this);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	//permet de seter les recettes et le temps du mode arcade (panel creer plus tot dans le jeu (donc les recette n existe encore pas) mais afficher qu au bon moment)
	public void setRecette(Recette[] recettes, String time)
		{
		this.recettes = recettes;
		this.time = time;
		bMaj = true;
		repaint();
		}

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
		Dimension dim = new Dimension(400, 353);
		setSize(dim);
		setPreferredSize(dim);
		setMaximumSize(dim);

		setOpaque(false);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Font font, font2;
	private Recette[] recettes;
	private String time;
	private boolean bMaj = false;
	private BufferedImage off_Image;
	}
