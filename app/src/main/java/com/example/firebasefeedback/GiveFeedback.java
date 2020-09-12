package com.example.firebasefeedback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class GiveFeedback extends AppCompatActivity {

    TextView feedQues, opt1,opt2,opt3,opt4;
    Button submitAnswer;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference userRef = myRef.child("UsersFeedback");
    DatabaseReference hostRef = myRef.child("HostQues");
    DatabaseReference ques = hostRef.child("Question");
    DatabaseReference option1 = hostRef.child("Option_1");
    DatabaseReference count1 = hostRef.child("Count_1");
    DatabaseReference option2 = hostRef.child("Option_2");
    DatabaseReference count2 = hostRef.child("Count_2");
    DatabaseReference option3 = hostRef.child("Option_3");
    DatabaseReference count3 = hostRef.child("Count_3");
    DatabaseReference option4 = hostRef.child("Option_4");
    DatabaseReference count4 = hostRef.child("Count_4");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_feedback);
        feedQues = findViewById(R.id.feedbackques);
        submitAnswer = findViewById(R.id.submitAnswer);
        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);
        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int c1 = 0;
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                            c1 = Integer.valueOf(snapshot.getValue().toString());
                            c1 = c1 + 1;
                            break;
                        }
                        count1.push().setValue(c1);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        setQuestions();
        setOption();
        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAnswer();
            }
        });
    }
    public void setQuestions(){
        ques.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    feedQues.setText(snapshot.getValue().toString() + "\n");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(GiveFeedback.this,"Data rtreve Cancel",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setOption(){

        option1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()  ) {
                    opt1.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        option2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    opt2.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        option3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    opt3.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        option4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    opt4.setText(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void submitAnswer(){

//        if (userAnswer.getText().toString().isEmpty()) {
//            userAnswer.setError("Add Answer");
//        } else {
//            userRef.push().setValue(userAnswer.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//                    if (task.isSuccessful()) {
//                        Toast.makeText(GiveFeedback.this, "Succesfully Add Answer", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(GiveFeedback.this, "OOpppss!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
        }
    }
