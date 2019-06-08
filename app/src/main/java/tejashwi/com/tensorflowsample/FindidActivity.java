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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FindidActivity extends AppCompatActivity {
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findid);

        final EditText mEmailText = (EditText) findViewById(R.id.Email_TEXT);
        final Button mEmailButton = (Button) findViewById(R.id.Emailbutton);


        mEmailButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String userEmail = mEmailText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(validate){
                            return;
                        }
                        if(mEmailText.equals("")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(FindidActivity.this);
                            builder.setMessage("이메일은 빈 칸일 수 없습니다.")
                                    .setNegativeButton("확인", null)
                                    .create()
                                    .show();
                            return;
                        }
                        try{

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(FindidActivity.this);
                                builder.setMessage("아이디를 이메일로 발송합니다.")
                                        .setNegativeButton("확인",null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(FindidActivity.this, LoginActivity.class);
                                FindidActivity.this.startActivity(intent);

                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(FindidActivity.this);
                                builder.setMessage("이메일을 확인해주세요.")
                                        .setNegativeButton("확인",null)
                                        .create()
                                        .show();
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                IDRequest idRequest = new IDRequest(userEmail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(FindidActivity.this);
                queue.add(idRequest);
            }
        });




    }

    public static class IDRequest extends StringRequest {
        final static private String URL = "http://jyyu7777.cafe24.com/Identi_ID.php";
        private Map<String, String> parameters;

        public IDRequest(String userEmail, Response.Listener<String> listener) {
            super(Method.POST, URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("userEmail", userEmail);

        }

        @Override
        public Map<String, String> getParams(){
            return parameters;
        }
    }
}
