package tejashwi.com.tensorflowsample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity{

    private static final int RC_SIGN_IN = 9001;
    private TextView userEmail1;


    //뒤로가기 버튼 막기
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText idText = (EditText)findViewById(R.id.id);
        final EditText passwordText = (EditText)findViewById(R.id.password);
        final Button mainLoginButton = findViewById(R.id.mainLoginButton);
        final TextView registerButton = findViewById(R.id.registerButton);
        //final CheckBox chk_auto = (CheckBox)findViewById(R.id.checkbox);
        final TextView findpwButton = findViewById(R.id.findIdPwButton);
        final TextView findidButton = findViewById(R.id.findIDButton);
        final String loginID, loginPW;



        

        SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
        loginID = auto.getString("inputID", null);
        loginPW = auto.getString("inputPW", null);

        if(loginID!=null&&loginPW!=null){
            Toast.makeText(LoginActivity.this,loginID+"님 자동로그인 입니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
            intent.putExtra("userID", loginID);
            startActivity(intent);
            finish();
        }
            mainLoginButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String userID = idText.getText().toString();
                    final String userPassword = passwordText.getText().toString();

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                //
                                if(userID.equals("")){
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setMessage("아이디를 입력해주세요.")
                                            .setPositiveButton("확인", null)
                                            .create()
                                            .show();
                                    return;
                                } else {
                                    //
                                    if (success) {
                                       
                                        if (loginID == null && loginPW == null) {
                                            
                                            SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                                            SharedPreferences.Editor autoLogin = auto.edit();
                                            autoLogin.putString("inputID", idText.getText().toString());
                                            autoLogin.putString("inputPW", passwordText.getText().toString());
                                            autoLogin.commit();
                                            Toast.makeText(LoginActivity.this, idText.getText().toString() + "님 환영합니다.", Toast.LENGTH_SHORT).show();
                                            
                                            String userID = jsonResponse.getString("userID");
                                            
                                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                                            intent.putExtra("userID", userID);
                                            startActivity(intent);
                                            finish();
                                        }

                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                        builder.setMessage("아이디와 비밀번호를 확인해주세요.")
                                                .setNegativeButton("다시시도", null)
                                                .create()
                                                .show();
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    queue.add(loginRequest);
                }
            });



        registerButton.setOnClickListener(new OnClickListener(){ //회원가입 버튼
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        findidButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idIntent = new Intent(LoginActivity.this, FindidActivity.class);
                LoginActivity.this.startActivity(idIntent);
            }
        });

        findpwButton.setOnClickListener(new OnClickListener(){ 
            @Override
            public void onClick(View v) {
                Intent pwIntent = new Intent(LoginActivity.this, FindpwActivity.class);
                LoginActivity.this.startActivity(pwIntent);
            }
        });


    }








    public static class LoginRequest extends StringRequest {
        final static private String URL = "http://jyyu7777.cafe24.com/Login.php";
        private Map<String, String> parameters;

        public LoginRequest(String userID, String userPassword, Response.Listener<String> listener) {
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



    //뒤로가기 버튼 막기(2번 누르면 앱 종료)
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
            ActivityCompat.finishAffinity(this);
        }
        else
        {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "Touch one more time to close the app.", Toast.LENGTH_SHORT).show();
        }
    }











}
