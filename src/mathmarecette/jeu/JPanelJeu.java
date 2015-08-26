
package mathmarecette.jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelJeu extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelJeu()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setQuestion(String question)
		{
		labelQuestion.setText("<html><body><p align=\"center\">" + question + "</p></body></html>");
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public JLabel getLabelQuestion()
		{
		return labelQuestion;
		}

	public JPanelBarResult getJPanelBarResult()
		{
		return panelBarResult;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		g.drawImage(imageCuisine, 0, 0, null);
		}

	private void geometry()
		{

		labelQuestion = new JLabel();
		panelBarResult = new JPanelBarResult();

		setLayout(null);
		setSize(new Dimension(600, 530));
		setLocation(0, 50);

		// JComponent : add
		add(labelQuestion);
		add(panelBarResult);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		imageCuisine = new ImageIcon(".\\image\\kitchen.png").getImage();

		labelQuestion.setOpaque(false);
		Font font = new Font("Arial", 1, 14);
		labelQuestion.setFont(font);
		labelQuestion.setForeground(Color.black);
		labelQuestion.setSize(560, 56);
		labelQuestion.setLocation(24, 16);
		labelQuestion.setVerticalAlignment(SwingConstants.CENTER);
		labelQuestion.setHorizontalAlignment(SwingConstants.CENTER);

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelQuestion;
	private Image imageCuisine;
	private JPanelBarResult panelBarResult;
	}
