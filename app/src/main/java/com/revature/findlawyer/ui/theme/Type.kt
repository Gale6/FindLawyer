package com.revature.findlawyer.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.revature.findlawyer.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val Cormorantgaramond =FontFamily(

    Font(R.font.cormorantgaramond_bold,weight = FontWeight.Bold),
    Font(R.font.cormorantgaramond_light,weight = FontWeight.Light),
    Font(R.font.cormorantgaramond_medium,weight = FontWeight.Medium),
    Font(R.font.cormorantgaramond_regular,weight = FontWeight.Normal),
    Font(R.font.cormorantgaramond_semibold,weight = FontWeight.SemiBold)
)

val CustomTypography = Typography(
    body1 = TextStyle(
        fontFamily = Cormorantgaramond,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)


