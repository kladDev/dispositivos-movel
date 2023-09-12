package aniverlembre.com.diarioescolar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import aniverlembre.adapter.AdapterStudent;
import aniverlembre.model.Student;
import aniverlembre.model.StudentManager;

public class Home extends AppCompatActivity {

    private StudentManager studentManager;
    private AdapterStudent studentAdapter;

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getApplicationContext();

        setContentView(R.layout.activity_home);

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerStudent = findViewById(R.id.recyclerView);
        recyclerStudent.setLayoutManager(new LinearLayoutManager(this));
        recyclerStudent.setHasFixedSize(true);

        studentManager = new StudentManager();
        List<Student> students = studentManager.getStudentList(getApplicationContext());

        studentAdapter = new AdapterStudent(getApplicationContext(), students);
        recyclerStudent.setAdapter(studentAdapter);
    }

    public void addStudent(View v) {
        Intent intent = new Intent(this, FormAddStudent.class);
        startActivity(intent);
    }
}