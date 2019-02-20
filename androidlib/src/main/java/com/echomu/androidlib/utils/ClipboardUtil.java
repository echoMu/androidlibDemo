package com.echomu.androidlib.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * 剪切板相关工具类
 * @author echoMu
 * @date 2018/11/13
 */
public class ClipboardUtil {

    /**
     * 复制文本到剪贴板
     *
     * @param text 文本
     */
    public static void copyText(Context context, final CharSequence text) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.setPrimaryClip(ClipData.newPlainText("text", text));
    }

    /**
     * 获取剪贴板的文本
     *
     * @return 剪贴板的文本
     */
    public static CharSequence getText(Context context) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        ClipData clip = cm.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            return clip.getItemAt(0).coerceToText(context);
        }
        return null;
    }

    /**
     * 复制uri到剪贴板
     *
     * @param uri uri
     */
    public static void copyUri(Context context, final Uri uri) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.setPrimaryClip(ClipData.newUri(context.getContentResolver(), "uri", uri));
    }

    /**
     * 获取剪贴板的uri
     *
     * @return 剪贴板的uri
     */
    public static Uri getUri(Context context) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        ClipData clip = cm.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            return clip.getItemAt(0).getUri();
        }
        return null;
    }

    /**
     * 复制意图到剪贴板
     *
     * @param intent 意图
     */
    public static void copyIntent(Context context, final Intent intent) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        cm.setPrimaryClip(ClipData.newIntent("intent", intent));
    }

    /**
     * 获取剪贴板的意图
     *
     * @return 剪贴板的意图
     */
    public static Intent getIntent(Context context) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        //noinspection ConstantConditions
        ClipData clip = cm.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            return clip.getItemAt(0).getIntent();
        }
        return null;
    }

    /**
     * 复制黏贴
     */
    public static void copyContext(Context mContext, String text){
        try {
            ClipboardManager clipboard = (ClipboardManager)
                    mContext.getSystemService(Context.CLIPBOARD_SERVICE);
            if(clipboard!=null){
                ClipData clip = ClipData.newPlainText("code",text);
                if(clip!=null){
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(mContext,"复制成功", Toast.LENGTH_SHORT).show();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 复制黏贴
     */
    public static void shareCopyContext(Context mContext, String text){
        try {
            ClipboardManager clipboard = (ClipboardManager)
                    mContext.getSystemService(Context.CLIPBOARD_SERVICE);
            if(clipboard!=null){
                ClipData clip = ClipData.newPlainText("code",text);
                if(clip!=null){
                    clipboard.setPrimaryClip(clip);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
