package mobile.unisinos.br.escalatime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mobile.unisinos.br.escalatime.db.DBJogador;
import mobile.unisinos.br.escalatime.pojo.Jogador;
import mobile.unisinos.br.escalatime.util.Utilitario;

public class CadastraJogadorActivity extends AppCompatActivity {

    private boolean bNnovo;
    private DBJogador dbJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_jogador);
        dbJogador = new DBJogador(this);
        bindBotoes();
        obterDadosActivityLista();
    }

    /**
     * Faz o bind das ações para os botões
     */
    private void bindBotoes() {
        Button btSalvar  = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validaCampos()) {
                    gravar();
                    finish();
                }
            }
        });

        Button btCancelar = (Button) findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (!bNnovo) {
            Button btDeletar = (Button) findViewById(R.id.btDeletar);
            btDeletar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    excluir();
                    Utilitario.getInstance().exibeMensagem("Veículo excluído com sucesso.", CadastraJogadorActivity.this);
                    finish();
                }
            });
            btDeletar.setVisibility(View.VISIBLE);
        }
    }

    private boolean validaCampos() {
        return true;
    }

    private void excluir() {

    }

    private void gravar() {
        Jogador jogador = new Jogador();
        if (bNnovo) {
            dbJogador.inserirJogador(jogador);
        } else {
            dbJogador.atualizarJogador(jogador);
        }
    }

    /**
     * Obtem os dados passados pela activity de listagem para esta.
     */
    private void obterDadosActivityLista() {
        bNnovo = getIntent().getExtras().getBoolean("novo");
    }
}
