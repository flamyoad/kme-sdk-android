package com.kme.kaltura.kmesdk.rest.response.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KmeUserInfoData(
    @SerializedName("id") var id: Long? = null,
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("name") var fullName: String? = null,
    @SerializedName("lang") var lang: String? = null,
    @SerializedName("avatar") var avatar: String? = null,
    @SerializedName("userCompanies") var userCompanies: UserCompanies? = null
) : Parcelable {

    @Parcelize
    data class UserCompanies(
        @SerializedName("owner_company_id") var companyOwnerId: Long?,
        @SerializedName("companies") var companies: List<KmeUserCompany>?,
        @SerializedName("active_company_id") var activeCompanyId: Long?,
    ) : Parcelable

}
