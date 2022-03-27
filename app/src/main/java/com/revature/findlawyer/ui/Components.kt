package com.revature.findlawyer.ui

import android.view.MenuItem
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.findlawyer.R
import com.revature.findlawyer.ui.theme.Cormorantgaramond
import com.revature.findlawyer.ui.theme.Shapes
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun bottDrawer(){
    val state= rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)
    val scope = rememberCoroutineScope()


    BottomDrawer(
        drawerElevation = 10.dp,
        drawerState = state,
        drawerContent = {
            Column(horizontalAlignment = Alignment.Start,modifier=Modifier.size(300.dp,400.dp)) {
                DropdownMenuItem(onClick = {scope.launch{state.close()} }) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "")
                    Text(text = "/*To Do*/",Modifier.padding(start = 16.dp))
                }
                DropdownMenuItem(onClick = {/*scope.launch{state.close()} */}) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                    Text(text = "/*To Do*/",Modifier.padding(start = 16.dp))
                }

            }
        }
    ){}


}

/////////////////////////////  Bot App Bar FO NAV (DRAWER, SCREENS)  ///////////////////////////////

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BotBar(){
    val state= rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)
    val scope = rememberCoroutineScope()

    BottomAppBar(){
        IconButton(onClick = { scope.launch{state.open()} }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
        }
        Spacer(Modifier.weight(1f,true))
        IconButton(onClick = { /*scope.launch{state.open()}*/ }) {
            Icon(imageVector = Icons.Filled.Settings, contentDescription = "")
        }

    }



}



/////////////////////////////  Bot App Bar w/Drawer  ///////////////////////////////

@Preview
@Composable
fun preBotApp(){
    AppBarBottom()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppBarBottom(){
    val state= rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)
    val scope = rememberCoroutineScope()


    BottomDrawer(
        drawerElevation = 10.dp,
        drawerState = state,
        drawerContent = {
            Column(horizontalAlignment = Alignment.Start,modifier=Modifier.size(300.dp,400.dp)) {
                DropdownMenuItem(onClick = {/*scope.launch{state.close()}*/ }) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "")
                    Text(text = "/*To Do*/",Modifier.padding(start = 16.dp))
                }
                DropdownMenuItem(onClick = {/*scope.launch{state.close()} */}) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                    Text(text = "/*To Do*/",Modifier.padding(start = 16.dp))
                }

            }
        }
    ){}

    Column(modifier= Modifier
        .fillMaxSize()
        /*.border(3.dp, color = Color.Red)*/,verticalArrangement = Arrangement.Bottom) {

        BottomAppBar(){
            IconButton(onClick = { scope.launch{state.open()} }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
            Spacer(Modifier.weight(1f,true))
            IconButton(onClick = { /*scope.launch{state.open()}*/ }) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "")
            }

        }


    }

}


/////////////////////////////  Bot App Bar w/Drawer  ///////////////////////////////

@Preview
@Composable
fun prevBotApp(){
    BottomAppBar()
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomAppBar () {
    val state= rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)
    val scope = rememberCoroutineScope()

    BottomDrawer(
        drawerState = state,
        drawerContent = {
            Column(Modifier.size(300.dp,400.dp)) {
                DropdownMenuItem(onClick = {/*scope.launch{state.close()}*/ }) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "")
                    Text(text = "/*To Do*/",Modifier.padding(start = 16.dp))
                }
                DropdownMenuItem(onClick = {/*scope.launch{state.close()} */}) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                    Text(text = "/*To Do*/",Modifier.padding(start = 16.dp))
                }

            }
        }
    ){
        Scaffold(bottomBar = {
            BottomAppBar(){
                IconButton(onClick = { scope.launch{state.open()} }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
                }
                Spacer(Modifier.weight(1f,true))
                IconButton(onClick = { /*scope.launch{state.open()}*/ }) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "")
                }

            }
        }
        ) {

        }
    }
}

////////////////////////////////////  LOGO  /////////////////////////////////////////

@Preview
@Composable
fun previewLogo(){
    Logo()
}

@Composable
fun Logo(){
    Box(modifier=Modifier/*.border(2.dp,color=Color.Black)*/.fillMaxSize(),contentAlignment = Alignment.TopCenter) {
        Image(painter = painterResource(id = R.drawable.scales), contentDescription = "",alignment = Alignment.TopCenter,
            modifier = Modifier
                .width(160.dp)
                .offset(y = 70.dp)
        )
    }


}

//////////////////////////////  THIS IS FOR THE MAIN SCREEN ////////////////////////////////////
@Composable
fun LogoMain(){
    Box(modifier=Modifier/*.border(2.dp,color=Color.Black)*/.fillMaxSize(),contentAlignment = Alignment.TopCenter) {
        Image(painter = painterResource(id = R.drawable.scales), contentDescription = "",alignment = Alignment.TopCenter,
            modifier = Modifier
                .width(130.dp)
                .offset(x = 61.dp, y = 50.dp)
        )
    }


}