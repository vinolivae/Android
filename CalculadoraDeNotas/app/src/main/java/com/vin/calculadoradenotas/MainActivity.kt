package com.vin.calculadoradenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val _calcularBtn = calcularbtn


        fun resultadoDoCalculo(media: Int, _faltas: Int) {
            val _resultado = resultado
            if(media >= 6 && _faltas <= 10){
                _resultado.setText("O Aluno foi Aprovado!\n" + "Media Final: ${media}")
                _resultado.setTextColor(Color.GREEN)
            }
            else{
                _resultado.setText("O Aluno foi Reprovado!\n" + "Media Final: ${media}")
                _resultado.setTextColor(Color.RED)
            }
        }

        fun calculoDaNota(){
            val _nota1 = Integer.parseInt(nota1.text.toString())
            val _nota2 = Integer.parseInt(nota2.text.toString())
            val media = (_nota1 + _nota2) / 2

            val _faltas = Integer.parseInt(falta.text.toString())

            resultadoDoCalculo(media, _faltas)
        }

        _calcularBtn.setOnClickListener {calculoDaNota()}
    }
}