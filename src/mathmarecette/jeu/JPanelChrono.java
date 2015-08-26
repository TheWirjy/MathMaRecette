
package mathmarecette.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JPanelChrono extends JPanel
	{

	public JPanelChrono()
		{
		geometry();
		control();
		appearance();
		}

	private void appearance()
		{
		// TODO Auto-generated method stub
		setSize(600, 50);
		setLocation(0,0);
		}

	private void control()
		{
		int delais = 1000;
		ActionListener tache_timer;

		tache_timer = new ActionListener()
			{

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
					label1.setText(+minute + ":" + seconde);/* rafraichir le label */
					}
			};

		final Timer timer1 = new Timer(delais, tache_timer);

		debut.addActionListener(new ActionListener()
			{

				public void actionPerformed(ActionEvent e)
					{
					String texte;
					texte = debut.getText();
					if (texte.compareTo("Start") == 0)
						{
						debut.setText("Stop ");
						timer1.start();
						}
					else if (texte.compareTo("Stop ") == 0)
						{
						debut.setText("Start");
						timer1.stop();
						}
					}
			});

		}

	public void setTitre(String titre)
	{
	recette.setText(titre);
	}

	private void geometry()
		{
		boxH=Box.createHorizontalBox();
		label1 = new JLabel(minute + ":" + seconde);
		debut = new JButton("Start");
		recette = new JLabel("Recette");
		recette.setFont(new Font("Serif", Font.BOLD, 38));
		recette.setForeground(new Color(0,0,128));

		recette.setForeground(Color.BLUE);
		quit = new JButton("");
		quit.setIcon(new ImageIcon("images/b.png"));

		boxH.add(quit);
		boxH.add(Box.createHorizontalStrut(100));

		boxH.add(recette);
		boxH.add(Box.createHorizontalStrut(100));

		boxH.add(label1);
		boxH.add(Box.createHorizontalStrut(100));

		boxH.add(debut);

		setLayout(new BorderLayout());
		add(boxH,BorderLayout.CENTER);

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

	private static int minute = 0;
	private static int seconde = 0;
	private JLabel label1;
	private JLabel recette;
	private JButton debut;
	private JButton quit;
	private Box boxH;

	}
