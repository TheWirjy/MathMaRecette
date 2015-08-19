
package mathmarecette;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JLabelIngredient extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JLabelIngredient(JPanelRecette _panelRecette, JPanelIngredients _panelIngredients)
		{
		this.panelRecette = _panelRecette;
		this.panelIngredients = _panelIngredients;
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
		boxV.add(Box.createVerticalStrut(5));
		boxV.add(labelQuantite);

			// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

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
					numQuestion++;
					panelRecette.getJPanelJeu().getLabelQuestion().setText("<html><body><center><p>"+panelRecette.getListQuestion().get(numQuestion)+"</p></center></body></html>");
					panelRecette.getJPanelJeu().getLabelCasserole().setText(labelQuantite.getText());
					panelIngredients.setIngredient(panelRecette.gettabReponse()[numQuestion]);
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
	}
