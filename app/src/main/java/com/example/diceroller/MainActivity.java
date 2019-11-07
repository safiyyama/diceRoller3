package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    int Score =0;

    public void generate(View view){

        Random rand = new Random();
        int number = rand.nextInt(6)+1;
        TextView myText = (TextView)findViewById(R.id.textView);
        String myString=String.valueOf(number);
        myText.setText(myString);

        EditText userInput;
        TextView userMsg = (TextView) this.findViewById(R.id.userMsg);
        TextView scoreTxt = (TextView)this.findViewById(R.id.score);
        int userNumber;

        userInput = (EditText)findViewById(R.id.userInput);
        String validate = userInput.getText().toString();

        if(validate.isEmpty()){
            Toast.makeText(MainActivity.this, "Please be sure to enter a number",
                    Toast.LENGTH_LONG).show();
            userInput.getText().clear();
        }
        else{
            userNumber = Integer.valueOf(userInput.getText().toString());
            compare( userNumber, userMsg, scoreTxt, userInput, number);
        }

    }

    public void compare(int userNumber, TextView userMsg, TextView scoreTxt, EditText userInput, int number){

        if(userNumber==number){

            Score++;
            scoreTxt.setText("You have guessed correctly this many times: "+Score);
            userMsg.setText("Congratulations! You guessed the dice number!");
            userInput.getText().clear();
        }

        else{
            userMsg.setText("Incorrect guess. Try again.");
            userInput.getText().clear();
        }
    }


}
