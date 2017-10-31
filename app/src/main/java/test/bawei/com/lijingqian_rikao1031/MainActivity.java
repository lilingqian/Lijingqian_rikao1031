package test.bawei.com.lijingqian_rikao1031;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Bean.login_bean;
import okhttp3.Call;
import utils.GsonObjectCallback;
import utils.OkHttp3Utils;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private  Button button1;
    private EditText edit;

    private EditText editq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button= (Button) findViewById(R.id.denglu);
        button1= (Button) findViewById(R.id.zhuce);
        edit= (EditText) findViewById(R.id.edit);
        editq= (EditText) findViewById(R.id.editq);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,zhuceActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namee=editq.getText().toString();
                String pess=edit.getText().toString();
                Map map=new HashMap();
                map.put("mobile",namee);
               map.put("password",pess);
                OkHttp3Utils.doPost("http://120.27.23.105/user/login", map, new GsonObjectCallback<login_bean>() {
                    @Override
                    public void onUi(login_bean login_bean) {
                        Toast.makeText(MainActivity.this,login_bean.msg,Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,shopp_demo.class));
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });

            }
        });
    }
}
