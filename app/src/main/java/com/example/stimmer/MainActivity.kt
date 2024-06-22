package com.example.stimmer
/*
TPdkr 2024
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stimmer.ui.theme.StimmerTheme

/*
This is a simple app that i felt like making. Its meant to be a stress relief and nothing special
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StimmerTheme {
                StimmerComposition()
            }
        }
    }
}

@Composable
fun StimmerComposition() {
    val palette = listOf(
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.onBackground


    )
    // we compose the app
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text= stringResource(R.string.click_me), fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(20.dp))

        Row {
            MyButton(palette = palette)
            MyButton(palette = palette)
            MyButton(palette = palette)
        }
        Row {
            MyButton(palette = palette)
            MyButton(palette = palette)
            MyButton(palette = palette)
        }
        Row {
            MyButton(palette = palette)
            MyButton(palette = palette)
            MyButton(palette = palette)
        }

    }

}
// this is a button that we use here 9 times
@Composable
fun MyButton(palette: List<Color>) {
    // its main property is color
    var buttonColor by remember {
        mutableStateOf(palette.random())
    }
    // this is the button logic in compose
    ElevatedButton(
        onClick = { buttonColor = newColor(palette,buttonColor) },
        modifier = Modifier
            .size(100.dp)
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 20.dp),
    ) {

    }
}
// this function makes sure that the color changes
fun newColor(palette: List<Color>, currentColor: Color): Color =
    palette.filter { it != currentColor }.random()

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StimmerTheme {
        StimmerComposition()
    }
}
/*
MMMMMMMMMMMMMMMMMWNXXK00OO00KKXNMMMMMMMMMMMMMMMMMM
MMMMMMMMMMMMWKxolloddddddddddoolllx0NWMMMMMMMMMMMM
MMMMMMMMMNkcldOXNNNNWWWWWWWWWWWWWN0xocl0NMMMMMMMMM
MMMMMMWkc:xXNNWWWWWWWWWWWWWWWWWWWWWWWWKo;c0WMMMMMM
MMMMM0,'ONNWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW0;,OWMMMM
MMMWx.lXNWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWk.:XMMM
MMMx.dNWWWWWMMMMMMMMWWWWWWWWWWWWWWWWWWWWWWWWN,'KMM
MM0.lNWWWWMMWx:,,;oONMMWWWWWWWWMMMMMMMMWWWWWWW,'KM
MW:.XWWWWMMX. :k0'   :NWWWWWMMMNd;'';lOMWWWWWMX.cW
M0.dNWWWWMMl  lo'     lWWWWMMX;..cd'   ,NWWWWMM:.0
N:.KWWWWWWMd          dNWWWMMc  'kx.    xWWWWWMd.x
x'oWWWWWWWWWd.      .lNWWWWMMc          kWWWWMMl.x
No.dMWWWWWWWWWN0OOk0NNWWWWWWWNc.     .,xNWWWWMW..O
MNd';XMWWWWWWWWWWWWWWWWWWWWWWWWWX00KNNNNWWWWMMd :N
MMM0;.oWMWWWWWWWWWWWMWWMMMMMWWWWWWWWWWWWWWMMMx.,0M
MMMMWk,.dNMWWWWWWWWWMXollllxWWWWWWWWWWWWWMMK;.:KMM
MMMMMMNk,.oNMWWWWWWWWWWWWWWNWWWWWWWWWMMMNx,.;kWMMM
MMMMMMMMWO:.:OXWMMMMMMMMWWWMMMMMMWNKko:.  ,OWMMMMM
MMMMMMMMMMM0o...;:cloodddddddoolc::::;;;,.,lOXMMMM
MMMMMMMMMMMMX;.KNNNNNNNNNNNNNNNNNNNNNNNWWWNOl'lNMM
MMMMMMMMMMMM0''NNNWWWWWWWWWWWWWWWWWWWWWWWWWWW0.cNM
MMMMMMMMMMMMO';NWWWWWWWWWWWWWWWWWWWWWWWWWWWWWM:.OM
MMMMMMMMMMMMO':NWWWWWWMdkWWWWWWMMMMMMWWWWWWWMM:.xM
MMMMMMMMMMMMO',WWWWWWMK cNWWWWM0;:coclxWWWWWMW..OM
MMMMMMMMMMMMO,.NWWWWWM: cWWWWMW'kNNO  .WWWWWMo ;WM
MMMMMMMMMMMMN; 0WWWWMN. ,WWWWMk.XNWd ..NWWWMK..kMM
MMMMMMMMMMMMMo':WWWMMc ..XWWMW'.XMN' ..NWWMX..oMMM
MMMMMMMMMMMMMNc.c0Kk;..'.,WMMo ..:'.,..xMWk..oWMMM
MMMMMMMMMMMMMMWxl:::lxNNo.'c;.;O000XM0;.;'';kMMMMM
MMMMMMMMMMMMMMMMMMMMMMMMMXdddkWMMMMMMMMX0KXMMMMMMM
 */