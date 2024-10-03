package com.example.FaizAdiPranawa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FaizAdiPranawa.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage( // Memanggil Composable function GreetingImage
                        message = "Happy Birthday Sam!",
                        from = "From Emma"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) { // Mengubah nama function menjadi GreetingImage dan menambahkan parameter message
    val image = painterResource(R.drawable.androidparty) // Mendeklarasikan variabel image dan memberikan nilai berupa gambar dari drawable
    Box(modifier) {
        Image( // Menampilkan gambar
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop, // Menyesuaikan ukuran gambar agar memenuhi Box
            alpha = 0.5F,
            modifier = Modifier.fillMaxSize() // Menyesuaikan ukuran gambar agar memenuhi Box
        )
        GreetingText( // Memanggil Composable function GreetingText
            message = message, // Memberikan nilai message ke parameter message pada GreetingText
            from = from, // Memberikan nilai from ke parameter from pada GreetingText
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) { // Mengubah nama function menjadi GreetingText dan menambahkan parameter message
    Column(
        verticalArrangement = Arrangement.Center, // Menempatkan elemen Column di bagian tengah
        horizontalAlignment = Alignment.CenterHorizontally, // Menengahkan elemen Column secara horizontal
        modifier = modifier
    ) {
        Text( // Menampilkan teks message
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally) // Menengahkan teks "Happy Birthday Sam!"
        )
        Text( // Menampilkan teks from
            text = from,
            fontSize = 36.sp,
            modifier = Modifier.align(Alignment.End) // Meratakan teks "From Emma" ke kanan
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingImage( // Memanggil Composable function GreetingImage pada Preview
            message = "Happy Birthday Sam!", // Memberikan nilai message ke parameter message pada GreetingImage
            from = "From Emma" // Memberikan nilai from ke parameter from pada GreetingImage
        )
    }
}