
package mathmarecette.jeu.panel.game.composant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import mathmarecette.Tools;
import mathmarecette.menu.JFrameMenu;

public class JPanelInfoBar extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 *
	 */
	private static final long serialVersionUID = -3107030340064931516L;

	public JPanelInfoBar(JFrameMenu frame)
		{
		this.parent = frame;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setMute(boolean mute)
		{
		if (mute)
			{
			bouton_mute.setIcon(Tools.MENU_MUTE_ON);
			}
		else
			{
			bouton_mute.setIcon(Tools.MENU_MUTE_OFF);
			}
		}

	public void initialisation()
		{
		minute = 0;
		seconde = 0;
		timeSave = 0;
		strMinute = "00";
		strSeconde = "00";
		labelChrono.setText("00:00");
		labelTitre.setIcon(null);
		}

	public void setTitre(ImageIcon icon)
		{
		labelTitre.setIcon(icon);
		}

	public void start()
		{
		timeSave = getTime();
		timer.start();
		}

	public void stop()
		{
		timer.stop();
		}

	public int getTime()
		{
		int s = 0;
		s += minute * 60;
		s += seconde;
		return s - timeSave;
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
		labelTitre = new JLabel();
		labelChrono = new JLabel("00:00");
		labelQuitter = new JLabel();
		bouton_mute = new JLabel();

		setSize(new Dimension(650, 50));
		setLocation(0, 0);

		setLayout(null);

		// JComponent : add
		add(labelTitre);
		add(labelChrono);
		add(labelQuitter);
		add(bouton_mute);
		}

	private void control()
		{

		int delais = 1000;
		ActionListener tache_timer;

		tache_timer = new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e1)
					{
					seconde++;
					if (seconde == 60)
						{
						seconde = 0;
						minute++;
						}
					if (minute == 60)
						{
						minute = 0;
						}
					strSeconde = seconde + "";
					strMinute = minute + "";

					if (seconde < 10)
						{
						strSeconde = "0" + seconde;
						}
					if (minute < 10)
						{
						strMinute = "0" + minute;
						}

					labelChrono.setText(strMinute + ":" + strSeconde);/*
																		* rafraichir le
																		* label
																		*/
					}
			};

		timer = new Timer(delais, tache_timer);

		bouton_mute.addMouseListener(new MouseAdapter()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					if (click && dessus)
						{
						Tools.stopSon();
						Tools.setMute();
						if (!Tools.getMute())
							{
							Tools.playSon(Tools.getSonSave());
							}
						}
					parent.setMute(Tools.getMute());
					click = false;
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					click = true;
					dessus = true;
					if (Tools.getMute())
						{
						bouton_mute.setIcon(Tools.MENU_MUTE_ON_CLICK);
						}
					else
						{
						bouton_mute.setIcon(Tools.MENU_MUTE_OFF_CLICK);
						}
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

		labelQuitter.addMouseListener(new MouseAdapter()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					labelQuitter.setIcon(Tools.BOUTON_RETOUR);
					if (click && dessus)
						{
						timer.stop();

						parent.quitRecette();
						}
					click = false;
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					click = true;
					dessus = true;
					labelQuitter.setIcon(Tools.BOUTON_RETOUR_CLICK);
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

		try
			{
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File(".\\font\\DIGITALISM.TTF"));
			font = font.deriveFont(Font.BOLD, 30);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			labelChrono.setFont(font);
			}
		catch (Exception e)
			{
			// TODO Auto-generated catch block
			labelChrono.setFont(new Font("Arial", 1, 20));
			}

		labelTitre.setSize(200, 50);
		labelTitre.setLocation(getWidth() / 2 - 100, 0);

		labelChrono.setSize(200, 50);
		labelChrono.setLocation(getWidth() - 210, 0);
		labelChrono.setVerticalAlignment(SwingConstants.CENTER);
		labelChrono.setHorizontalAlignment(SwingConstants.CENTER);

		labelQuitter.setSize(35, 35);
		labelQuitter.setLocation(10, 7);
		labelQuitter.setIcon(Tools.BOUTON_RETOUR);

		bouton_mute.setIcon(Tools.MENU_MUTE_OFF);
		bouton_mute.setSize(35, 35);
		bouton_mute.setLocation(55, 7);

		setBackground(Tools.COLOR_BAR);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Timer timer;
	private JFrameMenu parent;
	private JLabel labelTitre;
	private JLabel labelChrono;
	private JLabel labelQuitter;
	private boolean click = false;
	private boolean dessus = false;
	private static int minute = 0;
	private static int seconde = 0;
	private String strSeconde;
	private String strMinute;
	private int timeSave;
	private JLabel bouton_mute;
	}
