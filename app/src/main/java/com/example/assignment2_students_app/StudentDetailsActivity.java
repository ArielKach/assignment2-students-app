package com.example.assignment2_students_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment2_students_app.model.Model;
import com.example.assignment2_students_app.model.Student;

public class StudentDetailsActivity extends AppCompatActivity {
    TextView headerText;
    ImageView backButton;

    ImageView imageView;
    TextView nameView;
    TextView idView;
    TextView phoneView;
    TextView addressView;
    CheckBox checkedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> {
            this.finish();
        });

        headerText = findViewById(R.id.headerText);
        headerText.setText("Student Details");

        imageView = findViewById(R.id.studentDetailsImage);
        nameView = findViewById(R.id.nameValue);
        idView = findViewById(R.id.idValue);
        phoneView = findViewById(R.id.phoneValue);
        addressView = findViewById(R.id.addressValue);
        checkedView = findViewById(R.id.studentDetailsChecked);

        Bundle extras = getIntent().getExtras();
        int pos = extras.getInt("pos");
        Student st = Model.getInstance().getAllStudents().get(pos);

        imageView.setImageResource(st.getImageId());
        nameView.setText(st.getName());
        idView.setText(st.getId());
        phoneView.setText(st.getPhoneNumber());
        addressView.setText(st.getAddress());
        checkedView.setChecked(st.isChecked());
        checkedView.setText(st.isChecked()? "checked": "unchecked");

    }
}