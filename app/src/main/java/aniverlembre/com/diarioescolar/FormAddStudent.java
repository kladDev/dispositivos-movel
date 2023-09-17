package aniverlembre.com.diarioescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import aniverlembre.model.Student;
import aniverlembre.model.StudentManager;

public class FormAddStudent extends AppCompatActivity {
    private Context context;
    private EditText editTextName;
    private EditText editTextGrade01;
    private EditText editTextGrade02;
    private EditText editTextGrade03;
    private Button button;
    private StudentManager studentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getApplicationContext();

        setContentView(R.layout.activity_form_add_student);

        Intent intent = getIntent();

        if(intent != null) {
            String name = intent.getStringExtra("name");

            if(name != null) {
                studentManager = new StudentManager();

                List<Student> students = studentManager.getStudentList(getApplicationContext());
                Student student = studentManager.getStudentByName(name, students);

                editTextName = findViewById(R.id.editTextName);
                editTextGrade01 = findViewById(R.id.editTextGrade1);
                editTextGrade02 = findViewById(R.id.editTextGrade2);
                editTextGrade03 = findViewById(R.id.editTextGrade3);
                button = findViewById(R.id.button);

                editTextName.setText(student.name);
                editTextGrade01.setText(student.n1);
                editTextGrade02.setText(student.n2);
                editTextGrade03.setText(student.n3);
                button.setText("Salvar");


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nome = editTextName.getText().toString();
                        Float n1 = Float.valueOf(editTextGrade01.getText().toString());
                        Float n2 = Float.valueOf(editTextGrade02.getText().toString());
                        Float n3 = Float.valueOf(editTextGrade03.getText().toString());


                        if(nome.isEmpty()) {
                            Toast.makeText(context, "Campo novo vazio", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if(n1 == null || n1 < 0 || n1 > 10) {
                            Toast.makeText(context, "Nota 1 inválida", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if(n1 == null || n2 < 0 || n2 > 10) {
                            Toast.makeText(context, "Nota 2 inválida", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if(n3 == null || n3 < 0 || n3 > 10) {
                            Toast.makeText(context, "Nota 3 inválida", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        student.name = nome;
                        student.n1 = n1.toString();
                        student.n2 = n2.toString();
                        student.n3 = n3.toString();

                        StudentManager.updateStudent(getApplicationContext(), student, name);
                        Toast.makeText(context, "Dados atualizados com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    public void backPage(View v) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void addStudent(View v) {
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        EditText editTextGrade1 = (EditText) findViewById(R.id.editTextGrade1);
        EditText editTextGrade2 = (EditText) findViewById(R.id.editTextGrade2);
        EditText editTextGrade3 = (EditText) findViewById(R.id.editTextGrade3);


        String name = editTextName.getText().toString();
        Float grade1 = Float.valueOf(editTextGrade1.getText().toString());
        Float grade2 = Float.valueOf(editTextGrade2.getText().toString());
        Float grade3 = Float.valueOf(editTextGrade3.getText().toString());

        if(name.isEmpty()) {
            Toast.makeText(context, "Campo novo vazio", Toast.LENGTH_SHORT).show();
            return;
        }

        if(grade1 == null || grade1 < 0 || grade1 > 10) {
            Toast.makeText(context, "Nota 1 inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        if(grade2 == null || grade2 < 0 || grade2 > 10) {
            Toast.makeText(context, "Nota 2 inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        if(grade3 == null || grade3 < 0 || grade3 > 10) {
            Toast.makeText(context, "Nota 3 inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        Student student = new Student(name, grade1.toString(), grade2.toString(), grade3.toString());
        StudentManager.addStudentList(getApplicationContext(), student);

        Toast.makeText(context, "Estudante adicionando com sucesso!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}