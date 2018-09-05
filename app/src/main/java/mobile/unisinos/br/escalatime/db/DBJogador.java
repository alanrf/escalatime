package mobile.unisinos.br.escalatime.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashSet;
import java.util.Set;

import mobile.unisinos.br.escalatime.pojo.Jogador;


/**
 * Created by alan on 24/07/2016.
 */
public class DBJogador {

    private SQLiteDatabase db;

    public DBJogador(Context context) {
        DBCore access = new DBCore(context);
        db = access.getWritableDatabase();
    }

    public void inserirJogador(Jogador jogador) {
        ContentValues values = new ContentValues();
        values.put("nome", jogador.getNome());
        values.put("posicao", jogador.getPosicao());
        values.put("partidas", jogador.getPartidas());
        values.put("vitorias", jogador.getVitorias());
        values.put("derrotas", jogador.getDerrotas());
        values.put("empates", jogador.getEmpates());

        db.insert("jogador", null, values);
    }

    public void atualizarJogador(Jogador jogador) {
        ContentValues values = new ContentValues();
        values.put("nome", jogador.getNome());
        values.put("posicao", jogador.getPosicao());
        values.put("partidas", jogador.getPartidas());
        values.put("vitorias", jogador.getVitorias());
        values.put("derrotas", jogador.getDerrotas());
        values.put("empates", jogador.getEmpates());

        db.update("jogador", values, "_id = ?", new String[]{String.valueOf(jogador.getId())});
    }

    public void deletarJogador(Jogador jogador) {
        db.delete("jogador", "_id = ?", new String[]{String.valueOf(jogador.getId())});
    }

    public Set<Jogador> retornarJogadores() {
        String[] columns = {"_id", "nome", "posicao", "partidas", "vitorias", "derrotas", "empates"};
        Set<Jogador> set = new HashSet<Jogador>();
        Cursor cursor = db.query("jogador", columns, null, null, null, null, "nome ASC");

        try {
            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    Jogador jogador = new Jogador();
                    jogador.setId(cursor.getInt(0));
                    jogador.setNome(cursor.getString(1));
                    jogador.setPosicao(cursor.getString(2));
                    jogador.setPartidas(cursor.getInt(3));
                    jogador.setVitorias(cursor.getInt(4));
                    jogador.setDerrotas(cursor.getInt(5));
                    jogador.setEmpates(cursor.getInt(6));

                    set.add(jogador);
                }
            }
        } finally {
            cursor.close();
        }

        return set;
    }
}
