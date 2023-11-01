package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.text.NumberFormat.*

class MainActivity : AppCompatActivity() {
    lateinit  var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton1.setOnClickListener { calculateTip() }
    }
    fun calculateTip(){

        val costeServicio = binding.costeServicio.text.toString().toDouble()
        val porcentaje = when(binding.grupoBotones.checkedRadioButtonId){
            R.id.PrimerBoton -> 0.20
            R.id.SegundoBoton -> 0.18
            else -> 0.15
        }

        var propina = porcentaje*costeServicio
        if(binding.redondear.isChecked) {
            propina = kotlin.math.ceil(propina)
        }
        binding.propina.text = getString(R.string.propina_resultante,
            getCurrencyInstance().format(propina))


    }
}