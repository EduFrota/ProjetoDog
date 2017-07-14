package projetodog.com.edu.projetodog.Fragment;


import android.database.Cursor;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import projetodog.com.edu.projetodog.Adapter.AdapterTodos;
import projetodog.com.edu.projetodog.Other.ConectarServico;
import projetodog.com.edu.projetodog.Other.Dog;
import projetodog.com.edu.projetodog.R;
import projetodog.com.edu.projetodog.interfaces.RetornoStringWebService;
import projetodog.com.edu.projetodog.sqlite.BancoController;
import projetodog.com.edu.projetodog.sqlite.CriarBanco;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTabTodos extends Fragment implements RetornoStringWebService {
    private List<Dog> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterTodos mAdapter;

    public FragmentTabTodos() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_todos, container, false);

        new ConectarServico(getActivity(),this).execute();





        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new AdapterTodos(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

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
                Dog movie = new Dog(jsonObject.getString("nome"), jsonObject.getString("raca"),
                        jsonObject.getString("idade"),jsonObject.getString("temperamento"));
                movieList.add(movie);
                 //Integer.parseInt( jsonObject.getString("idade")==1){
                //if(     jsonObject.getString("idade") == 1){
                  //  add.
                }

            mAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            Log.i("Scrip", ""+e);
        }
    }
}