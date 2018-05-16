# AndroLua+ ![author](https://img.shields.io/badge/author-duangsuse-green.svg?style=flat-square) ![lang](https://img.shields.io/badge/language-luna-blue.svg?style=flat-square) ![ci](https://img.shields.io/badge/build-manual_tested-red.svg?style=flat-square)

Lua __5.3__ for __Android__ __Pro__, modified by duangsuse to make a *disturbed* Androlua+

## About

`Androlua+` 是原作者使用至少 *两年* 时间在手机上用 *AIDE* 完成的

`Androluna` 是以上的一个 *亚种*，目标是让 Androlua 维护程度更高，_IntelliJ IDEA x Lua plugin/JetBrains CLion_ 强力驱动开发

某些看着 `Androlua` 而起步的手机脚本软件开发平台直接抄袭套用 `Androlua+` 项目的源代码，虽然这合乎 *MIT* 许可证，也请他们尊重一点开源项目的道德。处处占便宜的人 *不配* 享受诚实开放的好处

> NOTE：即使是这样，作者的部分作法也不是很好，别如直接把第三方库源代码复制粘贴过来任意修改（一般应该使用依赖管理）

> 这给 `AndroLua+ 3.1.0` 的更新增加了难度。不过首先在这里 __duangsuse 维护的__ `Androluna` 不会在意与之前 __Nirenr__ 版本的 __兼容问题__

