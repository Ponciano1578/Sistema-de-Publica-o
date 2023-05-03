public class ArmazenamentoTermoDeCovocacao {
    private String link;
    private String nome;
    private String cargo;
    private String data;
  
    public ArmazenamentoTermoDeCovocacao(String link, String nome, String cargo, String data) {
        this.link = link;
        this.nome = nome;
        this.cargo = cargo;
        this.data = data;
    }
  
    public String getLink() {
        return link;
    }
  
    public void setLink(String link) {
        this.link = link;
    }
  
    public String getNome() {
        return nome;
    }
  
    public void setNome(String nome) {
        this.nome = nome;
    }
  
    public String getCargo() {
        return cargo;
    }
  
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
  
    public String getData() {
        return data;
    }
  
    public void setData(String data) {
        this.data = data;
    }
}