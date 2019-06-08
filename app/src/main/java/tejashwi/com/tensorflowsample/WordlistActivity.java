package tejashwi.com.tensorflowsample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordlistActivity extends AppCompatActivity {
    ListView word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordlist);
        final Intent intent = getIntent();
        final ArrayList<String> list = (ArrayList<String>) intent.getSerializableExtra("userWORDS");
        word = (ListView) findViewById(R.id.WordList);

        ArrayAdapter simpleAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        word.setAdapter(simpleAdapter);


        word.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), DictionaryActivity.class);
                i.putExtra("words",(String)parent.getAdapter().getItem(position));
                startActivity(i);
            }
        });

    }
}
