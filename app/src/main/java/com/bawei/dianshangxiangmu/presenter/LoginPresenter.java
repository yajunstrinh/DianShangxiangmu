package com.bawei.dianshangxiangmu.presenter;

import android.util.Log;

import com.bawei.dianshangxiangmu.data.Model.LoginModel;
import com.bawei.dianshangxiangmu.data.bean.LoginBean;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

/*
 *@Auther:张亚军
 *@Date: 2019/8/13
 *@Time:14:41
 *@Description:15901514581
 * */public class LoginPresenter extends BasePresenter<Constrans.LoginView> {
     public void loginData(String name, String pwd){
          LoginModel loginModel = new LoginModel();
          loginModel.loginShowModel(name,pwd,new Constrans.CallBackLogin() {
               @Override
               public void loginBack(LoginBean loginBean) {
                   Log.e("aa",loginBean+"");
                    getView().login(loginBean);
               }
          });
     }
}
