package br.com.ragazzid.raxaconta.raxaconta;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText edtPessoas;
    EditText edtPorcento;
    EditText edtValor;

    TextView txtvResultado;

    Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPessoas = (EditText) findViewById(R.id.edtPessoas);
                edtPorcento = (EditText) findViewById(R.id.edtPorcento);
                edtValor = (EditText) findViewById(R.id.edtValor);

                double pessoas = Double.parseDouble(edtPessoas.getText().toString());
                double porcento = Double.parseDouble(edtPorcento.getText().toString()) / 100;
                double valor = Double.parseDouble(edtValor.getText().toString());

                txtvResultado = (TextView) findViewById(R.id.txtvResultado);

                /* TODO
                Quando clicar, fazer o keyboard desaparecer
                * */

                txtvResultado.setText(String.valueOf(((porcento * valor) + valor) / pessoas));
            }
        });

    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
