package com.cd.chenplayview.Danmaku;

import android.graphics.Color;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.danmaku.parser.android.JSONSource;
import master.flame.danmaku.danmaku.util.DanmakuUtils;

/**
 * 项目名称：IjKPlayer.
 * 创建人： CT.
 * 创建时间: 2017/4/24.
 * GitHub:https://github.com/CNHTT
 * A站弹幕解析器
 */

public class AcFunDanmakuParser extends BaseDanmakuParser {
    @Override
    protected IDanmakus parse() {

        if (mDataSource != null && mDataSource instanceof JSONSource)
        {
            JSONSource jsonSource = (JSONSource) mDataSource;
            return doParse(jsonSource.data());
        }
        return null;
    }

    /**
     * 传入的弹幕数据
     * @param data
     * @return
     */
    private Danmakus doParse(JSONArray data) {
        Danmakus danmakus = new Danmakus();

        if (data == null|| data .length() ==0)
        {
            return danmakus;
        }
        for (int i=0;i< data.length();i++){
            try {
                JSONObject danmakuArray = data.getJSONObject(i);
                if (danmakuArray!=null){
                    danmakus = _parse(danmakuArray,danmakus);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return danmakus;
    }

    private Danmakus _parse(JSONObject jsonObject, Danmakus danmakus) {
        if (danmakus == null)
            danmakus = new Danmakus();
        if (jsonObject == null || jsonObject.length() == 0)
            return danmakus;
        for (int i = 0; i <jsonObject.length() ; i++) {

            JSONObject obj = jsonObject;
            try {
                String c = obj.getString("c");
                String[] values = c.split(",");
                if (values.length>0)
                {
                    int type = Integer.parseInt(values[2]);  //弹幕类型

                    if (type==7)
                        continue;

                    long time = (long) (Float.parseFloat(values[0]) * 1000); // 出现时间

                    int color = Integer.parseInt(values[1]) | 0xFF000000; // 颜色

                    float textSize = Float.parseFloat(values[3]); // 字体大小

                    BaseDanmaku item = mContext.mDanmakuFactory.createDanmaku(type,mContext);
                    if (item!=null)
                    {
                        item.setTime(time);
                        item.textSize = textSize * (mDispDensity - 0.6f);
                        item.textColor = color;
                        item.textShadowColor = color <= Color.BLACK ? Color.WHITE : Color.BLACK;
                        DanmakuUtils.fillText(item, obj.optString("m", "...."));
                        item.index = i;
                        item.setTimer(mTimer);
                        danmakus.addItem(item);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return danmakus;
    }
}
