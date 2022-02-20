package com.example.hackfrostletsgo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lessons2 extends AppCompatActivity {
    private int x1 = 0;
    private String r;
    private HashMap<String, User> m = new HashMap<String, User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons2);
        FirebaseFirestore db = FirebaseFirestore.getInstance();




        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Lessons2", document.getId() + " => " + document.getData());
                                User user = document.toObject(User.class);
                                m.put(String.valueOf(x1), user);
                                x1++;
                            }
                        } else {
                            Log.d("Lessons2", "Error getting documents: ", task.getException());
                        }
                        if(x1 >= 2) {
                            runIt();
                        }
                    }
                });





    }

    private void runIt() {
        for(int i = 0; i < 3; i++) {
            TextView t1;
            Button b1;
            if (i == 0) {
                t1 = findViewById(R.id.t_1);
                b1 = findViewById(R.id.button6);

            } else if (i == 1) {
                t1 = findViewById(R.id.t_2);
                b1 = findViewById(R.id.button8);
            } else {
                t1 = findViewById(R.id.t_3);
                b1 = findViewById(R.id.button9);
            }
            if(m.get(String.valueOf(i)).getName() != null)
            t1.setText("         " + Objects.requireNonNull(m.get(String.valueOf(i))).getName() + ", " + Objects.requireNonNull(m.get(String.valueOf(i))).getSchool() + ", " + Objects.requireNonNull(m.get(String.valueOf(i))).getCountry());
            b1.setText(m.get(String.valueOf(i)).getName() + "'s Lesson Plan");
        }
    }
}