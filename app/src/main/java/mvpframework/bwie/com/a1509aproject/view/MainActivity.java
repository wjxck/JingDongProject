package mvpframework.bwie.com.a1509aproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mvpframework.bwie.com.a1509aproject.R;
import mvpframework.bwie.com.a1509aproject.presenter.MainPresenter;
import mvpframework.bwie.com.a1509aproject.view.IView.IMainActivity;

/**
 *
 */
public class MainActivity extends BaseActivity implements View.OnClickListener, IMainActivity {

    private ImageView mIvBack;
    /**
     * 手机号
     */
    private EditText mEtPhone;
    /**
     * 请输入密码
     */
    private EditText mEtPwd;
    private ImageView mIvPwd;
    /**
     * 登陆
     */
    private Button mBtLogin;
    /**
     * 请注册
     */
    private TextView mTvRegister;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //关联presenter
        mainPresenter = new MainPresenter(this);
        initView();
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mIvPwd = (ImageView) findViewById(R.id.iv_pwd);
        mBtLogin = (Button) findViewById(R.id.bt_login);
        mBtLogin.setOnClickListener(this);
        mTvRegister = (TextView) findViewById(R.id.tv_register);
        mTvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                mainPresenter.login();
                break;
            case R.id.tv_register:
                //注册
                mainPresenter.register();
                break;
        }
    }

    @Override
    public String getAccount() {
        return mEtPhone.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mEtPwd.getText().toString().trim();
    }

    @Override
    public void show(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toRegisterAc() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void toClassAc() {
        Intent intent = new Intent(MainActivity.this, ClassActivity.class);
        startActivity(intent);
    }
}
