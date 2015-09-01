
package mathmarecette.jeu.panel.game.composant.composant;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mathmarecette.Tools;
import mathmarecette.jeu.panel.game.composant.JPanelRecette;

public class JLabelIngredient extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 *
	 */
	private static final long serialVersionUID = 8578267501910220280L;

	public JLabelIngredient(JPanelRecette _panelRecette, int _id, Point pO)
		{
		this.panelRecette = _panelRecette;
		this.id = _id;
		this.pO = pO;
		geometry();
		control();
		appearance();

		setLocation(pO);
		setSize(90, 90);
		setOpaque(false);
		setVisible(false);

		colorRect = Color.BLACK;
		colorFRect = Tools.COLOR_CASE_INGREDIENT;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Color shadowColorA = new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(), 50);
		Graphics2D graphics = (Graphics2D)g;

		if (shady)
			{
			graphics.setColor(shadowColorA);
			graphics.fillRoundRect(shadowOffset,// X position
					shadowOffset,// Y position
					this.getWidth() - strokeSize - shadowOffset, // width
					this.getHeight() - strokeSize - shadowOffset, // height
					arcs.width, arcs.height);// arc Dimension
			}
		else
			{
			shadowGap = 1;
			}

		// Draws the rounded opaque panel with borders.
		graphics.setColor(colorFRect);
		graphics.fillRoundRect(0, 0, this.getWidth() - shadowGap, this.getHeight() - shadowGap, arcs.width, arcs.height);
		graphics.setColor(colorRect);
		graphics.setStroke(new BasicStroke(strokeSize));
		graphics.drawRoundRect(0, 0, this.getWidth() - shadowGap, this.getHeight() - shadowGap, arcs.width, arcs.height);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setIngredient(ImageIcon ingr)
		{
		this.labelImage.setIcon(ingr);
		}

	public void setOrigin(Point p)
		{
		pO = p;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		labelImage = new JLabel("");

		Box boxV = Box.createVerticalBox();
		boxV.add(labelImage);

		FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
		setLayout(flowlayout);

		// JComponent : add
		add(boxV);
		}

	private void control()
		{
		addMouseMotionListener(new MouseMotionAdapter()
			{

				@Override
				public void mouseDragged(MouseEvent e)
					{
					// TODO Auto-generated method stub

					JLabelIngredient panelDrag = (JLabelIngredient)e.getComponent();

					x = panelDrag.getX() + e.getX() - xSourisClick;
					y = panelDrag.getY() + e.getY() - ySourisClick;
					panelDrag.setLocation(x, y);
					}
			});

		addMouseListener(new MouseAdapter()
			{

				@Override
				public void mousePressed(MouseEvent e)
					{
					xSourisClick = e.getX();
					ySourisClick = e.getY();
					x = 0;
					y = 0;
					// setComponentZOrder(e.getComponent(), 0);
					}

				@Override
				public void mouseReleased(MouseEvent e)
					{
					if (x + 45 < 110 || x + 45 > 520 || y + 45 < 320 || y + 45 > 500)
						{
						e.getComponent().setLocation(pO);
						}
					else
						{
						e.getComponent().setLocation(pO);
						Integer Px = new Integer(x);
						Integer Py = new Integer(y);
						panelRecette.reponseValider(id, (ImageIcon)labelImage.getIcon(), Px.intValue(), Py.intValue());
						}
					}
			});

		addMouseListener(new MouseAdapter()
			{

				@Override
				public void mousePressed(MouseEvent arg0)
					{
					// TODO Auto-generated method stub
					// labelImage.setBorder(BorderFactory.createLineBorder(Color.BLACK,
					// 1));
					colorRect = Color.WHITE;
					colorFRect = Tools.COLOR_CASE_CLICK_INGREDIENT;
					repaint();
					}

				@Override
				public void mouseReleased(MouseEvent arg0)
					{
					// TODO Auto-generated method stub
					// labelImage.setBorder(null);
					colorRect = Color.BLACK;
					colorFRect = Tools.COLOR_CASE_INGREDIENT;
					repaint();
					}
			});
		}

	private void appearance()
		{
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelImage;
	private JPanelRecette panelRecette;
	private int id;
	private int xSourisClick;
	private int ySourisClick;
	private int x;
	private int y;
	private Point pO;

	// shadow
	protected int strokeSize = 1;
	protected Color shadowColor = Color.black;
	protected boolean shady = true;
	protected boolean highQuality = true;
	protected Dimension arcs = new Dimension(0, 0);
	// protected Dimension arcs = new Dimension(20, 20);//creates curved borders
	// and panel
	protected int shadowGap = 5;
	protected int shadowOffset = 4;
	private Color colorRect;
	private Color colorFRect;
	}
