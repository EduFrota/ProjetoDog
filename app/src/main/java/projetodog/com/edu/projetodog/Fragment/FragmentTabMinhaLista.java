package projetodog.com.edu.projetodog.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projetodog.com.edu.projetodog.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTabMinhaLista extends Fragment {


    public FragmentTabMinhaLista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_minha_lista, container, false);
    }

}
