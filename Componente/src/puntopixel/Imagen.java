package puntopixel;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Imagen extends JPanel{
	public Imagen () {
		
		super();
		
		//Obtener el ancho y el alto del JFrame
		this.setPreferredSize(new Dimension ( 600 , 500 ));
		this.setBackground(Color.BLACK);
		JLabel picture = new JLabel(new ImageIcon("colores.jpg"));
		this.add(picture);
		
		addMouseListener(new MouseAdapter() 
		{

			public void mousePressed(MouseEvent e) {
				Robot pixel = null;
				try {
					pixel = new Robot();
				} catch (AWTException e1) {
					
					e1.printStackTrace();
				}
				int posX = e.getX();
				int posY = e.getY();
				Color color = pixel.getPixelColor(posX,posY);
				
				
				Pixel nuevo = new Pixel();
				InsertaCambio colorPixel = new InsertaCambio();
		        nuevo.addPixelListener(colorPixel);
		        nuevo.setColor(color, posX, posY);
		        
		      //Conexión automática
		        Conexion interfazMysql = new Conexion();
		    	interfazMysql.Conectar();
		    	interfazMysql.insertarPos(Integer.toString(posX),Integer.toString(posX) ,color.toString());
		    	
			}
		});
		
		
	}

}
