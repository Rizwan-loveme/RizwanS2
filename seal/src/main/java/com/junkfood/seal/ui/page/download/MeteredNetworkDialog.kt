package com.junkfood.seal.ui.page.download

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SignalCellularConnectedNoInternet4Bar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.junkfood.seal.R
import com.junkfood.seal.ui.component.BottomButtonShape
import com.junkfood.seal.ui.component.MiddleButtonShape
import com.junkfood.seal.ui.component.SealDialogButtonVariant
import com.junkfood.seal.ui.component.SealDialogVariant
import com.junkfood.seal.ui.component.TopButtonShape

@Composable
@Preview
fun MeteredNetworkDialog(
    onDismissRequest: () -> Unit = {},
    onAllowOnceConfirm: () -> Unit = {},
    onAllowAlwaysConfirm: () -> Unit = {},
) {
    SealDialogVariant(
        onDismissRequest = onDismissRequest,
        icon = {
            Icon(
                imageVector = Icons.Outlined.SignalCellularConnectedNoInternet4Bar,
                contentDescription = null,
            )
        },
        //        text = {
        //            Text(
        //                text = stringResource(id = R.string.sl_download_disabled_with_cellular),
        //                modifier = Modifier.padding(horizontal = 24.dp)
        //            )
        //        },
        title = { Text(text = stringResource(id = R.string.sl_download_with_cellular_request)) },
        buttons = {
            SealDialogButtonVariant(
                text = stringResource(id = R.string.sl_allow_always),
                shape = TopButtonShape,
            ) {
                onAllowAlwaysConfirm()
            }
            SealDialogButtonVariant(
                text = stringResource(id = R.string.sl_allow_once),
                shape = MiddleButtonShape,
            ) {
                onAllowOnceConfirm()
            }
            SealDialogButtonVariant(
                text = stringResource(id = R.string.sl_dont_allow),
                shape = BottomButtonShape,
            ) {
                onDismissRequest()
            }
        },
    )
}
