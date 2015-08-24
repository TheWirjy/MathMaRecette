
package mathmarecette.jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		labelQuestion.setText("<html><body><center><p>" + question + "</p></center></body></html>");
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

	public JLabel getLabelCasserole()
		{
		return labelCasserole;
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
		labelCasserole = new JLabel("Casserole");
		panelBarResult = new JPanelBarResult();

		setLayout(null);
		setSize(new Dimension(600, 530));
		setLocation(0, 50);

		// JComponent : add
		add(labelQuestion);
		add(labelCasserole);
		add(panelBarResult);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		imageCuisine = new ImageIcon(".\\image\\kitchen.png").getImage();

		labelQuestion.setBackground(new Color(255 ,255,255));
		labelQuestion.setOpaque(false);
		Font font = new Font("Verdana", 1, 16);
		labelQuestion.setFont(font);
		labelQuestion.setForeground(Color.black);
		//labelQuestion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		labelQuestion.setSize(540, 50);
		labelQuestion.setLocation(30, 0);

		labelCasserole.setSize(100, 20);
		labelCasserole.setLocation(300, 400);

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelQuestion;
	private JLabel labelCasserole;
	private Image imageCuisine;
	private JPanelBarResult panelBarResult;
	}
