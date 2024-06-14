package com.example.diplom

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.CompoundBarcodeView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AdminClubMembershipScanScreen(navController: NavHostController) {
    val context = LocalContext.current as Activity
    var scanFlag by remember { mutableStateOf(false) }

    val compoundBarcodeView = remember {
        CompoundBarcodeView(context).apply {
            val capture = CaptureManager(context, this)
            capture.initializeFromIntent(context.intent, null)
            this.setStatusText("")
            capture.decode()
            this.resume()
            this.decodeContinuous { result ->
                if (scanFlag) {
                    return@decodeContinuous
                }
                scanFlag = true
                result.text?.let { barCodeOrQr ->
                    // Показ тоста с информацией о сканированном коде
                    Toast.makeText(context, barCodeOrQr, Toast.LENGTH_LONG).show()
                    scanFlag = false
                }
            }
        }
    }

    // Управление жизненным циклом для CompoundBarcodeView
    DisposableEffect(Unit) {
        val lifecycleObserver = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> compoundBarcodeView.pause()
                Lifecycle.Event.ON_RESUME -> compoundBarcodeView.resume()
                else -> {}
            }
        }

        val lifecycle = (context as? LifecycleOwner)?.lifecycle
        lifecycle?.addObserver(lifecycleObserver)

        onDispose {
            lifecycle?.removeObserver(lifecycleObserver)
        }
    }

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { compoundBarcodeView },
    )
}
