package br.com.johabfreitas.appgasolinaoualcool

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DetalhesActivity : AppCompatActivity() {

    private lateinit var imgGasolina: ImageView
    private lateinit var imgEtanol: ImageView
    private lateinit var textGasolina: TextView
    private lateinit var textEtanol: TextView
    private lateinit var textResultado: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        imgGasolina = findViewById(R.id.img_gasolina)
        imgEtanol = findViewById(R.id.img_etanol)
        textGasolina = findViewById(R.id.text_gasolina)
        textEtanol = findViewById(R.id.text_etanol)
        textResultado = findViewById(R.id.text_resultado)

        val bundle = intent.extras
        if(bundle != null){
            val precoGasolina = bundle.getDouble("gasolina")
            val precoAlcool = bundle.getDouble("alcool")

            textGasolina.text = String.format("Preço Gasolina: R$%.2f", precoGasolina)
            textEtanol.text = String.format("Preço Álcool: R$%.2f", precoAlcool)

            val resultado = precoAlcool / precoGasolina

            val media = if(resultado > 0.7){
                imgGasolina.setVisibility(View.VISIBLE)
                "Gasolina"
            } else {
                imgEtanol.setVisibility(View.VISIBLE)
                "Álcool"
            }

            textResultado.text = media


        }

    }
}