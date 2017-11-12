package mvpframework.bwie.com.a1509aproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mvpframework.bwie.com.a1509aproject.utils.ActivityStroreUtil;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStroreUtil.addActivity(this);
    }

}
