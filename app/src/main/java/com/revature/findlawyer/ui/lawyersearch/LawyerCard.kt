package com.revature.findlawyer.ui.lawyersearch

import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.revature.findlawyer.R


@OptIn(ExperimentalCoilApi::class)
@Composable
fun LawyerCard(firstName:String,lastName:String,typeOfPractice:String,rating:Float,image:String,numCases:Int) {
    var context = LocalContext.current
    Card(

        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { }//go to other composable
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically

        ) {


            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("http://thispix.com/wp-content/uploads/2015/06/Edit-3700-1.jpg")
                    .build())

            Image(
                painter = painter,
                contentDescription = "Profile",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(120.dp)
                    .padding(8.dp)

            )
//                Image(
//                    painter = rememberImagePainter(image),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(120.dp)
//                        .padding(8.dp),
//                    contentScale = ContentScale.Fit
//                )


            Column(Modifier.padding(8.dp)) {

                Text(
                    text = firstName+" "+lastName,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(
                    text = typeOfPractice,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Row(Modifier.absolutePadding(right = 2.dp)) {
                    Text(
                        text = rating.toString(),
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Image(painter = painterResource(R.drawable.star3_ccexpress), contentDescription = "Profile Picture",
                        Modifier
                            .size(20.dp)
                            .padding(2.dp))

                        Text(
                            text = "•      "+numCases.toString()+" cases",
                            style = MaterialTheme.typography.body2,
                            fontStyle = FontStyle.Italic,
                            color = MaterialTheme.colors.onSurface,
                            modifier = Modifier.absolutePadding(bottom = 4.dp, left = 16.dp)
                        )

                }



            }

        }

    }
}

@Preview
@Composable
fun previewLawyerCard() {
    LawyerCard(
        firstName = "Brandon",
        lastName = "Tate",
        typeOfPractice = "Civil Attorney",
        rating = 4.7f,
        image = "http://thispix.com/wp-content/uploads/2015/06/Edit-3700-1.jpg",
        numCases = 87
    )
}