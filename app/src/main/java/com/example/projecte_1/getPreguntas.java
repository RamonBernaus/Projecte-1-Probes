package com.example.projecte_1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

public class getPreguntas extends AppCompatActivity {

    private static final String TAG = "getPreguntas";
    private static final String URL = "http://localhost:3000/api/preguntas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_preguntes);

        // Inicializar la cola de solicitudes de Volley
        RequestQueue queue = Volley.newRequestQueue(this);

        // Crear una solicitud JSON
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                response -> {
                    try {
                        // Analizar el JSON
                        String pregunta = response.getString("pregunta");
                        String respuesta = response.getString("respuesta");

                        // Hacer algo con los datos
                        Log.d(TAG, "Pregunta: " + pregunta);
                        Log.d(TAG, "Respuesta: " + respuesta);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    // Manejar errores de solicitud
                    Log.e(TAG, "Error en la solicitud: " + error.getMessage());
                });

        // Agregar la solicitud a la cola de solicitudes
        queue.add(jsonObjectRequest);
    }
}

