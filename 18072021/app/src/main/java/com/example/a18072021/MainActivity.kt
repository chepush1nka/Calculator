package com.example.a18072021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dot.setOnClickListener{ setTextFields(".")}
        zero.setOnClickListener{ setTextFields("0")}
        one.setOnClickListener{ setTextFields("1")}
        two.setOnClickListener{ setTextFields("2")}
        three.setOnClickListener{ setTextFields("3")}
        four.setOnClickListener{ setTextFields("4")}
        five.setOnClickListener{ setTextFields("5")}
        six.setOnClickListener{ setTextFields("6")}
        seven.setOnClickListener{ setTextFields("7")}
        eight.setOnClickListener{ setTextFields("8")}
        nine.setOnClickListener{ setTextFields("9")}
        dev.setOnClickListener{ setTextFields("-")}
        plus.setOnClickListener{ setTextFields("+")}
        multiply.setOnClickListener{ setTextFields("*")}
        div.setOnClickListener{ setTextFields("/")}
        _thing.setOnClickListener{ setTextFields("(")}
        thing_.setOnClickListener{ setTextFields(")")}
        ac.setOnClickListener{
            math_operation.text = ""
            result_text.text = ""
        }
        back.setOnClickListener{
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                math_operation.text = str.substring(0, str.length-1)
            result_text.text = ""
        }
        equal.setOnClickListener{
            try{
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            }catch(e:Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }

    }

    fun setTextFields(str: String){
        if(result_text.text!=""){
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }

}