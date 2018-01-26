package github.tornaco.xposedmoduletest.xposed.service;

import android.content.Context;
import android.os.RemoteException;

import github.tornaco.xposedmoduletest.IAshmanService;
import github.tornaco.xposedmoduletest.xposed.submodules.SubModule;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by guohao4 on 2017/10/27.
 * Email: Tornaco@163.com
 */
abstract class XAshmanServiceAbs extends IAshmanService.Stub
        implements IModuleBridge {

    @Getter
    @Setter
    private Context context;

    private boolean hasModuleError;

    @Override
    public void attachContext(Context context) {
        setContext(context);
    }

    @Override
    public boolean hasModuleError() throws RemoteException {
        return hasModuleError;
    }

    @Override
    public void onModuleInitError(SubModule module) {
        this.hasModuleError = true;
    }
}
