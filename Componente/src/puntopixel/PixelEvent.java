package puntopixel;

import java.awt.Color;
import java.util.EventObject;

public class PixelEvent extends EventObject {
	
	 protected int posX, posY;
	Color color;
	 protected Object objFuente;
	 
	 public PixelEvent(Object fuente, Color nuevoColor, int posX, int posY) {
	        super(fuente);
	        this.posX=posX;
	        this.posY=posY;
	        this.objFuente = fuente;
	        this.color = nuevoColor;
	        
	    }
	 

	 public Color getColor(){
	        return color;
	    }
	 
	 public int getPosX(){
	        return posX;
	    }

	    public int getPosY(){
	        return posY;
	    }

	    public Object getSource(){
	        return objFuente;
	    }

}