> 另外 duangsuse 也没有太多时间维护这个项目，毕竟 [GeekApk](https://geekapk.org) 依然在开发中

## Updates

### ﻿2.0
+ 更新 Lua _5.3.1_
+ 更新 luajava 3.0
+ 增加打包 apk 功能
+ 增加布局表
+ 增加线程
+ 增加更多回调方法
+ 更新支持高亮/自动缩进/自动补全编辑器

### 2.0.1
+ 布局表增加自绘制背景
+ 修复自动缩进算法错误
+ 增加百度广告，仅在打包时出现，不影响使用，希望大家支持
> Comment by duangsuse：但是我没有发现广告（为啥呢，请看 __2.1.0__ 更新记录）

### 2.0.2
+ 增加 getter 与 setter 快速调用，用于简化控件属性设置
> Comment by duangsuse：Lite 程序设计语言里也有这种写法，升级版本可能支持更多这种写法
+ 修复 Java 方法返回 null 没有返回值的 bug
+ 更新布局表算法，支持布局间距
+ 优化 Java _方法缓存_ 机制，效率提高一倍，布局表效率提高 *8* 倍
> Comment by duangsuse：这是在 _Luajava_ 上的优化，缓存了更多内部所需要 Java _方法 ID_

### 2.0.3
+ 修复 IDE 布局 bug

### 2.0.4
+ 增加 `luajava.astable` 方法
+ 增加 each 与 enum 迭代器
+ 布局表支持相对布局
+ 布局表 gravity 属性支持或 `|` 操作
+ 优化 IDE 逻辑

### 2.1.0
+ 去除广告，欢迎捐赠
> Comment by duangsuse：加入作者的付费群也可以
+ 修复接口方法错误无法显示错误信息的问题
+ 修复 `import` 函数一处逻辑错误
+ 修复 `onKeyDown` 等回调方法不能返回值的 bug
+ 优化 luajava 性能
+ 优化 IDE 编辑器性能
+ 修复 IDE 打开文件 bug
+ 增加 `setFooListener` 控件事件快速设置
+ 重写 `task` 与 `thread` 函数
+ 增加 `timer` 函数
+ 修复数字类型转换 bug
+ 增加查看 LogCat 输出功能
> Comment by duangsuse：或许这个功能依然没做好，大家看着办吧。我不会管这个功能
+ 布局表支持绝对布局
+ 布局表支持 `ListView` 预设项目
+ 布局表支持 style 属性
+ 布局表支持 `?android` 获取系统资源
+ 修复 `luajava.astable` 索引 0 的 bug
+ IDE 增加函数导航
+ IDE 增加搜索与转到

### 3.0.0
+ 支持打包 apk 的权限配置
+ 增加 Map 对象的简洁使用
+ 完善 `luajava.astable` 函数全面支持 `Object[] List Map`
+ 增加在方法调用时 Lua 表自动转换为 Java 数组或接口
+ 增加 `LuaArrayAdapter` 和 `LuaAdapter` 适配器
+ `LuaWebView` 支 `WebClient` 在 JavaScript 调用 Lua 函数
+ `timer` 支持设置时间间隔
+ `newActivity` 支持传递参数
+ `http` 增加 `download` 和 `upload`
+ 日志支持清除
+ Java 方法支持 table 与 `ArrayMap` 与 `Interface` 自动转换
+ 增强取长度运算符可以获取 Java 对象大小
+ 更换运行方式
+ 支持打包文件夹
+ 打包自动分析使用的 C 模块
> NOTE：就是自动选择是否添加某依赖库
+ 增加 `tointeger` 函数
+ `setContentView` 支持布局表参数

### 3.1.0
+ 化 `luajava` 错误提示
+ 增加工程导出/导入
+ 修复打开文件的 bug
+ 增加后台服务
+ 优化错误提示
+ 修复类型转换 bug
+ 增加导入 dex 函数
+ 增加布局设计器
+ 代码结构调整
+ 增加 `List` 对象快速访问
+ `newActivity` 支持指定切换动画
+ 优化 IDE 编辑器对 tab 绘制效果
+ 优化 IDE 界面及逻辑
+ 布局文件结构调整
+ `LuaArrayAdapter` 适配器支持布局表定义视图
+ 增加 `View` 类免 `Context` 参数构建
+ 增加 `LuaContext` 接口
+ 修复 *6.0* 不能打包的 bug
+ IDE 增加符号栏

### 3.1.1
+ 使用最新的 Gradle 管理项目
+ 格式化代码
+ Markdown 化文档
+ 修复构建

## 关于

[AndroLua](https://androlua.com) 是基于 [LuaJava](https://github.com/nirenr/luajava) 开发的安卓平台轻量级脚本编程语言工具，既具有 [Lua](https://lua.org) 简洁优雅的特质，又支持绝大部分安卓 API ，可以使你在手机上 *快速编写小型应用。*

官方 QQ 群： __236938279__ [官方 QQ 群 1 链接](http://jq.qq.com/?_wv=1027&k=dcofRr)

百度贴吧： [官方贴吧链接](http://c.tieba.baidu.com/mo/m?kw=androlua)

项目地址： [SourceForge 链接](http://sf.net/p/androlua)

> NOTE：[GitHub](https://github.com/nirenr/Androlua_pro) 上也有一份 *Git* 管理的源代码

点击链接支持我的工作，一块也可以哦： [AliPay 链接](https://qr.alipay.com/apt7ujjb4jngmu3z9a)

本程序使用了以下开源项目部分代码

+ bson/crypt/md5
https://github.com/cloudwu/skynet

+ cjson
https://sourceforge.net/projects/cjson/

+ zlib
https://github.com/brimworks/lua-zlib

+ xml
https://github.com/chukong/quick-cocos2d-x

+ luv
https://github.com/luvit/luv
https://github.com/clibs/uv

+ zip
https://github.com/brimworks/lua-zip
https://github.com/julienr/libzip-android

+ luagl
http://luagl.sourceforge.net/

+ luasocket
https://github.com/diegonehab/luasocket

+ sensor
https://github.com/ddlee/AndroidLuaActivity

+ canvas
由落叶似秋开发

+ jni
由 [nirenr](https://github.com/nirenr) 开发
> Comment by duangsuse：这里说的是 LuaJava 和以上的那些库的 JNI 接口


## 与标准 __Lua 5.3.1__ 的不同

+ 打开了部分兼容选项： `module/unpack/bit32`
+ 添加 `string.gfind` 函数，用于递归返回匹配位置
+ 增加 `tointeger` 函数，强制将数值转为整数
+ 修改 `tonumber` 支持转换 Java 对象

## 小型文档

已经移动到 [DOC.md](DOC.md)，不适合在项目的 __README__ 里存放太多信息


## LICENSE

*Copyright (C)* 2015-2016 by __Nirenr__

*Copyright (C)* 2018 __duangsuse__

```plain
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
