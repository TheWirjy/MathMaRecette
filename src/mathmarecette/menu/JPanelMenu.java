
package mathmarecette.menu;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mathmarecette.Tools;
import mathmarecette.jeu.JPanelVolume;

public class JPanelMenu extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	/**
	 *
	 */
	private static final long serialVersionUID = 3592622742224246733L;

	public JPanelMenu(JFrameMenu _parent)
		{
		this.parent = _parent;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	public void setMute(boolean mute)
		{
		if (mute)
			{
			bouton_mute.setIcon(Tools.MUTE_ON);
			}
		else
			{
			bouton_mute.setIcon(Tools.MUTE_OFF);
			}
		}

	private void geometry()
		{
		// JComponent : Instanciation
		arcade = new JButton();
		niveau = new JButton();
		tutoriel = new JButton();
		apropos = new JButton();
		pictures = new JLabel();
		title = new JLabel();
		bouton_mute = new JLabel();
		panelVolume = new JPanelVolume();

		arcade.setBorderPainted(false);
		iconArcade = new ImageIcon(".\\Image\\BTNArcade.png");
		arcade.setIcon(iconArcade);

		niveau.setBorderPainted(false);
		iconLevel = new ImageIcon(".\\Image\\BTNNiveau.png");
		niveau.setIcon(iconLevel);

		tutoriel.setBorderPainted(false);
		iconTutorial = new ImageIcon(".\\Image\\BTNTutoriel.png");
		tutoriel.setIcon(iconTutorial);

		apropos.setBorderPainted(false);
		iconApropos = new ImageIcon(".\\Image\\BTNApropos.png");
		apropos.setIcon(iconApropos);

		ImageIcon iconPictures = new ImageIcon(".\\Image\\font.png");
		pictures.setIcon(iconPictures);

		ImageIcon iconTitle = new ImageIcon(".\\Image\\title.png");
		title.setIcon(iconTitle);

		// JComponent : Layout

		setLayout(null);

		panelVolume.setLocation(300-panelVolume.getWidth()/2, 670);

		add(panelVolume);
		add(bouton_mute);
		add(arcade);
		add(niveau);
		add(tutoriel);
		add(apropos);
		add(pictures);
		add(title);

		}

	private MouseAdapter monMouseListener(final JButton level, final int choix)
		{
		return new MouseAdapter()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					level.setLocation(level.getX(), level.getY() + 10);
					if (click && dessus)
						{
						Tools.playBruitage("./Son/bouton_menu.wav");
						switch(choix)
							{
							case 0://Arcade
								parent.arcade();
								break;
							case 1://Niveau
								parent.level();
								break;
							case 2://Tuto
								parent.tuto();
								break;
							case 3://A propos
								parent.credit();
								break;
							}
						}
					click = false;
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					click = true;
					dessus = true;
					level.setLocation(level.getX(), level.getY() - 10);
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
		arcade.addMouseListener(monMouseListener(arcade, 0));
		niveau.addMouseListener(monMouseListener(niveau, 1));
		tutoriel.addMouseListener(monMouseListener(tutoriel, 2));
		apropos.addMouseListener(monMouseListener(apropos, 3));

		bouton_mute.addMouseListener(new MouseAdapter()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					bouton_mute.setLocation(bouton_mute.getX(), bouton_mute.getY() + 10);
					if (click && dessus)
						{
						Tools.stopSon();
						Tools.setMute();
						parent.setMute(Tools.getMute());
						if (!Tools.getMute())
							{
							Tools.playSon(Tools.getSonSave());
							}
						}
					click = false;
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					click = true;
					dessus = true;
					bouton_mute.setLocation(bouton_mute.getX(), bouton_mute.getY() - 10);
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
		Dimension dimPanel = new Dimension(590, 690);
		setPreferredSize(dimPanel);
		setSize(dimPanel);
		setBackground(Tools.COLOR_MENU);

		title.setSize(570, 115);
		title.setLocation(15, 40);
		pictures.setSize(500, 155);
		pictures.setLocation(50, 500);

		Dimension dim = new Dimension(250, 60);
		arcade.setPreferredSize(dim);
		arcade.setSize(dim);
		arcade.setLocation(getWidth() / 2 - dim.width / 2, 180);
		niveau.setPreferredSize(dim);
		niveau.setSize(dim);
		niveau.setLocation(getWidth() / 2 - dim.width / 2, 260);
		tutoriel.setPreferredSize(dim);
		tutoriel.setSize(dim);
		tutoriel.setLocation(getWidth() / 2 - dim.width / 2, 340);
		apropos.setPreferredSize(dim);
		apropos.setSize(dim);
		apropos.setLocation(getWidth() / 2 - dim.width / 2, 420);

		bouton_mute.setIcon(Tools.MUTE_OFF);
		bouton_mute.setSize(80, 80);
		bouton_mute.setLocation(260, 600);
		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	private JButton arcade;
	private JButton niveau;
	private JButton tutoriel;
	private JButton apropos;
	private JLabel pictures;
	private JLabel title;

	private JLabel bouton_mute;

	private ImageIcon iconApropos;
	private ImageIcon iconLevel;
	private ImageIcon iconArcade;
	private ImageIcon iconTutorial;
	private boolean click = false;
	private boolean dessus = false;

	private JFrameMenu parent;
	private JPanelVolume panelVolume;
	}
