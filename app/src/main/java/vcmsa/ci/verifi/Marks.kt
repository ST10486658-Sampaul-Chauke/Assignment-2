package vcmsa.ci.verifi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class Marks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_marks)

        val scoreText = findViewById<TextView>(R.id.Score)
        val feedback = findViewById<TextView>(R.id.Feedback)
        val review = findViewById<Button>(R.id.Review)
        val exitbutton = findViewById<Button>(R.id.ExitButton)

        val score = intent.getIntExtra("score", 0)
        scoreText.text = "Your score: $score/5"
        /*Code Attribution
This code was taken from the IMAD5112 Module Manual pages 49-59
  https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
  Varsity College IIE
     */
//If statement
        val feedbackText = if (score>=3){
            "Great job"
        } else{
            "Keep practicing"
        }
        feedback.text = feedbackText
//
        review.setOnClickListener {
            val intent = Intent(this, Review::class.java )
            intent.putExtra("questions", Question.questionlist)
            intent.putExtra("answer", Question.answers)
            startActivity(intent)
        }
        /*Code Attribution
This code was taken from the IMAD5112 Module Manual pages 38-44
  https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
  Varsity College IIE
     */
// Exit button control
        exitbutton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}