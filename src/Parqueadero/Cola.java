
package Parqueadero;

import static Parqueadero.Estacion.lisCola;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JGabriel
 */
public class Cola {
    private DefaultListModel modelo;
    private int n;
    public int tope;
    private Object cola[];

    public Cola(int n) {
        this.n = n;
        tope = 0;
        cola = new Object[n];
    }
    public boolean estaVacia(){
        return tope == 0;
    }
    public boolean estaLlena(){
        return tope == n;
    }
    public boolean colar(Object dato){
        if(estaLlena()){
            return false;
        }
        cola[tope] = dato;
        tope ++;
        return true;
    } 
    public Object descolar(){
        if(estaVacia()){
            return null;
        }
        tope --;
        for(int i = 0;i<tope;i++){
            cola[i]=cola[i+1];
        }
        return cola [tope];
    }
    public Object elementoPrimero(){
        return cola[0];
    }
    public void Imprimir(){
        modelo.clear();
        if(estaVacia()==true){
            JOptionPane.showMessageDialog(null, "El Estacionamiento Esta Vacio");
        }
        if(estaVacia()==false){
            for(int i = 0;i<tope;i++){
                modelo.addElement(cola[i]);
            }
        }
    }
    public void Modelo(){
        modelo = new DefaultListModel();
        lisCola.setModel(modelo);
        lisCola.setCellRenderer(new listaCola());
    }
}