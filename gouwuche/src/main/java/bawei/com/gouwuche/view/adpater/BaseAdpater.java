package bawei.com.gouwuche.view.adpater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bawei.com.gouwuche.R;
import bawei.com.gouwuche.data.bean.HomeBean;
import bawei.com.gouwuche.view.weight.Jianji;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:11:18
 *@Description:15901514581
 * */   public class BaseAdpater extends BaseExpandableListAdapter {
    private List<HomeBean.DataBean> data;

    public BaseAdpater(List<HomeBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).getList() == null ? 0 : 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        PresentViewHolder presentViewHolder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.parent_item, null);
            presentViewHolder = new PresentViewHolder(convertView);
            convertView.setTag(presentViewHolder);
        } else {
            presentViewHolder = (PresentViewHolder) convertView.getTag();
        }
        presentViewHolder.mTextParent.setText(data.get(groupPosition).getSellerName());
       final boolean b = issertCurrect(groupPosition);
        presentViewHolder.mCheckParent.setChecked(b);
        presentViewHolder.mCheckParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectseccurt(groupPosition,!b);
                notifyDataSetChanged();
                resetCartAllaSTUST();

            }
        });
        return convertView;
    }

    private void selectseccurt(int groupPosition,boolean selected) {
        HomeBean.DataBean dataBean = data.get(groupPosition);
        for (int j = 0; j < dataBean.getList().size(); j++) {
            HomeBean.DataBean.ListBean listBean = dataBean.getList().get(j);
          listBean.setSelected(selected?1:0);
        }
    }

    private boolean issertCurrect(int groupPosition) {
        HomeBean.DataBean dataBean = data.get(groupPosition);
        List<HomeBean.DataBean.ListBean> list = dataBean.getList();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getSelected()==0){
                return false;
            }
        }


        return true;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.child_item, null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        final HomeBean.DataBean.ListBean listBean = data.get(groupPosition).getList().get(childPosition);
        data.get(groupPosition).getList().get(childPosition);

        childViewHolder.mNameChild.setText(listBean.getCreatetime());
        Glide.with(parent.getContext()).load(listBean.getImages()).into(childViewHolder.mImageChild);
        childViewHolder.mPriceChild.setText(listBean.getPrice()+"");
        childViewHolder.mJianjiChild.setNum(listBean.getNum());
        childViewHolder.mJianjiChild.setOnCalicttener(new Jianji.OnCalicttener() {
            @Override
            public void oncal(int Num) {
                setchildNUm(groupPosition,childPosition,Num);
                notifyDataSetChanged();
                resetCartAllaSTUST();
            }
        });
        childViewHolder.mCheckChild.setChecked(listBean.getSelected()==1);
        childViewHolder.mCheckChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   listBean.setSelected(listBean.getSelected()==1?0:1);
                   notifyDataSetChanged();
                resetCartAllaSTUST();
            }
        });
        return convertView;

    }

    private void setchildNUm(int groupPosition, int childPosition, int num) {
        HomeBean.DataBean dataBean = data.get(groupPosition);
       dataBean.getList().get(childPosition).setNum(num);
    }
public void changAllpreduocet(boolean misAllstaus){
    for (int i = 0; i < data.size(); i++) {
        HomeBean.DataBean dataBean = data.get(i);
        List<HomeBean.DataBean.ListBean> list = dataBean.getList();
        for (int j = 0; j < list.size(); j++) {
            HomeBean.DataBean.ListBean listBean = list.get(j);
            listBean.setSelected(misAllstaus?1:0);
        }
    }
    notifyDataSetChanged();
}
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class PresentViewHolder {
        @BindView(R.id.check_parent)
        CheckBox mCheckParent;
        @BindView(R.id.text_parent)
        TextView mTextParent;

        PresentViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ChildViewHolder {
        @BindView(R.id.check_child)
        CheckBox mCheckChild;
        @BindView(R.id.image_child)
        ImageView mImageChild;
        @BindView(R.id.name_child)
        TextView mNameChild;
        @BindView(R.id.price_child)
        TextView mPriceChild;
        @BindView(R.id.jianji_child)
        Jianji mJianjiChild;

        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
public void resetCartAllaSTUST(){
        boolean isAllstause =true;
        float coprice=0;
        int num=0;
    for (int i = 0; i < data.size(); i++) {
        HomeBean.DataBean dataBean = data.get(i);
        List<HomeBean.DataBean.ListBean> list = dataBean.getList();
        for (int j = 0; j < list.size(); j++) {
            HomeBean.DataBean.ListBean listBean = list.get(j);
            if (listBean.getSelected()==0){
                isAllstause=false;
            }else{
                coprice+=(listBean.getNum()*listBean.getPrice());
                num+=listBean.getNum();
            }
        }
    }
    if(carOnLinseten!=null){
        carOnLinseten.oncar(isAllstause,coprice,num);
    }
}
public interface CarOnLinseten{
        void oncar(boolean isAllstause,float coprice,int num);
}
CarOnLinseten carOnLinseten;
    public void setCarOnLinseten(CarOnLinseten carOnLinseten){
        this.carOnLinseten=carOnLinseten;
    }
}
