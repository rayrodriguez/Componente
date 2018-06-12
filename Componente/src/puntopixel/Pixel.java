package puntopixel;

import java.awt.Color;
import java.io.Serializable;
import java.util.Vector;

public class Pixel implements Serializable{
	Color color;
	int posX;
	int posY;
	Conexion interfazMySQL;
	private Vector pixelListener = new Vector<PixelListener>();
	
	public Pixel() {  
		color = new Color(0);//negro
		posX = 0 ;
    }
	
public void setColor(Color nuevoColor, int posX, int posY){
    int ax = this.posX;
    this.posX = posX;
    this.posY = posY;
    
    if(ax != this.posX){
        PixelEvent event = new PixelEvent(this, nuevoColor, posX, posY);
        
       // String x = Integer.toString(posX);
       // String y = Integer.toString(posY);
      //  String colors = nuevoColor.toString();
      
        
       // int numRegistros = interfazMySQL.insertarPos(x, y, colors);
 		
 		//System.out.println("Filas actualizadas: "+ numRegistros);
        
        notificarCambio(event);
    }
}
		public Color getColor(){
		    return color;
		}
		public int posX() {
			
			return posX;
		}
		public int posY() {
			
			return posY;
		}
		
		public synchronized void addPixelListener(PixelListener listener){
			pixelListener.addElement(listener);
		}
		
		public synchronized void removePixelListener(PixelListener listener){
			pixelListener.removeElement(listener);
		}
		
		private void notificarCambio(PixelEvent event){
		    Vector lista;
		    synchronized(this){
		        lista = (Vector) pixelListener.clone();
		    }
		    for(int i=0; i<lista.size(); i++){
		        PixelListener listener =(PixelListener)lista.elementAt(i);
		        listener.enteradoPresion(event);
		    }
		}
}