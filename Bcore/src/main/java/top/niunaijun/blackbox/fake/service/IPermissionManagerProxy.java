package top.niunaijun.blackbox.fake.service;

import android.content.pm.PackageManager;

import java.lang.reflect.Method;

import black.android.app.BRActivityThread;
import black.android.app.BRContextImpl;
import black.android.os.BRServiceManager;
import black.android.permission.BRIPermissionManagerStub;
import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.fake.hook.BinderInvocationStub;
import top.niunaijun.blackbox.fake.hook.MethodHook;
import top.niunaijun.blackbox.fake.hook.ProxyMethod;
import top.niunaijun.blackbox.fake.service.base.PkgMethodProxy;
import top.niunaijun.blackbox.fake.service.base.ValueMethodProxy;
import top.niunaijun.blackbox.utils.Reflector;
import top.niunaijun.blackbox.utils.compat.BuildCompat;


public class IPermissionManagerProxy extends BinderInvocationStub {
    public static final String TAG = "IPermissionManagerProxy";

    private static final String P = "permissionmgr";

    public IPermissionManagerProxy() {
        super(BRServiceManager.get().getService(P));
    }

    @Override
    protected Object getWho() {
        return BRIPermissionManagerStub.get().asInterface(BRServiceManager.get().getService(P));
    }

    @Override
    protected void inject(Object baseInvocation, Object proxyInvocation) {
        replaceSystemService("permissionmgr");
        BRActivityThread.getWithException()._set_sPermissionManager(proxyInvocation);
        
    }

    @Override
    protected void onBindMethod() {
        super.onBindMethod();
        addMethodHook(new ValueMethodProxy("addPermissionAsync", true));
        addMethodHook(new ValueMethodProxy("addPermission", true));
        addMethodHook(new ValueMethodProxy("performDexOpt", true));
        addMethodHook(new ValueMethodProxy("performDexOptIfNeeded", false));
        addMethodHook(new ValueMethodProxy("performDexOptSecondary", true));
        addMethodHook(new ValueMethodProxy("addOnPermissionsChangeListener", 0));
        addMethodHook(new ValueMethodProxy("removeOnPermissionsChangeListener", 0));
        addMethodHook(new ValueMethodProxy("checkDeviceIdentifierAccess", false));
        addMethodHook(new PkgMethodProxy("shouldShowRequestPermissionRationale"));
        if (BuildCompat.isOreo()) {
            addMethodHook(new ValueMethodProxy("notifyDexLoad", 0));
            addMethodHook(new ValueMethodProxy("notifyPackageUse", 0));
            addMethodHook(new ValueMethodProxy("setInstantAppCookie", false));
            addMethodHook(new ValueMethodProxy("isInstantApp", false));
        }
    }


    /** Android 11+: Context/PackageManager permission checks end up here. Store Deny / Ask wins. */
    @ProxyMethod("checkPermission")
    public static class CheckPermission extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            String[] pair = PermissionPolicy.pickPermissionAndPackage(args);
            if (pair != null) {
                int decision = PermissionPolicy.decideForPackage(pair[0], pair[1], PermissionPolicy.LEGACY_NONE);
                if (decision != PermissionPolicy.NO_OPINION) {
                    return decision;
                }
            }
            return method.invoke(who, args);
        }
    }

    @ProxyMethod("checkUidPermission")
    public static class CheckUidPermission extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            // (uid, permission[, deviceId]) on Android 13+, (permission, uid) before: find by type
            String permission = null;
            int uid = -1;
            for (Object a : args) {
                if (permission == null && a instanceof String) {
                    permission = (String) a;
                } else if (uid == -1 && a instanceof Integer) {
                    uid = (Integer) a;
                }
            }
            if (permission != null && uid != -1) {
                int decision = PermissionPolicy.decideForUid(permission, uid, PermissionPolicy.LEGACY_NONE);
                if (decision != PermissionPolicy.NO_OPINION) {
                    return decision;
                }
            }
            return method.invoke(who, args);
        }
    }

    @ProxyMethod("isPermissionRevokedByPolicy")
    public static class IsPermissionRevokedByPolicy extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            String[] pair = PermissionPolicy.pickPermissionAndPackage(args);
            if (pair != null && PermissionPolicy.isOwnPackage(pair[1]) && PermissionPolicy.isDenied(pair[0])) {
                return true;
            }
            return method.invoke(who, args);
        }
    }

    @Override
    public boolean isBadEnv() {
        return false;
    }

}
