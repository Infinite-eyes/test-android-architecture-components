package come.example.livedatatest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private NameViewModel mModel;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        mModel = ViewModelProviders.of(this).get(NameViewModel.class);

        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv.setText(s);
            }
        };

        mModel.getCurrentName().observe(this, nameObserver);

        String anotherName = "John Doe";
        mModel.getCurrentName().setValue(anotherName);
    }
}
