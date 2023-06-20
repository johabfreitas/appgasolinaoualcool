package br.com.johabfreitas.appgasolinaoualcool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var editGasolina: EditText
    private lateinit var editAlcool: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular = findViewById(R.id.btn_calcular)
        editGasolina = findViewById(R.id.edit_gasolina)
        editAlcool = findViewById(R.id.edit_alcool)

        btnCalcular.setOnClickListener {
            val intent = Intent(this, DetalhesActivity::class.java)

            val gasolina = editGasolina.text.toString()
            val alcool = editAlcool.text.toString()
            
            if(gasolina.isNotEmpty() && alcool.isNotEmpty()){
                intent.putExtra("gasolina", gasolina.toDouble())
                intent.putExtra("alcool", alcool.toDouble())
            }
            
            startActivity(intent)
        }
    }
}