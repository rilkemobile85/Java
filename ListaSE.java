
package eda;

public class ListaSE<T> implements  ILista<T>{
    
        private int longitud;
        protected NodoSE<T> cabeza;

        public ListaSE()
        {
            cabeza = null;
            longitud = 0;
        }
        public void Adicionar(T x)
        {
            NodoSE<T> nuevo = new NodoSE<T>(x, null);
            if (Vacia())
                cabeza = nuevo;
            else
            {
                NodoSE<T> cursor = cabeza;
                while (cursor.getSiguiente() != null)
                    cursor = cursor.getSiguiente();
                cursor.setSiguiente(nuevo);
            }
            longitud++;
        }
        public void Insertar(T x, int pos)throws Exception
        {
            if ((pos < 0) || (pos >= longitud))
                throw new Exception("Posicion fuera de rango");

            NodoSE<T> nuevo = new NodoSE<T>(x, null);
            if (pos == 0)
            {
                nuevo.setSiguiente(cabeza);
                cabeza = nuevo;
            }
            else
            {
                NodoSE<T> cursor = cabeza;
                int pos_cursor = 0;
                while ((cursor != null) && (pos_cursor + 1 != pos))
                {
                    pos_cursor++;
                    cursor = cursor.getSiguiente();
                }
                nuevo.setSiguiente(cursor.getSiguiente());
                cursor.setSiguiente(nuevo);
            }
            longitud++;
        }
        public T Obtener(int pos)throws Exception
        {
            if ((pos < 0) || (pos >= longitud))
                throw new Exception("Posicion fuera de rango");
            
            NodoSE<T> cursor = cabeza;
            for (int i = 0; i < pos; i++)
                cursor = cursor.getSiguiente();
            return cursor.getInfo();
        }
        public void Eliminar(int pos)throws Exception
        { 
            if (Vacia())
                throw new Exception("Lista Vacia");
            if ((pos < 0) || (pos >= longitud))
                throw new Exception("Posicion fuera de rango");
            
            NodoSE<T> cursor = cabeza;
            if (pos == 0)
                cabeza = cursor.getSiguiente();
            else
            {
                NodoSE<T> anterior = cabeza;
                int pos_cursor = 0;
                while ((cursor != null) && (pos_cursor != pos))
                {
                    anterior = cursor;
                    cursor = cursor.getSiguiente();
                    pos_cursor++;
                }
                anterior.setSiguiente(cursor.getSiguiente());
                cursor.setSiguiente(null);
            }
            longitud--;
        }
        public int Longitud()
        {
            return longitud;
        }
        public boolean Vacia()
        {
            return (longitud == 0);
        }
    }