package com.example.test1;

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.test1.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textReuslt: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0
    var sau_ket_qua=false
    var op2_va_op1=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textReuslt = findViewById(R.id.text_result)

        findViewById<Button>(R.id.btn0).setOnClickListener(this)
        findViewById<Button>(R.id.btn1).setOnClickListener(this)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
        findViewById<Button>(R.id.btn3).setOnClickListener(this)
        findViewById<Button>(R.id.btn4).setOnClickListener(this)
        findViewById<Button>(R.id.btn5).setOnClickListener(this)
        findViewById<Button>(R.id.btn6).setOnClickListener(this)
        findViewById<Button>(R.id.btn7).setOnClickListener(this)
        findViewById<Button>(R.id.btn8).setOnClickListener(this)
        findViewById<Button>(R.id.btn9).setOnClickListener(this)
        findViewById<Button>(R.id.btnAdd).setOnClickListener(this)
        findViewById<Button>(R.id.btnEqual).setOnClickListener(this)
        findViewById<Button>(R.id.btn_tru).setOnClickListener(this)
        findViewById<Button>(R.id.x).setOnClickListener(this)
        findViewById<Button>(R.id.chia).setOnClickListener(this)
        findViewById<Button>(R.id.ce).setOnClickListener(this)
        findViewById<Button>(R.id.c).setOnClickListener(this)
        findViewById<Button>(R.id.bs).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.btn0) {
            addDigit(0)
        } else if (id == R.id.btn1) {
            addDigit(1)
        } else if (id == R.id.btn2) {
            addDigit(2)
        } else if (id == R.id.btn3) {
            addDigit(3)
        }else if (id == R.id.btn4) {
            addDigit(4)
        }else if (id == R.id.btn5) {
            addDigit(5)
        }else if (id == R.id.btn6) {
            addDigit(6)
        }else if (id == R.id.btn8) {
            addDigit(8)
        }else if (id == R.id.btn9) {
            addDigit(9)
        }else if(id==R.id.btn7){
            addDigit(7)
        }else if(id==R.id.ce){
            if(state==1)
                op1 = 0
            else
                op2 = 0
            textReuslt.text = "0"
        }else if(id==R.id.c){
            op1=0
            op2=0
            state=1
            op=0
            sau_ket_qua=false
            op2_va_op1=true
            textReuslt.text = "$op1"
        }else if(id==R.id.bs){
            if(state==1){
                op1 = op1/10
                textReuslt.text = "$op1"
            }
            else{
                op2=op2/10
                textReuslt.text = "$op2"
            }
        }else if (id == R.id.btnAdd) {
            op = 1
            op2=op1
            state = 2
        }else if (id == R.id.btn_tru) {
            op = 2
            op2=op1
            state = 2
        }else if (id == R.id.x) {
            op = 3
            op2=op1
            state = 2
        }else if (id == R.id.chia) {
            op = 4
            op2=op1
            state = 2
        } else if (id == R.id.btnEqual) {
            var result = 0
            if (op == 1) {
                result = op1 + op2
            }else if(op == 2){
                result=op1-op2
            }else if(op==3){
                result = op1 * op2
            }else if(op == 4){
                if(op2 == 0){
                    textReuslt.text="Cannot divide by zero"
                    state=1
                    op=0
                    op1=0
                }
                else
                    result = op1/op2
            }
            if(op!=0) {
                textReuslt.text = "$result"
                state = 1
                op1 = result
                sau_ket_qua=true
                op2_va_op1=true
                op2 = 0
                op = 0
            }
        }

    }

    fun addDigit(c: Int) {
        if (state == 1) {
            if(sau_ket_qua){
                op1 = c
                sau_ket_qua=false
                textReuslt.text = "$op1"
            }else{
                op1 = op1 * 10 + c
                textReuslt.text = "$op1"
            }
        } else {
            if(op2_va_op1){
                op2 = c
                op2_va_op1=false
                textReuslt.text = "$op2"
            }
            else{
                op2 = op2 * 10 + c
                textReuslt.text = "$op2"
            }
        }
    }
}