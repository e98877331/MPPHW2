package michael.com;

import java.math.BigDecimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends Activity {
	
	Bundle bundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultlayout);
		TextView tv = (TextView)findViewById(R.id.textView1);
		
		
	    bundle = this.getIntent().getExtras(); 
	  
		BigDecimal height = BigDecimal.valueOf((double)bundle.getInt("height")).divide(BigDecimal.valueOf(100));
		BigDecimal weight = BigDecimal.valueOf((double)bundle.getInt("weight"));
		BigDecimal bmi = weight.divide((height.multiply(height)),4,BigDecimal.ROUND_HALF_UP);
		
	
		tv.setText(bmi.toString());
		
		
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
            	

            	Intent intent = new Intent(); 
            	intent.setClass(Result.this,MPPHW2Activity.class); 
            	intent.putExtras(bundle); 
            	startActivity(intent);
            	
            	
                // Perform action on click
            }
        });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		return super.onMenuItemSelected(featureId, item);
	}

	
	
}
