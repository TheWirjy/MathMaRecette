
package mathmarecette.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelMenu extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelMenu()
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

		arcade = new JButton("");
		niveau = new JButton("");
		tutoriel = new JButton("");
		apropos = new JButton("");

		String filename = "C:/Users/raphael.schaffo/HE-ARC/MathMaRecette Media/Son/CLickJump.mp3";
		mp3 = new MP3(filename);

		try
			{
			current = new java.io.File(".").getCanonicalPath();
			}
		catch (IOException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

		// JComponent : Adaptation

		arcade.setPreferredSize(new Dimension(100, 30));
		niveau.setPreferredSize(new Dimension(100, 30));
		tutoriel.setPreferredSize(new Dimension(100, 30));
		apropos.setPreferredSize(new Dimension(100, 30));

		arcade.setBorderPainted(false);
		iconArcade = new ImageIcon(current + "\\Image\\BTNArcade.png");
		iconArcadeCopie = new ImageIcon(current + "\\Image\\BTNArcade-copie.png");
		arcade.setIcon(iconArcade);

		niveau.setBorderPainted(false);
		iconLevel = new ImageIcon(current + "\\Image\\BTNNiveau.png");
		iconLevelCopie = new ImageIcon(current + "\\Image\\BTNNiveau-copie.png");
		niveau.setIcon(iconLevel);

		tutoriel.setBorderPainted(false);
		iconTutorial = new ImageIcon(current + "\\Image\\BTNTutoriel.png");
		iconTutorialCopie = new ImageIcon(current + "\\Image\\BTNTutoriel-copie.png");
		tutoriel.setIcon(iconTutorial);

		apropos.setBorderPainted(false);
		iconApropos = new ImageIcon(current + "\\Image\\BTNApropos.png");
		iconAproposCopie = new ImageIcon(current + "\\Image\\BTNApropos - Copie.png");
		apropos.setIcon(iconApropos);

		// JComponent : Layout

		setLayout(new GridLayout(4, 1, 20, 20));
		add(arcade);
		add(niveau);
		add(tutoriel);
		add(apropos);
		}

	private void control()
		{
		tutoriel.addMouseListener(new MouseListener()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					tutoriel.setIcon(iconTutorial);

					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					tutoriel.setIcon(iconTutorialCopie);

					}

				@Override
				public void mouseExited(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseEntered(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseClicked(MouseEvent e)
					{
					// TODO Auto-generated method stub
					mp3.play();

					}
			});
		arcade.addMouseListener(new MouseListener()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					arcade.setIcon(iconArcade);
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					arcade.setIcon(iconArcadeCopie);
					}

				@Override
				public void mouseExited(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseEntered(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseClicked(MouseEvent e)
					{
					// TODO Auto-generated method stub
					mp3.play();

					}
			});
		niveau.addMouseListener(new MouseListener()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					niveau.setIcon(iconLevel);
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					niveau.setIcon(iconLevelCopie);
					}

				@Override
				public void mouseExited(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseEntered(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseClicked(MouseEvent e)
					{
					// TODO Auto-generated method stub
					new JFrameLevel();
					mp3.play();
					}
			});

		apropos.addMouseListener(new MouseListener()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					apropos.setIcon(iconApropos);
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					apropos.setIcon(iconAproposCopie);

					}

				@Override
				public void mouseExited(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseEntered(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}

				@Override
				public void mouseClicked(MouseEvent e)
					{
					// TODO Auto-generated method stub
					new JFrameCredits().setAlwaysOnTop(true);
					mp3.play();
					}
			});

		}

	private void appearance()
		{
		Dimension panelD = new Dimension(250, 300);
		this.setPreferredSize(panelD);
		this.setMaximumSize(panelD);
		Color fontColor = new Color(255, 246, 213);
		setBackground(fontColor);
		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	JButton arcade;
	JButton niveau;
	JButton tutoriel;
	JButton apropos;
	private ImageIcon iconApropos;
	private ImageIcon iconAproposCopie;
	private ImageIcon iconLevel;
	private ImageIcon iconLevelCopie;
	private ImageIcon iconArcade;
	private ImageIcon iconArcadeCopie;
	private ImageIcon iconTutorial;
	private ImageIcon iconTutorialCopie;
	private MP3 mp3;
	private String current;

	}
