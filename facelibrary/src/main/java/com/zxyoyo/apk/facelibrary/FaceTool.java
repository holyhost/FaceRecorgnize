package com.zxyoyo.apk.facelibrary;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * 描述
 *
 * @author 创建人 ：zhouxin
 * @version 1.0
 * @package 包名 ：com.zxyoyo.apk.facelibrary
 * @createTime 创建时间 ：18/9/21
 * @modifyBy 修改人 ：zhouxin
 * @modifyTime 修改时间 ：18/9/21
 * @modifyMemo 修改备注：
 */
public class FaceTool {



    protected static String appid = "";
    protected static String ft_key = "";
    protected static String fd_key = "";
    protected static String fr_key = "";
    protected static String age_key = "";
    protected static String gender_key = "";




    private static FaceTool faceTool;
    public static FaceDB mFaceDB;
    protected static Uri mImage;

    protected static boolean isRegister=false;
    protected static String faceName = "";
    public static final int REQ_CODE = 13;
    public static final String REQ_SUCCESS = "success";
    public static final String REQ_NAME = "name";
    /**
     * 对外开发的单例方法
     * @return
     */
    public static FaceTool getInstance(){
        return faceTool==null?new FaceTool():faceTool;
    }

    /**
     * 默认构造方法
     */
    private FaceTool(){ }

    /**
     * 初始化所需要的key和id
     * @param appid
     * @param ft_key
     * @param fd_key
     * @param fr_key
     * @param age_key
     * @param gender_key
     */
    public void initIdAndKeys(Context context,String appid,String ft_key,String fd_key,String fr_key,String age_key,String gender_key){
        this.appid = appid;
        this.ft_key = ft_key;
        this.fd_key = fd_key;
        this.fr_key = fr_key;
        this.age_key = age_key;
        this.gender_key = gender_key;
        mFaceDB = new FaceDB(context.getExternalCacheDir().getPath());
        mImage = null;

    }

    /**
     * 注册人脸
     * @param context
     * @param name: for face
     */
    public void register(Context context,String name){
        // 调用此方法前需初始化
        if(mFaceDB==null){
            Log.e("FaceTool","未初始化id 和 keys");
            Toast.makeText(context,"未初始化id 和 keys",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(name)){
            Log.e("FaceTool","name for registering is null");
            return;
        }
        isRegister = true;
        faceName = name;
        ((Activity)context).startActivityForResult(new Intent(context,PermissionActivity.class),REQ_CODE);
    }


    /**
     * 识别人脸
     * @param context
     */
    public void recorgnize(Context context,int FaceTool_REQ_CODE){
        if(mFaceDB.mRegister.isEmpty()){
            Toast.makeText(context,"未注册人脸，请先注册人脸！",Toast.LENGTH_SHORT).show();
            return;
        }
        isRegister = false;
        Intent intent = new Intent(context, DetecterActivity.class);
        ((Activity)context).startActivityForResult(intent,FaceTool_REQ_CODE);


    }

    /**
     * 删除人脸信息
     * @param name: the name will be deleted
     */

    public  boolean deleteFace(String name){
        boolean result = mFaceDB.delete(name);
        return result;
    }



}
