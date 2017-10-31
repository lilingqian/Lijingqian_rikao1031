
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

import Bean.zhuce_bean;
import okhttp3.Call;
import utils.GsonObjectCallback;
import utils.OkHttp3Utils;

public class zhuceActivity extends AppCompatActivity {
    private EditText nam;
    private EditText eml;
    private EditText pw;
    private EditText pw2;
    private Button butto;
    private Map map;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);


        nam= (EditText) findViewById(R.id.name);
         eml= (EditText) findViewById(R.id.emle);
        pw= (EditText) findViewById(R.id.pwd);
         pw2= (EditText) findViewById(R.id.pwd2);
       butto= (Button) findViewById(R.id.zhuce);


        butto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map =new HashMap();
                String namee = nam.getText().toString();
                String pwdd = pw.getText().toString();
                String pedd2 = pw2.getText().toString();
                String emall = eml.getText().toString();
                map.put("mobile", namee);
                map.put("password", pwdd);
                if (pwdd.equals(pedd2)){
                    OkHttp3Utils.getInstance().doPost("http://120.27.23.105/user/reg", map, new GsonObjectCallback<zhuce_bean>() {
                        @Override
                        public void onUi(zhuce_bean zhuce_bean) {
                            Toast.makeText(zhuceActivity.this, zhuce_bean.msg, Toast.LENGTH_SHORT).show();


                            startActivity(new Intent(zhuceActivity.this, MainActivity.class));
                        }

                        @Override
                        public void onFailed(Call call, IOException e) {

                        }
                    });
                }else{
                    Toast.makeText(zhuceActivity.this,"两次密码不正确",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
