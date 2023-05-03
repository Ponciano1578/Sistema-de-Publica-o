public class ArmazenamentoLeiComplementar {
    private String link;
    private String NomeLeiComplementar;
    private String TextoLei;

    
    public ArmazenamentoLeiComplementar(String link, String NomeLeiComplementar, String TextoLei) {
        this.link = link;
        this.NomeLeiComplementar = NomeLeiComplementar;
        this.TextoLei = TextoLei;
     
    }
  
    public String getLink() {
        return link;
    }
  
    public void setLink(String link) {
        this.link = link;
    }
  
    public String getNomeLeiComplementar() {
        return NomeLeiComplementar;
    }
  
    public void setNomeLeiComplementar(String NomeLeiComplementar) {
        this.NomeLeiComplementar = NomeLeiComplementar;
    }
  
    public String getTextoLei() {
        return TextoLei;
    }
  
    public void setTextoLei(String TextoLei) {
        this.TextoLei = TextoLei;
    }
  
    
}