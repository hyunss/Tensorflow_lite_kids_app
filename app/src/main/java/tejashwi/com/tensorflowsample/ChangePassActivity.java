package tejashwi.com.tensorflowsample;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangePassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

        final EditText changeText = (EditText) findViewById(R.id.changeText);
        final EditText idText = (EditText) findViewById(R.id.IDTEXT);


        final Button change_btn = (Button) findViewById(R.id.ChangeButton);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mIDText = idText.getText().toString();
                final String passChange = changeText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ChangePassActivity.this);
                                builder.setMessage("비밀번호 변경에 성공했습니다.")
                                        .setPositiveButton("확인", null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(ChangePassActivity.this, LoginActivity.class);
                                ChangePassActivity.this.startActivity(intent);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                ChangePassRequest changePassRequest = new ChangePassRequest(mIDText, passChange, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ChangePassActivity.this);
                queue.add(changePassRequest);

            }
        });
    }


    public static class ChangePassRequest extends StringRequest {
        final static private String URL = "http://jyyu7777.cafe24.com/passwordChange.php";
        private Map<String, String> parameters;

        public ChangePassRequest(String userID, String userPassword, Response.Listener<String> listener) {
            super(Method.POST, URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("userID", userID);
            parameters.put("userPassword", userPassword);
        }

        @Override
        public Map<String, String> getParams(){
            return parameters;
        }
    }
}
