
package mathmarecette.jeu.volume;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import mathmarecette.Tools;

public class JPanelVolume extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelVolume()
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
		volume = new JSlider();
		volumeActuel = new JLabel("5");

		volume.setValue(5);
		volume.setMaximum(5);
		volume.setMinimum(1);

		add(volume);
		add(volumeActuel);

		}

	private void control()
		{
		volume.addChangeListener(new ChangeListener()
			{

				@Override
				public void stateChanged(ChangeEvent e)
					{
					// TODO Auto-generated method stub
					volumeActuel.setText(volume.getValue() + "");
					Tools.setVolumeSon(volume.getValue());
					}
			});
		}

	private void appearance()
		{
		Dimension panelD = new Dimension(250, 60);
		this.setSize(panelD);
		this.setPreferredSize(panelD);
		this.setMaximumSize(panelD);
		setOpaque(false);

		volume.setSize(180, 50);
		volume.setLocation(0, 0);
		volume.setOpaque(false);

		volumeActuel.setSize(50, 50);
		volumeActuel.setLocation(245, 60);

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JSlider volume;
	private JLabel volumeActuel;
	}
