# Agree Android SDK

## 简介
当前版本支持，微信支付、支付宝支付、银联控件支付三种支付方式。
## 版本要求
Android SDK 要求 Android 2.3 及以上版本
请使用 Java 7 或以上版本
## 导入
1. 下载SDK
2. 在工程的AndroidManifest.xml文件中注册支付插件使用的Activity和添加插件的相关权限

通用配置
```
	<uses-permission android:name="android.permission.INTERNET"/>
    	<uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS"/>
    	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
```

SDK配置
```
	<activity android:name="com.agree.mobilepay.AgreePayActivity"
            android:configChanges="orientation|screenSize"
            android:launchMode="singleTop"
            android:theme="@android:style/Theme.Translucent.NoTitleBar">
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>

                <category android:name="android.intent.category.BROWSABLE"/>
                <category android:name="android.intent.category.DEFAULT"/>

                <data android:scheme="qwalletXXXXXXXX"/>
            </intent-filter>
        </activity>
```

添加支付宝
```
        <activity        
            android:name="com.alipay.sdk.app.H5PayActivity"     
            android:configChanges="orientation|keyboardHidden|navigation"
            android:exported="false"
            android:screenOrientation="behind" >
        </activity>
        <activity
            android:name="com.alipay.sdk.auth.AuthActivity"
            android:configChanges="orientation|keyboardHidden|navigation"
            android:exported="false"
            android:screenOrientation="behind" >
        </activity>

```
添加微信
```
        <activity-alias
            android:name=".wxapi.WXPayEntryActivity"
            android:exported="true"
            android:targetActivity="com.agree.mobilepay.AgreePayActivity"/>

```
添加银联
```

        <uses-library
            android:name="org.simalliance.openmobileapi"
            android:required="false" />

        <activity
            android:name="com.unionpay.uppay.PayActivity"
            android:configChanges="orientation|keyboardHidden"
            android:excludeFromRecents="true"
            android:label="@string/app_name"
            android:screenOrientation="portrait"
            android:windowSoftInputMode="adjustResize" />
            
        <!--银联-->
        <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
    	<uses-permission android:name="android.permission.NFC" />
    	<uses-feature android:name="android.hardware.nfc.hce" />
    	<uses-permission android:name="android.permission.RECORD_AUDIO" />
    	<uses-permission android:name="org.simalliance.openmobileapi.SMARTCARD" />
            
```
## SDK使用
1.导入SDK以及支付方的SDK
2.调起支付方法
```
	// 调起支付界面
        Agree.pay(支付页面Activity.this, 后端返回数据data);
	
```
3.支付回调获取
```
	@Override
   	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        	super.onActivityResult(requestCode, resultCode, data);

       	 	if (data == null){
            		return;
        	}else {

            		String resultss = data.getExtras().getString("pay_result");
            		Log.i("charge apppayresult", resultss);

            		/*
			返回8100 支付成功
			返回8104 支付失败
			返回8101 退出支付
			返回8111 异常返回
	 		*/
			
       		 }

    	}
```

#### 微信签名配置
请查看[官方文档](https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=8_5)

