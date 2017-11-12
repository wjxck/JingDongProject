package mvpframework.bwie.com.a1509aproject.presenter;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mvpframework.bwie.com.a1509aproject.bean.LoginBean;
import mvpframework.bwie.com.a1509aproject.model.IModel.ILoginModel;
import mvpframework.bwie.com.a1509aproject.model.IModel.IRegisterModel;
import mvpframework.bwie.com.a1509aproject.model.LoginModel;
import mvpframework.bwie.com.a1509aproject.model.RegisterModel;
import mvpframework.bwie.com.a1509aproject.net.OnNetListener;
import mvpframework.bwie.com.a1509aproject.view.IView.IMainActivity;

/**
 * Created by peng on 2017/11/7.
 * MainActiivty对应的 P 层
 */

public class MainPresenter {
    private IMainActivity iMainActivity;
    private final ILoginModel iLoginModel;
    private final IRegisterModel iRegisterModel;

    public MainPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iLoginModel = new LoginModel();
        iRegisterModel = new RegisterModel();
    }

    public void login() {
        String account = iMainActivity.getAccount();
        String pwd = iMainActivity.getPwd();
        //判断账号密码是否正确
        if (checkAccount(account) && checkPwd(pwd)) {
            //去调用model，进行登陆
            iLoginModel.login(account, pwd, new OnNetListener<LoginBean>() {
                @Override
                public void onSuccess(LoginBean loginBean) {
                    //保存登陆成功后的数据，可以保存到SP,也可以保存到数据库
                    iMainActivity.show(loginBean.getMsg());
                    //跳转到分类界面
                    iMainActivity.toClassAc();
                }

                @Override
                public void onFailure(Exception e) {

                }
            });
        }

    }

    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            //给用户提示，输入的账号不能为空
            iMainActivity.show("请输入密码");
            return false;
        }

        if (pwd.length() != 6) {
            iMainActivity.show("请输入6位密码");
            return false;
        }
        return true;
    }


    /**
     * 验证手机号是否正确
     *
     * @param account
     */
    private boolean checkAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            //给用户提示，输入的账号不能为空
            iMainActivity.show("请输入账号");
            return false;
        }
        if (!isMobileNO(account)) {
            iMainActivity.show("请输入正确的手机号");
            return false;
        }
        return true;
    }


    /*
    判断是否是手机号
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


    public void register() {
        //其实就是跳转到注册页面
        iMainActivity.toRegisterAc();
    }
}