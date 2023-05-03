public class ArmazenamentoContrato {
    private String linkContrato;
    private String numeroContrato;
    private String objetoContrato;
    private String fornecedorContrato;
    private String valorContrato;
  
    public ArmazenamentoContrato(String linkContrato, String numeroContrato, String objetoContrato, String fornecedorContrato, String valorContrato) {
        this.linkContrato = linkContrato;
        this.numeroContrato = numeroContrato;
        this.objetoContrato = objetoContrato;
        this.fornecedorContrato = fornecedorContrato;
        this.valorContrato = valorContrato;
    }
  
    public String getlinkContrato() {
        return linkContrato;
    }
  
    public void setlinkContrato(String linkContrato) {
        this.linkContrato = linkContrato;
    }
  
    public String getnumeroContrato() {
        return numeroContrato;
    }
  
    public void setnumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }
  
    public String getobjetoContrato() {
        return objetoContrato;
    }
  
    public void setobjetoContrato(String objetoContrato) {
        this.objetoContrato = objetoContrato;
    }
    public String getfornecedorContrato() {
        return fornecedorContrato;
    }
  
    public void setfornecedorContrato(String fornecedorContrato) {
        this.fornecedorContrato = fornecedorContrato;
    }  
    public String getvalorContrato() {
        return valorContrato;
    }
  
    public void setvalorContrato(String valorContrato) {
        this.valorContrato = valorContrato;
    }  
    
}