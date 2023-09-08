package aniverlembre.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import aniverlembre.com.diarioescolar.R;

public class StudentManager {
    public static void addStudentList(Context context, Student student) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                String.valueOf(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        String key = student.name;
        String value = student.n1 + "," + student.n2 + "," + student.n3;

        editor.putString(key, value);
        editor.apply();
    }

    public static List<Student> getStudentList(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                String.valueOf(R.string.preference_file_key), Context.MODE_PRIVATE);

        Map<String, ?> allStudent = sharedPref.getAll();
        List<Student> studentList = new ArrayList<>();

        for (Map.Entry<String, ?> entry : allStudent.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            String[] values = value.split(",");

            String grade01 = String.valueOf(Float.parseFloat(values[0]));
            String grade02 = String.valueOf(Float.parseFloat(values[1]));
            String grade03 = String.valueOf(Float.parseFloat(values[2]));

            Student student = new Student(key, grade01, grade02, grade03);
            studentList.add(student);
        }

        return studentList;
    }
}
