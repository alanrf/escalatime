package mobile.unisinos.br.escalatime.pojo;

/**
 * Created by alan on 09/08/2016.
 */
public class Jogador {
    private int id;
    private String nome;
    private String posicao;
    private int partidas;
    private int vitorias;
    private int derrotas;
    private int empates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getPartidas() {
        return partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Jogador && this.id == ((Jogador) obj).getId();
    }
}
