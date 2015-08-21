
package mathmarecette.jeu;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JLabelIngredient extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JLabelIngredient(JPanelRecette _panelRecette, JPanelIngredients _panelIngredients, JFrame jframe, int _id)
		{
		this.panelRecette = _panelRecette;
		this.panelIngredients = _panelIngredients;
		this.jframe = jframe;
		this.id = _id;
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

	public void setIngredient(Ingredient ingr)
		{
		this.labelImage.setIcon(new ImageIcon(ingr.getImage()));
		this.labelQuantite.setText(ingr.getQuantite());
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		labelImage = new JLabel("");
		labelQuantite = new JLabel("");

		Box boxV = Box.createVerticalBox();
		boxV.add(labelImage);
		//boxV.add(Box.createVerticalStrut(5));
		//boxV.add(labelQuantite);

		FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
		setLayout(flowlayout);

		// JComponent : add
		add(boxV);
		}

	private void control()
		{
		// rien
		addMouseListener(new MouseAdapter()
			{

				@Override
				public void mouseClicked(MouseEvent e)
					{
					// TODO Auto-generated method stub
					if (id == panelRecette.getTabSolution()[numQuestion])
						{
						System.out.println("Correct");
						}
					else
						{
						System.out.println("faux");
						}

					numQuestion++;
					panelRecette.getJPanelJeu().getLabelQuestion().setText("<html><body><center><p>" + panelRecette.getListQuestion().get(numQuestion) + "</p></center></body></html>");
					panelRecette.getJPanelJeu().getLabelCasserole().setText(labelQuantite.getText());
					panelIngredients.setIngredient(panelRecette.gettabReponse()[numQuestion]);

					switch(numQuestion)
						{
						case 4:
							new JDialogAnnonceRecette(jframe, "Crêpes", "4 questions");
							break;
						case 8:
							new JDialogAnnonceRecette(jframe, "Cake au citron", "5 questions");
							break;
						case 12:
							new JDialogAnnonceRecette(jframe, "Pizza", "7 questions");
							break;
						case 20:
							new JDialogAnnonceRecette(jframe, "Salade", "7 questions");
							break;
						}
					}
			});
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelImage;
	private JLabel labelQuantite;
	private JPanelRecette panelRecette;
	private JPanelIngredients panelIngredients;
	private static int numQuestion = 0;
	private JFrame jframe;
	private int id;
	}
