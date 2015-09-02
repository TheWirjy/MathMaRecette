
package mathmarecette.jeu.print;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFramePrint extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 *
	 * @param file : fichier pdf a imprimer
	 * @param preview : image du pdf a afficher servant de preview
	 */

	public JFramePrint(String file, ImageIcon preview)
		{
		geometry(file, preview);
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//recupere l instance de la frame, afin de n'en creer qu une
	//si la frame est deja creer, on set juste les nouveau parametre de la recette et on retourne l instance
	public static JFramePrint getInstance(String file, ImageIcon preview)
		{
		if (instance == null)
			{
			instance = new JFramePrint(file, preview);
			}
		else
			{
			instance.setParam(file, preview);
			instance.setVisible(true);
			}
		return instance;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	//permet de maj les pdf et preview
	private void setParam(String file, ImageIcon preview)
		{
		panelPrint.setParam(file, preview);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry(String file, ImageIcon preview)
		{
		// JComponent : Instanciation
		panelPrint = new JPanelPrint(this, file, preview);

			// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);
			}

		add(panelPrint, BorderLayout.CENTER);

		}

	private void control()
		{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}

	private void appearance()
		{
		setResizable(false);
		pack();
		setLocation(0, 0); // frame centrer
		setVisible(true); // last!
		}

	private static JFramePrint instance;
	private JPanelPrint panelPrint;
	}
