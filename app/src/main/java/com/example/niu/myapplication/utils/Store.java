package com.example.niu.myapplication.utils;

import java.util.Map;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Store {
	private SharedPreferences sp;
	private Editor editor;

	public static Store init(Context context, String name, int mode) {
		return new Store(context, name, mode);
	}

	/**
	 * ���췽����
	 * 
	 * @param context
	 * @param kvName
	 *            ��ֵ�����ơ�
	 * @param mode
	 *            �򿪵�ģʽ��ֵΪContext.MODE_APPEND, Context.MODE_PRIVATE,
	 *            Context.WORLD_READABLE, Context.WORLD_WRITEABLE.
	 */
	private Store(Context context, String name, int mode) {
		sp = context.getSharedPreferences(name, mode);
		editor = sp.edit();
	}

	/**
	 * ��ȡ�����ŵ�boolean����
	 *
	 * @param key
	 *            ����
	 * @param value
	 *            ��������ʱ���ص�Ĭ��ֵ��
	 * @return ���ػ�ȡ����ֵ����������ʱ����Ĭ��ֵ��
	 */
	public boolean getBoolean(String key, boolean value) {
		return sp.getBoolean(key, value);
	}

	public boolean getBoolean(String key) {
		return getBoolean(key, false);
	}

	/**
	 * ��ȡ�����ŵ�int����
	 * 
	 * @param key
	 *            ����
	 * @param value
	 *            ��������ʱ���ص�Ĭ��ֵ��
	 * @return ���ػ�ȡ����ֵ����������ʱ����Ĭ��ֵ��
	 */
	public int getInt(String key, int value) {
		return sp.getInt(key, value);
	}

	public int getInt(String key) {
		return getInt(key, 0);
	}

	/**
	 * ��ȡ�����ŵ�long����
	 * 
	 * @param key
	 *            ����
	 * @param value
	 *            ��������ʱ���ص�Ĭ��ֵ��
	 * @return ���ػ�ȡ����ֵ����������ʱ����Ĭ��ֵ��
	 */
	public long getLong(String key, long value) {
		return sp.getLong(key, value);
	}

	public long getLong(String key) {
		return getLong(key, 0);
	}

	/**
	 * ��ȡ�����ŵ�float����
	 * 
	 * @param key
	 *            ����
	 * @param value
	 *            ��������ʱ���ص�Ĭ��ֵ��
	 * @return ���ػ�ȡ����ֵ����������ʱ����Ĭ��ֵ��
	 */
	public float getFloat(String key, float value) {
		return sp.getFloat(key, value);
	}

	public float getFloat(String key) {
		return getFloat(key, 0);
	}

	/**
	 * ��ȡ�����ŵ�String����
	 * 
	 * @param key
	 *            ����
	 * @param value
	 *            ��������ʱ���ص�Ĭ��ֵ��
	 * @return ���ػ�ȡ����ֵ����������ʱ����Ĭ��ֵ��
	 */
	public String getString(String key, String value) {
		return sp.getString(key, value);
	}

	public String getString(String key) {
		return getString(key, null);
	}

	/**
	 * ��ȡ���м�ֵ�ԡ�
	 * 
	 * @return ��ȡ����������ֵ�ԡ�
	 */
	public Map<String, ?> getAll() {
		return sp.getAll();
	}

	/**
	 * ����һ����ֵ�ԣ�������{@linkplain #commit()}������ʱ���档<br/>
	 * ע�⣺�������value����boolean, byte(�ᱻת����int����),int, long, float,
	 * String������ʱ����������toString()��������ֵ�ı��档
	 * 
	 * @param key
	 *            �����ơ�
	 * @param value
	 *            ֵ��
	 * @return ���õ�KV����
	 */
	public Store put(String key, Object value) {
		if (value instanceof Boolean) {
			editor.putBoolean(key, (Boolean) value);
		} else if (value instanceof Integer || value instanceof Byte) {
			editor.putInt(key, (Integer) value);
		} else if (value instanceof Long) {
			editor.putLong(key, (Long) value);
		} else if (value instanceof Float) {
			editor.putFloat(key, (Float) value);
		} else if (value instanceof String) {
			editor.putString(key, (String) value);
		} else {
			editor.putString(key, value.toString());
		}
		return this;
	}

	/**
	 * �Ƴ���ֵ�ԡ�
	 * 
	 * @param key
	 *            Ҫ�Ƴ��ļ����ơ�
	 * @return ���õ�KV����
	 */
	public Store remove(String key) {
		editor.remove(key);
		return this;
	}

	/**
	 * ������м�ֵ�ԡ�
	 * 
	 * @return ���õ�KV����
	 */
	public Store clear() {
		editor.clear();
		return this;
	}

	/**
	 * �Ƿ����ĳ������
	 * 
	 * @param key
	 *            ��ѯ�ļ����ơ�
	 * @return ���ҽ��������ü�ʱ����true, ���򷵻�false.
	 */
	public boolean contains(String key) {
		return sp.contains(key);
	}

	/**
	 * �����Ƿ��ύ�ɹ���
	 * 
	 * @return ���ҽ����ύ�ɹ�ʱ����true, ���򷵻�false.
	 */
	public boolean commit() {
		return editor.commit();
	}
}