package com.example.chanley.thishopefullywillwork;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView resultLabelTextView;
    EditText firstNumberEditText, secondNumberEditText;
    Button addNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addNumbers = (Button) findViewById(R.id.addNumbers);
        firstNumberEditText= (EditText) findViewById(R.id.firstNumberEditText);
        secondNumberEditText = (EditText) findViewById(R.id.secondNumberEditText);
        resultLabelTextView = (TextView) findViewById(R.id.resultTextView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }



    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
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

    public void addNumbers(View view) {
        int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
        int secondNumber= Integer.parseInt(secondNumberEditText.getText().toString());
        NumberAdder adder = new NumberAdder();
        int result = adder.addTwoNumbers(firstNumber,secondNumber);
        resultLabelTextView.setText(String.valueOf(result));
    }
}
