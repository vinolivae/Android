package com.vin.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Float.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var calcular = btn_calcular
        var deletar = icon_delete

        calcular.setOnClickListener{
            var peso = edit_peso.text.toString()
            var altura = edit_altura.text.toString()
            if(peso.isEmpty()){
                view_resultado.setText("Insira seu peso")
            }
            else if(altura.isEmpty()){
                view_resultado.setText("Insira sua altura")
            }
            else{
                calcIMC()
            }
        }
        deletar.setOnTouchListener { v, event ->
            if(event.action == MotionEvent.ACTION_DOWN){
                deleteValuesOfFields()
            }
            false
        }

    }
    fun calcIMC(){
        var peso = Integer.parseInt(edit_peso.text.toString())
        var altura = parseFloat(edit_altura.text.toString())
        var resultado = view_resultado
        val imc = peso / (altura * altura)

        val _mensagem = when {
            imc <= 18.5 -> "Abaixo do peso"
            imc <= 24.9 -> "Peso normal"
            imc <= 29.9 -> "Sobrepeso"
            imc <= 34.9 -> "Obesidade (grau 1)"
            imc <= 39.9 -> "Obesidade (grau 2)"
            else -> "Obsedidade Mórbida (grau 3)"
        }
        resultado.text = "IMC: ${imc.toString()}\n$_mensagem"
    }
    fun deleteValuesOfFields(){
        edit_peso.setText("")
        edit_altura.setText("")
        view_resultado.setText("")
    }
}