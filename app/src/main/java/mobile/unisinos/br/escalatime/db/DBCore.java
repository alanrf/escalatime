package mobile.unisinos.br.escalatime.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alan on 24/07/2016.
 */
public class DBCore extends SQLiteOpenHelper {

    private static final String NOME_BD = "bdEscalaTime";
    private static final int VERSAO_BD = 1;

    public DBCore(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //cria a tabela jogador
        sqLiteDatabase.execSQL("create table jogador (" +
                "_id integer primary key autoincrement, " +
                "nome text not null, " +
                "posicao text not null, " +
                "partidas int not null, " +
                "vitorias int not null, " +
                "empates int not null, " +
                "derrotas int not null);");

        //cria a tabela quadra
        sqLiteDatabase.execSQL("create table quadra (" +
                "_id integer primary key autoincrement, " +
                "nome text not null, " +
                "tamanho text not null, "+
                "endereco text not null, " +
                "email text, " +
                "telefone text);");

        //cria a tabela partida
        sqLiteDatabase.execSQL("create table partida (" +
                "_id integer primary key autoincrement, " +
                "_id_quadra int not null, " +
                "placar_time_1 int not null, " +
                "placar_time_2 int not null, " +
                "data text not null, " +
                "FOREIGN KEY (_id_quadra) REFERENCES quadra(_id)" +
                ");");

        //cria a tabela partida_jogador
        sqLiteDatabase.execSQL("create table partida_jogador (_id integer primary key autoincrement, " +
                "_id_partida int not null, " +
                "_id_jogador int not null, " +
                "time int, " +
                "FOREIGN KEY (_id_partida) REFERENCES partida(_id), " +
                "FOREIGN KEY (_id_jogador) REFERENCES jogador(_id) " +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // caso mude a versâo deve ter scripts de migração ou apenas readequar a base atual
    }
}
