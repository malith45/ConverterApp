package lk.nibm.ku.hdse233.o24.converterapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var cmbChoice: Spinner
    private val cmbChoiceArray = arrayOf("Distance (Km to M)", "Temperature (F to C)", "Weight (G to Kg)")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Populate Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cmbChoiceArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        cmbChoice.adapter = adapter

    }
}