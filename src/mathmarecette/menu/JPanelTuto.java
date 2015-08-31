
package mathmarecette.menu;

import java.awt.Color;
import java.awt.Dimension;
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
		setLayout(null);

		// JComponent : add
		add(labelRetour);
		add(labelDrag);
		add(labelOrdre);
		add(labelHorloge);
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

		labelRetour.setIcon(Tools.BOUTON_RETOUR);
		labelRetour.setSize(35, 35);
		labelRetour.setLocation(10, 10);

		labelDrag.setSize(135, 160);
		labelDrag.setLocation(415, 90);
		labelDrag.setIcon(Tools.GIF_DRAG);
		labelDrag.setBorder(border);

		labelOrdre.setSize(135, 160);
		labelOrdre.setLocation(415, 270);
		labelOrdre.setIcon(Tools.GIF_ORDRE);
		labelOrdre.setBorder(border);

		labelHorloge.setSize(135, 160);
		labelHorloge.setLocation(415, 450);
		labelHorloge.setIcon(Tools.GIF_HORLOGE);
		labelHorloge.setBorder(border);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelDrag;
	private JLabel labelOrdre;
	private JLabel labelHorloge;
	private JLabel labelRetour;
	private boolean click = false;
	private boolean dessus = false;
	private JFrameMenu parent;

	}
