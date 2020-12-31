package com.kme.kaltura.kmesdk

import android.content.Context
import com.kme.kaltura.kmesdk.controller.*
import com.kme.kaltura.kmesdk.controller.IKmeRoomNotesController
import com.kme.kaltura.kmesdk.di.KmeKoinComponent
import com.kme.kaltura.kmesdk.di.KmeKoinContext
import com.kme.kaltura.kmesdk.prefs.IKmePreferences
import com.kme.kaltura.kmesdk.prefs.KmePrefsKeys
import com.kme.kaltura.kmesdk.rest.KmeApiException
import org.koin.core.inject

class KME : KmeKoinComponent {

    val signInController: IKmeSignInController by inject()
    val userController: IKmeUserController by inject()
    val roomController: IKmeRoomController by inject()
    val roomNotesController: IKmeRoomNotesController by inject()
    val chatController: IKmeChatController by inject()
    val audioController: IKmeAudioController by inject()

    private val prefs: IKmePreferences by inject()
    private val metadataController: IKmeMetadataController by inject()

    var isSDKInitialized = false
        private set

    companion object {
        private lateinit var instance: KME
        fun getInstance(): KME {
            if (!::instance.isInitialized) {
                instance = KME()
            }
            return instance
        }
    }

    fun initSDK(
        context: Context,
        success: () -> Unit,
        error: (exception: KmeApiException) -> Unit
    ) {
        KmeKoinContext.init(context)

        metadataController.fetchMetadata(success = {
            isSDKInitialized = true

            if (roomController.isConnected()) {
                roomController.disconnect()
            }

            success()
        }, error = {
            error(it)
        })
    }

    fun getFilesUrl() = metadataController.getMetadata()?.filesUrl

    fun getCookies() = prefs.getString(KmePrefsKeys.COOKIE)

}
