
package mathmarecette.jeu.medaille;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JFrameMedaille extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 *
	 */
	private static final long serialVersionUID = -628107275995716805L;

	public JFrameMedaille()
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

		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);

		// JComponent : add
		//add(TODO,BorderLayout.CENTER);
		add(new JPanelMedaille(), BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		pack();
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		new JFrameMedaille();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
