public class ArmazenamentoLeiOrdinaria {
    private String link;
    private String NomeLei;
    private String TextoLei;

    
    public ArmazenamentoLeiOrdinaria(String link, String NomeLei, String TextoLei) {
        this.link = link;
        this.NomeLei = NomeLei;
        this.TextoLei = TextoLei;
     
    }
  
    public String getLink() {
        return link;
    }
  
    public void setLink(String link) {
        this.link = link;
    }
  
    public String getNomeLei() {
        return NomeLei;
    }
  
    public void setNomeLei(String NomeLei) {
        this.NomeLei = NomeLei;
    }
  
    public String getTextoLei() {
        return TextoLei;
    }
  
    public void setTextoLei(String TextoLei) {
        this.TextoLei = TextoLei;
    }
  
    
}