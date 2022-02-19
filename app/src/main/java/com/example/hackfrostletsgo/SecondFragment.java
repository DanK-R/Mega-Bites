package com.example.hackfrostletsgo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hackfrostletsgo.databinding.FragmentSecondBinding;

    public class SecondFragment extends AppCompatActivity {
    String Country, schoolname, name;

    EditText nameinput;
    EditText schoolnameinput;
    EditText countrynameinput;

    Button submit;
    Button prevous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        countrynameinput = (EditText) findViewById(R.id.countrynameinput);
        schoolnameinput = (EditText) findViewById(R.id.schoolnameinput);
        nameinput = (EditText) findViewById(R.id.nameinput);

        submit = (Button) findViewById(R.id.submit);
        prevous = (Button) findViewById((R.id.prevous));


                submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameinput.getText().toString();
                schoolname = schoolnameinput.getText().toString();
                Country = countrynameinput.getText().toString();

                showToast(Country);
                showToast(schoolname);
                showToast(name);
            }
        });
    }



    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}