package com.hdl.elog;

import android.os.Environment;
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
     * 是否是debug模式----段雪松
     */
    private static boolean isDebugDxs = true;

    /**
     * 是否是debug模式----方乐
     */
    private static boolean isDebugFl = true;

    /**
     * 是否是debug模式----朱喜莹
     */
    private static boolean isDebugZxy = true;

    /**
     * 是否是debug模式----黄大力
     */
    private static boolean isDebugHdl = true;

    /**
     * 打印错误信息
     *
     * @param msg 不推荐使用，可以用自己的方法
     */
    public static void e(String msg) {
        if (!isDebug) {
            return;
        }
        printMsg(getStackTrace(), msg, "");
    }

    /**
     * 打印错误信息
     *
     * @param msg 不推荐使用，可以用自己的方法
     */
    public static void e(String tag, String msg) {
        if (!isDebug) {
            return;
        }
        printMsg(getStackTrace(), msg, "");
    }

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void hdl(String msg) {
        if (!isDebug) {
            return;
        }
        if (!isDebugHdl) {
            return;
        }
        printMsg(getStackTrace(), msg, "HDL");
    }

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void hdl(String tag, String msg) {
        if (!isDebug) {
            return;
        }
        if (!isDebugHdl) {
            return;
        }
        printMsg(getStackTrace(), "[ " + tag + " ] " + msg, "HDL");
    }

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void fl(String msg) {
        if (!isDebug) {
            return;
        }
        if (!isDebugFl) {
            return;
        }
        printMsg(getStackTrace(), msg, "FL");
    }

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void fl(String tag, String msg) {
        if (!isDebug) {
            return;
        }
        if (!isDebugFl) {
            return;
        }
        printMsg(getStackTrace(), "[ " + tag + " ] " + msg, "FL");
    }

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void dxs(String msg) {
        if (!isDebug) {
            return;
        }
        if (!isDebugDxs) {
            return;
        }
        printMsg(getStackTrace(), msg, "DXS");
    }

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void dxs(String tag, String msg) {
        if (!isDebug) {
            return;
        }
        if (!isDebugDxs) {
            return;
        }
        printMsg(getStackTrace(), "[ " + tag + " ] " + msg, "DXS");
    }

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void zxy(String msg) {
        if (!isDebug) {
            return;
        }
        if (!isDebugZxy) {
            return;
        }
        printMsg(getStackTrace(), msg, "ZXY");
    }

    /**
     * 打印错误信息
     *
     * @param msg
     */
    public static void zxy(String tag, String msg) {
        if (!isDebug) {
            return;
        }
        if (!isDebugZxy) {
            return;
        }
        printMsg(getStackTrace(), "[ " + tag + " ] " + msg, "ZXY");
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
     * 设置是否打印dxs方法的日志
     *
     * @param isDebugDxs
     */
    public static void setIsDebugDxs(boolean isDebugDxs) {
        ELog.isDebugDxs = isDebugDxs;
    }

    /**
     * 设置是否打印fl方法的日志
     *
     * @param isDebugFl
     */
    public static void setIsDebugFl(boolean isDebugFl) {
        ELog.isDebugFl = isDebugFl;
    }

    /**
     * 设置是否打印zxy方法的日志
     *
     * @param isDebugZxy
     */
    public static void setIsDebugZxy(boolean isDebugZxy) {
        ELog.isDebugZxy = isDebugZxy;
    }

    /**
     * 设置是否打印hdl方法的日志
     *
     * @param isDebugHdl
     */
    public static void setIsDebugHdl(boolean isDebugHdl) {
        ELog.isDebugHdl = isDebugHdl;
    }

    /**
     * 打印日志
     *
     * @param element 当前调用ELog.e()处的类信息（类名、方法名、行等）
     * @param msg
     * @param author
     */
    private static void printMsg(StackTraceElement element, String msg, String author) {
        StringBuilder sb = new StringBuilder();
//        String className = traceElement.getClassName();//暂时不需要类名
        String fileName = element.getFileName();
        sb.append(element.getMethodName())
                .append(" (").append(fileName).append(":")
                .append(element.getLineNumber())
                .append(") ");
        String tag = author + "-" + sb.toString();
        Log.e(tag, msg);
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
            fos = new FileOutputStream(dir.getPath()+"/" + fileName, true);
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
