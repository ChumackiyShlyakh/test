//package com.notyteam.bee.room
//
//import androidx.lifecycle.LiveData
//import androidx.annotation.WorkerThread
//import android.os.AsyncTask.execute
//import androidx.annotation.MainThread
//import androidx.annotation.NonNull
//import androidx.annotation.Nullable
//import androidx.databinding.adapters.NumberPickerBindingAdapter.setValue
//import androidx.lifecycle.MediatorLiveData
//
//
//abstract class NetworkBoundResource<ResultType, RequestType> @MainThread
//constructor(private val appExecutors: AppExecutors) {
//
//    private val result = MediatorLiveData<Resource<ResultType>>()
//
//    init {
//        result.setValue(Resource.loading(null))
//        val dbSource = loadFromDb()
//        result.addSource(dbSource) { data ->
//            result.removeSource(dbSource)
//            if (shouldFetch(data)) {
//                fetchFromNetwork(dbSource)
//            } else {
//                result.addSource(dbSource) { newData -> setValue(Resource.success(newData)) }
//            }
//        }
//    }
//
//    @MainThread
//    private fun setValue(newValue: Resource<ResultType>) {
//        if (!Objects.equals(result.value, newValue)) {
//            result.setValue(newValue)
//        }
//    }
//
//    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
//        val apiResponse = createCall()
//        // we re-attach dbSource as a new source, it will dispatch its latest value quickly
//        result.addSource(dbSource) { newData -> setValue(Resource.loading(newData)) } // appExecutors = 'this' is not available
//        //        response.errorMessage = Cannot find local variable 'response'
//        //        result = 'this' is not available
//        result.addSource(apiResponse) { //Cannot find local variable 'response'   'this' is not available
//                response ->
//            result.removeSource(apiResponse)
//            result.removeSource(dbSource)
//
//            if (response.isSuccessful()) {
//                appExecutors.getDiskIO().execute({
//                    saveCallResult(processResponse(response))
//                    appExecutors.getMainThread().execute({
//                        // we specially request a new live data,
//                        // otherwise we will get immediately last cached value,
//                        // which may not be updated with latest results received from network.
//                        result.addSource(
//                            loadFromDb()
//                        ) { newData -> setValue(Resource.success(newData)) }
//                    }
//                    )
//                })
//            } else {
//                onFetchFailed()
//                result.addSource(
//                    dbSource
//                ) { newData -> setValue(Resource.error(response.errorMessage, newData)) }
//            }
//        }
//    }
//
//    protected fun onFetchFailed() {}
//
//    fun asLiveData(): LiveData<Resource<ResultType>> {
//        return result
//    }
//
//    @WorkerThread
//    protected fun processResponse(response: ApiResponse<RequestType>): RequestType {
//        return response.body
//    }
//
//    @WorkerThread
//    protected abstract fun saveCallResult(@NonNull item: RequestType)
//
//    @MainThread
//    protected abstract fun shouldFetch(@Nullable data: ResultType): Boolean
//
//    @NonNull
//    @MainThread
//    protected abstract fun loadFromDb(): LiveData<ResultType>
//
//    @NonNull
//    @MainThread
//    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
//}
