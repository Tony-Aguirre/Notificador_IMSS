package mx.com.notificador_imss;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class Documento extends AppCompatActivity {
    private Switch switch1;
    private Button boton;
    private Spinner spinner2;
    private TextView rasgos,correo,Registro,Patron;
    String notificador,nombre,fecha_constancia,vigencia,emitida;
    String registro_patronal,razon_social,rfc,domicilio,credito,multa,periodo,fecha;
    String atiende,diligencia;
    String identificacionID,emisionID,vigenciaID,nombreID,numeroID;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento);
        notificador = getIntent().getStringExtra("notificador");
        registro_patronal = getIntent().getStringExtra("registro_patronal");
        atiende = getIntent().getStringExtra("atiende");
        diligencia = getIntent().getStringExtra("diligencia");
        identificacionID = getIntent().getStringExtra("identificacionID");
        emisionID = getIntent().getStringExtra("emisionID");
        vigenciaID = getIntent().getStringExtra("vigenciaID");
        nombreID = getIntent().getStringExtra("nombreID");
        numeroID = getIntent().getStringExtra("numeroID");
        boton = (Button)findViewById(R.id.btnCredencial);
        switch1 = (Switch)findViewById(R.id.switch1);
        rasgos = (TextView)findViewById(R.id.txtRasgos);
        String Rasgos = getIntent().getStringExtra("rasgos");
        rasgos.setText(Rasgos);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        String[] Atiende = {"Seleccione", "Patron", "Representante Legal", "Empleado", "Familiar", "No Atiende"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_notificadores, Atiende);
        spinner2.setAdapter(adapter);
        correo = (EditText)findViewById(R.id.txtEmail);
        Registro = (TextView)findViewById(R.id.txtRegistro);
        Registro.setText(registro_patronal);
        Patron = (TextView)findViewById(R.id.txtPatron);
        datosPatron();
        datosNotificador();
    }
    //Método de Boton Verificacion
    public void Verificacion(View view) {
        if(switch1.isChecked()){
            boton.setText("Datos ID");
        }else{
            boton.setText("Rasgos");
        }
    }
    //Método de Boton
    public void Credencial(View view) {
        atiende = spinner2.getSelectedItem().toString();
        if(switch1.isChecked()){
            Intent credencial = new Intent (Documento.this, Credencial.class);
            credencial.putExtra("notificador",notificador);
            credencial.putExtra("registro_patronal",registro_patronal);
            credencial.putExtra("atiende",atiende);
            credencial.putExtra("diligencia",diligencia);
            startActivity(credencial);
        }else{
            Intent rasgos = new Intent (Documento.this, Rasgos.class);
            rasgos.putExtra("notificador",notificador);
            rasgos.putExtra("registro_patronal",registro_patronal);
            rasgos.putExtra("atiende",atiende);
            rasgos.putExtra("diligencia",diligencia);
            startActivity(rasgos);
        }
    }
    //Método de Boton Enviar
    public void Envias(View view) {
        String CheckSpinner = spinner2.getSelectedItem().toString();
        String CheckCorreo =  correo.getText().toString();
        String CheckRasgos = rasgos.getText().toString();
        Boolean Verificacion = Boolean.FALSE;
        if(CheckSpinner.equals("Seleccione")){
            Toast.makeText(this, "Debes ingresar quien atiende la diligencia", Toast.LENGTH_SHORT).show();
            Verificacion=Boolean.FALSE;
        }else{
            Verificacion=Boolean.TRUE;
        }
        if(CheckCorreo.length() == 0){
            Toast.makeText(this, "Debes ingresar un correo", Toast.LENGTH_SHORT).show();
            Verificacion=Boolean.FALSE;
        }else{
            Verificacion=Boolean.TRUE;
        }
        if(switch1.isChecked()){
        }else{
            if(CheckRasgos.length() == 0){
                Toast.makeText(this, "Debes ingresar los rasgos fisicos", Toast.LENGTH_SHORT).show();
                Verificacion=Boolean.FALSE;
            }else{
                Verificacion=Boolean.TRUE;
            }
        }
        if(Verificacion==Boolean.TRUE){
            Toast.makeText(Documento.this,"Documento enviado con exito al correo: "+correo.getText().toString(),Toast.LENGTH_SHORT).show();
            Intent enviar = new Intent(Documento.this, Pendientes.class);
            startActivity(enviar);
        }
    }
    //Método de Boton Cancelar
    public void Cancelar(View view) {
        Intent cancelar = new Intent (Documento.this, Pendientes.class);
        startActivity(cancelar);
    }
    public void datosPatron(){
        String URL = "http://192.168.0.10/conexion/datos_patron.php?registro_patronal="+registro_patronal+"";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0; i<response.length();i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        if(registro_patronal.equals(jsonObject.getString("registro_patronal"))) {
                            razon_social=jsonObject.getString("razon_social");
                            Patron.setText(razon_social);
                            rfc=jsonObject.getString("rfc");
                            domicilio=jsonObject.getString("domicilio");
                            credito=jsonObject.getString("credito");
                            multa=jsonObject.getString("multa");
                            periodo=jsonObject.getString("periodo");
                            fecha=jsonObject.getString("fecha");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),"Debe ingresar el Registro Patronal",Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(jsonArrayRequest);
        }
    public void datosNotificador(){
            String URL = "http://192.168.0.10/conexion/datos_notificador.php?matricula="+notificador+"";
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for(int i=0; i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            if(notificador.equals(jsonObject.getString("matricula"))) {
                                nombre=jsonObject.getString("nombre");
                                fecha_constancia=jsonObject.getString("fecha");
                                vigencia=jsonObject.getString("vigencia");
                                emitida=jsonObject.getString("emitida");
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),"Debe seleccionar el numero de notificador",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),"Error en conexión",Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(jsonArrayRequest);
        }
}
