package puntopixel;

import java.util.EventObject;

public class InsertaCambio  implements PixelListener {
	//Conexion interfazMysql;
	String posX;
	String posY;
	String color;
	
	public InsertaCambio (){
		
	}

	@Override
	public void enteradoPresion(EventObject e) {
		if(e instanceof PixelEvent){
            PixelEvent event = (PixelEvent)e;
            
            posX = Integer.toString(event.getPosX());
            posY = Integer.toString(event.getPosY());
            color = event.getColor().toString();
            
    		//System.out.println("PosX: "+ posX);
            //System.out.println("PosY: " + posY);
            //System.out.println("Color: "+ color);
            
            
           
           //int numRegistros = interfazMysql.insertarPos(posX, posY, color);
     		
     		//System.out.println("Filas actualizadas: "+ numRegistros);
            
        }
		
	}

}
