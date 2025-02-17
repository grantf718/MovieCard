package edu.quinnipiac.ser210.moviecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.quinnipiac.ser210.moviecard.ui.theme.MovieCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieCardTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    MovieCard(
                        title = "Parasite",
                        length = "2:12",
                        language = "Korean",
                        rating = "10",
                        review = "1m+"
                    )
                }
            }
        }
    }
}

// Entire card
@Composable
fun MovieCard(title: String, length: String, language: String, rating: String, review: String){
    Box(){
        Column(){
            Header()
            Body(title, length, language, rating, review)
        }
        MovieCover()
    }
}

// Big cropped movie cover at the top
@Composable
fun Header(){
    Image(
        painterResource(R.drawable.parasite),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.79f)
    )
}

// Title and details
@Composable
fun Body(title: String, length: String, language: String, rating: String, review: String){
    Column(modifier = Modifier.fillMaxHeight().background(Color(36, 44, 36, 226))){
        Spacer(modifier = Modifier.height(130.dp))
        TitleSection(title)
        Spacer(modifier = Modifier.height(25.dp))
        DetailsSection(length, language, rating, review)
    }
}

// Small movie cover
@Composable
fun MovieCover(){
    Image(
        painterResource(R.drawable.parasite),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .offset(20.dp, 455.dp)
            .size(150.dp, 230.dp)
            .clip(RoundedCornerShape(5))
            .border(BorderStroke(2.dp, Color.White), RoundedCornerShape(5))
    )
}

// Move title and stars
@Composable
fun TitleSection(title: String){
    Column(modifier = Modifier.offset(195.dp, (-25).dp)){
        // Title
        Text(text = title, fontSize = 45.sp, color = Color.White)
        // Stars
        Row(){
            Icon(imageVector = Icons.TwoTone.Star, tint = Color(220, 215, 0), contentDescription = null)
            Icon(imageVector = Icons.TwoTone.Star, tint = Color(220, 215, 0), contentDescription = null)
            Icon(imageVector = Icons.TwoTone.Star, tint = Color(220, 215, 0), contentDescription = null)
            Icon(imageVector = Icons.TwoTone.Star, tint = Color(220, 215, 0), contentDescription = null)
            Icon(imageVector = Icons.TwoTone.Star, tint = Color(220, 215, 0), contentDescription = null)
        }
    }
}

// Movie details/information
@Composable
fun DetailsSection(length: String, language: String, rating: String, review: String){
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Length", fontSize = 18.sp, color = Color.White)
            Text(text = length, fontWeight = FontWeight.Bold, color = Color.White)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Language", fontSize = 18.sp, color = Color.White)
            Text(text = language, fontWeight = FontWeight.Bold, color = Color.White)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Rating", fontSize = 18.sp, color = Color.White)
            Text(text = rating, fontWeight = FontWeight.Bold, color = Color.White)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Review", fontSize = 18.sp, color = Color.White)
            Text(text = review, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview(){
    MovieCardTheme{
        MovieCard(
            title = "Parasite",
            length = "2:12",
            language = "Korean",
            rating = "10",
            review = "1m+"
        )
    }
}