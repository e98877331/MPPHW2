package michael.com;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MPPHW2Activity extends Activity {
    /** Called when the activity is first created. */
	static final int menu_lastRecord = 0;
	static final int menu_end =1;
	EditText et1;
	EditText et2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
     
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
            	
            	if(et1.getText().toString().equals("")||et1.getText().toString().equals("0") || et2.getText().toString().equals("") || et2.getText().toString().equals("0"))
                {
            		
            		
                	Toast.makeText(v.getContext(), "輸入錯誤(不可以為空白或0)", Toast.LENGTH_LONG).show();
                	return;
                }
            	int height = Integer.valueOf(et1.getText().toString());
            	int weight = Integer.valueOf(et2.getText().toString());
            	Intent intent = new Intent(); 
            	intent.setClass(MPPHW2Activity.this, Result.class); 
            	Bundle bundle = new Bundle(); 
            	bundle.putInt("height", height);
            	bundle.putInt("weight", weight);
            	intent.putExtras(bundle); 
            	startActivity(intent); //這行一定要放在這函式的最後
            	
            	
                // Perform action on click
            }
        });
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub	
    	boolean result = super.onCreateOptionsMenu(menu);
    	menu.add(0, menu_lastRecord, 0, R.string.menu_lastRecord);
    	menu.add(0, menu_end, 0, R.string.menu_end);
    	
    	
    	
        return result;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub	
		
		
		switch (item.getItemId()) {
	
        case menu_lastRecord:
             break;
        case menu_end:
        	this.finish();
        	
        	
        	
        	 break;
        default:
            return true;
        }
		
		return super.onMenuItemSelected(featureId, item);
	}


    
}