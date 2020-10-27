package com.kme.kaltura.kmesdk.ws.message.chat

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.kme.kaltura.kmesdk.rest.response.user.KmeUserCompany
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KmeChatMessage(

    @SerializedName("id") val id: String? = null,
    @SerializedName("conversation_id") val conversationId: String? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("message_metadata") val metadata: String? = null,
    @SerializedName("timestamp") val timestamp: Double? = null,
    @SerializedName("user") val user: KmeUserCompany? = null

) : Parcelable
