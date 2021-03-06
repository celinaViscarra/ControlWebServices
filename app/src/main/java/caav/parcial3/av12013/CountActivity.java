package caav.parcial3.av12013;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CountActivity extends AppCompatActivity {
    EditText idAutorTxt;
    TextView countTxt;
    //URL.
    private final String urlLocal ="http://192.168.1.8/av12013/ws_count.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        idAutorTxt = (EditText) findViewById(R.id.editText_autor);
        countTxt = (TextView) findViewById(R.id.textView_count);
    }

    public void consultarCount(View v) {
        String id = idAutorTxt.getText().toString();
        String url = urlLocal + "?idautor=" + id;
        String conteo = ControlWS.obtenerPeticion(url, this);
        Log.v("Respuesta", conteo);
        countTxt.setText("Conteo: " + ControlWS.obtenerCountJSON(conteo, this));
    }
}
