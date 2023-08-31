import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMoneda {
		
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Conversor de Monedas");
        ventana.getContentPane().setBackground(new Color(255, 255, 255));
        ventana.setBackground(new Color(255, 255, 255));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        panel.setLayout(null);

        JLabel etiquetaTitulo = new JLabel("Conversor de Monedas");
        etiquetaTitulo.setForeground(new Color(165, 42, 42));
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaTitulo.setBounds(200, 20, 200, 30);
        panel.add(etiquetaTitulo);

        JLabel cantidades = new JLabel("Ingrese el monto a convertir");
        cantidades.setForeground(new Color(165, 42, 42));
        cantidades.setBounds(54, 76, 212, 43);
        panel.add(cantidades);

        JTextField campoNumero = new JTextField();
        campoNumero.setHorizontalAlignment(SwingConstants.CENTER);
        campoNumero.setBounds(281, 82, 252, 30);
        panel.add(campoNumero);

        JLabel opciones = new JLabel(" Selecione una opción ");
        opciones.setForeground(new Color(165, 42, 42));
        opciones.setBounds(54, 147, 200, 30);
        panel.add(opciones);

        String[] OpcionesConversion = {"Pesos Argentinos a Dolar",
                "Pesos Argentinos a Euro",
                "Pesos Argentinos a Libras Esterlinas",
                "Pesos Argentinos a Yen Japonés",
                "Pesos Argentinos a Won sul-coreano",
                "Dólar a Pesos Argentinos",
                "Euros a Pesos Argentinos",
                "Libras Esterlinas a Pesos Argentinos",
                "Yen Japonés a Pesos Argentinos",
                "Won sul-coreano a Pesos Argentinos"};
        JComboBox<String> listaMonedaOrigen = new JComboBox<>(OpcionesConversion);
        listaMonedaOrigen.setForeground(new Color(106, 90, 205));
        listaMonedaOrigen.setBackground(new Color(230, 230, 250));
        listaMonedaOrigen.setBounds(281, 147, 252, 30);
        panel.add(listaMonedaOrigen);

        JButton botonConvertir = new JButton("Convertir");
        botonConvertir.setBackground(new Color(230, 230, 250));
        botonConvertir.setForeground(new Color(106, 90, 205));
        botonConvertir.setBounds(252, 236, 100, 30);
        botonConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String opcionConversion = (String) listaMonedaOrigen.getSelectedItem();

                try {
                    double cantidad = Double.parseDouble(campoNumero.getText());

                  
                    double resultado = realizarConversion(cantidad, opcionConversion);

                    String mensajeResultado = String.format(" su valor es de %.4f" , resultado);
                    JOptionPane.showMessageDialog(null, mensajeResultado, "Resultado de Conversión", JOptionPane.INFORMATION_MESSAGE);
                    
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?", "Continuar", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (opcion == JOptionPane.YES_OPTION) {
                  
                        campoNumero.setText( " ");                                         
                        listaMonedaOrigen.setSelectedIndex(0);
                    } else if (opcion == JOptionPane.NO_OPTION) {
                    	JOptionPane.showMessageDialog(null, "Programa Finalizado", "Fin del Programa", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }else if (opcion == JOptionPane.CANCEL_OPTION || opcion == JOptionPane.CLOSED_OPTION) { 
                    	JOptionPane.showMessageDialog(null, "Programa Finalizado", "Fin del Programa", JOptionPane.INFORMATION_MESSAGE);
                    	 System.exit(0);
                    	 }
                    			 
                     } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingresa un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

			public double realizarConversion(double  campoNumero, String opcionConversion) {
				//valores fijos de monedas comparados con 1 peso Argentino, fecha de obtencion de valores 30/08/2023
		    	
				double dolar = 0.0029;
		    	double euro = 0.0026;
		    	double librasEstarlinas = 0.0022;
		    	double yenJapones = 0.42;
		    	double wonSulCoreano= 3.78;    	
		    	double pesoArgParaDolar = 349.96;
		    	double pesoArgParaEuro= 382.48;
		    	double pesoArgParaLIbras = 445.44;
		    	double pesoArgParaYen = 2.40;
		    	double pesoArgParaWon = 0.26;
		        double resultado= 0.0;
		    	
		    	switch (opcionConversion) {
		    	
			        case "Pesos Argentinos a Dolar":
			            resultado = campoNumero * dolar;
			        break;
			
			        case "Pesos Argentinos a Euro":
			             resultado = campoNumero * euro;
			        break;
	                   
			        case "Pesos Argentinos a Libras Esterlinas":
			              resultado = campoNumero * librasEstarlinas;	
			        break;
			        
			        case "Pesos Argentinos a Yen Japonés":
			            resultado = campoNumero * yenJapones;
			        break;
			        
			        case "Pesos Argentinos a Won sul-coreano":
			             resultado = campoNumero * wonSulCoreano;
			        break; 
			        
			        case "Dólar a Pesos Argentinos":
			            resultado = campoNumero * pesoArgParaDolar;
			        break;
			        
			        case  "Euros a Pesos Argentinos":
			             resultado = campoNumero * pesoArgParaEuro;
			        break;
			        
			        case "Libras Esterlinas a Pesos Argentinos":
			              resultado = campoNumero * pesoArgParaLIbras;	
			        break;
			        
			        case "Yen Japonés a Pesos Argentinos":
			             resultado = campoNumero * pesoArgParaYen;
			        break; 
			                    
			        case  "Won sul-coreano a Pesos Argentinos":
			             resultado = campoNumero * pesoArgParaWon;
			        break;  
			        
			        default:
			        	System.out.println("Opcion no valida" );
			    	}
			  
		    	
		    	
		    	
				return resultado;
			}
        });
        panel.add(botonConvertir);

        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
   
   
    }
    }


