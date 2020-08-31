package org.cidie.mascotas.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import org.cidie.mascotas.R;
import org.cidie.mascotas.pojo.SendMail;

/**
 * Created by Osman Villanueva García - osman@cidie.org (agosto 2020)
 */

public class Contacto extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private TextInputEditText inputName;
    private TextInputEditText inputEmail;
    private TextInputEditText inputMessage;

    private Button botonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        toolbar = (Toolbar) findViewById(R.id.miActionBar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputName = (TextInputEditText) findViewById(R.id.textInputName);
        inputEmail = (TextInputEditText) findViewById(R.id.textInputEmail);
        inputMessage = (TextInputEditText) findViewById(R.id.textInputMessage);

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