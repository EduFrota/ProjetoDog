package projetodog.com.edu.projetodog.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import projetodog.com.edu.projetodog.Other.ConectarServico;
import projetodog.com.edu.projetodog.Other.Dog;
import projetodog.com.edu.projetodog.R;
import projetodog.com.edu.projetodog.interfaces.ItemClickListenner;
import projetodog.com.edu.projetodog.sqlite.BancoController;
import projetodog.com.edu.projetodog.sqlite.CriarBanco;

/**
 * Created by edu-f on 14/07/2017.
 */

public class AdapterTodos extends RecyclerView.Adapter<AdapterTodos.MyViewHolder>  {

    private List<Dog> dogList;
    public Context context;
    public ImageView img;
    private static ItemClickListenner itemClickListener;



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView nome, raca, genrer;


        public MyViewHolder(View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.img_dog);
            nome = (TextView) view.findViewById(R.id.textView_nome);
            raca = (TextView) view.findViewById(R.id.textView_raca);
            genrer = (TextView) view.findViewById(R.id.textView_gener);
            view.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            if(itemClickListener != null) {
                itemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }



    public AdapterTodos(List<Dog> dogList, Context c) {
        this.dogList = dogList;
        this.context = c;
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
        holder.raca.setText(movie.getRaca());

        if (movie.getGenero() == 1) {
            holder.genrer.setText("Macho");
        }else{
                holder.genrer.setText("Fêmea");
            }

        Picasso.with(context)
                .load(movie.getUrl())
                .placeholder(R.drawable.cao)
                .into(img);


    }
    public void setOnItemClickListener(ItemClickListenner itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }
}
