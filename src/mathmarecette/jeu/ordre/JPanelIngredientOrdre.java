
package mathmarecette.jeu.ordre;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mathmarecette.Tools;

public class JPanelIngredientOrdre extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 *
	 */
	private static final long serialVersionUID = -6946919024948969270L;

	/**
	 *
	 * @param _id : id unique du panel
	 * @param id_ordre : id permet de recuperer la position du panel
	 * @param x : position horizontal
	 * @param image : image du panel (ingredient)
	 * @param nom : nom du panel (l'action)
	 */
	public JPanelIngredientOrdre(int _id, int id_ordre, int x, ImageIcon image, String nom)
		{
		this.id = _id;
		this.id_pos = _id;
		this.x = x;
		this.nom = nom;
		this.image = image;
		this.id_ordre = id_ordre;

		geometry();
		control();
		appearance();

		setLocation(x, 100);
		setSize(100, 150);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public int getID()
		{
		return id;
		}

	public int getID_pos()
		{
		return id_pos;
		}

	public int getID_ordre()
		{
		return id_ordre;
		}

	public void setID_pos(int id)
		{
		this.id_pos = id;
		}

	public void setPositionX(int x)
		{
		this.x = x;
		}

	public int getPositionX()
		{
		return x;
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
		this.labelNom = new JLabel("<html><body><p align=\"center\">" + this.nom + "</p></body></html>");
		this.labelNom.setOpaque(true);
		this.labelNom.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelNom.setVerticalAlignment(SwingConstants.CENTER);
		this.labelNom.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		this.labelNom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.labelNom.setBackground(Tools.COLOR_PANEL_INGREDIENT);

		this.labelNom.setSize(100, 50);
		this.labelNom.setLocation(0, 0);

		this.labelImage = new JLabel();

		this.labelImage.setOpaque(true);
		this.labelImage.setSize(100, 100);
		this.labelImage.setLocation(0, 50);
		this.labelImage.setIcon(image);
		this.labelImage.setBackground(Tools.COLOR_BAR);
		this.labelImage.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelImage.setVerticalAlignment(SwingConstants.CENTER);
		this.labelImage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		setLayout(null);

		// JComponent : add
		add(labelNom);
		add(labelImage);

		}

	private void control()
		{

		}

	private void appearance()
		{

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private int id_pos;
	private int id;
	private int id_ordre;
	private int x;
	private ImageIcon image;
	private JLabel labelImage;
	private JLabel labelNom;
	private String nom;
	}
