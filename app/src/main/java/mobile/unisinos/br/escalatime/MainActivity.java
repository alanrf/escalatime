package mobile.unisinos.br.escalatime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //iniciar na tela de jogador (por enquanto)
        Intent it = new Intent(MainActivity.this, ListaJogadorActivity.class);
        startActivity(it);
    }
}
