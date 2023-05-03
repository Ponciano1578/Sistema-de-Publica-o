public class ArmazenamentoTomadaDePreço {
    private String LinkTP;
    private String NumeroTP;
    private String NumeroProcesso;
    private String DescricaoTP;
    private String DataTP;
    private String HoraTP;
  
    public ArmazenamentoTomadaDePreço(String LinkTP, String NumeroTP, String NumeroProcesso, String DescricaoTP, String DataTP, String HoraTP) {
        this.LinkTP = LinkTP;
        this.NumeroTP = NumeroTP;
        this.NumeroProcesso = NumeroProcesso;
        this.DescricaoTP = DescricaoTP;
        this.DataTP = DataTP;
        this.HoraTP = HoraTP;
    }
  
    public String getLinkTP() {
        return LinkTP;
    }
  
    public void setLinkTP(String LinkTP) {
        this.LinkTP = LinkTP;
    }
  
    public String getNumeroTP() {
        return NumeroTP;
    }
  
    public void setNumeroTP(String NumeroTP) {
        this.NumeroTP = NumeroTP;
    }
  
    public String getNumeroProcesso() {
        return NumeroProcesso;
    }
  
    public void setNumeroProcesso(String NumeroProcesso) {
        this.NumeroProcesso = NumeroProcesso;
    }
    public String getDescricaoTP() {
        return DescricaoTP;
    }
  
    public void setDescricaoTP(String DescricaoTP) {
        this.DescricaoTP = DescricaoTP;
    }  
    public String getDataTP() {
        return DataTP;
    }
  
    public void setDataTP(String DataTP) {
        this.DataTP = DataTP;
    }  
    public String getHoraTP() {
        return HoraTP;
    }
  
    public void setHoraTP(String HoraTP) {
        this.HoraTP = HoraTP;
    }  
    
    
}