package com.prueba.primerproyecto;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.prueba.primerproyecto.utils.FormatUtils;

public class PrimerActivity extends ActionBarActivity {

	private Double previusNumber;
	
	private Double partialResult;
	
	private int operation;
	
	private boolean hasResult = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_primer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.primer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void displayNumberAction(View view){
		if(hasResult){
			setDisplayText("");
			hasResult = false;
		}
		TextView element = (TextView) view;
		setDisplayText(String.valueOf(getDisplay().getText()).concat(String.valueOf(element.getText())));
	}
	
	public void clearAction(View view){
		clear();
		clearOperation();
	}	
	
	public void operationAction(View view){
		operation = view.getId();
		previusNumber = FormatUtils.parseDouble(getDisplay().getText());
		clear();
	}
	
	public void operationRaizAction(View view){
		Double nro = FormatUtils.parseDouble(getDisplay().getText());
		if(nro >= 0){
			Double result = Math.sqrt(nro);
			DecimalFormat df = new DecimalFormat("#.####");
			setDisplayText(String.valueOf(df.format(result)));
		}
	}
	
	public void resultAction(View view){
		switch (operation) {
			case R.string.sum: partialResult = previusNumber + FormatUtils.parseDouble(getDisplay().getText());  break;
			case R.string.substraction: partialResult = previusNumber - FormatUtils.parseDouble(getDisplay().getText()); break;
			case R.string.multiplication: partialResult = previusNumber * FormatUtils.parseDouble(getDisplay().getText()); break;
			case R.string.division:partialResult = previusNumber / FormatUtils.parseDouble(getDisplay().getText()); break;
		}
		setDisplayText(String.valueOf(partialResult));
		hasResult = true;
	}
	private void clear(){
		getDisplay().setText(FormatUtils.EMPTY_STRING);
	}
	
	private TextView getDisplay(){
		return (TextView)findViewById(R.string.displayTextView);
	}
	private void setDisplayText(CharSequence sequence){
		getDisplay().setText(sequence);
	}
	private void clearOperation(){
		operation = 0;
	}
	public void specialOperations(View view){
		switch(view.getId()){
		case R.string.sqrt:setDisplayText(String.valueOf(Math.sqrt(FormatUtils.parseDouble(getDisplay().getText()))));
		}
	}
}
