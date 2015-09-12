package com.homework9.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener{

	TextView addressError,cityError,stateError,invalidInput;
	String states [] ={"Choose State","AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI",
			           "MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT",
			           "VT","VA","WA","WV","WI","WY"};
	Spinner stateDropDownList;
	Button searchButton;
	EditText address,city;
	String state;
	int count;
	boolean notNull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addressError = (TextView) findViewById(R.id.address_error_tv);
        cityError = (TextView) findViewById(R.id.city_error_tv);
        stateError = (TextView) findViewById(R.id.state_error_tv);
        invalidInput = (TextView) findViewById(R.id.invalidInput_tv);
        address = (EditText) findViewById(R.id.et_address);
        city = (EditText) findViewById(R.id.et_city);
        searchButton = (Button) findViewById(R.id.b_text_searchBtn);

        
        stateDropDownList = (Spinner) findViewById(R.id.state_names_spinner);
        ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, states);
        adapter_state.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        stateDropDownList.setAdapter(adapter_state);
        stateDropDownList.setOnItemSelectedListener(this);
        
        searchButton.setOnClickListener(new View.OnClickListener() {			
			@SuppressLint("NewApi") @Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count=0;
				notNull=true;
				invalidInput.setText("");
				cityError.setText("");
				addressError.setText("");
				stateError.setText("");
				if(address.getText().toString().contentEquals("2636 Menlo Ave")){
					count++;
				}else if(address.getText().toString().isEmpty()){
					addressError.setText("This field is required"); notNull=false;
				}
				
				if(city.getText().toString().contentEquals("Los Angeles")){
					count++;
				}else if(city.getText().toString().isEmpty()){
					cityError.setText("This field is required"); notNull=false;
				}
				if(state.contentEquals("CA")){
					count++;
				}else if(state.isEmpty()){	        
			        stateError.setText("This field is required"); notNull=false;
				}
				if(count == 3){
					Toast.makeText(getApplicationContext(), "Success!!!",Toast.LENGTH_LONG).show();
				}else if(notNull== true){
					invalidInput.setText("No exact match found -- Verify that the given address is correct.");
				}
			}
		});
        }
    
    
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,long id) {
		// TODO Auto-generated method stub
		if(position>0){
			stateDropDownList.setSelection(position);
			state = stateDropDownList.getSelectedItem().toString();
		}else{
			state = "";
		}
		  
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
