package bawei.com.rikao11.presenter;

import bawei.com.rikao11.data.bean.LoginBean;
import bawei.com.rikao11.data.bean.ReginBean;
import bawei.com.rikao11.model.LoginModel;
import bawei.com.rikao11.model.ReginModel;
import bawei.com.rikao11.view.interfacece.Constans;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:9:04
 *@Description:15901514581
 * */public class ReginPresenter extends BasePresenter<Constans.reginView> {
     public void reginpresenter(String name, String pass){
         ReginModel reginModel = new ReginModel();
         reginModel.reginMofrl(name, pass, new Constans.CallBackRegin() {
             @Override
             public void callRegin(ReginBean string) {
                 getView().showRegin(string);
             }
         });
     }
}
