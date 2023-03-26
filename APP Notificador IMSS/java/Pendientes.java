package mx.com.notificador_imss;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
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
public class Pendientes extends AppCompatActivity {
    private Spinner spinner1,spinner2;
    private TextView Nombre,RegistroPatronal;
    String matriculas[]={"Selecciones","10270089","10270936","10270998","10271406","10271587"};
    String diligencia[]={"Diligencia","Citatorio","Notificacion"};
    String registros[];
    String seleccion1,seleccion2,admin,usuario;
    RequestQueue requestQueue;
    TableLayout Cedulas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendientes);
        usuario = getIntent().getStringExtra("usuario");
        Nombre = (TextView)findViewById(R.id.txtNombre);
        Cedulas = (TableLayout)findViewById(R.id.tblCedulas);
        RegistroPatronal = (TextView)findViewById(R.id.txtRegistroPatronal);
        spinner1 = (Spinner)findViewById(R.id.spinner);
        spinner1.setAdapter(new ArrayAdapter<String>(Pendientes.this, android.R.layout.simple_spinner_item, matriculas));
        spinner2 = (Spinner)findViewById(R.id.spinner3);
        spinner2.setAdapter(new ArrayAdapter<String>(Pendientes.this, android.R.layout.simple_spinner_item, diligencia));
    }
    //Método para Desplegar información
    public void Desplegar(View view){
        seleccion1 = spinner1.getSelectedItem().toString();
        String URL = "http://192.168.0.10/conexion/buscar_notificador.php?matricula="+seleccion1+"";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response){
                JSONObject jsonObject = null;
                for (int i=0; i<response.length(); i++) {
                    try{
                        jsonObject = response.getJSONObject(i);
                        if(seleccion1.equals(jsonObject.getString("matricula"))){
                            Nombre.setText(jsonObject.getString("nombre"));
                        }
                    }catch (JSONException e){
                        Toast.makeText(getApplicationContext(),"Debe seleccionar a un notificador", Toast.LENGTH_SHORT).show();
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
        llenarTabla();
    }
    //Método de Boton Supervisor
    public void Supervisor(View view){
        Intent Supervisor = new Intent (Pendientes.this, Supervisor.class);
        startActivity(Supervisor);
    }
    //Método de Boton Continuar
    public void Continuar(View view) {
        seleccion2 = spinner2.getSelectedItem().toString();
        if(RegistroPatronal.length()>0 &&!seleccion2.equals("Diligencia")) {
            Intent continuar = new Intent(Pendientes.this, Documento.class);
            continuar.putExtra("notificador",usuario);
            continuar.putExtra("registro_patronal","E"+RegistroPatronal.getText());
            continuar.putExtra("diligencia",seleccion2);
            startActivity(continuar);
        }
    }
    public void llenarTabla(){
        seleccion1 = spinner1.getSelectedItem().toString();
        String URL = "http://192.168.0.10/conexion/buscar_patron.php?asignacion="+seleccion1+"";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for(int i=0; i<response.length();i++){
                    try {
                        jsonObject = response.getJSONObject(i);
                        if(seleccion1.equals(jsonObject.getString("asignacion"))) {
                            View registro = LayoutInflater.from(Pendientes.this).inflate(R.layout.item_table_layout, null, false);
                            TextView colRegistoPatronal = registro.findViewById(R.id.colRegistroPatronal);
                            TextView colNombre = registro.findViewById(R.id.colNombre);
                            TextView colPeriodo = registro.findViewById(R.id.colPeriodo);
                            colRegistoPatronal.setText(jsonObject.getString("registro_patronal"));
                            colNombre.setText(jsonObject.getString("razon_social"));
                            colPeriodo.setText(jsonObject.getString("periodo"));
                            Cedulas.addView(registro);
                        }
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(),"Error en coneción",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error en coneción",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
