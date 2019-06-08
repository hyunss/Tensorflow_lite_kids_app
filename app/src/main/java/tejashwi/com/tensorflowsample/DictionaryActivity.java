package tejashwi.com.tensorflowsample;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DictionaryActivity extends AppCompatActivity {

    String url;
    private TextView showDef;
    private EditText enterWord;
    private String findwords="";
    private String word="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        showDef = (TextView)findViewById (R.id.showDef);
        enterWord = (EditText) findViewById (R.id.enterWord);
        Intent intent = new Intent();
        findwords = intent.getStringExtra("words");
    }

    private String dictionaryEntries() {
        final String language = "en-gb";

        if(enterWord.equals("")){
            word = findwords;
        }
        else {
            word = enterWord.getText().toString();
        }
        //now we will get the meaning of word entered in edittext
        final String fields = "definitions";//replace with whatever field you want
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }

    public void sendRequestOnClick(View v)
    {
        DictionaryRequest dR = new DictionaryRequest (this, showDef);
        url = dictionaryEntries ();
        dR.execute (url);
    }

    public static class DictionaryRequest extends AsyncTask<String, Integer, String>
    {
        Context context;
        TextView showDef;

        DictionaryRequest(Context context, TextView tV)
        {
            this.context = context;
            showDef = tV;
        }
        @Override
        protected String doInBackground(String... params) {

            final String app_id = "3c7574b5";
            final String app_key = "b2ccb5136842e8708f881268d2efd6cb";
            try {
                URL url = new URL(params[0]);
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Accept","application/json");
                urlConnection.setRequestProperty("app_id",app_id);
                urlConnection.setRequestProperty("app_key",app_key);

                // read the output from the server
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                return stringBuilder.toString();

            }
            catch (Exception e) {
                e.printStackTrace();
                return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            String def;
            try {
                JSONObject js = new JSONObject(result);
                JSONArray results = js.getJSONArray ("results");

                JSONObject lEntries = results.getJSONObject (0);
                JSONArray laArray = lEntries.getJSONArray ("lexicalEntries");

                JSONObject entries = laArray.getJSONObject (0);
                JSONArray e = entries.getJSONArray ("entries");

                JSONObject jsonObject = e.getJSONObject (0);
                JSONArray sensesArray = jsonObject.getJSONArray ("senses");

                JSONObject de = sensesArray.getJSONObject (0);
                JSONArray d = de.getJSONArray ("definitions");

                def = d.getString (0);
                showDef.setText (def);

            }
            catch (JSONException e) {
                e.printStackTrace ( );
            }

            Log.v ("Result of Directory", "onPostExecute"+result);
        }
    }
}
