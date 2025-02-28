layout = {
  main = {
    LinearLayout,
    layout_width = "fill",
    layout_height = "fill",
    orientation = "vertical";
    {
      LuaEditor,
      id = "editor",
      text = "",
      layout_width = "fill",
      layout_height = "fill",
      layout_weight = 1,
      --gravity="top"
    },
    {
      HorizontalScrollView;
      horizontalScrollBarEnabled = false,
      {
        LinearLayout;
        id = "ps_bar";
        layout_width = "fill";
      };
      layout_width = "fill";
    };
  },
  build = {
    ScrollView,
    layout_width = "fill",
    {
      LinearLayout,
      orientation = 1,
      layout_width = "fill",
      paddingLeft = 20,
      {
        TextView,
        text = "脚本路径"
      },
      {
        EditText,
        id = "luaPath",
        layout_width = "fill",
        singleLine = true,
      },
      {
        TextView,
        text = "包名称"
      },
      {
        EditText,
        id = "packageName",
        layout_width = "fill",
        singleLine = true,
      },
      {
        TextView,
        text = "程序名称"
      },
      {
        EditText,
        id = "appName",
        layout_width = "fill",
        singleLine = true,
      },
      {
        TextView,
        text = "程序版本"
      },
      {
        EditText,
        id = "appVer",
        layout_width = "fill",
        singleLine = true,
      },
      {
        TextView,
        text = "apk路径"
      },
      {
        EditText,
        id = "apkPath",
        layout_width = "fill",
        singleLine = true,
      },
      {
        TextView,
        text = "打包使用debug签名",
        id = "status"
      },
    }
  },
  project = {
    ScrollView,
    layout_width = "fill",
    {
      LinearLayout,
      orientation = 1,
      layout_width = "fill",
      padding = "10dp",
      {
        TextView,
        text = "程序名称"
      },
      {
        EditText,
        id = "project_appName",
        text = "demo",
        layout_width = "fill",
        singleLine = true,
      },
      {
        TextView,
        text = "包名称"
      },
      {
        EditText,
        id = "project_packageName",
        text = "com.androluna.demo",
        layout_width = "fill",
        singleLine = true,
      },
    }
  },
  open2 = {
    LinearLayout;
    orientation = "vertical";
    {
      EditText;
      layout_width = "fill";
      id = "open_edit";
    };
    {
      ListView;
      layout_width = "fill";
      id = "listview2";
    };
  };
}
