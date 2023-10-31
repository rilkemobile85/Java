
package aeropuerto;

import java.util.*;
import eda.*;

public class ControladorAereo {
    
    private ColaPrioridadSE<IPriorizable> cola_Aviones;
    
    public ControladorAereo() {
        cola_Aviones = new ColaPrioridadSE<IPriorizable>();
    }
    
    public void Adicionar(Avión av) {
        cola_Aviones.Adicionar((IPriorizable)av);
    }
    
    public Avión Aterrizar() throws Exception {
        Avión A = (Avión)cola_Aviones.Extraer();
        ReordenarCola();
        return A;
    }
    private void ReordenarCola() throws Exception {
        ListaSE<Avión> lista = new ListaSE<Avión>();
        
        while (!cola_Aviones.Vacia()) {
            lista.Adicionar((Avión)cola_Aviones.Extraer());
        }
        for (int i = 0; i < lista.Longitud(); i++) {
            Avión A = lista.Obtener(i);
            A.Consumir();
            cola_Aviones.Adicionar((IPriorizable)A);
        }
    }
    
    public ListaSE<Avión> getAviones() throws Exception {
        ListaSE<Avión> lista = new ListaSE<Avión>();
        
        while (!cola_Aviones.Vacia()) {
            lista.Adicionar((Avión)cola_Aviones.Extraer());
        }
        for (int i = 0; i < lista.Longitud(); i++) {
            Avión A = lista.Obtener(i);
            cola_Aviones.Adicionar((IPriorizable)A);
        }
        return lista;
    }
    
}
