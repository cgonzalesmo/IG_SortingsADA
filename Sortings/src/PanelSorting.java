import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class PanelSorting extends JPanel{
	Graphics2D g2D;
	int[] array;
	int maxValue;
	
	public PanelSorting(int[] ar, int maxValue) {
		this.array = ar;
		this.maxValue = maxValue;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g2D = (Graphics2D) g;		
		Dimension d = getSize();
		int Width = d.width-20;
		int Heigth = d.height-30;
	
		int xPos;
		int width = (int) Math.floor((Width/array.length)*0.9);
		int space = (int) Math.floor((Width/array.length)*0.1);
		int yPos;
		int height;
		
		for(int i=0;i<array.length;i++) {
			height = (array[i]*Heigth)/maxValue;
			yPos = Heigth - height +15;
			xPos = (width+space)*i+10;
			
			g2D.setColor(Color.WHITE);
			g2D.fillRect(xPos, 15, width, d.height-30);			
			g2D.setColor(Color.BLUE);			
			g2D.fillRect(xPos, yPos, width, height);
		}
		
	}
	
	public int[] getArray() {
		return array;
	}
	
	public void limpiar(Graphics g) {
		g.setColor(getBackground());
		Dimension d = getSize();
		g.fillRect(10,15,d.width-20,d.height-30);
	}
	
	public void actualizar(int[] ar,int maxValue) {
		this.array = ar;
		this.maxValue = maxValue;
	}

}
