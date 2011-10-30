package michael.com;

import java.math.BigDecimal;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends Activity {
	
	Bundle bundle;
	TextView tv;
	static final int SHOW_DATA = 0;
	static final int CHANGE_STYLE = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultlayout);
		tv = (TextView)findViewById(R.id.textView1);
		
		
	    bundle = this.getIntent().getExtras(); 
	  
		BigDecimal height = BigDecimal.valueOf(Double.parseDouble(bundle.getString("height"))).divide(BigDecimal.valueOf(100));
		BigDecimal weight = BigDecimal.valueOf(Double.parseDouble(bundle.getString("weight")));
		BigDecimal bmi = weight.divide((height.multiply(height)),4,BigDecimal.ROUND_HALF_UP);
		
	
		tv.setText("你的BMI值是"+bmi.toString());
		
		
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
            	

            	//Intent intent = new Intent(); 
            	//intent.setClass(Result.this,MPPHW2Activity.class); 
            	//intent.putExtras(bundle);
                Result.this.finish();      
            	//startActivity(intent);
            	
            	
                // Perform action on click
            }
        });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
    	boolean result = super.onCreateOptionsMenu(menu);
    	menu.add(0, SHOW_DATA, 0, R.string.result_showData);
    	menu.add(0, CHANGE_STYLE, 0, R.string.result_changeStyle);
    	
    	
    	
        return result;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {
		
        case SHOW_DATA:
        	String show="身高:"+bundle.getString("height")+"(cm) 體重："+bundle.getString("weight")+ "(kg)";
        	bundle.getInt("height");
        	Toast.makeText(this,show, Toast.LENGTH_LONG).show();
        	return super.onMenuItemSelected(featureId, item);
        case CHANGE_STYLE:
        
        	tv.setTextColor(Color.RED);
        	tv.setTextSize(55);
        	
        	return super.onMenuItemSelected(featureId, item);
        default:
        	return super.onMenuItemSelected(featureId, item);
        }
		
		
	}

	
	
}
