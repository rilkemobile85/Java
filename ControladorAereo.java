
package aeropuerto;

import java.util.*;
import eda.*;

public class ControladorAereo {
    
    private ColaPrioridadSE<IPriorizable> cola_Aviones;
    
    public ControladorAereo() {
        cola_Aviones = new ColaPrioridadSE<IPriorizable>();
    }
    
    public void Adicionar(Avi�n av) {
        cola_Aviones.Adicionar((IPriorizable)av);
    }
    
    public Avi�n Aterrizar() throws Exception {
        Avi�n A = (Avi�n)cola_Aviones.Extraer();
        ReordenarCola();
        return A;
    }
    private void ReordenarCola() throws Exception {
        ListaSE<Avi�n> lista = new ListaSE<Avi�n>();
        
        while (!cola_Aviones.Vacia()) {
            lista.Adicionar((Avi�n)cola_Aviones.Extraer());
        }
        for (int i = 0; i < lista.Longitud(); i++) {
            Avi�n A = lista.Obtener(i);
            A.Consumir();
            cola_Aviones.Adicionar((IPriorizable)A);
        }
    }
    
    public ListaSE<Avi�n> getAviones() throws Exception {
        ListaSE<Avi�n> lista = new ListaSE<Avi�n>();
        
        while (!cola_Aviones.Vacia()) {
            lista.Adicionar((Avi�n)cola_Aviones.Extraer());
        }
        for (int i = 0; i < lista.Longitud(); i++) {
            Avi�n A = lista.Obtener(i);
            cola_Aviones.Adicionar((IPriorizable)A);
        }
        return lista;
    }
    
}
