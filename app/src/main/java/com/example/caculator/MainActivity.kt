package com.example.caculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {
    private val cvShow: CardView by lazy { findViewById<CardView>(R.id.cvShow) }
    private val tvShow: TextView by lazy { findViewById<TextView>(R.id.tvShow) }
    private val btnDel: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnDel) }
    private val btnDiv: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnDiv) }
    private val btnSeven: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnSeven) }
    private val btnEight: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnEight) }
    private val btnNine: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnNine) }
    private val btnMulti: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnMulti) }
    private val btnFour: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnFour) }
    private val btnFive: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnFive) }
    private val btnSix: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnSix) }
    private val btnDe: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnDe) }
    private val btnOne: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnOne) }
    private val btnTwo: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnTwo) }
    private val btnThree: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnThree) }
    private val btnPlus: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnPlus) }
    private val btnZero: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnZero) }
    private val btnPer: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnPer) }
    private val btnEqual: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnEqual) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val deg = btnPer.getRotation() + 180F;
        btnPer.animate().rotation(deg).setInterpolator(AccelerateDecelerateInterpolator())
        btnZero.setOnClickListener(View.OnClickListener {

            setNumber(Integer.parseInt(btnZero.text as String));
        })
        btnTwo.setOnClickListener(View.OnClickListener {
            setNumber(Integer.parseInt(btnTwo.text as String));
        })
        btnThree.setOnClickListener(View.OnClickListener {
            setNumber(Integer.parseInt(btnThree.text as String));
        })
        btnFour.setOnClickListener(View.OnClickListener {
            setNumber(Integer.parseInt(btnFour.text as String));
        })
        btnFive.setOnClickListener(View.OnClickListener {
            setNumber(Integer.parseInt(btnFive.text as String));
        })
        btnSix.setOnClickListener(View.OnClickListener {
            setNumber(Integer.parseInt(btnSix.text as String));
        })
        btnSeven.setOnClickListener(View.OnClickListener {
            setNumber(Integer.parseInt(btnSeven.text as String));
        })
        btnEight.setOnClickListener(View.OnClickListener {
            setNumber(Integer.parseInt(btnEight.text as String));
        })
        btnNine.setOnClickListener(View.OnClickListener {
            setNumber(Integer.parseInt(btnNine.text as String));
        })
        btnOne.setOnClickListener(View.OnClickListener {
            setNumber(Integer.parseInt(btnOne.text as String));
        })

        btnDel.setOnClickListener(View.OnClickListener {
            calculate("C");
        })

        btnPlus.setOnClickListener(View.OnClickListener {
            calculate("+");
        })

        btnDiv.setOnClickListener(View.OnClickListener {
            calculate("÷");
        })

        btnPer.setOnClickListener(View.OnClickListener {
            calculate(".");
            val mTxt =  tvShow.text;
            if (mTxt.length>=2){
                tvShow.text = mTxt.substring(0 until mTxt.length-1)
            }else{
                tvShow.text = ""
            }
        })
        btnMulti.setOnClickListener(View.OnClickListener {
            calculate("x");
        })
        btnDe.setOnClickListener(View.OnClickListener {
            calculate("-");
        })
        btnEqual.setOnClickListener(View.OnClickListener {
            equalOfQuestion()
        })

    }

    private fun setNumber(number: Int) {
        var mNumber: String = "$number";
        if (tvShow.text!=null){
            var text = tvShow.text;
            tvShow.text = "$text$number";
        }else{
            tvShow.text = "$mNumber";
        }
    }
    private fun calculate(method: String) {

        if (method.equals("C",true)){
            var text = tvShow.text as String;
            tvShow.text = ""
        }
        if (tvShow.text!=null && tvShow.text.length>=2){

            val lastText: String = tvShow.text.substring(tvShow.text.length-2 until tvShow.length()-1);
            if (lastText.equals("+",true)||lastText.equals("-",true)||lastText.equals("x",true)||lastText.equals("÷",true)){

            }else{
                if (method.equals("-",true)){
                    val text = tvShow.text as String;
                    tvShow.text = "$text$method"
                }
                if (method.equals("x",true)){
                    val text = tvShow.text as String;
                    tvShow.text = "$text$method"
                }
                if (method.equals("÷",true)){
                    val text = tvShow.text as String;
                    tvShow.text = "$text$method"
                }
                if (method.equals("+",true)){
                    val text = tvShow.text as String;
                    tvShow.text = "$text$method"
                }
            }
        }else{
            if (method.equals("-",true)){
                val text = tvShow.text as String;
                tvShow.text = "$text$method"
            }
            if (method.equals("x",true)){
                val text = tvShow.text as String;
                tvShow.text = "$text$method"
            }
            if (method.equals("÷",true)){
                val text = tvShow.text as String;
                tvShow.text = "$text$method"
            }
            if (method.equals("+",true)){
                val text = tvShow.text as String;
                tvShow.text = "$text$method"
            }
        }
    }

    private fun equalOfQuestion(){
        var text = tvShow.text;
        val a: Int ;
        val b: Int ;
        val result : Int;
        if (text.contains("+")){
            val mCal: Int = text.indexOf("+").toInt();
            a = text.substring(0 until mCal).toInt();
            b = text.substring(mCal+1 until text.length).toInt();
            result = a + b;
            tvShow.text = "$result"
        }else if (text.contains("-")){
            val mCal: Int = text.indexOf("-").toInt();
            a = text.substring(0 until mCal).toInt();
            b = text.substring(mCal+1 until text.length).toInt();
            result = a - b;
            tvShow.text = "$result"
        }else if (text.contains("x")){
            val mCal: Int = text.indexOf("x").toInt();
            a = text.substring(0 until mCal).toInt();
            b = text.substring(mCal+1 until text.length).toInt();
            result = a * b;
            tvShow.text = "$result"
        }else if (text.contains("÷")){
            val length = "÷".length
            Log.e("length","$length")
            val mCal: Int = text.indexOf("÷").toInt();
            a = text.substring(0 until mCal).toInt();
            b = text.substring(mCal+1 until text.length).toInt();
            result = a / b;
            tvShow.text = "$result"
        }
    }

}