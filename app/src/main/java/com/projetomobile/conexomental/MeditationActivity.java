package com.projetomobile.conexomental;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MeditationActivity extends AppCompatActivity {

    // IDs das imagens
    private static final int IMAGE1 = R.drawable.checkbox01;
    private static final int IMAGE2 = R.drawable.checkbox02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meditation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        VideoView videoView = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tecnicaansiedade);
        videoView.setVideoURI(videoUri);
        videoView.start();
        // Inicializa a tag do ImageView
        ImageView imageView1 = findViewById(R.id.imageView2);
        imageView1.setTag(IMAGE1);
        ImageView imageView2 = findViewById(R.id.imageView3);
        imageView2.setTag(IMAGE1);
        ImageView imageView3 = findViewById(R.id.imageView4);
        imageView3.setTag(IMAGE1);
    }

    public void marcarHorario(View v) {
        // Verifica se o View é um ImageView
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            // Obtém o identificador da imagem atual
            int currentImageId = (Integer) imageView.getTag();

            // Define a nova imagem com base na atual
            if (currentImageId == IMAGE1) {
                imageView.setImageResource(IMAGE2);
                imageView.setTag(IMAGE2); // Atualiza a tag com o novo identificador
            } else {
                imageView.setImageResource(IMAGE1);
                imageView.setTag(IMAGE1); // Atualiza a tag com o novo identificador
            }
        }
    }
}