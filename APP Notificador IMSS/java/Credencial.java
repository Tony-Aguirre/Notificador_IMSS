package mx.com.notificador_imss;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
public class Credencial extends AppCompatActivity {
    String notificador,registro_patronal,atiende,diligencia;
    Spinner identificacion;
    TextView emision,vigencia,nombreID,numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credencial);
        notificador = getIntent().getStringExtra("notificador");
        registro_patronal = getIntent().getStringExtra("registro_patronal");
        atiende = getIntent().getStringExtra("atiende");
        diligencia = getIntent().getStringExtra("diligencia");
        identificacion = (Spinner)findViewById(R.id.spnIdentificacion);
        String [] Identificacion = {"seleccione","INE","Pasaporte","Cedula Profecional"};
        ArrayAdapter<String> adIdentificacion = new ArrayAdapter<String>(this, R.layout.spinner_item_notificadores, Identificacion);
        identificacion.setAdapter(adIdentificacion);
        emision = (TextView)findViewById(R.id.txtEmision);
        vigencia = (TextView)findViewById(R.id.txtVigencia);
        nombreID = (TextView)findViewById(R.id.txtNombreID);
        numero = (TextView)findViewById(R.id.txtNumero);
    }
    //Método de Boton Continuar
    public void Continuar(View view) {
        Intent continuar = new Intent(Credencial.this, Documento.class);
        continuar.putExtra("notificador",notificador);
        continuar.putExtra("registro_patronal",registro_patronal);
        continuar.putExtra("atiende",atiende);
        continuar.putExtra("identificacionID",identificacion.getSelectedItem().toString());
        continuar.putExtra("emisionID",emision.getText().toString());
        continuar.putExtra("vigenciaID",vigencia.getText().toString());
        continuar.putExtra("nombreID",nombreID.getText().toString());
        continuar.putExtra("diligencia",diligencia);
        startActivity(continuar);
    }
}
