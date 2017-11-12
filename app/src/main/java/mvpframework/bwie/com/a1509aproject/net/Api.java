package mvpframework.bwie.com.a1509aproject.net;

/**
 * Created by peng on 2017/11/7.
 */

public interface Api {
    public static boolean isOnline = false;
    public static final String DEV = "http://120.27.23.105/";
    public static final String WROK = "";
    public static final String HOST = isOnline ? WROK : DEV;

    public static final String LOGIN = HOST + "user/login";//登陆
    public static final String REGISTER = HOST + "user/reg";//注册
    public static final String CLASS = HOST + "product/getCatagory";//分类
    public static final String PRODUCT_CATAGORY = HOST + "product/getProductCatagory";//商品子分类接口
}
