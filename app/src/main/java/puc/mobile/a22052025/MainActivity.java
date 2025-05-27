package puc.mobile.a22052025;

import static android.app.ProgressDialog.show;

import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView hulk01, hulk02, hulk03, hulk04, hulk05, hulk06, hulk07, hulk08;
    ProgressBar progressBar;
    TextView pts, ptSM;
    Button iniciar;
    Random r;

    int pontos=0, fps = 1000, ptsMax=0, tempo=0, resta=5, tempoStatus=0;
    int imgAtv=0, imgAtvSalva=0;
    AnimationDrawable an;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.button);
        pts = findViewById(R.id.pts);
        ptSM = findViewById(R.id.recorde);
        progressBar = findViewById(R.id.progressBar);

        hulk01 = findViewById(R.id.hulk_01);
        hulk01.setVisibility(View.INVISIBLE);
        hulk02 = findViewById(R.id.hulk_02);
        hulk02.setVisibility(View.INVISIBLE);
        hulk03 = findViewById(R.id.hulk_03);
        hulk03.setVisibility(View.INVISIBLE);
        hulk04 = findViewById(R.id.hulk_04);
        hulk04.setVisibility(View.INVISIBLE);
        hulk05 = findViewById(R.id.hulk_05);
        hulk05.setVisibility(View.INVISIBLE);
        hulk06 = findViewById(R.id.hulk_06);
        hulk06.setVisibility(View.INVISIBLE);
        hulk07 = findViewById(R.id.hulk_07);
        hulk07.setVisibility(View.INVISIBLE);
        hulk08 = findViewById(R.id.hulk_08);
        hulk08.setVisibility(View.INVISIBLE);
        
        r = new Random();
        iniciar.setOnClickListener(v -> {
            resta = 0;
            tempoStatus=100;
            pontos = 0;
            pts.setText("Pontos: " +pontos);

            Handler handler = new Handler();
            handler.postDelayed(() -> minhaEngine(), 1000);
            iniciar.setEnabled(false);
            final Handler handler2 = new Handler();
            new Thread(() -> {
                while (tempoStatus > resta) {
                    tempoStatus--;
                    android.os.SystemClock.sleep(250);
                    handler.post(() -> progressBar.setProgress(tempoStatus));
                }
            }).start();
        });

        hulk01.setOnClickListener(v -> {
            tempo = 1;
            hulk01.setImageResource(R.drawable.hulk_03);
            pontos++;
            pts.setText("Pontos: " +pontos);
            hulk01.setEnabled(false);
        });

        hulk02.setOnClickListener(v -> {
            tempo = 1;
            hulk02.setImageResource(R.drawable.hulk_03);
            pontos++;
            pts.setText("Pontos: " +pontos);
            hulk02.setEnabled(false);
        });

        hulk03.setOnClickListener(v -> {
            tempo = 1;
            hulk03.setImageResource(R.drawable.hulk_03);
            pontos++;
            pts.setText("Pontos: " +pontos);
            hulk03.setEnabled(false);
        });

        hulk04.setOnClickListener(v -> {
            tempo = 1;
            hulk04.setImageResource(R.drawable.hulk_03);
            pontos++;
            pts.setText("Pontos: " +pontos);
            hulk04.setEnabled(false);
        });

        hulk05.setOnClickListener(v -> {
            tempo = 1;
            hulk05.setImageResource(R.drawable.hulk_03);
            pontos++;
            pts.setText("Pontos: " +pontos);
            hulk05.setEnabled(false);
        });

        hulk06.setOnClickListener(v -> {
            tempo = 1;
            hulk06.setImageResource(R.drawable.hulk_03);
            pontos++;
            pts.setText("Pontos: " +pontos);
            hulk06.setEnabled(false);
        });

        hulk07.setOnClickListener(v -> {
            tempo = 1;
            hulk07.setImageResource(R.drawable.hulk_03);
            pontos++;
            pts.setText("Pontos: " +pontos);
            hulk07.setEnabled(false);
        });

        hulk08.setOnClickListener(v -> {
            tempo = 1;
            hulk08.setImageResource(R.drawable.hulk_03);
            pontos++;
            pts.setText("Pontos: " +pontos);
            hulk08.setEnabled(false);
        });
    }

    private void minhaEngine() {
        if (pontos<10) fps = 1000;
        else if (pontos>=10 && pontos<15) fps = 950;
        else if (pontos>=15 && pontos<20) fps = 900;
        else if (pontos>=20 && pontos<25) fps = 850;
        else if (pontos>=25 && pontos<30) fps = 800;
        else if (pontos>=30 && pontos<35) fps = 750;
        else if (pontos>=35 && pontos<40) fps = 700;
        else if (pontos>=40 && pontos<45) fps = 650;
        else if (pontos>=45 && pontos<50) fps = 600;
        else if (pontos>=50 && pontos<55) fps = 550;
        else if (pontos>=55 && pontos<60) fps = 500;
        else if (pontos>=60 && pontos<65) fps = 450;
        else fps = 400;

        an = (AnimationDrawable) ContextCompat.getDrawable(this, R.drawable.animacao);
        do {
            imgAtv = r.nextInt(8) + 1;
        } while (imgAtvSalva==imgAtv);
        imgAtvSalva = imgAtv;
        if (imgAtv == 1) {
            hulk01.setImageDrawable(an);
            hulk01.setVisibility(View.VISIBLE);
            hulk01.setEnabled(true);
        } else if (imgAtv == 2) {
            hulk02.setImageDrawable(an);
            hulk02.setVisibility(View.VISIBLE);
            hulk02.setEnabled(true);
        }

        an.start();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            hulk01.setVisibility(View.INVISIBLE);
            hulk02.setVisibility(View.INVISIBLE);
            hulk03.setVisibility(View.INVISIBLE);
            hulk04.setVisibility(View.INVISIBLE);
            hulk05.setVisibility(View.INVISIBLE);
            hulk06.setVisibility(View.INVISIBLE);
            hulk07.setVisibility(View.INVISIBLE);
            hulk08.setVisibility(View.INVISIBLE);
            hulk01.setEnabled(false);
            hulk02.setEnabled(false);
            hulk03.setEnabled(false);
            hulk04.setEnabled(false);
            hulk05.setEnabled(false);
            hulk06.setEnabled(false);
            hulk07.setEnabled(false);
            hulk08.setEnabled(false);

            if (tempoStatus<1) {
                Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                iniciar.setEnabled(true);
                if (ptsMax<pontos) ptsMax = pontos;
                ptSM.setText("Recorde: " +ptsMax);
                SharedPreferences prefs = getSharedPreferences("recorde", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("recorde", ptsMax);
                editor.apply();
            } else minhaEngine();
        }, fps);

        // persistência de dados
        SharedPreferences prefs = getSharedPreferences("recorde", MODE_PRIVATE);
        ptsMax = prefs.getInt("recorde", 0);
        ptSM.setText("Recorde: " + ptsMax);
    }
}