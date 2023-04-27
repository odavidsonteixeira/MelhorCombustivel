package telas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.etanolxgasolina.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button limpar = findViewById(R.id.bLimpar);
        limpar.setOnClickListener(v -> {
            EditText user = findViewById(R.id.eTUsuario);
            EditText senha = findViewById(R.id.eTSenha);
            user.setText("");
            senha.setText("");
            user.requestFocus();

        });
    }
    public void limpar(){
        EditText user = findViewById(R.id.eTUsuario);
        EditText senha = findViewById(R.id.eTSenha);
        user.setText("");
        senha.setText("");
        user.requestFocus();
    }
    public void logar(View v){
        EditText usuario = findViewById(R.id.eTUsuario);
        EditText senha = findViewById(R.id.eTSenha);
        if(usuario.getText().length()<=0){
            usuario.setError(getString(R.string.digusu));
            usuario.requestFocus();
        } if(senha.getText().length()<=0){
            senha.setError(getString(R.string.digsen));
            senha.requestFocus();
        }else if(usuario.getText().toString().equals("admin")&&
        senha.getText().toString().equals("admin")){
            //tentativa de abrir a segunda tela
            Intent it = new Intent(this, Tela2Activity.class);
            //enviando valor para outra tela
            it.putExtra("nome",usuario.getText().toString());
            //iniciar a segunda tela
            startActivity(it);
        } else {

            Context context = getApplicationContext();
            @SuppressLint("ResourceType") String text = String.valueOf(findViewById(R.string.dus));
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, R.string.dus, duration);
            toast.show();

            limpar();

//
//            AlertDialog.Builder builder = new AlertDialog.Builder(context);
//            builder.setTitle("Erro de login");
//
//            builder.setMessage(R.string.dus)
//                    .setCancelable(false)
//                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                        }
//                    })
//                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            getDialog().cancel();
//                        }
//                    });
//
//            Alerta alerta = new Alerta();
//           alerta.showNow(getSupportFragmentManager(), null);

        }
    }
}