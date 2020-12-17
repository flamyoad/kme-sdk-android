package com.kme.kaltura.kmesdk.di

import com.kme.kaltura.kmesdk.controller.*
import com.kme.kaltura.kmesdk.controller.impl.*
import com.kme.kaltura.kmesdk.controller.impl.internal.KmeRoomSettingsControllerImpl
import com.kme.kaltura.kmesdk.controller.impl.internal.KmeWebSocketControllerImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val controllersModule = module {

    single<IKmeSignInController> { KmeSignInControllerImpl() }
    single<IKmeUserController> { KmeUserControllerImpl() }
    single<IKmeRoomController> { KmeRoomControllerImpl(androidContext()) }
    single<IKmeRoomNotesController> { KmeRoomNotesControllerImpl() }
    single<IKmeChatController> { KmeChatControllerImpl() }
    single<IKmeAudioController> { KmeAudioControllerImpl() }
    single<IKmeMetadataController> { KmeMetadataControllerImpl() }
    single<IKmeWebSocketController> { KmeWebSocketControllerImpl() }
    single<IKmeRoomSettingsController> { KmeRoomSettingsControllerImpl() }

}
