package tempconverter.com.example.silp.tempconverter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends ActionBarActivity {
    private Button btn_C, btn_F;
    private EditText TempEditText;
    private TextView kq;
    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_C = (Button) findViewById(R.id.C_buttonId);
        btn_F = (Button) findViewById(R.id.F_buttonId);
        TempEditText = (EditText) findViewById(R.id.editTextId);
        kq = (TextView) findViewById(R.id.textViewId);


        btn_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TempVal = TempEditText.getText().toString();

                if (TempVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input a value", Toast.LENGTH_LONG).show();

                } else {

                    Double result = convert_C(Double.parseDouble(TempVal));
                    kq.setText(String.valueOf(round.format(result))+" C");

                }

            }
        });
        btn_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String TempVal = TempEditText.getText().toString();

                if (TempVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input a value", Toast.LENGTH_LONG).show();

                } else {

                    Double result = convert_F(Double.parseDouble(TempVal));
                    kq.setText(String.valueOf(round.format(result))+" F");

                }
            }
        });



    }
    public Double convert_C(double F_val){

        double C = (F_val - 32) * 1.8;

        return C;
    }
    public  Double convert_F(double C_val) {
        double F = (C_val *1.8)+ 32;



        return F;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
