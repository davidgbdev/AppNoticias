package com.gonzalez.blanchard.newsapp.domain.usecase

import com.gonzalez.blanchard.newsapp.BuildConfig
import com.gonzalez.blanchard.newsapp.data.repository.NewsRepository
import com.gonzalez.blanchard.newsapp.domain.model.NewsItem
import com.gonzalez.blanchard.newsapp.utils.BusinessException
import com.gonzalez.blanchard.newsapp.utils.parseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsFromApiUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    sealed class Result {
        data class Complete(val success: Boolean, val newsList: List<NewsItem>) : Result()
        data class Error(val exception: BusinessException) : Result()
    }

    suspend operator fun invoke(): Flow<Result> = flow {
        try {

            val news = repository.getTopNews(
                country = "us",
                apiKey = BuildConfig.NEWS_API_KEY
            )
            emit(Result.Complete(success = true, newsList = news))
        }catch (e: Throwable){
            val businessException = e.parseException()
            emit(Result.Error(businessException))
        }
    }

}