package com.kme.kaltura.kmesdk.controller.room

import com.kme.kaltura.kmesdk.webrtc.view.KmeSurfaceRendererView

/**
 * An interface for desktop share actions
 */
interface IKmeDesktopShareModule {

    /**
     * Start listen desktop share events
     *
     * @param roomId id of a room
     * @param companyId id of a company
     */
    fun startListenDesktopShare(
        roomId: Long,
        companyId: Long,
        renderer: KmeSurfaceRendererView,
        callback: IKmeDesktopShareEvents
    )

    /**
     * Stop listen desktop share events
     */
    fun stopListenDesktopShare()

    /**
     * Desktop share events
     */
    interface IKmeDesktopShareEvents {

        /**
         * Triggered by administrator
         *
         * @param isActive indicates is desktop share currently active
         */
        fun onDesktopShareActive(isActive: Boolean)

        /**
         * Triggered by administrator
         *
         * @param isHd indicates that quality of video was changed
         */
        fun onDesktopShareQualityChanged(isHd: Boolean)
    }

}
