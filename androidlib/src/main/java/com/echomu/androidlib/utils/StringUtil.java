package com.echomu.androidlib.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 *     author : echoMu
 *     e-mail :
 *     time   : 2017/11/07
 *     desc   :
 *     version:
 * </pre>
 */
public class StringUtil {

    /*****************************     字符串操作        ***********************************/

    /**
     * 判断字符串是否非空非null
     *
     * @param strParm 需要判断的字符串
     * @return 真假
     */
    public static boolean isNoBlankAndNoNull(String strParm) {
        return !((strParm == null) || (strParm.equals("")));
    }

    /**
     * 将流转成字符串
     *
     * @param is 输入流
     * @return
     * @throws Exception
     */
    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    /**
     * 将文件转成字符串
     *
     * @param file 文件
     * @return
     * @throws Exception
     */
    public static String getStringFromFile(File file) throws Exception {
        FileInputStream fin = new FileInputStream(file);
        String ret = convertStreamToString(fin);
        // Make sure you close all streams.
        fin.close();
        return ret;
    }

    /**
     * 去除list重复数据
     *
     * @param list
     * @return
     */
    public static List<String> removeDuplicate(List<String> list) {
        Set<String> set = new HashSet<String>();
        List<String> newList = new ArrayList<String>();
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            String element = (String) iter.next();
            if (set.add(element))
                newList.add(element);
        }
        return newList;
    }

    /**
     * 读取Assets文件内容，输出字符串
     *
     * @param fileName
     * @return
     */
    public static String getFromAssets(Context context, String fileName) {
        try {
            InputStreamReader inputReader = new InputStreamReader(context.getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            String Result = "";
            while ((line = bufReader.readLine()) != null)
                Result += line;
            return Result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 验证手机号码， 仅做开头为1与长度11的验证 (为羊城派特地加入 3和9开头的账号)
     * <p>
     * （支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     * </p>
     *
     * @param mobile 移动、联通、电信运营商的号码段
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkMobile4ycp(String mobile) {
        if (!isNoBlankAndNoNull(mobile)) {
            return false;
        }
        String regex = "(\\+\\d+)?[1|3|9]\\d{10}$";
        return Pattern.matches(regex, mobile);
    }

    /**
     * 验证Email
     *
     * @param email email地址，格式：zhangsan@zuidaima.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkEmail(String email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    /**
     * 验证身份证号码
     *
     * @param identityNumber
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkIdentityNumber(String identityNumber) {
        String regex = "(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])";
        return Pattern.compile(regex).matcher(identityNumber).matches();
    }

    /**
     * 获取P标签数组
     *
     * @param htmlStr
     * @return
     */
    public static String getPTags(String htmlStr) {
        String regEx_p = "<p[^>]*?>[\\s\\S]*?</p>\n";

        Pattern p_p = Pattern.compile(regEx_p, Pattern.CASE_INSENSITIVE);
        Matcher m_p = p_p.matcher(htmlStr);
        htmlStr = m_p.replaceAll(""); //过滤p标签

        return htmlStr.trim(); //返回文本字符串
    }

    /**
     * 使用正则表达式删除HTML标签
     *
     * @param htmlStr
     * @return
     */
    public static String clearHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); //过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); //过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); //过滤html标签

        htmlStr = htmlStr.replace("&nbsp;", " "); //过滤&nbsp标签

        return htmlStr.trim(); //返回文本字符串
    }

}
