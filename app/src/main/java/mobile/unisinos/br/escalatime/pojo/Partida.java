package mobile.unisinos.br.escalatime.pojo;

import java.util.Set;

/**
 * Created by alan on 09/08/2016.
 */
public class Partida {

    private int id;
    private Quadra quadra;
    private String data;
    private int placarTime1;
    private int placarTime2;
    private Set<Jogador> jogadoresTime1;
    private Set<Jogador> jogadoresTime2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quadra getQuadra() {
        return quadra;
    }

    public void setQuadra(Quadra quadra) {
        this.quadra = quadra;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getPlacarTime1() {
        return placarTime1;
    }

    public void setPlacarTime1(int placarTime1) {
        this.placarTime1 = placarTime1;
    }

    public int getPlacarTime2() {
        return placarTime2;
    }

    public void setPlacarTime2(int placarTime2) {
        this.placarTime2 = placarTime2;
    }

    public Set<Jogador> getJogadoresTime1() {
        return jogadoresTime1;
    }

    public void setJogadoresTime1(Set<Jogador> jogadoresTime1) {
        this.jogadoresTime1 = jogadoresTime1;
    }

    public Set<Jogador> getJogadoresTime2() {
        return jogadoresTime2;
    }

    public void setJogadoresTime2(Set<Jogador> jogadoresTime2) {
        this.jogadoresTime2 = jogadoresTime2;
    }
}
