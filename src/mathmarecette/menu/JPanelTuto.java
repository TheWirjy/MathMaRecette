
package mathmarecette.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import mathmarecette.Tools;

public class JPanelTuto extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 *
	 */
	private static final long serialVersionUID = -2031343329085314683L;

	public JPanelTuto(JFrameMenu _parent)
		{
		this.parent = _parent;
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
		labelDrag = new JLabel();
		labelHorloge = new JLabel();
		labelOrdre = new JLabel();
		labelRetour = new JLabel();
		labelDragText = new JLabel();
		labelOrdreText = new JLabel();
		labelHorlogeText = new JLabel();
		labelTitre = new JLabel();

		setLayout(null);

		// JComponent : add
		add(labelTitre);
		add(labelRetour);
		add(labelDrag);
		add(labelOrdre);
		add(labelHorloge);
		add(labelDragText);
		add(labelOrdreText);
		add(labelHorlogeText);
		}

	private void control()
		{
		labelRetour.addMouseListener(new MouseAdapter()
			{

				@Override
				public void mouseReleased(MouseEvent e)
					{
					// TODO Auto-generated method stub
					labelRetour.setIcon(Tools.BOUTON_RETOUR);
					if (click && dessus)
						{
						parent.menu(JPanelTuto.this);
						}
					click = false;
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
					// TODO Auto-generated method stub
					click = true;
					dessus = true;
					labelRetour.setIcon(Tools.BOUTON_RETOUR_CLICK);
					}

				@Override
				public void mouseExited(MouseEvent e)
					{
					// TODO Auto-generated method stub
					dessus = false;
					}

				@Override
				public void mouseEntered(MouseEvent e)
					{
					// TODO Auto-generated method stub
					dessus = true;
					}
			});
		}

	private void appearance()
		{
		Dimension panelD = new Dimension(600, 700);
		this.setSize(panelD);
		this.setPreferredSize(panelD);
		this.setMaximumSize(panelD);
		setBackground(Tools.COLOR_MUR);

		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

		labelTitre.setSize(230, 60);
		labelTitre.setLocation(300-115, 20);
		labelTitre.setIcon(Tools.TITRE_TUTO);

		labelRetour.setIcon(Tools.BOUTON_RETOUR);
		labelRetour.setSize(35, 35);
		labelRetour.setLocation(10, 10);

		labelDrag.setSize(135, 160);
		labelDrag.setLocation(430, 130);
		labelDrag.setIcon(Tools.GIF_DRAG);
		labelDrag.setBorder(border);

		labelOrdre.setSize(135, 160);
		labelOrdre.setLocation(430, 310);
		labelOrdre.setIcon(Tools.GIF_ORDRE);
		labelOrdre.setBorder(border);

		labelHorloge.setSize(135, 160);
		labelHorloge.setLocation(430, 490);
		labelHorloge.setIcon(Tools.GIF_HORLOGE);
		labelHorloge.setBorder(border);

		font = new Font("Segoe Print", Font.PLAIN, 12);

		labelDragText.setSize(370, 160);
		labelDragText.setLocation(30, 130);
		labelDragText.setFont(font);
		labelDragText
				.setText("<html><body><p align=\"justify\">Ici tu as une question et quatre possibilitées de réponse. Pour répondre, tu dois cliquer (maintenir enfoncé la touche) sur un alimant. Ensuite tu dois le déplacer sur la table et relaché le bouton pour validé ton choix.</p></body></html>");

		labelOrdreText.setSize(370, 160);
		labelOrdreText.setLocation(30, 310);
		labelOrdreText.setFont(font);
		labelOrdreText
				.setText("<html><body><p align=\"justify\">Dans ce mini jeu, tu dois mettre dans l'ordre les actions qui compose la recette. Pour déplacer une action, tu dois cliquer (maintenir la touche enfoncée) sur une \"carte\" et la déplacée de gauche à droite. Relâche le bouton pour validé la position. Le jeu t'indique le nombre d'action qui sont bien placé lorsque tu valide une réponse mais tu ne sais pas lesquelles. Tu as 4 essais.</p></body></html>");

		labelHorlogeText.setSize(370, 160);
		labelHorlogeText.setLocation(30, 490);
		labelHorlogeText.setFont(font);
		labelHorlogeText
				.setText("<html><body><p align=\"justify\">Le but ici est de mettre l'horloge à l'heure. Pour dépacer une aiguille, tu dois maintenir presser le bouton de la souris, déplacer l'aiguille puis relâcher pour valider<br/>Clique gauche : Heures<br/>Clique droit : Minutes</p></body></html>");
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelDrag;
	private JLabel labelOrdre;
	private JLabel labelHorloge;
	private JLabel labelRetour;
	private JLabel labelTitre;
	private JLabel labelDragText;
	private JLabel labelOrdreText;
	private JLabel labelHorlogeText;

	private boolean click = false;
	private boolean dessus = false;
	private JFrameMenu parent;
	private Font font;
	}
