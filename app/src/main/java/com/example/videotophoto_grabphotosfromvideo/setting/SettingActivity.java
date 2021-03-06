package com.example.videotophoto_grabphotosfromvideo.setting;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.videotophoto_grabphotosfromvideo.R;

public class SettingActivity extends AppCompatActivity {
    TextView tvFileFormat, tvFileQuality, tvFileSize, tvLanguage;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREFERENCES_NAME = "Settings";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        tvFileFormat = findViewById(R.id.tvFileFormat);
        tvFileQuality = findViewById(R.id.tvFileQuality);
        tvFileSize = findViewById(R.id.tvFileSize);
        tvLanguage = findViewById(R.id.tvLanguage);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String file_format = sharedPreferences.getString("file_format", "JPG");
        String quality = sharedPreferences.getString("quality", "High");
        String size = sharedPreferences.getString("size", "1x");
        String language = sharedPreferences.getString("language_format","Tiếng Việt");
        tvFileFormat.setText(file_format);
        tvFileQuality.setText(quality);
        tvFileSize.setText(size);
        tvLanguage.setText(language);
        tvFileFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                View view = LayoutInflater.from(SettingActivity.this).inflate(R.layout.dialog_file_formats, null);
                builder.setTitle("File Format");
                RadioButton rbJPG = (RadioButton) view.findViewById(R.id.rbJPG);
                RadioButton rbPNG = (RadioButton) view.findViewById(R.id.rbPNG);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (rbJPG.isChecked()) {
                            tvFileFormat.setText(rbJPG.getText().toString());
                            editor.putString("file_format", "JPG");
                        } else {
                            tvFileFormat.setText(rbPNG.getText().toString());
                            editor.putString("file_format", "PNG");
                        }
                        editor.apply();
                        editor.commit();
                    }
                });

                builder.setView(view);
                builder.show();
            }
        });

        tvFileQuality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(SettingActivity.this);
                View view = LayoutInflater.from(SettingActivity.this).inflate(R.layout.dialog_file_quality, null);
                builder1.setTitle("File Quality");
                RadioButton rbBest = (RadioButton) view.findViewById(R.id.rbBest);
                RadioButton rbVeryHigh = (RadioButton) view.findViewById(R.id.rbVeryHigh);
                RadioButton rbHigh = (RadioButton) view.findViewById(R.id.rbHigh);
                RadioButton rbMedium = (RadioButton) view.findViewById(R.id.rbMedium);
                RadioButton rbLow = (RadioButton) view.findViewById(R.id.rbLow);
                builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (rbBest.isChecked()) {
                            tvFileQuality.setText(rbBest.getText().toString());
                            editor.putString("quality", "Best");
                        } else if (rbVeryHigh.isChecked()) {
                            tvFileQuality.setText(rbVeryHigh.getText().toString());
                            editor.putString("quality", "Very High");
                        } else if (rbHigh.isChecked()) {
                            tvFileQuality.setText(rbHigh.getText().toString());
                            editor.putString("quality", "High");
                        } else if (rbMedium.isChecked()) {
                            tvFileQuality.setText(rbMedium.getText().toString());
                            editor.putString("quality", "Medium");
                        } else {
                            tvFileQuality.setText(rbLow.getText().toString());
                            editor.putString("quality", "Low");
                        }
                        editor.apply();
                        editor.commit();
                    }
                });

                builder1.setView(view);
                builder1.show();
            }
        });


        tvFileSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(SettingActivity.this);
                View view = LayoutInflater.from(SettingActivity.this).inflate(R.layout.dialog_file_size, null);
                builder2.setTitle("File Size");
                RadioButton rb05 = (RadioButton) view.findViewById(R.id.rb05);
                RadioButton rb1 = (RadioButton) view.findViewById(R.id.rb1);
                RadioButton rb15 = (RadioButton) view.findViewById(R.id.rb15);
                RadioButton rb2 = (RadioButton) view.findViewById(R.id.rb2);
                RadioButton rb3 = (RadioButton) view.findViewById(R.id.rb3);
                builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (rb05.isChecked()) {
                            tvFileSize.setText(rb05.getText().toString());
                            editor.putString("size", "0.5x");
                        } else if (rb1.isChecked()) {
                            tvFileSize.setText(rb1.getText().toString());
                            editor.putString("size", "1x");
                        } else if (rb15.isChecked()) {
                            tvFileSize.setText(rb15.getText().toString());
                            editor.putString("size", "1.5x");
                        } else if (rb2.isChecked()) {
                            tvFileSize.setText(rb2.getText().toString());
                            editor.putString("size", "2x");
                        } else {
                            tvFileSize.setText(rb3.getText().toString());
                            editor.putString("size", "3x");
                        }
                        editor.apply();
                        editor.commit();
                    }
                });

                builder2.setView(view);
                builder2.show();
            }
        });

        tvLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                View view = LayoutInflater.from(SettingActivity.this).inflate(R.layout.dialog_file_language, null);
                builder.setTitle("Language Format");
                RadioButton rbViet = (RadioButton) view.findViewById(R.id.rbViet);
                RadioButton rbAnh = (RadioButton) view.findViewById(R.id.rbAnh);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (rbViet.isChecked()) {
                            tvLanguage.setText(rbViet.getText().toString());
                            editor.putString("language_format", "Tiếng Việt");
                        } else {
                            tvLanguage.setText(rbAnh.getText().toString());
                            editor.putString("language_format", "English");
                        }
                        editor.apply();
                        editor.commit();
                    }
                });

                builder.setView(view);
                builder.show();
            }
        });

    }
}