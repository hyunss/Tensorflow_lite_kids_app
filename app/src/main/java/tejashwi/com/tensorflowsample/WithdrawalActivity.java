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

public class WithdrawalActivity extends AppCompatActivity {

    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawal);

        final EditText wd_idText = (EditText) findViewById(R.id.wd_IDtext);
        final EditText wd_pwText = (EditText) findViewById(R.id.wd_PWtext);
        final Button wd_btn = (Button) findViewById(R.id.withdrawal_btn2);

        wd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userID = wd_idText.getText().toString();
                final String userPassword = wd_pwText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(validate){
                            return;
                        }
                        if(wd_idText.equals("")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(WithdrawalActivity.this);
                            builder.setMessage("아이디는 빈 칸일 수 없습니다.")
                                    .setPositiveButton("확인", null)
                                    .create()
                                    .show();
                            return;
                        }
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(WithdrawalActivity.this);
                                builder.setMessage("회원탈퇴성공")
                                        .setPositiveButton("확인", null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(WithdrawalActivity.this, LoginActivity.class);
                                WithdrawalActivity.this.startActivity(intent);
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(WithdrawalActivity.this);
                                builder.setMessage("아이디 비밀번호를 확인해주세요.")
                                        .setNegativeButton("다시시도",null)
                                        .create()
                                        .show();
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                WithdrawalRequest withdrawalRequest = new WithdrawalRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(WithdrawalActivity.this);
                queue.add(withdrawalRequest);
            }
        });
    }

    public static class WithdrawalRequest extends StringRequest {
        final static private String URL = "http://jyyu7777.cafe24.com/withdraw.php";
        private Map<String, String> parameters;

        public WithdrawalRequest(String userID, Response.Listener<String> listener) {
            super(Method.POST, URL, listener, null);

            parameters = new HashMap<>();
            parameters.put("userID", userID);

        }
        @Override
        public Map<String, String> getParams() {
            return parameters;
        }


    }
}
