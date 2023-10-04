package fr.isep.androidjavaone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextLocation;
    private EditText editTextStartDate;
    private EditText editTextEndDate;
    private EditText editTextNumOfPeople;
    private EditText editTextPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLocation = findViewById(R.id.editTextLocation);
        editTextStartDate = findViewById(R.id.editTextStartDate);
        editTextEndDate = findViewById(R.id.editTextEndDate);
        editTextNumOfPeople = findViewById(R.id.editTextNumOfPeople);
        editTextPrice = findViewById(R.id.editTextPrice);

        Button buttonSearch = findViewById(R.id.buttonSearch);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });
    }

    private void performSearch() {
        // Retrieve user input from EditText fields
        String location = editTextLocation.getText().toString();
        String startDate = editTextStartDate.getText().toString();
        String endDate = editTextEndDate.getText().toString();
        String numOfPeople = editTextNumOfPeople.getText().toString();
        String price = editTextPrice.getText().toString();

        // Construct the search query based on the user's input
        String searchQuery = constructSearchQuery(location, startDate, endDate, numOfPeople, price);

        // Call the API with the search query and handle the response
        // For simplicity, let's assume you have a method called fetchSearchResults(searchQuery) to handle API calls
        fetchSearchResults(searchQuery);
    }

    private String constructSearchQuery(String location, String startDate, String endDate, String numOfPeople, String price) {
        // Construct the search query based on the input parameters
        // You might want to format the query as per your API requirements
        // For example: "?location=NewYork&startDate=2023-10-01&endDate=2023-10-15&..."
        StringBuilder queryBuilder = new StringBuilder();

        if (!location.isEmpty()) {
            queryBuilder.append("location=").append(location).append("&");
        }

        if (!startDate.isEmpty()) {
            queryBuilder.append("startDate=").append(startDate).append("&");
        }

        if (!endDate.isEmpty()) {
            queryBuilder.append("endDate=").append(endDate).append("&");
        }

        if (!numOfPeople.isEmpty()) {
            queryBuilder.append("numOfPeople=").append(numOfPeople).append("&");
        }

        if (!price.isEmpty()) {
            queryBuilder.append("price=").append(price).append("&");
        }

        // Remove the trailing "&" if it exists
        if (queryBuilder.length() > 0 && queryBuilder.charAt(queryBuilder.length() - 1) == '&') {
            queryBuilder.deleteCharAt(queryBuilder.length() - 1);
        }

        return queryBuilder.toString();
    }

    private void fetchSearchResults(String searchQuery) {
        // Make API call using the searchQuery and handle the response
        // You'll need to implement the logic for making API calls and handling responses here
        // For this example, we'll just show a toast message with the search query
        Toast.makeText(this, "Search query: " + searchQuery, Toast.LENGTH_SHORT).show();
    }

}