package com.example.niu.myapplication.presenter;

import android.arch.lifecycle.LifecycleObserver;

/**
 * Created by wanglei on 18-6-29.
 */

public abstract class BasePresenter <M extends BaseView,T extends BaseModel>
        implements LifecycleObserver {


    M view;
    T model;

    public BasePresenter(){

        model = createModel();
    }

    public void attachView(M view){

        this.view = view;

    }

    public void detachView(){

        view = null;
    }


    protected abstract T createModel();


}
