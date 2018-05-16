## 1. 参考链接

关于 Lua 的语法和 Android API 请参考以下网页。

[Lua 官网](http://www.lua.org) | [Android 中文 API](http://android.toolib.net/reference/packages.html)

## 2. 导入模块

在每个脚本程序的开头 *应该* 写上 `require "import"` 以导入 `import` 模块，降低代码的复杂度。

目前程序内置 __bson,canvas,cjson,crypt,ftp,gl,http,import,md5,smtp,socket,sensor,xml,zip,zlib__ 库。

## 3. 导入包或类

可以导入包或者类

```lua
import "android.widget.*"
import "android.widget.Button"
```

导入内部类

`import "android.view.View_*"`

或

`import "android.view.View_OnClickListener"`

或

`View.OnClickListener`

包名和类名 *必须* 用引号包围（他们只是 Lua 函数）。

## 4. 创建布局与组件

```lua
layout = LinearLayout(activity)
activity.setContentView(layout)
button = Button(activity)
layout.addView(button)
-- 注. activity 是当前窗口的 Context 对象，如果习惯只需要写 this
-- Comment by duangsuse: 这个分支也可以写 ctx
this = activity
button = Button(this)
```

## 5. 使用方法

`button.setText("按钮")`

> getter/setter

Java 的 `getFoo` 方法没有参数与 `setFoo` 方法只有一个参数时可以简写。

```lua
button.Text = "按钮" -- implicit call to button.setText('按钮')
x = button.X -- equals to x = button.getX()
```

## 6 使用事件

创建事件处理函数

```
function click(s)
  print("点击")
end
```

把函数添加到事件接口

`listener = View.OnClickListener {onClick = click}`

把接口注册到组件

`button.setOnClickListener(listener)`

也可以使用匿名函数(LuaFunction)

```
button.setOnClickListener(View.OnClickListener {onClick = function(s)
  print("点击")
end
})
```
    
`onFoo` 事件可以简写

```lua
button.onClick=function(v)
  print(v)
end
```

## 7. 回调方法

```lua
function onResume()
  print("返回程序")
end
function onDestroy()
  print("程序已退出")
end
function onCreateOptionsMenu(menu)
  menu.add("菜单")
end
```

支持覆盖

`onCreate,onStart,onResume,onPause,onStop,onDestroy`

`onActivityResult,onCreateOptionsMenu,onCreateContextMenu,onMenuItemSelected`

回调方法

## 8. 按键与触控

```lua
function onKeyDown(code,event)
  print(code, event)
end
function onTouchEvent(event)
  print(event)
end    
```

支持覆盖 `onKeyDown,onKeyUp,onKeyLongPress,onTouchEvent` 方法

函数 *必须* 返布尔值

## 9. 使用数组

`array = float {1, 2, 3}`

或者

```lua
array = int[10]
a = array[0]
array[0] = 4
```

## 10. 使用线程

需导入 `import` 模块，参看 `thread,timer` 与 `task` 函数说明

+ 任务

`task(str, args, callback)`

`str` 为任务执行代码，`args` 为参数，`callback` 为回调函数，任务返回值将传递到回调方法

+ 线程

`t = thread(str, args)`

`str` 为线程中执行的代码，`args` 为初始传入参数

+ 调用线程中方法

`call(t, fn, args)`

`t` 为线程，`fn` 为方法对象标识符，`args` 为参数

+ 设置线程变量

`set(t, fn, arg)`

`t` 为线程，`fn` 为变量名称，`arg` 为变量值

+ 线程调用主线程中方法

`call(fn, args)`

`fn` 为方法名称，`args` 为参数

线程设置主线程变量

`set(fn, arg)`

`fn` 为变量名称，`arg` 为变量值

> 注. 参数类型为 字符串，数值， Java 对象，布尔值与 nil

> 线程要使用 quit() 结束线程。

`t = timer(func, delay, period, args)`

`func` 为定时器执行的函数，`delay` 为定时器延时，`period` 为定时器间隔，`args` 为初始化参数

`t.Enable = false` 暂停定时器

`t.Enable = true` 启动定时器

`t.stop()` 停止定时器

> 注意：定时器函数定义 run 函数时定时器重复执行 run 函数，否则重复执行构建时的 func 函数

## 11. 使用布局表

使用布局表须导入 `android.view` 与 `android.widget` 包。

```lua
require "import"
import "android.widget.*"
import "android.view.*"
```

布局表格式

```lua
layout = {
  控件名称,
  id = 控件名称,
  属性 = 值,
  {
    子控件名称,
    id = 控件名称,
    属性 = 值
  }
}
```

> Tips: 在 Luna 中还可以使用 `{ a: b }`，与 `{ a = b }` 等价 

布局表支持 *全部* 安卓控件属性

与安卓 XML 布局文件的不同点：

id 表示在 Lua 中变量的名称，而不是安卓的可以 findById 的数字 id。

`ImageView` 的 `src` 属性是当前目录图片名称或绝对文件路径图片或网络上的图片

`layout_width` 与 `layout_height` 的值支持 `fill` 与 `wrap`简写

`onClick` 值为 lua 函数或 Java `onClick` 接口或他们的全局变量名称

背景 `background` 支持背景图片，背景色与 `LuaDrawable` 自绘制背景，背景图片参数为是当前目录图片名称或绝对文件路径图片或网络上的图片

颜色同 `backgroundColor`，自绘制背景参数为绘制函数或绘制函数的全局变量名称

绘制函数形式

```lua
function draw(canvas,paint)
  canvas.drawRect(1, 1, 100, 100, paint)
end
```

控件背景色使用 `backgroundColor` 设置，值为十六进制颜色值。

其他参考 `loadlayout` 与 `loadbitmap` 具体实现

## 12. 2D 绘图

```lua
require "import"
import "android.app.*"
import "android.os.*"
import "android.widget.*"
import "android.view.*"
import "android.graphics.*"

activity.setTitle('AndroLua')

paint = Paint()
paint.setARGB(100, 0, 250, 0)
paint.setStrokeWidth(20)
paint.setTextSize(28)

sureface = SurfaceView(activity);
callback = SurfaceHolder_Callback {
  surfaceChanged = function(holder, format, width, height)
  end,
  surfaceCreated = function(holder)
    ca = holder.lockCanvas()
    if (ca ~= nil) then
      ca.drawRGB(0, 79, 90);
      ca.drawRect(0, 0, 200, 300, paint)
    end
    holder.unlockCanvasAndPost(ca)
  end,
  surfaceDestroyed = function(holder)
  end
}

holder = sureface.getHolder()
holder.addCallback(callback)
activity.setContentView(sureface)
```

## 13. Lua 类型与 Java 类型

在大多数情况下 Androlua 可以很好的处理 Lua 与 Java 类型之间的自动转换

但是 Java 的数值类型有多种 (`double,float,long,int,short,byte`) 而 Lua 只有 `number`，在必要的情况下可以使用类型的 __强制转换__。

`i = int(10)`

`i` 就是一个 Java 的 `int` 类型数值

`d = double(10)`

`d` 是一个 Java 的 `Double` 类型对象

在调用 Java 方法时 Androlua 可以自动将 Lua 的 `table` 转换成 Java 的 `Object[], Map` 或 `Interface`

`Map` 类型可以像使用 Lua 表一样简便

```lua
map = HashMap {a = 1, b = 2}
print(map.a)
map.a = 3
```

取长度运算符 `#` 可以获取 Java 中 `Object[], List, Map, Set, String` 的长度。


## 14. 部分模块

1. _canvas_ 模块

```lua
require "import"
import "android.app.*"
import "android.os.*"
import "android.widget.*"
import "android.view.*"
import "android.graphics.*" -- Android API

activity.setTitle('AndroLua')

paint = Paint()
paint.setARGB(100, 0, 250, 0)
paint.setStrokeWidth(20)
paint.setTextSize(28)

sureface = SurfaceView(activity);
callback = SurfaceHolder_Callback {
  surfaceChanged = function(holder, format, width, height)
  end,
  surfaceCreated = function(holder)
    local ca = holder.lockCanvas()
    if (ca ~= nil) then
      ca.drawRGB(0, 79, 90);
      ca.drawRect(0, 0, 200, 300, paint)
    end
    holder.unlockCanvasAndPost(ca)
  end,
  surfaceDestroyed = function(holder)
  end
}

holder = sureface.getHolder()
holder.addCallback(callback)
activity.setContentView(sureface)
```

2. _OpenGL_ 模块

```lua
require "import"
import "gl" -- OGL Library

import "android.app.*"
import "android.os.*"
import "android.widget.*"
import "android.view.*"
import "android.opengl.*" -- Android GL API

activity.setTitle('AndroLua')
activity.setTheme(android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen) -- you can comment it out

mTriangleData = {
  0.0, 0.6, 0.0,
  -0.6, 0.0, 0.0,
  0.6, 0.0, 0.0, -- be double
};

mTriangleColor = {
  1, 0, 0, 0,
  0, 1, 0, 0,
  0, 0, 1, 0,
};

sr = GLSurfaceView.Renderer {
  onSurfaceCreated = function(gl2, config)
    gl.glDisable(gl.GL_DITHER);
    gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_FASTEST);
    gl.glClearColor(0, 0, 0, 0);
    gl.glShadeModel(gl.GL_SMOOTH);
    gl.glClearDepth(1.0)
    gl.glEnable(gl.GL_DEPTH_TEST);
    gl.glDepthFunc(gl.GL_LEQUAL);
  end,
  onDrawFrame = function(gl2, config)
    gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
    gl.glMatrixMode(gl.GL_MODELVIEW);
    gl.glLoadIdentity();
    gl.glRotate(0, 1, 1, 1)
    gl.glTranslate(0, 0, 0);
    gl.glEnableClientState(gl.GL_VERTEX_ARRAY);
    gl.glEnableClientState(gl.GL_COLOR_ARRAY);
    gl.glVertexPointer(mTriangleData, 3);
    gl.glColorPointer(mTriangleColor, 4);
    gl.glDrawArrays(gl.GL_TRIANGLE_STRIP, 0, 3);
    gl.glFinish();
    gl.glDisableClientState(gl.GL_VERTEX_ARRAY);
    gl.glDisableClientState(gl.GL_COLOR_ARRAY);
  end,
  onSurfaceChanged = function (gl2, w, h)
    gl.glViewport(0, 0, w, h);
    gl.glLoadIdentity();
    ratio = w / h;
    gl.glFrustum(-rautio, ratio, -1, 1, 1, 10);
  end
}

glSurefaceView = GLSurfaceView(activity);
glSurefaceView.setRenderer(sr);
activity.setContentView(glSurefaceView);
```

3. *http* 模块

```lua
-- destructure
body,cookie,code,headers=http.get(url, [cookie])
body,cookie,code,headers=http.post(url, postdata, [cookie])
code,headers=http.download(url, [cookie])
body,cookie,code,headers=http.upload(url, datas, files, [cookie])
-- NOTE by duangsuse: there maybe a incorrect call, open a issue on my repository if you found the code above won't run

require "import"
import "http"

-- get 函数以 get 请求获取网页，参数为请求的网址与 cookie
body,cookie,code,headers=http.get("http://www.androlua.com")

-- post 函数以 post 请求获取网页，通常用于提交表单，参数为请求的网址，要发送的内容与 cookie
body,cookie,code,headers=http.post("http://androlua.com/Login.Asp?Login=Login&Url=http://androlua.com/bbs/index.asp", "name=用户名&pass=密码&ki=1")

-- download 函数和 get 函数类似，用于下载文件，参数为请求的网址，保存文件的路径与 cookie
http.download("http://androlua.com", "/sdcard/alua.html")

-- upload 用于上传文件，参数是请求的网址，请求内容字符串部分，格式为以 key=value 形式的表，请求文件部分，格式为 key=文件路径的表，最后一个参数为 cookie
http.upload("http://androlua.com", {title = "标题", msg = "内容"}, {file1 = "/sdcard/1.txt", file2 = "/sdcard/2.txt"})
```

## 4. import模块

```lua
require "import" -- the library

import "android.widget.*"
import "android.view.*"

layout = {
  LinearLayout,
  orientation = "vertical",
  {
    EditText,
    id = "edit",
    layout_width = "fill"
  },
  {
    Button,
    text = "按钮",
    layout_width = "fill",
    onClick = "click"
  }
}

function click()
  Toast.makeText(activity, edit.getText().toString(), Toast.LENGTH_SHORT ).show()
end

activity.setContentView(loadlayout(layout))
```

## 关于打包

新建工程或在脚本目录新建 `init.lua` 文件。

写入以下内容，即可将文件夹下所有 lua 文件打包， `main.lua` 为程序人口。

```lua
appname = "demo"
appver = "1.0"
packagename = "com.androlua.demo"
```

目录下 icon.png 替换图标，welcome.png 替换启动图。

没有 int.lua 文件只打包当前文件。

打包默认只能使用 `debug(Android Mountain View)` 签名，如果需要自定义请使用第三方工具如 *MT 管理器*

## 部分函数参考

`[a]` 表示参数 `a` 可选

`(...)` 表示不定参数（`varargs`）。

*函数调用在只有一个参数且参数为字符串或表时可以省略括号*

AndroLua 库函数在 import 模块，为便于使用都是全局变量。

`s` 表示 `string` 类型，`i` 表示整数类型，`n` 表示浮点数或整数类型，`t` 表示表类型，`b` 表示布尔类型，`o` 表示 Java 对象(`JavaObject`) 类型，`f`为 Lua 函数。

`--` 表示注释。

```lua
--[[
I am a multi-line comment
]]

print "a" -- this is ignored

function a(...) -- varargs
  print(args)
end

function c(b, [a])
  if a == nil then
    print "not given"
  else
    print(a)
   end
end
```

`each(o)`

参数：`o` 为实现 `Iterable` 接口的 Java 对象

返回：用于 Lua 迭代的闭包

作用：Java 集合迭代器


`enum(o)`

参数：`o` 实现 `Enumeration` 接口的 Java 对象

返回：用于 Lua 迭代的闭包

作用：Java 集合迭代器

`import(s)`

参数：`s` 要载入的包或类的名称
返回：载入的类或模块
作用：载入包或类或 Lua 模块

```lua
import "http" --载入http模块
import "android.widget.*" --载入android.widget包
import "android.widget.Button" --载入android.widget.Button类
import "android.view.View$OnClickListener" --载入 android.view.View.OnClickListener 内部类
```

`loadlayout(t [,t2])`

参数：`t` 要载入的布局表，`t2` 保存 `view` 的表

返回：布局最外层 `View`

作用：载入布局表，生成 `View`

```lua
layout = {
  LinearLayout,
  layout_width = "fill",
  {
    TextView,
    text = "Androlua",
    id = "tv"
  }
}
main = {}
activity.setContentView(loadlayout(layout, main))
print(main.tv.getText())
```

`loadbitmap(s)`

参数：`s` 要载入图片的地址，支持相对地址，绝对地址与网址

返回：`BitMap` 对象

作用：载入图片

注意：载入网络图片需要在线程中进行

`task(s [,...], f)`

参数：`s` 任务中运行的代码或函数，`...` 任务传入参数，`f` 回调函数

返回：无返回值

作用：在异步线程运行 Lua 代码，执行完毕在主线程调用回调函数

注意：参数类型包括 布尔，数值，字符串，Java 对象，不能使用 Lua 对象（值）

```lua
function func(a,b)
  require "import"
  print(a, b)
  return a + b
end

task(func, 1, 2, print)
```

`thread(s[,...])`

参数：`s` 线程中运行的 lua 代码或脚本的相对路径(不加扩展名)或函数，`...` 线程初始化参数

返回：返回线程对象

作用：开启一个线程运行 Lua 代码

注意：线程需要调用 `quit` 方法结束线程

```lua
func=[[
a,b=...
function add()
  call("print", a + b)
end
]]

t = thread(func, 1, 2)
t.add()
```

`timer(s, i1, i2[,...])`

参数：`s` 定时器运行的代码或函数，`i1` 前延时，`i2` 定时器间隔，`...` 定时器初始化参数

返回：定时器对象

作用：创建定时器重复执行函数

```lua
function f(a)
  function run()
    print(a)
    a=a+1
  end
end

t = timer(f, 0, 1000, 1)
t.Enabled = false --暂停定时器
t.Enabled = true --重新定时器
t.stop() --停止定时器
```

`new_env()`

参数：无

返回：一个继承了 `import` 模块函数的环境表

作用：产生一个继承 `import` 模块函数的环境表

```lua
function foo()
  local _ENV = new_env()
  -- 在 Ruby 里，有一种叫「洁净室」的元编程法术与这里的类似
  import "android.widget.*"
  b = Button(activity)
end
```

`luajava.bindClass(s)`

参数：`s` `Class` 的完整名称，支持基本类型(`int, boolean...`)

返回：Java `Class` 对象

作用：载入 Java `Class`

```lua
Button = luajava.bindClass("android.widget.Button")
-- now variable Botton is bind to Java Class android.widget.Button
int = luajava.bindClass("int")
-- now variable int is bind to Java Class java.lang.Integer
```

`luajava.createProxy(s, t)`

参数：`s` 接口的完整名称(也可以传入使用 `,` 切分的几个名称)，`t` 接口函数表

返回：Java 接口对象

作用：创建 Java 接口

`onclick = luajava.createProxy("android.view.View$OnClickListener", {onClick = function(v) print(v) end})`

`luajava.createArray(s, t)`

参数：`s` 类的完整名称，支持基本类型，`t` 要转化为 Java 数组的表

返回：创建的 Java 数组对象

作用：创建 Java 数组

`ary = luajava.createArray("int", {1, 2, 3, 4})`

`luajava.newInstance(s [,...])`

参数：`s` 类的完整名称，`...` 构建方法的参数

作用：创建 Java 类的实例

`btn = luajava.newInstance("android.widget.Button", activity)`

`luajava.new(o[,...])`

参数：`o` Java 类对象，`...` 参数

返回：类的实例或数组对象或接口对象

作用：创建一个类实例或数组对象或接口对象

注意：当只有一个参数且为表类型时，如果类对象为 `Interface` 创建接口，为 `Class` 创建数组，参数为其他情况创建实例

```lua
b = luajava.new(Button, activity)
onclick = luajava.new(OnClickListener, {onClick = function(v) print(v) end})
ary = luajava.new(int, {1, 2, 3})
```

__(示例中假设已载入相关类)__

`luajava.coding(s [,s2 [, s3]])`

> NOTE: luna 里推荐使用 java.coding(s [,s2 [, s3]])

> NOTE: *luna* 里 `luajava` 默认名称为 `java`

参数：`s` 要转换编码的 Lua 字符串，`s2` 字符串的原始编码，`s3` 字符串的目标编码

返回：转码后的 Lua 字符串

作用：转换字符串编码

注意：默认进行 `GBK` 转 `UTF8`

`luajava.clear(o)`

> NOTE: luna 里推荐使用 java.destroy(o)

参数：`o` Java 对象
返回：无
作用：销毁 Java 对象
注意：尽量避免使用此函数，除非确认不在使用此对象，且该对象比较大

`luajava.astable(o)`

参数：`o` Java 对象

返回：Lua 表

作用：转换 Java 的 `ArrayList` 或 `Map` 为 `Lua` 表

`luajava.tostring(o)`

参数：`o` Java对象

返回：Lua 字符串

作用：相当于 `o.toString()`

## `LuaActivity` 部分 API 参考

`setContentView(layout, env)`

设置布局表 `layout` 为当前 `Activity` 的主视图，`env` 是保存视图 ID 的表，默认是 `_G`

`getLuaDir()`

返回脚本当前目录

`getLuaDir(name)`

返回脚本当前目录的子目录

`getLuaExtDir()`

返回 Androlua 在 SD 卡的工作目录

`getLuaExtDir(name)`

返回 Androlua 在 SD 的工作目录的子目录

> NOTE: 我看到很多 Androlua 开发者在 __硬编码 SD 卡路径__，希望你们能 *学会这个简写* 并在你们开发的应用的最新版本里 *彻底* 替换这类字符串

> NOTE: `activity.getLuaExtDir()` 可以获得外部存储路径

`getWidth()`

返回屏幕宽度

`getHeight()`

返回屏幕高度，不包括状态栏与导航栏

`loadDex(path)`

加载当前目录下的 dex 或 jar，返回 `DexClassLoader`

`loadLib(path)`

加载当前目录 C 模块，返回载入后模块的返回值(通常是包含模块函数的包)

`registerReceiver(filter)`

注册一个广播接收者，当再次调用该方法时将移除上次注册的过滤器

`newActivity(req, path, arg)`

打开一个新 `Activity`，运行脚本路径为 `path` 的 Lua 文件，其他两个参数为可选，`arg`为表，接受脚本为变长参数

`newTask(func, update, callback)`

新建一个 `Task` 异步任务，在线程中执行 `func` 函数，其他两个参数可选，执行结束回调 `callback`，在任务调用 `update` 函数时在 __UI线程__ 回调该函数

新建的 `Task` 在调用 `execute {}` 时通过表传入参数，在 `func` 以 `unpack` 形式接收，执行 `func`可以返回多个值

`newThread(func, arg)`

新建一个线程，在线程中运行 `func` 函数，可以以表的形式传入 `arg`，在 `func` 以 `unpack` 形式接收

新建的线程调用 `start()` 方法运行，线程为含有 `loop` 线程，在当前 `Activity` 结束后自动结束 `loop` 线程

`newTimer(func, arg)`

新建一个定时器，在线程中运行 `func` 函数，可以以表的形式传入 `arg`，在 `func` 以 `unpack` 形式接收

调用定时器的 `start(delay, period)` 开始定时器，`stop()` 停止定时器

修改 `Enabled` 属性暂停恢复定时器，`Period` 属性改变定时器间隔
