package tejashwi.com.tensorflowsample;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText id = (EditText) findViewById(R.id.id);
        final EditText password = (EditText) findViewById(R.id.pw);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText phone = (EditText) findViewById(R.id.phone);
        final EditText email = (EditText) findViewById(R.id.email);

        final Button ValidateButton = (Button) findViewById(R.id.validateButton);
        ValidateButton.setOnClickListener(new View.OnClickListener() {
            //중복체크버튼

            @Override
            public void onClick(View v) {
                String userID = id.getText().toString();
                if(validate){
                    return;
                }

                if(userID.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setMessage("아이디는 빈 칸일 수 없습니다.")
                            .setPositiveButton("확인", null)
                            .create()
                            .show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("사용할 수 있는 아이디입니다.")
                                        .setPositiveButton("확인",null)
                                        .create()
                                        .show();
                                id.setEnabled(false);
                                validate = true;
                                id.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                                ValidateButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("사용할 수 없는 아이디입니다.")
                                        .setPositiveButton("확인",null)
                                        .create()
                                        .show();

                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest = new ValidateRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(validateRequest);
            }
        });



        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id = id.getText().toString();
                String Pw = password.getText().toString();
                String Name = name.getText().toString();
                String PH = phone.getText().toString();
                String Em = email.getText().toString();

                if(Id.equals("") || Pw.equals("") || Name.equals("") || PH.equals("") || Em.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setMessage("빈 칸이 존재합니다.")
                            .setPositiveButton("확인", null)
                            .create()
                            .show();
                    return;
                }




                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");


                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("회원등록에 성공 했습니다.")
                                        .setPositiveButton("확인",null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("회원등록에 실패 했습니다.")
                                        .setNegativeButton("다시시도", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                RegisterRequest registerRequest=new RegisterRequest(Id, Pw, Name, PH, Em, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

            }
        });
    }

    public static class RegisterRequest extends StringRequest {
        final static private String URL = "http://jyyu7777.cafe24.com/Register.php";
        private Map<String, String> parameters;

        public RegisterRequest(String userID, String userPassword, String userName, String userPhone, String userEmail, Response.Listener<String> listener) {
            super(Method.POST, URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("userID", userID);
            parameters.put("userPassword", userPassword);
            parameters.put("userName", userName);
            parameters.put("userPhone", userPhone);
            parameters.put("userEmail", userEmail);

        }

        @Override
        public Map<String, String> getParams(){
            return parameters;
        }
    }

    public static class ValidateRequest extends StringRequest {

        //사용가능한 아이디인지 체크하는 클래스

        final static private String URL = "http://jyyu7777.cafe24.com/UserValidate.php";
        private Map<String, String> parameters;

        public ValidateRequest(String userID, Response.Listener<String> listener) {
            super(Method.POST, URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("userID", userID);

        }

        @Override
        public Map<String, String> getParams() throws AuthFailureError {
            return parameters;
        }

    }
}
