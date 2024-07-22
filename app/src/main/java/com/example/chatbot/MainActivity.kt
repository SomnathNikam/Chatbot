package com.example.chatbot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.ai.client.generativeai.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eTPrompt = findViewById<EditText>(R.id.eTPrompt)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnSubmit.setOnClickListener {
            val prompt = eTPrompt.text.toString()

            val generativeModel = GenerativeModel(
                // The Gemini 1.5 models are versatile and work with both text-only and multimodal prompts
                modelName = "gemini-1.5-flash",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = ""
            )

            runBlocking {
                val response = generativeModel.generateContent(prompt)
                tvResult.text = response.text.toString()
                print(tvResult)
            }
        }

    }
}