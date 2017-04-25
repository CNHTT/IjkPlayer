package com.cd.chenplayview.Danmaku;

/**
 * 项目名称：IjKPlayer.
 * 创建人： CT.
 * 创建时间: 2017/4/24.
 * GitHub:https://github.com/CNHTT
 */

public abstract class BaseDanmakuData {

    private
    @DanmakuType
    int type;
    private String content;
    private Long time;
    private float textSize;
    private int textColor;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    @Override
    public String toString() {
        return "BaseDanmakuData{" +
                "type=" + type +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", textSize=" + textSize +
                ", textColor=" + textColor +
                '}';
    }
}
