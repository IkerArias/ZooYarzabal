package Zoo;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private Image imagenFondo;
	
	public ImagePanel(String imagePath) {
		this.imagenFondo = new ImageIcon(imagePath).getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
	}
	
	

}
