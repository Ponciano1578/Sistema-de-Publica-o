public class ArmazenamentoCredenciamento {
    private String LinkCredenciamento;
    private String NumeroCredenciamento;
    private String NumeroProcesso;
    private String DescricaoCredenciamento;
    private String DataCredenciamento;
    private String HoraCredenciamento;
  
    public ArmazenamentoCredenciamento(String LinkCredenciamento, String NumeroCredenciamento, String NumeroProcesso, String DescricaoCredenciamento, String DataCredenciamento, String HoraCredenciamento) {
        this.LinkCredenciamento = LinkCredenciamento;
        this.NumeroCredenciamento = NumeroCredenciamento;
        this.NumeroProcesso = NumeroProcesso;
        this.DescricaoCredenciamento = DescricaoCredenciamento;
        this.DataCredenciamento = DataCredenciamento;
        this.HoraCredenciamento = HoraCredenciamento;
    }
  
    public String getLinkCredenciamento() {
        return LinkCredenciamento;
    }
  
    public void setLinkCredenciamento(String LinkCredenciamento) {
        this.LinkCredenciamento = LinkCredenciamento;
    }
  
    public String getNumeroCredenciamento() {
        return NumeroCredenciamento;
    }
  
    public void setNumeroCredenciamento(String NumeroCredenciamento) {
        this.NumeroCredenciamento = NumeroCredenciamento;
    }
  
    public String getNumeroProcesso() {
        return NumeroProcesso;
    }
  
    public void setNumeroProcesso(String NumeroProcesso) {
        this.NumeroProcesso = NumeroProcesso;
    }
    public String getDescricaoCredenciamento() {
        return DescricaoCredenciamento;
    }
  
    public void setDescricaoCredenciamento(String DescricaoCredenciamento) {
        this.DescricaoCredenciamento = DescricaoCredenciamento;
    }  
    public String getDataCredenciamento() {
        return DataCredenciamento;
    }
  
    public void setDataCredenciamento(String DataCredenciamento) {
        this.DataCredenciamento = DataCredenciamento;
    }  
    public String getHoraCredenciamento() {
        return HoraCredenciamento;
    }
  
    public void setHoraCredenciamento(String HoraCredenciamento) {
        this.HoraCredenciamento = HoraCredenciamento;
    }  
    
    
}