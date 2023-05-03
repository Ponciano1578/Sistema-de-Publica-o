public class ArmazenamentoPregaoPresencial {
    private String LinkPregao;
    private String NumeroPregao;
    private String NumeroProcesso;
    private String DescricaoPregao;
    private String DataPregao;
    private String HoraPregao;
  
    public ArmazenamentoPregaoPresencial(String LinkPregao, String NumeroPregao, String NumeroProcesso, String DescricaoPregao, String DataPregao, String HoraPregao) {
        this.LinkPregao = LinkPregao;
        this.NumeroPregao = NumeroPregao;
        this.NumeroProcesso = NumeroProcesso;
        this.DescricaoPregao = DescricaoPregao;
        this.DataPregao = DataPregao;
        this.HoraPregao = HoraPregao;
    }
  
    public String getLinkPregao() {
        return LinkPregao;
    }
  
    public void setLinkPregao(String LinkPregao) {
        this.LinkPregao = LinkPregao;
    }
  
    public String getNumeroPregao() {
        return NumeroPregao;
    }
  
    public void setNumeroPregao(String NumeroPregao) {
        this.NumeroPregao = NumeroPregao;
    }
  
    public String getNumeroProcesso() {
        return NumeroProcesso;
    }
  
    public void setNumeroProcesso(String NumeroProcesso) {
        this.NumeroProcesso = NumeroProcesso;
    }
    public String getDescricaoPregao() {
        return DescricaoPregao;
    }
  
    public void setDescricaoPregao(String DescricaoPregao) {
        this.DescricaoPregao = DescricaoPregao;
    }  
    public String getDataPregao() {
        return DataPregao;
    }
  
    public void setDataPregao(String DataPregao) {
        this.DataPregao = DataPregao;
    }  
    public String getHoraPregao() {
        return HoraPregao;
    }
  
    public void setHoraPregao(String HoraPregao) {
        this.HoraPregao = HoraPregao;
    }  
    
    
}