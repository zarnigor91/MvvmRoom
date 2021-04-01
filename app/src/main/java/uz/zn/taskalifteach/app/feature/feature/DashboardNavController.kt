package uz.zn.taskalifteach.app.feature.feature

import android.util.Log

class DashboardNavController {

    private var eventListener: RouteEventListener? = null
    private var currentRouteItem = DashboardRouteItem.DASHBOARD_ITEM


    fun navigationUpdateTask(name: String, date: String, status: Boolean){
        Log.wtf("navCard", "navigateAddCardScreen called")
        eventListener?.onStartUpdateTask(name,date,status)

    }

    interface RouteEventListener{

        fun onStartUpdateTask(name: String, date: String, status: Boolean)
    }
}