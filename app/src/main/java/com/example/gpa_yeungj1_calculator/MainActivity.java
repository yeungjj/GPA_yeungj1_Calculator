package com.example.gpa_yeungj1_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText grade1, grade2, grade3, grade4, grade5;
    double GPAvalue;
    TextView numericalGPA;
    View view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grade1 = findViewById(R.id.grade1);
        grade2 = findViewById(R.id.grade2);
        grade3 = findViewById(R.id.grade3);
        grade4 = findViewById(R.id.grade4);
        grade5 = findViewById(R.id.grade5);
        numericalGPA = findViewById(R.id.numericalGPA);
        view1 = findViewById(R.id.view);

        final Button computeGPA = (Button) findViewById(R.id.button);

        //controls button when clicked

        computeGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Your app should not accept empty fields

                if (grade1.length() == 0) {
                    grade1.setError("Please enter a value");
                } else if (grade2.length() == 0) {
                    grade2.setError("Please enter a value");
                } else if (grade3.length() == 0) {
                    grade3.setError("Please enter a value");
                } else if (grade4.length() == 0) {
                    grade4.setError("Please enter a value");
                } else if (grade5.length() == 0) {
                    grade5.setError("Please enter a value");
                } else {
                    final double grade1value = Double.parseDouble(grade1.getText().toString());
                    final double grade2value = Double.parseDouble(grade2.getText().toString());
                    final double grade3value = Double.parseDouble(grade3.getText().toString());
                    final double grade4value = Double.parseDouble(grade4.getText().toString());
                    final double grade5value = Double.parseDouble(grade5.getText().toString());

                    GPAvalue = (grade1value + grade2value + grade3value + grade4value + grade5value) / 5;
                    String result = Double.toString(GPAvalue);
                    numericalGPA.setText(result);

                    //Your app should display red background if GPA less than 60, Yellow for 61-79, and Green for 80 to 100.

                    if (GPAvalue >= 0 && GPAvalue <= 60) {
                        view1.setBackgroundColor(Color.RED);
                    } else if (GPAvalue >= 61 && GPAvalue <= 79) {
                        view1.setBackgroundColor(Color.YELLOW);
                    } else if (GPAvalue >= 80 && GPAvalue <= 100) {
                        view1.setBackgroundColor(Color.GREEN);
                    } else
                        view1.setBackgroundColor(Color.WHITE);

                    //The text on the compute button should be changed to clear form once click.

                    computeGPA.setText("Clear Form");
                    Toast.makeText(MainActivity.this, "Long Click on Button to Clear Form", Toast.LENGTH_SHORT).show();
                    computeGPA.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {
                            grade1.getText().clear();
                            grade2.getText().clear();
                            grade3.getText().clear();
                            grade4.getText().clear();
                            grade5.getText().clear();
                            return true;
                        }
                    });

                    //When you start typing in the fields again after the first GPA calculation, change back the button text to show compute GPA.

                    grade1.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            computeGPA.setText("Compute GPA");
                        }
                        @Override
                        public void afterTextChanged(Editable editable) { }
                    });
                    grade2.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            computeGPA.setText("Compute GPA");
                        }
                        @Override
                        public void afterTextChanged(Editable editable) { }
                    });
                    grade3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            computeGPA.setText("Compute GPA");
                        }
                        @Override
                        public void afterTextChanged(Editable editable) { }
                    });
                    grade4.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            computeGPA.setText("Compute GPA");
                        }
                        @Override
                        public void afterTextChanged(Editable editable) { }
                    });
                    grade5.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            computeGPA.setText("Compute GPA");
                        }
                        @Override
                        public void afterTextChanged(Editable editable) { }
                    });
                }
            }
        });
    }
}

