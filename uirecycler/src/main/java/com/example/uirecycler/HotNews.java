package com.example.uirecycler;

/**
 * 各种资源id的实体
 */
public class HotNews {
    /**
     * 标题id
     */
    int news_id;

    /**
     * 图片id
     */
    int img_id;

    /**
     * 热度图片id
     */
    int hot_img_id;

    /**
     * 分享图片id
     */
    int share_img_id;

    /**
     * 热度值
     */
    int hot;

    /**
     * 分享值
     */
    int share;


    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public int getHot_img_id() {
        return hot_img_id;
    }

    public void setHot_img_id(int hot_img_id) {
        this.hot_img_id = hot_img_id;
    }

    public int getShare_img_id() {
        return share_img_id;
    }

    public void setShare_img_id(int share_img_id) {
        this.share_img_id = share_img_id;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }
}
