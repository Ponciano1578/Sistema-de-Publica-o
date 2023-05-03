public class ArmazenamentoTermoAditivo {
    private String LinkTermo;
    private String NumeroTermo;
    private String DescricaoTermo;
    private String EmpresaContratada;
  
    public ArmazenamentoTermoAditivo(String LinkTermo, String NumeroTermo, String DescricaoTermo, String EmpresaContratada) {
        this.LinkTermo = LinkTermo;
        this.NumeroTermo = NumeroTermo;
        this.DescricaoTermo = DescricaoTermo;
        this.EmpresaContratada = EmpresaContratada;
    }
  
    public String getLinkTermo() {
        return LinkTermo;
    }
  
    public void setLinkTermo(String LinkTermo) {
        this.LinkTermo = LinkTermo;
    }
  
    public String getNumeroTermo() {
        return NumeroTermo;
    }
  
    public void setNumeroTermo(String NumeroTermo) {
        this.NumeroTermo = NumeroTermo;
    }
  
    public String getDescricaoTermo() {
        return DescricaoTermo;
    }
  
    public void setDescricaoTermo(String DescricaoTermo) {
        this.DescricaoTermo = DescricaoTermo;
    }
    public String getEmpresaContratada() {
        return EmpresaContratada;
    }
  
    public void setEmpresaContratada(String EmpresaContratada) {
        this.EmpresaContratada = EmpresaContratada;
    }    
    
}