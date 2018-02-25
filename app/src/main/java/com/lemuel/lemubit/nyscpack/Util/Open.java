package com.lemuel.lemubit.nyscpack.Util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by charl on 25/02/2018.
 */

public class Open {
    public static void OpenActivity(Context context, Class<?> cls, Bundle bundle)
    {
        Intent intent=new Intent(context,cls);
        context.startActivity(intent);
    }
}
