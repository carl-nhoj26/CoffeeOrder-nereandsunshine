package android.example.com.coffeeorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int numberOfCoffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    int quantity = 0;


    public void increment(View view) {
        quantity++;
        displayQuantity( quantity );
    }


    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity--;
        displayQuantity( quantity );
    }


    public void submitOrder(View view) {

        EditText nameField = (EditText) findViewById( R.id.name_field );
        String value = nameField.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById( R.id.whipped_cream_checkbox );
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById( R.id.chocolate_checkbox );
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice( hasWhippedCream, hasChocolate );
        String priceMessage = createOrderSummary( value, price, hasWhippedCream, hasChocolate );
        displayMessage( priceMessage );
    }

    private View findViewById( int chocolate_checkbox) {
        return null;
    }


    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {

        int basePrice = 5;

        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        if (addChocolate) {
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }


    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }


    private void displayQuantity(int numberOfCoffees) {
        this.numberOfCoffees = numberOfCoffees;
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view );
        quantityTextView.setText( "" + numberOfCoffees );
    }


    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById( R.id.order_summary_text_view );
        OrderSummaryTextView.setText( message );
    }
}

