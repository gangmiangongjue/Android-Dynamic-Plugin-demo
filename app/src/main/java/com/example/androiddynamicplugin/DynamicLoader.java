package com.example.androiddynamicplugin;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class DynamicLoader {
    private final static String TAG = "DanymicLoader";
    private static Object handle;
    /**
     * 加载dex文件中的class，并调用其中的方法
     * 这里由于是加载 jar文件，所以采用DexClassLoader
     * 下面开始加载dex class
     */
    private static Method getMethod(Context context,String methodName,Class<?>... methodArgs) {
        File cacheFile = context.getCacheDir();
        Log.d(TAG, "loadDexClass file path: " + cacheFile.getAbsolutePath());
        String internalPath = cacheFile.getAbsolutePath() + File.separator + "classes.dex";
        File desFile = new File(internalPath);
        Method method = null;
        if (desFile.exists()) {
            DexClassLoader dexClassLoader = new DexClassLoader(internalPath, cacheFile.getAbsolutePath(), cacheFile.getAbsolutePath(), context.getClass().getClassLoader());
            try {
                Class<?> libClazz = dexClassLoader.loadClass("com.example.testdepence.Add");
                Method getInstance = libClazz.getMethod("getInstance");
                getInstance.setAccessible(true);
                handle = getInstance.invoke(null);
                if (handle ==null){
                    Log.d(TAG, "getInstance error handle is null !!! ");
                }else {
                    Log.d(TAG, "getInstance success!!! ");
                }

                method = libClazz.getMethod(methodName,methodArgs);
                method.setAccessible(true);

            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "getMethod error: " + e.getMessage());
                return method;
            }
        }else{
            Log.d(TAG, "aar not exist!!!");
        }
        return method;
    }

    public static int dynamicInit(Context context,byte[] data){
        Method initHandle = getMethod(context,"init",byte[].class);
        if (initHandle !=null && handle != null && data != null){
            try {
                initHandle.invoke(handle,data);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
    }





}
