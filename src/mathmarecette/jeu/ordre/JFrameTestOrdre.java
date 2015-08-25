
package mathmarecette.jeu.ordre;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameTestOrdre extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameTestOrdre()
		{
		label = new JLabelOrdre[4];

		ordre = new int[4];
		ordre[0] = 2;
		ordre[1] = 0;
		ordre[2] = 3;
		ordre[3] = 1;

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
						if ((((JLabelOrdre)e.getSource()).getX() - ((JLabelOrdre)e.getSource()).getPositionX()) > 40)
							{
							if (((JLabelOrdre)e.getSource()).getID_pos() + 1 < label.length)
								{
								swapLabel(((JLabelOrdre)e.getSource()).getID_pos(), ((JLabelOrdre)e.getSource()).getID_pos() + 1);
								}
							}

						if ((((JLabelOrdre)e.getSource()).getX() - ((JLabelOrdre)e.getSource()).getPositionX()) < -40)
							{
							if (((JLabelOrdre)e.getSource()).getID_pos() - 1 > -1)
								{
								swapLabel(((JLabelOrdre)e.getSource()).getID_pos(), ((JLabelOrdre)e.getSource()).getID_pos() - 1);
								}
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
						((JLabelOrdre)e.getSource()).setLocation(((JLabelOrdre)e.getSource()).getPositionX(), 0);
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

	public void swapLabel(int i1, int i2)
		{
		label[i2].setLocation(label[i1].getPositionX(), 0);

		int tmp = label[i2].getID_pos();
		label[i2].setID_pos(label[i1].getID_pos());
		label[i1].setID_pos(tmp);

		tmp = label[i2].getPositionX();
		label[i2].setPositionX(label[i1].getPositionX());
		label[i1].setPositionX(tmp);

		JLabelOrdre temp = label[i1];
		label[i1] = label[i2];
		label[i2] = temp;
		repaint();
		}

	public void checkOrdre()
		{
		String txt = "";
		for(JLabelOrdre jLabelOrdre:label)
			{
			txt += jLabelOrdre.getID() + " ";
			}
		boolean bOrdrer = true;
		for(int i = 0; i < label.length; i++)
			{
			if (label[i].getID() != ordre[i])
				{
				bOrdrer = false;
				}
			}

		labelReponse.setText(txt + " " + bOrdrer);
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
		JButton buttonV = new JButton("Valider");
		buttonV.setLocation(50, 200);
		buttonV.setSize(150, 30);
		buttonV.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					checkOrdre();
					}
			});

		labelReponse = new JLabel("1 4 5 8");
		labelReponse.setSize(250, 50);
		labelReponse.setLocation(50, 100);
			// Layout : Specification
			{
			setLayout(null);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		for(int i = 0; i < 4; i++)
			{
			add(label[i]);
			}

		add(buttonV);
		add(labelReponse);

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

	private JLabelOrdre[] label;
	private int[] ordre;
	private int xSourisClick;
	private JLabel labelReponse;

	public static void main(String[] args)
		{
		new JFrameTestOrdre();
		}
	}
