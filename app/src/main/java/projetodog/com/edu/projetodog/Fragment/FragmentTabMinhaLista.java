package projetodog.com.edu.projetodog.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import projetodog.com.edu.projetodog.Activity.TelaDog;
import projetodog.com.edu.projetodog.Adapter.AdapterTodos;
import projetodog.com.edu.projetodog.Other.AddCaes;
import projetodog.com.edu.projetodog.Other.ConectarServico;
import projetodog.com.edu.projetodog.Other.Dog;
import projetodog.com.edu.projetodog.R;
import projetodog.com.edu.projetodog.interfaces.ItemClickListenner;
import projetodog.com.edu.projetodog.interfaces.RetornoStringWebService;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTabMinhaLista extends Fragment implements RetornoStringWebService {
    private List<Dog> dogList;
    private RecyclerView recyclerView;
    private AdapterTodos mAdapter;

    public FragmentTabMinhaLista() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_minha_lista, container, false);
        new ConectarServico(getActivity(),this).execute();

        dogList = new ArrayList<>();
        AddCaes addCaes = new AddCaes();
        dogList = addCaes.returnMyDogList();


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_minha);

        mAdapter = new AdapterTodos(dogList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        mAdapter.setOnItemClickListener(new ItemClickListenner() {
            @Override
            public void onItemClick(int position) {
                Log.i("tag","Elemento="+ dogList.get(0));
                Intent intent = new Intent(getActivity(), TelaDog.class);
                intent.putExtra("dog", dogList.get(0));
                startActivity(intent);
            }
        });

        //prepareMovieData();
        return view;

    }










    @Override
    public void retornoStrongWebService(String result) {
        Log.i("Script","Retorno webservice lista = "+result);

        try {
            JSONArray jsonArray = new JSONArray(result);
            Log.i("script", "Number of entries " + jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Log.i("script", jsonObject.getString("nome"));
               /* Dog movie = new Dog(jsonObject.getString("nome"), jsonObject.getString("raca"),
                        jsonObject.getString("idade"),jsonObject.getString("temperamento"), jsonObject.getInt("meus"));
                if (jsonObject.getInt("meus")== 1){
                    movieList.add(movie);
                } */
            }

            mAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            Log.i("Scrip", ""+e);
        }
    }
}

