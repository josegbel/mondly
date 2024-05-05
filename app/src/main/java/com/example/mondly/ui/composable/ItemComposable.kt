import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mondly.domain.DomainItem

@Composable
fun ItemComposable(item: DomainItem) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {// Create a dimens file in res/values!!
            Image(
                painter = rememberAsyncImagePainter(item.imageUrl),
                contentDescription = item.name,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = item.name, style = MaterialTheme.typography.headlineLarge)
                Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}