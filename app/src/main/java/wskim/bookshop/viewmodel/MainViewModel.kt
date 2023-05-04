package wskim.bookshop.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import wskim.bookshop.model.BookItem
import wskim.bookshop.utils.DetailViewState
import wskim.bookshop.utils.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.jvm.Throws


class MainViewModel : ViewModel() {

    private val _viewState = MutableStateFlow<ViewState>(ViewState.Loading)
    private val _detailViewState = MutableStateFlow<DetailViewState>(DetailViewState.Loading)

    val books = _viewState.asStateFlow()
    val bookDetails = _detailViewState.asStateFlow()

    // get all the data from the Book.json
    @Throws(Exception::class)
    fun getAllBooks(context: Context) = viewModelScope.launch {
        try {

            // read JSON File
            val myJson = context.assets.open("books.json").bufferedReader().use {
                it.readText()
            }

            // format JSON
            val gson = Gson()
            val listType = object : TypeToken<List<BookItem>>() {}.type
            val bookList: List<BookItem> = gson.fromJson(myJson, listType)
            _viewState.value = ViewState.Success(bookList)

        } catch (e: Exception){
            _viewState.value = ViewState.Error(e)
        }
    }


    // get book by ID
    fun getBookByID(context: Context, isbnNO:String) = viewModelScope.launch {
        try {

            // read JSON File
            val myJson = context.assets.open("books.json").bufferedReader().use {
                it.readText()
            }

            val gson = Gson()
            val listType = object : TypeToken<List<BookItem>>() {}.type
            val bookList: List<BookItem> = gson.fromJson(myJson, listType)

            // format JSON
            val filterBookList = bookList.first { it.isbn.contentEquals(isbnNO) }
            _detailViewState.value = DetailViewState.Success(filterBookList)

        } catch (e: Exception){
            _detailViewState.value = DetailViewState.Error(e)
        }
    }

}