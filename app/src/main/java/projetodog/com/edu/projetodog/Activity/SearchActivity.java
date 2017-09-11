package projetodog.com.edu.projetodog.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import projetodog.com.edu.projetodog.R;

import static projetodog.com.edu.projetodog.Activity.MainActivity.navItemIndex;

public class SearchActivity extends AppCompatActivity {
    TextView busca;
    LinearLayout v;
    Switch s;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Aplicar Filtro");

        Spinner spinner_Raca = (Spinner) findViewById(R.id.spinner_raca);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.raca_Spinner, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_Raca.setAdapter(adapter);

        Spinner spinner_estado = (Spinner) findViewById(R.id.spinner_Estado);
        ArrayAdapter adapter_estado = ArrayAdapter.createFromResource(this, R.array.estado_Spinner, R.layout.spinner_item);
        adapter_estado.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_estado.setAdapter(adapter_estado);

        Spinner spinner_cidade = (Spinner) findViewById(R.id.spinner_cidade);
        ArrayAdapter adapter_cidade = ArrayAdapter.createFromResource(this, R.array.cidade_Spinner, R.layout.spinner_item);
        adapter_cidade.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_cidade.setAdapter(adapter_cidade);

        Spinner spinner_pelo1 = (Spinner) findViewById(R.id.spinner_pelo1);
        ArrayAdapter adapter_pelo1 = ArrayAdapter.createFromResource(this, R.array.pelagem_Spinner, R.layout.spinner_item);
        adapter_pelo1.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_pelo1.setAdapter(adapter_pelo1);

        Spinner spinner_cor = (Spinner) findViewById(R.id.spinner_corpelo);
        ArrayAdapter adapter_cor = ArrayAdapter.createFromResource(this, R.array.cor_Spinner, R.layout.spinner_item);
        adapter_cor.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_cor.setAdapter(adapter_cor);


        Spinner spinner_temperamento = (Spinner) findViewById(R.id.spinner_temperamento);
        ArrayAdapter adapter_temp = ArrayAdapter.createFromResource(this, R.array.temperamento_spinner, R.layout.spinner_item);
        adapter_temp.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_temperamento.setAdapter(adapter_temp);



        v = (LinearLayout) findViewById(R.id.Linearoculto_telaSearch);
        s = (Switch) findViewById(R.id.switch_Busca);
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
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_genero_macho:
                if (checked)
                    Log.i("Clicado", "radioMAcho");
                break;
            case R.id.radio_genero_femea:
                if (checked)
                    // Ninjas rule
                    break;


        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_vacina:
                if (checked)
                Log.i("Clicou", "Check");
            else
                // Remove the meat
                break;

                // Cheese me
            // TODO: Veggie sandwich
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_ok:
                Intent intent = new Intent(SearchActivity.this, Resultado_Busca.class);
                startActivity(intent);
                 return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}







