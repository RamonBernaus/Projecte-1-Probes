package com.example.projecte_1;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class QuestionResponse {

    @SerializedName("pregunta")
    private String pregunta;

    @SerializedName("respuestas")
    private List<String> respuestas;

    public String getPregunta() {
        return pregunta;
    }

    public List<String> getRespuestas() {
        return respuestas;
    }
}

