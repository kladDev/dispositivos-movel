package aniverlembre.com.diarioescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import aniverlembre.model.Student;
import aniverlembre.model.StudentManager;

public class FormAddStudent extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getApplicationContext();

        setContentView(R.layout.activity_form_add_student);

    }

    public void addStudent(View v) {
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        EditText editTextGrade1 = (EditText) findViewById(R.id.editTextGrade1);
        EditText editTextGrade2 = (EditText) findViewById(R.id.editTextGrade2);
        EditText editTextGrade3 = (EditText) findViewById(R.id.editTextGrade3);

        String name = editTextName.getText().toString();
        String grade1 = editTextGrade1.getText().toString();
        String grade2 = editTextGrade2.getText().toString();
        String grade3 = editTextGrade3.getText().toString();
//        float grade1 = Float.parseFloat(editTextGrade1.getText().toString());
//        float grade2 = Float.parseFloat(editTextGrade2.getText().toString());
//        float grade3 = Float.parseFloat(editTextGrade3.getText().toString());

        Student student = new Student(name, grade1, grade2, grade3);
        StudentManager.addStudentList(getApplicationContext(), student);

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}