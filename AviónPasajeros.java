/*
 * Avi�nPasajeros.java
 *
 * Created on December 14, 2006, 5:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package aeropuerto;

/**
 *
 * @author jalbert
 */
public class Avi�nPasajeros extends Avi�n{
    
    protected int cantPasajeros;
    protected double distanciaRecorrida;
    
    public Avi�nPasajeros(String mat, String nombreAero, double cantCombustible, double cons, int cantPas, double distRec) {
        super(mat, nombreAero, cantCombustible, cons);
        cantPasajeros = cantPas;
        distanciaRecorrida = distRec;
    }
    
    @Override
    public double getPrioridad(){
        return combustible_restante/distanciaRecorrida;
    }
    
}
