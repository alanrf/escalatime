package mobile.unisinos.br.escalatime.util;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by alan on 02/11/2016.
 * Classe com alguns métodos prontos para serem utilizados por outras classes, especialmente Activities
 */
public final class Utilitario {
    private static Utilitario util;

    //Para esconder o construtor
    private Utilitario() {}

    //Para gerar um singleton da classe
    public static Utilitario getInstance() {
        if (util == null) {
            util = new Utilitario();
        }
        return util;
    }

    /**
     * Valida se o campo está vazio
     * @return boolean
     */
    public boolean campoPreenchido(EditText ed) {
        if (ed.getText() == null || "".equals(ed.getText().toString().trim())) {
            ed.setError("Este campo deve estar preenchido com um valor.");
            return false;
        }
        return true;
    }

    /**
     * Método para ocultar o teclado virtual que fica sobre o texto.
     */
    public void escondeTeclado(AppCompatActivity activity) {
        try {
            View view = activity.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            // esconder exceção, caso ocorra, esse código é apenas para tentar ocultar o teclado
            // para a mensagem ficar mais visivel
        }
    }

    /**
     * Exibe uma mensagem na tela (Toast)
     */
    public void exibeMensagem(CharSequence strMensagem, AppCompatActivity activity) {
        Toast toast = Toast.makeText(activity.getApplicationContext(), strMensagem, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}
