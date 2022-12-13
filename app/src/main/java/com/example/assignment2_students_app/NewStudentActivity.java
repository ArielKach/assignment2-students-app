package com.example.assignment2_students_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment2_students_app.model.Model;
import com.example.assignment2_students_app.model.Student;

public class NewStudentActivity extends AppCompatActivity {
    TextView headerText;
    ImageView backButton;
    ImageView imageViewNew;
    EditText nameViewNew;
    EditText idViewNew;
    EditText phoneViewNew;
    EditText addressViewNew;
    CheckBox checkedViewNew;
    Button cancelButtonNew;
    Button saveButtonNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> {
            this.finish();
        });
        cancelButtonNew = findViewById(R.id.cancelButtonNew);
        cancelButtonNew.setOnClickListener(view -> {
            this.finish();
        });
        saveButtonNew = findViewById(R.id.saveButtonNew);
        saveButtonNew.setOnClickListener(view -> {
            Model.getInstance().addStudent(new Student(idViewNew.getText().toString(),
                    nameViewNew.getText().toString(),
                    R.drawable.student_image,
                    phoneViewNew.getText().toString(),
                    addressViewNew.getText().toString(),
                    checkedViewNew.isChecked()));
            this.finish();
        });

        headerText = findViewById(R.id.headerText);
        headerText.setText("New Student");

        imageViewNew = findViewById(R.id.studentDetailsImageNew);
        nameViewNew = findViewById(R.id.nameValueNew);
        idViewNew = findViewById(R.id.idValueNew);
        phoneViewNew = findViewById(R.id.phoneValueNew);
        addressViewNew = findViewById(R.id.addressValueNew);
        checkedViewNew = findViewById(R.id.studentDetailsCheckedNew);
        imageViewNew.setImageResource(R.drawable.student_image);
        checkedViewNew.setText("unchecked");

        checkedViewNew.setOnCheckedChangeListener((compoundButton, b) -> {
            checkedViewNew.setText(b ? "checked" : "unchecked");
        } );
    }
}