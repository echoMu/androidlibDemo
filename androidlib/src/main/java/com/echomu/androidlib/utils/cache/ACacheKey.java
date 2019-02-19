package com.echomu.androidlib.utils.cache;

import android.content.Context;



/**
 * 缓存对应关键字
 *
 * @author ck
 * @since 2014年4月23日 10:25:40
 */
public class ACacheKey {

    // 缓存 key命名方式
    public static final String CACHE_XXX = "cache_xxx";

    // 帖子列表 key前缀
    public static final String CACHE_POSTLIST_ = "cache_postlist_";

    // 帖子发帖分类 key前缀
    public static final String CACHE_CLASSI_BEAN_ = "cache_classi_bean_";

    // 圈子发帖分类 key前缀
    public static final String CACHE_QUAN_CLASSIF = "cache_quan_classif";

    // 回复帖子 key前缀
    public static final String CACHE_REPLY_ = "cache_reply_";

    // 写同城帖子 key前缀
    public static final String CACHE_WRITE_ = "cache_write_";

    // 写圈子帖子 key前缀
    public static final String CACHE_CIRCLE_WRITE_ = "cache_circle_write_";

    // 我的动态 key前缀
    public static final String CACHE_NEWS_ = "cache_news_";

    // 首页热点广告 key前缀
    public static final String CACHE_HEADLINES_IMG_ = "cache_headlines_img_";

    // 首页热点列表 key前缀
    public static final String CACHE_HEADLINES_LIST_ = "cache_headlines_list_";

    // 我的信息 key前缀
    public static final String CACHE_MINE_INFO = "cache_mine_info";

    // 非买不可导航栏 key
    public static final String MUST_BUY_TAG_LIST = "must_buy_tag_list";

    // 圈子首页广场广告 key前缀
    public static final String CACHE_SQUARE_IMG_ = "cache_square_img";

    // 圈子首页广场帖子列表
//	public static final String CACHE_SQUARE_LIST = "cache_square_list";
    public static final String CACHE_SQUARE_LIST = "cache_square_list_new";

    public static final String CACHE_HOME_RECOMMEND = "cache_home_recommend";

    // 爱逛焦点图广告key
    public static final String AISHOPPING_FOCUSAD = "aishopping_focusad";

    // 爱逛列表key
    public static final String AISHOPPING_LISTDATA = "aishopping_listdata";

    // 发布活动 key前缀
    public static final String CACHE_POST_PART_ = "cache_post_part_";

    // 发现 key前缀
    public static final String CACHE_FIND_DATA = "cache_find_data";
    // 发现 key前缀，
    public static final String CACHE_FIND_DATA_V_6_3 = "cache_find_data_v_6_3";

    // 朋友数据 key前缀
    public static final String CACHE_FRI = "cache_friend";

    // 回顾活动帖子 key前缀
    public static final String CACHE_LOOKBACK_ = "cache_lookback_";

    //  活动评论 key前缀
    public static final String CACHE_COMMENT_ = "cache_comment_";

    // 头条发帖中的板块
    public static final String SUB_TYPE_PREFIX = "post_type_new_";

    //获取城市列表
    public static final String CACHE_CITY = "cache_city";
    //育儿
    public static final String PARENTING_HOME_CACHE = "parenting_home_cache";

    //闪屏广告
    public static final String CACHE_SPLASH_AD = "cache_splash_ad";

    //精选直播入口
    public static final String CACHE_LIVE_ENTER = "cache_live_enter";

    //获取求助贴缓存
    public static final String CAHCE_HELP_DETAIL = "cahe_help_detail";

    //缓存消息详情
    public static final String CAHCE_MESSAGE = "cahe_message_detail_";

    //网络白名单缓存
    public static final String CAHCE_WEBWHITE = "cahe_webWhite";

    //网络schema
    public static final String CAHE_WEBSCHEMA = "cahe_webschema";

    // 话题列表 key前缀
    public static final String CACHE_TOPICLIST_ = "cache_topiclist_";

    // 首页精选页上报url缓存
    public static final String CACHE_EXPOSURE_URL_LIST = "cache_exposure_url_list";

    // 精华合集点击缓存
    public static final String SUBJECT_ONCLICK_LIST = "subject_onclick_list";

//    public static String getCacheKey(Context context, String key) {
//        UserInfo userInfoUtil = UserInfo.instance(context);
//        return ACacheUtil.getCacheName(key, userInfoUtil.getmUid());
//    }
}
