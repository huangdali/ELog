# ELog  [![](https://jitpack.io/v/huangdali/ELog.svg)](https://jitpack.io/#huangdali/ELog)

> E级别错误日志打印工具


## 带定位功能
- 打印任何类型（Object类型）的对象
- 输出调用处类型名、方法名、行
- 点击可追踪到调用处
- 可设置tag(方便过滤)
- 可设置开关(是否打印)
- 可打印日志信息到sdcard中

## 导入

## 方法一（JCenter）
Add the dependency

```java
dependencies {
	        compile 'com.hdl:elog:v2.0.2'
	}
```

## 方法二（JitPack方式）
**Step 1.**  Add it in your root build.gradle at the end of repositories:
```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency

```java
dependencies {
	        compile 'com.github.huangdali:ELog:v2.0.2'
	}
```

## 用法

```java
    ELog.e("我是最简答用法");
    ELog.e("tag","带tag用法");
    ELog.file("mylog.txt","我是打印的具体内容");//此时会在sdcard/ELog目录下生成mylog.txt文件
    ELog.setIsDebug(false);//关闭日志打印，默认为true
```


### 打印日志到文件

此时会在sdcard/ELog目录下生成{yourfilename}.txt文件

![](https://github.com/huangdali/ELog/blob/elogmaster/file.png)

### 使用演示

![](https://github.com/huangdali/ELog/blob/elogmaster/elog.gif)

### 历史版本
- 2.0.2

【修复】tag失效

- 2.0.1

正式版发布