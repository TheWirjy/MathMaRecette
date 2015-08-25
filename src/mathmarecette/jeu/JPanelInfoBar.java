
package mathmarecette.jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelInfoBar extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelInfoBar()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setTitre(String titre)
	{
		labelTitre.setText(titre);
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
		labelTitre = new JLabel("Recette");

		setSize(new Dimension(650, 50));
		setLocation(0, 0);

			// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
			add(labelTitre);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		labelTitre.setFont(new Font("Verdana", 1, 20));
		setBackground(new Color(119,114,105));
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelTitre;
	}
