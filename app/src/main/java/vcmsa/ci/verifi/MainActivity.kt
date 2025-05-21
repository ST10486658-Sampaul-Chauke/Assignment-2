package vcmsa.ci.verifi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*Code Attribution
        This code was taken from the IMAD5112 Module Manual pages 53-56
          https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
          Varsity College IIE
             */
        // initialize UI elements
        val welcomeMessage = findViewById<TextView>(R.id.Welcome)
        val appDescription = findViewById<TextView>(R.id.message)
        val startButton = findViewById<Button>(R.id.start)
        val exitButton = findViewById<Button>(R.id.exit)

        /*Code Attribution
This code was taken from the IMAD5112 Module Manual pages 41-43
  https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
  Varsity College IIE
     */
        //set welcome message and app description
        welcomeMessage.text = "Welcome to VeriFi!"
        appDescription.text = "Test your knowledge with these fun flashcards."

        /*Code Attribution
This code was taken from the IMAD5112 Module Manual pages 62-65
  https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
  Varsity College IIE
     */
        //set click listener for the start button
        startButton.setOnClickListener {
            //Start the Quizactivty
            val intent = Intent(this, Question::class.java)
            startActivity(intent)
        }
// Exiting the game
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}
