package com.example.assignment2_students_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment2_students_app.model.Model;
import com.example.assignment2_students_app.model.Student;

public class EditStudentActivity extends AppCompatActivity {
    TextView headerText;
    ImageView backButton;
    ImageView imageViewEdit;
    EditText nameViewEdit;
    EditText idViewEdit;
    EditText phoneViewEdit;
    EditText addressViewEdit;
    CheckBox checkedViewEdit;
    Button cancelButton;
    Button deleteButton;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        Bundle extras = getIntent().getExtras();
        int pos = extras.getInt("pos");
        Student st = Model.getInstance().getAllStudents().get(pos);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> {
            this.finish();
        });
        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(view -> {
            this.finish();
        });
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(view -> {
            st.setName(nameViewEdit.getText().toString());
            st.setId(idViewEdit.getText().toString());
            st.setPhoneNumber(phoneViewEdit.getText().toString());
            st.setAddress(addressViewEdit.getText().toString());
            st.setChecked(checkedViewEdit.isChecked());
            this.finish();
        });
        deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(view -> {
            Model.getInstance().deleteStudent(pos);
            Intent intent = new Intent(view.getContext(), StudentsListActivity.class);
            startActivity(intent);
        });

        headerText = findViewById(R.id.headerText);
        headerText.setText("Edit student");

        imageViewEdit = findViewById(R.id.studentDetailsImageEdit);
        nameViewEdit = findViewById(R.id.nameValueEdit);
        idViewEdit = findViewById(R.id.idValueEdit);
        phoneViewEdit = findViewById(R.id.phoneValueEdit);
        addressViewEdit = findViewById(R.id.addressValueEdit);
        checkedViewEdit = findViewById(R.id.studentDetailsCheckedEdit);

        imageViewEdit.setImageResource(st.getImageId());
        nameViewEdit.setText(st.getName());
        idViewEdit.setText(st.getId());
        phoneViewEdit.setText(st.getPhoneNumber());
        addressViewEdit.setText(st.getAddress());
        checkedViewEdit.setChecked(st.isChecked());
        checkedViewEdit.setText(st.isChecked() ? "checked" : "unchecked");

        checkedViewEdit.setOnCheckedChangeListener((compoundButton, b) -> {
            checkedViewEdit.setText(b ? "checked" : "unchecked");
        } );
    }
}