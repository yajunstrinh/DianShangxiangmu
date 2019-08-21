package com.bawei.dianshangxiangmu.data.bean;

import java.util.ArrayList;
import java.util.List;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:16:07
 *@Description:15901514581
 * */public class ItemBean {
    private String commodityName;
    private String masterPic;
    private int price;
    private int commodityId;
    public ItemBean(String commodityName, String masterPic, int price) {
        this.commodityName = commodityName;
        this.masterPic = masterPic;
        this.price = price;
    }

    public ItemBean(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                ", price=" + price +
                '}';
    }
}
