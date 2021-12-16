package com.grafos;


import com.mxgraph.layout.*;
import com.mxgraph.swing.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.ext.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.*;

public class Grafo extends JApplet
{
       private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);
       private JGraphXAdapter<String, DefaultEdge> jgxAdapter;
       private ArrayList<String[]> personas = new ArrayList<String[]>();


      //Constructor que recibe el arraylist persona

      public Grafo(ArrayList<String[]> personas){

        this.personas = personas;
        
      }

       //  Inicializa el grafico de grafos
       ListenableGraph<String, DefaultEdge> g =
       new DefaultListenableGraph<>(new DefaultUndirectedGraph<>(DefaultEdge.class));

   
    public static void main(ArrayList<String[]> personas )
    {
        //Inicializacion de la ventana (pestaña) para graficar los grafos 
        Grafo applet = new Grafo(personas);
        applet.init();
        JFrame frame = new JFrame();
        frame.setSize(1200, 800);
        frame.getContentPane().add(applet);
        
        frame.setTitle("JGraphT Adapter to JGraphX Demo");
        frame.pack();
        frame.setVisible(true);

             
 
    }

    @Override
    public void init()
    {
        

        //Crea una visualizacion usando JGraph mediante un adaptador grafico, las siguientes son lineas recomendadas por la API
        jgxAdapter = new JGraphXAdapter<>(g);

        setPreferredSize(DEFAULT_SIZE);
        mxGraphComponent component = new mxGraphComponent(jgxAdapter);
        component.setConnectable(false);
        component.getGraph().setAllowDanglingEdges(false);
        getContentPane().add(component);
        resize(DEFAULT_SIZE);

        // Ciclo for que añade vertices 

        for(int i=0; i<personas.size();i++){

            g.addVertex(personas.get(i)[0]);
        }
        
        //Añadir vectores segun haya correspondencia
        //Por deporte

        for(int i = 0;i<personas.size()-1;i++){


            for(int j=i+1;j<personas.size();j++){

                if( personas.get(i)[1].equals(personas.get(j)[1])){
                    g.addEdge(personas.get(i)[0],personas.get(j)[0]);
                }
            }
        }

         //Por afinidad musical

         for(int i = 0;i<personas.size()-1;i++){


            for(int j=i+1;j<personas.size();j++){

                if( personas.get(i)[2].equals(personas.get(j)[2])){
                    g.addEdge(personas.get(i)[0],personas.get(j)[0]);
                }
            }
        }

        //Todo lo siguiente es recomendado por la API para centrar el grafo
        mxCircleLayout layout = new mxCircleLayout(jgxAdapter);

        // center the circle
        int radius = 100;
        layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
        layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
        layout.setRadius(radius);
        layout.setMoveCircle(true);

        layout.execute(jgxAdapter.getDefaultParent());
    }


    
}
