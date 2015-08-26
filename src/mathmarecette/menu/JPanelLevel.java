
package mathmarecette.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import mathmarecette.jeu.JFrameRecette;
import mathmarecette.jeu.Recette.Cake;
import mathmarecette.jeu.Recette.Crepe;
import mathmarecette.jeu.Recette.Pizza;
import mathmarecette.jeu.Recette.Recette;
import mathmarecette.jeu.Recette.Salade;
import mathmarecette.jeu.Recette.Spaghetti;

public class JPanelLevel extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelLevel()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation

		level1 = new JButton("Spaghetti");
		level2 = new JButton("Pâte à Crêpe ");
		level3 = new JButton("Cake au Citron ");
		level4 = new JButton("Salade");
		level5 = new JButton("Pizza au jambon ");

		// JComponent : Adaptation

		try
			{
			current = new java.io.File(".").getCanonicalPath();
			}
		catch (IOException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		String filename = current + "/Son/ClickJump.mp3";
		mp3 = new MP3(filename);

		level1.setPreferredSize(new Dimension(100, 30));
		level2.setPreferredSize(new Dimension(100, 30));
		level3.setPreferredSize(new Dimension(100, 30));
		level4.setPreferredSize(new Dimension(100, 30));
		level5.setPreferredSize(new Dimension(100, 30));

		level1.setBorderPainted(false);
		iconSpaghetti = new ImageIcon(current + "\\Image\\BTNSpaghetti.png");
		level1.setIcon(iconSpaghetti);

		level2.setBorderPainted(false);
		iconPate = new ImageIcon(current + "\\Image\\BTNPate.png");
		level2.setIcon(iconPate);

		level3.setBorderPainted(false);
		iconCake = new ImageIcon(current + "\\Image\\BTNCake.png");
		level3.setIcon(iconCake);

		level4.setBorderPainted(false);
		iconSalade = new ImageIcon(current + "\\Image\\BTNSalade.png");
		level4.setIcon(iconSalade);

		level5.setBorderPainted(false);
		iconPizza = new ImageIcon(current + "\\Image\\BTNPizza.png");
		level5.setIcon(iconPizza);

		// JComponent : Layout

		setLayout(new GridLayout(5, 1, 10, 10));
		add(level1);
		add(level2);
		add(level3);
		add(level4);
		add(level5);

		}

	private MouseAdapter monMouseListener(final JButton level, final Recette recette)
		{
		return new MouseAdapter()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					level.setLocation(level.getX(), level.getY()+10);
					if (click && dessus)
						{
						mp3.play();
						new JFrameRecette(recette);
						}
					click = false;
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					click = true;
					dessus = true;
					level.setLocation(level.getX(), level.getY()-10);
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
			};
		}

	private void control()
		{
		level1.addMouseListener(monMouseListener(level1, new Spaghetti()));
		level2.addMouseListener(monMouseListener(level2, new Crepe()));
		level3.addMouseListener(monMouseListener(level3, new Cake()));
		level4.addMouseListener(monMouseListener(level4, new Salade()));
		level5.addMouseListener(monMouseListener(level5, new Pizza()));
		}

	private void appearance()
		{
		Dimension panelD = new Dimension(500, 470);
		this.setPreferredSize(panelD);
		this.setMaximumSize(panelD);
		Color fontColor = new Color(255, 246, 213);
		setBackground(fontColor);
		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	JButton level1;
	JButton level2;
	JButton level3;
	JButton level4;
	JButton level5;
	private ImageIcon iconSpaghetti;
	private ImageIcon iconPate;
	private ImageIcon iconCake;
	private ImageIcon iconSalade;
	private ImageIcon iconPizza;
	private MP3 mp3;
	private String current;
	private boolean click = false;
	private boolean dessus = false;

	}
