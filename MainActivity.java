package mx.com.notificador_imss;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText Usuario,Password;
    EditText UsuarioBD,PasswordBD;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Usuario = (EditText)findViewById(R.id.txtUsuario);
        Password = (EditText)findViewById(R.id.txtPassword);
    }
    //Método botón Iniciar Sesión
    public void IniciarSesion(View view){
        String usuario = Usuario.getText().toString();
        String password = Password.getText().toString();
        if(usuario.length() == 0){
            Toast.makeText(this, "Debes ingresar el usuario", Toast.LENGTH_SHORT).show();
        }if(password.length() == 0){
            Toast.makeText(this, "Debes ingresar la contraseña", Toast.LENGTH_SHORT).show();
        }if(usuario.length() != 0 && password.length() != 0){
            String URL="http://192.168.0.10:80/dashboard/conexion/buscar_notificador.php?matricula="+usuario+"";
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, (response) -> {
                JSONObject jsonObject = null;
                for (int i=0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        UsuarioBD.setText(jsonObject.getString("matricula"));
                        PasswordBD.setText(jsonObject.getString("password"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),"Error de Conexión",Toast.LENGTH_SHORT).show();
                }
            }
            );
            requestQueue=Volley.newRequestQueue(this);
            requestQueue.add(jsonArrayRequest);
            String CompUsuario = UsuarioBD.getText().toString();
            String CompPassword = PasswordBD.getText().toString();
            if(CompUsuario.equals(usuario) && CompPassword.equals(password)){
                Intent siguiente = new Intent (MainActivity.this, Pendientes.class);
                startActivity(siguiente);
            }
        }
    }
}
