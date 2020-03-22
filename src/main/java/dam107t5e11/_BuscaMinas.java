package dam107t5e11;
import java.util.Random;

public class _BuscaMinas {
    public BuscaminasCasilla [][] casillas;
    public int cantFilas;
    public int cantCols;
    public int cantBombas;
    static final int BOMBA = -1;
    
    public _BuscaMinas (int filas, int cols, int cantBombas){
          this.cantFilas = filas;
          this.cantCols = cols;
          this.cantBombas = cantBombas;
          this.casillas = new BuscaminasCasilla [filas][cols];
           for (int i = 0; i < cantFilas; i++) 
              for (int j = 0; j <cantCols; j++) 
                  casillas[i][j] =  new BuscaminasCasilla (0,false);
          ponerBombas();
          ponerNumeros();
    }
    public void ponerBombas(){
        boolean rep; Random r = new Random();
        for (int i = 0; i < cantBombas; i++) {
              do {
                 rep = true;
                 int x= r.nextInt (cantFilas);
                 int y= r.nextInt (cantCols);
                 if (casillas[x][y].valor != BOMBA) {
                    casillas[x][y].valor = BOMBA;
                    rep = false;
                 }
              } while (rep);
        }
    }
    
    public void ponerNumeros(){
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j <cantCols; j++) {
                if (casillas[i][j].valor != BOMBA) {
                    casillas[i][j].valor = sumarColindantes(i,j);
                } 
            }
        }
    }
    
    public int sumarColindantes(int f, int c){
        int cant=0;
        for (int i = f-1; i <= f+1; i++) {
            for (int j = c-1; j <= c+1; j++) {
                if (i>=0 && i<cantFilas && 
                      j>=0 && j< cantCols &&
                      casillas[i][j].valor == BOMBA) cant++;
                } 
            }
        return cant;
    }
    
    public int elegir (int fil, int col) {
        if (fil <0 || fil >= cantFilas || col <0 || col >=cantCols) return 0;
        if (casillas[fil][col].descubierta == true)
            return casillas[fil][col].valor;
        casillas[fil][col].descubierta = true;    
        if (casillas[fil][col].valor==0){
           elegir (fil-1,col-1);elegir (fil-1,col);elegir (fil-1,col+1);
           elegir (fil,col-1);elegir (fil,col+1);
           elegir (fil+1,col-1);elegir (fil+1,col);elegir (fil+1,col+1);
        }
        return casillas[fil][col].valor;
    } 
    
    public boolean ganaste (){
        for (int i = 0; i < cantFilas; i++) 
            for (int j = 0; j <cantCols; j++) 
                if (casillas[i][j].valor != BOMBA &&
                    casillas[i][j].descubierta == false)
                    return false;
        return true;
    }
    
    public void mostrarSolucion(){
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j <cantCols; j++) {
                  System.out.printf("%02d.", casillas[i][j].valor);                
            }
            System.out.println("");                
        }
        System.out.println("");                        
    }
    public void mostrarDescubierto(){
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j <cantCols; j++) {
                  if (casillas[i][j].descubierta) 
                      System.out.printf("VV.");
                  else 
                      System.out.printf("FF.");
            }
            System.out.println("");                
         }
    }
} //fin clase

class BuscaminasCasilla {
     int valor;
     boolean descubierta;

     public BuscaminasCasilla(int valor, boolean descubierta) {
        this.valor = valor;
        this.descubierta = descubierta;
     }
}
