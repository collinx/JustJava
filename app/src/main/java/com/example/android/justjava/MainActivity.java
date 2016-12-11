package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int s = 0;

    public void submitOrder(View view) {
        CheckBox swhip = (CheckBox) findViewById(R.id.checky);
        CheckBox schoc = (CheckBox) findViewById(R.id.chocy);
        EditText name = (EditText) findViewById(R.id.namey);
        EditText emai = (EditText) findViewById(R.id.ema);
        String nameyo = "",emaill;
        nameyo = name.getText().toString();
        emaill = emai.getText().toString();

        int total = s*5;
        String  iswhip,ischoc;
        if(swhip.isChecked()==true) {
            iswhip = getString(R.string.tr);
            total += s;
        }else
            iswhip = getString(R.string.fa);
        if(schoc.isChecked()==true) {
            ischoc = getString(R.string.tr);
            total += s;
        }else
            ischoc = getString(R.string.fa);

    String priceMessage = "Name: "+ nameyo;
        priceMessage += "\nAdd Whipped Cream? "+iswhip;
        priceMessage += "\nAdd Chocolate? "+ischoc;
        priceMessage += "\nQuantity: "+ s;
        priceMessage += "\nTotal: Rs."+ total;
        priceMessage += "\nThank You!";
     //   displayPrice(s * 5);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"+emaill)); // only email apps should handle this

        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.Just) + " "+ nameyo);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }



    }

    public void incr(View view) {
        if( s < 100 )
        s=s+1;
        display(s);

    }
    public void decr(View view) {
        if(s>0)
            s=s-1;
        display(s);

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
  /*  private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R: .id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
*/

}