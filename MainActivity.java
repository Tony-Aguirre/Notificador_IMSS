package mx.com.notificador_imss;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText Usuario,Password;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Usuario = (EditText)findViewById(R.id.txtUsuario);
        Password = (EditText)findViewById(R.id.txtPassword);
    }
    //Metodo de boton Inicio de sesion
    public void IniciarSesion(View view){
        String URL = "http://192.168.0.10/conexion/validar_usuario.php";
        StringRequest stringRequest =  new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent intent = new Intent (getApplicationContext(),Pendientes.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("matricula",Usuario.getText().toString());
                parametros.put("password",Password.getText().toString());
                return parametros;
            }
        };
        requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
