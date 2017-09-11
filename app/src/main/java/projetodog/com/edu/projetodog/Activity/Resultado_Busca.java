package projetodog.com.edu.projetodog.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import projetodog.com.edu.projetodog.Adapter.AdapterTodos;
import projetodog.com.edu.projetodog.Other.AddCaes;
import projetodog.com.edu.projetodog.Other.Dog;
import projetodog.com.edu.projetodog.R;
import projetodog.com.edu.projetodog.interfaces.ItemClickListenner;

public class Resultado_Busca extends AppCompatActivity {
    private List<Dog> movieList;
    private RecyclerView recyclerView;
    private AdapterTodos mAdapter;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado__busca);

         myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Resultado da Busca");


        movieList = new ArrayList<>();

        AddCaes addCaes = new AddCaes();
        movieList = addCaes.returnTodos();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_busca);

        mAdapter = new AdapterTodos(movieList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        mAdapter.setOnItemClickListener(new ItemClickListenner() {
            @Override
            public void onItemClick(int position) {
                Log.i("tag","Elemento="+ movieList.get(position));
                Intent intent = new Intent(Resultado_Busca.this, TelaDog.class);
                intent.putExtra("dog", movieList.get(position));
                startActivity(intent);
            }
        });

        //prepareMovieData();

    }


    }

