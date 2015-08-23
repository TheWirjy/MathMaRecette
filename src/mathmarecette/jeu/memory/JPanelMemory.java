
package mathmarecette.jeu.memory;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelMemory extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelMemory(final JDialogMemory dialog)
		{
		this.dialog = dialog;

		mapFamille = new HashMap<Integer, Integer>();
		mapFamille.put(0, 2);
		mapFamille.put(1, 8);
		mapFamille.put(3, 6);
		mapFamille.put(4, 7);
		mapFamille.put(5, 11);
		mapFamille.put(9, 10);
		mapFamille.put(12, 15);
		mapFamille.put(13, 14);

		mapFamille.put(2, 0);
		mapFamille.put(8, 1);
		mapFamille.put(6, 3);
		mapFamille.put(7, 4);
		mapFamille.put(11, 5);
		mapFamille.put(10, 9);
		mapFamille.put(15, 12);
		mapFamille.put(14, 13);

		tabB = new String[16];
		tabB[0] = "6*2";
		tabB[1] = "-10";
		tabB[2] = "12";
		tabB[3] = "8/8";
		tabB[4] = "16/4";
		tabB[5] = "5*12*0";
		tabB[6] = "1";
		tabB[7] = "4";
		tabB[8] = "1-11";
		tabB[9] = "10/1";
		tabB[10] = "10";
		tabB[11] = "0";
		tabB[12] = "50";
		tabB[13] = "6/3";
		tabB[14] = "2";
		tabB[15] = "5*10";

		tabLabel = new JLabelCarte[16];

		dialog.setBlur();

		Box b = Box.createVerticalBox();
		int cpt = 0;
		for(int i = 0; i < 4; i++)
			{
			Box bb = Box.createHorizontalBox();

			for(int j = 1; j <= 4; j++)
				{
				JLabelCarte label = new JLabelCarte(cpt, this);
				tabLabel[cpt] = label;
				bb.add(label);
				cpt++;
				}
			b.add(bb);
			}

		add(b);

		JPanel buttonPane = new JPanel();
		button = new JButton("OK");
		button.setEnabled(false);
		buttonPane.add(button, BorderLayout.CENTER);
		button.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					setVisible(false);
					dialog.dispose();
					dialog.setBlurOff();
					//parent.setContentPane(panel);
					}
			});

		add(buttonPane, BorderLayout.SOUTH);

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void verification(int id)
		{
		if (mapFamille.get(id) == JLabelCarte.idA)
			{
			tabLabel[id].isFound();
			tabLabel[JLabelCarte.idA].isFound();
			cptFamille++;
			if (cptFamille == 8)
				{
				button.setEnabled(true);
				}
			}
		}

	public void cacherCarte()
		{
		for(int i = 0; i < 16; i++)
			{
			if(tabLabel[i].getFound() == false && tabLabel[i].getReturn())
				{
				tabLabel[i].cacher();
				}
			}
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

			// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Map<Integer, Integer> mapFamille;
	private String[] tabB;
	private JLabelCarte[] tabLabel;
	private int cptFamille = 0;
	private JButton button;
	private JDialogMemory dialog;
	}
