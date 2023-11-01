package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.text.NumberFormat.*

class MainActivity : AppCompatActivity() {
    private lateinit  var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton1.setOnClickListener { calculateTip() }
    }
    private fun displayTip(propina : Double){
        binding.propina.text = getString(R.string.propina_resultante,
            getCurrencyInstance().format(propina))
    }
    private fun calculateTip(){

        val costeServicio = binding.costeServicioEditText.text.toString().toDoubleOrNull()
        if(costeServicio == null || costeServicio == 0.0){
            Toast.makeText(this,"Introduce un importe correcto",Toast.LENGTH_SHORT).show()
            displayTip(0.0)
            return
        }
        val porcentaje = when(binding.grupoBotones.checkedRadioButtonId){
            R.id.PrimerBoton -> 0.20
            R.id.SegundoBoton -> 0.18
            else -> 0.15
        }

        var propina = porcentaje*costeServicio
        if(binding.redondear.isChecked) {
            propina = kotlin.math.ceil(propina)
        }
        displayTip(propina)

    }
}