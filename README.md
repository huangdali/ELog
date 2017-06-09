# ELog  [![](https://jitpack.io/v/huangdali/ELog.svg)](https://jitpack.io/#huangdali/ELog)

> E级别错误日志打印工具



## 带定位功能
- 输出调用处类型名、方法名、行
- 点击可追踪到调用处
- 可设置tag（不设置也是可以的）
- 可设置开关（总开关，分支开关）
- 可打印日志信息到sdcard中

## 导入
**Step 1.**  Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency

```
dependencies {
	        compile 'com.github.huangdali:ELog:v1.3.3'
	}
```

## 用法

```
    ELog.e("我是最简答的用法");
    ELog.e("tag1","我是带tag的用法");
    ELog.file("mylog.txt","我是打印的具体内容");//此时会在sdcard/ELog目录下生成mylog.txt文件
```

### 扩展用法

![](https://github.com/huangdali/ELog/blob/master/use.png)

### 打印日志到文件

![](https://github.com/huangdali/ELog/blob/master/file.png)


