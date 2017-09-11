package projetodog.com.edu.projetodog.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import projetodog.com.edu.projetodog.Activity.MainActivity;
import projetodog.com.edu.projetodog.Activity.SearchActivity;
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
public class FragmentTabTodos extends Fragment implements RetornoStringWebService {
    private List<Dog> movieList;
    private RecyclerView recyclerView;
    private AdapterTodos mAdapter;
    private FloatingActionButton fab;


    public FragmentTabTodos() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_todos, container, false);



        new ConectarServico(getActivity(),this).execute();
        movieList = new ArrayList<>();
        AddCaes addCaes = new AddCaes();
        movieList = addCaes.returnTodos();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_todos);

        mAdapter = new AdapterTodos(movieList,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        mAdapter.setOnItemClickListener(new ItemClickListenner() {
            @Override
            public void onItemClick(int position) {
                Dog d = movieList.get(position);
                Log.i("tag","Elemento="+ movieList.get(position));
                Intent intent = new Intent(getActivity(), TelaDog.class);
                intent.putExtra("dog", movieList.get(position));
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
                movieList.add(movie);
                 //Integer.parseInt( jsonObject.getString("idade")==1){
                //if(     jsonObject.getString("idade") == 1){
                  //  add. */
                }

            mAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            Log.i("Scrip", ""+e);
        }
    }
}