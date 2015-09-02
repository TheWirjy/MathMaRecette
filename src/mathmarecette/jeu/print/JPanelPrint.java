
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

	private void refreshPrint()
		{
		services = getPrinteuse();
		listImprimante.removeAllItems();
		if (services != null)
			{
			if (services.length > 0)
				{
				for(int i = 0; i < services.length; i++)
					{
					listImprimante.addItem(services[i].toString());
					}
				buttonImprimer.setEnabled(true);
				}
			else
				{
				listImprimante.addItem("pas d imprimante");
				buttonImprimer.setEnabled(false);
				}
			}
		else
			{
			listImprimante.addItem("Erreur fichier");
			buttonImprimer.setEnabled(false);
			}
		}

	private PrintService[] getPrinteuse()
		{
		try
			{
			psStream = new FileInputStream(this.file);
			}
		catch (FileNotFoundException ffne)
			{
			System.out.println("File non trouvé");
			}

		if (psStream == null) { return null; }

		psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		myDoc = new SimpleDoc(psStream, psInFormat, null);
		aset = new HashPrintRequestAttributeSet();
		PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);

		return services;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/*
		public static void printRecette(String file)
			{
			FileInputStream psStream = null;
			try
				{
				psStream = new FileInputStream(file);
				}
			catch (FileNotFoundException ffne)
				{
				ffne.printStackTrace();
				}

			if (psStream == null) { return; }

			DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
			Doc myDoc = new SimpleDoc(psStream, psInFormat, null);
			PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
			PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);

			// this step is necessary because I have several printers configured
			PrintService myPrinter = null;
			for(int i = 0; i < services.length; i++)
				{

				String svcName = services[i].toString();
				System.out.println("service found: " + svcName);
				if (svcName.contains("PDFCreator"))
					{
					myPrinter = services[i];
					System.out.println("my printer found: " + svcName);
					break;
					}
				}

			if (myPrinter != null)
				{
				DocPrintJob job = myPrinter.createPrintJob();
				try
					{
					job.print(myDoc, aset);
					}
				catch (Exception pe)
					{
					pe.printStackTrace();
					}
				}
			else
				{
				System.out.println("no printer services found");
				}
			}
	*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// ANTI ALIASING
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

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
