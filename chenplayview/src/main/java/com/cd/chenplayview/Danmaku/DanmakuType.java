package com.cd.chenplayview.Danmaku;

import android.support.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static master.flame.danmaku.danmaku.model.BaseDanmaku.TYPE_FIX_BOTTOM;
import static master.flame.danmaku.danmaku.model.BaseDanmaku.TYPE_FIX_TOP;
import static master.flame.danmaku.danmaku.model.BaseDanmaku.TYPE_SCROLL_RL;


/**
 * 项目名称：IjKPlayer.
 * 创建人： CT.
 * 创建时间: 2017/4/24.
 * GitHub:https://github.com/CNHTT
 */

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@IntDef({TYPE_SCROLL_RL, TYPE_FIX_TOP, TYPE_FIX_BOTTOM})
public @interface DanmakuType {
}
