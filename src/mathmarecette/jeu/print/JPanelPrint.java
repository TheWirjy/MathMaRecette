
package mathmarecette.jeu.print;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import mathmarecette.Tools;

public class JPanelPrint extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 *
	 * @param parent : jframeMenu, frame de base
	 * @param file : fichier pdf
	 * @param preview : image du fichier pdf (preview avant impression)
	 */
	public JPanelPrint(JFramePrint parent, String file, ImageIcon preview)
		{
		this.file = file;
		this.preview = preview;
		this.parent = parent;
		geometry();
		control();
		appearance();

		refreshPrint();
		}

	//maj les document pdf et image preview en fonction de la recette que l on souhaite imprimer
	public void setParam(String file, ImageIcon preview)
		{
		this.file = file;
		this.preview = preview;
		refreshPrint();
		repaint();
		}

	//refresh la liste des imprimante et set le document a imprimer
	private void refreshPrint()
		{
		//recupere les imprimante
		services = getPrinteuse();
		//nettoie la liste des imprimante
		listImprimante.removeAllItems();
		//si le fichier pdf existe
		if (services != null)
			{
			//si il existe des imprimante
			if (services.length > 0)
				{
				//affiche les imprimante dans la liste
				for(int i = 0; i < services.length; i++)
					{
					listImprimante.addItem(services[i].toString());
					}
				//permet l impression
				buttonImprimer.setEnabled(true);
				}
			else
				{
				//affiche qu il n y a pas d imprimante
				listImprimante.addItem("pas d imprimante");
				//bloque l impression
				buttonImprimer.setEnabled(false);
				}
			}
		else
			{
			//affiche une erreur fichier pdf
			listImprimante.addItem("Erreur fichier");
			//bloque l impression
			buttonImprimer.setEnabled(false);
			}
		}

	//set le document et recupere les imprimante si le document est valider
	private PrintService[] getPrinteuse()
		{
		try
			{
			//recupere le pdf
			psStream = new FileInputStream(this.file);
			}
		catch (FileNotFoundException ffne)
			{
			System.out.println("File non trouvé");
			}

		//si pas de fichier pdf retourne null
		if (psStream == null) { return null; }

		//set le pdf
		psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		myDoc = new SimpleDoc(psStream, psInFormat, null);
		aset = new HashPrintRequestAttributeSet();
		//recupere les imprimante
		PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);

		//retourne les imprimante
		return services;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// ANTI ALIASING
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//AFFICHE L IMAGE DE PREVIEW AVEC UN EFFET D OMBRE
		g2.setColor(Color.GRAY);
		g2.fillRect(65, 65, 480, 600);
		g2.drawImage(preview.getImage(), 60, 60, null);

		g2.setColor(Color.BLACK);
		g2.drawRect(60, 60, 480, 600);
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
		listImprimante = new JComboBox<String>();
		buttonImprimer = new JButton("Imprimer");
		buttonRefresh = new JButton("Rafraîchir");

		// JComponent : add
		add(listImprimante);
		add(buttonImprimer);
		add(buttonRefresh);
		add(buttonRefresh);
		}

	private void control()
		{
		buttonRefresh.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					refreshPrint();
					}
			});

		buttonImprimer.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					PrintService myPrinter = services[listImprimante.getSelectedIndex()];
					System.out.println(listImprimante.getSelectedIndex() + "");
					if (myPrinter != null)
						{
						DocPrintJob job = myPrinter.createPrintJob();
						try
							{
							job.print(myDoc, aset);
							}
						catch (Exception pe)
							{
							System.out.println("erreur d impression");
							}
						}
					else
						{
						System.out.println("erreur d impression");
						}

					parent.dispose();
					}
			});
		}

	private void appearance()
		{
		Dimension dim = new Dimension(600, 700);
		setPreferredSize(dim);
		setSize(dim);
		setMaximumSize(dim);
		setBackground(Tools.COLOR_MUR);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JComboBox<String> listImprimante;
	private JButton buttonImprimer;
	private JButton buttonRefresh;
	private String file;
	private PrintService[] services;
	private FileInputStream psStream;
	private DocFlavor psInFormat;
	private Doc myDoc;
	private PrintRequestAttributeSet aset;
	private ImageIcon preview;
	private JFramePrint parent;
	}
