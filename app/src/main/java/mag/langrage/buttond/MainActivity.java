package mag.langrage.buttond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button btnMain, btnSetting;
      TextView textView;
      File myDir ;
      String pathFileDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMain= findViewById(R.id.btnMain);
        btnSetting= findViewById(R.id.btnSetting);
        textView= findViewById(R.id.textView);
        pathFileDelete=Environment.getExternalStorageDirectory().getAbsolutePath();
        pathFileDelete=pathFileDelete+"/Telegram";
        textView.setText(pathFileDelete);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             try {

                 myDir = new File(pathFileDelete);
                 deleteFolderRecursive(myDir);
                 textView.setText("готово");


             } catch (Exception e){
                 textView.setText("U have a problams   "+e.getMessage());

             }


            }

            private void deleteFile() {

                try {

                    new File(pathFileDelete).createNewFile();
                    textView.setText("готово");
                } catch (Exception e) {
                    textView.setText("U have a problams  deleteFile "+e.getMessage());
                     } }

        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context content = MainActivity.this;
                Intent IntentSet= new Intent(content, Setting.class);
                startActivity(IntentSet);

            }
        });

        


    }

    private void deleteFolderRecursive(File dir) {

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolderRecursive(file);
                } else {
                    file.delete();
                }
            }
        }

        dir.delete();
    }
}

