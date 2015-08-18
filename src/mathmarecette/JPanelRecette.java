
package mathmarecette;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelRecette extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelRecette()
		{
		tableauIngredient = new Ingredient[4][];
		for(int i = 0; i < tableauIngredient.length; i++)
			{
			tableauIngredient[i] = new Ingredient[4];
			}

		createTableauQuestions();

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	private void createTableauQuestions()
		{
		createQuestion(0, "1/4 #", "1/4 de pomme", "1/2 #", "1/2 pomme", "3 #", "3 pomme", "8 #", "8 pomme");
		createQuestion(1, "1/4 *", "1/4 orange", "1/2 *", "1/2 orange", "3 *", "3 orange", "8 *", "8 orange");
		}

	private void createQuestion(int numQuestion, String img1, String q1, String img2, String q2, String img3, String q3, String img4, String q4)
		{
		tableauIngredient[numQuestion][0] = new Ingredient(img1, q1);
		tableauIngredient[numQuestion][1] = new Ingredient(img2, q2);
		tableauIngredient[numQuestion][2] = new Ingredient(img3, q3);
		tableauIngredient[numQuestion][3] = new Ingredient(img4, q4);
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
		jpanelIngredients = new JPanelIngredients();
		JButton buttonTest = new JButton("test");
		buttonTest.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					jpanelIngredients.setIngredient(tableauIngredient[1]);
					}
			});

		setLayout(new BorderLayout());

		// JComponent : add
		add(buttonTest, BorderLayout.CENTER);
		add(jpanelIngredients, BorderLayout.SOUTH);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		jpanelIngredients.setIngredient(tableauIngredient[0]);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelIngredients jpanelIngredients;
	Ingredient[][] tableauIngredient;

	}
