package vcmsa.ci.verifi

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Question : AppCompatActivity() {

    private lateinit var question: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var feedback: TextView
    private lateinit var nextButton: Button
    /*Code Attribution
    This code was taken from the IMAD5112 Module Manual pages 71-83
      https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
      Varsity College IIE
         */
    companion object {
        val questionlist = arrayOf(
            "Sound cannot travel through a vacuum.",

            "Sound travels faster in air than in water",

            "Pitch is determined by the amplitude of a sound wave.",

            "Loudness depends on the frequency of the sound wave.",

            "Sound is a mechanical wave."

        )
        /*Code Attribution
        This code was taken from the IMAD5112 Module Manual pages 71-83
          https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
          Varsity College IIE
             */
        val answers = booleanArrayOf(true, false, false,false, true)
    }

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)

        //Initialize UI

        question = findViewById(R.id.question)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        feedback = findViewById(R.id.Feedback)
        nextButton = findViewById(R.id.nextButton)

        //Display the first question
        displayQuestion()
        /*Code Attribution
        This code was taken from the IMAD5112 Module Manual pages 38-44
          https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
          Varsity College IIE
             */
        //Set click listener for the answer buttons
        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questionlist.size) {
                displayQuestion()
                feedback.text = "" //clear feedback message
                trueButton.isEnabled = true // Enable buttons
                falseButton.isEnabled = true
            } else {
                /*Code Attribution
This code was taken from the IMAD5112 Module Manual page 62-65
  https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
  Varsity College IIE
     */
                // Go to ScoreActivity
                val intent = Intent(this, Marks::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish() // Finish Questions so the user can't go back

            }
            nextButton.isEnabled = false //Disable next button at the start

        }
    }
    private fun displayQuestion(){
        question.text = questionlist[currentQuestionIndex]
    }
    /*Code Attribution
This code was taken from the IMAD5112 Module Manual pages 66-70
  https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
  Varsity College IIE
     */
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]

//if statement
        if (userAnswer == correctAnswer) {
            feedback.text = "Correct!"
            feedback.setTextColor(Color.GREEN)
            score++

        } else {
            feedback.setTextColor(Color.RED)
            feedback.text = "Incorrect"
        }
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = true
    }
}

