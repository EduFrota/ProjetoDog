package projetodog.com.edu.projetodog.Fragment;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import projetodog.com.edu.projetodog.R;
import projetodog.com.edu.projetodog.sqlite.BancoController;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastrarFragment extends Fragment {
    EditText editText_nome;
    EditText editText_raca;
    EditText editText_idade;
    Button button_cadastrar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cadastrar, container, false);

        editText_nome = (EditText) view.findViewById(R.id.EditText_nome);
        editText_raca = (EditText) view.findViewById(R.id.EditText_raca);
        editText_idade = (EditText) view.findViewById(R.id.EditText_idade);
        button_cadastrar = (Button) view.findViewById(R.id.Button_cadastro);


        button_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getActivity());

                String nomeString = editText_nome.getText().toString();
                String racarString = editText_raca.getText().toString();
                String idadeString = editText_idade.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeString,racarString,idadeString);

                Toast.makeText(getActivity(), resultado, Toast.LENGTH_LONG).show();



            }
        });



        return view;

    }

}
