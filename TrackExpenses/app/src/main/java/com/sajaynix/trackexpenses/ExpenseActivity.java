package com.sajaynix.trackexpenses;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;


public class ExpenseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
    }

    public void addExpense(View view) {

        EditText amountText = (EditText) findViewById(R.id.et_amount);
        String amount = amountText.getText().toString();
        Toast.makeText(getApplicationContext(), amount, Toast.LENGTH_SHORT).show();

        // TODO, create the task to post the new Expense to Rest API
        JSONObject jsonExpense = new JSONObject();
        try {
            jsonExpense.put("expenseCategory", 1);
            jsonExpense.put("expenseType", 1);
            jsonExpense.put("amount_spent", 100.01);
            jsonExpense.put("expense_date", new Date());
            jsonExpense.put("vendorType", 1);
            jsonExpense.put("created_by",1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPostRequest = new HttpPost("http://localhost:8000/api/v1/expenses/");
            StringEntity se = new StringEntity(jsonExpense.toString());
            se.setContentType("application/json;charset=UTF-8");
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
            httpPostRequest.setEntity(se);
            HttpResponse httpresponse = httpclient.execute(httpPostRequest);
            Toast.makeText(getApplicationContext(), "Expense Added", Toast.LENGTH_SHORT).show();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_expense, menu);
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
