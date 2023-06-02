package witoldmetel.coffeeshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import witoldmetel.coffeeshop.ui.theme.Alternative1
import witoldmetel.coffeeshop.ui.theme.Alternative2

@Composable
fun Offer(title: String, description: String) {
    Box(modifier = Modifier.padding(16.dp)) {
        Image(painter = painterResource(R.drawable.background_pattern),
            contentDescription = "background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .height(180.dp)
                .matchParentSize())
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()) {
            Text(text = title,
                fontSize = 16.sp,
                modifier = Modifier
                    .background(Alternative1)
                    .padding(16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = description,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .background(Alternative2)
                    .padding(16.dp))
        }
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
private fun OfferPreview() {
    Offer(title = "New Offer", description = "Offer description")
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun OffersPage() {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
    }
}