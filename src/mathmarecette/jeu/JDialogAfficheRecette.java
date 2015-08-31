
package mathmarecette.jeu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class JDialogAfficheRecette extends JDialog
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JDialogAfficheRecette(final JFrame parent, ImageIcon image)
		{
		super(parent, "Spaghetti", true);
		if (parent != null)
			{
			Dimension parentSize = parent.getSize();
			Point p = parent.getLocation();
			setLocation(p.x + parentSize.width / 2 - 200, p.y + parentSize.height / 2-250);
			}

		setLocation(800, 200);

		//setLocationRelativeTo(null);
		JLabel labelImage = new JLabel(image);
		labelImage.setSize(400, 500);
	    getContentPane().add(labelImage);

	    JPanel buttonPane = new JPanel();
	    JButton button = new JButton("OK");
	    buttonPane.add(button, BorderLayout.CENTER);
	    button.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					setVisible(false);
				    dispose();
					}
			});

	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    pack();
	    setVisible(true);
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

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}

