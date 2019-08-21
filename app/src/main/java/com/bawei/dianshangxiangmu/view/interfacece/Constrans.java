package com.bawei.dianshangxiangmu.view.interfacece;

import com.bawei.dianshangxiangmu.data.bean.BannerBean;
import com.bawei.dianshangxiangmu.data.bean.HomeBean;
import com.bawei.dianshangxiangmu.data.bean.LoginBean;
import com.bawei.dianshangxiangmu.data.bean.ReginBean;
import com.bawei.dianshangxiangmu.data.bean.XiangBean;

/*
 *@Auther:张亚军
 *@Date: 2019/8/13
 *@Time:14:36
 *@Description:15901514581
 * */public interface Constrans {
     public interface LoginView{
         void login(LoginBean string);
     }
     public interface CallBackLogin{
         void loginBack(LoginBean loginBean);
     }
    public interface ReginView{
        void regin(ReginBean reginBean);
    }
    public interface CallBackRegin{
        void reginBack(ReginBean string);
    }
    public interface BeanView{
        void ban(BannerBean bannerBean);
        void home(HomeBean homeBean);
    }
    public interface CallBackBan{
        void BanBack(BannerBean string);
    }
    public interface CallBackHome{
        void homeBack(HomeBean homeBean);
    }
    public interface XiangView{
        void xiang(XiangBean xiangBean);
    }
    public interface CallBackXiang{
        void xiangnBack(XiangBean string);
    }
}
