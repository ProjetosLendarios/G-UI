package com.goncalogarrido.g_ui.tuils;

import androidx.core.content.FileProvider;

import com.goncalogarrido.g_ui.BuildConfig;

public class GenericFileProvider extends FileProvider {
    public static final String PROVIDER_NAME = BuildConfig.APPLICATION_ID + ".FILE_PROVIDER";
}
