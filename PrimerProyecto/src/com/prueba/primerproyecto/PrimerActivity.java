package com.prueba.primerproyecto;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
	private boolean doCalculate = true; //indica si debe calcular o no
	private DecimalFormat df;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_primer);
		df = new DecimalFormat("#.######");
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
			setDisplayText("0");
			hasResult = false;
		}
		TextView element = (TextView) view;
		
		//si ingresamos un digito y en el display dice solamente 0, reemplazamos 0 por el nro que ingresamos
		if(getDisplay().getText().equals("0")) 
			if(String.valueOf(element.getText()).equals("."))
				setDisplayText(String.valueOf(getDisplay().getText()).concat(String.valueOf(element.getText())));
			else
				setDisplayText(String.valueOf(element.getText()));
		else{
			if(String.valueOf(element.getText()).equals(".")){
				if(getDisplay().getText().toString().indexOf(".") == -1)
					setDisplayText(String.valueOf(getDisplay().getText()).concat(String.valueOf(element.getText())));
			}
			else setDisplayText(String.valueOf(getDisplay().getText()).concat(String.valueOf(element.getText())));
		}
	}
	
	public void clearAction(View view){
		clear();
		clearOperation();
	}	
	
	public void operationAction(View view){
		operation = view.getId();
		previusNumber = FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.'));
		doCalculate = true;
		clear();
	}
	
	public void operationSenoAction(View view){
		partialResult = Math.sin(FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.')));
		
		if(partialResult > 1000000000){
			NumberFormat formatter = new DecimalFormat("0.###E0");
			setDisplayText(String.valueOf(formatter.format(partialResult)));
		}
		else{
			setDisplayText(String.valueOf(df.format(partialResult)));
		}
		hasResult = true;
		doCalculate = false;
	}
	
	public void operationDivXAction(View view){
		partialResult = 1 / FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.'));
		
		if(partialResult > 1000000000){
			NumberFormat formatter = new DecimalFormat("0.###E0");
			setDisplayText(String.valueOf(formatter.format(partialResult)));
		}
		else{
			setDisplayText(String.valueOf(df.format(partialResult)));
		}
		hasResult = true;
		doCalculate = false;
	}
	
	public void operationCosenoAction(View view){
		partialResult = Math.cos(FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.')));
		
		if(partialResult > 1000000000){
			NumberFormat formatter = new DecimalFormat("0.###E0");
			setDisplayText(String.valueOf(formatter.format(partialResult)));
		}
		else{
			setDisplayText(String.valueOf(df.format(partialResult)));
		}
		hasResult = true;
		doCalculate = false;
	}
	
	public void operationCuadradoAction(View view){
		partialResult = FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.')) 
							* FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.'));
		
		if(partialResult > 1000000000){
			NumberFormat formatter = new DecimalFormat("0.###E0");
			setDisplayText(String.valueOf(formatter.format(partialResult)));
		}
		else{
			setDisplayText(String.valueOf(df.format(partialResult)));
		}
		hasResult = true;
		doCalculate = false;
	}
	
	public void operationTangAction(View view){
		partialResult = Math.tan(FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.')));
		if(partialResult > 1000000000){
			NumberFormat formatter = new DecimalFormat("0.###E0");
			setDisplayText(String.valueOf(formatter.format(partialResult)));
		}
		else{
			setDisplayText(String.valueOf(df.format(partialResult)));
		}
		hasResult = true;
		doCalculate = false;
	}
	
	public void operationRaiz3Action(View view){
		Double nro = FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.'));
		if(nro >= 0){
			Double result = Math.cbrt(nro);
			if(partialResult > 1000000000){
				NumberFormat formatter = new DecimalFormat("0.###E0");
				setDisplayText(String.valueOf(formatter.format(result)));
			}
			else{
				setDisplayText(String.valueOf(df.format(result)));
			}
		}
	}
	
	public void operationLogAction(View view){
		partialResult = Math.log(FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.')));
		if(partialResult > 1000000000){
			NumberFormat formatter = new DecimalFormat("0.###E0");
			setDisplayText(String.valueOf(formatter.format(partialResult)));
		}
		else{
			setDisplayText(String.valueOf(df.format(partialResult)));
		}
		hasResult = true;
		doCalculate = false;
	}
	
	public void operationDiezXAction(View view){
		for(int x=0;x<FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.'));x++){
			if(x==0){ 
				partialResult = (double) (10 * 10);
				x++;
			}
			partialResult *= 10;
		}
		
		if(partialResult > 1000000000){
			NumberFormat formatter = new DecimalFormat("0.###E0");
			setDisplayText(String.valueOf(formatter.format(partialResult)));
		}
		else{
			setDisplayText(String.valueOf(df.format(partialResult)));
		}
		hasResult = true;
		doCalculate = false;
	}
	
	public void operationRaizAction(View view){
		String outString = getDisplay().getText().toString().replace(',', '.');
		Double nro = FormatUtils.parseDouble(outString);
		if(nro >= 0){
			Double result = Math.sqrt(nro);
			
			setDisplayText(String.valueOf(df.format(result)));
		}
	}
	
	public void operationLogDiezAction(View view){
		String outString = getDisplay().getText().toString().replace(',', '.');
		partialResult = Math.log10(FormatUtils.parseDouble(outString));
		
		if(partialResult > 1000000000){
			NumberFormat formatter = new DecimalFormat("0.###E0");
			setDisplayText(String.valueOf(formatter.format(partialResult)));
		}
		else{
			setDisplayText(String.valueOf(df.format(partialResult)));
		}
		hasResult = true;
		doCalculate = false;
	}
	
	public void operationBorrarAction(View view){
		if(getDisplay().getText().length() == 1){
			setDisplayText("0");
		}
		else{
			String outString = getDisplay().getText().toString().substring(0, getDisplay().getText().length()-1);
			setDisplayText(outString);
		}
	}
	
	public void resultAction(View view){
		if(doCalculate){
			switch (operation) {
				case R.string.sum: partialResult = previusNumber + FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.'));  break;
				case R.string.substraction: partialResult = previusNumber - FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.')); break;
				case R.string.multiplication: partialResult = previusNumber * FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.')); break;
				case R.string.division: partialResult = previusNumber / FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.')); break;
				case R.string.expY: partialResult = Math.pow(previusNumber,FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.'))); break;
			}
			
			if(partialResult > 1000000000){
				NumberFormat formatter = new DecimalFormat("0.###E0");
				setDisplayText(String.valueOf(formatter.format(partialResult)));
			}
			else{
				setDisplayText(String.valueOf(df.format(partialResult)));
			}
			hasResult = true;
			doCalculate = false;
		}
	}
	
	private void clear(){
		getDisplay().setText(R.string.numberCero);
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
		case R.string.sqrt:setDisplayText(String.valueOf(Math.sqrt(FormatUtils.parseDouble(getDisplay().getText().toString().replace(',', '.')))));
		}
	}
}
