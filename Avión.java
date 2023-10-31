package aeropuerto;

import eda.*;

public abstract class Avión implements IPriorizable{
        
        protected String matricula;
        protected String aerolinea;
        protected double combustible_restante; 
        protected double consumo_30min;

        public Avión(String mat, String al, double cr, double c3)
        {
            matricula = mat;
            aerolinea = al;
            combustible_restante = cr;
            consumo_30min = c3;
        }
        public void Consumir()
        {
            combustible_restante -= consumo_30min;
        }
        public String getMatricula()
        {
            return matricula;
        }
        public String getAerolinea()
        {
            return aerolinea;
        }
        public abstract double getPrioridad();
    }
