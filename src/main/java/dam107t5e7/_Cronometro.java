package dam107t5e7;

public class _Cronometro extends Thread {
   public int decimas;
   public int segundos;
   public int minutos;
   public boolean arrancado;
   
   _Cronometro () {
       Resetear();
   }
    
   public void Resetear(){
      decimas=0;
      segundos=0;
      minutos=0;
      arrancado = false;
   } 
   public void Arrancar (){
      arrancado=true;
   }
   public void Parar (){
      arrancado = false;
   }
   
   public void Incrementar () {
       if (arrancado) {
            decimas++;
            if (decimas==10) {decimas=0;segundos++;}
            else return;
            if (segundos ==60) {segundos=0;minutos++;}
        }
   }
   
   public String toString(){
       return minutos+":"+segundos+":"+decimas;
   }
}