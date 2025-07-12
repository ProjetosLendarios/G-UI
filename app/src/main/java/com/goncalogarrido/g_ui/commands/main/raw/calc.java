package com.goncalogarrido.g_ui.commands.main.raw;

import com.goncalogarrido.g_ui.R;
import com.goncalogarrido.g_ui.commands.CommandAbstraction;
import com.goncalogarrido.g_ui.commands.ExecutePack;
import com.goncalogarrido.g_ui.commands.main.MainPack;
import com.goncalogarrido.g_ui.commands.main.specific.PermanentSuggestionCommand;
import com.goncalogarrido.g_ui.tuils.Tuils;

/**
 * Created by francescoandreuzzi on 29/01/2017.
 */

public class calc extends PermanentSuggestionCommand {

    @Override
    public String exec(ExecutePack pack) throws Exception {
        try {
            return String.valueOf(Tuils.eval(pack.getString()));
        } catch (Exception e) {
            return e.toString();
        }
    }

    @Override
    public int[] argType() {
        return new int[] {CommandAbstraction.PLAIN_TEXT};
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public int helpRes() {
        return R.string.help_calc;
    }

    @Override
    public String onArgNotFound(ExecutePack pack, int index) {
        return null;
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs) {
        MainPack info = (MainPack) pack;
        return info.res.getString(helpRes());
    }

    @Override
    public String[] permanentSuggestions() {
        return new String[] {"(", ")", "+", "-", "*", "/", "%", "^", "sqrt"};
    }
}
