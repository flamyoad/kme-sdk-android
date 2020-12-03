package com.kme.kaltura.kmesdk.controller

import com.kme.kaltura.kmesdk.rest.KmeApiException
import com.kme.kaltura.kmesdk.rest.response.user.KmeGetUserInfoResponse
import com.kme.kaltura.kmesdk.rest.response.user.KmeUserInfoData
import com.kme.kaltura.kmesdk.ws.message.participant.KmeParticipant

interface IKmeUserController {

    fun getCurrentParticipant(): KmeParticipant?

    fun updateParticipant(participant: KmeParticipant?)

    fun isLoggedIn(): Boolean

    fun isAdminFor(companyId: Long): Boolean

    fun isModerator(): Boolean

    fun getUserInformation(
        success: (response: KmeGetUserInfoResponse) -> Unit,
        error: (exception: KmeApiException) -> Unit
    )

    fun getUserInformation(
        roomAlias: String,
        success: (response: KmeGetUserInfoResponse) -> Unit,
        error: (exception: KmeApiException) -> Unit
    )

    fun getCurrentUserInfo(): KmeUserInfoData?

    fun logout()

}
