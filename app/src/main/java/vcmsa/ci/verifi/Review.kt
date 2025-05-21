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


class Review : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val check = findViewById<TextView>(R.id.textView)
        val restartBtn = findViewById<Button>(R.id.Restart)
        val exitBtn = findViewById<Button>(R.id.Exit)
        /*Code Attribution
        This code was taken from the IMAD5112 Module Manual pages 62-65
          https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
          Varsity College IIE
             */
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answer")

        val reviewText = StringBuilder()
        /*Code Attribution
        This code was taken from the IMAD5112 Module Manual pages 49-59
          https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
          Varsity College IIE
             */
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                reviewText.append("${i + 1}. ${questions[i]}\n")
                reviewText.append("Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            check.text = reviewText.toString()
        } else {
            check.text = "Error loading review data."
        }

        restartBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        /*Code Attribution
        This code was taken from the IMAD5112 Module Manual pages 38-44
          https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
          Varsity College IIE
             */
        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}
