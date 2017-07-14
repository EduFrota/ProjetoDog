package projetodog.com.edu.projetodog.Adapter;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import projetodog.com.edu.projetodog.Other.ConectarServico;
import projetodog.com.edu.projetodog.Other.Dog;
import projetodog.com.edu.projetodog.R;
import projetodog.com.edu.projetodog.sqlite.BancoController;
import projetodog.com.edu.projetodog.sqlite.CriarBanco;

/**
 * Created by edu-f on 14/07/2017.
 */

public class AdapterTodos extends RecyclerView.Adapter<AdapterTodos.MyViewHolder> {

    private List<Dog> dogList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nome, raca, idade, temperamento;

        public MyViewHolder(View view) {
            super(view);
            nome = (TextView) view.findViewById(R.id.nome);
            raca = (TextView) view.findViewById(R.id.raca);
            idade = (TextView) view.findViewById(R.id.idade);
            temperamento = (TextView) view.findViewById(R.id.temperamento);
        }
    }

    public AdapterTodos(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_todos, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Dog movie = dogList.get(position);
        holder.nome.setText(movie.getNome());
        holder.idade.setText(movie.getIdade());
        holder.raca.setText(movie.getRaca());
        holder.temperamento.setText(movie.getTemperamento());
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }
}
