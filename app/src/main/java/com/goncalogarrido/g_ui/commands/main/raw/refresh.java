package com.goncalogarrido.g_ui.commands.main.raw;

import com.goncalogarrido.g_ui.R;
import com.goncalogarrido.g_ui.commands.CommandAbstraction;
import com.goncalogarrido.g_ui.commands.ExecutePack;
import com.goncalogarrido.g_ui.commands.main.MainPack;

public class refresh implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) {
        MainPack info = (MainPack) pack;
        info.appsManager.fill();
        info.aliasManager.reload();
        if(info.player != null) info.player.refresh();
        info.contacts.refreshContacts(info.context);
        info.rssManager.refresh();

        return info.res.getString(R.string.output_refresh);
    }

    @Override
    public int helpRes() {
        return R.string.help_refresh;
    }

    @Override
    public int[] argType() {
        return new int[0];
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public String onNotArgEnough(ExecutePack info, int nArgs) {
        return null;
    }

    @Override
    public String onArgNotFound(ExecutePack info, int index) {
        return null;
    }
}
