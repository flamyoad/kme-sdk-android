package com.kme.kaltura.kmesdk.webrtc.peerconnection.impl

import android.content.Context
import com.kme.kaltura.kmesdk.webrtc.peerconnection.IKmePeerConnectionEvents
import com.kme.kaltura.kmesdk.webrtc.view.KmeSurfaceRendererView
import org.webrtc.PeerConnection
import org.webrtc.VideoCapturer

/**
 * An implementation actions under WebRTC peer connection object
 */
class KmeScreenSharePeerConnectionImpl(
    context: Context,
    events: IKmePeerConnectionEvents
) : KmeBasePeerConnectionImpl(context, events) {

    init {
        isPublisher = true
        isScreenShare = true
    }

    override fun createPeerConnection(
        localRenderer: KmeSurfaceRendererView?,
        remoteRenderer: KmeSurfaceRendererView?,
        videoCapturer: VideoCapturer?,
        useDataChannel: Boolean,
        iceServers: MutableList<PeerConnection.IceServer>
    ) {
        super.createPeerConnection(
            localRenderer,
            remoteRenderer,
            videoCapturer,
            useDataChannel,
            iceServers
        )

        peerConnection?.let { peerConnection ->
            videoCapturer?.let {
                peerConnection.addTrack(createLocalVideoTrack(videoCapturer), videoStreamId)
                findVideoSender()
            }
        }

        events?.onPeerConnectionCreated()
    }

    override fun addLocalRenderer(renderer: KmeSurfaceRendererView) {
        localVideoTrack?.addSink(renderer)
    }

    override fun removeLocalRenderer(renderer: KmeSurfaceRendererView) {
        localVideoTrack?.removeSink(renderer)
    }

}
