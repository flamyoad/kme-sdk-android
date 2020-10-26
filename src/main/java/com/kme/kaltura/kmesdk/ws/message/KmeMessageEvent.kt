package com.kme.kaltura.kmesdk.ws.message

import com.google.gson.annotations.SerializedName

enum class KmeMessageEvent(
    @SerializedName("name") val moduleName: String
) {

    /*
    * RoomInit
    * */

    @SerializedName("joinRoom", alternate = ["joinroom"])
    JOIN_ROOM("joinRoom"),

    @SerializedName("instructorIsOffLine", alternate = ["instructorisoffline"])
    INSTRUCTOR_IS_OFFLINE("instructorIsOffLine"),

    @SerializedName("anyInstructorsConnectedToRoom", alternate = ["anyinstructorsconnectedtoroom"])
    ANY_INSTRUCTORS_IS_CONNECTED_TO_ROOM("anyInstructorsConnectedToRoom"),

    @SerializedName("joinedRoom", alternate = ["joinedroom"])
    JOINED_ROOM("joinedRoom"),

    @SerializedName("closeWebSocket", alternate = ["closewebsocket"])
    CLOSE_WEB_SOCKET("closeWebSocket"),

    @SerializedName("roomState", alternate = ["roomstate"])
    ROOM_STATE("roomState"),

    @SerializedName("newUserJoined", alternate = ["newuserjoined"])
    NEW_USER_JOINED("newUserJoined"),

    @SerializedName("roomAvailableForParticipant", alternate = ["roomavailableforparticipant"])
    ROOM_AVAILABLE_FOR_PARTICIPANT("roomAvailableForParticipant"),

    @SerializedName("roomParticipantsLimitReached", alternate = ["roomparticipantslimitreached"])
    ROOM_PARTICIPANT_LIMIT_REACHED("roomParticipantsLimitReached"),

    /*
    * Banners
    * */

    @SerializedName("roomHasPassword", alternate = ["roomhaspassword"])
    ROOM_HAS_PASSWORD("roomHasPassword"),

    @SerializedName("sendRoomPassword", alternate = ["sendroompassword"])
    SEND_ROOM_PASSWORD("sendRoomPassword"),

    @SerializedName("roomPasswordStatusReceived", alternate = ["roompasswordstatusreceived"])
    ROOM_PASSWORD_STATUS_RECEIVED("roomPasswordStatusReceived"),


    /*
    * Room Participants
    * */

    @SerializedName("userMediaStateInit", alternate = ["usermediastateinit"])
    USER_MEDIA_STATE_INIT("userMediaStateInit"),

    @SerializedName("userMediaStateChanged", alternate = ["usermediastatechanged"])
    USER_MEDIA_STATE_CHANGED("userMediaStateChanged"),

    @SerializedName("changeUserFocusEvent", alternate = ["changeuserfocusevent"])
    CHANGE_USER_FOCUS_EVENT("changeUserFocusEvent"),

    /*
    * Streaming
    * */

    @SerializedName("userDisconnected", alternate = ["userdisconnected"])
    USER_DISCONNECTED("userDisconnected"),

    /*
    * Chat
    * */

    @SerializedName("loadConversations", alternate = ["loadconversations"])
    LOAD_CONVERSATIONS("loadConversations"),

    @SerializedName("loadMessages", alternate = ["loadmessages"])
    LOAD_MESSAGES("loadMessages"),

    @SerializedName("receiveSystemConversations", alternate = ["receivesystemconversations"])
    RECEIVE_CONVERSATIONS("receiveSystemConversations");

    override fun toString(): String {
        return moduleName.toLowerCase()
    }

}