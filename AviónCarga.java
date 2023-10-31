/*
 * Avi�nCarga.java
 *
 * Created on December 14, 2006, 5:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package aeropuerto;

public class Avi�nCarga extends Avi�n{
    
    protected double capacidadDeCarga;
    protected double cargaReal;
    
    public Avi�nCarga(String mat, String nombreAero, double cantCombustible, double cons, double capacidad, double carga) {
        super(mat, nombreAero, cantCombustible, cons);
        capacidadDeCarga = capacidad;
        cargaReal = carga;
    }
    
    @Override
    public double getPrioridad(){
        return combustible_restante/(capacidadDeCarga - cargaReal);
    }
}
