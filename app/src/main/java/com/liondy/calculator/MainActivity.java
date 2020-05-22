package com.liondy.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_tambah,btn_kurang,btn_kali,btn_bagi,btn_koma,btn_calc,btn_reset;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtHasil = (TextView) findViewById(R.id.txtHasil);
        this.btn_0 = (Button) findViewById(R.id.btn_0);
        this.btn_1 = (Button) findViewById(R.id.btn_1);
        this.btn_2 = (Button) findViewById(R.id.btn_2);
        this.btn_3 = (Button) findViewById(R.id.btn_3);
        this.btn_4 = (Button) findViewById(R.id.btn_4);
        this.btn_5 = (Button) findViewById(R.id.btn_5);
        this.btn_6 = (Button) findViewById(R.id.btn_6);
        this.btn_7 = (Button) findViewById(R.id.btn_7);
        this.btn_8 = (Button) findViewById(R.id.btn_8);
        this.btn_9 = (Button) findViewById(R.id.btn_9);
        this.btn_tambah = (Button) findViewById(R.id.btn_Add);
        this.btn_kurang = (Button) findViewById(R.id.btn_Sub);
        this.btn_kali = (Button) findViewById(R.id.btn_Mul);
        this.btn_bagi = (Button) findViewById(R.id.btn_Div);
        this.btn_calc = (Button) findViewById(R.id.btn_calc);
        this.btn_reset = (Button) findViewById(R.id.btn_reset);

        this.btn_0.setOnClickListener(this);
        this.btn_1.setOnClickListener(this);
        this.btn_2.setOnClickListener(this);
        this.btn_3.setOnClickListener(this);
        this.btn_4.setOnClickListener(this);
        this.btn_5.setOnClickListener(this);
        this.btn_6.setOnClickListener(this);
        this.btn_7.setOnClickListener(this);
        this.btn_8.setOnClickListener(this);
        this.btn_9.setOnClickListener(this);
        this.btn_tambah.setOnClickListener(this);
        this.btn_kurang.setOnClickListener(this);
        this.btn_kali.setOnClickListener(this);
        this.btn_bagi.setOnClickListener(this);
        this.btn_calc.setOnClickListener(this);
        this.btn_reset.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        String text = "";
        if(v.getId()==this.btn_0.getId()) text = "0";
        else if(v.getId()==this.btn_1.getId()) text = "1";
        else if(v.getId()==this.btn_2.getId()) text = "2";
        else if(v.getId()==this.btn_3.getId()) text = "3";
        else if(v.getId()==this.btn_4.getId()) text = "4";
        else if(v.getId()==this.btn_5.getId()) text = "5";
        else if(v.getId()==this.btn_6.getId()) text = "6";
        else if(v.getId()==this.btn_7.getId()) text = "7";
        else if(v.getId()==this.btn_8.getId()) text = "8";
        else if(v.getId()==this.btn_9.getId()) text = "9";
        else if(v.getId()==this.btn_tambah.getId()) text = "+";
        else if(v.getId()==this.btn_kurang.getId()) text = "-";
        else if(v.getId()==this.btn_kali.getId()) text = "*";
        else if(v.getId()==this.btn_bagi.getId()) text = "/";
        else if(v.getId()==this.btn_reset.getId()) this.txtHasil.setText("");
        else if(v.getId()==this.btn_calc.getId() && !this.txtHasil.getText().equals("")) calculate(this.txtHasil.getText().toString());
        if(this.txtHasil.getText().equals("0")){
            if(!text.equals("+") && !text.equals("-") && !text.equals("*") && !text.equals("/")) this.txtHasil.setText(text);
        }
        else this.txtHasil.setText(this.txtHasil.getText() + text);
    }

    public void calculate(String exp){
        if(exp.charAt(exp.length()-1)=='.'){
            exp = exp.substring(0,exp.length()-1);
        }
        Postfix postfix = new Postfix();
        int hasil = postfix.calculate(exp);
        this.txtHasil.setText(String.valueOf(hasil));
    }
}
