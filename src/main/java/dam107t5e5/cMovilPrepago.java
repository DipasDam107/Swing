package dam107t5e5;



public class cMovilPrepago implements Movil {
    public long numeroMovil;
    private float costeEstablecLlamada;
    private float costeMinutoLlamada ;
    private float costeConsumoMB;
    private float saldo;

cMovilPrepago (long nM, float cEL, float cML, float cMB, float s) {
    numeroMovil = nM;
    costeEstablecLlamada = cEL;
    costeMinutoLlamada = cML;
    costeConsumoMB = cMB;
    saldo =s;
}    
public void efectuarLlamada (int segundos) {
      saldo -= Math.round(costeEstablecLlamada +
                           costeMinutoLlamada /60f * segundos * 100f)/100f; 
      if (saldo < 0) saldo = 0;
}
public void navegar (int mb) {
      saldo -= Math.round(costeConsumoMB* mb * 100f) / 100f;
      if (saldo < 0) saldo = 0;
}
public boolean recargar (int importe) {
      if (importe % 5 == 0) {
         saldo += importe;
         return true;
      }
      else return false;
}
public float consultarSaldo () {
      return saldo;
}

    @Override
 public String toString(){
        return "Numero de Movil: " + this.numeroMovil + " Saldo: " +this.consultarSaldo()+"€";
    }
  
    @Override
    public boolean equals(Object movil){
        if(movil instanceof cMovilPrepago)
             if(((cMovilPrepago)movil).numeroMovil==this.numeroMovil) return true;
             else return false;
        else return false;
    }
 
} 