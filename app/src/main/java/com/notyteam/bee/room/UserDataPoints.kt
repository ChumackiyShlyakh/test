//package com.notyteam.bee.room
//
//import androidx.lifecycle.LiveData
//import android.app.Application
//import androidx.annotation.NonNull
//import androidx.annotation.Nullable
//
//
//public class UserDataPoints(application: Application) {
//
//    private val apiGit: ApiGit
//    private val roomDBRepository: RoomDBRepository
//    private val appExecutors: AppExecutors
//
//    init {
//
//    }
//
////    fun UserDataRepository(application: Application): ??? {
////        this.apiGit = ApiGitHubApplication.getRestClientInstance().getApiGit()
////        this.roomDBRepository = RoomDBRepository(application)
////        this.appExecutors = AppExecutors()
////    }
//
//    fun loadPoints(userOwner: String): LiveData<Resource<List<RoomPointData>>> {
//
//        return object :
//            NetworkBoundResource<List<RoomPointData>, List<RoomPointData>>(appExecutors) {
//
//            protected fun saveCallResult(@NonNull item: List<RoomPointData>) {
//                roomDBRepository.insert(item)
//            }
//
//            protected fun shouldFetch(@Nullable data: List<RoomPointData>?): Boolean {
//                return data == null || data.size == 0
//            }
//
//            @NonNull
//            protected fun loadFromDb(): LiveData<List<RoomPointData>> {
//                return roomDBRepository.getAllRepos()
//            }
//
//            @NonNull
//            protected fun createCall(): LiveData<ApiResponse<List<RoomPointData>>> {
//                return apiGit.getRepos(userOwner)
//            }
//        }.asLiveData()
//    }
//}