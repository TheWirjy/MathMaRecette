package mathmarecette.jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mathmarecette.Tools;

public class JPanelJeu extends JPanel {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 5397251654976575668L;
	public JPanelJeu(JPanelRecette panelRecette) {
		this.panelRecette = panelRecette;
		this.labelIngredient = new JLabelIngredient[4];
		labelIngredientTable = new JLabel[8];
		geometry();
		control();
		appearance();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void initialisation() {
		removeAll();
		imageCuisine = CUISINE.getImage();
		labelScore.setText("0");
		labelQuestion.setText("");
		panelBarResult.initialisation(0);
		labelScore.setVisible(true);

		for (JLabel ingr : labelIngredientTable) {
			ingr.setIcon(null);
			ingr.setVisible(true);
		}

		for (int i = 0; i < 4; i++) {
			labelIngredient[i].setIngredient(null);
			labelIngredient[i].setEnabled(false);
			labelIngredient[i].setVisible(false);
		}

		for (int i = 0; i < labelIngredient.length; i++) {
			add(labelIngredient[i]);
			setComponentZOrder(labelIngredient[i], i);
		}

		// JComponent : add
		add(panelIntroRecette);
		setComponentZOrder(panelIntroRecette, 4);
		add(labelQuestion);
		setComponentZOrder(labelQuestion, 5);
		add(panelBarResult);
		setComponentZOrder(panelBarResult, 6);
		add(labelScore);
		setComponentZOrder(labelScore, 7);

		int cpt = 8;

		for (int i = labelIngredientTable.length - 1; i >= 0; i--) {
			add(labelIngredientTable[i]);
			setComponentZOrder(labelIngredientTable[i], cpt);
			cpt++;
		}
	}

	public void setIngredient(ImageIcon[] ingredient) {
		for (int i = 0; i < ingredient.length; i++) {
			labelIngredient[i].setIngredient(ingredient[i]);
		}
	}

	public void addIngr(ImageIcon icon, int indice, int x, int y) {
		labelIngredientTable[indice].setIcon(icon);
		labelIngredientTable[indice].setLocation(x, y);
	}

	public void setQuestion(String question) {
		labelQuestion.setText("<html><body><p align=\"center\">" + question
				+ "</p></body></html>");
	}

	public void setSplash(ImageIcon image) {
		panelIntroRecette.setVisible(true);
		panelIntroRecette.setSplash(image);
		imageCuisine = CUISINE_FLOU.getImage();
	}

	public void removeSplash() {
		imageCuisine = CUISINE.getImage();
		repaint();
	}

	public void startRecette() {
		panelRecette.startRecette();
		removeSplash();
		for (int i = 0; i < 4; i++) {
			labelIngredient[i].setEnabled(true);
			labelIngredient[i].setVisible(true);
		}
	}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public JLabel getLabelQuestion() {
		return labelQuestion;
	}

	public JPanelBarEtat getJPanelBarResult() {
		return panelBarResult;
	}

	public void setScore(int score) {
		labelScore.setText(score + "");
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	public void hideForMiniJeu() {
		for (JLabelIngredient label : labelIngredient) {
			label.setVisible(false);
		}
		for (JLabel ingr : labelIngredientTable) {
			ingr.setVisible(false);
		}
		labelScore.setVisible(false);
		labelQuestion.setVisible(false);
		imageCuisine = CUISINE_FLOU.getImage();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// ANTI ALIASING
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.drawImage(imageCuisine, 0, 0, null);
		g2.drawLine(0, 530, 600, 530);
	}

	private void geometry() {

		labelQuestion = new JLabel();
		panelBarResult = new JPanelBarEtat();
		labelScore = new JLabel();
		panelIntroRecette = new JPanelIntroRecette(this);

		Dimension dim = new Dimension(80, 80);

		for (int i = 0; i < labelIngredientTable.length; i++) {
			labelIngredientTable[i] = new JLabel();
			labelIngredientTable[i].setPreferredSize(dim);
			labelIngredientTable[i].setSize(dim);
		}

		setLayout(null);

		// JComponent : add

		setLayout(null);
		setSize(new Dimension(600, 660));
		setLocation(0, 50);

		for (int i = 0; i < labelIngredient.length; i++) {
			Point p = new Point(getWidth() / 2 - (2 * 90 + 15) + i * 90 + i
					* 10, 545);
			labelIngredient[i] = new JLabelIngredient(panelRecette, i + 1, p);
		}
	}

	private void control() {
		// rien
	}

	private void appearance() {

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

		setBackground(Tools.COLOR_PANEL_INGREDIENT);

	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabelIngredient[] labelIngredient;
	private JLabel labelQuestion;
	private Image imageCuisine;
	private JPanelBarEtat panelBarResult;
	private JLabel labelScore;
	private JPanelIntroRecette panelIntroRecette;
	private static final ImageIcon CUISINE_FLOU = new ImageIcon(
			".\\image\\kitchen_blur.png");
	private static final ImageIcon CUISINE = new ImageIcon(
			".\\image\\kitchen.png");
	private JPanelRecette panelRecette;
	private JLabel[] labelIngredientTable;
}
