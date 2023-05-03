public class ArmazenamentoDecreto {
    private String linkDecreto;
    private String nomeDecreto;
    private String NumeroDecreto;
  
    public ArmazenamentoDecreto(String linkDecreto, String nomeDecreto, String NumeroDecreto) {
        this.linkDecreto = linkDecreto;
        this.nomeDecreto = nomeDecreto;
        this.NumeroDecreto = NumeroDecreto;
    }
  
    public String getlinkDecreto() {
        return linkDecreto;
    }
  
    public void setlinkDecreto(String linkDecreto) {
        this.linkDecreto = linkDecreto;
    }
  
    public String getnomeDecreto() {
        return nomeDecreto;
    }
  
    public void setnomeDecreto(String nomeDecreto) {
        this.nomeDecreto = nomeDecreto;
    }
  
    public String getNumeroDecreto() {
        return NumeroDecreto;
    }
  
    public void setNumeroDecreto(String NumeroDecreto) {
        this.NumeroDecreto = NumeroDecreto;
    }
}