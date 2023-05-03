public class ArmazenamentoPortaria {
    private String link;
    private String NomeFuncionario;
    private String AntesNome;
    private String DepoisNome;
    private String NumeroPortaria;
    
    public ArmazenamentoPortaria(String link, String NomeFuncionario, String AntesNome, String DepoisNome, String NumeroPortaria) {
        this.link = link;
        this.NomeFuncionario = NomeFuncionario;
        this.AntesNome = AntesNome;
        this.DepoisNome = DepoisNome;
        this.NumeroPortaria = NumeroPortaria;
    }
  
    public String getLink() {
        return link;
    }
  
    public void setLink(String link) {
        this.link = link;
    }
  
    public String getNomeFuncionario() {
        return NomeFuncionario;
    }
  
    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }
  
    public String getAntesNome() {
        return AntesNome;
    }
  
    public void setAntesNome(String AntesNome) {
        this.AntesNome = AntesNome;
    }
  
    public String getDepoisNome() {
        return DepoisNome;
    }
  
    public void setDepoisNome(String DepoisNome) {
        this.DepoisNome = DepoisNome;
    }
    public String getNumeroPortaria() {
        return NumeroPortaria;
    }
  
    public void setNumeroPortaria(String NumeroPortaria) {
        this.NumeroPortaria = NumeroPortaria;
    }
}