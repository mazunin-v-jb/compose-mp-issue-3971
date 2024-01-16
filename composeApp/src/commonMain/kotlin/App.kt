import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    MaterialTheme {
        val uriHandler = LocalUriHandler.current

        val listOfNumbers: List<String> = listOf(
            "tel:+37499999999",
            "tel:+374 999-999-99",
            "tel:+374 (999) 999-99",
            "tel:+374(999)999-99",
            "tel:+374(999)99999",
            "tel:+1 (999)99999",
            "tel:+1 (999) 999-99",
            "tel:+1 999-999-99",
            "tel:+199999999",
            "https://www.google.com"
        )

        var lazyList =
            LazyColumn(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(16.dp)) {
                items(listOfNumbers) {
                    Button(onClick = { uriHandler.openUri(it) }) {
                        Text(it)
                    }
                }
            }
    }
}