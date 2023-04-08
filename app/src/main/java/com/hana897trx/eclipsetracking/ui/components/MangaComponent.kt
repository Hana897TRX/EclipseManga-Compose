package com.hana897trx.eclipsetracking.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hana897trx.eclipsetracking.R
import com.hana897trx.eclipsetracking.ui.theme.EclipseTrackingTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MangaComponent(
    onClick: () -> Unit = {},
    onLongPress: () -> Unit = {},
) {
    val dropDownValues = listOf(
        MangaOption.FAVORITE,
        MangaOption.READING,
        MangaOption.COMPLETED,
        MangaOption.DROPPED,
        MangaOption.ON_HOLD,
        MangaOption.PLANNED,
    )
    val (dropDownState, setDropDownState) = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .width(150.dp)
            .combinedClickable(
                onClick = onClick,
            )
            .padding(8.dp),
        backgroundColor = colorResource(id = R.color.black),
        shape = RoundedCornerShape(8.dp),
        elevation = 0.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_place_holder),
                contentDescription = stringResource(id = R.string.img_manga_cover_placeholder_description),
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9F)
                        .padding(start = 8.dp, bottom = 4.dp, top = 4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(id = R.string.manga_title_placeholder),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.white),
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 4.dp),
                        text = stringResource(id = R.string.manga_author_placeholder),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.gray_text),
                    )
                }
                Icon(
                    modifier = Modifier
                        .width(24.dp)
                        .padding(end = 4.dp)
                        .clickable {
                            setDropDownState(!dropDownState)
                        },
                    painter = painterResource(id = R.drawable.ic_menu_dropdown),
                    contentDescription = stringResource(id = R.string.drop_down_menu_placeholder),
                    tint = colorResource(id = R.color.white),
                )
                MangaDropDownMenu(
                    dropDownValues = dropDownValues,
                    dropDownState = dropDownState,
                    hideDropDown = { setDropDownState(false) },
                    onSelectedOption = {
                        setDropDownState(false)
                    },
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
)
@Composable
fun MangaComponentPreview() {
    EclipseTrackingTheme {
        MangaComponent()
    }
}