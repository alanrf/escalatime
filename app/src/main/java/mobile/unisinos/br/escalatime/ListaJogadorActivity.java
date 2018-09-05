package mobile.unisinos.br.escalatime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Set;

import mobile.unisinos.br.escalatime.adapter.JogadorAdapter;
import mobile.unisinos.br.escalatime.db.DBJogador;
import mobile.unisinos.br.escalatime.pojo.Jogador;

public class ListaJogadorActivity extends AppCompatActivity {

    private DBJogador dbJogador;
    private Jogador[] arrayJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jogador);

        dbJogador = new DBJogador(this);
        defineComportamentoNovo();
        defineComportamentoLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaLista();
    }

    /**
     * Atualiza a lista apresentada no listView
     */
    private void atualizaLista() {
        Set<Jogador> list = dbJogador.retornarJogadores();
        arrayJogador = list.toArray(new Jogador[list.size()]);
        JogadorAdapter adapter = new JogadorAdapter(this, arrayJogador);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }

    /**
     * Faz o bind do botão "NOVO" para ir para tela de cadastro.
     */
    private void defineComportamentoNovo() {
        Button bt = (Button) findViewById(R.id.btNovo);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(ListaJogadorActivity.this, CadastraJogadorActivity.class);
                it.putExtra("novo", true);
                startActivity(it);
            }

        });
    }

    /**
     * Define o comportamento para quando seleciona um item da lista
     */
    private void defineComportamentoLista() {
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Jogador v = arrayJogador[i];

                        Intent it = new Intent(ListaJogadorActivity.this, CadastraJogadorActivity.class);
                        it.putExtra("novo", false);
                        it.putExtra("id", v.getId());
                        it.putExtra("nome", v.getNome());
                        it.putExtra("posicao", v.getPosicao());
                        it.putExtra("partidas", v.getPartidas());
                        it.putExtra("vitorias", v.getVitorias());
                        it.putExtra("derrotas", v.getDerrotas());
                        it.putExtra("empates", v.getEmpates());

                        startActivity(it);
                    }
                }
        );
    }
}
