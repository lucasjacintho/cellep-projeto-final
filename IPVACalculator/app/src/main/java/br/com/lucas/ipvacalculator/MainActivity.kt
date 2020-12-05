package br.com.lucas.ipvacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listEstados = mapOf("Selecione o Estado" to 0.0, "Santa Catarina" to 2.0,"Rio Grande do Sul" to 3.0,
        "Paraná" to 3.5,"Espírito Santo" to 2.0, "São Paulo" to 3.0,"Rio de Janeiro" to 4.0,"Minas Gerais" to 4.0,"Sergipe" to 2.0,
        "Paraíba" to 2.0,"Alagoas" to 2.5,"Pernambuco" to 2.5,"Rio Grande do Norte" to 2.5,"Ceará" to 2.5,"Piauí" to 2.5,"Maranhão" to 2.5,
        "Bahia" to 2.5,"Acre" to 2.0,"Tocantins" to 2.0,"Pará" to 2.5,"Amapá" to 3.0,"Amazonas" to 3.0,"Roraima" to 3.0,"Rondônia" to 3.0,
        "Mato Grosso do Sul" to 2.5,"Goiás" to 2.5,"Mato Grosso" to 3.0,"Distrito Federal" to 3.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val estadosAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listEstados.keys.toTypedArray()
        )

        spnValorAliquota.adapter = estadosAdapter;

        btnCalcular.setOnClickListener{
            calcularIPVA(spnValorAliquota.selectedItem.toString())
        }
    }

//    R$ 30.000 X 3= 90.000 ÷ 100 = 900

    fun calcularIPVA(estado: String){
        val aliquote = listEstados.getValue(estado)
        val valorAutomovel = edtValorAutomovel.text.toString().toDouble()
        val calculoFinal:Double =  (valorAutomovel * aliquote) / 100

        txtValorFinal.text = "R$ " + calculoFinal.toString()
    }
}