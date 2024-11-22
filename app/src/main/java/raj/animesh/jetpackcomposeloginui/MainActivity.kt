package raj.animesh.jetpackcomposeloginui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginUi()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginUi(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding->
        LazyColumn (modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = colorResource(id = R.color.blue))) {
            item {
                Image(painter = painterResource(id = R.drawable.top), contentDescription = null)
            }
            
            item { 
                Text(text = "Welcome\nBack",
                    modifier = Modifier.padding(start = 24.dp),
                    fontSize = 87.sp,
                    lineHeight = (87-8).sp,
                    color = colorResource(id = R.color.white),
                    fontFamily = FontFamily(
                         Font(R.font.freescript, FontWeight.Normal)
                    )
                )
            }
            item {
                var textEmail by rememberSaveable {
                    mutableStateOf("")
                }

                TextField(value = textEmail, onValueChange = {textEmail = it},
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 24.dp, top = 8.dp, end = 24.dp)
                        .background(
                            color = colorResource(id = R.color.blueWhite),
                            shape = RoundedCornerShape(100.dp)
                        ),
                    label = { Text(text = "email", color = colorResource(id = R.color.white))},
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )
                var textpassword by rememberSaveable {
                    mutableStateOf("")
                }
                TextField(value = textpassword, onValueChange = {textpassword = it},
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 24.dp, top = 8.dp, end = 24.dp)
                        .background(
                            color = colorResource(id = R.color.blueWhite),
                            shape = RoundedCornerShape(100.dp)
                        ),
                    label = { Text(text = "password", color = colorResource(id = R.color.white))},
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    )
                )
            }
            item {
                Text(text = "Forgot Password ?", fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.white)
                )
            }
            item {
                Row(modifier = Modifier.fillParentMaxWidth(), horizontalArrangement = Arrangement.Center)
                {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.orange),


                        ),
                        modifier = Modifier
                            .padding(top = 32.dp, bottom = 10.dp)
                            .width(165.dp)
                            .height(55.dp),
                        shape = RoundedCornerShape(100.dp),

                        ) {
                        Text(text = "Login",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }
            }
            item {
                Text(text = "New user ? Sign Up!", fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, bottom = 24.dp),
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.white)
                )
            }

        }

    }
}

@Preview
@Composable
fun LoginPreview() {
    LoginUi()
}