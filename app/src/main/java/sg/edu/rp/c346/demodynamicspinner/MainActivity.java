package sg.edu.rp.c346.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import sg.edu.rp.c346.dynamicspinner.R;

public class MainActivity extends AppCompatActivity {

    Spinner s1, s2;
    Button b1;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = findViewById(R.id.spinner1);
        s2 = findViewById(R.id.spinner2);
        b1 = findViewById(R.id.buttonUpdate);

//        alNumbers = new ArrayList<>();

//        alNumbers.add("2");
//        alNumbers.add("4");
//        alNumbers.add("6");


        //Need click update
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = s1.getSelectedItemPosition();
//                alNumbers.clear();
//
//                String[] strNumbersO = getResources().getStringArray(R.array.odd_numbers);
//                aaNumbers = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, strNumbersO);
//                s2.setAdapter(aaNumbers);
//
                switch (pos) {
                    case 0:
                        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

                        aaNumbers = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, strNumbers);
                        s2.setAdapter(aaNumbers);
                        break;
                    case 1:
                        String[] strNumbersO = getResources().getStringArray(R.array.odd_numbers);

                        aaNumbers = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, strNumbersO);
                        s2.setAdapter(aaNumbers);
                        break;
                }


                //Automatic update
                s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                //Get the string-array and store as an Array
                                String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                                aaNumbers = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, strNumbers);
                                s2.setAdapter(aaNumbers);
                                s2.setSelection(2);

                                //Convert Array to List and add to the ArrayList
//                        alNumbers.addAll(Arrays.asList(strNumbers));
                                break;


                            case 1:
                                String[] strNumbersO = getResources().getStringArray(R.array.odd_numbers);

                                aaNumbers = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, strNumbersO);
                                s2.setAdapter(aaNumbers);
                                s2.setSelection(1);
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
//
                    }
                });
            }
        });


    }
}
