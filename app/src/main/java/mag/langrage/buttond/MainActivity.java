package mag.langrage.buttond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
      Button btnMain, btnSetting;
      TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMain= findViewById(R.id.btnMain);
        btnSetting= findViewById(R.id.btnSetting);
        textView= findViewById(R.id.textView);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("нажал главную кнопку");
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* textView.setText("нажал кнопку настроек"); */
                Context content = MainActivity.this;
                Intent IntentSet= new Intent(content, Setting.class);
                startActivity(IntentSet);

            }
        });


    }

}