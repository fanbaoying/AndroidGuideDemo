# Agree Android SDK

## 简介
当前版本支持，微信支付、支付宝支付、银联控件支付三种支付方式。
## 版本要求
Android SDK 要求 Android 2.3 及以上版本
请使用 Java 7 或以上版本
## 导入
1. 下载SDK
2. 在工程的AndroidManifest.xml文件中注册支付插件使用的Activity和添加插件的相关权限
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

        <!--用于访问网络，网络定位需要上网-->
        <uses-permission android:name="android.permission.INTERNET"/>
        <!-- 阿里支付配置-start -->
        <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
        <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
        <uses-permission android:name="android.permission.READ_PHONE_STATE" />
        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
        <!-- 阿里支付配置-end -->

```
添加微信
```
        <activity
            android:name=".wxapi.WXPayEntryActivity"
            android:exported="true" >
        </activity>

        <!--微信-->
        <uses-permission android:name="android.permission.INTERNET"/>
        <uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS"/>
        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

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
        <uses-permission android:name="android.permission.INTERNET" />
        <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
        <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
        <uses-permission android:name="android.permission.READ_PHONE_STATE" />
        <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
        <uses-permission android:name="android.permission.NFC" />
        <uses-feature android:name="android.hardware.nfc.hce" />
        <uses-permission android:name="android.permission.RECORD_AUDIO" />
        <uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS" />
        <uses-permission android:name="org.simalliance.openmobileapi.SMARTCARD" />
            
```
