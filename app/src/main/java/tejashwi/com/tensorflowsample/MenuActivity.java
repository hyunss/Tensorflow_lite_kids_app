package tejashwi.com.tensorflowsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {

    String userID ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView WelcomeMessage = (TextView)findViewById(R.id.welcomeMessage);
        final ImageView Mypagebutton = (ImageView) findViewById(R.id.mypageButton);
        ImageView dictionary_btn = (ImageView) findViewById(R.id.dictionaryButton);
        ImageView detection_btn = (ImageView) findViewById(R.id.cameraButton);

        Intent intent =getIntent();
        userID = intent.getStringExtra("userID");

        Mypagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData(userID);
            }
        });

        dictionary_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MenuActivity.this, DictionaryActivity.class);
                MenuActivity.this.startActivity(intent1);
            }
        });

        detection_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MenuActivity.this, ObjectActivity.class);
                intent2.putExtra("userID", userID);
                MenuActivity.this.startActivity(intent2);
            }
        });
        String message =  userID;
        WelcomeMessage.setText(message);
    }
    private void getData(String userID) {

        String value = userID;

        if (value.equals("")) {
            Toast.makeText(this, "Please Enter Data Value", Toast.LENGTH_LONG).show();
            return;
        }

        String url = Config5.DATA_URL + value;



        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MenuActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config5.JSON_ARRAY);

            String name ="", email="";
            for(int i=0;i<result.length();i++){
                JSONObject jo = result.getJSONObject(i);
                name = jo.getString(Config5.KEY_DATA);
                email = jo.getString(Config5.KEY_ID);
            }
            Intent intent = new Intent(MenuActivity.this, MypageActivity.class);
            intent.putExtra("userID", userID);
            intent.putExtra("userName", name);
            intent.putExtra("userEmail", email);
            MenuActivity.this.startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static class Config5 {
        public static final String DATA_URL="http://jyyu7777.cafe24.com/fetchDB.php?userID=";
        public static final String KEY_DATA = "userName";
        public static final String KEY_ID = "userEmail";
        public static final String JSON_ARRAY = "result";
    }
}
