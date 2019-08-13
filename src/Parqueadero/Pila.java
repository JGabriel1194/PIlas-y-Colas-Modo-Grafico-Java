
package Parqueadero;

import static Parqueadero.Estacion.lisPila;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JGabriel
 */
public class Pila {
    private DefaultListModel modelo;
    private int n;
    public int tope =0;
    private Object pila[];

    public Pila(int n) {
        this.n = n;
        tope = 0;
        pila = new Object[n];
    }
    public boolean estaVacia(){
        return tope == 0;
    }
    public boolean estaLlena(){
        return tope == n;
    }
    public boolean apilar(Object dato){
        if(estaLlena()){
            return false;
        }
        pila[tope] = dato;
        tope ++;
        return true;
    } 
    public Object desapilar(){
        if(estaVacia()){
            return null;
        }
        tope --;
        return pila [tope];
    }
    public Object elementoTope(){
        return pila[tope - 1];
    }
    public void Imprimir(){
        modelo.clear();
        if(estaVacia()==true){
            JOptionPane.showMessageDialog(null, "El Estacionamiento Esta Vacio");
        }
        if(estaVacia()==false){
            for(int i = tope-1;i>-1;i--){
                modelo.addElement(pila[i]);
            }
        }
    }
    public void Modelo(){
        modelo = new DefaultListModel();
        lisPila.setModel(modelo);
        lisPila.setCellRenderer(new listaPila());
    }
}