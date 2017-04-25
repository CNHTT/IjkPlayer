package com.cd.chenplayview.Danmaku;

import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.FBDanmaku;
import master.flame.danmaku.danmaku.model.FTDanmaku;
import master.flame.danmaku.danmaku.model.R2LDanmaku;

import static master.flame.danmaku.danmaku.model.BaseDanmaku.TYPE_SCROLL_RL;
/**
 * 项目名称：IjKPlayer.
 * 创建人： CT.
 * 创建时间: 2017/4/24.
 * GitHub:https://github.com/CNHTT
 *
 * 弹幕转换器，用来进行自定义数据和弹幕的转换
 */

public abstract class  BaseDanmakuConverter <T extends BaseDanmakuData> {
    public  abstract  T convertDanmaku(BaseDanmaku danmaku);

    protected void initData(T data ,BaseDanmaku danmaku){
        int danmakuType = TYPE_SCROLL_RL;
        if (danmaku instanceof R2LDanmaku){
            danmakuType = BaseDanmaku.TYPE_SCROLL_RL;
        }else if (danmaku instanceof FBDanmaku){
            danmakuType = BaseDanmaku.TYPE_FIX_BOTTOM;
        }else if (danmaku instanceof FTDanmaku){
            danmakuType = BaseDanmaku.TYPE_FIX_TOP;
        }
        data.setType(
                danmakuType
        );

        data.setContent(danmaku.text.toString());

        data.setTime(danmaku.getTime());

        data.setTextSize(danmaku.textSize);

        data.setTextColor(danmaku.textColor);


    }
}
