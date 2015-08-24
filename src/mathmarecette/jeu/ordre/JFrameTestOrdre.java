
package mathmarecette.jeu.ordre;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameTestOrdre extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameTestOrdre()
		{
		label = new JLabel[4];

		position = new int[4];
		position[0] = 0;
		position[1] = 80;
		position[2] = 160;
		position[3] = 240;

		for(int i = 0; i < 4; i++)
			{
			JLabelOrdre newLabel = new JLabelOrdre(i, 80 * i);
			newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			label[i] = newLabel;
			label[i].addMouseMotionListener(new MouseMotionListener()
				{

					@Override
					public void mouseMoved(MouseEvent e)
						{
						// TODO Auto-generated method stub

						}

					@Override
					public void mouseDragged(MouseEvent e)
						{
						// TODO Auto-generated method stub
						e.getComponent().setLocation(e.getComponent().getX() + e.getX() - xSourisClick, e.getComponent().getY());
						if (e.getComponent().getX() + 40 > label[((JLabelOrdre)e.getSource()).getID() + 1].getX() + 40)
							{
								int itemp = ((JLabelOrdre)e.getSource()).getID() + 1;
								label[((JLabelOrdre)e.getSource()).getID() + 1] = label[((JLabelOrdre)e.getSource()).getID()];
							}
						}
				});
			label[i].addMouseListener(new MouseAdapter()
				{

					@Override
					public void mousePressed(MouseEvent e)
						{
						xSourisClick = e.getX();
						}

					@Override
					public void mouseReleased(MouseEvent e)
						{
						int x = e.getComponent().getX();

						}
				});
			}

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

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

			// Layout : Specification
			{
			FlowLayout flowLayout = new FlowLayout();
			setLayout(null);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		for(int i = 0; i < 4; i++)
			{
			add(label[i]);
			}

		// JComponent : add
		//add(TODO,BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(600, 400);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools

	private JLabel[] label;
	private int[] reponse;
	private int xSourisClick;
	private int[] position;

	public static void main(String[] args)
		{
		new JFrameTestOrdre();
		}
	}
