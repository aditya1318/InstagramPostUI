package com.example.composeui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Divider
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class HomeScreen {


    @Composable
    fun Screen() {
        Box(Modifier.fillMaxSize()) {

            Column(modifier = Modifier.fillMaxSize()) {
                AppBar(userName = "_aditya18_", modifier = Modifier.height(56.dp))

                ProfilePicBar("_aditya18_", "Vadodara, Gujarat")

                PostImage(painter = painterResource(id = R.drawable.image))

                IconsRow(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 10.dp))

                LikesStatus(modifier = Modifier.padding(start = 12.dp))

                CaptionText(
                    "_aditya18_ ",
                    "Bro love....",
                    modifier = Modifier.padding(start = 12.dp, top = 5.dp, bottom = 5.dp)
                )

                ViewCommentText(modifier = Modifier.padding(start = 12.dp, bottom = 5.dp))
                PostTime(modifier = Modifier.padding(start = 12.dp))


            }
            BottomNavBar(modifier = Modifier.align(BottomCenter))

        }
    }

    @Composable
    fun AppBar(
        userName: String,
        modifier: Modifier = Modifier
    ) {
        Box(modifier = modifier.fillMaxWidth()) {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.aspectRatio(0.3f, matchHeightConstraintsFirst = true)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .align(
                        Center
                    )
            ) {
                Text(
                    text = userName,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = Color.LightGray,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Posts",
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1f.dp)
                    .align(BottomCenter),
                color = Color(0x51CCCCCC)
            )
        }
    }

    @Composable
    fun ProfilePicBar(userName: String, Location: String) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .height(46.dp),
            contentAlignment = Center,
        ) {
            Row() {

                CircularImage(painter = painterResource(id = R.drawable.profilepic))
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp), Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = userName,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.White
                    )


                    Text(
                        text = Location,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.padding(start = 2.dp))
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 10.dp),
                contentAlignment = CenterEnd
            ) {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "menu",
                    tint = Color.White,
                    modifier = Modifier.rotate(90f)
                )
            }
        }

    }

    @Composable
    fun CircularImage(painter: Painter, modifier: Modifier = Modifier) {
        Image(
            painter = painter,
            contentDescription = "ProfilePic",
            modifier = modifier
                .padding(6.dp)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .clip(CircleShape)
        )
    }


    @Composable
    fun PostImage(modifier: Modifier = Modifier, painter: Painter) {
        Image(
            painter = painter, contentDescription = "image", modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.625f)
                .background(Color.White),
            alignment = Center
        )
    }


    @Composable
    fun IconsRow(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(26.dp), contentAlignment = CenterStart
        ) {
            Row(Modifier.fillMaxWidth(0.25f), Arrangement.SpaceBetween) {
                InstaIcons(painter = painterResource(id = R.drawable.heart), imageVector = null)
                InstaIcons(imageVector = null, painter = painterResource(id = R.drawable.comment))
                InstaIcons(painter = painterResource(id = R.drawable.send), imageVector = null)
            }
            Box(Modifier.fillMaxSize(), contentAlignment = CenterEnd) {

                InstaIcons(
                    painter = painterResource(id = R.drawable.bookmark),
                    imageVector = null,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
    }


    @Composable
    fun InstaIcons(painter: Painter?, imageVector: ImageVector?, modifier: Modifier = Modifier) {
        if (painter != null) {
            Icon(painter, contentDescription = "icon", modifier.size(18.dp), tint = Color.White)
        } else {
            Icon(
                imageVector!!,
                contentDescription = "icon",
                modifier.size(18.dp),
                tint = Color.White
            )
        }
    }

    @Composable
    fun LikesStatus(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .height(16.dp)
                .fillMaxWidth(), contentAlignment = CenterStart
        ) {
            Row(
                Modifier
                    .fillMaxSize(), verticalAlignment = Alignment.CenterVertically
            ) {

                LikeCircularPic(
                    painterResource(id = R.drawable.bansi1),
                    modifier = Modifier
                        .size(15.dp)
                )
                LikeCircularPic(
                    painterResource(id = R.drawable.bansi2),
                    modifier = Modifier
                        .size(15.dp)
                        .offset((-5).dp)
                )
                LikeCircularPic(
                    painterResource(id = R.drawable.bansi3),
                    modifier = Modifier
                        .size(15.dp)
                        .offset((-10).dp)
                )

                LikedByText()
            }
        }
    }

    @Composable
    fun LikeCircularPic(painter: Painter, modifier: Modifier = Modifier) {
        Image(
            painter = painter, contentDescription = "Liked people", modifier = modifier.clip(
                CircleShape
            )
        )
    }

    @Composable
    fun LikedByText() {
        Text(
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 12.sp,
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    Color.White,
                    fontWeight = FontWeight.Bold, fontSize = 12.sp
                )
                append("Liked by ")
                pushStyle(boldStyle)
                append("NidhiPatel ")
                pop()
                append("and ")
                pushStyle(boldStyle)
                append("4 others")
            })
    }

    @Composable
    fun CaptionText(userName: String, caption: String, modifier: Modifier = Modifier) {
        Text(textAlign = TextAlign.Center,
            color = Color.White,
            modifier = modifier,
            fontSize = 12.sp, text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    Color.White,
                    fontWeight = FontWeight.Bold, fontSize = 13.sp
                )
                pushStyle(boldStyle)
                append(userName)
                pop()
                append(caption)
            })
    }

    @Composable
    fun ViewCommentText(modifier: Modifier = Modifier) {
        Text(
            text = "View all 1 comments",
            fontSize = 12.sp,
            color = Color(0xFFA9A9A9),
            modifier = modifier
        )
    }

    @Composable
    fun PostTime(modifier: Modifier = Modifier) {
        Text(text = "2 mins ago", fontSize = 12.sp, color = Color(0xFFA9A9A9), modifier = modifier)

    }

    @Composable
    fun BottomNavBar(modifier: Modifier = Modifier) {
        Box(modifier.fillMaxWidth()) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1f.dp)
                    .align(TopCenter), color = Color(0x51CCCCCC)
            )
            Row(
                modifier
                    .fillMaxWidth()
                    .height(46.dp),
                Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomMenuItem(imageVector = null, painter = painterResource(id = R.drawable.home))
                BottomMenuItem(
                    imageVector = null,
                    painter = painterResource(id = R.drawable.search)
                )
                BottomMenuItem(imageVector = null, painter = painterResource(id = R.drawable.reel))
                BottomMenuItem(imageVector = null, painter = painterResource(id = R.drawable.heart))
                Image(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(CircleShape),
                    painter = painterResource(
                        id = R.drawable.profilepic
                    ),

                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )


            }
        }
    }

    @Composable
    fun BottomMenuItem(
        painter: Painter?,
        imageVector: ImageVector?,
        modifier: Modifier = Modifier
    ) {
        if (painter != null) {
            Icon(
                painter,
                contentDescription = "icon",
                modifier.aspectRatio(0.5f, matchHeightConstraintsFirst = true),
                tint = Color.White
            )
        } else {
            Icon(
                imageVector!!,
                contentDescription = "icon",
                modifier.aspectRatio(0.5f, matchHeightConstraintsFirst = true),
                tint = Color.White
            )
        }
    }
}
