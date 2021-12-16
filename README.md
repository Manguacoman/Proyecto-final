# Proyecto-final
package com.grafos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.*;
//JApplet es la libreria que sirve para traer todos los elementos que se van a graficar del formulario
public class App extends JApplet{

//arreglo con los participantes iniciales 
    private ArrayList<String[]> personas = new ArrayList<String[]>();

    //Constructor, inicializacion de informacion basica
    public App(){

        String[] personsa1 = {"Claudio","Futbol","Gospel"};
        String[] personsa2 = {"Camila","Ciclismo","Gospel"};
        String[] personsa3 = {"Alexander","Ciclismo","Jazz"};
        String[] personsa4 = {"Paula","Ciclismo","Pop"};

        personas.add(personsa1);
        personas.add(personsa2);
        personas.add(personsa3);
        personas.add(personsa4);

    }

    public static void main(String[] args)
    {
        // Declaracion componentes menu y componentes que se mostraran en pantalla 
        App variables = new App();

        JLabel label2 = new JLabel("Nombre");
        label2.setBounds(350, 500, 500, 100);

        JTextField nombre = new JTextField();
        nombre.setBounds(600, 500, 500, 100);
        nombre.setColumns(20);
        
        JLabel deporte = new JLabel("Deporte");
        deporte.setBounds(850, 500, 500, 100);

        String deportes[]={"Futbol","Basquetbol","Volleyball","Ciclismo","Natacion"};        
        JComboBox sports=new JComboBox(deportes);   
        sports.setBounds(1000, 500, 500, 200);

        JLabel musica = new JLabel("Estilo Musical");
        deporte.setBounds(1250, 500, 500, 100);

        String estilos_musicales[]={"Blues","Jazz","Pop","Rock","Gospel"};        
        JComboBox estilos=new JComboBox(estilos_musicales);   
        estilos.setBounds(1250, 500, 500, 200);

        JButton agregar=new JButton("Agregar");  
        agregar.setBounds(50,100,95,30); 
// Funcion que actua como listener del boton agregar
        agregar.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                          
                          // Se recuperan los datos del textbox y combobox
                          String nombre_adicional = nombre.getText();
                          String deporte_adicional = sports.getSelectedItem().toString();
                          String estilos_adicional = estilos.getSelectedItem().toString();

                          String[] personsa_adicional = {nombre_adicional,deporte_adicional,estilos_adicional};
                          variables.personas.add(personsa_adicional);
                          // Se instancia la clase grafo para mostrar las conexiones 
                          Grafo graficador = new Grafo(variables.personas);
                          graficador.main(variables.personas);
                          

                    }  
                });



        // Se crea el contenedor de los elementos declarados anteriormente
        JPanel menuPanel = new JPanel();  
        menuPanel.setSize(1200, 800);
        menuPanel.setBackground(new Color(255, 255, 255));
        //menuPanel.add(label1);     
        menuPanel.add(label2);
        menuPanel.add(nombre);
        menuPanel.add(deporte);  
        menuPanel.add(sports);
        menuPanel.add(musica);
        menuPanel.add(estilos);
        menuPanel.add(agregar);   


        // Inicializacion del menu

        JFrame frame = new JFrame();
        frame.getContentPane().add(menuPanel);
        frame.setTitle("JGraphT Adapter to JGraphX Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1200, 800);
        frame.setVisible(true);
    }
    
}
