package org.cidie.mascotas.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.cidie.mascotas.R;
import org.cidie.mascotas.pojo.SendMail;

/**
 * Created by Osman Villanueva García - osman@cidie.org (agosto 2020)
 */

public class Contacto extends AppCompatActivity implements View.OnClickListener {
    //    private Toolbar toolbar;
    private EditText inputName;
    private EditText inputEmail;
    private EditText inputMessage;

    private Button botonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

//        toolbar = (Toolbar) findViewById(R.id.miActionBar);

//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputName = (EditText) findViewById(R.id.textInputName);
        inputEmail = (EditText) findViewById(R.id.textInputEmail);
        inputMessage = (EditText) findViewById(R.id.textInputMessage);

        botonEnviar = (Button) findViewById(R.id.buttonSend);

        botonEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }

    private void sendEmail() {
        //Getting content for email
        String email = inputEmail.getText().toString().trim();
        String subject = "MASCOTAS CIDIE";
        String message = "Estimad@ " + inputName.getText().toString().trim() + ":\n" + inputMessage.getText().toString().trim();

        //Creating SendMail object
        SendMail sendMail = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sendMail.execute();
    }

}