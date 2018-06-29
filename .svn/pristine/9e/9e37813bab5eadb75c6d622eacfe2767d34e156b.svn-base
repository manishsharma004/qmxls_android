package com.example.niu.myapplication.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class Hint {
	
	private static Toast toast = null;

	/**
	 * ��ͨ�ı���Ϣ��ʾ
	 * 
	 * @param context
	 * @param text
	 * @param duration
	 */
	public static void Short(Context context, CharSequence text) {
		// ����һ��Toast��ʾ��Ϣ
		toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		// ����Toast��ʾ��Ϣ����Ļ�ϵ�λ��
		//toast.setGravity(Gravity.BOTTOM, 0, (int)(Tools.getWindowHeight(context)*0.1));
		// ����Toast��ʾ����Ļ�м�
		toast.setGravity(Gravity.CENTER, 0, 0);
		// ��ʾ��Ϣ
		toast.show();
	}
}
