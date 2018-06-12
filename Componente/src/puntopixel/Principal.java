package puntopixel;

	/*Hacer un componente que obtenga el color de un pixel de pantalla, como la 
	herramienta cuentagotas del photoshop. El evento se generaría cuando se de click a un pixel y la 
	información que contendría sería el color y las coordenadas del pixel. 
	http://docs.oracle.com/javase/7/docs/api/java/awt/Robot.html*/

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame{
	
	public Principal () {
		Container contenedorPrinc = getContentPane();
        contenedorPrinc.setLayout(new BoxLayout(contenedorPrinc, BoxLayout.Y_AXIS));
        
        Imagen imagen = new Imagen();
        contenedorPrinc.add(imagen);
        
        JPanel panelBotones = new JPanel();
        
        panelBotones.setLayout(new FlowLayout());
        TitledBorder titPanelBotones = BorderFactory.createTitledBorder("");
        panelBotones.setBorder(titPanelBotones);
        
        JButton btnObtener = new JButton("Obtener datos");
        panelBotones.add(btnObtener);
        
        //JButton btnEliminar = new JButton("Eliminar datos");
        //panelBotones.add(btnEliminar);
        
        JLabel lblConectado = new JLabel("Conectado");
        lblConectado.setPreferredSize(new Dimension(70, 20));
        
      //Conexión automática
    	
    	contenedorPrinc.add(panelBotones);
        
        btnObtener.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                       
                    	TablaDeBD frame = new TablaDeBD();
                    	frame.setTitle("Datos almacenados en BD posiciones");
                    	frame.setBackground(Color.BLACK);
                        frame.pack();
                        frame.setVisible(true);
                        
                    }
                }
                );
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Principal principal = new Principal();
		principal.setTitle("Click sobre la imagen");
        principal.setSize(600, 510);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setResizable(true);
        principal.setVisible(true);
		
	}
	
	
}

