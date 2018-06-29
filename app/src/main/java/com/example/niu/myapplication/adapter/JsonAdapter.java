package com.example.niu.myapplication.adapter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class JsonAdapter extends BaseAdapter {
	private ArrayList<JSONObject> list;
	protected LayoutInflater inflater;
	protected Context context;

	public JsonAdapter(Context context) {
		list = new ArrayList<JSONObject>();
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	/**
	 * �ϲ���������
	 * 
	 * @param ja
	 */
	public void merge(JSONArray ja) {
		try {
			for (int i = 0; i < ja.length(); i++) {
				list.add(ja.getJSONObject(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// notifyDataSetChanged();
	}

	/** 移除item数据 */
	public void delData(int pos) {
		if (list != null && list.size() > 0) {
			list.remove(pos);// 移除最后一条数据
		}

	}

	/**
	 * �����������
	 * 
	 * @param ja
	 */
	public void update(JSONArray ja) {
		try {
			list = new ArrayList<JSONObject>();
			for (int i = 0; i < ja.length(); i++) {
				list.add(ja.getJSONObject(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		notifyDataSetChanged();
	}

	public void updateinfo(JSONObject ja) {
		try {
			list = new ArrayList<JSONObject>();
			list.add(ja);
		} catch (Exception e) {
			e.printStackTrace();
		}
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public JSONObject getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public abstract View getView(int position, View convertView, ViewGroup parent);

	public JSONArray getList() {
		JSONArray array = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			array.put(list.get(i));
		}
		return array;
	}
}