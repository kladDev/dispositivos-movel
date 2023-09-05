package aniverlembre.com.diarioescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FormAddStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add_student);
    }

    public void clickIcon(View v) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}