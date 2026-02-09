package com.goncalogarrido.g_ui.commands.main.raw;

import com.goncalogarrido.g_ui.R;
import com.goncalogarrido.g_ui.commands.CommandAbstraction;
import com.goncalogarrido.g_ui.commands.ExecutePack;
import com.goncalogarrido.g_ui.commands.main.MainPack;
import com.goncalogarrido.g_ui.commands.main.specific.PermanentSuggestionCommand;

/**
 * Simple Rule of Three: a is to b as c is to x → x = b * c / a
 */
public class rule3 extends PermanentSuggestionCommand {

    @Override
    public int[] argType() {
        // Grab all space-separated tokens as a List<String>
        return new int[] { CommandAbstraction.TEXTLIST };
    }

    @Override
    public String exec(ExecutePack pack) throws Exception {
        @SuppressWarnings("unchecked")
        java.util.List<String> parts = pack.getList();
        MainPack info = (MainPack) pack;

        if (parts.size() != 3) {
            return info.res.getString(helpRes());
        }

        try {
            double a = Double.parseDouble(parts.get(0));
            double b = Double.parseDouble(parts.get(1));
            double c = Double.parseDouble(parts.get(2));
            double x = b * c / a;

            // drop ".0" if integer
            if (x == (long) x) {
                return Long.toString((long) x);
            } else {
                return Double.toString(x);
            }
        } catch (NumberFormatException e) {
            return info.res.getString(R.string.output_invalidnumber);
        }
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public int helpRes() {
        return R.string.help_rule3;
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
        return new String[] { "<a>", "<b>", "<c>" };
    }
}
