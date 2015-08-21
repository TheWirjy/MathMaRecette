package mathmarecette.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelLevel extends JPanel
	{

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	public JPanelLevel()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation

		level1 = new JButton("Spaghetti");
		level2 = new JButton("Pâte à Crêpe ");
		level3 = new JButton("Cake au Citron ");
		level4 = new JButton("Salade");
		level5 = new JButton("Pizza au jambon ");

		// JComponent : Adaptation
		String filename="C:/Users/raphael.schaffo/HE-ARC/MathMaRecette Media/Son/CLickJump.mp3";
	    mp3= new MP3(filename);

		level1.setPreferredSize(new Dimension(100, 30));
		level2.setPreferredSize(new Dimension(100, 30));
		level3.setPreferredSize(new Dimension(100, 30));
		level4.setPreferredSize(new Dimension(100, 30));
		level5.setPreferredSize(new Dimension(100, 30));

		level1.setBorderPainted(false);
		iconSpaghetti = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\BTNSpaghetti.png");
		iconSpaghettiCopie = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\BTNSpaghetti-copie.png");
		level1.setIcon(iconSpaghetti);
		
		
		level2.setBorderPainted(false);
		iconPate = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\BTNPate.png");
		iconPateCopie = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\BTNPate-copie.png");
		level2.setIcon(iconPate);
		
		level3.setBorderPainted(false);
		iconCake = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\BTNCake.png");
		iconCakeCopie = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\BTNCake-copie.png");
		level3.setIcon(iconCake);
		
		
		level4.setBorderPainted(false);
		iconSalade = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\BTNSalade.png");
		iconSaladeCopie = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\BTNSalade-copie.png");
		level4.setIcon(iconSalade);
		
		level5.setBorderPainted(false);
		iconPizza = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\BTNPizza.png");
		iconPizzaCopie = new ImageIcon("C:\\Users\\raphael.schaffo\\HE-ARC\\MathMaRecette Media\\Image\\BTNPizza-copie.png");
		level5.setIcon(iconPizza);
		
		
		// JComponent : Layout

		setLayout(new GridLayout(5, 1, 10, 10));
		add(level1);
		add(level2);
		add(level3);
		add(level4);
		add(level5);

		}

	private void control()
		{
		level1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				level1.setIcon(iconSpaghetti);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				level1.setIcon(iconSpaghettiCopie);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				mp3.play();
			}
		});
		level2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				level2.setIcon(iconPate);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				level2.setIcon(iconPateCopie);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				mp3.play();
			}
		});
		level3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				level3.setIcon(iconCake);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				level3.setIcon(iconCakeCopie);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				mp3.play();
			}
		});
		level4.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				level4.setIcon(iconSalade);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				level4.setIcon(iconSaladeCopie);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				mp3.play();
			}
		});
		level5.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				level5.setIcon(iconPizza);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				level5.setIcon(iconPizzaCopie);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				mp3.play();
			}
		});
		}

	private void appearance()
		{
		Dimension panelD = new Dimension(500, 470);
		this.setPreferredSize(panelD);
		this.setMaximumSize(panelD);
		Color fontColor = new Color(255,246,213);
		setBackground(fontColor);
		}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	JButton level1;
	JButton level2;
	JButton level3;
	JButton level4;
	JButton level5;
	private ImageIcon iconSpaghetti;
	private ImageIcon iconSpaghettiCopie;
	private ImageIcon iconPate;
	private ImageIcon iconPateCopie;
	private ImageIcon iconCake;
	private ImageIcon iconCakeCopie;
	private ImageIcon iconSalade;
	private ImageIcon iconSaladeCopie;
	private ImageIcon iconPizza;
	private ImageIcon iconPizzaCopie;
	private MP3 mp3 ;

	}
