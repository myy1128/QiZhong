package com.example.myy.qizhong;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class XiaoFragment extends Fragment {


    private View view;
    private RecyclerView rv;
    private ArrayList<DbBean> list;
    public XiaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_xiao, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        rv = (RecyclerView) inflate.findViewById(R.id.rv);

        DbBean dbBean = new DbBean(null, "http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg", "大学生们，我为什么不建议你们一毕业就创业");
        DbUtil.getDbUtil().insert(dbBean);

        list = new ArrayList<>();
        List<DbBean> query = DbUtil.getDbUtil().query();
        list.addAll(query);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        RvAdapter rvAdapter = new RvAdapter(list, getActivity());
        rv.setAdapter(rvAdapter);
    }
}
