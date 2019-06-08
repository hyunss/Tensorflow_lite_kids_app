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

public class IdentiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identi);

        Intent intent = getIntent();
        final String userID = intent.getExtras().getString("ID");

        final EditText AuthNumber = (EditText) findViewById(R.id.emailAuth_number);

        final Button auth_btn = (Button) findViewById(R.id.emailAuth_btn);
        auth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String authNumber = AuthNumber.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(IdentiActivity.this);
                                builder.setMessage("메일인증에 성공했습니다.")
                                        .setPositiveButton("확인", null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(IdentiActivity.this, ChangePassActivity.class);
                                intent.putExtra("identi", "authNumber");
                                IdentiActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(IdentiActivity.this);
                                builder.setMessage("인증에 실패했습니다.")
                                        .setNegativeButton("다시시도", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                IdentiRequest identiRequest = new IdentiRequest(userID, authNumber, responseListener);
                RequestQueue queue = Volley.newRequestQueue(IdentiActivity.this);
                queue.add(identiRequest);

            }
        });
    }

    public static class IdentiRequest extends StringRequest {
        final static private String URL = "http://jyyu7777.cafe24.com/userIdenti.php";
        private Map<String, String> parameters;

        public IdentiRequest(String userID, String identi, Response.Listener<String> listener) {
            super(Method.POST, URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("userID", userID);
            parameters.put("identi", identi);
        }

        @Override
        public Map<String, String> getParams(){
            return parameters;
        }
    }
}
