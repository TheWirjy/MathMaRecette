
package mathmarecette.jeu.horloge;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import mathmarecette.Tools;

public class JPanelHorloge extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * Panel Horloge
	 */
	private static final long serialVersionUID = -4081161226106246894L;

	public JPanelHorloge()
		{
		initialisation();

		//calcul des angles pour les heure 1h = 360/12 = 30�
		//on demarre a -15� car si l aiguille est entre -15� et 15� il est midi
		f_angle = new int[12];
		int a = -15;
		for(int i = 0; i < 12; i++)
			{
			f_angle[i] = a + i * 30;
			}

		//tableau des angles pour les minutes 360/60 = 6�
		f_angleM = new int[60];
		int m = -3;
		for(int i = 0; i < 60; i++)
			{
			f_angleM[i] = m + i * 6;
			}

		start();
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//met les valeurs par d�faut (14h)
	public void initialisation()
		{
		reponse = "";
		heure = "14";
		minute = "00";
		angleH = 45;
		angleM = 0;
		}

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// ANTI ALIASING
		AffineTransform transform = g2.getTransform();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// EPAISSEUR
		g2.setStroke(STROKE);

		g2.setColor(BLACK);
		g2.drawOval(50, 40, 320, 320);

		// CERCLE HORLOGE EXTERIEUR (CADRE) GRIS
		g2.setColor(Color.GRAY);
		g2.fillOval(50, 40, 320, 320);

		g2.setColor(GRAY);
		g2.fillOval(45, 40, 315, 320);

		g2.setColor(BLACK);
		g2.drawOval(45, 40, 315, 320);

		// CERCLE HORLOGE INTERIEUR BLANC
		g2.setColor(WHITE);
		g2.fillOval(50, 50, 300, 300);
		g2.setColor(BLACK);
		g2.drawOval(50, 50, 300, 300);

		// CERCLE CENTRE AIGUILLE
		g2.setColor(GRAY);
		g2.fillOval(193, 192, 15, 15);
		g2.setColor(BLACK);
		g2.drawOval(193, 192, 15, 15);

		// TRAIT MINUTE
		for(int i = 0; i < 60; i++)
			{
			g2.rotate((f_angleM[i] + 3) * Math.PI / 180, 200, 200);
			g2.drawLine(200, 56, 200, 51);
			g2.setTransform(transform);
			}

		// TRAIT HEURE
		for(int i = 0; i < 12; i++)
			{
			g2.rotate((f_angle[i] + 15) * Math.PI / 180, 200, 200);
			g2.drawLine(200, 63, 200, 51);
			g2.setTransform(transform);
			}

		// ECRITURE DES HEURE 12H 3H 6H 9H
		g2.setFont(FONT);
		g2.drawString("12", 190, 80);
		g2.drawString("3", 323, 206);
		g2.drawString("9", 67, 206);
		g2.drawString("6", 195, 333);

		// GRANDE AIGUILLE (MINUTES)
		g2.rotate(angleM, 200, 200);
		g2.drawLine(200, 200, 200, 85);

		g2.setTransform(transform);

		// PETITE AIGUILLE (HEURES)
		g2.setColor(RED);
		g2.rotate(angleH, 200, 200);
		g2.drawLine(200, 200, 200, 130);

		// CERCLE QUI RECOUVRE LES AIGUILLES AU CENTRE DE L HORLOGE
		g2.setColor(BLACK);
		g2.fillOval(195, 195, 10, 10);

		g2.setTransform(transform);
		}

	//active le listener pour tourner les aiguilles - montre le panel
	public void start()
		{
		start = true;
		setVisible(true);
		}

	//stop le listener - cache le panel
	public void stop()
		{
		start = false;
		setVisible(false);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	//retourne l heure afficher sur l horloge sous le format "14h30"
	public String getHeure()
		{
		return reponse;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{

		FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
		setLayout(flowlayout);

		}

	private void control()
		{
		//tourne l aiguille en maintenant la touche de la souris enfoncer et en bougant le curseur
		addMouseMotionListener(new MouseMotionAdapter()
			{

				@Override
				public void mouseDragged(MouseEvent e)
					{
					// TODO Auto-generated method stub
					if (start)
						{
						rotateAiguille(e);
						}
					}
			});

		// met l aiguille la ou on presse sur l horloge
		//recupere le bouton presser - gauche -> tourne les heure - droite -> tourne l aiguille minutes
		addMouseListener(new MouseAdapter()
			{

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					if (start)
						{
						button = e.getButton();
						rotateAiguille(e);
						}
					}
			});
		}

	//rotation de l aiguille
	private void rotateAiguille(MouseEvent e)
		{
		double a = Math.atan2((200 - e.getX()), (200 - e.getY()));

		//transformation radian -> degr�
		a = Math.abs(a * 180 / Math.PI);
		if (e.getX() < 200)
			{
			//tangante, 180� -> quand on tourne dans le sens des aiguille d une montre depuis midi, si l'aiguille arrive sur le cote gauche de l horlge, au lieu d avoir un angle qui redescent de 180 a 0, ou le fais aller de 180 a 360
			a = 360 - a;
			}

		//si c est le clique gauche
		//on regarde dans quelle plage de 30� est l aiguille et on lui donne l heure se trouvant au milieu de cette plage
		if (button == MouseEvent.BUTTON1)
			{
			for(int i = 0; i < 12; i++)
				{
				if (a > f_angle[i] && a < f_angle[i] + 30)
					{
					angleH = (f_angle[i] + 15) * Math.PI / 180;
					heure = i + 12 + "";
					}
				}
			}
		//si c est le bouton droite de la souris
		//idem, on regarde cette fois dans quelle plage de 6� est l aiguille et on lui applique l angle ce trouvant au centre de cette plage
		else if (button == MouseEvent.BUTTON3)
			{
			for(int i = 0; i < 60; i++)
				{
				if (a > f_angleM[i] && a < f_angleM[i] + 6)
					{
					angleM = (f_angleM[i] + 3) * Math.PI / 180;

					if (i < 10)
						{
						minute = "0" + i;
						}
					else
						{
						minute = i + "";
						}
					}
				}
			}
		//assigne l heure afficher a une variable r�ponse qui pourra etre demander avec un get
		reponse = heure + "h" + minute;
		//System.out.println(reponse);
		repaint();
		}

	private void appearance()
		{
		Dimension dim = new Dimension(400, 400);
		setPreferredSize(dim);
		setSize(dim);
		setOpaque(false);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private String reponse;
	private String heure;
	private String minute;
	private double angleH;
	private double angleM;
	private int[] f_angle;
	private int[] f_angleM;
	private int button;
	private final Color BLACK = Color.BLACK;
	private final Color WHITE = Color.WHITE;
	private final Color RED = Color.RED;
	private final Color GRAY = Tools.COLOR_CASE_INGREDIENT;
	private final Font FONT = new Font("Arial", Font.BOLD, 18);
	private final BasicStroke STROKE = new BasicStroke(3);
	private boolean start = false;
	}
