package com.example.projecte_1;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    Button Start;
    private TextView countdownText;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 30000; // 30 segundos = 30000 milisegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start = findViewById(R.id.StartButton);
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el botón, cambia al segundo diseño (activity_second.xml)
                setContentView(R.layout.pantalla_preguntes);

                //Creamos el crono
                countdownText = findViewById(R.id.Chronometer);

                // Inicializar el temporizador con un intervalo de 1 segundo (1000 milisegundos)
                countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timeLeftInMillis = millisUntilFinished;
                        updateCountdownText();
                    }

                    @Override
                    public void onFinish() {
                        // EL crono acaba, et porta a la pantalla final
                        setContentView(R.layout.pantalla_final);
                    }
                };

                countDownTimer.start(); // Iniciar el temporizador
            }

            private void updateCountdownText() {
                int seconds = (int) (timeLeftInMillis / 1000);
                String timeFormatted = String.format("%02d:%02d", seconds / 60, seconds % 60);
                countdownText.setText(timeFormatted);
            }
        });
    }
}

