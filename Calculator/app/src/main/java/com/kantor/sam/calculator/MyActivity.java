package com.kantor.sam.calculator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    public static String str = "";
    public static String str2 = "";

    public boolean wasAddClicked = false;
    public boolean wasOpClicked = false;

    public void numberClicked (View view) {

        Button button = (Button)view;
        //String str = "";
        String newstr = button.getText().toString();
        TextView textView = (TextView)findViewById(R.id.container1);

        if (!(wasOpClicked) ) {

            str = str + newstr;
            textView.setText(str);
        }
        else {

            str2 = str2 + newstr;
            textView.setText(str2);
        }
        //Integer number = Integer.valueOf(str);
        //textView.setText(String.valueOf(number));
    }

    public void Add (View view) {

       Button button = (Button)view;
        String newstr1 = button.getText().toString();
        TextView operationClick = (TextView)findViewById(R.id.OperationSelected);
        // str = newstr1;
        wasOpClicked = true;
        wasAddClicked = true;

    }

    public void Equals (View view) {

        TextView equals = (TextView)findViewById(R.id.equals);
        Button button = (Button)view;
        if (wasAddClicked) {

            int number = Integer.valueOf(str);
            int number2 = Integer.valueOf(str2);
            int equals2 = number + number2;

            equals.setText(Integer.toString(equals2));
        }

    }

/*    public void operationClicked (View view) {

        Button button = (Button)view;
        String str = button.getText().toString();
        TextView operationClick = (TextView)findViewById(R.id.OperationSelected);
        operationClick.setText(str);
        wasOpClicked = true;

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);
            return rootView;
        }
    }
}
