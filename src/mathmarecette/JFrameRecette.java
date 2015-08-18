
package mathmarecette;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JFrameRecette extends JFrame
	{

		/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JFrameRecette()
		{
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
			panelRecette = new JPanelRecette();

			// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(panelRecette, BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(600, 800);
		setTitle("Math ma recette");
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	private JPanelRecette panelRecette;
	}
