package projetodog.com.edu.projetodog.Fragment;


import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;

import projetodog.com.edu.projetodog.Activity.MainActivity;
import projetodog.com.edu.projetodog.Activity.Resultado_Busca;
import projetodog.com.edu.projetodog.Activity.SearchActivity;
import projetodog.com.edu.projetodog.R;
import projetodog.com.edu.projetodog.sqlite.BancoController;

import static android.R.attr.color;
import static android.R.attr.data;
import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastrarFragment extends Fragment {
    ImageView targetImage;
    EditText nome;
    private SeekBar seekBar;
    TextView textView,peso,comprimento,altura,filhotes;
    Switch s;
    CheckBox box;
    RadioGroup radioGroup;
    LinearLayout v,v2;
    private static int DELTA_VALUE = 5;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastrar, container, false);
        setHasOptionsMenu(true);
        nome = (EditText)view.findViewById(R.id.edit_nome);
        peso = (TextView) view.findViewById(R.id.text_peso_cadastro);
        comprimento = (TextView) view.findViewById(R.id.text_comprimento_cadastro);
        altura = (TextView) view.findViewById(R.id.text_altura_cadastro);
        filhotes = (TextView) view.findViewById(R.id.text_filhotes_ninhada);
        seekBar = (SeekBar)view.findViewById(R.id.seek_cadastrar_idade);
        SeekBar seekBarpeso = (SeekBar) view.findViewById(R.id.seek_cadastrar_peso);
        SeekBar seekBarComrprimento = (SeekBar) view.findViewById(R.id.seek_cadastrar_comprimento);
        SeekBar seekBarCernelha = (SeekBar) view.findViewById(R.id.seek_cadastrar_altura);
        SeekBar seekBarFilhotes = (SeekBar) view.findViewById(R.id.seek_cadastrar_filhotes);
        textView = (TextView) view.findViewById(R.id.seekTextIdade);



        Spinner spinner_cadastrar_raca = (Spinner) view.findViewById(R.id.spinner_cadastrar_raca);
        ArrayAdapter adapterraca = ArrayAdapter.createFromResource(getActivity(), R.array.raca_Spinner, R.layout.spinner_item);
        adapterraca.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_cadastrar_raca.setAdapter(adapterraca);

        Spinner spinner_cadastrar_cor1 = (Spinner) view.findViewById(R.id.spinner_cadastrar_cor1);
        ArrayAdapter adapter_cor1= ArrayAdapter.createFromResource(getActivity(), R.array.cor_Spinner, R.layout.spinner_item);
        adapter_cor1.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_cadastrar_cor1.setAdapter(adapter_cor1);

        Spinner spinner_cadastrar_cor2 = (Spinner) view.findViewById(R.id.spinner_cadastrar_cor2);
        ArrayAdapter adapter_cor2= ArrayAdapter.createFromResource(getActivity(), R.array.cor_Spinner, R.layout.spinner_item);
        adapter_cor2.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_cadastrar_cor2.setAdapter(adapter_cor2);


        Spinner spinner_cadastrar_temp1 = (Spinner) view.findViewById(R.id.spinner_cadastrar_temperamento1);
        ArrayAdapter adapter_temp1= ArrayAdapter.createFromResource(getActivity(), R.array.temperamento_spinner, R.layout.spinner_item);
        adapter_temp1.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_cadastrar_temp1.setAdapter(adapter_temp1);

        Spinner spinner_cadastrar_temp2 = (Spinner) view.findViewById(R.id.spinner_cadastrar_temperamento2);
        ArrayAdapter adapter_temp2= ArrayAdapter.createFromResource(getActivity(), R.array.temperamento_spinner, R.layout.spinner_item);
        adapter_temp2.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_cadastrar_temp2.setAdapter(adapter_temp2);

        Spinner spinner_cadastrar_temp3 = (Spinner) view.findViewById(R.id.spinner_cadastrar_temperamento3);
        ArrayAdapter adapter_temp3= ArrayAdapter.createFromResource(getActivity(), R.array.temperamento_spinner, R.layout.spinner_item);
        adapter_temp3.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_cadastrar_temp3.setAdapter(adapter_temp3);


        Spinner spinner_cadastrar_pelagem = (Spinner) view.findViewById(R.id.spinner_cadastrar_TipoPelo);
        ArrayAdapter adapter_pelagem= ArrayAdapter.createFromResource(getActivity(), R.array.pelagem_Spinner, R.layout.spinner_item);
        adapter_pelagem.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_cadastrar_pelagem.setAdapter(adapter_pelagem);

        box = (CheckBox) view.findViewById(R.id.checkbox_cadastro_vacina);
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //
                }
            }
        });

         v = (LinearLayout) view.findViewById(R.id.linear_cadastrar_pedigree);
         s = (Switch) view.findViewById(R.id.switch_cadastrar_pedigree);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    v.setVisibility(View.VISIBLE);

                }else{
                    v.setVisibility(View.INVISIBLE);
                }
            }
        });

        radioGroup = (RadioGroup) view.findViewById(R.id.groupradio);
        v2 = (LinearLayout) view.findViewById(R.id.cadastrar_femea);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch(checkedId) {
                    case R.id.radio_genero_macho_cadastro:
                        v2.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.radio_genero_femea_cadastro:
                        v2.setVisibility(View.VISIBLE);
                        // Fragment 2
                        break;
                }

            }
        });



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progresschanged= 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresschanged = progress;


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText(+progresschanged+" anos");
                textView.setTextColor(Color.BLACK);

            }
        });

        seekBarpeso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressoPeso =0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressoPeso = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                peso.setText(+progressoPeso+" kg");
                peso.setTextColor(Color.BLACK);

            }
        });
        seekBarComrprimento.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int comprimentoP = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                comprimentoP = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                comprimento.setText(+comprimentoP+" cm");
                comprimento.setTextColor(Color.BLACK);

            }
        });
        seekBarCernelha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
             int progreeCernelha = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progreeCernelha = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                     altura.setText(+progreeCernelha+" cm");
                     altura.setTextColor(Color.BLACK);
            }
        });

        seekBarFilhotes.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressFilhos = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressFilhos = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                    filhotes.setText(+progressFilhos+" filhotes");
                    filhotes.setTextColor(Color.BLACK);
            }
        });







        nome.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return true;
            }
        });

        ImageView buttonLoadImage = (ImageView) view.findViewById(R.id.loadimage);

        targetImage = (ImageView) view.findViewById(R.id.targetimage);

        buttonLoadImage.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });





        return view;
    }


    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(targetUri));
                targetImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_ok:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

