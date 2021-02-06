package mag.langrage.buttond;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Setting extends AppCompatActivity {
    Button btnFolder;
    EditText editFolder1;
    EditText editFolder2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btnFolder = findViewById(R.id.btnOnViewSetting);
        editFolder1 = findViewById(R.id.editDirName);
        editFolder2 = findViewById(R.id.editDirName2);
        btnFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnFolder.setText("вы всетаки нажали" );
                MainActivity.MyListDir.add(editFolder1.getText().toString());
                MainActivity.MyListDir.add(editFolder2.getText().toString());
            }
        });
    }
}