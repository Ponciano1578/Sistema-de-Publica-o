public class ArmazenamentoAta {
    private String linkAta;
    private String numeroAta;
    private String objetoAta;
    private String fornecedorAta;
  
    public ArmazenamentoAta(String linkAta, String numeroAta, String objetoAta, String fornecedorAta) {
        this.linkAta = linkAta;
        this.numeroAta = numeroAta;
        this.objetoAta = objetoAta;
        this.fornecedorAta = fornecedorAta;
    }
  
    public String getlinkAta() {
        return linkAta;
    }
  
    public void setlinkAta(String linkAta) {
        this.linkAta = linkAta;
    }
  
    public String getnumeroAta() {
        return numeroAta;
    }
  
    public void setnumeroAta(String numeroAta) {
        this.numeroAta = numeroAta;
    }
  
    public String getobjetoAta() {
        return objetoAta;
    }
  
    public void setobjetoAta(String objetoAta) {
        this.objetoAta = objetoAta;
    }
    public String getfornecedorAta() {
        return fornecedorAta;
    }
  
    public void setfornecedorAta(String fornecedorAta) {
        this.fornecedorAta = fornecedorAta;
    }    
    
}