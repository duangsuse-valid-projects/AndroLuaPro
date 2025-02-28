-- Support SDK 22, change theme automaticly
local version = luajava.bindClass("android.os.Build").VERSION.SDK_INT;
local function autotheme()
  local h = tonumber(os.date("%H"))
  if version >= 21 then
    if h <= 6 or h >= 22 then
      return (android.R.style.Theme_Material)
    else
      return (android.R.style.Theme_Material_Light)
    end
  else
    if h <= 6 or h >= 22 then
      return (android.R.style.Theme_Holo)
    else
      return (android.R.style.Theme_Holo_Light)
    end
  end
end

return autotheme
