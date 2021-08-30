package com.zcshou.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.core.content.FileProvider;

import java.io.File;

public class ShareUtils {
    /**
     * 返回uri
     */
    private static Uri getUriForFile(Context context, File file) {
        String authority = context.getPackageName().concat(".fileProvider");
        return FileProvider.getUriForFile(context, authority, file);
    }

    public static void shareFile(Context context, File file, String title) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        share.putExtra(Intent.EXTRA_STREAM, getUriForFile(context, file));
        share.setType("application/octet-stream");
        context.startActivity(Intent.createChooser(share, title));
    }
}

