package com.example.simplecalculatorv1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	float op;// register for 1st operand..and first git commit
	boolean start_state_0 = true;// start state equal to 0
	float sum = 0;// sum accumulator;
	int op_type = 0;// 0-not assigned;1-add;2-sub
	float prod = 1;// product accumulator
	int sub_cnt = 0;
	int div_cnt = 0;
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	Button btn0;
	Button btnAdd;
	Button btnSub;
	Button btnProd;
	Button btnClear;
	Button btnApply;
	Button btnDiv;
	Button btnDot;
	
	EditText edResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);
		btn6 = (Button) findViewById(R.id.btn6);
		btn7 = (Button) findViewById(R.id.btn7);
		btn8 = (Button) findViewById(R.id.btn8);
		btn9 = (Button) findViewById(R.id.btn9);
		btn0 = (Button) findViewById(R.id.btn0);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnSub = (Button) findViewById(R.id.btnSub);
		btnProd = (Button) findViewById(R.id.btnProd);
		btnDiv = (Button) findViewById(R.id.btnDiv);
		btnClear = (Button) findViewById(R.id.btnClear);
		btnApply = (Button) findViewById(R.id.btnApply);
		btnDot = (Button) findViewById(R.id.btnDot);
		edResult = (EditText) findViewById(R.id.edResult);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btn0.setOnClickListener(this);

		btnAdd.setOnClickListener(this);
		btnSub.setOnClickListener(this);
		btnProd.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
		btnDot.setOnClickListener(this);
		btnClear.setOnClickListener(this);
		btnApply.setOnClickListener(this);
	}

    // создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      // TODO Auto-generated method stub
      // добавляем пункты меню
    	getMenuInflater().inflate(R.menu.main_menu, menu);

      return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    	AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
	      alertDialog.setTitle("Quit?");
	     
	      alertDialog.setMessage("Do you really want to quit?");
	  
	      alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	          public void onClick(DialogInterface dialog,int which) {
	           Intent intent = new Intent(Intent.ACTION_MAIN);
	              intent.addCategory(Intent.CATEGORY_HOME);
	              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	              startActivity(intent);
	          }
	      });
	  
	      alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
	          public void onClick(DialogInterface dialog, int which) {
	              dialog.cancel();
	          }
	      });

	      alertDialog.show();      
      return super.onOptionsItemSelected(item);
    }
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnDot:
			// кнопка .
			if (!start_state_0) {
				edResult.setText(edResult.getText() + ".");
			} else {
				edResult.setText(".");
				start_state_0 = false;
			}		
			break;
		case R.id.btnDiv:
			// нажата кнопка Разделить
			op_type = 4;
			op = Float.parseFloat(edResult.getText().toString());
			if (div_cnt == 0){
				prod = op / prod;				
			}
			else {
				prod = prod / op;
			}

			if (!start_state_0) {
				edResult.setText(Float.toString(prod));
			}
			div_cnt = div_cnt + 1;
			start_state_0 = true;
			break;
		case R.id.btnProd:
			// нажата кнопка Умножить
			op_type = 3;
			op = Float.parseFloat(edResult.getText().toString());
			prod = prod * op;
			if (!start_state_0) {
				edResult.setText(Float.toString(prod));
			}
			start_state_0 = true;
			break;
		case R.id.btnAdd:
			// нажата кнопка Сложить
			op_type = 1;
			op = Float.parseFloat(edResult.getText().toString());
			sum = sum + op;
			if (!start_state_0) {
				edResult.setText(Float.toString(sum));
			}
			start_state_0 = true;
			break;
		case R.id.btnSub:
			// нажата кнопка Вычесть
			op_type = 2;
			op = Float.parseFloat(edResult.getText().toString());
			if (sub_cnt == 0){
				sum = op - sum;
			}
			else{
				sum = sum - op;
			}
			if (!start_state_0) {
				edResult.setText(Float.toString(sum));
			}
			sub_cnt = sub_cnt + 1;
			start_state_0 = true;
			break;
		case R.id.btnApply:
			// Сложить
			if (op_type == 1) {
				sum = /*op*/sum + Float.parseFloat(edResult.getText().toString());
				edResult.setText(Float.toString(sum));
				sum = 0;
			}
			;
			// Вычесть
			if (op_type == 2) {
				sum = sum - Float.parseFloat(edResult.getText().toString());
				edResult.setText(Float.toString(sum));
				sum = 0;
			}
			// Умножить
			if (op_type == 3) {
				prod = prod * Float.parseFloat(edResult.getText().toString());
				edResult.setText(Float.toString(prod));
				prod = 1;
			}
			// Разделить
			if (op_type == 4) {
				prod = op / Float.parseFloat(edResult.getText().toString());
				edResult.setText(Float.toString(prod));
				prod = 1;
			}
			op = 0;
			start_state_0 = true;
			break;
		case R.id.btnClear:
			// кнопка Очистить
			edResult.setText("0");
			sum = 0;
			op = 0;
			prod = 1;
			sub_cnt = 0;
			div_cnt = 0;
			start_state_0 = true;
			break;
		case R.id.btn1:
			// кнопка 1
			if (!start_state_0) {
				edResult.setText(edResult.getText() + "1");
			} else {
				edResult.setText("1");
				start_state_0 = false;
			}
			break;
		case R.id.btn2:
			// кнопка 2
			if (!start_state_0) {
				edResult.setText(edResult.getText() + "2");
			} else {
				edResult.setText("2");
				start_state_0 = false;
			}
			break;
		case R.id.btn3:
			// кнопка 3
			if (!start_state_0) {
				edResult.setText(edResult.getText() + "3");
			} else {
				edResult.setText("3");
				start_state_0 = false;
			}
			break;
		case R.id.btn4:
			// кнопка 4
			if (!start_state_0) {
				edResult.setText(edResult.getText() + "4");
			} else {
				edResult.setText("4");
				start_state_0 = false;
			}
			break;
		case R.id.btn5:
			// кнопка 5
			if (!start_state_0) {
				edResult.setText(edResult.getText() + "5");
			} else {
				edResult.setText("5");
				start_state_0 = false;
			}
			break;
		case R.id.btn6:
			// кнопка 6
			if (!start_state_0) {
				edResult.setText(edResult.getText() + "6");
			} else {
				edResult.setText("6");
				start_state_0 = false;
			}
			break;
		case R.id.btn7:
			// кнопка 7
			if (!start_state_0) {
				edResult.setText(edResult.getText() + "7");
			} else {
				edResult.setText("7");
				start_state_0 = false;
			}
			break;
		case R.id.btn8:
			// кнопка 8
			if (!start_state_0) {
				edResult.setText(edResult.getText() + "8");
			} else {
				edResult.setText("8");
				start_state_0 = false;
			}
			break;
		case R.id.btn9:
			// кнопка 9
			if (!start_state_0) {
				edResult.setText(edResult.getText() + "9");
			} else {
				edResult.setText("9");
				start_state_0 = false;
			}
			break;
		case R.id.btn0:
			// кнопка 0
			if (!start_state_0) {
				edResult.setText(edResult.getText() + "0");
			} else {
				edResult.setText("0");
				start_state_0 = false;
			}
			break;
		}
	}
}
