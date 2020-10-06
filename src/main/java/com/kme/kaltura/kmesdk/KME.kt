package com.kme.kaltura.kmesdk

import com.kme.kaltura.kmesdk.di.KmeKoinComponent
import com.kme.kaltura.kmesdk.rest.KmeApiException
import com.kme.kaltura.kmesdk.rest.controller.IKmeMetadataController
import com.kme.kaltura.kmesdk.rest.controller.IKmeRoomController
import com.kme.kaltura.kmesdk.rest.controller.IKmeSignInController
import com.kme.kaltura.kmesdk.rest.controller.IKmeUserController
import org.koin.core.inject

internal var isSDKInitialized = false

class KME : KmeKoinComponent {

    val signInController: IKmeSignInController by inject()
    val userController: IKmeUserController by inject()
    val roomController: IKmeRoomController by inject()

    private val metadataController: IKmeMetadataController by inject()

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
        success: () -> Unit,
        error: (exception: KmeApiException) -> Unit
    ) {
        if (isSDKInitialized) error(Exception("SDK already initialized!"))

        metadataController.fetchMetadata(success = {
            isSDKInitialized = true
            success()
        }, error = {
            error(it)
        })
    }

}
