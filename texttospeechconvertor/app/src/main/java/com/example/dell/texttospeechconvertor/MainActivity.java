package com.example.dell.texttospeechconvertor;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText e;
    TextToSpeech t;
    Button speak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e =(EditText)findViewById(R.id.editText);
        speak=(Button)findViewById(R.id.button);

        t=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                t.setLanguage(Locale.JAPAN);
            }
        });

        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st=e.getText().toString();
                t.speak(st ,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });

    }
}
