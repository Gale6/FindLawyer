package com.revature.findlawyer.ui.lawyersearch

import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

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

            Image(
                painter = rememberImagePainter(image),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )
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
                Text(
                    text = rating.toString(),
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                RatingBar(context).rating


            }

        }

    }
}