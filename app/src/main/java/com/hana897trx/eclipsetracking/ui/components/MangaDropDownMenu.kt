package com.hana897trx.eclipsetracking.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hana897trx.eclipsetracking.R

enum class MangaOption(
    val stringName: Int,
) {
    FAVORITE(R.string.manga_option_favorite),
    READING(R.string.manga_option_reading),
    COMPLETED(R.string.manga_option_completed),
    DROPPED(R.string.manga_option_dropped),
    ON_HOLD(R.string.manga_option_on_hold),
    PLANNED(R.string.manga_option_plan_to_read),
    DEFAULT(R.string.manga_option_choose_an_option),
}

@Composable
fun MangaDropDownMenu(
    modifier: Modifier = Modifier,
    dropDownValues: List<MangaOption>,
    dropDownState: Boolean = false,
    hideDropDown: () -> Unit,
    onSelectedOption: (MangaOption) -> Unit,
) {
    Surface(
        elevation = 4.dp,
    ) {
        DropdownMenu(
            modifier = modifier,
            expanded = dropDownState,
            onDismissRequest = hideDropDown,
        ) {
            for (item in dropDownValues) {
                DropdownMenuItem(
                    onClick = { onSelectedOption(item) }
                ) {
                    Text(
                        text = stringResource(id = item.stringName),
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun MangaDropDownMenuPreview() {
    val dropDownValues = listOf(
        MangaOption.FAVORITE,
        MangaOption.READING,
        MangaOption.COMPLETED,
        MangaOption.DROPPED,
        MangaOption.ON_HOLD,
        MangaOption.PLANNED,
    )

    val (dropDownState, setDropDownState) = remember { mutableStateOf(false) }
    val (selectedOption, setSelectedOption) = remember { mutableStateOf(MangaOption.DEFAULT) }

    Button(onClick = { setDropDownState(true) }) {
        Text(text = stringResource(id = selectedOption.stringName))
    }

    MangaDropDownMenu(
        dropDownState = dropDownState,
        dropDownValues = dropDownValues,
        hideDropDown = { setDropDownState(false) },
        onSelectedOption = {
            setDropDownState(false)
            setSelectedOption(it)
        },
    )
}