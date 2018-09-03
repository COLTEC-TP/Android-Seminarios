package com.example.italo.reconhecevoz;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    // id necessário porem pode ser qualquer número
    private final int ID_TEXTO_VOZ = 43;

    Button btnfala;
    TextView txtcapiturado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnfala = (Button) findViewById(R.id.botao_fala);
        txtcapiturado = (TextView) findViewById(R.id.texto_falado);

        btnfala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Reconhecimento de voz
                Intent intentVoz = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH );

                // Setar idioma e modo de fala livre
                intentVoz.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

                // Pega a lingua padrão do celular e reconhece o que é dito através dela
                intentVoz.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

                // Mensasem Prompt
                intentVoz.putExtra(RecognizerIntent.EXTRA_PROMPT,"Fale o que desejar ");

                    try{
                        startActivityForResult(intentVoz,ID_TEXTO_VOZ);
                    }

                    catch (ActivityNotFoundException a){
                        Toast.makeText(getApplicationContext(),"Seu celular não suporta comando de foz",
                                Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }

    @Override
    protected void onActivityResult(int id,int resultCodeID,Intent dados){
        super.onActivityResult(id,resultCodeID,dados);

            switch (id){

                case ID_TEXTO_VOZ:

                    if (resultCodeID == RESULT_OK && null != dados){

                        ArrayList<String> result = dados.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        String ditado = result.get(0);

                        Toast.makeText(getApplicationContext(),ditado,Toast.LENGTH_SHORT).show();

                        txtcapiturado.setText(ditado);
                    }
             break;

            }
      }

}
