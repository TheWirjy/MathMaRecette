package mathmarecette.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelCredits extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelCredits()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		credits = new JLabel("Projet d'HES d'été");
		wassim = new JLabel("Ajjali Wassim");
		jeremy = new JLabel("Wirth Jeremy");
		schaffo = new JLabel("Schaffo Raphaël");

		Box colomn = Box.createVerticalBox();
		colomn.add(credits);
		colomn.add(wassim);
		colomn.add(jeremy);
		colomn.add(schaffo);

		// JComponent : add
		add(colomn,BorderLayout.CENTER);

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		Dimension panelD = new Dimension(200, 150);
		this.setPreferredSize(panelD);
		this.setMaximumSize(panelD);
		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	JLabel credits;
	JLabel wassim;
	JLabel schaffo;
	JLabel jeremy;

	}