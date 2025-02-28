package com.shadowings.rpg98.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.shadowings.rpg98.appModule
import com.shadowings.rpg98.ui.theme.Rpg98Theme
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication

@Preview
@Composable
fun PreviewContainer(content: @Composable () -> Unit) {
    val context = LocalContext.current

    KoinApplication(application = {
        androidContext(context)
        modules(appModule)
    }) {
        Rpg98Theme {
            content()
        }
    }
}