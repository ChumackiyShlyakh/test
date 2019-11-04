package com.notyteam.bee.topics.google_map.fragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.notyteam.bee.room.PointsRepository
import com.notyteam.bee.room.RoomPointData
import com.google.android.gms.maps.model.CircleOptions
import com.notyteam.bee.R
import com.notyteam.bee.google_map_controls.GoogleMapNewEventFragment
import com.notyteam.bee.google_map_controls.GoogleMapNewObjectFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.app_bar_main.view.*
import kotlinx.android.synthetic.main.dialog_confirm.*


class GoogleMapsFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMapClickListener,
    GoogleMap.OnMarkerClickListener {

    val LOG_TAG: String = "myLogs";

    var latitude: String = ""
    var longitude: String = ""
    private lateinit var coordinates: LatLng

    override fun onMapClick(latLng: LatLng?) {
        coordinates = LatLng(latLng!!.latitude, latLng.longitude)
        this.latitude = latLng.latitude.toString()
        this.longitude = latLng.longitude.toString()
        googleMap.addMarker(MarkerOptions().position(coordinates).draggable(true).title("My Favorite City"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(coordinates))
        Log.d(LOG_TAG, "latitude longitude: " + latitude + ", " + longitude);
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var googleMap: GoogleMap
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var img_btn_map_point: ImageButton
    private lateinit var img_btn_map_circle: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_google_maps, container, false)

        coordinates = LatLng(0.0, 0.0)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        img_btn_map_point = view.findViewById(R.id.img_btn_map_point) as ImageButton
        img_btn_map_point.setOnClickListener { showDialog(this) }

        img_btn_map_circle = view.findViewById(R.id.img_btn_map_circle) as ImageButton
        img_btn_map_circle.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                GoogleMapNewEventFragment()
            )?.commit()
            (activity as AppCompatActivity).toolbar_main_drawer?.visibility = View.GONE
//            drawCircle(coordinates)
        }

//        window.statusBarColor = getResources().getColor(R.color.orange_light_transparent)
//        (activity as AppCompatActivity).setSupportActionBar(toolbar_main_drawer)

        Log.d(LOG_TAG, "onCreate latitude longitude: " + latitude + ", " + longitude);

        return view
    }

    private fun drawCircle(point: LatLng) {

        // Instantiating CircleOptions to draw a circle around the marker
        val circleOptions = CircleOptions()

        // Specifying the center of the circle
        circleOptions.center(point)

        // Radius of the circle
        circleOptions.radius(2000.0)

        // Border color of the circle
        circleOptions.strokeColor(Color.BLACK)

        // Fill color of the circle
        circleOptions.fillColor(0x30ff0000)

        // Border width of the circle
        circleOptions.strokeWidth(2f)

        // Adding the circle to the GoogleMap
        googleMap.addCircle(circleOptions)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        googleMap.setOnMapClickListener(this)
    }

    fun setUpMap() {
        googleMap.isMyLocationEnabled = true
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }
    }

    fun showDialog(activity: Fragment) {
        val dialog = Dialog(getActivity())
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_confirm)
        dialog.show()

        val window = dialog.getWindow()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )

        var btn_correctly_marker_no =
            dialog.btn_correctly_marker_no.findViewById<Button>(R.id.btn_correctly_marker_no)
        var btn_correctly_marker_yes =
            dialog.btn_correctly_marker_yes.findViewById<Button>(R.id.btn_correctly_marker_yes)

        btn_correctly_marker_no.setOnClickListener {
            //            var list: List<RoomPointData>? = null
//            Observable.fromCallable {
//            }
//            Thread(Runnable {
//                this.run {this@GoogleMapsFragment
//                list = PointsRepository(getActivity()!!.application).getAllRepos()
//            Log.d(LOG_TAG, "btn_correctly_marker_no: " + list?.size);
//                }
//            }).start()

            dialog.dismiss()
        }
        btn_correctly_marker_yes.setOnClickListener {

            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_main_activity,
                GoogleMapNewObjectFragment()
            )?.commit()

//            val destination = RoomPointData(coordinates.latitude, coordinates.longitude)
//
//            Thread(Runnable {
//                this.run {this@GoogleMapsFragment
//
//                PointsRepository(getActivity()!!.application).insert(destination)
//                }
//            }).start()
//
//            Observable.fromCallable {
//            }
//            PointsRepository(getActivity()!!.application).insert(destination)

            activity.app_bar_layout?.toolbar_main_drawer?.visibility = View.GONE
            dialog.dismiss()
        }
    }

//    map.setOnMapClickListener { latLng ->
//        val destination = Destination(System.nanoTime(), lat = latLng.latitude, long = latLng.longitude)
//
//        Log.d(TAG, destination.toString())
//        AppDatabase.getInstance(this).destinationDao().insertPoint(destination)
//        Log.d(TAG, AppDatabase.getInstance(this).destinationDao().getDestination().toString())
//    }

//    private val locationCallback = object : LocationCallback() {
//        override fun onLocationResult(userLocation: LocationResult?) {
//            val array = FloatArray(1)
//            val destination = AppDatabase.getInstance(appContext).destinationDao().getDestination()
//
//            Log.d(TAG, "Distance: ${array[0]} m\nlat: ${destination!!.latitude}, long: ${destination.longitude}")
//        }
//    }
}
