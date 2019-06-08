package tejashwi.com.tensorflowsample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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

public class MypageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);


        TextView MypageID = (TextView)findViewById(R.id.myIDMessage);
        TextView MypageName = (TextView)findViewById(R.id.myName);
        TextView MypageEmail = (TextView)findViewById(R.id.mypageEmail);


        final Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");
        final String userEmail = intent.getStringExtra("userEmail");
        final String userName = intent.getStringExtra("userName");

        Button resetpw_btn = (Button) findViewById(R.id.ResetPw_button);
        Button withdraw_btn = (Button) findViewById(R.id.withdrawal_button);
        Button logout_btn=(Button) findViewById(R.id.Logout_Button) ;
        Button userstore_btn = (Button)findViewById(R.id.userwordlist);

        MypageID.setText(userID);
        MypageEmail.setText(userEmail);
        MypageName.setText(userName);



        withdraw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wintent = new Intent(MypageActivity.this, WithdrawalActivity.class);
                MypageActivity.this.startActivity(wintent);
            }
        });



        resetpw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reset_intent = new Intent(MypageActivity.this, FindpwActivity.class);
                MypageActivity.this.startActivity(reset_intent);

            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent i = new Intent(MypageActivity.this, LoginActivity.class);
                        startActivity(i);
                        SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = auto.edit();

                        editor.clear();
                        editor.commit();
                        Toast.makeText(MypageActivity.this, "로그아웃", Toast.LENGTH_SHORT).show();
                        finish();
            }
        });
        userstore_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData(userID);
            }
        });

    }
    private void getData(String userID) {

        String value = userID;

        if (value.equals("")) {
            Toast.makeText(this, "Please Enter Data Value", Toast.LENGTH_LONG).show();
            return;
        }

        String url = MypageActivity.Config5.DATA_URL + value;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MypageActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(MypageActivity.Config5.JSON_ARRAY);

            String words ="";
            ArrayList<String> arraylist = new ArrayList<String>();
            for(int i=0;i<result.length();i++){
                JSONObject jo = result.getJSONObject(i);
                words = jo.getString(MypageActivity.Config5.KEY_DATA);
                arraylist.add(words);
            }
            Intent intent = new Intent(MypageActivity.this, WordlistActivity.class);
            intent.putExtra("userWORDS", arraylist);

            MypageActivity.this.startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public static class Config5 {
        public static final String DATA_URL="http://jyyu7777.cafe24.com/fetchWord.php?userID=";
        public static final String KEY_DATA = "userWORDS";
        public static final String JSON_ARRAY = "result";
    }
}
