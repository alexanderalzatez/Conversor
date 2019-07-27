package com.example.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.String

class MainActivity : AppCompatActivity() {

    private var de=""
    private var a=""
    private var conversion=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var moneda = arrayOf("Dolar","Euro","COP")
        spnDe.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,moneda)
        spnA.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,moneda)

        spnDe.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                de = "Seleccione opción"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                de = moneda[p2]
                when(de){
                    "Dolar" -> imgDe.setImageResource(R.drawable.estadosunidos)
                    "Euro" -> imgDe.setImageResource(R.drawable.unioneuropea)
                    "COP" -> imgDe.setImageResource(R.drawable.colombia)
                }
                tvResultado.text = "Convertir de " + de + " a " + a
            }

        }
        spnA.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                a = "Seleccione opción"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                a = moneda[p2]
                when(a){
                    "Dolar" -> imgA.setImageResource(R.drawable.estadosunidos)
                    "Euro" -> imgA.setImageResource(R.drawable.unioneuropea)
                    "COP" -> imgA.setImageResource(R.drawable.colombia)
                }
                tvResultado.text = "Convertir de " + de + " a " + a
            }

        }
        bnCalcular.setOnClickListener {
            var doleur = 0.90
            var eurcop = 3571.57
            var dolcop = 3205.30
            var moneda2 = ""

            try {


                if (de == "Dolar" && a == "Euro") {
                    conversion = (etValor.text.toString().toDouble() * doleur)
                    moneda2 = "Euros"
                    tvConversion.text = String.format("%.2f", conversion) + " " + moneda2
                } else
                    if (de == "Euro" && a == "Dolar") {
                        conversion = (etValor.text.toString().toDouble() / doleur)
                        moneda2 = "Dolares"
                        tvConversion.text = String.format("%.2f", conversion) + " " + moneda2
                    } else
                        if (de == "COP" && a == "Dolar") {
                            conversion = (etValor.text.toString().toDouble() / dolcop)
                            moneda2 = "Dolares"
                            tvConversion.text = String.format("%.2f", conversion) + " " + moneda2
                        } else
                            if (de == "Dolar" && a == "COP") {
                                conversion = (etValor.text.toString().toDouble() * dolcop)
                                moneda2 = "COP"
                                tvConversion.text = String.format("%.2f", conversion) + " " + moneda2
                            } else
                                if (de == "Euro" && a == "COP") {
                                    conversion = (etValor.text.toString().toDouble() * eurcop)
                                    moneda2 = "COP"
                                    tvConversion.text = String.format("%.2f", conversion) + " " + moneda2
                                } else
                                    if (de == "COP" && a == "Euro") {
                                        conversion = (etValor.text.toString().toDouble() / eurcop)
                                        moneda2 = "Euros"
                                        tvConversion.text = String.format("%.2f", conversion) + " " + moneda2
                                    }
            }catch (e:Exception){
                Log.d("Exception", "message : " + e.message)
                Toast.makeText(this, "Ingresa el valor a convertir", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
