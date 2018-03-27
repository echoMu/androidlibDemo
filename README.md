##Android 项目的目录结构
一. AndroidLib 类库,将与业务无关的逻辑转移到 AndroidLib。主项目引用 AndroidLib 类库
1.activity 包中存放的是与业务无关的 Activity 基类。Activity 基类要分两层，
AndroidLib 下的基类 BaseActivity 封装的是业务无关的公用逻辑，
主项目中的AppBaseActivity 基类封装的是业务相关的公用逻辑。
2.net 包里面存放的是网络底层封装；
3.cache 包里面存放的是缓存数据和图片的相关处理；
4.ui 包中存放的是自定义控件；
5.utils 包中存放的是各种与业务无关的公用方法，比如对 SharedPreferences 的封装；
    已有日志控制类CommonUtil、
    一般工具类CommonUtil、
    轻量存储SP工具类SharePreferenceUtil、
    图片选择工具类SelectPhotoUtil、

二.将主项目中的类分门别类地进行划分，放置在各种包中
1.activity：我们按照模块继续拆分，将不同模块的 Activity 划分到不同的包下；
2.adapter：所有适配器都放在一起；
3.entity：将所有的实体都放在一起；
4.db：SQLLite 相关逻辑的封装；
5.engine：将业务相关的类都放在一起；
6.ui：将自定义控件都放在这个包中；
6. utils：将所有的公用方法都放在这里；
7.interfaces：真正意义上的接口，命名以 I 作为开头；
8.listener：基于 Listener 的接口，命名以 On 作为开头；

这些划分主要是为了以下两个目的：
1）每个文件只有一个单独的类，不要有嵌套类，比如在 Activity 中嵌套 Adapter、Entity。
2）将 Activity 按照模块拆分归类后，可以迅速定位具体的一个页面。此外，将开发人员
按照模块划分后，每个开发人员都只负责自己的那个包，开发边界线很清晰。