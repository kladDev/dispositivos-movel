package aniverlembre.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import aniverlembre.com.diarioescolar.R;
import aniverlembre.model.Student;

 public class AdapterStudent extends RecyclerView.Adapter<AdapterStudent.ViewHolder> {
    private List<Student> studentList;
    private Context context;

    public AdapterStudent(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.name.setText(student.name);
        holder.grade1.setText(student.n1);
        holder.grade2.setText(student.n2);
        holder.grade3.setText(student.n3);
        holder.delete.setImageResource(R.drawable.delete);
        holder.edit.setImageResource(R.drawable.edit);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView grade1;
        public TextView grade2;
        public TextView grade3;
        public ImageView delete;
        public ImageView edit;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            grade1 = itemView.findViewById(R.id.textn1);
            grade2 = itemView.findViewById(R.id.b2);
            grade3 = itemView.findViewById(R.id.n3);
            delete = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);
        }
    }
}

