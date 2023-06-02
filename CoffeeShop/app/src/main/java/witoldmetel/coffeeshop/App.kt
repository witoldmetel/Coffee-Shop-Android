package witoldmetel.coffeeshop


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import witoldmetel.coffeeshop.ui.theme.Alternative2
import witoldmetel.coffeeshop.ui.theme.CoffeeShopTheme
import witoldmetel.coffeeshop.ui.theme.Primary

@Preview
@Composable
fun AppTitle() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Primary)
        .padding(10.dp),
        contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    var selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }

    Scaffold(
        topBar = {
            AppTitle()
        },
        content = {
            Box(modifier = Modifier.padding(vertical = 26.dp)) {
                OffersPage()
            }
        },
        bottomBar = {
            NavBar(onChange = {newRoute ->
                selectedRoute.value = newRoute
            })
        }

    )
}


@Preview
@Composable
fun AppPreview() {
    CoffeeShopTheme() {
        App()
    }
}


