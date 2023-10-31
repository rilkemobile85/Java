
package eda;

import aeropuerto.Avión;

public class ColaPrioridadSE <T extends IPriorizable> extends ColaSE<T>
{
    public void Adicionar(T x) {
        NodoSE<T> nuevo = new NodoSE<T>(x, null);
        if (Vacia()) {
            frente = nuevo;
            fondo = nuevo;
        } else {
            NodoSE<T> cursor = frente;
            NodoSE<T> anterior = cursor;
            while ((cursor != null) && (cursor.getInfo().getPrioridad() <= nuevo.getInfo().getPrioridad())) {
                anterior = cursor;
                cursor = cursor.getSiguiente();
            }
            
            if (cursor == null) {
                fondo.setSiguiente(nuevo);
                fondo = nuevo;
            } else if (cursor == frente) {
                nuevo.setSiguiente(frente);
                frente = nuevo;
            } else {
                nuevo.setSiguiente(cursor);
                anterior.setSiguiente(nuevo);
            }
        }
    }

}