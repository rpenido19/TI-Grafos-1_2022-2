package trab_algoritmos_em_grafos;

public class Aresta<TIPO> {
    private String cod;
    private int peso;
    private Vertice<TIPO> inicio;
    private Vertice<TIPO> fim;

    //Getters e Setters
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public Vertice<TIPO> getFim() {
        return fim;
    }
    public void setFim(Vertice<TIPO> fim) {
        this.fim = fim;
    }
    public Vertice<TIPO> getInicio() {
        return inicio;
    }
    public void setInicio(Vertice<TIPO> inicio) {
        this.inicio = inicio;
    }
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    
    //Construtor
    public Aresta(int peso, Vertice<TIPO> inicio, Vertice<TIPO> fim, String cod){
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
        this.cod = cod;
    }
    
}
