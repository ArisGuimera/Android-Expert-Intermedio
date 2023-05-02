package com.aristidevs.horoscopapp.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aristidevs.horoscopapp.core.network.ErrorType
import com.aristidevs.horoscopapp.core.network.ResultType
import com.aristidevs.horoscopapp.data.network.model.HoroscopeResponse
import com.aristidevs.horoscopapp.domain.GetHoroscopeUseCase
import com.aristidevs.horoscopapp.domain.dto.HoroscopeDTO
import com.aristidevs.horoscopapp.domain.model.HoroscopeModel
import com.aristidevs.horoscopapp.ui.detail.model.DetailUIState
import com.aristidevs.horoscopapp.ui.detail.model.DetailUIState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getHoroscopeUseCase: GetHoroscopeUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow<DetailUIState>(Loading)
    val uiState: StateFlow<DetailUIState> = _uiState

    fun getHoroscope() {
        //Main = UI
        //IO = Room, Retrofit, etc
        //Default = Procesos largos
        val myJob: Job = viewModelScope.launch(Dispatchers.IO) {
            when (val response = getHoroscopeUseCase(HoroscopeDTO(sign = "aries"))) {
                is ResultType.Error -> {
                    Log.i("aristiCurso", "fail")
                    _uiState.value = Error("Error")
                }

                is ResultType.Success -> {
                    Log.i("aristiCurso", "success")
                    if (response.data != null) {
                        _uiState.value = Success(response.data)
                    }
                }
            }

//            withContext(Dispatchers.Default){
//
//            }

//            val response1 = async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) }
//            val response2 = async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) }
//            val response3 = async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) }
//           response2.await()
//
//            val deferreds = listOf(
//                async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) },
//                async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) },
//                async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) },
//                async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) },
//                async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) },
//                async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) },
//                async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) },
//                async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) },
//                async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) },
//                async { getHoroscopeUseCase(HoroscopeDTO(sign = "aries")) }
//            )
//
//            val a: List<ResultType<HoroscopeModel>> = deferreds.awaitAll()
        }
//        myJob.cancel()
    }

//    fun getHoroscope() {
//        viewModelScope.launch {
//            getHoroscopeUseCase(HoroscopeDTO(sign = "aries"))
//                .collect { result: ResultType<HoroscopeModel> ->
//                    when(result){
//                        is ResultType.Error -> {
////                            val error = when(result.errorType){
////                                ErrorType.BadRequest -> "Mensaje genérico"
////                                is ErrorType.ExceptionError -> "Mensaje genérico"
////                                ErrorType.Forbidden -> "Mensaje genérico"
////                                ErrorType.InternalServerError -> "Mensaje genérico"
////                                ErrorType.InvalidData -> "Mensaje genérico"
////                                is ErrorType.UncontrolledError -> "Mensaje genérico"
////                            }
//                            _uiState.value = Error("Error")
//                        }
//                        is ResultType.Success -> {
//                            _uiState.value = Success(result.data!!)
//                        }
//                    }
//                }
//        }
//    }


}