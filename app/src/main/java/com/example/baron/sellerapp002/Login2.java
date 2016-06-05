package com.example.baron.sellerapp002;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.managerplat.model.Sellers;

import java.io.File;
import java.io.FileNotFoundException;


public class Login2 extends Activity {

    public static final int CUT_PICTURE=1;
    public static final int SHOW_PICTURE=2;
    public static final int CUT_FROM_CAMERA=3;
    private Uri imageUri;
    private Uri imageUri1;

    private String filename;

    private Button button2;
    private ImageView iv1 ;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv = null;

    //姓名，密码，手机号
    private String name;
    private String passwd;
    private int phone;

    //头像，营业照，身份证
    private StringBuffer profile=new StringBuffer();
    private StringBuffer certification=new StringBuffer();
    private StringBuffer identity=new StringBuffer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        button2= (Button) findViewById(R.id.confirm_button);
        iv1= (ImageView) findViewById(R.id.head_portrait_Image);
        iv2= (ImageView) findViewById(R.id.login_certificate_Image);
        iv3= (ImageView) findViewById(R.id.login_ID_Image);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        passwd = intent.getStringExtra("passwd");
        phone = Integer.parseInt(intent.getStringExtra("phone"));

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv = iv1;
                choosePicture(profile);
            }

        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv = iv2;
                choosePicture(certification);
            }

        });

        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv = iv3;
                choosePicture(identity);
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Sellers sellers = new Sellers();
                sellers.setSellerName(name);
                sellers.setSellerPassword(passwd);
                sellers.setSellerPhone(phone);
                sellers.setSellerStar(Math.random() * 5);
                sellers.setSellerIDCardPath(identity.toString());
                sellers.setSellerImagePath(profile.toString());
                sellers.setSellerLicencePath(certification.toString());
                Intent intent=new Intent();
                intent.setClass(Login2.this, Waiting.class);
                intent.putExtra("seller", sellers);
                startActivity(intent);

                // conneteToService();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void choosePicture(final StringBuffer stringBuffer){
        AlertDialog.Builder builder=new AlertDialog.Builder(Login2.this);
        builder.setPositiveButton("相机", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                filename = String.valueOf(System.currentTimeMillis());
                //创建File对象，用于存储拍照后的图片
                //将此图片存于SD卡的根目录下
                //File outputImage = new File(Environment.getExternalStorageDirectory(),"output_image.jpg");
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                File outputImage = new File(path, filename + ".jpg");
                stringBuffer.append(outputImage.getAbsolutePath().toString());
//                try {
//                    if (outputImage.exists()) {
//                        outputImage.delete();
//                    }
//                    outputImage.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                //将File对象转换Uri对象；Uri表示图片的地址
                imageUri = Uri.fromFile(outputImage);

                //隐式调用相机程序
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, CUT_FROM_CAMERA);
            }
        });

        builder.setNegativeButton("相册", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                imageUri = Uri.fromFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
                Intent intent = new Intent(Intent.ACTION_PICK, imageUri);
                //此处调用了图片选择器，如果直接写intent.setDataAndType("image/*");调用的是系统图库
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, CUT_PICTURE);

            }
        });
        //builder.show();
        builder.create().show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case 20:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(data.getData(),"image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, SHOW_PICTURE);

                }
                break;
            case SHOW_PICTURE:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        iv.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case CUT_FROM_CAMERA:
                if(resultCode == RESULT_OK){
                    Intent crop = new Intent("com.android.camera.action.CROP");
                    crop.setDataAndType(imageUri,"image/*");
                    crop.putExtra("scale",true);
                    crop.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(crop, SHOW_PICTURE);
                }
                break;
            default:
                break;
        }
    }
}

