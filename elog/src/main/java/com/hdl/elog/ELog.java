package com.hdl.elog;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * E级别错误日志打印工具，带定位功能（输出调用处类型名、方法名、行，点击可追踪到）
 * Created by HDL on 2017/5/4.
 */

public class ELog {
    /**
     * 是否是debug模式----总开关
     */
    private static boolean isDebug = true;

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void e(Object msg) {
        if (!isDebug) {
            return;
        }
        printMsg(getStackTrace(), "", msg.toString());
    }

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void e(String tag, Object msg) {
        if (!isDebug) {
            return;
        }
        printMsg(getStackTrace(), tag, msg.toString());
    }

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void file(String fileName, String msg) {
        if (!isDebug) {
            return;
        }
        printMsgToFile(getStackTrace(), fileName, msg);
    }

    /**
     * 获取StackTraceElement对象-----当前调用ELog.e()处的类信息（类名、方法名、行等）
     *
     * @return
     */
    private static StackTraceElement getStackTrace() {
        return Thread.currentThread().getStackTrace()[4];
    }

    /**
     * 设置是否打印e方法的日志
     *
     * @param isDebug
     */
    public static void setIsDebug(boolean isDebug) {
        ELog.isDebug = isDebug;
    }

    /**
     * 打印日志
     *
     * @param element 当前调用ELog.e()处的类信息（类名、方法名、行等）
     * @param msg
     */
    private static void printMsg(StackTraceElement element, String tag, String msg) {
        msg = msg.replace("(", "（").replace(")", "）");//替换()为中文，防止冲突
        StringBuilder sb = new StringBuilder();
//        String className = traceElement.getClassName();//暂时不需要类名
        String fileName = element.getFileName();
        sb.append(element.getMethodName())
                .append("(").append(fileName).append(":")
                .append(element.getLineNumber())
                .append(")");
        String lTag = (TextUtils.isEmpty(tag) ? "" : (tag + ":")) + sb.toString();
        Log.e(lTag, msg);
    }

    /**
     * 打印日志到文件
     *
     * @param element  当前调用ELog.e()处的类信息（类名、方法名、行等）
     * @param fileName
     * @param msg
     */
    private static void printMsgToFile(StackTraceElement element, String fileName, String msg) {
        StringBuilder sb = new StringBuilder();
        String className = element.getFileName();
        sb.append(element.getMethodName())
                .append(" (").append(className).append(":")
                .append(element.getLineNumber())
                .append(") ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        String content = "-----------------------   " +
                format.format(new Date(System.currentTimeMillis()))
                + "   -----------------------\n" + sb.toString() + "\n" +
                msg + "\n\n\n";
        File dir = new File(Environment.getExternalStorageDirectory().getPath() + "/ELog/");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(dir.getPath() + "/" + fileName + ".txt", true);
            fos.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
