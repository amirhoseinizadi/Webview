package com.example.webview;

import static android.webkit.URLUtil.isValidUrl;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        WebView webview = findViewById(R.id.webview);
        Button back = findViewById(R.id.button3);
        Button forward = findViewById(R.id.button2);
        Button Go = findViewById(R.id.button);
        EditText edittext = findViewById(R.id.editTextText);

        back.setOnClickListener(v -> {
            if(webview.canGoBack()){
                webview.goBack();
            }
        });

        forward.setOnClickListener(v -> {
            if(webview.canGoForward()){
                webview.goForward();
            }
        });

        Go.setOnClickListener(v -> {
            String address = edittext.getText().toString();

            if (isValidUrl(address.trim())){
                webview.loadUrl(address);
            } else {
                Toast.makeText(this, "address is not valid", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}