package bawei.com.gouwuche.presenter;

import bawei.com.gouwuche.data.bean.HomeBean;
import bawei.com.gouwuche.model.HomeModel;
import bawei.com.gouwuche.view.interfacece.Constans;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:10:00
 *@Description:15901514581
 * */public class HomePresenter extends BasePresenter<Constans.BaseMain>{
     public void showPresenter(){
         HomeModel homeModel = new HomeModel();
         homeModel.showModel(new Constans.CallBackHome() {
             @Override
             public void calBck(HomeBean s) {
                 getView().main(s);
             }
         });
     }
}
