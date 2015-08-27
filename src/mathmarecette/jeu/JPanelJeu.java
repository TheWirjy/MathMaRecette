
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

	public JPanelBarEtat getJPanelBarResult()
		{
		return panelBarResult;
		}

	public void setScore(int score)
		{
		labelScore.setText(score+"");
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
		panelBarResult = new JPanelBarEtat();
		labelScore = new JLabel("0");

		setLayout(null);
		setSize(new Dimension(600, 530));
		setLocation(0, 50);

		// JComponent : add
		add(labelQuestion);
		add(panelBarResult);
		add(labelScore);
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

		labelScore.setForeground(Color.RED);
		labelScore.setFont(new Font("Arial", Font.BOLD, 12));
		labelScore.setSize(50, 20);
		labelScore.setLocation(62, 220);
		labelScore.setVerticalAlignment(SwingConstants.CENTER);
		labelScore.setHorizontalAlignment(SwingConstants.CENTER);

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelQuestion;
	private Image imageCuisine;
	private JPanelBarEtat panelBarResult;
	private JLabel labelScore;
	}
