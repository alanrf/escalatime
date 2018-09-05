package mobile.unisinos.br.escalatime.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mobile.unisinos.br.escalatime.R;
import mobile.unisinos.br.escalatime.pojo.Jogador;

/**
 * Created by alan on 10/08/2016.
 */
public class JogadorAdapter extends ArrayAdapter<Jogador> {
        private final Context context;
        private final Jogador[] values;

        public JogadorAdapter(Context context, Jogador[] objects) {
            super(context, R.layout.lista_row_jogador, objects);
            this.context = context;
            this.values = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.lista_row_jogador, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.label);
            Jogador v = values[position];
            textView.setText(v.getNome() +" - "+ v.getPosicao());

            if (position % 2 == 1) {
                rowView.setBackgroundColor(Color.WHITE);
            } else {
                rowView.setBackgroundColor(Color.CYAN);
            }

            return rowView;
        }
}
