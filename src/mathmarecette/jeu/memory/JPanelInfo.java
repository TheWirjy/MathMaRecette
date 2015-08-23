
package mathmarecette.jeu.memory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelInfo extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelInfo(final JDialogMemory dialog)
		{
		this.dialog = dialog;
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
		labelText = new JLabel();
		labelText
				.setText("<html><body><center><p align=\"justify\"> Les pâtes sont en train de cuire, tu as 2min pour finir ce jeu du memory avant que les pâtes ne soient prêtes! Pour faire une famille, tu dois réunir deux cartes. Sur l'une d'elle doit se trouver un calcul et sur l'autre la réponse. Bonne chance!</p></center></body></html>");
		labelText.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		button = new JButton("Commencer");

			// Layout : Specification
			{
			setLayout(new BorderLayout());

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(labelText, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		}

	private void control()
		{
		button.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
						dialog.switchPanel();
					}
			});
		}

	private void appearance()
		{
		setPreferredSize(new Dimension(380,300));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelText;
	private JButton button;
	private JDialogMemory dialog;
	}
