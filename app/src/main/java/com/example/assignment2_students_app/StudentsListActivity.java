package com.example.assignment2_students_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment2_students_app.model.Model;
import com.example.assignment2_students_app.model.Student;

import java.util.List;

public class StudentsListActivity extends AppCompatActivity {
    RecyclerView studentsListRecyclerView;
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        studentList = Model.getInstance().getAllStudents();
        studentsListRecyclerView = findViewById(R.id.studentRecyclerList);
        studentsListRecyclerView.setHasFixedSize(true);

        studentsListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter();
        studentsListRecyclerView.setAdapter(new StudentRecyclerAdapter());

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Intent intent = new Intent(getApplicationContext(), StudentDetailsActivity.class);

                intent.putExtra("pos", pos);
                startActivity(intent);
            }
        });
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;
        TextView studentId;
        CheckBox studentIsChecked;
        ImageView studentImage;
        ConstraintLayout studentRow;

        public StudentViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            studentName = itemView.findViewById(R.id.studentListRowName);
            studentId = itemView.findViewById(R.id.studentListRowId);
            studentIsChecked = itemView.findViewById(R.id.studentListRowCheckbox);
            studentImage = itemView.findViewById(R.id.studentListRowImage);
            studentIsChecked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = (int) studentIsChecked.getTag();
                    Student st = studentList.get(pos);
                    st.setChecked(studentIsChecked.isChecked());
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    listener.onItemClick(pos);
                }
            });
        }

        public void bind(Student st, int position) {
            studentName.setText(st.getName());
            studentId.setText(st.getId());
            studentIsChecked.setChecked(st.isChecked());
            studentIsChecked.setTag(position);
            studentImage.setImageResource(st.getImageId());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int pos);
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
        OnItemClickListener listener;
        void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }
        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row, parent, false);

            return new StudentViewHolder(view, listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            Student st = studentList.get(position);
            holder.bind(st, position);
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }
    }
}