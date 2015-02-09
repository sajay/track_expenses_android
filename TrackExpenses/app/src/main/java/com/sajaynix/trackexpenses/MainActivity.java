package com.sajaynix.trackexpenses;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void verifyLogin(View view) {

        EditText userNameText = (EditText) findViewById(R.id.user_name);
        String userName = userNameText.getText().toString();
        EditText passwordText = (EditText) findViewById(R.id.password);
        String password = passwordText.getText().toString();
        Toast.makeText(getApplicationContext(), userName, Toast.LENGTH_SHORT).show();

        // TODO, create the task to call the REST API
        // If successfully logged in , go to view list of expenses

        Intent intent = new Intent(this, ExpenseActivity.class);
        startActivity(intent);

    }
}
