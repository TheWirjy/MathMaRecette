package mathmarecette;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelLevel extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelLevel()
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

		level1 = new JButton("Spaghetti");
		level2 = new JButton("Pâte à Crêpe ");
		level3 = new JButton("Cake au Citron ");
		level4 = new JButton("Salade");
		level5 = new JButton("Pizza au jambon ");

		// JComponent : Adaptation

		level1.setPreferredSize(new Dimension(100, 30));
		level2.setPreferredSize(new Dimension(100, 30));
		level3.setPreferredSize(new Dimension(100, 30));
		level4.setPreferredSize(new Dimension(100, 30));
		level5.setPreferredSize(new Dimension(100, 30));

		// JComponent : Layout

		setLayout(new GridLayout(5, 1, 10, 10));
		add(level1);
		add(level2);
		add(level3);
		add(level4);
		add(level5);

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		Dimension panelD = new Dimension(500, 500);
		this.setPreferredSize(panelD);
		this.setMaximumSize(panelD);
		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	JButton level1;
	JButton level2;
	JButton level3;
	JButton level4;
	JButton level5;

	}
