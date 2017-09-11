package projetodog.com.edu.projetodog.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import projetodog.com.edu.projetodog.Other.Dog;
import projetodog.com.edu.projetodog.R;

public class TelaDog extends AppCompatActivity {
    private ImageView img;
    private TextView estado;
    private TextView cidade;
    private TextView peso;
    private TextView sexo;
    private TextView idade;
    private TextView raca;
    private TextView comprimento;
    private TextView filho_ninhada;
    private TextView proximo_cio;
    private TextView altura_Cernelha;
    private TextView temperamento1;
    private TextView temperamento2;
    private TextView temperamento3;
    private TextView tipoPelo;
    private TextView corPelo1;
    private TextView corPelo2;
    private TextView vacina;
    private TextView nomeMaee;
    private TextView nomePai;
    private TextView pedigree;
    public Context context;
    Toolbar myToolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dog);

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        img = (ImageView) findViewById(R.id.imageView_cao);
        altura_Cernelha = (TextView) findViewById(R.id.valor_cernelha);
        estado = (TextView) findViewById(R.id.text_estado_Dog);
        cidade = (TextView) findViewById(R.id.text_cidade_Dog);
        peso = (TextView) findViewById(R.id.valor_peso);
        sexo = (TextView) findViewById(R.id.text_sexo_Dog);
        idade = (TextView) findViewById(R.id.text_idade_Dog);
        raca = (TextView) findViewById(R.id.text_raca_Dog);
        comprimento = (TextView) findViewById(R.id.valor_comprmento);
        altura_Cernelha = (TextView) findViewById(R.id.valor_cernelha);
        temperamento1 = (TextView) findViewById(R.id.temp1);
        temperamento2 = (TextView) findViewById(R.id.temp2);
        temperamento3 = (TextView) findViewById(R.id.temp3);
        tipoPelo = (TextView) findViewById(R.id.valor_pelagem);
        corPelo1 = (TextView) findViewById(R.id.cor1);
        corPelo2 = (TextView) findViewById(R.id.cor2);
        nomeMaee = (TextView) findViewById(R.id.Nome_mãe);
        nomePai = (TextView) findViewById(R.id.Nome_Pai);
        pedigree = (TextView) findViewById(R.id.rg);
        vacina = (TextView) findViewById(R.id.vacinar);
        filho_ninhada = (TextView) findViewById(R.id.filhotes_ninhafa);
        proximo_cio = (TextView) findViewById(R.id.valor_data_cio);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Dog d = (Dog) intent.getExtras().getSerializable("dog");
        Log.i("tag", "Elemento" + d.getNome());

        getSupportActionBar().setTitle(d.getNome());

        pedigree.setText(d.getRg());
        nomePai.setText(d.getNome_pai());
        nomeMaee.setText(d.getNome_mãe());
        corPelo2.setText(d.getCor2());
        corPelo1.setText(d.getCor1());
        tipoPelo.setText(d.getPelo());
        temperamento1.setText(d.getTemperamento1());
        temperamento2.setText(d.getGetTemperamento2());
        temperamento3.setText(d.getTemperamento3());
        altura_Cernelha.setText(d.getAltura());
        proximo_cio.setText(d.getData_cio());
        filho_ninhada.setText(d.getFilhotes_ninhada());
        cidade.setText(d.getCidade());
        estado.setText(d.getEstado());
        peso.setText(d.getPeso());

        if (d.getGenero() == 1) {
            sexo.setText("Macho");
        } else {
            sexo.setText("Fêmea");
        }

        idade.setText(d.getIdade());
        raca.setText(d.getRaca());
        comprimento.setText(d.getComprimento());
        Picasso.with(context)
                .load(d.getUrl())
                .into(img);

        if(d.getVacina() == 1){
            vacina.setText("Vacinado");
        }else {
            vacina.setText("Não Vacinado");
        }

    }
}
