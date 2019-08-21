package com.bawei.dianshangxiangmu.presenter;

import android.util.Log;

import com.bawei.dianshangxiangmu.data.Model.LoginModel;
import com.bawei.dianshangxiangmu.data.Model.ReginModel;
import com.bawei.dianshangxiangmu.data.bean.LoginBean;
import com.bawei.dianshangxiangmu.data.bean.ReginBean;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

/*
 *@Auther:张亚军
 *@Date: 2019/8/13
 *@Time:14:41
 *@Description:15901514581
 * */public class ReginPresenter extends BasePresenter<Constrans.ReginView> {
     public void reginData(String name, String pwd){
         ReginModel reginModel = new ReginModel();

        reginModel.reginShowModel(name, pwd, new Constrans.CallBackRegin() {
            @Override
            public void reginBack(ReginBean string) {
                getView().regin(string);
            }
        });
     }
}
