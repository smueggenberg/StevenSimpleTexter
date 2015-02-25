package edu.css.smueggenberg.stevensimpletexter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class TextActivity extends ActionBarActivity {

    EditText customMessage;
    TextView lblSelectMessage;
    Spinner messages;
    Button btnPreset;
    Button btnCustom;
    Bundle extras;
    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        extras = getIntent().getExtras();

        customMessage = (EditText) findViewById(R.id.txtCustomMessage);
        lblSelectMessage = (TextView) findViewById(R.id.lblSelectMessage);
        btnPreset = (Button) findViewById(R.id.btnSendPreset);
        btnCustom = (Button) findViewById(R.id.btnSendCutsom);

        //Code handles the spinner spnMessages
        messages = (Spinner) findViewById(R.id.spnMessages);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.messages, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        messages.setAdapter(adapter);

        phoneNumber = "-1";

        //Set the title text to display the message with the appropriate name and
        // set the correct phone number
        switch (extras.getInt("senderId")) {
            case 0:
                lblSelectMessage.setText(R.string.MessageSelect0);
                phoneNumber = "7632288115";
                break;
            case 1:
                lblSelectMessage.setText(R.string.MessageSelect1);
                phoneNumber = "7634646117";
                break;
            case 2:
                lblSelectMessage.setText(R.string.MessageSelect2);
                phoneNumber = "2184643432";
                break;
        }

        btnPreset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Use the sendMessage method to send the selected preset message
                sendMessage(phoneNumber, messages.getSelectedItem().toString());
            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendMessage(phoneNumber, customMessage.getText().toString());
            }
        });
    }

    //Sends a message to a specified phone number with a message using SMS
    public void sendMessage(String phoneNumber, String message){
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:" + phoneNumber));
        sendIntent.putExtra("sms_body", message);
        startActivity(sendIntent);
    }
}
