# WeatherForecast
 红岩寒假考核
 APP效果图：

![image](https://github.com/dech53/WeatherForecast/blob/main/app/src/gif/S30126-14270638_1.gif)

0.本APP的功能是通过点击城市列表中的城市名称，请求网络获得城市天气信息并更新控件。

实现：

1.网络请求的实现是通过API端口，从端口中读取二进制数据，将二进制流包装并存入缓冲区，并在缓冲区中读取二进制流的内容并返回内容。

2.在MainActivity中使用了spinner，通过在strings.xml中添加城市数据，在spinner中引用并且将列表颜色改为透明来使得界面更加的美观，在MainActivity中添加ArrayAdapter<String>是的城市信息在列表中显示

3.使用Gson将传入的json数据转变为天气类，利用ListView获取json中的每日天气数据，将当日的数据显示在上方，并将第一位数据移除，传入RecycleView中显示后七天的天气。

4.使用RecycleView，利用Adapter，引入移除了第一位数据的天气列表，创建一个View并与RecycleView进行绑定，从而实现列表内容的显示

亮点：

1.在网络请求数据的接收中引gson库，并利用天气通过键值对将数据转换为天气类，这样做省去了json解析中的键值堆获取数据，将其归并为一个类，使代码变得更加的简洁。

2.通过百度得知了spinner一些没有提示的功能，如android:dropDownVerticalOffset和android:overlapAnchor。

问题：
 
1.spinner显示了城市列表，但是在滑动列表时，选中的城市会和下拉的城市名称重叠
