package com.example.imadpracticum



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imadpracticum.ui.theme.ImadpracticumTheme

class MainActivity : ComponentActivity() {

    // Enum used to switch between app screens
    enum class Screen {
        SPLASH, MAIN, LIST
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ImadpracticumTheme {
                var currentScreen by remember { mutableStateOf(value=Screen.MAIN) }
            }

            ImadpracticumTheme {
                var currentScreen by remember { mutableStateOf(value=Screen.MAIN) }

                // Parallel arrays
                val MovieTitle = remember { mutableStateListOf<String>() }
                val Director = remember { mutableStateListOf<String>() }
                val Rating = remember { mutableStateListOf<Int>() }
                val comments = remember { mutableStateListOf<String>() }

                // Input fields
                var MovieTitle by remember { mutableStateOf(value="") }
                var Director by remember { mutableStateOf(value="") }
                var Rating by remember { mutableStateOf(value="") }
                var comments by remember { mutableStateOf(value="") }

                var message by remember { mutableStateOf(value="") }
                var listDisplay by remember { mutableStateOf(value="") }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(all=16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.verticalScroll(state=rememberScrollState())
                        ) {
                            when (currentScreen) {


                                com.example.imadpracticum..MainActivity.Screen.MAIN -> {
                                    Text(
                                        text = "The movie rating app",
                                        style = MaterialTheme.typography.headlineSmall
                                    )
                                    Spacer(modifier = Modifier.height(height=16.dp))

                                    OutlinedTextField(
                                        value = MovieTitle,
                                        onValueChange = { MovieTitle = it },
                                        label = { Text(text="Item Name") }
                                    )
                                    Spacer(modifier = Modifier.height(height=8.dp))

                                    OutlinedTextField(
                                        value = Director,
                                        onValueChange = { Director = it },
                                        label = { Text(text="Category") }
                                    )
                                    Spacer(modifier = Modifier.height(height=8.dp))

                                    OutlinedTextField(
                                        value = Rating,
                                        onValueChange = { Rating = it },
                                        label = { Text(text="Rating") }
                                    )
                                    Spacer(modifier = Modifier.height(height=8.dp))

                                    OutlinedTextField(
                                        value = comments,
                                        onValueChange = { comments = it },
                                        label = { Text(text="Comments") }
                                    )
                                    Spacer(modifier = Modifier.height(height=16.dp))

                                    Button(onClick = {
                                        try {
                                            if (MovieTitle.isBlank() || Director.isBlank() || Rating.isBlank()) {
                                                message = "⚠️ Please fill in all fields!"
                                            } else {
                                                val qty = Rating.toInt()
                                                MovieTitle.add(MovieTitle)
                                                Director.add(Director)
                                                Rating.add(Rating)
                                                comments.add(comments)

                                                message = "✅ Item added!"
                                                MovieTitle = ""
                                                Director = ""
                                                Rating = ""
                                                comments = ""
                                            }
                                        } catch (e: NumberFormatException) {
                                            message = "Rating must be a number!"
                                        }
                                    }) {
                                        Text(text="Add to Movie ratihngs to List")
                                    }

                                    Spacer(modifier = Modifier.height(height=8.dp))
                                    Text(text = message)

                                    Spacer(modifier = Modifier.height(height=16.dp))
                                    Button(onClick = { currentScreen = com.example.imadpracticum..MainActivity.Screen.LIST }) {
                                        Text(text="View Packing List")
                                    }

                                    Spacer(modifier = Modifier.height(height=8.dp))
                                    Button(onClick = { finishAffinity() }) {
                                        Text(text="Exit App")
                                    }
                                }




                


            }