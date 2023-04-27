package telas;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.etanolxgasolina.R;

public class Tela2Activity extends AppCompatActivity {
    private EditText alcool, gasolina, resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        //Recebendo o valor enviado
        Intent it = getIntent();
        Toast.makeText(this, "Bem vindo "+it.getStringExtra("nome")+"!",
                Toast.LENGTH_LONG).show();
        Button limpar = findViewById(R.id.bLimpar);
        limpar.setOnClickListener(v -> {
            alcool = findViewById(R.id.eTEtanol);
            gasolina = findViewById(R.id.eTGasolina);
            resultado = findViewById(R.id.eTResultado);
            alcool.setText("");
            gasolina.setText("");
            resultado.setText("");
            alcool.requestFocus();
        });
        Button calcular = findViewById(R.id.bCalcular);
        calcular.setOnClickListener(v -> {
            alcool = findViewById(R.id.eTEtanol);
            gasolina = findViewById(R.id.eTGasolina);
            resultado = findViewById(R.id.eTResultado);
            double valcool, vgasolina;
            String res;
            if (alcool.getText().length() <= 0) {
                alcool.setError(getString(R.string.de));
                alcool.requestFocus();
            } if (gasolina.getText().length() <= 0) {
                gasolina.setError(getString(R.string.dg));
                gasolina.requestFocus();
            } else {
                valcool = Double.parseDouble(alcool.getText().toString());
                vgasolina = Double.parseDouble(gasolina.getText().toString());
                //res = (valcool<vgasolina*0.7?"Etanol":"Gasolina");
                if (valcool < vgasolina * 0.7) {
                    res = "O melhor combustível é Etanol!";
                } else {
                    res = "O melhor combustível é Gasolina!";
                }

                resultado.setText(res);
            }
        });

    }
    public void calcular(View v){
        alcool = findViewById(R.id.eTEtanol);
        gasolina = findViewById(R.id.eTGasolina);
        resultado = findViewById(R.id.eTResultado);
        double valcool, vgasolina;
        String res;
        valcool = Double.parseDouble(alcool.getText().toString());
        vgasolina = Double.parseDouble(gasolina.getText().toString());
        res = (valcool<vgasolina*0.7?"Etanol":"Gasolina");
        resultado.setText(res);
    }
    public void limpar(View v){
        alcool = findViewById(R.id.eTEtanol);
        gasolina = findViewById(R.id.eTGasolina);
        resultado = findViewById(R.id.eTResultado);
        alcool.setText(""); gasolina.setText("");
        resultado.setText(""); alcool.requestFocus();
    }

}