package witoldmetel.coffeeshop.pages

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView


@Preview(showBackground = true, widthDp = 400)
@Composable
fun InfoPage() {
    MyWebView()
}

@Composable
fun MyWebView() {
    var url = "https://firtman.github.io/coffeemasters/webapp"

    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            )
            webViewClient = WebViewClient() // customize the web view
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}
