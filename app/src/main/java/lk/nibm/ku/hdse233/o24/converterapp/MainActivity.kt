package lk.nibm.ku.hdse233.o24.converterapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var cmbChoice: Spinner
    private lateinit var txtInput: EditText
    private lateinit var txtResult: TextView
    private lateinit var btnConvert: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Locate UI elements
        cmbChoice = findViewById(R.id.cmbChoice)
        txtInput = findViewById(R.id.txtInput)
        txtResult = findViewById(R.id.txtResult)
        btnConvert = findViewById(R.id.btnConvert)

        // Combo box array
        val cmbChoiceArray = arrayOf("Distance (Km to M)", "Temperature (F to C)", "Weight (G to Kg)")
        // Populate Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cmbChoiceArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        cmbChoice.adapter = adapter

        // Button click function
        btnConvert.setOnClickListener {
            val inputValue = txtInput.text.toString()
            // Choosing the convertor
            if (inputValue.isNotEmpty()) {
                val result = when (cmbChoice.selectedItem.toString()) {
                    "Distance (Km to M)" -> convertKmToM(inputValue.toDouble())
                    "Temperature (F to C)" -> convertFahrenheitToCelsius(inputValue.toDouble())
                    "Weight (G to Kg)" -> convertGramsToKg(inputValue.toDouble())
                    else -> 0.0
                }
                // Displaying the result
                txtResult.text = "$result"
            } else {
                // Empty Input Error
                Toast.makeText(this, "Please enter a value!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // Convert Kilometers to Meters
    private fun convertKmToM(value: Double): Double {
        return value * 1000
    }
    // Convert Fahrenheit to Celsius
    private fun convertFahrenheitToCelsius(value: Double): Double {
        return (value - 32) * 5 / 9
    }
    // Convert Grams to Kilogram
    private fun convertGramsToKg(value: Double): Double {
        return value / 1000
    }
}