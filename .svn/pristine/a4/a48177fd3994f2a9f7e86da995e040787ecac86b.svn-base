package com.example.niu.myapplication.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.example.niu.myapplication.R;


public class MoreListView extends ListView implements OnScrollListener {
	private View footer;
	private int totalItem;
	private int lastItem;
	private boolean over;
	private boolean isLoading;
	private OnLoadMoreListener listener;
	private LayoutInflater inflater;

	public MoreListView(Context context) {
		super(context);
		init(context);
	}

	public MoreListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public MoreListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	@SuppressLint("InflateParams")
	private void init(Context context) {
		inflater = LayoutInflater.from(context);
		footer = inflater.inflate(R.layout.block_more, null, false);
		footer.setVisibility(View.GONE);
		this.setFooterDividersEnabled(false);
		this.setOnScrollListener(this);
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		this.lastItem = firstVisibleItem + visibleItemCount;
		this.totalItem = totalItemCount;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
//		if (this.totalItem == lastItem && scrollState == SCROLL_STATE_IDLE) {
//			if (!isLoading && !over) {
//				isLoading = true;
//				this.addFooterView(footer);
//				footer.setVisibility(View.VISIBLE);
//				listener.onLoadMore();
//			}
//		}
	}

	public void setLoadMoreListen(OnLoadMoreListener listener) {
		this.listener = listener;
	}

	/**
	 * 是否没有记录，不允许在加载了
	 * @param over
	 */
	public void onLoadComplete(boolean over) {
		this.over = over;
		new Handler().postDelayed(new Runnable(){
			public void run() {
				removeFooterView(footer);
				footer.setVisibility(View.GONE);
				isLoading = false;
			}
		},1500);
	}
	
	public interface OnLoadMoreListener {
//		public void onLoadMore();
	}
}