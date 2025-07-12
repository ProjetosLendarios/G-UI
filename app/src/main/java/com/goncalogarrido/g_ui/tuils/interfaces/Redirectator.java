package com.goncalogarrido.g_ui.tuils.interfaces;

import com.goncalogarrido.g_ui.commands.main.specific.RedirectCommand;

/**
 * Created by francescoandreuzzi on 03/03/2017.
 */

public interface Redirectator {

    void prepareRedirection(RedirectCommand cmd);
    void cleanup();
}
