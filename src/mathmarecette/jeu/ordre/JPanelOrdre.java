
package mathmarecette.jeu.ordre;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelOrdre extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelOrdre(int _id, int x, ImageIcon image, String nom)
		{
		this.id = _id;
		this.id_pos = _id;
		this.x = x;
		this.nom = nom;
		this.image = image;

		geometry();
		control();
		appearance();

		setLocation(x, 0);
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
		this.labelNom = new JLabel("<html><body><p align=\"center\">"+ this.nom +"</p></body></html>");
		this.labelNom.setOpaque(true);
		this.labelNom.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelNom.setVerticalAlignment(SwingConstants.CENTER);
		this.labelNom.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		this.labelNom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.labelNom.setBackground(new Color(119,114,105));


		this.labelNom.setSize(100, 50);
		this.labelNom.setLocation(0, 0);

		this.labelImage = new JLabel();

		this.labelImage.setOpaque(true);
		this.labelImage.setSize(100, 100);
		this.labelImage.setLocation(0, 50);
		this.labelImage.setIcon(image);
		this.labelImage.setBackground(new Color(145,139,126));
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
	private int x;
	private ImageIcon image;
	private static final ImageIcon IMG = new ImageIcon(".\\image\\ordre\\test.png");
	private JLabel labelImage;
	private JLabel labelNom;
	private String nom;
	}
