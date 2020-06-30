package com.ranipetdt.flames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button display;
private TextView showme;
String lbl="";
    String name1 = "";
    String name2 = "";
    int count=0;
    int y =0;
private EditText firstname,secondname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.btn_showMe);
        showme = findViewById(R.id.txt_display);
        firstname = findViewById(R.id.txt_yourName);
        secondname = findViewById(R.id.txt_partnerName);
        firstname.addTextChangedListener(textWatcher);
        secondname.addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            name1 = firstname.getText().toString().trim();
            name2 = secondname.getText().toString().trim();

            display.setEnabled(name1 !=""&&!name1.isEmpty()&& !name2.isEmpty()&&name2!="");
             showme.setText("");
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public void matchAction(View view) {
        try {
            name1 = firstname.getText().toString().trim();
            name2 = secondname.getText().toString().trim();
        String partnername = name2;
        String commonChars = "";
            name1 = name1.toLowerCase();
            name2 = name2.toLowerCase();
        StringBuilder sb1 = new StringBuilder(name1);// converting to string builder
        StringBuilder sb2 = new StringBuilder(name2);


            int m=sb1.length();
            int n=sb2.length();
            for(int i=0; i<m;i++)
            {
                for(int j=0; j<n;j++)
                {
                    if(sb1.charAt(i) == sb2.charAt(j))
                    {
                        sb1.replace(i, i+1, "0"); // replacing matching characters into "0"
                        sb2.replace(j,j+1,"0");
                    }
                }
            }



            int x1=0;
            int y1=0;
            String s1="";
            String s2="";
            s1 = sb1.toString();
            s2 = sb2.toString();
            for(int i=0;i<s1.length();i++){ //length of string to remove 0 and find the length
                if(s1.charAt(i)!='0'){
                    System.out.print(" "+s1.charAt(i));
                    x1 +=1;

                }
            }
            System.out.println();
            System.out.println("First String: "+x1);

            for(int i=0;i<s2.length();i++){
                if(s2.charAt(i)!='0'){
                    System.out.print(" "+s2.charAt(i));
                    y1 +=1;

                }
            }
            System.out.println();
            System.out.println("Second String: "+y1);


            int x = x1+y1; // total length of remaining characters in both the strings
            System.out.println("Length is: "+x);

            //------------------------------- STEP 2 COMPLETE --------------------------------------

            String flames = "flames";
            StringBuilder sb3 = new StringBuilder(flames);

            char flameResult = 0;

            while(sb3.length()!=1)
            {
                int y = x%sb3.length();
                String temp;

                if(y!=0)
                {
                    temp = sb3.substring(y)+sb3.substring(0, y-1); // taking substring (counting purpose)

                }
                else
                {
                    temp = sb3.substring(0, sb3.length()-1); // taking substring (counting purpose)

                }
                sb3 = new StringBuilder(temp);
                flameResult = sb3.charAt(0);

            }
            System.out.println(flameResult);
//        for (int i = 0; i < s1.length(); i++) {
//            for (int j = 0; j < s2.length(); j++) {
//                if (s1.charAt(i) == s2.charAt(j)) {
//                    commonChars += s1.charAt(i);
////                    sb1.replace(i, i+1, "0"); // replacing matching characters into "0"
////                    sb2.replace(j,j+1,"0");
//                }
//            }
//        }

//        for(int i = 0; i < commonChars.length(); i ++) {
//            String charToRemove = commonChars.charAt(i)+"";
//            s1 = s1.replace(charToRemove, "");
//            s2 = s2.replace(charToRemove, "");
//        }
//
//            String s3 = s1+s2;
//            count = s3.length();
//
//
//            String flames = "flames";
//            StringBuilder sb3 = new StringBuilder(flames);
//
//            char flameResult = 0;
//
//            while(sb3.length()!=1)
//            {
//                y = count%sb3.length();
//                String temp;
//
//                if(y!=0)
//                {
//                    temp = sb3.substring(y)+sb3.substring(0, y-1); // taking substring (counting purpose)
//
//                }
//                else
//                {
//                    temp = sb3.substring(0, sb3.length()-1); // taking substring (counting purpose)
//
//                }
//                sb3 = new StringBuilder(temp);
//                flameResult = sb3.charAt(0);
//
//            }

           // ------------------------------------ STEP 3 COMPLETE -------------------------------------------

                    switch(flameResult)
                            {
                                case 'f':
                                    lbl=getString(R.string.f);
                                    break;
                                case 'l':
                                    lbl=getString(R.string.l);
                                    break;
                                case 'a':
                                    lbl=getString(R.string.a);
                                    break;
                                case 'm':
                                    lbl=getString(R.string.m);
                                    break;
                                case 'e':
                                    lbl=getString(R.string.e);
                                    break;
                                case 's':
                                    lbl=getString(R.string.s);
                                    break;

                            }


    showme.setText(partnername+"\t"+lbl);
}catch (Exception e){e.printStackTrace();}
    }
}
