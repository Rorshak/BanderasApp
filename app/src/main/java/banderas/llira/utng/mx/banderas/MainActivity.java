package banderas.llira.utng.mx.banderas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtPais, txtAcietos, txtErrores;
    Button btnAceptar, btnNuevo;
    ImageView imgBandera;
    String[] paises = {"Alemania", "Argentina", "Australia", "Austria", "Brasil",
            "Bahamas", "Chile", "México"};
    int x;
    int acierto = 1;
    int error = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate - Relacionar los objetos de la vista con la clase
        txtPais = findViewById(R.id.txt_pais);
        txtAcietos = findViewById(R.id.txt_aciertos);
        txtErrores = findViewById(R.id.txt_errores);
        imgBandera = findViewById(R.id.img_bandera);
        btnAceptar = findViewById(R.id.btn_aceptar);
        btnNuevo = findViewById(R.id.btn_nuevo);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                x = random.nextInt(paises.length);
                switch (x) {
                    case 0:
                        imgBandera.setBackgroundDrawable(getResources().getDrawable(R.drawable.alemania));
                        break;
                    case 1:
                        imgBandera.setBackgroundDrawable(getResources().getDrawable(R.drawable.argentina));
                        break;
                    case 2:
                        imgBandera.setBackgroundDrawable(getResources().getDrawable(R.drawable.australia));
                        break;
                    case 3:
                        imgBandera.setBackgroundDrawable(getResources().getDrawable(R.drawable.austria));
                        break;
                    case 4:
                        imgBandera.setBackgroundDrawable(getResources().getDrawable(R.drawable.brasil));
                        break;
                    case 5:
                        imgBandera.setBackgroundDrawable(getResources().getDrawable(R.drawable.bahamas));
                        break;
                    case 6:
                        imgBandera.setBackgroundDrawable(getResources().getDrawable(R.drawable.chile));
                        break;
                    case 7:
                        imgBandera.setBackgroundDrawable(getResources().getDrawable(R.drawable.mexico));
                        break;
                }
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String respuesta;
                String pais;
                pais = paises[x];
                respuesta = txtPais.getText().toString();
                if (respuesta.equals(pais)) {
                    Toast.makeText(getApplication(), "Correcto", Toast.LENGTH_LONG).show();
                    System.out.println("Acierto");
                    txtAcietos.setText("Aciertos: " + acierto++);
                } else {
                    Toast.makeText(getApplication(), "Incorrecto es... " + pais, Toast.LENGTH_LONG).show();
                    System.out.println("Error");
                    txtErrores.setText("Errores: " + error++);
                }
            }
        });
    }

}//End class
