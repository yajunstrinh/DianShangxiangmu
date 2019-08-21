package bawei.com.rikao11.presenter;

import bawei.com.rikao11.data.bean.LoginBean;
import bawei.com.rikao11.model.LoginModel;
import bawei.com.rikao11.view.interfacece.Constans;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:9:04
 *@Description:15901514581
 * */public class LoginPresenter extends BasePresenter<Constans.loginView> {
     public void loginpresenter(String name, String pass){
         LoginModel loginModel = new LoginModel();
         loginModel.loginMofrl(name,pass,new Constans.CallBackLogin() {
             @Override
             public void callLogin(LoginBean string) {
                 getView().showLogin(string);
             }
         });
     }
}
