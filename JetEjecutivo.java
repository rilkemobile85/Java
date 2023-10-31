/*
 * JetEjecutivo.java
 *
 * Created on December 14, 2006, 5:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package aeropuerto;

public class JetEjecutivo extends Avión{
    
    protected int nivelDeUrgencia;
    
    public JetEjecutivo(String mat, String nombreAero, double cantCombustible, double cons, int nivelUrg) {
        super(mat, nombreAero, cantCombustible, cons);
        nivelDeUrgencia = nivelUrg;
    }
    
    @Override
    public double getPrioridad(){
        return combustible_restante/nivelDeUrgencia;
    }
    
}
