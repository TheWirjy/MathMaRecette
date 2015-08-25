
package mathmarecette.jeu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JLabelIngredient extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JLabelIngredient(JPanelRecette _panelRecette, int _id)
		{
		this.panelRecette = _panelRecette;
		this.id = _id;
		geometry();
		control();
		appearance();
		colorRect = Color.BLACK;
		colorFRect = COLOR_CASE;
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

		//Draws the rounded opaque panel with borders.
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
		addMouseListener(new MouseAdapter()
			{

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

				@Override
				public void mousePressed(MouseEvent arg0)
					{
					// TODO Auto-generated method stub
					//labelImage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
					colorRect = Color.WHITE;
					colorFRect = COLOR_CLICK;
					repaint();
					click = true;
					dessus = true;
					}

				@Override
				public void mouseReleased(MouseEvent arg0)
					{
					// TODO Auto-generated method stub
					//labelImage.setBorder(null);
					colorRect = Color.BLACK;
					colorFRect = COLOR_CASE;
					repaint();

					if (click && dessus)
						{
						panelRecette.reponseValider(id);
						}
					click = false;
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

	//shadow
	protected int strokeSize = 1;
	protected Color shadowColor = Color.black;
	protected boolean shady = true;
	protected boolean highQuality = true;
	protected Dimension arcs = new Dimension(0, 0);
	//protected Dimension arcs = new Dimension(20, 20);//creates curved borders and panel
	protected int shadowGap = 5;
	protected int shadowOffset = 4;
	private Color colorRect;
	private Color colorFRect;
	private static final Color COLOR_CLICK = new Color(173, 173, 173);
	private static final Color COLOR_CASE = new Color(205, 204, 205);
	private boolean click = false;
	private boolean dessus = false;
	}
