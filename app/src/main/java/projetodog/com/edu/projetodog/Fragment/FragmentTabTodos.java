package projetodog.com.edu.projetodog.Fragment;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import projetodog.com.edu.projetodog.R;
import projetodog.com.edu.projetodog.sqlite.BancoController;
import projetodog.com.edu.projetodog.sqlite.CriarBanco;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTabTodos extends Fragment {
    private ListView lista;

    public FragmentTabTodos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_tab_todos, container, false);


        BancoController crud = new BancoController(getActivity());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {CriarBanco.ID, CriarBanco.NOME, CriarBanco.RACA,CriarBanco.IDADE};
        int[] idViews = new int[] {R.id.idDog, R.id.nomeDog, R.id.nomeRaca, R.id.idadeDog};


        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getActivity(),
                R.layout.lista_layout,cursor,nomeCampos,idViews, 0);
        lista = (ListView)view.findViewById(R.id.listView);
        lista.setAdapter(adaptador);
        return view;
    }

    }

