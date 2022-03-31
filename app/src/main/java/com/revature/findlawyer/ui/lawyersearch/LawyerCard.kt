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
import com.revature.findlawyer.R


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
                Row() {
                    Text(
                        text = rating.toString(),
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Image(painter = painterResource(R.drawable.star3_ccexpress), contentDescription = null,
                        Modifier
                            .size(20.dp)
                            .padding(2.dp))

                        Text(
                            text = numCases.toString()+" cases",
                            style = MaterialTheme.typography.body2,
                            fontStyle = FontStyle.Italic,
                            color = MaterialTheme.colors.onSurface,
                            modifier = Modifier.absolutePadding(bottom = 4.dp, left = 28.dp)
                        )

                }



            }

        }

    }
}

@Preview
@Composable
fun previewLawyerCard() {

}