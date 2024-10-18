package com.example.carte-ville

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dice_roller.R
import com.example.dice_roller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.sky_),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        // Using a Column for spacing items between
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            verticalArrangement = Arrangement.SpaceBetween, // Change to SpaceBetween
            horizontalAlignment = Alignment.CenterHorizontally // Center items horizontally
        ) {
            DiceWithButtonAndImage() // Call the DiceWithButtonAndImage composable
        }
    }
}


@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }

    // Set the image and description based on the result
    val (imageResource, description) = when (result) {
        1 -> Pair(R.drawable.mosqu_, "One of the largest mosques in the world, known for its stunning architecture and oceanfront location.")
        2 -> Pair(R.drawable.cournich, "A beautiful waterfront promenade lined with restaurants, cafes, and beaches, perfect for strolling and enjoying the sea view.")
        3 -> Pair(R.drawable.roiyalpalace, "The official residence of the King of Morocco, featuring impressive architecture and beautiful gardens.")
        4 -> Pair(R.drawable.hubous, "A charming neighborhood with traditional Moroccan architecture, souks (markets), and artisan shops.")
        5 -> Pair(R.drawable.oldmedina, "The historic center of Casablanca, filled with narrow streets, local shops, and cafes.")
        else -> Pair(R.drawable.place, "A central square surrounded by important government buildings and featuring beautiful fountains and gardens.")
    }

    val imageSize = 200.dp

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly // Use SpaceEvenly to distribute space evenly
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = description,
            modifier = Modifier
                .size(imageSize)
                .clip(RoundedCornerShape(16.dp))
        )

        // Display the description text
        Text(
            text = description,
            fontSize = 25.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp) // Padding for layout
        )

        Button(
            onClick = { result = (1..6).random() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black // Change button color to black
            ),
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp)) // Optional: Keep the rounded corners for the button
        ) {
            Text(
                text = stringResource(R.string.roll),
                fontSize = 15.sp,
                color = Color.White // Change text color to white
            )
        }
    }
}
