package com.example.firebasefeedback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.logging.ErrorManager;

public class HostActivity extends AppCompatActivity {

    Button submitButton;
    EditText ques,opt1,opt2,opt3,opt4;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRoot = database.getReference();
    DatabaseReference hostRoot = myRoot.child("HostQues");
    DatabaseReference question = hostRoot.child("Question");
    DatabaseReference option1 = hostRoot.child("Option_1");
    DatabaseReference count1 = hostRoot.child("Count_1");
    DatabaseReference option2 = hostRoot.child("Option_2");
    DatabaseReference count2 = hostRoot.child("Count_2");
    DatabaseReference option3 = hostRoot.child("Option_3");
    DatabaseReference count3 = hostRoot.child("Count_3");
    DatabaseReference option4 = hostRoot.child("Option_4");
    DatabaseReference count4 = hostRoot.child("Count_4");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        ques = findViewById(R.id.editTextQues);
        opt1 = findViewById(R.id.option1);
        opt2 = findViewById(R.id.option2);
        opt3 = findViewById(R.id.option3);
        opt4 = findViewById(R.id.option4);
        submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    public void submit() {
        hostRoot.child("Question").removeValue();
        hostRoot.child("Option_1").removeValue();
        hostRoot.child("Option_2").removeValue();
        hostRoot.child("Option_3").removeValue();
        hostRoot.child("Option_4").removeValue();
        hostRoot.child("Count_1").removeValue();
        hostRoot.child("Count_2").removeValue();
        hostRoot.child("Count_3").removeValue();
        hostRoot.child("Count_4").removeValue();

        if (ques.getText().toString().isEmpty()) {
            ques.setError("Add Question");
        } else {
            question.push().setValue(ques.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(HostActivity.this, "Succesfully Add ques", Toast.LENGTH_SHORT).show();
                        Intent backtoHome = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(backtoHome);
                    } else {
                        Toast.makeText(HostActivity.this, "OOpppss!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if (opt1.getText().toString().isEmpty()) {
            opt1.setError("Add Option 1");
        } else {
            option1.push().setValue(opt1.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        //Toast.makeText(HostActivity.this, "Succesfully Add ques", Toast.LENGTH_SHORT).show();
                        //Intent backtoHome = new Intent(getApplicationContext(), MainActivity.class);
                        //startActivity(backtoHome);
                    } else {
                        //Toast.makeText(HostActivity.this, "OOpppss!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        if (opt2.getText().toString().isEmpty()) {
            opt2.setError("Add Question");
        } else {
            option2.push().setValue(opt2.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        //Toast.makeText(HostActivity.this, "Succesfully Add ques", Toast.LENGTH_SHORT).show();
                        //Intent backtoHome = new Intent(getApplicationContext(), MainActivity.class);
                        //startActivity(backtoHome);
                    } else {
                        //Toast.makeText(HostActivity.this, "OOpppss!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        if (opt3.getText().toString().isEmpty()) {
            opt3.setError("Add Question");
        } else {
            option3.push().setValue(opt3.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        //Toast.makeText(HostActivity.this, "Succesfully Add ques", Toast.LENGTH_SHORT).show();
                        //Intent backtoHome = new Intent(getApplicationContext(), MainActivity.class);
                        //startActivity(backtoHome);
                    } else {
                        //Toast.makeText(HostActivity.this, "OOpppss!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        if (opt4.getText().toString().isEmpty()) {
            opt4.setError("Add Question");
        } else {
            option4.push().setValue(opt4.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        //Toast.makeText(HostActivity.this, "Succesfully Add ques", Toast.LENGTH_SHORT).show();
                        //Intent backtoHome = new Intent(getApplicationContext(), MainActivity.class);
                        //startActivity(backtoHome);
                    } else {
                        //Toast.makeText(HostActivity.this, "OOpppss!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        initCount();
    }

    public void initCount(){

        count1.push().setValue(0);
        count2.push().setValue(0);
        count3.push().setValue(0);
        count4.push().setValue(0);
    }
}