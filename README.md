# 异步线程---AsyncTask


- **为什么要异步任务**

*Android单线程模式*

*耗时操作在主线程中执行*

- **AsyncTask为何而生**

  子线程中更新UI

  封装,简化异步操作

- **构建AsyncTask子类参数**

  **Ansystask**<param,progress,Result>是一个抽象类,通常用于被继承,继承**AsyncTask**需要指定如下三个泛型参数:

  **params**:启动任务时输入参数类型

  **progress**:后台任务执行中返回进度类型

  **Result**:后台执行任务完成后返回结果的类型

  *构建**AsyncTask**子类回调方法*

  **doInBackground**:必须重写,异步执行后台线程将要完成的任务

  **onPreExcute**:执行后台耗时操作前被调用,通常用户完成一些初始化操作

  **onpauseExcute**:当**doInBackground()**完成后,系统会自动调用**onpostExcute**方法,并将返回值返回给该方法

  **onprogressUpdate**:在**doInBackground**方法中调用**publishProgress**方法

  更新任务的执行进度,就会触发此方法

- **使用注意事项**

  必须在UI线程中创建AsyncTask的实例

  必须在UI线程中调用AsyTask的Excute()方法

  重写AsyTask是系统调用的,我们不能手动调用这四个方法

  每个AsyTAsk只能执行一次,多次执行,会引发异常

  ​

  ​

  ​
