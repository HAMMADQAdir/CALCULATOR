package com.example.new_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.Allclear
import kotlinx.android.synthetic.main.activity_main.backspace
import kotlinx.android.synthetic.main.activity_main.devide
import kotlinx.android.synthetic.main.activity_main.dot
import kotlinx.android.synthetic.main.activity_main.equal
import kotlinx.android.synthetic.main.activity_main.minus
import kotlinx.android.synthetic.main.activity_main.multiply
import kotlinx.android.synthetic.main.activity_main.num1
import kotlinx.android.synthetic.main.activity_main.num2
import kotlinx.android.synthetic.main.activity_main.num3
import kotlinx.android.synthetic.main.activity_main.num4
import kotlinx.android.synthetic.main.activity_main.num5
import kotlinx.android.synthetic.main.activity_main.num6
import kotlinx.android.synthetic.main.activity_main.num7
import kotlinx.android.synthetic.main.activity_main.num8
import kotlinx.android.synthetic.main.activity_main.num9
import kotlinx.android.synthetic.main.activity_main.output
import kotlinx.android.synthetic.main.activity_main.plus
import kotlinx.android.synthetic.main.activity_main.textinPuT
import kotlinx.android.synthetic.main.activity_main.zero
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        backspace.setOnClickListener {
            textinPuT.text = textinPuT.text.subSequence(0, textinPuT.length() - 1)
        }
        Allclear.setOnClickListener {
            textinPuT.text = ""
            output.text=""
        }
        num1.setOnClickListener {
            textinPuT.text = addtoinput("1")
        }
        num2.setOnClickListener {
            textinPuT.text = addtoinput("2")
        }
        num3.setOnClickListener {
            textinPuT.text = addtoinput("3")
        }
        num4.setOnClickListener {
            textinPuT.text = addtoinput("4")
        }
        num5.setOnClickListener {
            textinPuT.text = addtoinput("5")
        }
        num6.setOnClickListener {
            textinPuT.text = addtoinput("6")
        }
        num7.setOnClickListener {
            textinPuT.text = addtoinput("7")
        }
        num8.setOnClickListener {
            textinPuT.text = addtoinput("8")
        }
        num9.setOnClickListener {
            textinPuT.text = addtoinput("9")
        }
        devide.setOnClickListener {
            textinPuT.text = addtoinput("/")
        }
        multiply.setOnClickListener {
            textinPuT.text = addtoinput("*")
        }
        minus.setOnClickListener {
            textinPuT.text = addtoinput("-")
        }
        plus.setOnClickListener {
            textinPuT.text = addtoinput("+")
        }
        dot.setOnClickListener {
            textinPuT.text = addtoinput(".")

        }
        zero.setOnClickListener {
            textinPuT.text = addtoinput("0")

        }
        equal.setOnClickListener {
            showResult()
        }
    }
    private fun addtoinput(buttonValue: String) :String {
        return "${textinPuT.text}$buttonValue"
    }
    private fun showResult() {
        try {
            val expression = textinPuT.text.toString()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {

                output.text = "Error"

            } else {

                output.text = DecimalFormat("0.#####").format(result).toString()

            }
        } catch (e: Exception) {

            output.text = "Error"

        }
    }
}
