package mx.com.notificador_imss;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class Rasgos extends AppCompatActivity {
    private Spinner Sexo,Tez,Compexion,Cabello,Color,Ojos;
    private TextView Edad;
    String notificador,registro_patronal,atiende,diligencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasgos);
        notificador = getIntent().getStringExtra("notificador");
        registro_patronal = getIntent().getStringExtra("registro_patronal");
        atiende = getIntent().getStringExtra("atiende");
        diligencia = getIntent().getStringExtra("diligencia");
        Sexo = (Spinner)findViewById(R.id.spnSexo);
        String [] sexo = {"seleccione","masculino","femenino","intersexual"};
        ArrayAdapter<String> adSexo = new ArrayAdapter<String>(this, R.layout.spinner_item_notificadores, sexo);
        Sexo.setAdapter(adSexo);
        Tez = (Spinner)findViewById(R.id.spnTez);
        String [] tez = {"seleccione","clara","morena","oscura"};
        ArrayAdapter<String> adTez = new ArrayAdapter<String>(this, R.layout.spinner_item_notificadores, tez);
        Tez.setAdapter(adTez);
        Compexion = (Spinner)findViewById(R.id.spnCompexion);
        String [] compexion = {"seleccione","delgada","mediana","gruesa"};
        ArrayAdapter<String> adCompexion = new ArrayAdapter<String>(this, R.layout.spinner_item_notificadores, compexion);
        Compexion.setAdapter(adCompexion);
        Cabello = (Spinner)findViewById(R.id.spnCabello);
        String [] cabello = {"seleccione","lacio","ondulado","rizado","corto","sin cabello"};
        ArrayAdapter<String> adCabello = new ArrayAdapter<String>(this, R.layout.spinner_item_notificadores, cabello);
        Cabello.setAdapter(adCabello);
        Color = (Spinner)findViewById(R.id.spnColor);
        String [] color = {"seleccione","castaño","rubio","obscuro","canuzco","teñido"};
        ArrayAdapter<String> adColor = new ArrayAdapter<String>(this, R.layout.spinner_item_notificadores, color);
        Color.setAdapter(adColor);
        Ojos = (Spinner)findViewById(R.id.spnOjos);
        String [] ojos = {"seleccione","negros","cafes","miel","azules","verdes","claros"};
        ArrayAdapter<String> adOjos = new ArrayAdapter<String>(this, R.layout.spinner_item_notificadores, ojos);
        Ojos.setAdapter(adOjos);
        Edad = (TextView)findViewById(R.id.txtEdad);
    }
    //Método de Boton Continuar
    public void Continuar(View view) {
        String Descripcion;
        Boolean Verificacion = Boolean.FALSE;
        String varSexo = Sexo.getSelectedItem().toString();
        if (varSexo.equals("masculino")) {
            varSexo = "Hombre";
        } else if (varSexo.equals("femenino")) {
            varSexo = "Mujer";
        } else {
            varSexo = "Persona";
        }
        if(varSexo.equals("seleccione")){
            Toast.makeText(this, "Debes seleccionar el tipo de sexo", Toast.LENGTH_SHORT).show();
            Verificacion = Boolean.FALSE;
        }else{
            Verificacion = Boolean.TRUE;
        }
        String varTez = Tez.getSelectedItem().toString();
        if(varTez.equals("seleccione")){
            Toast.makeText(this, "Debes seleccionar el tipo de tez", Toast.LENGTH_SHORT).show();
            Verificacion = Boolean.FALSE;
        }else{
            Verificacion = Boolean.TRUE;
        }
        String varCompexion = Compexion.getSelectedItem().toString();
        if(varCompexion.equals("seleccione")){
            Toast.makeText(this, "Debes seleccionar el tipo de complexion", Toast.LENGTH_SHORT).show();
            Verificacion = Boolean.FALSE;
        }else{
            Verificacion = Boolean.TRUE;
        }
        String varColor = Color.getSelectedItem().toString();
        if(varColor.equals("seleccione")){
            Toast.makeText(this, "Debes seleccionar el color de cabello", Toast.LENGTH_SHORT).show();
            Verificacion = Boolean.FALSE;
        }else{
            Verificacion = Boolean.TRUE;
        }
        String varOjos = Ojos.getSelectedItem().toString();
        if(varOjos.equals("seleccione")){
            Toast.makeText(this, "Debes seleccionar el color de ojos", Toast.LENGTH_SHORT).show();
            Verificacion = Boolean.FALSE;
        }else{
            Verificacion = Boolean.TRUE;
        }
        String edad =  Edad.getText().toString();
        if(edad.length() == 0){
            Toast.makeText(this, "Debes ingresar la edad", Toast.LENGTH_SHORT).show();
            Verificacion=Boolean.FALSE;
        }else{
            Verificacion = Boolean.TRUE;
        }
        String varCabello = Cabello.getSelectedItem().toString();
        if (varCabello.equals("sin cabello")){
            Descripcion = String.format("%s de tez %s, complexión %s, sin cabellos, ojos color %s y aproximadamente de %s años.",
                    varSexo.toString(), varTez.toString(), varCompexion.toString(), varOjos.toString(), Edad.getText().toString());
        }else{
            Descripcion = String.format("%s de tez %s, complexión %s, cabellos %s de color %s, ojos color %s y aproximadamente de %s años.",
                    varSexo.toString(), varTez.toString(), varCompexion.toString(), varCabello.toString(), varColor.toString(), varOjos.toString(), Edad.getText().toString());
        }
        if(varCabello.equals("seleccione")){
            Toast.makeText(this, "Debes seleccionar el tipo de cabello", Toast.LENGTH_SHORT).show();
            Verificacion = Boolean.FALSE;
        }else{
            Verificacion = Boolean.TRUE;
        }
        if(Verificacion == Boolean.TRUE){
            Intent continuar = new Intent(Rasgos.this, Documento.class);
            continuar.putExtra("rasgos", Descripcion);
            continuar.putExtra("notificador",notificador);
            continuar.putExtra("registro_patronal",registro_patronal);
            continuar.putExtra("atiende",atiende);
            continuar.putExtra("diligencia",diligencia);
            startActivity(continuar);
        }
    }
}
