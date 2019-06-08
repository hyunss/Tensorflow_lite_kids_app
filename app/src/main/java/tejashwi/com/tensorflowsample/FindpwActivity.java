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

public class FindpwActivity extends AppCompatActivity {
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpw);

        final EditText mIdText = (EditText) findViewById(R.id.IDTEXT);
        final Button mEmailButton = (Button) findViewById(R.id.IDbutton);

        mEmailButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String userID = mIdText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(validate){
                            return;
                        }
                        if(mIdText.equals("")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(FindpwActivity.this);
                            builder.setMessage("아이디는 빈 칸일 수 없습니다.")
                                    .setNegativeButton("확인", null)
                                    .create()
                                    .show();
                            return;
                        }
                        try{

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(FindpwActivity.this);
                                builder.setMessage("승인 코드를 이메일로 발송합니다.")
                                        .setNegativeButton("확인",null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(FindpwActivity.this, IdentiActivity.class);
                                intent.putExtra("ID", "userID");
                                FindpwActivity.this.startActivity(intent);

                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(FindpwActivity.this);
                                builder.setMessage("아이디를 확인해주세요.")
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
                EmailRequest emailRequest=new EmailRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(FindpwActivity.this);
                queue.add(emailRequest);
            }
        });




    }

    public static class EmailRequest extends StringRequest {
        final static private String URL = "http://jyyu7777.cafe24.com/Identification.php";
        private Map<String, String> parameters;

        public EmailRequest(String userID, Response.Listener<String> listener) {
            super(Method.POST, URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("userID", userID);

        }

        @Override
        public Map<String, String> getParams(){
            return parameters;
        }
    }
}
